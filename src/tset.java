import java.util.ArrayList;
import java.util.ArrayDeque;

public class tset {
    public static void main(String[] args){
        Coords c = new Coords(1, 3);
        Coords cc = new Coords(2,3);
        Coords ccc = new Coords(3,3);
        Coords cccc = new Coords(4,3);
        Coords ccccc = new Coords(5,3);

        ArrayDeque<Coords> arrDeq = new ArrayDeque<Coords>();
        arrDeq.add(c);
        arrDeq.add(cc);
        arrDeq.add(ccc);
        arrDeq.add(cccc);
        arrDeq.add(ccccc);

        Coords temp = arrDeq.pop();
        temp = arrDeq.poll();
        temp = arrDeq.poll();
        temp = arrDeq.poll();
        temp = arrDeq.poll();
        temp = arrDeq.poll();

        System.out.println("hihi");
/*        Coords c = new Coords(3, 3);
        Coords cc = new Coords(3,3);

        ArrayList<Coords> arr = new ArrayList<Coords>();
        arr.add(c);
        boolean cont = arr.contains(cc);

        System.out.println("hihi");*/
    }
}
