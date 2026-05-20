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
}
