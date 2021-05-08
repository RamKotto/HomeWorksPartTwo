package LessonFive;


import java.util.Arrays;

public class Main{

    public static void main(String[] args) {

        sequential();

        try{
            parallel();
        } catch (InterruptedException e){
            e.printStackTrace();
        }


    }


    public static void sequential() {
        // создание одномерного массива:
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];

        // заполнение массива единицами:
        Arrays.fill(arr, 1);

        // Засекаем время выполнения:
        long start = System.currentTimeMillis();

        // Проходим по всему массиву и для каждой ячейки считают новое значение:
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        // Время окончания работы:
        long finish = System.currentTimeMillis();

        // Выводим время работы на экран:
        long result = finish - start;
        System.out.println("Время последовательного выполнения: " + result);
    }


    public static void parallel() throws InterruptedException {
        // создание одномерного массива:
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];

        // заполнение массива единицами:
        Arrays.fill(arr, 1);

        // Засекаем время выполнения:
        long start = System.currentTimeMillis();

        // Делим массив на двоих =)
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        // Запускаем щупальца в массивы:
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        // Склеиваем массивы:
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        // Подсчет времени:
        long finish = System.currentTimeMillis();
        long result = finish - start;
        System.out.println("Время параллельного выполнения: " + result);
    }

}
