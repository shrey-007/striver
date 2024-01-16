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


//    method2=using merge sort
      public static Node getMiddleNode(Node head){
        //generally we start fast and slow from head itself, but agar ll ka size even hai toh slow n/2 na dekar n/2+1 deta hai
        // ex 1,2,3,4,5,6 isme agar fast and slow dono head se start kroge toh slow 4 ko point krega.
        //but middle 3 hona chaiye, islie fast ko ek jyaada se start kra
        Node fast=head.next;
        Node slow=head;
        while(fast!=null || fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
      }

      //method2=merge sort
      public static Node func2(Node head){
        /*
         imagine kro ki ye array pr lagani hai merge sort toh kya kya loge
         1)array<->ll = jo ki head se mil jaaegi
         2)mid element=jo ki function se mil jaaega
         3)start and end nhi lenge isme(start and end ka main aim ye tha ki aaray kese do part mai divide hoga, yaha
           apan ne middleNode  se hi decide kr liya kese divide hoga)
        * */
          if(head==null || head.next==null){
              //so ll contains 1 or 0 element means it is already sorted
              return head;
          }
          //you got the middle node of ll
          Node middleNode=getMiddleNode(head);

          //now break the ll into two parts, but break krne se pehle dono ke head store krlo
          Node leftHead=head;  //start
          Node rightHead=middleNode.next;  //mid+1
          //break ll into 2 parts
          middleNode.next=null;

          //sort the left ll
          Node leftSorted=func2(head);
          //sort the right ll
          Node rightSorted=func2(rightHead);
          //now we have 2 sorted ll, merge them
          return MergeTwoSortedLL.func(leftSorted,rightSorted);
      }

    public static void main(String[] args) {

    }
}
