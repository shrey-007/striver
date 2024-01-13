package arrays.medium;

import java.util.Arrays;

public class NextPermutation {
    public void func(int nums[]){

        boolean flag=false;

        for(int i=nums.length-2;i>=0;i--){
            //check kro ki koi bada element hai kya right side
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    //agar koi bada mila toh flag true krdo
                    flag=true;
                }
            }
            //agar koi bada element hai toh swap kro else left jaao.toh else ki jarurat nhi h apne aap i-- ho jaaega
            if(flag==true){
                //means ki bade element hai right side mai toh,dekho ki bado mai sabse chota kon hai.
                int min_of_max=Integer.MAX_VALUE;
                int i_min_of_max=-1;  //this is index of min_of_max
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]>nums[i] && nums[j]<min_of_max){min_of_max=nums[j];i_min_of_max=j;}
                }
                //toh i_min_of_max par hai vo element
                //swap i and i_min_of_max
                int temp=nums[i];
                nums[i]=nums[i_min_of_max];
                nums[i_min_of_max]=temp;
                //ab i+1 se end tak sort krdo
                Arrays.sort(nums,i+1,nums.length);
                break;
            }
        }

        if(flag==false){
            //means ki array decsending order mai h
            Arrays.sort(nums);
        }
    }

    public static void func2(int nums[]){

    }


    public static void main(String[] args) {

    }
}
