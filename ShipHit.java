public class ShipHit extends HitResult {
    private ShipType shipType;
    private int shipRemainingCellCount = shipType.getCellCount();
    
    public ShipHit(ShipType shipType, int RemainingCellCount){
        this.shipType = shipType;
        this.shipRemainingCellCount = RemainingCellCount;
    }
    
    public int getShipRemainingCellCount()
    {
        return this.shipRemainingCellCount;
    }
}