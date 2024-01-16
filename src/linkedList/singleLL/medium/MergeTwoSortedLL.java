package linkedList.singleLL.medium;

//you are given head of two sorted ll. merge them in sorted order and return head

import linkedList.singleLL.Node;

public class MergeTwoSortedLL {
//    this is same as merge function of merge sort
    public static Node func(Node head1,Node head2){
        //create a dummy node
        Node dummy=new Node();
        //create a iterator temp(same as k in merge sort)
        Node k=dummy;
        Node i=head1;
        Node j=head2;

        //this is same as mergesort
        while (i!=null || j!=null){
            if(i.value< j.value){
                k.next=i;
                k=k.next;
                i=i.next;
            }
            else{
                k.next=j; //arr[k]=arr[j]
                k=k.next; //k++
                j=j.next; //j++
            }
        }
        while (i!=null){
            k.next=i;
            k=k.next;
            i=i.next;
        }
        while (j!=null){
            k.next=j;
            k=k.next;
            j=j.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
