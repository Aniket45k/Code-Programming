import java.util.*;
public class floyds_triangle_pattern {
    public static void floyds_triangle(int n){
        int counter = 1;
        for(int i=1; i<=n;i++){
            //inner -how many times will counter will b  printed
            for(int j=1; j<=i; j++){
                System.out.print(counter+" ");
                counter++;
            }
            System.out.println();
        }

    }
    public static void main(String args[]){
        floyds_triangle(6);
    }
}
