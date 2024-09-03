public class Constructor {
    public static void main(String[] args) {
        Horse h = new Horse();
        Mustag m = new Mustag();
       //Animal -> Horse -> mustag 

    }
}

abstract class Animal {
    Animal() {
        System.out.println("Animal constructor called");
    }

}

class Horse extends Animal {
    Horse() {
        System.out.println("Horse constructor called");
    }
}

class Mustag extends Horse {
    Mustag() {
        System.out.println("Mustag constructor called");
    }
}
