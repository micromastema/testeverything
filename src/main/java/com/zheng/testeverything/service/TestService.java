package com.zheng.testeverything.service;

import com.github.binarywang.wxpay.bean.entpay.EntPayRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.zheng.testeverything.config.MultiPay;
import org.springframework.beans.factory.annotation.Autowired;
import me.chanjar.weixin.common.bean.WxAccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengchentong on 2019-06-15
 */
@Service
public class TestService {

    @Autowired
    private MultiPay multiPay;

    public void test1() {
        WxPayService wxPayService = multiPay.getWxPayService(1 + "");
        EntPayRequest entPayRequest = new EntPayRequest();

        try {
            wxPayService.getEntPayService().entPay(entPayRequest);
        } catch (WxPayException e) {
            e.printStackTrace();
        }
    }
    @Autowired
    private WxMpService wxMpService;

    public void test() throws WxErrorException {
        wxMpService.switchover("ivykid");
        WxAccessToken wxAccessToken = new WxAccessToken();
        wxAccessToken.setAccessToken("28_roclLRzwkGy8l3wurifuJHCYpTWl_CJZYELA4Xq6BkGPGJLw-8IDrA6EAWBdlIc2jDLAQ9DCMe8oV7DFTzz-rINzPToe8Oe_qLcnuJtDddY6oHZBVL_s0xboouh6swkKY_9nqIxuo8i6U8mwHCOeAGAPKW");
        wxAccessToken.setExpiresIn(100000);
        wxMpService.getWxMpConfigStorage().updateAccessToken(wxAccessToken);
        List<String> openidList = getOpenidList();
        for (String openid : openidList) {
            WxMpUser wxMpUser = wxMpService.getUserService().userInfo("o7JOi0_6eJdQ44BWumOHNHs0XbTg");
            System.out.println(openid+"\t"+wxMpUser.getUnionId());
        }

    }

