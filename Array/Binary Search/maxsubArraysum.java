//***********************BRUTE FORCE**********************

// import java.util.*;
// //print subarrays

// public class maxsubArraysum {
//     public static void maxSum(int numbers[]) {
//         int currSum = 0;
//         int maxSum = Integer.MIN_VALUE;

//         for (int i = 0; i < numbers.length; i++) {
//             int start = i;
//             for (int j = i; j < numbers.length; j++) {
//                 int end = j;
//                 currSum=0;
//                 for (int k = start; k <= end; k++) {// print
//                     //subarraysum
//                     currSum += numbers[k];
//                 }
//                 System.out.println(currSum);
//                 if (maxSum < currSum) {
//                     maxSum = currSum;
//                 }
//             }

//         }
//         System.out.println("max sum = " + maxSum);

//     }

//     public static void main(String args[]) {
//         int numbers[] = { 1, -2, 6, -1, 3 };
//         maxSum(numbers);
//     }
// }

//*******************************PREFIX SUM********************

// import java.util.*;
// //print subarrays

// public class maxsubArraysum {
//     public static void maxSum(int numbers[]) {
//         int currSum = 0;
//         int maxSum = Integer.MIN_VALUE;
//         int prefix[]=new int [numbers.length];

//         prefix[0]=numbers[0];

//         //calculate prefix array
//         for(int i=1; i<prefix.length; i++){
//             prefix[i]=prefix[i-1]+numbers[i];
//         }

//         for (int i = 0; i < numbers.length; i++) {
//             int start = i;
//             for (int j = i; j < numbers.length; j++) {
//                 int end = j;

//                     //subarraysum
//                     currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];

//                 if (maxSum < currSum) {
//                     maxSum = currSum;
//                 }
//             }

//         }
//         System.out.println("max sum = " + maxSum);

//     }

//     public static void main(String args[]) {
//         int numbers[] = { 1, -2, 6, -1, 3 };
//         maxSum(numbers);
//     }
// }

//*************************KADANE'S ALGORITHM***************************** */

import java.util.*;

public class maxsubArraysum {
    public static int maxSubArraySum(int arr[]) {
        int cs = 0;
        int ms = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            cs = Math.max(arr[i], cs + arr[i]);
            ms = Math.max(ms, cs);
        }

        return ms;
    }

    public static void main(String[] args) {
        int arr[] = { -8, 2, 5, 1 };
        int result = maxSubArraySum(arr);
        System.out.println("Maximum subarray sum: " + result);
    }
}
