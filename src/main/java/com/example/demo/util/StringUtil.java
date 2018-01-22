package com.example.demo.util;

import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import org.apache.commons.codec.Charsets;
import org.apache.commons.lang.StringUtils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lenovo on 2018/1/9.
 */
public class StringUtil {

    public static final String homeCodeChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String userNumberChar = "0123456789";

    public static boolean isEmpty(String content) {
        if (content == null || content.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String getRandomSMS() {
        int max = 9999;
        int min = 1000;
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return "" + s;
    }

    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String getRandomHomeCode() {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(homeCodeChar.charAt(random.nextInt(homeCodeChar.length())));
        }
        return sb.toString();
    }

    public static String getRandomUserNumber() {
        StringBuffer sb = new StringBuffer();
        sb.append("K");
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            sb.append(userNumberChar.charAt(random.nextInt(userNumberChar.length())));
        }
        return sb.toString();
    }

    /**
     * 加密
     *
     * @param content  需要加密的内容
     * @param password 加密密码
     * @return
     */
    public static String encrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return BaseEncoding.base64().encode(result); // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     *
     * @param content  待解密内容
     * @param password 解密密钥
     * @return
     */
    public static String decrypt(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return BaseEncoding.base64().encode(result); // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String md5(String content) {
        return Hashing.md5().newHasher().putString(content, Charsets.UTF_8).hash().toString().toLowerCase();
    }

    public static boolean checkPicFormat(String format) {
        if (format != null) {
            if ("png".equals(format.toLowerCase())) {
                return true;
            }
            if ("bmp".equals(format.toLowerCase())) {
                return true;
            }
            if ("jpeg".equals(format.toLowerCase())) {
                return true;
            }
            if ("jpg".equals(format.toLowerCase())) {
                return true;
            }
            if ("gif".equals(format.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPicFormat2(String format) {
        if (format != null) {
            if ("png".equals(format.toLowerCase())) {
                return true;
            }
            if ("jpeg".equals(format.toLowerCase())) {
                return true;
            }
            if ("jpg".equals(format.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkVoiceFormat(String format) {
        if (format != null) {
            if ("mp3".equals(format.toLowerCase())) {
                return true;
            }
            if ("wma".equals(format.toLowerCase())) {
                return true;
            }
            if ("wav".equals(format.toLowerCase())) {
                return true;
            }
            if ("amr".equals(format.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIsEmail(String email) {
        if (email == null) {
            return false;
        }
        String regex = "\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}";
        return email.matches(regex);
    }

    public static boolean checkIsUrl(String url) {
        if (url == null) {
            return false;
        }
        return url.startsWith("http://");
    }

    public static Timestamp getDayBegin() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 001);
        return new Timestamp(cal.getTimeInMillis());
    }

    public static Timestamp getDayBeginTimestamp() {
        Date date = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        Date date2 = new Date(date.getTime() - gc.get(gc.HOUR_OF_DAY) * 60 * 60
                * 1000 - gc.get(gc.MINUTE) * 60 * 1000 - gc.get(gc.SECOND)
                * 1000);
        return new Timestamp(date2.getTime());
    }

    public static String getErrorInfoFromException(Exception e) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return sw.toString();
        } catch (Exception e2) {
            return "bad getErrorInfoFromException";
        }
    }

    public static String transactSQLInjection(String str) {
        if (str != null) {
            return str.replaceAll("([';])+|(--)+", "");
        }
        return "";
    }

    public static int getDayOffset(long date1, long date2) {
        return getDayOffset(new Date(date1 * 1000), new Date(date2 * 1000));
    }

    public static int getDayOffset(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)    //闰年
                {
                    timeDistance += 366;
                } else {
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else {
            return day2 - day1;
        }
    }

    public static boolean checkArrayContainContent(String arr[], String content) {
        if (arr != null && content != null) {
            int count = arr.length;
            for (int i = 0; i < count; i++) {
                if (StringUtils.equals(content, arr[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获取日期年份
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static int getYear(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取日期月份
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static int getMonth(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        return (calendar.get(Calendar.MONTH) + 1);
    }

    /**
     * 获取日期号
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static int getDay(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取月份起始日期
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getMinMonthDate(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }

    /**
     * 获取月份起始日期时间戳
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static long getMinMonthDateTimestamp(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTimeInMillis() / 1000;
    }

    /**
     * 获取月份最后日期
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getMaxMonthDate(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }

    /**
     * 获取月份最后日期时间戳
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static long getMaxMonthDateTimestamp(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTimeInMillis() / 1000;
    }

    public static String getSha1(String str) {
        if (null == str || 0 == str.length()) {
            return null;
        }
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] buf = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String translateCityId(String cityId) {
        if (cityId != null && cityId.length() <= 7) {
            return cityId;
        }
        if (!isEmpty(cityId)) {
            switch (cityId) {
                case "0CAE6CE7-9612-4601-B88C-DEEBD4F3F783": // 广州公司
                    return "231";
                case "6586FD8F-0539-4517-9826-6ACDFB560BD1": // 苏州公司
                    return "112";
                case "083082D5-8C79-4D03-8A07-98EA0A0D6EFB": // 成都公司
                    return "270";
                case "893C88B2-9FAE-441B-AED1-5541E2750BBA": // 海南公司
                    return "351";
                case "31AA0673-3E34-42BD-A91D-2AB92D39E676": // 上海公司
                    return "107";
                case "9842CBEF-6B50-E511-9D75-0050569A93ED": // 佛山公司
                    return "236";
                case "1780F359-D082-4E09-9CF1-99618E0928EF": // 杭州公司
                    return "121";
                case "D0A9C136-F42B-4BBD-98DA-E5470C867143": // 南宁公司
                    return "252";
                case "406CBD60-9489-4E2F-AFA0-DD9FC94D1250": // 北京公司
                    return "35";
                case "3A0EB3FC-A846-40CB-AA29-D418ABD0F6D9": // 天津公司
                    return "36";
                case "04A4F614-CAE2-E611-80BF-005056896FC5": // 合肥公司
                    return "132";
                default:
                    return cityId;
            }
        }
        return cityId;
    }

}
