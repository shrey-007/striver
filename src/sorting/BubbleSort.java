
package sorting;



public class BubbleSort {
    public static int [] func(int arr[]){

        //code==========================================================
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        //code===========================================================

        return arr;
    }

    public static void main(String[] args) {
        int arr[]={2,3,1,7,5};

        func(arr);
        Helper.print(arr);
    }
}
