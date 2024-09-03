import java.util.*;

public class implementTwoStackInArray {
    public static class TwoStack {
        int[] data;
        int tos1;
        int tos2;

        TwoStack(int cap) {// constructor
            data = new int[cap];
            tos1 = -1;
            tos2 = data.length;
        }

        int size1() {
            return tos1 + 1;
        }

        int size2() {
            return data.length - tos2;
        }

        void push1(int val) {
            if (tos2 == tos1 + 1) {
                System.out.println("stack overflow");
            } else {
                tos1++;
                data[tos1] = val;
            }
        }

        void push2(int val) {
            if (tos2 == tos1 + 1) {
                System.out.println("stack overflow");
            } else {
                tos2--;
                data[tos2] = val;
            }
        }

        int pop1() {
            if (size1() == 0) {
                System.out.println("stack overflow");
                return -1;
            } else {
                int val = data[tos1];
                tos1--;
                return val;
            }
        }

        int pop2() {
            if (size2() == 0) {
                System.out.println("stack overflow");
                return -1;
            } else {
                int val = data[tos2];
                tos2++;
                return val;
            }
        }

        int top1() {
            if (size1() == 0) {
                System.out.println("stack overflow");
                return -1;
            } else {
                int val = data[tos1];
                return val;
            }
        }

        int top2() {
            if (size2() == 0) {
                System.out.println("stack overflow");
                return -1;
            } else {
                int val = data[tos2];
                return val;
            }
        }
    }

    public static void main(String[] args) {
        TwoStack ts = new TwoStack(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from stack1 is "
                + ": " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from stack2 is "
                + ": " + ts.pop2());
        System.out.println("Popped element from stack2 is "
                + ": " + ts.top1());

    }

}
