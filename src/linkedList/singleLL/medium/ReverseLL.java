package linkedList.singleLL.medium;

import linkedList.singleLL.Node;

public class ReverseLL {
    public static Node reverse(Node head){
        Node temp=head;
        Node before=null;
        Node after=head;

        while (temp!=null){
            after=after.next;
            temp.next=before;
            before=temp;
            temp=after;
        }
//        before points to the last element which is new head
        head=before;
        return head ;

    }
    public static void main(String[] args) {

    }
}
