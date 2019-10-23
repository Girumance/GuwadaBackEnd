package com.intern.guwada.Services;


import com.intern.guwada.Components.CustomerOrder;
import com.intern.guwada.Components.CustomerWrapper;
import com.intern.guwada.Components.MealOrderWrapper;
import com.intern.guwada.Components.OrderWrapper;
import com.intern.guwada.Domain.*;
import com.intern.guwada.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    KitechenService kitechenService;
    @Autowired
    AccountService accountService;

    public ArrayList<CustomerOrder> getOrdersByKitchenId(String kitchenid) {
        Sort sort =new Sort(Sort.Direction.DESC, "date");
        ArrayList<Order> order=orderRepository.getOrdersByKitchenId(kitchenid,sort);
        ArrayList<CustomerOrder> customerOrders=new ArrayList<>();
        for (Order order1:order){

            CustomerWrapper wrapper = new CustomerWrapper();
            Optional<Account> account = accountService.getAccountbyId(order1.getCustomerId());
            wrapper.setAttributes(account.get());
            CustomerOrder customerOrder=new CustomerOrder();
            customerOrder.setCustomer(wrapper);
            customerOrder.setOrderId(order1.getId());
            customerOrder.setDateTime(order1.getDate());
            customerOrders.add(customerOrder);

        }

        return customerOrders;
    }


    public ArrayList<Order> getOrdersByCustomerId(String customerId) {


        return orderRepository.getOrdersByCustomerId(customerId);
    }

    public ArrayList<MealOrder> getOrderById(String id) {
        Optional<Order> order = orderRepository.findById(id);
        OrderWrapper orderWrapper = new OrderWrapper();
        if (order.get()!=null) {

            CustomerWrapper wrapper = new CustomerWrapper();
            Optional<Account> account = accountService.getAccountbyId(order.get().getCustomerId());
            wrapper.setAttributes(account.get());


           // orderWrapper.setCustomerWrapper(wrapper);
            orderWrapper.setMealOrder(order.get().getMealorder());
           // orderWrapper.setDate(order.get().getDate());
            //orderWrapper.setOrderStatus(order.get().getOrderStatus());

            return order.get().getMealorder();

        }

        return null;
    }


    public boolean saveOrder(Order order) {

        return orderRepository.save(order) != null ? true : false;

    }


}
