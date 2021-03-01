import java.util.ArrayList;

public class tset {
    public static void main(String[] args){
        Coords c = new Coords(3, 3);
        Coords cc = new Coords(3,3);

        ArrayList<Coords> arr = new ArrayList<Coords>();
        arr.add(c);
        boolean cont = arr.contains(cc);

        System.out.println("hihi");
    }
}
