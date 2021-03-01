import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    public Grid g;
    public JLabel label;

    public Window() {
        super("Best program ever");
        //setLayout(new FlowLayout());
        setLayout(new BorderLayout());
        label = new JLabel("Ahojte vsici");
        g = new Grid(20, 20);
        add(label, BorderLayout.NORTH);
        add(g, BorderLayout.CENTER);
        setFocusable(true);
        requestFocus();
    }

    public void refresh() {
        System.out.println("Refreshing...");
    }

    public void showGameOver(){
        System.out.println("GAME OVER");
        label.setText("GAME OVER!");
    }

}