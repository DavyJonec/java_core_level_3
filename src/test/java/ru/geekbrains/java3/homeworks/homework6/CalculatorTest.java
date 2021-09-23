package ru.geekbrains.java3.homeworks.homework6;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.java3.homeworks.Homework6.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeAll
    static void initAll() {
        System.out.println("Before all");
    }

    @AfterAll
    static void closeAll() {
        System.out.println("After all");
    }

    @BeforeEach
    void initEach() {
        System.out.println("Test init");
        calculator = new Calculator();
    }

        @CsvSource({
            "5,7,12",
            "2, 6, 8",
            "20,10,30",
            "15,17,32",
            "15,26,41"
    })
    @CsvFileSource(files = {"test_csv/test_add.csv"})
    @MethodSource("generateValuesForAdd")
    @ParameterizedTest
    @Disabled
    void massAddTest(int a, int b, int result) {
        Assertions.assertEquals(result, calculator.add(a, b));
    }

    @Test
    @Timeout(value = 3000, unit = TimeUnit.MILLISECONDS)
    void someLongTest() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Stream<Arguments> generateValuesForAdd() {
        List<Arguments> list = new ArrayList<>(100_000);

        for (int i = 0; i < 100_000; i++) {
            int a = (int) (Math.random() * 100_000);
            int b = (int) (Math.random() * 100_000);
            int result = a + b;
            list.add(Arguments.arguments(a, b, result));
        }
        return list.stream();
    }

    @Test
    void add() {
        Assertions.assertEquals(20, calculator.add(15, 5));
//        Assertions.assertEquals(30, calculator.add(15, 15));
//        Assertions.assertEquals(32, calculator.add(15, 17));
//        Assertions.assertEquals(41, calculator.add(15, 26));
//        Assertions.assertEquals(20, calculator.add(15, 5));
    }

    @Test
    void sub() {
        int a = 15;
        int b = 5;
        int result = 10;
        Assertions.assertEquals(result, calculator.sub(a, b));
    }

    @Test
    void mul() {
        int a = 15;
        int b = 5;
        int result = 75;
        Assertions.assertEquals(result, calculator.mul(a, b));
    }

    @Test
    void div() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.div(10, 0));
    }

    @AfterEach
    void closeEach() {
        System.out.println("After test");
    }
}