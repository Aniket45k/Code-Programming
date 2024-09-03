import java.util.*;
public class backTrackOnArray {
    public static void changeArray(int arr[], int i, int val){
        if(i==arr.length){
           print(arr);
           return;
        }
        arr[i]=val;
        changeArray(arr, i+1, val+1);//fnx call step
        arr[i]=arr[i]-2;//backtracking step 
    }
    public static void print(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]=new int[5];
        changeArray(arr, 0, 1);
        print(arr);
    }
   
}
