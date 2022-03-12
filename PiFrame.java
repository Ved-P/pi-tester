import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PiFrame {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Hello world");
    frame.setSize(300, 300);
    frame.setLocation(5, 5);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    PiGame label = new PiGame();
    frame.add(label);

    frame.show();
  }
}

class PiGame extends JPanel implements MouseListener, KeyListener {
  String pi = "314159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706798214808651328230664709384460955058223172535940812848111745028410270193852110555964462294895493038196";
  int i = 0;
  int me = -1;
  boolean start = false;
  public PiGame() {
    addMouseListener(this);
    addKeyListener(this);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setFont(new Font("Serif", Font.PLAIN, 20));
    g.setColor(Color.BLACK);
    if (!start) {
      g.drawString("Start by typing the digits of pi.", 20, 50);
      g.drawString("This will tell you if it's correct.", 20, 80);
      g.drawString("Press x to reset.", 20, 110);
    }
    else {
      g.drawString("You said: " + me, 20, 50);
      g.drawString("Correct answer: " + pi.charAt(i), 20, 80);
      String correct = "";
      if (me == pi.charAt(i) - '0') {
        correct = "correct.";
        g.setColor(Color.BLUE);
        i++;
      }
      else {
        correct = "wrong.";
        g.setColor(Color.RED);
        i++;
      }
      g.drawString("You are " + correct, 20, 110);
      g.setColor(Color.BLACK);
      g.drawString("You are on digit " + i + ".", 20, 140);
    }
  }

  public void keyTyped(KeyEvent evt) {
    char c = evt.getKeyChar();
    if (c >= '0' && c <= '9') {
      start = true;
      me = c - '0';
    }
    else if (c == 'x') {
      start = false;
      me = -1;
      i = 0;
    }
    repaint();
  }

  public void mousePressed(MouseEvent evt) {
    requestFocusInWindow();
  }

  public void keyPressed(KeyEvent evt) {}
  public void keyReleased(KeyEvent evt) {}
  public void mouseClicked(MouseEvent evt) {}
  public void mouseReleased(MouseEvent evt) {}
  public void mouseEntered(MouseEvent evt) {}
  public void mouseExited(MouseEvent evt) {}
}
