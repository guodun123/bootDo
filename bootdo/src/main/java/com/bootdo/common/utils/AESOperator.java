package com.bootdo.common.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class AESOperator {
    private static String prefix = "{加密}";

    private AESOperator() {
    }

 /*   public static void main(String[] args) throws Exception {
        String cSrc = "石牌街道天河区黄埔大道西601号暨南大学校本部真如苑1栋";
        String str = encryptBASE64(cSrc);
        System.out.println(str);
        System.out.println("加密后再：" + decryptBASE64(str));
        System.out.println("直接解密：" + decryptBASE64("{加密}55+z54mM6KGX6YGT5aSp5rKz5Yy66buE5Z+U5aSn6YGT6KW/NjAx5Y+35pqo5Y2X5aSn5a2m5qCh\n5pys6YOo55yf5aaC6IuRMeagiw=="));
    }*/

    public static String encryptBASE64(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException var4) {
            var4.printStackTrace();
        }

        if (b != null) {
            s = (new BASE64Encoder()).encode(b);
        }

        return prefix + s;
    }

    public static String decryptBASE64(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains(prefix)) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                str = str.replace(prefix, "");
                byte[] b = decoder.decodeBuffer(str);
                return new String(b);
            } catch (Exception e) {
                return str;
            }
        }
        return str;
    }


    public static String publicKeyString = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/PexusYXNgCXBMzOI5rEPiotQNJlt6jn3bTCO7JY/gfVN1/uWAmxS1e+7aqUVOCzvkq3D3lZuI8YvAVAirZxYoO6F/Jf2ywE/+cD3JAYyt3vp5hIhtblj0Xut9R/0RE9j181Esdw0TlFcEXFNpE0H/tgbkRnUMIQDzcwtgjVQmwIDAQAB";
    public static String privateKeyString = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAL897G6xhc2AJcEzM4jmsQ+Ki1A0mW3qOfdtMI7slj+B9U3X+5YCbFLV77tqpRU4LO+SrcPeVm4jxi8BUCKtnFig7oX8l/bLAT/5wPckBjK3e+nmEiG1uWPRe631H/RET2PXzUSx3DROUVwRcU2kTQf+2BuRGdQwhAPNzC2CNVCbAgMBAAECgYEAszatZQI5GF35g3ae2bENxjmX2f6gtW8lCSgqtBUjq7n2jg9TtbzplCrlsGT89Mii25NCAWZO6oHdy9jYJtc4xfdIazCRHEUbt/Lp04DBr43HhYHHLipb8hlbN05Z0qOnhGnJwjdO9vE670Th72qxMJgcnyu/GJ+pxqJIin6N2MkCQQD7wOn7hY6yzdaguON1w6ai+RvozAIFIJ2QD81svnrqnDWUXpbqMVKm+1A1ApuQR2srK92+sFhcxADFQXhWZrLfAkEAwne3fHu96F+CJZt+U2nzDaytx3dAmdl8gfNUVfjiu6KMdXO0svu78REOzxFaK0MeqWis4drOtBs5BICAFAq1xQJBAPh8CvaVdqmJfaSZmPjtqhYF5sQ6SGwjKyG8VzhUMiJLGJ9fVXnGQRxLxXjtH/qiY2bzHyVODYlSdKg93Lb7GuUCQDdJYdj6NRuDS7T1aAy+6mLQ3PcAaFVVB5jKXQe0IoHFzLj3lD/uYZg/iT5FaKU0B9uR7tSnKGz78FHfVopcISECQGtBSyKlW3QgQzoxeC8mg/3nB2YFVQ+501Ve8Bv4uFs5iJ8j7DykRjyhG5Kt8mxWlof21daF++zfNmNSURLNU3g=";
    //其中RSA非对称加密解密内容长度是有限制的，加密长度不超过117Byte，解密长度不超过128Byte
    public static int maxEncryptLength = 117;
    public static int maxDecryptLength = 128;
    private static String algorithm = "RSA"; //$NON-NLS-1$

    public static void main(String[] args) throws Exception {
    /*    // TODO Auto-generated method stub
        KeyPair keyPair=genKeyPair(1024);
        PublicKey publicKey=keyPair.getPublic();
        System.out.println("公钥："+new String(Base64.getEncoder().encode(publicKey.getEncoded())));

        //获取私钥，并以base64格式打印出来
        PrivateKey privateKey=keyPair.getPrivate();
        System.out.println("私钥："+new String(Base64.getEncoder().encode(privateKey.getEncoded())));*/

        //公钥加密
        String str = "宇宙银河系太阳系地球亚洲中国湖北省呜啊还能是阿三大苏打撒旦撒阿萨啊实打实的ifhsaidha扫i和爱说大话i扫i和哈怂诋毁哦啊稍后i少i婚纱多少ioh啊";

        System.out.println(str.getBytes().length);
        String encryptedBytes = encipher(str);
        System.out.println("加密后：" + new String(encryptedBytes));
        System.out.println(encryptedBytes.length());

        //私钥解密
        String decryptedBytes = decipher(encryptedBytes);
        System.out.println("解密后：" + new String(decryptedBytes));
    }

    //生成密钥对
    public static KeyPair genKeyPair(int keyLength) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        return keyPairGenerator.generateKeyPair();
    }


    //将base64编码后的公钥字符串转成PublicKey实例
    public static PublicKey getPublicKey() throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(publicKeyString.getBytes());
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    //将base64编码后的私钥字符串转成PrivateKey实例
    public static PrivateKey getPrivateKey() throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(privateKeyString.getBytes());
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    public static String encipher(String ciphertext) {
        if (StringUtils.isEmpty(ciphertext)){
            return ciphertext;
        }
        try {
            // 用公钥加密
            byte[] srcBytes = ciphertext.getBytes();
            PublicKey publicKey = getPublicKey();
            // Cipher负责完成加密或解密工作，基于RSA
            Cipher cipher = Cipher.getInstance("RSA");
            // 根据公钥，对Cipher对象进行初始化
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] resultBytes = null;

            if (maxEncryptLength > 0) {
                resultBytes = cipherDoFinal(cipher, srcBytes, maxEncryptLength); //分段加密
            } else {
                resultBytes = cipher.doFinal(srcBytes);
            }

            return  prefix + Base64.getEncoder().encodeToString(resultBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 分段大小
     *
     * @param cipher
     * @param srcBytes
     * @param segmentSize
     * @return
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws IOException
     */
    public static byte[] cipherDoFinal(Cipher cipher, byte[] srcBytes, int segmentSize)
            throws IllegalBlockSizeException, BadPaddingException, IOException {
        if (segmentSize <= 0)
            throw new RuntimeException("分段大小必须大于0");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int inputLen = srcBytes.length;
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > segmentSize) {
                cache = cipher.doFinal(srcBytes, offSet, segmentSize);
            } else {
                cache = cipher.doFinal(srcBytes, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * segmentSize;
        }
        byte[] data = out.toByteArray();
        out.close();
        return data;
    }

    /**
     * 分段解密
     *
     * @param contentBase64 密文
     * @return
     */
    public static String decipher(String contentBase64) {
        if (StringUtils.isEmpty(contentBase64) || !contentBase64.contains(prefix)){
            return contentBase64;
        }
        contentBase64 = contentBase64.replace(prefix,"");
        try {
            //获取私钥
            PrivateKey privateKey = getPrivateKey();
            // 用私钥解密
            byte[] srcBytes = Base64.getDecoder().decode(contentBase64);
            // Cipher负责完成加密或解密工作，基于RSA
            Cipher deCipher = Cipher.getInstance("RSA");
            // 根据公钥，对Cipher对象进行初始化
            deCipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decBytes = null;//deCipher.doFinal(srcBytes);
            if (maxDecryptLength > 0) {
                decBytes = cipherDoFinal(deCipher, srcBytes, maxDecryptLength); //分段加密
            } else {
                decBytes = deCipher.doFinal(srcBytes);
            }
            return new String(decBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
