import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter{

    Snake s;

    public KeyHandler(Snake s){
        this.s = s;
    }

    @Override
    public void keyPressed(KeyEvent e){
        //System.out.println(e);
        int keyCode = e.getKeyCode();
        if(keyCode == e.VK_LEFT){
            System.out.println("Left");
            //s.moveLeft();
        }
        if(keyCode == e.VK_UP) {
            System.out.println("Up");
            //s.moveUp();
        }
        if(keyCode == e.VK_RIGHT) {
            System.out.println("Right");
            //s.moveRight();
        }
        if(keyCode == e.VK_DOWN) {
            System.out.println("Down");
            //s.moveDown();
        }
    }

}
