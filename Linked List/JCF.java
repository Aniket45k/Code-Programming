import java.util.LinkedList;
public class JCF {
    public static void main(String args[]){
        //create - 
        LinkedList<Integer> ll = new LinkedList<>();

        //add
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(0);

        System.out.println(ll);

        //remove
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);
    }
}
