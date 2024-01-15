package arrays.hard;

import java.util.*;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
// and nums[i] + nums[j] + nums[k] == 0.
//        Notice that the solution set must not contain duplicate triplets.
//example=[-1,0,1,2,-1,-4]. here you can not take [-1,0,1] and [0,1,-1] both because it is repeating.
public class ThreeSum {

    //method1=try out all ways and store them in set, so that same answers dont repeat =O(n3)
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> hs=new HashSet<>();



        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        //ek baar temp ye [-1,0,1] hoga.and ek baar temp mai [0,1,-1] hoga but ye dono nhi aane chaiye
                        //toh temp ko sort kro toh [-1,0,1] banege, dono same hoge toh set apne aap identify kr lega
                        //and duplicate store nhi krega.but set ko pta nhi hai ki voh dono same h, uske liye sort krna padega
                        Collections.sort(temp);
                        hs.add(temp);
                    }
                }
            }
        }


        List<List<Integer>> ans=new ArrayList<>(hs);

        return ans;
    }


//    method2=first loop mai i decide kro and j and k ke liye 2 sum laga do.TC=O(n2),but we are using set to not include duplicates.
public List<List<Integer>> threeSum2(int[] nums) {
    HashSet<List<Integer>> hs=new HashSet<>();



    for(int i=0;i<nums.length;i++){
        //ek element already mil gaya(i) toh 2-sum algorithm lagao remaining sum -arr[i] ke liye.
        HashSet<Integer> hashSet=new HashSet<>();
        for(int j=i+1;j<nums.length;j++){
          //now current element is arr[j],so total sum is arr[i]+arr[j] now check whether hashset contains   -(arr[i]+arr[j])
          if (hashSet.contains(-nums[i]-nums[j])){
              //if yes then we have found our one triplet
              ArrayList<Integer> list=new ArrayList<>();
              list.add(nums[i]);
              list.add(nums[j]);
              list.add(-nums[i]-nums[j]);
              Collections.sort(list);
              hs.add(list);
          }
          //add current element in hashset
          hashSet.add(nums[j]);
        }
    }
    List<List<Integer>> ans=new ArrayList<>(hs);

    return ans;

    }


//    method3=we were using O(n) space beacause of set as we dont have to include duplicates.
//    so instead of doing it why dont you simply sort the array in nlogn.

    public static List<List<Integer>> func(int arr[]){
        List<List<Integer>> ans=new ArrayList<>();
//        sort the array
        Arrays.sort(arr);

        //run loop for i
        for (int i = 0; i < arr.length; i++) {
            //read this line later.
            if(i>0 && arr[i]==arr[i-1]){continue;}
        //i is now fixed.now take one pointer at i+1 and one at end.
            int j=i+1;
            int k=arr.length-1;
        //run loop till i<j
            while (j<k){
                if(arr[i]+arr[j]+arr[k]>0){
                    //if sum is big, and we know array is sorted, so last pointer ko kam krdo
                    k--;
                }
                else if(arr[i]+arr[j]+arr[k]<0){
//                    if sum is small toh j ko bada do
                    j++;
                }
                else{
                    //if sum is equal to 0, toh list mai add krdo
                    List<Integer> temp=new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    //now since is loop ke under i fix hai toh agar j purana vaala hi le liye toh k bhi purana vaala hi aaega
                    //toh repeat ho jaaega toh jab tak j puraani value ke equal h tab tak use badate rho
                    //same for k.
                    while(arr[j]==arr[j-1]){j++;}
                    while(arr[k]==arr[k+1]){k--;}
                }
//                ye while loop khatam hone ke baad i ko fix maan kr, j and k ke jitne bhi distinct pairs ban skte the sab add ho
//                gye hoge list mai toh agar vaapis se same i hai toh same results aaege toh same i ko skip kro isliye voh for loop ke
//                just baad vo line likhi hai
            }
        }
        return ans;

    }



    public static void main(String[] args) {

    }
}
