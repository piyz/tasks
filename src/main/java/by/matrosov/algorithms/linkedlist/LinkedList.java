package by.matrosov.algorithms.linkedlist;


public class LinkedList{

    private Node head;

    class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private void print(){
        Node node = head;
        while (node != null){
            System.out.println(node.data + " ");
            node = node.next;
        }
    }

    private void add(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    private void reverse(){
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    private void removeDuplicatesFromUnsorted(){
        Node node1, node2;
        node1 = head;
        while (node1 != null && node1.next != null){
            node2 = node1;
            while (node2.next != null){
                if (node1.data == node2.next.data){
                    node2.next = node2.next.next;
                }else {
                    node2 = node2.next;
                }
            }
            node1 = node1.next;
        }
    }

    private void removeDuplicatesFromSorted(){
        Node current = head;
        Node next;

        if (head == null){
            return;
        }

        while (current.next != null){
            if (current.data == current.next.data){
                next = current.next.next;
                current.next = next;
            }else {
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
    }
}