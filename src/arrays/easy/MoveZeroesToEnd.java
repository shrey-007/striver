package arrays.easy;

import sorting.Helper;

public class MoveZeroesToEnd {
    //Q=Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements
    //m-1= this is same as removeduplicatesfromsortedarray(same algorithm)
    public static void func(int arr[]){
        int i=-1;              //stores last non zero element
        int j=0;              //iterator
        while(j< arr.length){
            if(arr[j]!=0){
                //means ki isko store krna hai, and store i krega toh i ko badao and store kro
                i++;
                //swap j and i
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
            j++;
        }
    }

    //for other methods refer notes
    
    public static void main(String[] args) {
         int arr[]={0,0,1,1,1,2,2,3,3,4};
         func(arr);
        Helper.print(arr);
    }
}
