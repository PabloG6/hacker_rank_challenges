import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by Pablo on 11/3/2016.
 */


public class Solution {
    Map<String, Integer> magazineMap = new HashMap<>();
    String note;

    public Solution(String[] magazine, String ransom) {
        add(magazine, magazineMap);
        this.note = ransom;
    }

    private void add(String[] s, Map map) {
        for (String value : s) {
            if (!map.containsKey(s)) {
                map.put(value, 0);

            } else {
                map.put(value, (Integer) map.get(value) + 1);
            }
        }
    }

    public boolean solve() {
        for (String s : note.split(" ")) {
            if (magazineMap.containsKey(s)) {
                if (magazineMap.get(s) < 0) {
                    return false;
                }
                magazineMap.put(s, magazineMap.put(s, magazineMap.get(s) - 1));


            } else {
                return false;

            }
        }
        return true;

    }

    static class Nodes {
        Nodes next;
        String s;
        int size;
    }

    public static class HashTable {

        String[] values;
        Nodes[] hashTable;

        public HashTable(String[] values) {
            if (values.length == 0) {
                throw new RuntimeException("Please enter a string array with length greater than 0");
            }
            this.values = values;
            hashTable = new Nodes[values.length];
            hash();
        }

        private int hashKey(String s) {
            return s.hashCode() % values.length;
        }

        final private void hash() {
            for (int i = 0; i < values.length; i++) {
                int key = hashKey(values[i]);
                Nodes map = new Nodes();
                map.s = values[i];

                Nodes hMap = hashTable[key];
                if (hMap == null) {
                    hashTable[key] = map;
                    continue;
                }

                while (hMap.next != null) {
                    hMap = hMap.next;
                    if (hMap.s.equals(values[i])) {
                        hMap.size++;
                        break;
                    }
                }
                hMap.next = map;
                hashTable[key] = hMap;
            }


        }

        private boolean search(String s) {
            int key = s.hashCode() % values.length;
            Nodes map = hashTable[key];


            //check if the map string is equal and if the next node is null
            while (map != null && !map.s.equals(s)) {
                map = map.next;
            }
            if (map == null) {
                return false;
            }
            map.size--;

            return map.size > 0;
        }

        public boolean search(String[] s) {
            for (String val : s) {
                if (!search(s)) {
                    return false;
                }
            }
            return true;
        }
    }

    String magazine;
    String ransom;
    HashMap<String, Integer> magHash = new HashMap<>();

//    public Solution(String magazine, String ransom){
//        this.magazine = magazine;
//        this.ransom = ransom;
//        for(String s: magazine.split(" ")){
//            magHash.put(s, magHash.getOrDefault(s, 0)+1);
//        }
//
//
//
//    }


    public static int[] rotate(int[] array, int rot) {

        for (int i = 0; i < rot; i++) {
            array = leftRotation(array);
        }

        return array;
    }

    //// FIXME: 11/3/2016 recursion is bad because everytime you call a function you have to put it on a new stackframe
    static public int[] leftRotation(int[] arr, int previous, int len) {
        if (len == 0) {
            arr[arr.length - 1] = previous;
            return arr;
        }

        int temp = arr[len - 1];
        arr[len - 1] = previous;
        return leftRotation(arr, temp, len - 1);
    }

    static public int[] leftRotation(int[] arr) {
        int temp = arr[0];
        int fin;
        for (fin = 0; fin < arr.length - 1; fin++) {
            arr[fin] = arr[fin + 1];

        }
        arr[arr.length - 1] = temp;
        return arr;
    }

    static public void testRotation() {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int rot = in.nextInt();
        in.nextLine();
        String line = in.nextLine();
        String array[] = line.split(" ");
        int[] arr = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            arr[i] = Integer.parseInt(array[i]);

        }


        int[] new_arr = rotate(arr, rot);
        for (int aNew_arr : new_arr) System.out.print(aNew_arr + " ");

    }

    public static void main(String[] args) {
//        Node node = new Node();
//        node.add("hack");
//        node.add("hackerrank");
//        System.out.println(node.getCount("hac"));
        Scanner in = new Scanner(System.in);
        String magazine = "give me one grand today night";
        String ransom = "give one grand today";
        Solution solution = new Solution(magazine.split(" "), ransom);
        System.out.println(solution.solve());
    }

    static class Node {
        private static final int node_size = 26;
        Node[] children = new Node[node_size];
        int size;

        public static int getCharIndex(char c) {
            return c - 'a';
        }


        public void setNode(char c, Node node) {
            children[getCharIndex(c)] = node;
        }

        public Node getNode(char c) {
            return children[getCharIndex(c)];
        }

        public int getCount(String s) {
            return getCount(s, 0);

        }

        private int getCount(String s, int index) {
            if (index == s.length()) {
                return size;
            }
            char c = s.charAt(index);
            Node child = getNode(c);
            if (child == null) {
                return 0;
            }
            return child.getCount(s, index + 1);

        }


        public void add(String s) {
            add(s, 0);
        }


        public void add(String s, int index) {
            size++;
            if (s.length() == index) return;
            char c = s.charAt(index);
            int charIndex = c - 'a';
            Node child = getNode(c);
            if (child == null) {
                child = new Node();
                children[charIndex] = child;
                setNode(c, child);
            }
            child.add(s, index + 1);


        }


        static class Anagram {
            public int numberNeeded(String first, String second) {

                //assuming it's ascii;
                int result = 0;
                int[] freq = new int[256];
                for (char ch : first.toCharArray()) {
                    freq[ch - 'a']++;
                }

                for (char ch : second.toCharArray()) {
                    freq[ch - 'a']--;
                }

                for (int val : freq) {
                    result += Math.abs(val);
                }

                return result;
            }

        }


    }
}

