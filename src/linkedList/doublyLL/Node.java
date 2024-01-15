package linkedList.doublyLL;

public class Node {
    int value;
    Node next;
    Node previous;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next, Node previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }
}
