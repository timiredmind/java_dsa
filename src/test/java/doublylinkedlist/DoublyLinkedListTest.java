package doublylinkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

    @Test
    public void testAppendEmptyDoublyLinkedList() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.append(1);

        assertEquals(1, dll.getLength());
        assertEquals(1, dll.getHead().value);
        assertEquals(1, dll.getTail().value);
        assertEquals(dll.getHead(), dll.getTail());
    }

    @Test
    public void testAppendSingleElementDoublyLinkedList() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(1);
        dll.append(2);

        assertNull(dll.getHead().prev);
        assertEquals(1, dll.getHead().value);
        assertEquals(2, dll.getTail().value);
        assertEquals(2, dll.getLength());
        assertEquals(dll.getHead().next, dll.getTail());
        assertEquals(dll.getTail().prev, dll.getHead());
    }

    @Test
    public void testAppendDoublyLinkedList() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);

        assertEquals(1, dll.getHead().value);
        assertNull(dll.getHead().prev);
        assertEquals(4, dll.getTail().value);
        assertEquals(4, dll.getLength());

        DoublyLinkedList.Node<Integer> secondNode = dll.getHead().next;
        DoublyLinkedList.Node<Integer> thirdNode = secondNode.next;
        assertEquals(2, secondNode.value);
        assertEquals(3, thirdNode.value);
        assertEquals(thirdNode, dll.getTail().prev);
    }

    @Test
    public void testRemoveLastFromEmptyList() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        assertNull(dll.removeLast());
    }

    @Test
    public void testRemoveLastFromSingleElementList() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(1);
        var lastNode = dll.removeLast();

        assertEquals(1, lastNode.value);
        assertEquals(0, dll.getLength());
        assertNull(lastNode.prev);
        assertNull(lastNode.next);
        assertNull(dll.getHead());
        assertNull(dll.getTail());
    }

    @Test
    public void testRemoveLastFromTwoElementList() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(1);
        dll.append(2);

        var lastNode = dll.removeLast();

        assertEquals(2, lastNode.value);
        assertNull(lastNode.prev);
        assertNull(lastNode.next);

        assertEquals(1, dll.getLength());
        assertEquals(dll.getHead(), dll.getTail());
        assertNull(dll.getHead().next);
        assertNull(dll.getTail().next);
    }

    @Test
    public void testRemoveLastFromMultipleElementList() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(1);
        dll.append(2);
        dll.append(3);

        var lastNode = dll.removeLast();
        assertEquals(3, lastNode.value);
        assertEquals(2, dll.getLength());

        assertEquals(1, dll.getHead().value);
        assertEquals(2, dll.getTail().value);
        assertEquals(dll.getHead().next, dll.getTail());
        assertEquals(dll.getTail().prev, dll.getHead());
    }
}
