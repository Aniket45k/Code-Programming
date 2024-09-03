public class Constructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Aniket");
        
    }
}
class Student{

    String name;
   
    //non parameterized constructor
    Student(){
        System.out.println("constructor is called......");
    }
    //parameterized constructor
    Student(String name){
        this.name=name;
    }
   
}
