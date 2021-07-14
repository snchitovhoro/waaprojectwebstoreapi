package edu.miu.cs545.waaprojectwebstoreapi.service;

import edu.miu.cs545.waaprojectwebstoreapi.model.Product;
import edu.miu.cs545.waaprojectwebstoreapi.model.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;

@Document
@CrossOrigin
public class OrderDTO {
    @Id
    private Long id;
    private long orderNumber;
    private User user;
    private Collection<Product> orderlist;

    public OrderDTO() {
    }

    public OrderDTO(Long id, long orderNumber, User user, Collection<Product> orderlist) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.user = user;
        this.orderlist = orderlist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Product> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(Collection<Product> orderlist) {
        this.orderlist = orderlist;
    }
}
