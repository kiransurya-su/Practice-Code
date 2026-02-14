import java.util.*;
class Student{
    int studentId;
    String name;
    int mark1;
    int mark2;
    int mark3;
    int total;
    double average;
    String grade;
    Student(int studentId,String name,int m1,int m2,int m3){
        this.studentId=studentId;
        this.name=name;
        this.mark1=m1;
        this.mark2=m2;
        this.mark3=m3;
        calculateResult();
    }
    void calculateResult(){
        total=mark1+mark2+mark3;
        average=total/3.0;
        if(average>=80){
            grade="A";
        }else if(average>=60){
            grade="B";
        }else if(average>=40){
            grade="C";
        }else{
            grade="Fail";
        }
    }

    void display(){
        System.out.println("StudentID: "+studentId+" Name: "+name+" Total: "+total+" Average: "+average+" Grade: "+grade);
        System.out.println("----------------------------------------------------------------------------------------");
    }
}
public class StudentGradeAnalyser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students");
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();
        for(int i=0;i<n;i++){
            System.out.println("\nEnter details for Student: "+(i+1));

            System.out.print("Student ID: ");
            int id=sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name=sc.nextLine();

            System.out.print("Mark 1: ");
            int m1=sc.nextInt();

            System.out.print("Mark 2: ");
            int m2=sc.nextInt();

            System.out.print("Mark 3: ");
            int m3=sc.nextInt();

            students.add(new Student(id,name,m1,m2,m3));
        }
        students.sort((a,b)->Double.compare(a.average,b.average));
        for(Student s:students){
            s.display();
        }
    }
}
