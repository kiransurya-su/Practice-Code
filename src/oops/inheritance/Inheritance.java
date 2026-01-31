package oops.inheritance;
class GrandFather{
    String gender="Male";
    public void display(){
        System.out.println("GrandFather class");
    }
}
class Mother extends GrandFather{
    String gender="Female";
}
class Uncle extends GrandFather{
    String gender="Male";
}
class Daughter extends Mother {
    String gender="Female";
}
class Inheritance {
    public static void main(String[] args) {
//        Daughter s=new Daughter();
//        System.out.println(s.gender);
//        s.display();

        Mother m = new Mother();
        System.out.println(m.gender);
        System.out.println();

        Uncle u = new Uncle();
        System.out.println(u.gender);
    }
}

// Multilevel Inheritance