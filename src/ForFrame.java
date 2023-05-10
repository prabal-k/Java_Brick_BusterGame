import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ForFrame extends JPanel implements KeyListener ,MouseListener{
    public JFrame frame=new JFrame();
    JLabel score_label=new JLabel();
    int count=2;
    JLabel life_lable =new JLabel();
    int score=0;
  //  JLabel label=new JLabel();
    int x_rect =350 ,y_rect=700,x_oval=378,y_oval=674;
    int speedx=15,speedy=15;
  //  boolean out ;
    Brick_map brick_map=new Brick_map();
    ForFrame()
    {
        frame.setSize(800,800);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        score_label.setBounds(700,0,60,30);
        score_label.setText(String.valueOf(score));
        score_label.setForeground(Color.GREEN);
        score_label.setFont(new Font("Ink free",Font.BOLD,40));
        life_lable.setBounds(0,0,80,50);
        life_lable.setForeground(Color.GREEN);
        life_lable.setFont(new Font("Ink free",Font.BOLD,40));
        life_lable.setText(String.valueOf(count));
     //   add(life_lable);

        add(score_label);

        //frame.getContentPane().setForeground(Color.BLUE);

        frame.add(this);
        frame.addKeyListener(this);
        setBackground(Color.BLACK);
        frame.setVisible(true);
       // frame.setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillOval(x_oval, y_oval, 20, 20);
        g.fillRect(x_rect, y_rect, 100, 10);
        brick_map.draw((Graphics2D) g);
        try {
            ballin();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    void ballin() throws InterruptedException {
        //COllision of paddle ra oval ko lagi //imp

        if(new Rectangle(x_rect,y_rect,80,12).intersects(new Rectangle(x_oval,y_oval,20,20)))
        {
            if(x_oval<0||x_oval>680)
                speedx=-speedx;
            if(y_oval<0||y_oval>680)
                speedy=-speedy;
            x_oval=x_oval-speedx;
            y_oval=y_oval-speedy;
        }
        A:for(int i=0;i<brick_map.map.length;i++)
        {
            for(int j=0;j<brick_map.map[0].length;j++)
            {
                if(brick_map.map[i][j]>0)
                {
                    int brickx=j*brick_map.width+80;
                    int bricky=i*brick_map.height+80;
                    int wid=brick_map.width;
                    int hei=brick_map.height;
                    Rectangle rect=new Rectangle(brickx,bricky,wid,hei);
                    Rectangle ballrect=new Rectangle(x_oval,y_oval,20,20);
                    Rectangle brickrect=rect;
                    if(ballrect.intersects(brickrect))
                    {
                        brick_map.Brickscount(0,i,j);
                        score=score+5;
                       // System.out.println(score);
                        score_label.setText(String.valueOf(score));
                        if(x_oval+10<=brickrect.x||y_oval+1>=brickrect.x+brickrect.width)
                        {
//                            x_oval=-x_oval;
                            speedx=-speedx;
                        }
                        else
                        {
                            //y_oval=-y_oval;
                            speedy=-speedy;
                        }
                        break A;
                    }
                }
            }
        }
        if(x_oval<0||x_oval>770)
            speedx=-speedx;
        if(y_oval<0||y_oval>770)
            speedy=-speedy;

        //pheri ball reset garna ko lagi and life count dekhauna

        if(y_oval>770)
            check_ballout();

        x_oval=x_oval-speedx;
        y_oval=y_oval-speedy;
        try {
            Thread.sleep(50);
        } catch (InterruptedException k) {
            throw new RuntimeException(k);
        }
        repaint();




    }

    //BALL OUT GAYO VANI REGENERATE GARNA KO LAGI
    void check_ballout() throws InterruptedException {

            x_oval=378;
            y_oval=674-20;
            Thread.sleep(1000);

            repaint();
          //  ballin();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            if(x_rect>=680)
            {
                repaint();
            }

            else {
                x_rect = x_rect + 30;
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
                x_rect = x_rect - 30;
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


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
