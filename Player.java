public class Player {
    private Grid gridJoueur = new Grid();
    private Grid gridAdv = new Grid();
    private String name;
    int shipStillAliveJoueur = 0;
    int shipStillAliveAdv = 0 ;
    
     public boolean addShip(Ship ship, int rowIndex, int columnIndex, Orientation orientation) {
        boolean res;
        if( orientation.isHorizontal() )
        {
             if(columnIndex + ship.getSize()< 10 && rowIndex <10)
             {
                 gridJoueur = ship.addToGrid(gridJoueur, rowIndex, columnIndex, orientation);
                 shipStillAliveJoueur++;
                 res = true;
             }
             else
             {
                 res = false;
             }
        }
        else
        {
            if(rowIndex + ship.getSize()< 10 && columnIndex <10)
             {
                 gridJoueur = ship.addToGrid(gridJoueur, rowIndex, columnIndex, orientation);
                 res = true;
             }
            else
             {
                 res = false;
             }
        }
        return res;
    }
    
    public HitResult hit(int rowIndex, int columnIndex){
        HitResult res = this.gridAdv.getCell(rowIndex,columnIndex).hit();
        if (res instanceof ShipHit)
        {        
            if (((ShipHit)res).getShipRemainingCellCount() == 0 )
            {
                shipStillAliveJoueur--;
            }
            
        }
        return res;
    }
    
    public Grid getGridJoueur() {
        return this.gridJoueur ;
    }
    
    public Grid getGridAdv() {
        return this.gridAdv ;
    }
    
    public boolean isDestroyed(){
        boolean res = false;
        if(shipStillAliveJoueur == 0)
        {
            res = true;
        }
        return res;
    }
}
