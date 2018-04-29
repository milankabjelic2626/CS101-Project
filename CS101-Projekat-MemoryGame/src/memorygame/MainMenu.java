package memorygame;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author milankabjelic
 */
public class MainMenu extends JFrame
{
   
    private final JButton button1;
    private final JButton button2;
    private final JButton button3;
    private final JButton button4;
    private final JButton button5;
    
    public MainMenu()  
    {
        super("Memory Game - Menu");
        
        JPanel okvir = new JPanel();
        okvir.setSize(350, 600);
        okvir.setLayout(new GridLayout(5, 1, 10, 10));
        
        /*GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(0, 0, 0, 10);
        gc.gridx = 0;
        gc.gridy = 0;*/

        button1 = new JButton("Easy");
        button2 = new JButton("Medium");
        button3 = new JButton("Hard");
        button4 = new JButton("Scoreboard");
        button5 = new JButton("Exit");
        
        okvir.add(button1);
        okvir.add(button2);
        okvir.add(button3);
        okvir.add(button4);
        okvir.add(button5);
        
        setLayout(new GridLayout(5, 1, 10, 10));
        setSize(350, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        
        button1.addActionListener(new ActionListener() 
        {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
                Easy easy = new Easy();
                
            }
        });
        
        button2.addActionListener(new ActionListener() 
        {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Medium medium = new Medium();
            }
        });
        
        button3.addActionListener(new ActionListener() 
        {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Hard hard = new Hard();
            }
        });
        
        button4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Scoreboard scoreBoard = new Scoreboard();
            }
        });
        
        button5.addActionListener(new ActionListener() 
        {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });

        setVisible(true);        
    }

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JButton getButton3() {
        return button3;
    }

    public JButton getButton4() {
        return button4;
    }

    public JButton getButton5() {
        return button5;
    }

    @Override
    public String toString() {
        return "MainMenu{" + "button1=" + button1 + ", button2=" + button2 + ", button3=" + button3 + ", button4=" + button4 + ", button5=" + button5 + '}';
    }
}
