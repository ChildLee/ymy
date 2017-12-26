package com.ymy.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 工具类
 */
public final class Util {
    //MD5
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    //<editor-fold> 字符工具类

    /**
     * 判断是不是空值
     *
     * @param value 需要判断的值
     * @return 空值为true, 否则false
     */
    public static Boolean isNull(String value) {
        if (null == value || value.isEmpty()) {
            return true;
        }
        return false;
    }


    //</editor-fold>

    //<editor-fold> 转换工具类

    /**
     * 除去Map集合中的空值
     *
     * @param params 参数集合
     */
    public static void mapFilter(Map<String, String> params) {
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (isNull(entry.getKey()) || isNull(entry.getValue())) {
                iterator.remove();
            }
        }
    }

    /**
     * 对参数按照key=value的格式，并按照参数名ASCII字典序排序
     *
     * @param params 参数集合
     * @return 拼接完返回字符串
     */
    public static String spliceParamsToString(Map<String, String> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        //微信要求按照参数名ASCII字典序排序
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = params.get(key);
            if (isNull(value)) {
                continue;
            }
            sb.append("&" + key + "=" + value);
        }
        return sb.substring(1);
    }
    //</editor-fold>

    //<editor-fold> 时间工具类

    /**
     * 获取无分隔的系统时间
     *
     * @return 无分隔格式的系统时间字符串
     */
    public static String getNoSpaceTime() {
        //获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(System.currentTimeMillis());
    }

    /**
     * 获取分隔的系统时间
     *
     * @return 无分隔格式的系统时间字符串
     */
    public static String getFormatTime() {
        //获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(System.currentTimeMillis());
    }

    /**
     * 获取当前时间往后多少分钟的时间
     *
     * @param minute 分钟
     * @return 当前时间往后延迟的时间
     */
    public static String getTimeOut(int minute) {
        //获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date().getTime() + (minute * 60 * 1000));
    }
    //</editor-fold>

    //<editor-fold> Web工具类

    /**
     * POST访问url并获取数据
     *
     * @param url   访问的链接
     * @param param 访问链接传递的参数
     * @return 字符串结果
     */
    public static String httpPost(String url, String param) {
        HttpURLConnection conn = null;
        OutputStream os = null;
        BufferedReader br = null;
        StringBuilder sb = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            //POST提交设置参数
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setUseCaches(false);  //不允许缓存
            conn.setConnectTimeout(60000);//连接超时 单位毫秒
            conn.setReadTimeout(60000);   //读取超时 单位毫秒
            //发送POST请求必须设置如下两行
            conn.setDoOutput(true);   //向httpUrlConnection输出
            conn.setDoInput(true);    //从httpUrlConnection读入

            //输出参数
            os = conn.getOutputStream();
            os.write(param.getBytes("utf-8"));
            os.flush();

            //获取接口返回数据
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String temp;
            sb = new StringBuilder();
            while (null != (temp = br.readLine())) {
                sb.append(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                br.close();
                conn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    //</editor-fold>

    //<editor-fold> 随机数工具类

    /**
     * 获取一定长度的随机数字
     *
     * @param length 指定数字长度
     * @return 一定长度的数字
     */
    public static String getRandomNumber(int length) {
        String str = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(str.charAt(random.nextInt(str.length())));
        }
        return sb.toString();
    }

    /**
     * 获取一定长度的随机字符串
     *
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(str.charAt(random.nextInt(str.length())));
        }
        return sb.toString();
    }


    //</editor-fold>

    //<editor-fold> MD5工具类

    /**
     * 字符串转MD5
     *
     * @param param 转换字符串
     * @return MD5
     */
    public static String getMD5(String param) {
        if (param == null) return null;
        char[] chars = new char[32];
        try {
            byte[] bytes = MessageDigest.getInstance("MD5").digest(param.getBytes("utf-8"));
            for (int i = 0; i < chars.length; i = i + 2) {
                byte b = bytes[i / 2];
                chars[i] = HEX_CHARS[(b >>> 0x4) & 0xf];
                chars[i + 1] = HEX_CHARS[b & 0xf];
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return String.valueOf(chars);
    }
    //</editor-fold>
}
