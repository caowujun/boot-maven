package com.example.bootmaven.tools;

import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * @author robin
 * @date 2022年06月27日 8:36
 * @description
 */
public class Utils {


    public static String Encrypt(String str) {
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(str.getBytes());
            byte[] after = md5.digest();

            for (int i = 0; i < after.length; i++) {
                String hex = Integer.toHexString(0xff & after[i]);
                if (hex.length() == 1)
                    hex = "0" + hex;
                sb.append(hex);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }
    /**
     * @param url
     * @Author wujun.cao
     * @Description
     * @Date Created in 2021/03/11 16:22
     * @Return {@link String}
     **/
    public static String executeGet(String url) {

        try {
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
            http.setRequestMethod("GET"); // 必须是get方式请求
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            String message = new String(jsonBytes, "UTF-8");
//            JSONObject demoJson = JSONObject.fromObject(message);
            //openid,用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
            is.close();
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            throw null;
        }
    }


    /**
     * @param url
     * @Author wujun.cao
     * @Description
     * @Date Created in 2021/03/11 16:22
     * @Return {@link String}
     **/
    public static String executeGet1(String url) {

        try {
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
            http.setRequestMethod("GET"); // 必须是get方式请求
            http.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0");
            http.setRequestProperty("Content-Type", "plain/text; charset=UTF-8");

            http.setDoOutput(true);
            http.setDoInput(true);
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            String message = new String(jsonBytes, "UTF-8");
//            JSONObject demoJson = JSONObject.fromObject(message);
            //openid,用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
            is.close();
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            throw null;
        }
    }

    /**
     * @param blob
     * @Author wujun.cao
     * @Description
     * @Date Created in 2021/03/11 16:22
     * @Return {@link String}
     **/
    public static String blobToBase64(Blob blob) {
        String result = "";
        if (null != blob) {
            try {
                InputStream msgContent = blob.getBinaryStream();
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte[] buffer = new byte[100];
                int n = 0;
                while (-1 != (n = msgContent.read(buffer))) {
                    output.write(buffer, 0, n);
                }
                result = new BASE64Encoder().encode(output.toByteArray());
                output.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        } else {
            return null;
        }
    }

//    /**
//     * @param b
//     * @Author wujun.cao
//     * @Description
//     * @Date Created in 2021/03/11 16:23
//     * @Return {@link String}
//     **/
//    public static String byte2Base64StringFun(byte[] b) {
//        return Base64.encodeBase64String(b);
//    }

    /**
     * @param d
     * @Author wujun.cao
     * @Description 保留两位小数点
     * @Date Created in 2021/03/11 16:23
     * @Return {@link double}
     **/
    public static double fix2(double d) {
        return new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * @param str
     * @Author wujun.cao
     * @Description
     * @Date Created in 2021/03/11 16:23
     * @Return {@link boolean}
     **/
    public static boolean isIdCardNo(String str) {

        if (str == null)
            return false;

        int len = str.length();
        if (len != 15 && len != 18)
            return false;

        for (int i = 0; i < len; i++) {
            try {
                Integer.parseInt("" + str.charAt(i));
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    /**
     * @param idCardNo18
     * @Author wujun.cao
     * @Description
     * @Date Created in 2021/03/11 16:23
     * @Return {@link String}
     **/
    public static String from18to15(String idCardNo18) {

        if (!(isIdCardNo(idCardNo18) && idCardNo18.length() == 18))
            throw new IllegalArgumentException("身份证号参数格式不正确！");

        return idCardNo18.substring(0, 6) + idCardNo18.substring(8, 17);
    }
}
