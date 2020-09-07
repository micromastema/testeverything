package com.zheng.testeverything.service;


import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @Description 雪花算法 SnowFlake
 * @Author iteach team
 * @Date 2020/4/7 14:49
 * @blame iteach team
 */
public class SnowFlake {

    private static final String MACHINE_ID_ENV = "MACHINE_ID";
    private static final String DATACENTER_ID_ENV = "DATACENTER";


    /**
     * 起始的时间戳
     */
    private final static long START_STAMP = 1564630701338L;

    /**
     * 每一部分占用的位数
     */
    private final static long SEQUENCE_BIT = 12; //序列号占用的位数
    private final static long MACHINE_BIT = 6;   //机器标识占用的位数
    private final static long DATA_CENTER_BIT = 6;//数据中心占用的位数

    /**
     * 每一部分的最大值
     */
    private final static long MAX_DATA_CENTER_NUM = -1L ^ (-1L << DATA_CENTER_BIT);
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTAMP_LEFT = DATA_CENTER_LEFT + DATA_CENTER_BIT;

    private long dataCenterId;  //数据中心
    private long machineId;     //机器标识
    private long sequence = 0L; //序列号
    private long lastStamp = -1L;//上一次时间戳

    private static SnowFlake idWorker;

    static {
        idWorker = new SnowFlake(getDataCenterId(), getMachineId());
    }


    private static final SnowFlake DEFAULT_GENERATOR = new SnowFlake(
            Optional.ofNullable(System.getenv(DATACENTER_ID_ENV)).map(Integer::parseInt)
                    .orElse((int) (System.currentTimeMillis() % (1 << DATA_CENTER_BIT))),
            Optional.ofNullable(System.getenv(MACHINE_ID_ENV)).map(Integer::parseInt)
                    .orElse((int) (System.currentTimeMillis() % (1 << DATA_CENTER_BIT))));

    public SnowFlake(long dataCenterId, long machineId) {
        if (dataCenterId > MAX_DATA_CENTER_NUM || dataCenterId < 0) {
            throw new IllegalArgumentException("dataCenterId can't be greater than MAX_DATA_CENTER_NUM or less than 0");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        this.dataCenterId = dataCenterId;
        this.machineId = machineId;
    }

    private static Long getMachineId() {
        try {
            String hostAddress = Inet4Address.getLocalHost().getHostAddress();
            int[] ints = StringUtils.toCodePoints(hostAddress);
            int sums = 0;
            for (int b : ints) {
                sums += b;
            }
            return (long) (sums % 32);
        } catch (UnknownHostException e) {
            // 如果获取失败，则使用随机数备用
            return RandomUtils.nextLong(0, 31);
        }
    }

    private static Long getDataCenterId() {
        int[] ints = StringUtils.toCodePoints("as-comment");
        int sums = 0;
        for (int i : ints) {
            sums += i;
        }
        return (long) (sums % 32);
    }

    public static long nextNumber() {
        return DEFAULT_GENERATOR.nextId();
    }

    /**
     * 产生下一个ID
     *
     * @return
     */
    public synchronized long nextId() {
        long currStamp = getNewStamp();
        if (currStamp < lastStamp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currStamp == lastStamp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currStamp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }

        lastStamp = currStamp;

        return (currStamp - START_STAMP) << TIMESTAMP_LEFT //时间戳部分
                | dataCenterId << DATA_CENTER_LEFT       //数据中心部分
                | machineId << MACHINE_LEFT             //机器标识部分
                | sequence;                             //序列号部分
    }

    private long getNextMill() {
        long mill = getNewStamp();
        while (mill <= lastStamp) {
            mill = getNewStamp();
        }
        return mill;
    }

    private long getNewStamp() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {

        long start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            System.out.println("当前生成的有序数字串：" + SnowFlake.nextNumber());
        }

        System.out.println("总共耗时：" + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));
    }

}
