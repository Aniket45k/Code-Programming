public class MultiLevel {
    public static void main(String[] args) {
        Dog dobby = new Dog();
        dobby.eat();
        dobby.legs=4;
        System.out.println(dobby.legs);

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
    int legs;
}
//Derived class
class Dog extends Mammals{
    int bark;
}