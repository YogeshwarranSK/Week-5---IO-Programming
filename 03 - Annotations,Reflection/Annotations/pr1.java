package Day25.Annotations;
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

public class pr1 {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.makeSound();
    }
}


