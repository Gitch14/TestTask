package org.example.facade.logic;

import org.example.facade.dto.Order;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Menu {
    static Logger logger = Logger.getLogger(Menu.class.getName());
    public void menu() throws IOException {
        AddOrder orderBook = new AddOrder();
        File file = new File("file.txt");
        Scanner scanner = new Scanner(file);

        logger.info("Open file " + file.getName());


        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");

            if (parts.length == 4) {
                String side = parts[0];
                int price = Integer.parseInt(parts[1]);
                int size = Integer.parseInt(parts[2]);
                String orderType = parts[3];
                Order order1 = new Order(side, price, size, orderType);
                orderBook.addOrder(order1);
            } else if (parts.length == 3) {
                String side = parts[0];
                String orderType = parts[1];
                int size = Integer.parseInt(parts[2]);
                Order order2 = new Order(side, orderType, size);
                orderBook.addOrder(order2);
            } else if (parts.length == 2) {
                String side = parts[0];
                String orderType = parts[1];
                Order order3 = new Order(side, orderType);
                orderBook.addOrder(order3);
            }else {
                System.Logger.Level error = System.Logger.Level.ERROR;
                logger.warning(String.valueOf(error));
                throw new RuntimeException();
            }

        }
        scanner.close();
        logger.info("Scanner close");
    }
}
