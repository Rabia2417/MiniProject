// TIC-TAC-TOE

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Miniproject extends JFrame implements ActionListener{
    JLabel heading;
    JLabel bottom;
    Font font = new Font("Times New Roman",  Font.ITALIC, 25);
    JPanel mainPanel; // creates a panel
    JButton[] bttns = new JButton[9]; // for creating 9 buttons
    int[] gameChances = {2, 2, 2, 2, 2, 2, 2, 2, 2}; // 2 means empty
    int activePlayer = 0;
    int winner = 2;
    Miniproject() {
        setTitle("Tic-Tac-Toe");
        setSize(500, 500);
        ImageIcon icon = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\Tic-Tac-Toe\\src\\img.png");
        setIconImage(icon.getImage());

        // JPanel -> Grid Layout(3X3) -> 9 blocks
        createGUI();


        // clock run with help of thread
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void createGUI() {
        this.getContentPane().setBackground((Color.black)); // sets background colour as black
        this.setLayout(new BorderLayout());
        heading = new JLabel("Tic Tac Toe");
        heading.setFont(font);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setForeground(Color.white);
        this.add(heading, BorderLayout.NORTH);

        bottom = new JLabel("~Elektra");
        bottom.setFont(font);
        bottom.setHorizontalAlignment(SwingConstants.CENTER);
        bottom.setForeground(Color.white);
        this.add(bottom, BorderLayout.SOUTH);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 3, 5, 5));
        for (int i = 0; i < 9; i++) { // creates nine buttons
            JButton btn = new JButton();
            btn.setBackground(Color.white);
            mainPanel.add(btn);
            bttns[i] = btn; // storing button in array for future use
            btn.addActionListener(this); // call actionPerformed function
            btn.setName(String.valueOf(i));
        }
        this.add(mainPanel, BorderLayout.CENTER); // sets the panel at center
    }
    public static void main(String[] args) {
        Miniproject ob = new Miniproject();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        e.getSource(); // returns object through which this function is called
        JButton b = (JButton)e.getSource(); // type cast that object into JButton (current button)
        // b represents current button which is pressed
//        System.out.println(b.getName());
        String str = b.getName();
        int block = Integer.parseInt(str.trim());
        if (gameChances[block] == 2) {
            if (activePlayer == 1) {
                b.setIcon(new ImageIcon("C:\\Users\\hp\\IdeaProjects\\Tic-Tac-Toe\\src\\ttt1.png"));
                gameChances[block] = 1;
                activePlayer = 0;
                if ((gameChances[0] == 1 && gameChances[1] == 1 && gameChances[2] == 1) ||
                    (gameChances[3] == 1 && gameChances[4] == 1 && gameChances[5] == 1) ||
                    (gameChances[6] == 1 && gameChances[7] == 1 && gameChances[8] == 1) ||
                    (gameChances[0] == 1 && gameChances[3] == 1 && gameChances[6] == 1) ||
                    (gameChances[1] == 1 && gameChances[4] == 1 && gameChances[7] == 1) ||
                    (gameChances[2] == 1 && gameChances[5] == 1 && gameChances[8] == 1) ||
                    (gameChances[0] == 1 && gameChances[4] == 1 && gameChances[8] == 1) ||
                    (gameChances[2] == 1 && gameChances[4] == 1 && gameChances[6] == 1)) {
                    winner = 1;
                    JOptionPane.showMessageDialog(null, "Player 2 wins!!!" );
                }
            }
            else {
                b.setIcon(new ImageIcon("C:\\Users\\hp\\IdeaProjects\\Tic-Tac-Toe\\src\\ttt0.png"));
                gameChances[block] = 0;
                activePlayer = 1;
                if ((gameChances[0] == 0 && gameChances[1] == 0 && gameChances[2] == 0) ||
                        (gameChances[3] == 0 && gameChances[4] == 0 && gameChances[5] == 0) ||
                        (gameChances[6] == 0 && gameChances[7] == 0 && gameChances[8] == 0) ||
                        (gameChances[0] == 0 && gameChances[3] == 0 && gameChances[6] == 0) ||
                        (gameChances[1] == 0 && gameChances[4] == 0 && gameChances[7] == 0) ||
                        (gameChances[2] == 0 && gameChances[5] == 0 && gameChances[8] == 0) ||
                        (gameChances[0] == 0 && gameChances[4] == 0 && gameChances[8] == 0) ||
                        (gameChances[2] == 0 && gameChances[4] == 0 && gameChances[6] == 0)) {
                    winner = 0;
                    JOptionPane.showMessageDialog(null, "Player 1 wins!!!" );
                }
            }
            int f = 0;
            for (int j = 0; j < 9; j++) {
                if (gameChances[j] == 2) {
                    f = 1;
                    break;
                }
            }
            if (f == 0) {
                JOptionPane.showMessageDialog(null, "GAME DRAW");
            }
            if (winner == 1 || winner == 0 || f == 0) {
                int i = JOptionPane.showConfirmDialog(this, "Play new game: ");
                if (i == 0) { // 0 -> yes, 1 -> no, 2 -> cancel
                    this.setVisible(false);
                    new Miniproject();
                }
                else {
                    System.exit(404); // pass any status
                }
            }
        }


    }
}
