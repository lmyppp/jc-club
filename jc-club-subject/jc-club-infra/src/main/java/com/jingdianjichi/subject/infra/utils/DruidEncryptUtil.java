package com.jingdianjichi.subject.infra.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * 数据库密码加密
 */
public class DruidEncryptUtil {
    //公钥
    private static String publicKey;
    //私钥
    private static String privateKey;

    static {
        try {
            //通过druid的ConfigTools可以生成一个512位的加密对，返回值是string数组(加密对，两个值)
            String[] keyPair = ConfigTools.genKeyPair(512);
            //把生成的加密对分别赋值给私钥,公钥（顺序不能颠倒）
            privateKey = keyPair[0];
            System.out.println("privateKey:" + privateKey);
            publicKey = keyPair[1];
            System.out.println("publicKey:" + publicKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
    //加密方法
    public static String encrypt(String passwordText) throws Exception {
        return ConfigTools.encrypt(privateKey, passwordText);
    }
    //解密方法
    public static String decrypt(String encryptText) throws Exception {
        return ConfigTools.decrypt(publicKey, encryptText);
    }

    public static void main(String[] args) throws Exception {
        //加密需要加密的密码
        String encrypt = encrypt("123456");
        System.out.println("encrypt:" + encrypt);
        //解密
        String decrypt = decrypt(encrypt);
        System.out.println("decrypt:" + decrypt);
    }

}
