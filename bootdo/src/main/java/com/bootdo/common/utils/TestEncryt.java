package com.bootdo.common.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestEncryt {
    public static void main(String[] args) {
        try {
            //读取本都文件
            InputStream in = new FileInputStream("D:\\address.txt");
            BufferedReader b = new BufferedReader(new InputStreamReader(in));
            String d = null;
            StringBuilder sd = new StringBuilder();
            List<String> fileInfo = new ArrayList<>();
            while ((d = b.readLine()) != null) {
                sd.append(d);
                fileInfo.add(d);
                sd.append("\n");
            }
            System.out.println(Arrays.asList(fileInfo));
            System.out.println(fileInfo.size());

            // 写入Txt文件
            File file = new File("D:\\output.txt");
            file.delete();
            file.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            StringBuilder sd1 = new StringBuilder();
            System.out.println(System.currentTimeMillis());
            for (String str : fileInfo) {
                String decrypt = AESOperator.decipher(str);
                String encrypt = AESOperator.encipher(str);
                String decrypt2 = AESOperator.decipher(encrypt);
                sd1.append(decrypt).append("\t").append(encrypt).append("\t").append(decrypt2).append("\n");
            }
            System.out.println(System.currentTimeMillis());
            out.write(sd1.toString()); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件

            System.out.println("地址测试完毕");

            //读取本都文件
            InputStream in2 = new FileInputStream("D:\\phone.txt");
            BufferedReader b2 = new BufferedReader(new InputStreamReader(in2));
            String d2 = null;
            StringBuilder sd2 = new StringBuilder();
            List<String> fileInfo2 = new ArrayList<>();
            while ((d2 = b2.readLine()) != null) {
                sd2.append(d2);
                fileInfo2.add(d2);
                sd2.append("\n");
            }
            // 写入Txt文件
            File file2 = new File("D:\\output2.txt");
            file2.delete();
            file2.createNewFile(); // 创建新文件
            BufferedWriter out2 = new BufferedWriter(new FileWriter(file2));
            StringBuilder sdt = new StringBuilder();
            System.out.println(System.currentTimeMillis());
            for (String str : fileInfo2) {
                String decrypt = AESOperator.decipher(str);
                String encrypt = AESOperator.encipher(str);
                String decrypt2 = AESOperator.decipher(encrypt);
                sdt.append(decrypt).append("\t").append(encrypt).append("\t").append(decrypt2).append("\n");
            }

            System.out.println(System.currentTimeMillis());
            out2.write(sdt.toString()); // \r\n即为换行
            out2.close(); // 最后记得关闭文件

            System.out.println("电话测试完毕");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
