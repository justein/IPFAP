package cc.mrbird.febs.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: chenyanfeng
 * @Date: 2019-08-14
 * @Time: 下午3:05
 */
public class HeaderUtils {

    public static Map<String, String> getHeaders(String authorization) {

        // 设置请求参数 0###oo34J0ZRgatN5UBO8UQRwap6Ew_A###1565664617903###24ed6f7b1512aee63869b97552a2bd8f
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", authorization);
        headers.put("host", "api9.tianyancha.com");
        headers.put("Content-Type", "application/json");
        headers.put("X-AUTH-TOKEN", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTU4OTk5NDYxOSIsImlhdCI6MTU3NzY4NTE5NiwiZXhwIjoxNTgwMjc3MTk2fQ.2U6O2s5P0LF4-NklMj8iKMQiFmHkFZhNIEz7FYtOeb75D0Ny2zpFDd_ynA4vZiSDuwdDVoNbAdB3PQgep4FalA");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept", "*/*");
        headers.put("version", "TYC-XCX-WX");
        headers.put("Referer","https://servicewechat.com/wx9f2867fc22873452/31/page-frame.html");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36 MicroMessenger/7.0.4.501 NetType/WIFI MiniProgramEnv/Windows WindowsWechat");
        headers.put("Accept-Language", "zh-cn");
        return headers;
    }
}
