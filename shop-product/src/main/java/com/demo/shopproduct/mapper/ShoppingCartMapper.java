package com.demo.shopproduct.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.demo.shopproduct.bean.ShoppingCartVO;
import com.demo.shopproduct.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/27 10:34
 * 4
 */
@Repository
@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {


    @Select("SELECT\n" +
            "\t\t\tc.cart_id AS cartId, \n" +
            "\t\t\tc.product_spec_number AS productSpecNumber, \n" +
            "\t\t\tc.user_id AS userId, \n" +
            "\t\t\tc.buy_number AS buyNumber,\n" +
            "\t\t\tc.check_status AS checkStatus,\n" +
            "\t\t\ts.spec,\n" +
            "\t\t\ts.stock,\n" +
            "\t\t\ts.sales_volume AS salesVolume,\n" +
            "\t\t\ts.price,\n" +
            "\t\t\ts.score,\n" +
            "\t\t\tp.name,\n" +
            "\t\t\tp.pic_img AS picImg,\n" +
            "\t\t\tp.product_number AS productNumber\n" +
            "    \tFROM\n" +
            "    \t\tos_shopping_cart c\n" +
            "    \tLEFT JOIN os_product_specification s ON c.product_spec_number = s.product_spec_number\n" +
            "    \tLEFT JOIN os_product p ON s.product_id = p.product_id\n" +
            "    \t<where>\n" +
            "    \t\t1=1\n" +
            "    \t\t<if test=\"userId != null\">\n" +
            "    \t\t\tAND c.user_id = #{userId}\n" +
            "    \t\t</if>\n" +
            "    \t\t<if test=\"checkStatus != null\">\n" +
            "    \t\t\tAND c.check_status = #{checkStatus}\n" +
            "    \t\t</if>")
    List<ShoppingCartVO> list(@Param("userId") long userId,@Param("checkStatus") Integer chackStatus);
}
