package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        final Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public LinkedList() {
        this.tail = null;
        this.head = null;
        this.length = 0;
    }

    @Override
    public String toString() {
        return "LinkedList { head = " + this.head + " }";
    }

    public int getLength() {
        return this.length;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public void printList() {
        Node temp = this.head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public void append(int value) {
        final Node node = new Node(value);
        this.tail.next = node;
        this.tail = node;
        this.length++;
    }

    public Node removeLast() {
        if (this.length == 0) {
            return null;
        }

        Node removedNode;
        if (this.length == 1) {
            removedNode = this.head;
            this.head = null;
            this.tail = null;
        } else {
            Node prev = this.head;
            Node current = this.head;

            while(current.next != null) {
                prev = current;
                current = current.next;
            }
            prev.next = null;
            this.tail = prev;
            removedNode = current;
        }
        this.length--;
        return removedNode;
    }

    public void prepend(int value) {
        final Node node = new Node(value);
        if (this.length == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
        this.length++;
    }

    public Node removeFirst() {
        if (this.length == 0) {
            return null;
        }

        Node removedNode = this.head;
        this.head = this.head.next;
        if (this.length == 1) {
            this.tail = null;
        }
        this.length--;
        return removedNode;
    }

    public boolean insert(int index, int value) {
        if (index > this.length) {
            return false;
        }

        if (index == 0) {
            prepend(value);
        }
        else if (index == this.length) {
            append(value);
        }
        else {
            final Node newNode = new Node(value);
            Node current = this.head;
            Node prev = this.head;
            for(int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }
            prev.next = newNode;
            newNode.next = current;
            length++;
        }
        return true;
    }

    public Node get(int index) {
        if (index >= this.length || index < 0) {
            return null;
        }
        Node node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public boolean set(int index, int value) {
        Node node = get(index);
        if (node == null) {
            return false;
        }
        node.setValue(value);
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }
        if (index == (this.length - 1)) {
            return removeLast();
        }

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        this.length--;
        return temp;
    }

    public void reverse() {
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;

        Node before = null;

        while(temp != null) {
            Node after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node findMiddleNode() {
        // floyd tortise and hare algorithm
        Node slow = this.head;
        Node fast = this.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node findKthNodeFromEnd(int k) {
        Node slow = this.head;
        Node fast = this.head;

        // move the fast object forward by k elements
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public void removeDuplicatesWithSet() {
        final Set<Integer> values = new HashSet<>();
        Node before = this.head;
        Node temp = this.head;

        while (temp != null) {
            if (values.contains(temp.value)) {
                before.next = temp.next;
                length--;
            } else {
                values.add(temp.value);
                before = temp;
            }
            temp = temp.next;
        }
    }

    public void removeDuplicateWithoutSet() {
        Node current = this.head;

        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (current.value == runner.next.value) {
                    runner.next = runner.next.next;
                    length--;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static class Node {
        public Node next;
        public int value;


        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
