package oops.classandobj;

class ApplForm {
    private String name;
    private int rollno;

    public void display(){
        System.out.println("Name = "+name);
        System.out.println("Roll number = "+rollno);
        System.out.println();
    }
    public void setVal(String st,int n){
        name=st;
        rollno=n;
    }
    public String getVal() {
        return name;
    }
}
// Example.txt for Class and Objects
class Main{
    public static void main(String[] args) {
        ApplForm app = new ApplForm();
        app.setVal("Kiran Surya",58);
        app.display();

        ApplForm ap1 = new ApplForm();
        ap1.setVal("Heisenberg",77);
        ap1.display();
        String st=ap1.getVal();
        System.out.println(st);
    }
}
