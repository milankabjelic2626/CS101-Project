
package memorygame;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author milankabjelic
 */
public class Card extends JButton
{
    private int cardID;
    private boolean mached = false;
    private boolean opened = false;
    private ImageIcon imgIcon, imgBack;

    
    public Card(int cardID)
    {
        this.cardID = cardID;
        imgIcon = new ImageIcon("images/image_" + cardID + ".jpg");
        imgBack = new ImageIcon("images/backside.jpg");
    }
    
    public void turnCardOn()
    { 
        this.setIcon(imgIcon);
        this.opened = true;            
    }
    
    public void turnCardOff()
    {       
        this.setIcon(imgBack);
        this.opened = false;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public boolean isMached() {
        return mached;
    }

    public void setMached(boolean mached) {
        this.mached = mached;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    @Override
    public String toString() {
        return "Card{" + "cardID=" + cardID + ", mached=" + mached + ", opened=" + opened + ", imgIcon=" + imgIcon + ", imgBack=" + imgBack + '}';
    }
    
    
    
}
