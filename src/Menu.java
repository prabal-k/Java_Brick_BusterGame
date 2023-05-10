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
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        // Create title label
        titleLabel = new JLabel("Menu");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 75));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);


        // Create button panel
        buttonPanel = new JPanel((new GridLayout(2, 1, 1, 1)));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(75, 150, 150, 150));


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
            ForFrame forFrame=new ForFrame();

        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Menu();
    }

}


