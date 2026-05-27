package doublylinkedlist;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public DoublyLinkedList(T value) {
        Node<T> newNode = new Node<>(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    public int getLength() {
        return this.length;
    }

    public void append(T value) {
        Node<T> newNode = new Node<>(value);
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
        }
        this.tail = newNode;
        this.length++;
    }

    public Node<T> removeLast() {
        if (this.head == null) {
            return null;
        }
        Node<T> lastNode = this.tail;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.length--;
        lastNode.prev = null;
        return lastNode;
    }

    public void prepend(T value) {
        Node<T> newNode = new Node<>(value);
        if (this.head == null) {
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
        }
        this.head = newNode;
        length++;
    }

    public Node<T> removeFirst() {
        if (this.head == null) {
            return null;
        }
        final Node<T> temp = this.head;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.length--;
        temp.next = null;
        return temp;
    }

    public Node<T> get(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        Node<T> temp = this.head;
        if (index < length/2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = this.tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, T value) {
        Node<T> node = get(index);
        if (node == null) {
            return false;
        }
        node.value = value;
        return true;
    }


    public boolean insert(int index, T value) {
        if (index < 0 || index > this.length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
        } else if (index == this.length) {
            append(value);
        } else {
            Node<T> prev = get(index -1);
            Node<T> current = prev.next;
            Node<T> newNode = new Node<>(value);

            newNode.next = current;
            newNode.prev = prev;
            prev.next = newNode;
            current.prev = newNode;
            this.length++;
        }
        return true;
    }

    public Node<T> remove(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        else if(index == 0) {
            return removeFirst();
        } else if (index == this.length - 1) {
            return removeLast();
        } else {
            Node<T> current = get(index);
            Node<T> after = current.next;
            Node<T> prev = current.prev;

            prev.next = after;
            after.prev = prev;

            current.next = null;
            current.prev = null;
            length--;
            return current;
        }

    }

    public void swapFirstLast() {
        if (this.length > 2) {
            T headValue = this.head.value;
            this.head.value = this.tail.value;
            this.tail.value = headValue;
        }
    }

    public void reverse() {
        Node<T> current = this.head;
        Node<T> temp;
        Node<T> after;
        while (current != null) {
            temp = current.prev;
            after = current.next;

            current.next = temp;
            current.prev = after;

            current = current.prev;
        }
        temp = this.head;
        this.head = this.tail;
        this.tail = temp;
    }

    public void printList() {
        Node<T> temp = this.head;
        while(temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static class Node<T> {
        public T value;
        public Node<T> prev;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}
