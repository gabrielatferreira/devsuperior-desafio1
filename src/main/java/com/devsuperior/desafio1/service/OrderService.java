package com.devsuperior.desafio1.service;

import com.devsuperior.desafio1.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {
        double discountValue = order.getBasic() * (order.getDiscount() / 100.0);
        return order.getBasic() - discountValue + shippingService.shipment(order);
    }
}
