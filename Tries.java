/**
 * Created by Pablo on 1/19/2017.
 */
public class Tries {
    //create an array value that stores the 26 characters

    public static class LonelyInteger {
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
}
