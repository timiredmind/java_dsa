package linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void testFindMiddleNodeOnEmptyList() {
        final LinkedList emptyList = new LinkedList();
        assertNull(emptyList.findMiddleNode());
    }

    @Test
    public void testFindMiddleNodeForListWithOneValue() {
        final LinkedList singleList = new LinkedList(1);
        LinkedList.Node middleNode = singleList.findMiddleNode();
        assertEquals(1, middleNode.value);
        assertNull(middleNode.next);
    }

    @Test
    public void testFindMiddleNodeForOddElements() {
        final LinkedList list = new LinkedList(1);
        list.append(2);
        list.append(3);

        LinkedList.Node middleNode = list.findMiddleNode();
        assertEquals(2, middleNode.value);
        assertEquals(3, middleNode.next.value);
    }

    @Test
    public void testFindMiddleNodeForEvenElements() {
        final LinkedList list = new LinkedList(1);
        list.append(2);
        list.append(3);
        list.append(4);

        LinkedList.Node middleNode = list.findMiddleNode();
        assertEquals(3, middleNode.value);
        assertEquals(4, middleNode.next.value);
    }

    @Test
    public void testRemoveDuplicateWithSet() {
        final LinkedList list = new LinkedList(1);
        list.append(2);
        list.append(1);
        list.append(3);
        list.append(4);
        list.append(4);

        assertEquals(6, list.getLength());
        list.removeDuplicatesWithSet();

        assertEquals(4, list.getLength());
        LinkedList.Node firstNode = list.getHead();
        assertEquals(1, firstNode.value);
        LinkedList.Node secondNode = firstNode.next;
        assertEquals(2, secondNode.value);
        LinkedList.Node thirdNode = secondNode.next;
        assertEquals(3, thirdNode.value);
        LinkedList.Node lastNode = thirdNode.next;
        assertEquals(4, lastNode.value);
    }

    @Test
    public void testRemoveDuplicateWithoutSet() {
        final LinkedList list = new LinkedList(1);
        list.append(2);
        list.append(1);
        list.append(3);
        list.append(4);
        list.append(4);

        assertEquals(6, list.getLength());
        list.removeDuplicateWithoutSet();

        assertEquals(4, list.getLength());
        LinkedList.Node firstNode = list.getHead();
        assertEquals(1, firstNode.value);
        LinkedList.Node secondNode = firstNode.next;
        assertEquals(2, secondNode.value);
        LinkedList.Node thirdNode = secondNode.next;
        assertEquals(3, thirdNode.value);
        LinkedList.Node lastNode = thirdNode.next;
        assertEquals(4, lastNode.value);
    }

    @Test
    public void testBinaryToDecimal1() {
        final LinkedList list = new LinkedList(1);
        list.append(0);
        list.append(1);

        int decimalValue = list.binaryToDecimal();
        assertEquals(5, decimalValue);
    }

    @Test
    public void testBinaryToDecimal2() {
        final LinkedList list = new LinkedList(1);
        list.append(1);
        list.append(1);

        int decimalValue = list.binaryToDecimal();
        assertEquals(7, decimalValue);
    }
}
