import java.util.*;

//class for doubly linked list implementation
class DLL {
    int size;
    DLL(int size) {
        this.size = size;
    }

//    class for creating nodes in doubly linked list
    class Node {
        Node prev;
        int data;
        Node next;
        Node (int val) {
            data = val;
            prev = next = null;
        }
    }

//    initializing head and tail
    public Node head = null;
    public Node tail = null;

//    method to add nodes in DLL
    public void add(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
            head.prev = tail.next = null;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = null;
        }
    }

//    method insert a node at given position
    public void insert(int pos, int val) {
        Node newNode = new Node(val);
        Node prevNode = null;
        Node currNode = head;
        Node nextNode = null;
        if (pos == 1) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            head.prev = null;
        }
        else if (pos == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = null;
        }
        else {
            for (int i=1;i<pos;i++ ){
                prevNode = currNode;
                currNode = currNode.next;
                nextNode = currNode.next;
            }
            prevNode.next = newNode;
            newNode.next = currNode;

        }
    }

//    method to delete a given node
    public void delete(int val) {
        Node fNode = head;
        Node lNode = tail;
        Node prevNode = null;
        Node currNode = head;
        Node nextNode = null;
        if (fNode.data == val) {
            head = null;
            head = currNode.next;
            head.prev = null;
        }
        else if (lNode.data == val) {
            tail = null;
            tail = lNode.prev;
            tail.next = null;
        }
        else {
            while (currNode != null && currNode.data != val) {
                prevNode = currNode;
                currNode = currNode.next;
                nextNode = currNode.next;
            }
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            currNode = null;
        }
    }

//    method to display the DLL
    public void display() {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data +" ");
            currNode = currNode.next;
        }
        System.out.println();
    }
}
public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the number of nodes to be added..");
        int size = sc.nextInt();
        DLL list = new DLL(size);
        for (int i=0;i<size;i++) {
            System.out.println("Enter the element " +i);
            list.add(sc.nextInt());
        }
        System.out.println("Enter the value to deleted");
        int val = sc.nextInt();
        list.delete(val);
        System.out.println("Enter a position to insert a node..");
        int position = sc.nextInt();
        System.out.println("Enter the value to be inserted..");
        int value = sc.nextInt();
        list.insert(position, value);
        list.display();
    }
}