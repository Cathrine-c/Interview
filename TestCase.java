package java_1101.java;

public class TestCase {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        //myLinkedList.addFirst(3);
        //myLinkedList.addFirst(9);
        myLinkedList.addFirst(7);
        myLinkedList.addFirst(6);
        myLinkedList.addFirst(0);
       // myLinkedList.addLast(1);
        myLinkedList.addIndex(2,2);
        //myLinkedList.display();
        //System.out.println(myLinkedList.contains(1));
        //System.out.println("--------------");
        myLinkedList.removeKey(7);
        myLinkedList.display();
        System.out.println("--------------");
        myLinkedList.clear();
        myLinkedList.display();

    }


}
