/*******************************************************************************
 * Food.java
 * Max Beard
 * 
 * simulates food at the carnival
 ******************************************************************************/

package carnival;

public class Food 
{
    String foodName;
    int foodCost;
    
    public Food(String name, int cost)
    {
        foodName = name;
        foodCost = cost;
    } // end Food constructor
    
    public String getFoodName()
    {
        return foodName;
    } // end getFoodName
    
    public int getFoodCost()
    {
        return foodCost;
    } // end getFoodCost
} // end Food
