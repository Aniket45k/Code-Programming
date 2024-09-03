public class SingleLevel {
    public static void main(String[] args) {
        Fish shark=new Fish();
        shark.eat();
        
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
class Fish extends Animal {
    int fins;

    void swim() {
        System.out.println("I can swim in water");
    }
}
