package oops.constructor;

class Sample{
    int rollno;
    int year;
    Sample(int rno,int yr){
        System.out.println("This is a Default Constructor");
        rollno=rno;
        year=yr;
    }
}
class Construct {
    public static void main(String[] args) {
        Sample obj =new Sample(58,2004);
        System.out.println(obj.rollno);
        System.out.println(obj.year);
    }
}
// Example.txt for Constructor