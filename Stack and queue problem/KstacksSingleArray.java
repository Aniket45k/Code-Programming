import java.util.*;

public class KstacksSingleArray {
    private int[] arr;
    private int[] top;
    private int[] next;

    private int n, s;

    private int freespot;

    // Initialize your data structure.
    public KstacksSingleArray(int S, int N) {
        n = N;
        s = S;
        arr = new int[n];
        top = new int[s];
        next = new int[n];

        // Top initialize
        for (int i = 0; i < s; i++) {
            top[i] = -1;
        }

        // Next initialize
        for (int i = 0; i < n; i++) {
            next[i] = i + 1;
        }
        // Update last index value to -1
        next[n - 1] = -1;

        // Initialize freespot
        freespot = 0;
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack,
    // and false otherwise.
    public boolean push(int x, int m) {
        // Validate stack number
        if (m < 1 || m > n) {
            System.out.println("Invalid stack number " + m);
            return false;
        }

        // Check for overflow
        if (freespot == -1) {
            return false;
        }

        // Find index
        int index = freespot;

        // Insert element into array
        arr[index] = x;

        // Update freespot
        freespot = next[index];

        // Update next
        next[index] = top[m - 1];

        // Update top
        top[m - 1] = index;

        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise
    // returns the popped element.
    public int pop(int m) {
        // Validate stack number
        if (m < 1 || m > n) {
            System.out.println("Invalid stack number " + m);
            return -1;
        }

        // Check underflow condition
        if (top[m - 1] == -1) {
            return -1;
        }

        int index = top[m - 1];

        top[m - 1] = next[index];

        next[index] = freespot;

        freespot = index;

        return arr[index];
    }

    public static void main(String[] args) {
        // Create an instance of KstacksSingleArray with 3 stacks and a single array of
        // size 10
        KstacksSingleArray stacks = new KstacksSingleArray(3, 10);

        // Push elements into the stacks
        stacks.push(15, 2);
        stacks.push(45, 2);
        stacks.push(17, 1);
        stacks.push(49, 1);
        stacks.push(39, 1);
        stacks.push(11, 3);
        stacks.push(9, 3);
        stacks.push(7, 3);

        // Pop elements from the stacks
        System.out.println("Popped element from stack 2 is " + stacks.pop(2));
        System.out.println("Popped element from stack 1 is " + stacks.pop(1));
        System.out.println("Popped element from stack 3 is " + stacks.pop(3));
    }
}
