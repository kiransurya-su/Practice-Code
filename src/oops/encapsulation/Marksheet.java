package oops.encapsulation;

class Student{
    private String name;
    private int mark;
    public void setName(String n){
        name=n;
    }
    public String getName(){
        return name;
    }
    public void setMark(int m){
        if(m>=0 && m<=100){
            mark=m;
        }
        else{
            System.out.println("Invalid mark!!");
        }
    }
    public int getMark(){
        return mark;
    }
}
public class Marksheet {
    public static void main(String[] args) {
        Student st1 = new Student();
        st1.setName("Kiran Surya");
        st1.setMark(70);
        System.out.println("Name="+ st1.getName());
        System.out.println("Mark="+ st1.getMark());
        System.out.println();
        Student st2 = new Student();
        st2.setName("Quentin Tarantino");
        st2.setMark(100);
        System.out.println("Name="+ st2.getName());
        System.out.println("Mark="+ st2.getMark());
    }
}
