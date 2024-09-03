

import java.util.*;
public class decimalTobinary {
    public static void decTobin(int n) {
        int myNum = 0;
        int pow = 0;
        int binNum = 0;

        while (n > 0) {
            int rem = n % 2;
            binNum = binNum + (rem * (int) Math.pow(10, pow));

            pow++;
            n = n / 2;
        }
        System.out.println("decimal of " + myNum + " = " + binNum);
    }

    public static void main(String args[]) {
        decTobin(8);
    }
}
