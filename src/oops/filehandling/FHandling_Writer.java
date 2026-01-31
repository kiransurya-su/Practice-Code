package oops.filehandling;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
public class FHandling_Writer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        try{
            File f = new File("Example.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(name);
            fw.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}