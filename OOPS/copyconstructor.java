public class copyconstructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Aniket";
        s1.roll = 45;
        s1.password = "qwery";
        s1.marks[0]=100;
        s1.marks[1]=90;
        s1.marks[2]=80;

        Student s3=new Student("Aniket");

        Student s2 = new Student(s1);
        s2.password="xyz";

        s1.marks[2]=70;

        //for shallow copy
        // for(int i=0; i<3; i++){
        //     System.out.println(s2.marks[i]);
        // }
  
    }
}
class Student {
    String name;
    String password;
    int roll;
    int marks[];

    //non parameterized constructor
    Student(){
        marks=new int[3];
        System.out.println("constructor is called......");
    }


    //shallow copy constructor
    // Student(Student s1) {
    //     marks=new int[3];
    //     this.name=s1.name;
    //     this.roll=s1.roll;
    //     this.marks=s1.marks;
    // } 

    //deep copy constructor
    Student(Student s1) {
        marks=new int[3];
        this.name=s1.name;
        this.roll=s1.roll;
        
        for(int i=0; i<3; i++){
            System.out.println(s1.marks[i]);
        }
        
    }

    
    //parameterized constructor
    Student(String name){
        marks=new int[3];
        System.out.println(this.name=name);
    }
   
}
