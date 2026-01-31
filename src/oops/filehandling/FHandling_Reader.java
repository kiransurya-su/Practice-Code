package oops.filehandling;

import java.util.*;
import java.io.File;
public class FHandling_Reader {
    public static void main(String[] args) {
        try{
            File f = new File("Example.txt");
            Scanner reader = new Scanner(f);
            while(reader.hasNextLine()){
                System.out.println(reader.nextLine());
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
