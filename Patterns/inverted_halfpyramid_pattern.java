import java.util.*;
public class inverted_halfpyramid_pattern {
    public static void inverted_halfpyramid(int n){
         //outer loop
         for(int i=1; i<=n; i++){
            //inner-numbers
            for(int j=1; j<=n-i+1; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        inverted_halfpyramid(10);
    }
}