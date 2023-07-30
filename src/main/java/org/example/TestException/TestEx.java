package org.example.TestException;

import java.util.Scanner;
import java.util.function.Function;

public class TestEx {

    public static <T> T input (String message, Function<String, T> converter) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(message);
                return converter.apply(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Вероятно, вы ввели недопустимый формат данных ");
            }
        }
    }

}
