package com.zheng.testeverything.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo<T> {
    int pageNo;
    int pageSize;
    long totalNum;
    List<T> data;
}
