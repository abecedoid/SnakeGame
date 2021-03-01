import java.util.ArrayList;

public class Snake {

    int maxX;
    int maxY;
    ArrayList<Coords> repr;

    public Snake(Coords initialPos, int maxX, int maxY){
        repr = new ArrayList<Coords>();
        this.maxX = maxX;
        this.maxY = maxY;
        repr.add(initialPos);
    }

    public ArrayList<Coords> getRepr() {
        return repr;
    }

    public boolean isOnCoord(Coords c){
        for(int i=0; i < repr.size(); i++){
            Coords temp = repr.get(i);
            if(temp.getX() == c.getX() && temp.getY() == c.getY())
                return true;
        }
        return false;
    }

    //todo
    public void moveLeft(){
        // so far work only with one pixel
        Coords c = repr.get(0);
        // decrease the x coord by one
        int xNew = c.getX() - 1;
        if(xNew >= 0)
            c.setX(xNew);
    }

    public void moveUp(){

    }

    public void moveRight(){

    }

    public void moveDown(){

    }
}
