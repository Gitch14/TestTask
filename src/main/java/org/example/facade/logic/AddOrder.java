package org.example.facade.logic;

import org.example.facade.dto.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class AddOrder {
    static Logger logger = Logger.getLogger(Function.class.getName());
    Function function = new Function(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());

    public AddOrder() throws IOException {
    }

    public void addOrder(Order order) throws IOException {
        if (order.getType().equals("bid") || order.getType().equals("best_bid")) {
            function.addBidOrder(order);
            logger.info("bid add to list or request to best_bid");
        } else if (order.getType().equals("ask") || order.getType().equals("best_ask")) {
            function.addAskOrder(order);
            logger.info("ask add to list or request to best_ask");
        }else if (order.getType().equals("buy")) {
            function.addBuyOrder(order);
            logger.info("buy request add to list");
        } else if (order.getType().equals("sell")) {
            function.addSellOrder(order);
            logger.info("sell request add to list");
        } else if (order.getType().equals("size")) {
            logger.info("size request add to list");
            function.addSizeOrder(order);
        } else {
            System.Logger.Level error = System.Logger.Level.ERROR;
            logger.warning(String.valueOf(error));
            throw new RuntimeException();
        }
    }

}
