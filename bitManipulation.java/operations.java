import java.util.*;

public class operations {
    public static int getIthBit(int n, int i) {
        int bitmask = 1 << i;
        if ((n & bitmask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitmask = 1 << i;
        return n | bitmask;

    }

    public static int clearIthBit(int n, int i) {
        int bitmask = ~(1 << i);
        return n & bitmask;

    }

    public static int updateIthBit(int n, int i, int newBit) {
        n = clearIthBit(n, i);
        int bitmask = newBit << i;
        return n | bitmask;
    }

    public static int clearIBit(int n, int i) {

        int bitmask = (~0) << i;
        return n & bitmask;
    }

    public static int clearIBitsinRange(int n, int i, int j) {

        int a = ((~0) << (j + i));
        int b = (1 << i) - 1;
        int bitmask = a | b;
        return n & bitmask;
    }

    public static boolean isPowerOfTwo(int n) {

        return (n & (n - 1)) == 0;
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int fastExpo(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {// check lsb
                ans = ans * a;

            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getIthBit(10, 2));
        System.out.println(setIthBit(10, 2));
        System.out.println(clearIthBit(10, 2));
        System.out.println(updateIthBit(10, 2, 1));
        System.out.println(clearIBit(15, 2));
        System.out.println(clearIBitsinRange(10, 2, 4));
        System.out.println(isPowerOfTwo(32));
        System.out.println(countSetBits(15));
        System.out.println(fastExpo(3, 5));
    }
}
