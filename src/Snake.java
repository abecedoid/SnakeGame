import java.util.ArrayDeque;

public class Snake {

    int maxX;
    int maxY;
    String directionPlayer = "left";
    String directionCommited = "left";
    boolean growFlag = false;
    boolean collision = false;
    ArrayDeque<Coords> repr;

    public Snake(Coords initialPos, int maxX, int maxY){
        repr = new ArrayDeque<Coords>();
        this.maxX = maxX;
        this.maxY = maxY;
        repr.addFirst(initialPos);
    }

    public ArrayDeque<Coords> getRepr() {
        return repr;
    }

    public boolean isOnCoord(Coords c){
        ArrayDeque<Coords> copyRepr = repr.clone();
        for(int i=0; i < copyRepr.size(); i++){
            Coords temp = copyRepr.pop();
            //Coords temp = repr.get(i);
            if(temp.getX() == c.getX() && temp.getY() == c.getY())
                return true;
        }
        return false;
    }

    public void directionLeft(){
        if(!directionCommited.equals("right"))
            directionPlayer = "left";
    }

    public void directionUp(){
        if(!directionCommited.equals("down"))
            directionPlayer = "up";
    }

    public void directionRight(){
        if(!directionCommited.equals("left"))
            directionPlayer = "right";
    }
    public void directionDown(){
        if(!directionCommited.equals("up"))
            directionPlayer = "down";
    }

    public void commitDirection(){
        directionCommited = directionPlayer;
    }

    public void move(){

        Coords c = new Coords(repr.peekFirst().getX(), repr.peekFirst().getY());

        if(directionPlayer.equals("left")){
            int xNew = c.getX() - 1;
            if(xNew >= 0)
                c.setX(xNew);
            else
                collision = true;
        }
        else if(directionPlayer.equals("up")){
            int yNew = c.getY() - 1;
            if(yNew >= 0)
                c.setY(yNew);
            else
                collision = true;
        }
        else if(directionPlayer.equals("right")){
            int xNew = c.getX() + 1;
            if(xNew < maxX)
                c.setX(xNew);
            else
                collision = true;
        }
        else if(directionPlayer.equals("down")){
            int yNew = c.getY() + 1;
            if(yNew < maxY)
                c.setY(yNew);
            else
                collision = true;
        }

        if(growFlag){
            System.out.println("Growing, ha ha");
            repr.addFirst(c);
        }
        else{
            repr.addFirst(c);
            repr.removeLast();
        }
        growFlag = false;
        commitDirection();

    }

    public void grow(){
        growFlag = true;
        System.out.println("Growing,m mggmhmhm");
    }

}
