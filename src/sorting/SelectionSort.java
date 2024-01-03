package sorting;

public class SelectionSort {
    public static int[] func(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            //find smallest element from ith index to end
            int smallestElementIndex=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[smallestElementIndex]){
                    smallestElementIndex=j;
                }
            }

            //swap the current element with smallest element
            int temp=arr[i];
            arr[i]=arr[smallestElementIndex];
            arr[smallestElementIndex]=temp;

        }
        return arr;

    }

    public static void main(String[] args) {
        int arr[]={2,3,1,7,5};

        func(arr);
        Helper.print(arr);
    }
}
