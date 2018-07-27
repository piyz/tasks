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

    private void removeBetweenTwoNodes(int m, int n){
        reverse();

        Node node = head;
        int count = 0;
        while (count < m){
            node = node.next;
            count++;
        }
        Node temp = node;

        while (count < n && node != null){
            node = node.next;
            count++;
        }
        temp.next = node;
    }

    private void removeBetweenEveryTwoNodes(int m, int n){
        Node node = head;
        int count;

        while (node != null){
            count = 0;
            while (count < n - 1){
                node = node.next;
                count++;
                if (node == null){
                    return;
                }
            }
            Node temp = node;

            count = 0;
            while (count < m + 1 && node != null){
                node = node.next;
                count++;
            }
            temp.next = node;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
    }
}