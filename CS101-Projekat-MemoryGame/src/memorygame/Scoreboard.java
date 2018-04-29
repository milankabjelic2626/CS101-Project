
package memorygame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author milankabjelic
 */
public class Scoreboard extends JFrame
{
    private static ArrayList<Player> listOfPlayers = new ArrayList<>();

    public Scoreboard()
    {
        super("Memory Game - Scoreboard");
        
        Collections.sort(listOfPlayers);
        
        setLayout(new FlowLayout());
        setSize(350, 450);
        setLocationRelativeTo(null);
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        setVisible(true);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        
        JList scoreList = new JList(listOfPlayers.toArray());
        
        add(scoreList);
        
    }
    
    public static void addToListOfPlayers(Player p)
    {
        listOfPlayers.add(p);
    }

    public static ArrayList<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    public static void setListOfPlayers(ArrayList<Player> listOfPlayers) {
        Scoreboard.listOfPlayers = listOfPlayers;
    }
    
    
}
