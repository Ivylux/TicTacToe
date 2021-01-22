
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main extends JFrame implements ActionListener
{
    public static void main(String[] args) 
    {
        main = new Main();
        main.setVisible(true);
    }
    static private Main main;

    private JButton[][] tiles = new JButton[3][3];

    private char[][] states = new char[3][3];
    private char player = 'O';

    public Main() 
    {
        setTitle("TicTacToe");
        setSize(600,600);
        setLocation(new Point(600, 600));
        setLayout(new GridLayout(3, 3));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        initComponent();
    }


    public void winCheck(int x, int y)
    {
        boolean win = false;
        if(states[x][0] == states[x][1] && states[x][0] == states[x][2])
        {
            win = true;
        }
        else if(states[0][y] == states[1][y] && states[0][y] == states[2][y])
        {
            win = true;
        }
        else if(states[0][0] == states[1][1] && states[1][1] == states[2][2] && (states[1][1] == 'O' || states[1][1] == 'X'))
        {
            win = true;
        }
        else if(states[0][2] == states[1][1] && states[1][1] == states[2][0] && (states[1][1] == 'O' || states[1][1] == 'X'))
        {
            win = true;
        }
        boolean tie = true;
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                if(!(states[j][i] == 'O' || states[j][i] == 'X'))
                {
                    tie = false;
                }
            }    
        }

        if(win == true)
        {
            player = 'O';
            JOptionPane.showMessageDialog(null, "Winner!");
            int a = JOptionPane.showConfirmDialog(main, "Rematch?", "", JOptionPane.YES_NO_OPTION);
            if(a == JOptionPane.YES_OPTION)
            {
                for(int i = 0; i < 3; i++)
                {
                    for(int j = 0; j < 3; j++)
                    {
                        tiles[j][i].setText("");
                    }
                }
                states = new char[3][3];
            }
            else if(a == JOptionPane.NO_OPTION)
            {
                main.dispose();
            }
            else if(a == JOptionPane.CANCEL_OPTION)
            {
                main.dispose();
            }
        }
        else if(tie == true)
        {
            player = 'O';
            JOptionPane.showMessageDialog(null, "Tie!");
            int a = JOptionPane.showConfirmDialog(main, "Rematch?", "", JOptionPane.YES_NO_OPTION);
            if(a == JOptionPane.YES_OPTION)
            {
                for(int i = 0; i < 3; i++)
                {
                    for(int j = 0; j < 3; j++)
                    {
                        tiles[j][i].setText("");
                    }
                }
                states = new char[3][3];
            }
            else if(a == JOptionPane.NO_OPTION)
            {
                main.dispose();
            }
            else if(a == JOptionPane.CANCEL_OPTION)
            {
                main.dispose();
            }
        }
        
    }

    public void buttonCheck(int x, int y)
    {
        if(states[x][y] != 'O' && states[x][y] != 'X')
        {
            states[x][y] = player;
            tiles[x][y].setText(String.valueOf(player));

            if(player == 'O')
            {
                player = 'X';
            }
            else
            {
                player = 'O';
            }
            winCheck(x, y);
        }
    }


    public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == tiles[0][0])
            {
                buttonCheck(0, 0);
            }
            else if(e.getSource() == tiles[0][1])
            {
                buttonCheck(0, 1);
            }
            else if(e.getSource() == tiles[0][2])
            {
                buttonCheck(0, 2);
            }
            else if(e.getSource() == tiles[1][0])
            {
                buttonCheck(1, 0);
            }
            else if(e.getSource() == tiles[1][1])
            {
                buttonCheck(1, 1);
            }
            else if(e.getSource() == tiles[1][2])
            {
                buttonCheck(1, 2);
            }
            else if(e.getSource() == tiles[2][0])
            {
                buttonCheck(2, 0);
            }
            else if(e.getSource() == tiles[2][1])
            {
                buttonCheck(2, 1);
            }
            else if(e.getSource() == tiles[2][2])
            {
                buttonCheck(2, 2);
            }
        }

    private void initComponent()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                tiles[i][j] = new JButton();
                add(tiles[i][j]);
                tiles[i][j].addActionListener(this);
                tiles[i][j].setFont(new Font("Default", Font.PLAIN, 200));
            }
        }

    }
}
