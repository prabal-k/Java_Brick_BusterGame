import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ForFrame extends JPanel implements KeyListener {
    public JFrame frame=new JFrame();
    JLabel label=new JLabel();
    int x_rect =350 ,y_rect=700,x_oval=378,y_oval=674;
    int speedx=15,speedy=15;
    ForFrame()
    {
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        label.setBackground(Color.BLACK);
        label.setOpaque(true);
        frame.add(label);
        frame.add(this);
        frame.addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        g.fillOval(x_oval,y_oval,20,20);
        g.fillRect(x_rect,y_rect,80,12);

        if(x_oval<0||x_oval>770)
            speedx=-speedx;
        if(y_oval<0||y_oval>770)
            speedy=-speedy;

        x_oval=x_oval-speedx;
        y_oval=y_oval-speedy;
        try {
            Thread.sleep(50);
        } catch (InterruptedException k) {
            throw new RuntimeException(k);
        }
        repaint();

        //COllision of paddle ra oval ko lagi //imp

        if(new Rectangle(x_rect,700,80,12).intersects(new Rectangle(x_oval,y_oval,20,20)))
        {
         while(x_oval!=0)
         {
             repaint();
             x_oval--;

         }

        }





    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            if(x_rect>=710)
            {
                repaint();
            }

            else {
                x_rect = x_rect + 14;
                repaint();
            }

        }
        else  if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            if(x_rect<=0)
            {
                repaint();
            }
            else {
                x_rect = x_rect - 14;
                repaint();
            }
        }
        

        ///COLLISION CHECK KO LAGI

        //COLLISION CHECK
        check_collision();
    }
    void check_collision()
    {



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



}
