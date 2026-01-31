package oops.inheritance;

class Animal{
    public void eat(){
        System.out.println("I am eating");
    }
    public void walk(){
        System.out.println("I am walking");
    }
}
class Cat extends Animal{
    int paws=4;
    Boolean meow = true;
}
class Dog extends Animal{
    int legs=4;
    Boolean canBark = true;
}
// Example.txt for Inheritance
class Call {
    public static void main(String[] args) {
        System.out.println("oops.inheritance.Cat inheritance");
        Cat ob1 = new Cat();
        ob1.eat();
        ob1.walk();
        System.out.println(ob1.paws);
        System.out.println();
        System.out.println("oops.inheritance.Dog inheritance");
        Dog ob2 = new Dog();
        ob2.walk();
        ob2.eat();

        System.out.println(ob2.canBark);
    }
}
