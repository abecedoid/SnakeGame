import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;

public class Grid extends JPanel{

    int width;
    int height;
    Snake snake;
    Meal meal;
    Timer timer;

    public Grid(int x, int y) {
        super();
        width = x;
        height = y;
    }

    public void drawState(Snake s, Meal m){
        //System.out.println("redrawing state...");
        //System.out.println("snake: x -> " + s.getRepr().get(0).getX() + " y -> " + s.getRepr().get(0).getY());
        snake = s;
        meal = m;
        repaint();
    }

    public Dimension getPreferredSize(){
        return new Dimension(300, 300);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //System.out.println("painting grid..");
        int actSizeX = this.getWidth() / width;
        int actSizeY = this.getWidth() / height;

        g.setColor(Color.WHITE);
        for(int m=0; m<actSizeX; m++){
            for(int n=0; n<actSizeY; n++){
                g.fillRect(m*actSizeX, n*actSizeY, actSizeX, actSizeY);
            }
        }

        ArrayDeque<Coords> arrDeq = snake.getRepr().clone();
        g.setColor(Color.BLACK);
        for(int i = 0; i < arrDeq.size(); i++){
            Coords temp = arrDeq.pop();
            g.fillRect(temp.getX()*actSizeX, temp.getY()*actSizeY, actSizeX, actSizeY);
        }

        g.setColor(Color.CYAN);
        g.fillRect(meal.getCoords().getX()*actSizeX, meal.getCoords().getY()*actSizeY, actSizeX, actSizeY);

/*        for(int m=0; m<actSizeX; m++){
            for(int n=0; n<actSizeY; n++){

                if (snake.isOnCoord(new Coords(m, n)))
                    g.setColor(Color.BLACK);
                else if(meal.isOnCoord(new Coords(m, n)))
                    g.setColor(Color.CYAN);
                else
                    g.setColor(Color.WHITE);

                g.fillRect(m*actSizeX, n*actSizeY, actSizeX, actSizeY);
            }
        }*/
    }

}