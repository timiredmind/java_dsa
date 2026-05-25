package doublylinkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

    @Test
    public void testPrependEmptyList() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.prepend(1);


        assertEquals(1, dll.getLength());
        assertEquals(dll.getHead(), dll.getTail());
        assertEquals(1, dll.getHead().value);
        assertEquals(1, dll.getTail().value);
    }

    @Test
    public void testPrependSingleElementList() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(1);

        dll.prepend(2);
        assertEquals(2, dll.getHead().value);
        assertEquals(1, dll.getTail().value);
        assertEquals(2, dll.getLength());
    }

    @Test
    public void testPrependMultipleElementList() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(1);
        dll.append(2);
        dll.prepend(0);

        assertEquals(3, dll.getLength());
        assertEquals(0, dll.getHead().value);
        assertEquals(2, dll.getTail().value);
    }

    @Test
    public void testRemoveFirstWithEmptyList() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        assertNull(dll.removeFirst());
    }

    @Test
    public void testRemoveFirstWithSingleList() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(1);
        var node = dll.removeFirst();

        assertEquals(1, node.value);
        assertNull(node.prev);
        assertNull(node.next);
        assertNull(dll.getHead());
        assertNull(dll.getTail());
        assertEquals(0, dll.getLength());
    }

    @Test
    public void testRemoveFirstWithTwoElementList() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(1);
        dll.append(2);
        var node = dll.removeFirst();

        assertEquals(1, node.value);
        assertEquals(2, dll.getHead().value);
        assertEquals(2, dll.getTail().value);
        assertEquals(1, dll.getLength());
        assertNull(node.prev);
        assertNull(node.next);
    }

    @Test
    public void testRemoveFirstWithMultipleElementList() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(0);
        dll.append(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);

        var node = dll.removeFirst();
        assertEquals(0, node.value);
        assertEquals(1, dll.getHead().value);
        assertEquals(5, dll.getTail().value);
        assertEquals(5, dll.getLength());
    }

    @Test
    public void testGetWithIndexLessThanZero() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(0);

        var node = dll.get(-1);
        assertNull(node);
    }

    @Test
    public void testGetWithIndexMoreThanLength() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(0);
        var node = dll.get(2);
        assertNull(node);
    }

    @Test
    public void testGetWithIndex() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(0);
        var node = dll.get(0);

        assertEquals(node, dll.getHead());
    }

    @Test
    public void testGetWithIndex2() {
        final  DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(1);
        dll.append(2);
        dll.append(3);

        var node = dll.get(1);
        assertEquals(2, node.value);
        assertEquals(1, node.prev.value);
        assertEquals(3, node.next.value);
    }

    @Test
    public void testSetMethod1() {
        final  DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(1);
        dll.append(2);
        dll.append(3);

        assertTrue(dll.set(1, 9));
        var updatedNode = dll.get(1);
        assertEquals(9, updatedNode.value);
    }

    @Test
    public void testSetMethodWithInvalidIndex() {
        final  DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(1);

        assertFalse(dll.set(-1, 5));
    }

    @Test
    public void testSetMethodWithInvalidIndex1() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(1);
        assertFalse(dll.set(4, 9));
    }

    @Test
    public void testInsertWithEmptyList() {
        final DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        assertTrue(doublyLinkedList.insert(0, 1));
        assertEquals(1, doublyLinkedList.getHead().value);
        assertEquals(1, doublyLinkedList.getTail().value);
        assertEquals(1, doublyLinkedList.getLength());
    }

    @Test
    public void testInsertWithInvalidIndex() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(0);
        assertFalse(dll.insert(-1, 2));
    }

    @Test
    public void testInsertWithInvalidIndex1() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(0);
        assertFalse(dll.insert(3, 3));
    }

    @Test
    public void testInsertMethod1() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(0);
        dll.append(1);

        assertTrue(dll.insert(1, 3));
        assertEquals(0, dll.getHead().value);
        assertEquals(3, dll.get(1).value);
        assertEquals(1, dll.getTail().value);
    }

    @Test
    public void testInsertMethod2() {
        final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(0);
        dll.append(1);
        dll.append(2);

        assertTrue(dll.insert(3, 3));
        assertEquals(0, dll.getHead().value);
        assertEquals(3, dll.getTail().value);
        assertEquals(4, dll.getLength());
    }

}
