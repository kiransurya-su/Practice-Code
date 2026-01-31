package oops.inheritance.multipleinheritance;
interface Writer{
    void write();
}
interface Director {
    void direct();
}
class FilmMaker implements Writer,Director {
    public void write(){
        System.out.println("Wriiten by Writer");
    }
    public void direct(){
        System.out.println("Directed by Director");
    }
}
public class Cinema {
    public static void main(String[] args) {
        FilmMaker film = new FilmMaker();
        film.write();
        film.direct();
    }
}
