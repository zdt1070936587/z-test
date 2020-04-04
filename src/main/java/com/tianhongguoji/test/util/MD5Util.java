package com.tianhongguoji.test.util;


import java.security.MessageDigest;

public final class MD5Util {
    //******************BEGIN MD5********************
    private final static String[] hexDigits = {
            "0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"};


    /**
     * 将字节内容转换成字符串;
     *
     * @param b
     * @return
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }


    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }


    /**
     * MD5加密;
     *
     * @param str
     * @return
     */
    public static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] b = md.digest(str.getBytes());
            int i;
            StringBuffer buf = new StringBuffer();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.substring(8, 24);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * MD5进行加密;
     *
     * @param origin
     * @return
     * @throws Exception
     */
    public static String MD5Encode(String origin) throws Exception {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            return resultString;
        } catch (Exception ex) {
            throw ex;
        }
    }


    /**
     * 截取其中的16位;
     *
     * @param origin
     * @return
     * @throws Exception
     */
    public static String MD5Encode16Num(String origin) throws Exception {
        String resultString = null;
        resultString = MD5Encode(origin).substring(8, 24);
        return resultString;
    }
//******************END  MD5******************


    public static String getAAC002_B(String AAC002) {
        return AAC002.length() == 15 ? getAac002Of18(AAC002) : getAac002Of15(AAC002);
    }

    private static String getAac002Of15(String AAC002) {
        return AAC002.substring(0, 6) + AAC002.substring(8, 17);
    }


    private static String getAac002Of18(String AAC002) {
        return AAC002.substring(0, 6) + "19" + AAC002.substring(6) + getVerifyCode(AAC002);
    }


    private static String getVerifyCode(String strId) {
        String strVerifyCode = null;
        String strVerifyArray[] = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        if (strId.length() == 15)
            strId = strId.substring(0, 6) + "19" + strId.substring(6);
        if (strId.length() == 18)
            strId = strId.substring(0, 17);
        int n = 0;
        if (strId.length() == 17) {
            for (int i = 17; i > 0; i--) {
                n += (new Integer("" + strId.charAt(17 - i))).intValue() * (Math.pow(2, i) % 11);
            }
            n = n % 11;
            strVerifyCode = strVerifyArray[n];
        }
        return strVerifyCode;
    }
}

