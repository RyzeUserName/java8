package com.lft.java8.create;

import org.apache.commons.codec.binary.Base64;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

/**
 * 描述
 * @author Ryze
 * @date 2019-09-20 11:31HashMap
 */
public class Tsss {
    //    public static void main(String[] args) {
//        //  /^1\d{10}$/
//
////        String content = "1234567890";
////
////        String pattern = "^1\\d{10}$";
////
////        boolean isMatch = Pattern.matches(pattern, content);
////        System.out.println(isMatch);YXHD_APPID
////        int n = 100 - 1;
////        n |= n >>> 1;
////        n |= n >>> 2;
////        n |= n >>> 4;
////        n |= n >>> 8;
////        n |= n >>> 16;
////        int i = (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
////        System.out.println(i);
////        String substring = "123".substring(0, 2);
////        System.out.println(substring);
//        Integer i=0;
//        add(i);
//        System.out.println(i);
//    }
//
//    public static void add(Integer i) {
//        i++;
//    }
    public static void main(String[] args) {
//    String fjsjs = "fjsjs";
//    byte[] bytes = Base64.encodeBase64(fjsjs.getBytes());
//    byte[] bytes1 = Base64.decodeBase64(bytes);
//    System.out.println(new String(bytes1).equals(fjsjs));
//    LocalDateTime now = LocalDateTime.now();
//    System.out.println(now.getYear());
//    System.out.println(now.getMonth().getValue());
//    System.out.println(now.getDayOfMonth());
//    System.out.println(now.getHour());
//    System.out.println(now.getMinute());
//    System.out.println(now.getSecond());
//    byte[] bytes = longToBytes(1234567890);

//        System.out.println(String.format("%010d", 123));
        byte[] b={1,2,3,4,5,6};
        byte[] a=new byte[3];
        System.arraycopy(b,1,a,0,3);
        System.out.println(a[0]);
    }

    public static byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(x);
        return buffer.array();

}

    public String fillZero(long number) {
        String str = String.valueOf(number);
        int i = 10 - str.length();
        for (int j = 0; j < i; j++) {
            str = "0" + str;
        }
        return str;
    }
}
