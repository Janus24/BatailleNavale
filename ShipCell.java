public class ShipCell extends Cell {
    Ship ship ;
    Orientation orient;

    
   public ShipCell(Ship sship, Orientation orient)
   {
       this.ship = sship;
       this.orient=orient;
   }
   
    protected ShipHit firstHit() 
    {
        return this.ship.Hit();
    }
    
    public Ship getShip()
    {
        return this.ship;
    }
    
    public Orientation getOrient()
    {
        return this.orient;
    }
}