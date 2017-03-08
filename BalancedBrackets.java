/**
 * Created by Pablo on 1/20/2017.
 */
public class BalancedBrackets {

    public static class Queue {


        public static class Node {
            String data;
            Node next;
            int size;


            public Node(String data) {
                this.data = data;
            }


        }

        private Node head;
        private Node tail;

        public boolean isEmpty() {
            return head == null;
        }

        public void sendIn() {
            while (head != null) {
                System.out.println(head.data);
                this.head = head.next;
            }
        }

        public void add(String s) {
            Node node = new Node(s);
            if (head == null) {
                head = node;
                tail = head;
                return;
            }
            head.size++;

            tail.next = node;
            tail = tail.next;

        }

    }

    public static boolean isBalanced(String expression) {

        return true;
    }

    public static void main(String[] args) {
        String[] friends = new String[]{"Paul", "Jonil", "Javaughn", "Alex", "Jeremy"};
        Queue queue = new Queue();
        for (String friend : friends) {
            queue.add(friend);
        }

        queue.sendIn();


    }
}

