package com.bootdo.common.utils;

import java.util.Date;
import java.util.Random;

public class CommonUtil {

    public static String getDocCode(String prefix, Integer orderType, String serialNumber) {
        StringBuilder zero = new StringBuilder();
        Integer num = serialNumber.length() - 4;
        orderType = orderType == null ? 0 : orderType;
        if (num < 0) {
            for (int i = 0; i < num * -1; i++) {
                zero.append("0");
            }
        }
        serialNumber = zero.append(serialNumber).toString();
        //获取时间如 180928
        String date = DateUtils.format(new Date(), "yyyyMMdd").substring(2, 8);
        //获取末尾两位随机数
        Random random = new Random();
        String ends = String.format("%02d", random.nextInt(99));//如果不足两位，前面补0
        return prefix + orderType + date + serialNumber + ends;
    }
}
