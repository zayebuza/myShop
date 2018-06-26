package com.demo.shoporder.common.utils;

import com.demo.shopcommon.util.RandomUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/26 18:38
 * 4
 */
public class OrderUtils {
    /** 订单编号后缀位数 */
    private static final int SUFFIX_NUMBER = 4;


    /**
     * 构造订单编号
     * @return 订单编号
     */
    public static Long getOrderNumber() {
        //获取当前时间戳
        String prefixNumber = Long.toString(System.currentTimeMillis());
        //获取订单后几位的随机值
        String suffixNumber = RandomUtils.number(SUFFIX_NUMBER);

        String userNumber = prefixNumber + suffixNumber;

        return Long.valueOf(userNumber);
    }

    /**
     * 获取支付金额
     * @param shipmentAmount  快递费
     * @param orderAmount   订单金额
     * @return 支付金额
     */
    public static BigDecimal getPayAmount(BigDecimal shipmentAmount, BigDecimal orderAmount) {
        if (shipmentAmount != null) {
            orderAmount.add(shipmentAmount);
        }
        return orderAmount;
    }
}
