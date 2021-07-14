package edu.miu.cs545.waaprojectwebstoreapi.service;

import edu.miu.cs545.waaprojectwebstoreapi.model.Order;

public class OderDtoAdapter {

    public static OrderDTO getDto(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderNumber(order.getOrderNumber());
        orderDTO.setUser(order.getUser());
        orderDTO.setOrderlist(order.getOrderlist());
        return orderDTO;
    }

    public static Order getOrder(OrderDTO orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setOrderNumber(orderDto.getOrderNumber());
        order.setUser(orderDto.getUser());
        order.setOrderlist(orderDto.getOrderlist());
        return order;
    }
}
