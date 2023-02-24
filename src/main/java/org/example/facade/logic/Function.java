package org.example.facade.logic;


import lombok.ToString;
import org.example.facade.dto.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;


@ToString
public class Function {
    static Logger logger = Logger.getLogger(Function.class.getName());
    FileWriter nFile;
    private List<Order> bidOrders;
    private List<Order> askOrders;
    private List<Order> sizeOrders;
    private List<Order> buyOrders;
    private List<Order> sellOrders;

    public Function(List<Order> bidOrders, List<Order> askOrders, List<Order> sizeOrders, List<Order> buyOrders, List<Order> sellOrders) throws IOException {
        this.bidOrders = bidOrders;
        this.askOrders = askOrders;
        this.sizeOrders = sizeOrders;
        this.buyOrders = buyOrders;
        this.sellOrders = sellOrders;
        this.nFile = new FileWriter("orders.txt");
    }

    protected void addBidOrder(Order order) throws IOException {
        bidOrders.add(order);
            if (order.getType().equals("best_bid")) {
                int maxPrice = Integer.MIN_VALUE;
                int sizeForPrice;
                FileWriter nFile = new FileWriter("orders.txt");
                for (Order bidOrder : bidOrders) {
                    if (bidOrder.getPrice() > maxPrice) {
                        maxPrice = bidOrder.getPrice();
                        sizeForPrice = bidOrder.getSize();
                        String line = maxPrice + ", " + sizeForPrice + "\n";
                        nFile.write(line);
                        logger.info("line write in file");
                    }
                }
                nFile.close();

        }

    }


    protected void addAskOrder(Order order) throws IOException {
        askOrders.add(order);
        if (order.getType().equals("best_ask")) {
            int maxPrice = Integer.MIN_VALUE;
            int sizeForPrice;
            FileWriter nFile = new FileWriter("orders.txt");
            for (Order askOrders : askOrders) {
                if (askOrders.getPrice() > maxPrice) {
                    maxPrice = askOrders.getPrice();
                    sizeForPrice = askOrders.getSize();
                    String line = maxPrice + ", " + sizeForPrice + "\n";
                    nFile.write(line);
                    logger.info("line write in file");
                }
            }
            nFile.close();
        }

    }

        protected void addSizeOrder(Order order) throws IOException {
        sizeOrders.add(order);
            if (order.getType().equals("size")) {
                FileWriter fw = new FileWriter("orders.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw);

                for (Order sizeOrders : sizeOrders) {
                    for (Order varAsk : askOrders) {
                        if (varAsk.getSize() == sizeOrders.getSize()) {
                             String line = varAsk.getPrice() + ", " + varAsk.getPrice() + ", " + varAsk.getSize() + ", " + varAsk.getType() + "\n";
                            out.println(line);
                            logger.info("line write in file");
                        }
                    }

                    for (Order varBid : bidOrders) {
                        if (varBid.getSize() == sizeOrders.getSize()) {
                            String line = varBid.getPrice() + ", " + varBid.getPrice() + ", " + varBid.getSize() + ", " + varBid.getType() + "\n";
                            out.println(line);
                            logger.info("line write in file");
                            }
                        }
                    }

               out.close();
            }
    }

    protected void addBuyOrder(Order order) throws IOException {
        buyOrders.add(order);
        FileWriter nFile = new FileWriter("orders.txt");
            for (Order buyOrders : buyOrders) {
                String str = buyOrders.getSize() + "\n";
              nFile.write(str);
                logger.info("line write in file");
            }
        nFile.close();
    }



    protected void addSellOrder(Order order) throws IOException {
        sellOrders.add(order);
        FileWriter fw = new FileWriter("orders.txt", true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter out = new PrintWriter(bw);


        for (Order sellOrders : sellOrders) {
            String str = String.valueOf(sellOrders.getSize());
           out.println(str);
            logger.info("line write in file");
        }
       out.close();
    }


}
