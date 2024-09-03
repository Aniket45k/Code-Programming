import java.util.*;

public class inbuiltSort {
    public static void insertionSort(Integer arr[]){
        for(int i=1; i<arr.length; i++){
            int curr = arr[i];
            int prev = i-1;
            //finding out the correct pos to insert
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
                
            }
            //insertion
            arr[prev+1]=curr;
        }
    }

    public static void printArr(Integer arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");

        }
        System.out.println();
        
    }
    public static void main(String args[]){
        Integer arr[]={5, 4, 1, 3, 2};
        //insertionSort(arr);
        //Arrays.sort(arr);
        //Arrays.sort(arr,0,3);
        //Arrays.sort(arr,Collections.reverseOrder());
        Arrays.sort(arr,0,3,Collections.reverseOrder());
        printArr(arr);
    }
}
//int arr[]-->int is primittive type
//reverseOrder function method only works on objects
//Integer arr[]-->Integer is a class and arr is object of that class 

// reverseOrder function uses the comparator
// public static int compare(int a, int b)
// {
//     a<b -ve;
//     a==b 0;
//     a>b +ve;
//     return b-a;
// }