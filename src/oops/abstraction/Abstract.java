package oops.abstraction;

abstract class Computer{
    abstract void turnOff();
    public void turnOn(){
        System.out.println("Turning on..");
    }
}
class Victus extends Computer{
    public void turnOff(){
        System.out.println("Victus off..");
    }
}

class Mac extends Computer{
    public void turnOff(){
        System.out.println("Mac off..");
    }
}
class Abstract {
    public static void main(String[] args) {
        System.out.println("Victus properties");
        Victus vic = new Victus();
        vic.turnOn();
        vic.turnOff();

        System.out.println();
        System.out.println("Mac properties");
        Mac mc = new Mac();
        mc.turnOn();
        mc.turnOff();
    }

}
