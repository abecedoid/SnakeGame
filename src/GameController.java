import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameController implements ActionListener{
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
        gTimer = new Timer(500, this);
        keyHandler = new KeyHandler();
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
        win.setSize(400, 400);
        win.setVisible(true);
        win.g.setFocusable(true);
        win.g.requestFocus();
        win.g.addKeyListener(keyHandler);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        win.g.drawState(this.s, this.m);
    }
}
