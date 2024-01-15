package linkedList.doublyLL;

public class ReverseDLL {
//    it is very easy , we just need to implement reverseSingleLL twice.
    public static Node reverse(Node head){
        //consider example 4<->3<->2<->1
        //sabse pehle next vaale attribute ko dekho only, 4->3->2->1. sabke next ko reverse kro by revereSLL algorithm
        Node temp=head;
        Node after=head;
        Node before=null;

        while (temp!=null){
            after=after.next;
            temp.next=before;
            before=temp;
            temp=after;
        }
//        after this temp,after are pointing to null  and before is pointing to last element, jo ki new head hoga
        head=before;

//        ese krne se DLL kuch esi ho jaaegi.4<-3<-2<-1. coz sab nodes ke next and previous same jagah pr point kr rhe hai ab.
//        ab prevoius dekho only 4<-3<-2<-1. sabke previous ko reverse  kro using reverseSLL.

         temp=before;
         after=before;
         before=null;
        // current scenario = after(lastElement)   temp(lastElement)   before(null)
//        ab reverse kro
         while (temp!=null){
             after=after.previous;
             temp.previous=after;
             before=temp;
             temp=after;
         }
         return head;
    }
    public static void main(String[] args) {

    }
}
