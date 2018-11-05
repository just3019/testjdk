package org.demon.java8;

import java.time.LocalDateTime;
import java.util.function.Supplier;

/**
 * @author demon
 * @version 1.0
 * @date 2018/10/30 14:21
 * @since 1.0
 */
public class Java8Tester {

    static String HELLO = "Hello ";

    public static void main(String args[]) {
        Java8Tester tester = new Java8Tester();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        String HELLO2 = "Hello2 ";

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println(HELLO + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println(HELLO2 + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");

        Supplier<Java8Tester> java8TesterSupplier = Java8Tester::new;
        System.out.println(java8TesterSupplier.get());
        System.out.println(java8TesterSupplier.get());
        System.out.println(java8TesterSupplier.get());

        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(currentTime);

    }


    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
