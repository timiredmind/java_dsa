import linkedlist.LinkedList;

public class Main {
    public static void main(String[] args) {
//        final LinkedList list = new LinkedList(1);
//
//        System.out.println(list);
//
//        System.out.println("::: after prepending :::");
//        list.prepend(2);
//        System.out.println(list);
//
//        list.append(3);
//        list.printList();
//
//        System.out.println(list.getLength());
//
//        list.insert(0, 5);
//        list.printList();
//        list.insert(4, 6);
//        list.printList();
//        System.out.println(list.getLength());
//        System.out.println(list.insert(3, 7));
//        list.printList();
////        System.out.println(list.getLength());
//
////        list.printList();
//
//        System.out.println(list.removeLast());
//        list.printList();
//        System.out.println(list.removeLast());
//        list.printList();
//        System.out.println(list.removeLast());
//        list.printList();
//
//        System.out.println(list.removeLast());
//        list.printList();

        LinkedList list = new LinkedList(1);
//        System.out.println(list.removeFirst().value);
//        list.printList();
//
//        System.out.println(list.getHead());
//        System.out.println(list.getTail());
//        System.out.println(list.getLength());
        list.append(2);
        list.append(1);
        list.append(4);
        list.prepend(1);

        list.printList();

//        System.out.println(list.remove(0).value);
//        list.printList();
//        System.out.println(list.getLength());

//        list.reverse();
        list.removeDuplicatesWithSet();
        list.printList();

//        System.out.println(list.getTail().next.value);
//        System.out.println(list.getHead().value);

//        System.out.println(list.get(-1));

//        list.set(0, 2);
//        list.printList();

//        list.set(1, 4);
//        list.set(2, 6);
//        list.set(3, 8);
//        list.printList();
//
//        list.prepend(0);
//        list.printList();
//
//        System.out.println(list.removeFirst().value);
//        list.printList();
//
//        System.out.println(list.removeLast());
//        list.printList();
//
//        list.insert(3, 4);
//        list.printList();
//
//        list.insert(0, 0);
//        list.printList();
    }
}
