package com.yangxiaochen.template.http.web;

import com.yangxiaochen.template.http.web.vo.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangxiaochen
 * @Date 2018-10-22
 */
@RestController
@RequestMapping("/web/order")
public class OrderController {

    @RequestMapping("sigle")
    public Order getOrder(@RequestParam("orderId") Long orderId) {
        Order order = new Order();
        order.setId(orderId);
        return order;
    }

}
