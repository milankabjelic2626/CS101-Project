package memorygame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author milankabjelic
 */
public abstract class Table extends JFrame
{

        private ArrayList<Card> cardList;
        private int c1 = -1, c2 = -1;
        private long startTime, endTime;
        private int deltaTime;
        private int numbOfPairs;
        private final ImageIcon imgIcon;
        
        
    public Table(int fRow, int fCol, int fHGap, int fWGap, int pairs, int fWidth, int fHeight)  
    {
        super("Memory Game");
        imgIcon = new ImageIcon("images/backside.jpg");
        cardList = new ArrayList<>();
        
        setLayout(new GridLayout(fRow, fCol, fHGap, fWGap));
        setResizable(false);
        setSize(fWidth, fHeight);
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);
        
        numbOfPairs = pairs;
        for(int i = 0; i < numbOfPairs; i++)
        {
            cardList.add(new Card(i));
            cardList.add(new Card(i));
        }
        
        Collections.shuffle(cardList);
        
        for(Card c : cardList)
        {
            c.setIcon(imgIcon);
            c.setSize(150, 150);
            add(c);
        }
        
        setVisible(true);
        startTime = System.nanoTime();
        
        for(Card c : cardList)
        {
            c.addActionListener(new ActionListener() 
            {

                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    doTurn(c);
                }
            });
        }
    
    }
    
    public boolean gameWon()
    {
        for(Card c : cardList)
        {
            if(c.isMached() == false)
                return false;
            
        }
        return true;
    }
    
    public void doTurn(Card c)
    {
        if(c.isOpened() == false && c1 == -1)
        {
            
            for(Card ch : cardList)
            {
                if(ch.isOpened() == true && ch.isMached() == false)
                    ch.turnCardOff();
            }
            
            c1 = c.getCardID();
            c.turnCardOn();
            
        }
        else if(c.isOpened() == false && c1 != -1)
        {
            c.turnCardOn();
            c2 = c.getCardID();
            
            if(c1 == c2)
            {
                for(Card card : cardList)
                {
                    if(card.getCardID() == c.getCardID())
                    {
                        card.setEnabled(false);
                        card.setMached(true);
                        card.setOpened(true);
                    }
                }
                if(gameWon() == true)
                {
                    endTime = System.nanoTime();
                    deltaTime = (int)((endTime - startTime) / 1000000000);
                    String name = JOptionPane.showInputDialog("Cestitamo zavrsili ste za: " + deltaTime + " sekundi! Upisite svoje ime");
                    Player player = new Player(name, deltaTime);
                    Scoreboard.addToListOfPlayers(player);
                    
                    setEnabled(false);
                    setVisible(false);
                    
                }
            }
            
            c1 = -1;
            c2 = -1;
        }
        else if(c.isOpened() == true)
        {   
            for(Card card : cardList)
            {
                if(card.getCardID() != c.getCardID() && card.isMached() == false)
                    card.turnCardOff();              
            }
            c1 = c.getCardID();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Doslo je do greske");
        }
        
    }

    public ArrayList<Card> getCardList() {
        return cardList;
    }

    public void setCardList(ArrayList<Card> cardList) {
        this.cardList = cardList;
    }

    public int getC1() {
        return c1;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public int getC2() {
        return c2;
    }

    public void setC2(int c2) {
        this.c2 = c2;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(int deltaTime) {
        this.deltaTime = deltaTime;
    }

    public int getNumbOfPairs() {
        return numbOfPairs;
    }

    public void setNumbOfPairs(int numbOfPairs) {
        this.numbOfPairs = numbOfPairs;
    }

    @Override
    public String toString() {
        return "Table{" + "cardList=" + cardList + ", c1=" + c1 + ", c2=" + c2 + ", startTime=" + startTime + ", endTime=" + endTime + ", deltaTime=" + deltaTime + ", numbOfPairs=" + numbOfPairs + ", imgIcon=" + imgIcon + '}';
    }
  
}
