package linkedList.singleLL.medium;

import linkedList.singleLL.Node;

import java.util.ArrayList;
import java.util.Collections;

public class sortLL {

//    method1=convert whole linkedList into array/arrayList for that you have to tarverse whole ll.=O(n)
//    now apply sorting on array/arraylist.=O(nlogn)
//    now convert the array again to ll, but this time you dont need to create new ll, you can change the given ll.
    public static Node func1(Node head){
        ArrayList<Integer> arrayList=new ArrayList<>();

        //traverse whole ll and store it in arraylist

        Node temp=head;
        while (temp!=null){
          arrayList.add(temp.value);
          temp=temp.next;
        }

        //sort the arraylist
        Collections.sort(arrayList);

        //ab given ll mai hi changes krdo
        temp=head;
        int i=0;
        while (temp!=null){
            temp.value= arrayList.get(i);
            temp=temp.next;
            i++;
        }
        return head;
    }
    public static void main(String[] args) {

    }
}
