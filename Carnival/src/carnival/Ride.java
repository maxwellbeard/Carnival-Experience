/*******************************************************************************
 * Ride.java
 * Max Beard
 *
 * simulates a ride at the carnival
 ******************************************************************************/
package carnival;

public class Ride
{
    String rideName;
    int rideCost;

    public Ride(String newRideName, int cost)
    {
        rideName = newRideName;
        rideCost = cost;
    } // end Ride constructor
    
    public int getRideCost()
    {
        return rideCost;
    } // end ticketCost
    
    public String getRideName()
    {
        return rideName;
    } // end getRideName
} // end Ride
