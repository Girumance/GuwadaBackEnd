package com.intern.guwada.Services;


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

    public ArrayList<Order> getOrdersByKitchenId(String kitchenid) {

        Sort sort =new Sort(Sort.Direction.DESC, "date");
        return orderRepository.getOrdersByKitchenId(kitchenid,sort);
    }


    public ArrayList<Order> getOrdersByCustomerId(String customerId) {


        return orderRepository.getOrdersByCustomerId(customerId);
    }

    public OrderWrapper getOrderById(String id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.get()!=null) {

            CustomerWrapper wrapper = new CustomerWrapper();
            Optional<Account> account = accountService.getAccountbyId(order.get().getCustomerId());
            wrapper.setAttributes(account.get());

            ArrayList<MealOrderWrapper> mealOrderWrappers = new ArrayList<>();

            if(order.get().getMealorder()!=null) {

                for (MealOrder mealOrder : order.get().getMealorder()) {

                    Menu menu = kitechenService.getMenuByTitle(order.get().getKitchenId(), mealOrder.getTitle());

                    MealOrderWrapper mealOrderWrapper = new MealOrderWrapper();
                    mealOrderWrapper.setMealOrder(mealOrder);
                    ;
                    mealOrderWrapper.setMenu(menu);

                    mealOrderWrappers.add(mealOrderWrapper);

                }

            }

            OrderWrapper orderWrapper = new OrderWrapper();
            orderWrapper.setCustomerWrapper(wrapper);
            orderWrapper.setMealOrderWrapper(mealOrderWrappers);
            orderWrapper.setDate(order.get().getDate());
            orderWrapper.setOrderStatus(order.get().getOrderStatus());


            return orderWrapper;

        }


        return null;
    }


    public boolean saveOrder(Order order) {

        return orderRepository.save(order) != null ? true : false;

    }


}
