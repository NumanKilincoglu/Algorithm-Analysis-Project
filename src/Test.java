import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int size = 0;

        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                size = 10000;
            }
            if (i == 2) {
                size = 50000;
            }
            if (i == 3) {
                size = 100000;
            }
            if (i == 4) {
                size = 250000;
            }
            if (i == 5) {
                size = 500000;
            }
            if (i == 6) {
                size = 1000000;
            }
            if (i == 7) {
                size = 1250000;
            }
            if (i == 8) {
                size = 2000000;
            }
            if (i == 9) {
                size = 2500000;
            }
            int[] unordered = randomArray(size); // Unordered Array
            testSort(unordered, "Random Array");
            int[] ordered = orderedArray(size); // Unordered Array
            testSort(ordered, "Ordered Array");
            int[] reverseOrdered = reverseArray(size); // Reverse Ordered Array
            testSort(reverseOrdered, "Reverse Ordered Array");
        }
    }

    static void createCopy(int[] arr, int[] copy1, int[] copy2, int[] copy3, int[] copy4, int[] copy5) {
        for (int i = 0; i < arr.length; i++) {
            copy1[i] = copy2[i] = copy3[i] = copy4[i] = copy5[i] = arr[i];
        }
    }

    static void testSort(int[] testArray, String arrayType) {
        int n = testArray.length;
        int[] copy1 = new int[n];
        int[] copy2 = new int[n];
        int[] copy3 = new int[n];
        int[] copy4 = new int[n];
        int[] copy5 = new int[n];
        createCopy(testArray, copy1, copy2, copy3, copy4, copy5);

        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        LomutoQuickSort lomutoQuickSort = new LomutoQuickSort();
        HoareQuickSort hoareQuickSort = new HoareQuickSort();
        HeapSort heapSort = new HeapSort();

        long startTime = System.currentTimeMillis();
        selectionSort.run(testArray);
        long stopTime = System.currentTimeMillis();
        System.out.println(arrayType + " - (Selection Sort) - Array Length = " + n + " -- Execution Time:" + (stopTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        insertionSort.run(copy1);
        stopTime = System.currentTimeMillis();
        System.out.println(arrayType + " - (Insertion Sort) - Array Length = " + n + " -- Execution Time:" + (stopTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        mergeSort.run(copy2);
        stopTime = System.currentTimeMillis();
        System.out.println(arrayType + " - (Merge Sort) - Array Length = " + n + " -- Execution Time:" + (stopTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        lomutoQuickSort.run(copy3);
        stopTime = System.currentTimeMillis();
        System.out.println(arrayType + " - (Lomuto's Quick Sort) - Array Length = " + n + " -- Execution Time:" + (stopTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        hoareQuickSort.run(copy4);
        stopTime = System.currentTimeMillis();
        System.out.println(arrayType + " - (Hoare's Quick Sort) - Array Length = " + n + " -- Execution Time:" + (stopTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        heapSort.run(copy5);
        stopTime = System.currentTimeMillis();
        System.out.println(arrayType + " - (Heap Sort) - Array Length = " + n + " -- Execution Time:" + (stopTime - startTime) + " ms");
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    static int[] randomArray(int size) {
        int[] array = new int[size];
        int min = 1;
        int max = 1000;
        int range = max - min + 1;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * range) + min;
        }
        return array;
    }

    static int[] orderedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    static int[] reverseArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        Collections.reverse(List.of(array));
        return array;
    }

    static void yaz(int[] arr1, int[] arr2) {
        for (int i = 0; i < 500; i++) {
            System.out.println(i + " arr1: " + arr1[i] + " arr2: " + arr2[i]);
        }
    }

    static void arrYaz(int[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(i + " " + arr1[i]);
        }
    }

}