//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Menu implements ActionListener
//
//{
//    JFrame frame=new JFrame();
//    boolean status;
//    JButton start_button =new JButton();
//    void menu()
//    {
//        frame.setSize(800,800);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        frame.setLayout(null);
//        frame.setVisible(true);
//
//        start_button.setBounds(400,400,70,30);
//        start_button.setText("PLAY");
//        frame.add(start_button);
//
//
//    }
//    int click ()
//    {
//        start_button.addActionListener(this);
//        return 1;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==start_button)
//        {
//            System.out.println("helo");
//            status=true;
//        }
//
//
//    }
//}

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu implements ActionListener {
    private JFrame frame;
    private JPanel mainPanel, buttonPanel;
    private JLabel titleLabel;
    private JButton startButton, exitButton;
    private Brick_map brick_map;

    public Menu() {
        frame = new JFrame("Game Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.BLACK);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = new ImageIcon("Black_colour.jpg").getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Create title label
        titleLabel = new JLabel("Menu");
//        titleLabel.setBounds(500,150,50,50);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);


        // Create button panel
        buttonPanel = new JPanel((new GridLayout(2, 1, 1, 1)));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 150, 150, 150));


        // Create start button

            startButton = new JButton("Start");
            startButton.setFont(new Font("Monospaced", Font.BOLD, 20));
            startButton.setBackground(Color.BLACK);
            startButton.setForeground(Color.CYAN);
            startButton.addActionListener(this);



        // Create exit button
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Monospaced", Font.BOLD, 20));
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.CYAN);
        exitButton.addActionListener(this);

        // Add buttons to button panel
        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);

        // Create main panel
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add main panel to frame
        frame.add(mainPanel);


        // Display the frame
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            // TODO: handle start game button press


        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Menu();
    }

}


