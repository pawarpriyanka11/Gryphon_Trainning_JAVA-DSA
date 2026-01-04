package DAY6;
import java.awt.*;
import java.awt.event.*;

public class MouseEvent1 extends Frame implements MouseListener {

    Label l1, l2;
    Frame f;
    String str;

    MouseEvent1() {
        f = new Frame("WINDOW");
        l1 = new Label("Handling Mouse Event in the Frame window!", Label.CENTER);
        l2 = new Label(); // label to add text dynamically

        f.setLayout(new FlowLayout());
        f.add(l1);
        f.add(l2);

        f.addMouseListener(this);
        f.setSize(340, 200);
        f.setVisible(true);
    }

    public void mouseEntered(MouseEvent me) {
        str = "Mouse has entered the window area";
        l2.setText(str);
    }

    public void mouseExited(MouseEvent me) {
        str = "Mouse has exited the window area";
        l2.setText(str);
    }

    public void mouseClicked(MouseEvent me) {
        str = "Mouse has clicked the window area";
        l2.setText(str);
    }

    public void mousePressed(MouseEvent me) {
        str = "Mouse has pressed the window area";
        l2.setText(str);
    }

    public void mouseReleased(MouseEvent me) {
        str = "Mouse has released the window area";
        l2.setText(str);
    }

    public static void main(String[] args) {
        new MouseEvent1();
    }
}
