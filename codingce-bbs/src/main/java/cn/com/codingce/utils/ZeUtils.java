package cn.com.codingce.utils;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * <p>
 *  用户唯一UID
 * </p>
 *
 * @author Ma Xinze
 * @since 2021-1-1
 */
public class ZeUtils {

    static boolean printFlag = true;

    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static Timestamp getTime(){
        return new Timestamp(System.currentTimeMillis());
    }

    public static void print(String msg){
        if (printFlag){
            System.out.println("CODINGCE:=>"+msg);
        }
    }

}
