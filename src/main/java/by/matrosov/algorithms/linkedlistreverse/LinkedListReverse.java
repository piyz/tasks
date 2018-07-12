package by.matrosov.algorithms.linkedlistreverse;

public class LinkedListReverse {

    static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private void print(Node node){
        while (node != null){
            System.out.println(node.data + " ");
            node = node.next;
        }
    }

    private Node reverse(Node node){
        Node prev = null;
        Node current = node;
        Node next;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public static void main(String[] args) {
        LinkedListReverse list = new LinkedListReverse();
        Node head = new Node(22);
        head.next = new Node(54);
        head.next.next = new Node(111);
        head.next.next.next = new Node(202);

        head = list.reverse(head);
        list.print(head);
    }
}