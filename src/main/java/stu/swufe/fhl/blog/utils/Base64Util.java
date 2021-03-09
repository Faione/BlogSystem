package stu.swufe.fhl.blog.utils;

import java.util.Base64;
import java.util.UUID;

public class Base64Util {
    private static final String SALT="fhl";
    private static int REPEAT = 2;

    public static byte[] encode(String str){
        String temp = str + "{"+ SALT +"}";
        byte data[] = temp.getBytes();

        for (int x = 0; x < REPEAT; x++){
            data = Base64.getEncoder().encode(data);
        }
        return data;
    }

    public static byte[] decode(byte[] data){
        for (int x = 0; x < REPEAT; x++){
            data = Base64.getDecoder().decode(data);
        }
        return data;
    }

    public static String encodeToStr(String str){
        return new String(Base64Util.encode(str));
    }

    public static String decodeToStr(byte[] data){
        return new String(Base64Util.decode(data)).replaceAll("\\{\\w+\\}", "");
    }

    public static void main(String[] args) {
//        System.out.println(Base64Util.encodeToStr("fanghaoleifanghaoleifanghaolei"));

    }
}
