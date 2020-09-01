/*******************************************************************************
 * Game.java
 * Max Beard
 * 
 * simulates a game at the carnival
 ******************************************************************************/

package carnival;

public class Game 
{
    String gameName;
    int gameCost;
    String[] prizes;
    
    public Game(String name, int cost, String[] prizes)
    {
        gameName = name;
        gameCost = cost;
        this.prizes = new String[4];
        System.arraycopy(prizes, 0, this.prizes, 1, this.prizes.length-1);
        this.prizes[0] = "sorry, no prize"; 
    } // end Game constructor
    
    public String playGame()
    {
        int rand = (int) (Math.random() * prizes.length);
        System.out.printf("Play %s, and the result is: %s\n", gameName, prizes[rand]);
        return prizes[rand];
    } // end playGame
    
    public int getGameCost()
    {
        return gameCost;
    } // end getGameCost
} // end Game
