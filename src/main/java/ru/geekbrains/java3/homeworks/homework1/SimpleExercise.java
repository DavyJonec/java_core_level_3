package ru.geekbrains.java3.homeworks.homework1;

import java.util.ArrayList;
import java.util.Arrays;

public class SimpleExercise {


    // Задача 1. Написать метод, который меняет два элемента массива местами.
    public <T> void swapElements(T[] array, int index1, int index2) {
        System.out.println("Exercise #1\n" + Arrays.toString(array));
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        System.out.println(Arrays.toString(array));
    }

    //Задача 2. Написать метод, который преобразует массив в ArrayList
    //
    public static <L> ArrayList<L> arrToList(L[] arr) {
        ArrayList<L> result = new ArrayList<L>(arr.length);
        for (L l : arr) {
            result.add(l);
        }

        System.out.println("\nExercise #2\n" + result);
        return result;
    }
}