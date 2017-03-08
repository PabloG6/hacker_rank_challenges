import java.util.Scanner;

/**
 * Created by Pablo on 1/22/2017.
 */
public class BubbleSort {


    public int bubbleSort(int[] array) {
        int numOfSwaps = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(i, j, array);
                    numOfSwaps++;
                }
            }
        }
        return numOfSwaps;
    }

    public void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        array = new int[size];


        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();


        }

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(array);
    }
}
