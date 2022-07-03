import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  // Script author Warrpy
public class MicroBounce extends JFrame{
  public MicroBounce() {
    setTitle("MicroBounce");
    setSize(400, 250);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(new Core());
    setVisible(true);
  }
  public static void main(String[] args){
    new MicroBounce();
  }
}
class Core extends JComponent{
  int pos_x = 200, pos_y = 50,
      speed_x = 1, speed_y = 1;
  public Core(){
    var t = new Timer(16, new ActionListener(){
      public void actionPerformed(ActionEvent e){
        // collision detection on X axis.
        if (pos_x <= 0 || pos_x >= (getWidth()-20)){
          speed_x *= -1; // reverse direction.
        }

        if (pos_y <=0 || pos_y >= (getHeight()-20)){
          speed_y *= -1;
        }
        // move.
        pos_x += speed_x;
        pos_y += speed_y;
        repaint();
      }
    });
    t.start();
  }
  public void paint(Graphics g){
    g.setColor(Color.green);
    g.fillOval(pos_x, pos_y, 20, 20);
    getToolkit().sync();
  }
}

// Very sexy script, you know?
