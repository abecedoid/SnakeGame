public class Meal {

    Coords coords;

    public Meal(Coords c){

        coords = c;

    }

    public boolean isOnCoord(Coords c){
        if(coords.getX() == c.getX() && coords.getY() == c.getY())
            return true;
        return false;
    }


}
