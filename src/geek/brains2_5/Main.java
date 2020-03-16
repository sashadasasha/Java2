package geek.brains2_5;

import java.util.Arrays;

public class Main {

    private static final int size = 10000000;
    private static final int half = size / 2;
    private static float[] arr = new float[size];


    private static void operationWithArr(float[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (float)i / 5) * Math.cos(0.2f + (float)i / 5) * Math.cos(0.4f + (float)i / 2));
        }
    }

    private static void operationWithoutThread() {
        Arrays.fill(arr, 1);
        System.out.println("Подсчет без потоков - start");
        long startTime = System.currentTimeMillis();
        operationWithArr(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("Время, затраченное на выполнение без потоков: " + (endTime - startTime));
    }

    private static void operationWithThread() throws InterruptedException {
        Arrays.fill(arr, 1);
        float[] arr1 = new float[half];
        float[] arr2 = new float[half];
        System.out.println("Процесс подсчета с потоками - start");
        long startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, half);
        System.arraycopy(arr, half, arr2, 0, half);
        Thread thread1 = new Thread(() -> operationWithArr(arr1));
        Thread thread2 = new Thread(() -> operationWithArr(arr2));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.arraycopy(arr1, 0, arr, 0, half);
        System.arraycopy(arr2, 0, arr, half, half);
        long endTime = System.currentTimeMillis();
        System.out.println("Время, затраченное на выполнение с потоками: " + (endTime - startTime));
    }

    public static void main(String[] args) {
        operationWithoutThread();
        try {
            operationWithThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