    private List<String> getOpenidList() {
        List<String> openidList = new ArrayList<>();
        openidList.add("o7JOi0_6eJdQ44BWumOHNHs0XbTg");
        openidList.add("o7JOi0_6hUuCEM-0N9zSBKsilrCU");
        openidList.add("o7JOi0_7pmdxntjOxMzpUlHofFZU");
        openidList.add("o7JOi0_CiuL62sgSMSELL7v4u3x0");
        openidList.add("o7JOi0_h-l7ouubNZ4VRnCp3ra_Q");
        openidList.add("o7JOi0_Sl7bZBCnmNt0qAJwESX5A");
        openidList.add("o7JOi0_T4h6aoaeJG8pJxIPxeYuA");
        openidList.add("o7JOi0_uT7HVFrEME7ynRhRpQdjs");
        openidList.add("o7JOi0_V8-8MYFVbaaD9yzdC-3BA");
        openidList.add("o7JOi0_Z2nZI9-CLTzdkqlJgK2Kc");
        openidList.add("o7JOi008P-dC2CXJK9nAVVJtKHBg");
        openidList.add("o7JOi00pImOnhxoP4HLcHcCcbQ-E");
        openidList.add("o7JOi00RzWnnvz4RybRj_zT2yOXE");
        openidList.add("o7JOi00uwA2Oyo0gMBF5Up3RSIoY");
        openidList.add("o7JOi0101Crgw1ktQ7t4IysNaGd4");
        openidList.add("o7JOi016lKs22EVh433o8bZfdMPo");
        openidList.add("o7JOi017pr5Ici7NutGfeQMFPJKo");
        openidList.add("o7JOi018b6OfPOpNIhiKvclqLc8g");
        openidList.add("o7JOi01BuUQypbkvY_4BJPbN4EjA");
        openidList.add("o7JOi01c2wCaK6ZuTF4b1huNA5-A");
        openidList.add("o7JOi01dyogiHyjNUtzI4szGIEzg");
        openidList.add("o7JOi01IaeP_BOtD-3I6EC4kdMIs");
        openidList.add("o7JOi01IpOOd8ugU1mKNUEbQB4bo");
        openidList.add("o7JOi01jst0AwIyXRet_GLWEpkUE");
        openidList.add("o7JOi01KkpqxW-aoe9Rija_C50Ao");
        openidList.add("o7JOi01LMubSaY6JkZolJuB4YSfE");
        openidList.add("o7JOi01MN0UUAJJ0ZMN6OEpnDNXA");
        openidList.add("o7JOi01N6iDx1S-ebWOJoQOhKTFg");
        openidList.add("o7JOi01OCSpoSJLxklvZX1GvFtHo");
        openidList.add("o7JOi01OymgXQbnlVMejx0HQeDG4");
        openidList.add("o7JOi01t9-CvYjHb0aHVnMlHf-SI");
        openidList.add("o7JOi01u3xlR2_vdix2YApdzcLXI");
        openidList.add("o7JOi01xMHFx-50TkB7uljYOegYE");
        openidList.add("o7JOi029qEhEXCiUwi0YDlPlEzWA");
        openidList.add("o7JOi02cXnR7A_v4VB5zT6Sb_G3Y");
        openidList.add("o7JOi02doYCu0bJFKjn93cu8uQcc");
        openidList.add("o7JOi02f0fwUuezXmaXefOUZFt2E");
        openidList.add("o7JOi02Hj-Ef9MTQKM7YqpfgwS60");
        openidList.add("o7JOi02lXEuXaL694fW2jsGZwiFM");
        openidList.add("o7JOi02M6UnBudEtkCGVJuhnEJnM");
        openidList.add("o7JOi02STHQkGo8OS6GpQy9iNvtU");
        openidList.add("o7JOi02tPDpNWFrOM7-eIhUka0w8");
        openidList.add("o7JOi02TR5vz5XISH_o0fgWIx3B8");
        openidList.add("o7JOi02Xli34Y_Lr6akW_oRZm7Os");
        openidList.add("o7JOi02ydv38geR-avM_OB37BEe0");
        openidList.add("o7JOi02zfb0-Jvg5gUAlHIoaBxaM");
        openidList.add("o7JOi03_egAqjjI-D3IKzeFYRXsQ");
        openidList.add("o7JOi033CSQIQ1O2X0CB_2YQENpc");
        openidList.add("o7JOi034V4aYJVYefPVGKgG4KbWs");
        openidList.add("o7JOi037bem_pXgvYfgkXQNcgpBk");
        openidList.add("o7JOi0396rs50543CUkPpcNb6qJ4");
        openidList.add("o7JOi03BYoWLCmn2nYCqaRgkPQWI");
        openidList.add("o7JOi03cYzYhoaUB5nQ86o789TKw");
        openidList.add("o7JOi03f-OCYQ6Co8th3WcyILJL0");
        openidList.add("o7JOi03JEQO2J-bCM4RJKMXBdbos");
        openidList.add("o7JOi03Lc7X6KmrdG-eL6C8GSMB4");
        openidList.add("o7JOi03qm0uziHYbVq0IQiRGsjeg");
        openidList.add("o7JOi03qwYCkoBk4scbqv44bS_Gw");
        openidList.add("o7JOi0-3U2a49qC2nsiq8kUYu22k");
        openidList.add("o7JOi03uwd6XS7JGwGC0ij7U07NY");
        openidList.add("o7JOi03YtEj3A2pNi7ajZnsKslI0");
        openidList.add("o7JOi043aPJ9xqoG2j-jtGRTNp2c");
        openidList.add("o7JOi045URfd04qN2S_nBRpR20YI");
        openidList.add("o7JOi047xLsuaME7QN-6XcitqzeY");
        openidList.add("o7JOi048duG0redwKiKJk-NliRVs");
        openidList.add("o7JOi04emich8f25EIcWK4Fdx4aI");
        openidList.add("o7JOi04G1foSPiqs3oNNiWJCKMd4");
        openidList.add("o7JOi04GgUcil_69gokB8UzptVfs");
        openidList.add("o7JOi04p4LxwoLERV02gDzKZpBE4");
        openidList.add("o7JOi04rriuvlwgPiQJ8Ox69Xsn4");
        openidList.add("o7JOi04t-mWt6VpHQgzgk_BPv5gQ");
        openidList.add("o7JOi04v_vbNquTBUAX7olJ0IyUs");
        openidList.add("o7JOi04ZuSNqpk5WNYrMcM-3M8nU");
        openidList.add("o7JOi05AfAeIby31Khz32ICFb6Vc");
        openidList.add("o7JOi05gMY9z9Y718uCJgVNqGkdw");
        openidList.add("o7JOi05JguzE-B1RQY5OJZOJR6Wk");
        openidList.add("o7JOi05JRUbBFBT3JFwH92rrqbzs");
        openidList.add("o7JOi05l6ppVDcVJKd7-X-D5YTSE");
        openidList.add("o7JOi05lsJGd33H5dBI3EehMrQxo");
        openidList.add("o7JOi05M1_iD_nET6ZV34FcLrlYc");
        openidList.add("o7JOi05Mi4ORDr3na9LfemDT2-iY");
        openidList.add("o7JOi05nMZRWeU5K0MnoF5hahbgk");
        openidList.add("o7JOi064ou-MRFWW4cGeDNRUpPZc");
        openidList.add("o7JOi064RluevjHdvHAb1yewhu9E");
        openidList.add("o7JOi067PfZ7yjCUjyB3d1puGm9M");
        openidList.add("o7JOi06cuOurJZ0-1yLgXsE-70Nw");
        openidList.add("o7JOi06EE-nnKx1TfsHwycZyvql0");
        openidList.add("o7JOi06GrAEKmxRxKULWLS-pzDbw");
        openidList.add("o7JOi06J4c_mYw92Z7K1_9YbBeIU");
        openidList.add("o7JOi06l66_nFjEBjZF7S0stE7Zo");
        openidList.add("o7JOi06pv8lhNmIeElQIVrMrjZU8");
        openidList.add("o7JOi06r7p4uOivYD3qDg-wT7MYY");
        openidList.add("o7JOi06-WfMLaDvxQa4pL1fPYw2I");
        openidList.add("o7JOi06xZdV3jxP74oZ0Ld-LL0ug");
        openidList.add("o7JOi06z7Uzp9pykHtihjz1WInxg");
        openidList.add("o7JOi06zxWurjxDkX9ADEcJG04p0");
        openidList.add("o7JOi073XWxw4TZqg_BgvHjHohWs");
        openidList.add("o7JOi07GCsjfrN1EQTM5xtoi430Q");
        openidList.add("o7JOi07lNHXzf01aX3Y4C9qkHub4");
        openidList.add("o7JOi07Lon-o7pM1oLf2dg950R2g");
        openidList.add("o7JOi07NR95AtvzI2_n7P_uLYj2I");
        openidList.add("o7JOi07PVOxYnoZIaudKj_qIlkZI");
        openidList.add("o7JOi07pxR_B9KFzaMr47xg5O2oQ");
        openidList.add("o7JOi07r0V63uhDp9mYNw76hl-oY");
        openidList.add("o7JOi07um5CkZcofQlix19DB8AQA");
        openidList.add("o7JOi07VVnDG3uPzqTfUY4GlruCc");
        openidList.add("o7JOi07yX9DGTKHOb-qUWCDfqGBY");
        openidList.add("o7JOi082mu9q5joyHbwBEdfhtTk4");
        openidList.add("o7JOi083ynBKZi8NPZ7zpvyUj1kw");
        openidList.add("o7JOi083yoHrrSYeMcCyVMepEFhA");
        openidList.add("o7JOi085zTZL2s-kpI096MjCKUfY");
        openidList.add("o7JOi08bv_dSUylEjKJ4DYL3pTK4");
        openidList.add("o7JOi08gK8h7XusWWTMnLQjGW7Rs");
        openidList.add("o7JOi08l6SbgtboyKHEUflOHi_Hw");
        openidList.add("o7JOi08ncs8M0jy1WQIgqrKqxAq4");
        openidList.add("o7JOi08RAtUdO3p2sev1gFIVqHWQ");
        openidList.add("o7JOi08uPiyGGtzt8Ahy_OxSAgdc");
        openidList.add("o7JOi092fXTFk-rLhDRJEsPhWEyk");
        openidList.add("o7JOi097o4OnnHTd2N2iWZhZ2G_o");
        openidList.add("o7JOi09ANwCQ5kAgtzUz_TUuMNvw");
        openidList.add("o7JOi09EV4edJloeWD7WnjWZjuaA");
        openidList.add("o7JOi09g0gidU5Hzc3hqdLDkZFV4");
        openidList.add("o7JOi09HDFzGKrCpgIy74wQXNOZM");
        openidList.add("o7JOi09KORK4lUnyVTZXvMImpbrs");
        openidList.add("o7JOi09PwUWAz7Rvl8xL-7JLcLtU");
        openidList.add("o7JOi09Q7C7uMn1xeTFhiAcQsZGE");
        openidList.add("o7JOi09Vl5recZvsV0a1yjo9R2tA");
        openidList.add("o7JOi09Z5-wP5UXnbxHJffNt4E-k");
        openidList.add("o7JOi0-BtjG5-gsuW6TQ8XDeQF1s");
        openidList.add("o7JOi0-HWn_FXjn2fufGmx6G79Sw");
        openidList.add("o7JOi0-kkI8fdkJ9CJgIOv4UyxX4");
        openidList.add("o7JOi0-MzGLtQTlSvSYC-vE50fEo");
        openidList.add("o7JOi0-tZwviRgbCWdQO0WqOMrnY");
        openidList.add("o7JOi0wBvETNjJwd8UCKjDFfGy5s");
        openidList.add("o7JOi0wclM-C9y0vom8xXhq7CGTU");
        openidList.add("o7JOi0wdgk6MM5WpnE9ThrAwQIXk");
        openidList.add("o7JOi0wHZy5gc5ezxOSpuVQdJKUQ");
        openidList.add("o7JOi0wiPH2CZ1ojxqeR-m-IR4VA");
        openidList.add("o7JOi0wLuzTyLUikGu4_xT54cXpI");
        openidList.add("o7JOi0wOWqY0cUiAYm6baSSUHt30");
        openidList.add("o7JOi0wrbOaPw2T959p1M-2fDatE");
        openidList.add("o7JOi0wxJl3iVso60PSe_WYSMhVQ");
        openidList.add("o7JOi0x8MBnm76v1YaRrrtsBHg_U");
        openidList.add("o7JOi0xBO3M67HtN0-NawCaFioP4");
        openidList.add("o7JOi0xeS8r9nfgUvbMcTd8KEYKE");
        openidList.add("o7JOi0xOfmT2Kft6r2aOjOGTjZQI");
        openidList.add("o7JOi0xQRco3sk_J6z_sB96B6qsA");
        openidList.add("o7JOi0xrM_bje-1j9zsnazCMjvLk");
        openidList.add("o7JOi0xtSX7t7syjQFg8yhRBEzMU");
        openidList.add("o7JOi0xuE6B6d5ev6o3e9I739V2Y");
        openidList.add("o7JOi0xvvuvZ40-FjBHAVDZ6p5Hc");
        openidList.add("o7JOi0-xW3kuHj_rVxlbaeECNsko");
        openidList.add("o7JOi0y8b7P-D7i0uHStU0AMXTFY");
        openidList.add("o7JOi0yboS21rnhg921lDMfvc3tk");
        openidList.add("o7JOi0yBYOQTPr1zo16cqwRNdMUE");
        openidList.add("o7JOi0ycrlnLojYeZ6-mG9EU9NyQ");
        openidList.add("o7JOi0ygjAAO0DokytR59vfqC1Ao");
        openidList.add("o7JOi0yguy-2fbynbN4UbIwa34fA");
        openidList.add("o7JOi0ygxc_i4SbcdPEiXrEKLH9o");
        openidList.add("o7JOi0yIssvb8GSMup7dWtQAP1t4");
        openidList.add("o7JOi0ykba0IlOUJea34lWn-mh9Q");
        openidList.add("o7JOi0yLG1jKs2IsrflNtxvbBaLs");
        openidList.add("o7JOi0ynuf3E_NxhMcKS_xftnBWU");
        openidList.add("o7JOi0ypqIwDohBSNityL6dXUwTc");
        openidList.add("o7JOi0z6Sv43-GIZ3_uIBv7Lv294");
        openidList.add("o7JOi0zcSXvHGklZHsKXfkcrzrcw");
        openidList.add("o7JOi0zDewgs-KTJGLsX64Ivwlxw");
        openidList.add("o7JOi0-Zdkrw2z8AcE7SytkeXmY8");
        openidList.add("o7JOi0zEtpByhg8sTEmmxF9VtZos");
        openidList.add("o7JOi0zfrXvmpF9lc_s6E77vn478");
        openidList.add("o7JOi0zFyZrzAiPCe3jn6kes1hQg");
        openidList.add("o7JOi0z-Gs7KzGuC35T7Bih-_tsI");
        openidList.add("o7JOi0zNpz5OJpMn_MH6NFD6kPcw");
        openidList.add("o7JOi0zqabf9xJb8kZQKyaIjhZjU");
        openidList.add("o7JOi0zqol64q_rOLYmlPE6m9qiA");
        openidList.add("o7JOi0zs0AVXhzVtqGXKwVnFiUMA");
        openidList.add("o7JOi0zTksKiEWTCifs7ZoZNnAN4");
        openidList.add("o7JOi0zwwuVlW_2eH0f9LaVvjVQ4");
        openidList.add("o7JOi0zyHsECCgJpWutGlTj3rIQs");
        return openidList;
    }
}
