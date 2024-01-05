package arrays.easy;

import java.util.HashMap;

//array contans positive numbers only.find longest subarray having sum k.you have to return length of longest subarray
public class LongesSubarrayHavingSumK {

    //brute force
    public static int func1(int arr[],int k){
        //find sum of all possible subarrays
        int ans=0;
        for (int i = 0; i < arr.length; i++) {
            //i se start hone vaale saare subarrays
            int sum=0;
            for (int j = i; j < arr.length; j++) {
                if(sum==k && j-i+1>ans){
                    //since sum==k hai toh ye subarray ans ho skta hai
                    //update the length of subarray if it is bigger than previous one.
                    //also yaha loop break nhi hui toh aage jaaega maybe usko 0 mil jaaye aage
                    ans=j-i+1;
                }
                else if(sum<k){
                    //means ki aur elements add kro
                    sum=sum+arr[j];
                }
                else{
                    //means ki sum>k toh subarray starting from i having sum k is not possible
                    break;
                }
            }
        }
        return ans;
    }

    //using reverse engineering.
    //we will store prefix sum in hashmap(prefix sum->index)
    /*for(int i=0;i<arr.length;i++){
        sum=sum+arr[i];
        hashmap.put(sum,i);
    }*/
    //agar prefixsum k hi hai toh voh ans ho skta hai
    //refer notes for better understanding
    static int func2(int arr[],int k){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int ans=0;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum=sum+arr[i];
            if(sum==k){
                ans=Math.max(ans,i+1);
            }
            if(!hashMap.containsKey(sum)){hashMap.put(sum,i);}


            if(hashMap.containsKey(k-sum)){
              ans=Math.max(ans,hashMap.get(k-sum)-i+1);
            }
        }

        return ans;
    }


    public static void main(String[] args) {

    }
}
