import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener

{
    JFrame frame=new JFrame();
    boolean status;
    JButton start_button =new JButton();
    void menu()
    {
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        start_button.setBounds(400,400,70,30);
        start_button.setText("PLAY");
        frame.add(start_button);


    }
    int click ()
    {
        start_button.addActionListener(this);
        return 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start_button)
        {
            System.out.println("helo");
            status=true;
        }


    }
}
