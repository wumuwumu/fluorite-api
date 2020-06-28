package cn.sciento.fluorite.utils;

public class PasswordUtil {


    public static String generate(String password){
        String mdPassword = MD5Util.code("AppKey#"+password);
        if(mdPassword == null){
            throw new NullPointerException("密码加密失败");
        }
        return mdPassword.toLowerCase();
    }
}
