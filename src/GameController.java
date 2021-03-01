import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;


public class GameController implements ActionListener, KeyListener{
    int refreshPeriod; // in ms
    Timer gTimer;      // for geting next state
    Window win;
    int sizeX;
    int sizeY;
    Snake s;
    Meal m;
    KeyHandler keyHandler;

    public GameController(int refreshPeriod, int gridX, int gridY){
        this.refreshPeriod = refreshPeriod;
        this.sizeX = gridX;
        this.sizeY = gridY;
        gTimer = new Timer(250, this);
        //keyHandler = new KeyHandler();
        //keyHandler = new KeyHandler(this.s);
    }

    public void start(){
        //initialize snake and meal
        Coords c = new Coords(5, 5);
        s = new Snake(c, sizeX, sizeY);
        m = new Meal(new Coords(10, 10));

        gTimer.start();
        showWindow();

    }

    public void showWindow(){
        win = new Window();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(500, 500);
        win.setVisible(true);
        win.g.setFocusable(true);
        win.g.requestFocus();
        win.g.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);

        //System.out.println("Length is : " + s.getRepr().size());
        s.move();
        win.g.drawState(this.s, this.m);

        if(isMealEaten()){
            s.grow();
            newMealPosition();
        }

        if(s.collision){
            gTimer.stop();
            win.showGameOver();
        }
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp2);
    }

    public boolean isMealEaten(){
        if(s.isOnCoord(m.getCoords())){
            System.out.println("Food eaten!!");
            return true;
        }
        return false;
    }

    public void newMealPosition(){
        int x = (int)(Math.random()*(sizeX - 1));
        int y = (int)(Math.random()*(sizeY - 1));
        Coords c = new Coords(x, y);
        m.setCoords(c);
        System.out.println("New meal position ");
    }

    @Override
    public void keyPressed(KeyEvent keyEvent){
        int keyCode = keyEvent.getKeyCode();
        if(keyCode == keyEvent.VK_LEFT){
            System.out.println("Left");
            s.directionLeft();
        }
        if(keyCode == keyEvent.VK_UP) {
            System.out.println("Up");
            s.directionUp();
        }
        if(keyCode == keyEvent.VK_RIGHT) {
            System.out.println("Right");
            s.directionRight();
        }
        if(keyCode == keyEvent.VK_DOWN) {
            System.out.println("Down");
            s.directionDown();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent){}
    @Override
    public void keyTyped(KeyEvent keyEvent){}
}