// if 'n' is NOT evenly divisible by 2 (i.e.: n is odd)


class Solution1 {
    public static int charIndex(char c) {
        return c - 'a';
    }

    public static void countStones(String value, int[] stones) {
        boolean[] already_counted = new boolean[26];
        for (int i = 0; i < value.length(); i++) {
            int pos = charIndex(value.charAt(i));
            if (!already_counted[pos]) {
                stones[pos]++;
                already_counted[pos] = true;

            }
        }
    }

    public static int allGems(int[] stones, int list_of_stones) {
        int var = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] == list_of_stones) {
                var++;
            }
        }

        return var;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int[] gem_stones = new int[26];
        Scanner scanner = new Scanner(System.in);
        int counter = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < counter; i++) {
            String value = scanner.nextLine();
            countStones(value, gem_stones);

        }
        System.out.println(allGems(gem_stones, counter));

    }
}


class Solution2 {
    static public boolean isAm(String value) {
        return value.contains("AM");
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String value = scanner.next();
        String removedMeridian = value.substring(0, value.length() - 2);
        String[] times = removedMeridian.split(":");
        if (isAm(value)) {
            int army_time = Integer.parseInt(times[0]);
            if (army_time == 12) {
                army_time -= 12;
            }
            System.out.printf("%02d:%s:%s", army_time, times[1], times[2]);

        } else {
            int army_time = Integer.parseInt(times[0]);
            army_time += 12;
            System.out.printf("%02d:%s:%s", army_time, times[1], times[2]);
        }
    }
}

/*
Consider two sets of positive integers, A={a0, a1,..... a(n-1)} and B={b0, b1..... b(m-1)}
. We say that a positive integer, x, is between sets A and B if the following
conditions are satisfied:

All elements in  A are factors of x.
x is a factor of all elements in B.
Given A and B, find and print the number of integers (i.e., possible x's)
that are between the two sets.
 */
class Solution3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = 0;
        int y = 101;
        int retVal = 0;
        boolean aFactor = true;
        boolean bFactor = true;

        int m = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
            //loop through a
            if (a[a_i] > x) {

                //highest value in a
                x = a[a_i];
            }
        }
        int[] b = new int[m];
        for (int b_i = 0; b_i < m; b_i++) {
            b[b_i] = in.nextInt();

            if (b[b_i] < y) {
                y = b[b_i];
            }

        }

        for (int i = x; i < y + 1; i++) {

            for(int a_i: a) {
                if(i%a_i!=0) {
                    aFactor =false;
                    break;
                }
                aFactor = true;

            }

            for(int b_i: b) {
                if(b_i%i!=0) {
                    bFactor=false;
                    break;
                }
                bFactor = true;
            }

            if(bFactor && aFactor) {
                retVal++;
            }

        }
        System.out.println(retVal);

    }

}

class Solution4 {


    public static BigInteger factorial(BigInteger value) {

        if(value.equals(new BigInteger("0"))) {
            return new BigInteger("1");
        }
        return new BigInteger(String.valueOf(value)).multiply(factorial(new BigInteger(String.valueOf(value.subtract(new BigInteger("1"))))));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(factorial(new BigInteger(String.valueOf(i))));

    }

}


//challenge here https://www.hackerrank.com/challenges/sock-merchant?h_r=next-challenge&h_v=zen
 /*
 John's clothing store has a pile of n loose socks where each sock i is
 labeled with an integer, ci, denoting its color.
 He wants to sell as many socks as possible,
 but his customers will only buy them in matching pairs. Two socks, i
 and j, are a single matching pair if ci = cj.
Given  and the color of each sock, how many pairs of socks can John sell?
  */
class Solution5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num_sold = 0;
        int n = in.nextInt();
        int[] socks_count = new int[101];
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }

        for(int i: c) {
            socks_count[i]++;

        }
        for(int s_c: socks_count) {
            num_sold+=(int) Math.floor(s_c/2);
        }
        System.out.println(num_sold);
    }
}