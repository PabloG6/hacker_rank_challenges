/**
 * Created by Pablo on 1/19/2017.
 */

/**
 * https://www.hackerrank.com/challenges/ctci-lonely-integer
 *Consider an array of integers, int[] a= [a0, a1, a2, a3 , a4]
 * where all but one of the integers occur in pairs. In other words, every element in  occurs exactly twice except for one unique element.
 Given , find and print the unique element.
 The first line contains a single integer, , denoting the number of integers in the array.
 The second line contains  space-separated integers describing the respective values in a.

 1<n<100
 0<=ai<=100, where 
 */
public class LonelyInteger {
    public int[] flags = new int[100];
    public int[] numbers;

    public LonelyInteger(int[] numbers) {
        this.numbers = numbers;

    }

    public int findUnique() {
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            flags[n]++;

        }

        for (int i = 0; i < flags.length; i++) {
            if (flags[i] == 1) {
                return i;
            }
        }
        return -1;
    }

}
