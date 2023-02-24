package org.example;

import org.example.facade.logic.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.menu();
    }
}