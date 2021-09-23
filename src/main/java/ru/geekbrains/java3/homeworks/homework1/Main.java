package ru.geekbrains.java3.homeworks.homework1;

// Задача 1. Написать метод, который меняет два элемента массива местами.

// Задача 2. Написать метод, который преобразует массив в ArrayList

//3. Большая задача:

//a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку
//   нельзя сложить и яблоки, и апельсины;
//c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока -
//   1.0f, апельсина - 1.5f, не важно в каких это единицах);
//e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в
//   compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем
//   сравнивать с коробками с апельсинами);
//f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
//   (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
//   соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
//g. Не забываем про метод добавления фрукта в коробку.

public class Main {
    static String[] arr = {"asd", "r345", "245ujdfd", "hello"};
    static Integer[] arr1 = {223343, 124, 475, 3464};
    static SimpleExercise simpleExercise = new SimpleExercise();

    public static void main(String[] args) {
        simpleExercise.swapElements(arr, 1, 3);
        simpleExercise.arrToList(arr1);

        System.out.println("\nExercise #3");

        FruitBox<Apple> appleFruitBox = new FruitBox<>(new Apple(), new Apple(), new Apple());
        System.out.println(appleFruitBox.getWeight());
        FruitBox<Orange> oranges = new FruitBox<>(new Orange(), new Orange(), new Orange());

        System.out.println(appleFruitBox.equalsByWeight(oranges));

        FruitBox<Orange> orangeFruitBox = new FruitBox<>(new Orange(), new Orange());

        System.out.println(oranges.getWeight());
        oranges.transferAll(orangeFruitBox);
        System.out.println(orangeFruitBox.getWeight());
        System.out.println(oranges.getWeight());
    }
}
