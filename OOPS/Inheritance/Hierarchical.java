public class Hierarchical {
    public static void main(String[] args) {
        Mammals Dog = new Mammals();
        Dog .eat();
        Fish shark = new Fish();
        shark.breath();


    }
}
//Base class
class Animal {
    void eat() {
        System.out.println("eats");
    }

    void breath() {
        System.out.println("breaths");
    }
}
//Derived class
class Mammals extends Animal{
    void walk(){
        System.out.println("walk");
    }
}
//Derived class
class Fish extends Animal{
    void walk(){
        System.out.println("swim");
    }
}
//Derived class
class Bird extends Animal{
    void walk(){
        System.out.println("fly");
    }
}


