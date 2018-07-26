package cc.nefuer.market.common.util;

import com.qiniu.util.Auth;

/**
 * @author jimi花
 * @dare 2018/7/25
 */
public class QiNiuUtil {

    private static String accessKey;
    private static String secretKey;
    private static String bucket;

    public static String creatUpdateToken(String accessKey, String secretKey, String bucket) {

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        return upToken;

    }
}
