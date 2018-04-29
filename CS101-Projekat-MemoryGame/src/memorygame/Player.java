
package memorygame;

/**
 *
 * @author milankabjelic
 */
public class Player implements Comparable<Player>
{

    private String name;
    private int scoreTime;
    
    public Player(String name, int scoreTime) 
    {
        this.name = name;
        this.scoreTime = scoreTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScoreTime() {
        return scoreTime;
    }

    public void setScoreTime(int scoreTime) {
        this.scoreTime = scoreTime;
    }

    @Override
    public String toString() {
        return "Score: " + scoreTime + " sec.............................................." + name;
    }

    @Override
    public int compareTo(Player p) 
    {
        return this.scoreTime - p.getScoreTime();
    }
    
    
}
