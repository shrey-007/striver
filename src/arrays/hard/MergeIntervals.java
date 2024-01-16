package arrays.hard;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
// and return an array of the non-overlapping intervals that cover all the intervals in the input.
//        Example 1:
//        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//        Output: [[1,6],[8,10],[15,18]]
class Interval{
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class MergeIntervals {

    public static int[][] func1(int[][] intervals){
        //you first sort them on basis of their first index(start time of interval).
//        then merge them using stack

        Stack<Interval> stack=new Stack<>();
        Interval interval=new Interval(intervals[0][0],intervals[0][1]);
        for (int i = 1; i <intervals.length ; i++) {
            //create new Interval
            Interval temp=new Interval(intervals[i][0],intervals[i][1]);
            //get peak of stack
            Interval peek=stack.peek();
            if(temp.end<= peek.end && temp.start>= peek.start){
                //temp is complete subset of peak
                continue;
            }
            else if(temp.end>= peek.end && temp.start<= peek.start){
//               peak is complete subset of temp
                stack.pop();
                stack.push(temp);
            }
            else if(temp.end>=peek.start && temp.end<=peek.end){
                stack.pop();
                Interval temp2=new Interval(temp.start, peek.end);
                stack.push(temp);
            }
            else if(peek.end>=temp.start && peek.end<=temp.end){
                stack.pop();
                Interval temp2=new Interval(peek.start, temp.end);
                stack.push(temp2);
            }
            else {
                stack.push(temp);
            }
        }
        int[][] ans=new int[stack.size()][2];
        int index=0;
        while (stack.size()>=0){
            Interval interval1=stack.pop();
            ans[index][0]=interval1.start;
            ans[index][1]=interval1.end;
            index++;
        }
        return ans;
    }


    static int[][] func2(int [][]intervals){
        //sort the array on basis of startTime, if startTime is same sort on endTime.you can implement this using comparator
        Stack<Interval> stack=new Stack<>();
        //add first interval initially
        stack.add(new Interval(intervals[0][0],intervals[0][1]));

        for (int i = 1; i < intervals.length; i++) {
            //we know that array is sorted toh overlap ka ek hi case banega jab stack ke peek ka end
            //current ke start se bada hoga.
            // toh uper jo itne cases bane hai voh sirf ek mai convert ho gya
            Interval currentInterval=new Interval(intervals[i][0],intervals[i][1]);

            if(stack.peek().end>= currentInterval.start){
                //means overlapping hui hai and start point stack ke peek ka start hi hoga,but end ka pata nhi
                int startTime=stack.peek().start;
                int endTime= Math.max(stack.peek().end,currentInterval.end);
                //pop the peak coz vo merge ho jaaegi new interval ke saath
                stack.pop();
                //add new interval to stack
                stack.push(new Interval(startTime,endTime));
            }
            else{
                //means no overlapping toh direct add krdo stack m
                stack.push(new Interval(currentInterval.start, currentInterval.end);
            }
//            ab ans stack mai store hai toh stack ko iterate krke ans nikaal lo
        }





    }

    public static void main(String[] args) {


    }
}
