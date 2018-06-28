package com.demo.shoporder.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.demo.shopdubboapi.entity.order.OrderProduct;
import com.demo.shopdubboapi.entity.order.OrderShoppingCartVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/26 19:08
 * 4
 */
@Repository
@Mapper
public interface OrderProductMapper extends BaseMapper<OrderProduct> {

    /**
     * 插入订单明细
     * @param shoppingCartVOs  购物车选中商品
     * @param orderId   订单ID
     * @return
     */
    @Insert("INSERT INTO os_order_product(\n" +
            "\t    \torder_id, \n" +
            "\t    \tproduct_number, \n" +
            "\t    \tname, \n" +
            "\t    \tpic_img, \n" +
            "\t    \tproduct_spec_number, \n" +
            "\t    \tproduct_spec_name,\n" +
            "\t    \tprice, \n" +
            "\t    \tscore, \n" +
            "\t    \tbuy_number,\n" +
            "\t    \tproduct_score,\n" +
            "\t    \tproduct_amount\n" +
            "    \t)\n" +
            "    \tVALUES\n" +
            "    \t<foreach collection=\"shoppingCartVOs\" item=\"shoppingCart\" separator=\",\">\n" +
            "    \t\t(#{orderId},\n" +
            "    \t\t#{shoppingCart.productNumber},\n" +
            "    \t\t#{shoppingCart.name},\n" +
            "    \t\t#{shoppingCart.picImg},\n" +
            "    \t\t#{shoppingCart.productSpecNumber},\n" +
            "\t    \t#{shoppingCart.productSpecName},\n" +
            "    \t\t#{shoppingCart.price},\n" +
            "    \t\t#{shoppingCart.score},\n" +
            "    \t\t#{shoppingCart.buyNumber},\n" +
            "    \t\t#{shoppingCart.productScore},\n" +
            "    \t\t#{shoppingCart.productAmount})\n" +
            "    \t</foreach>")
    Integer insertProduct(@Param("shoppingCartVOs") List<OrderShoppingCartVO> shoppingCartVOs,
                          @Param("orderId") Long orderId);
}
