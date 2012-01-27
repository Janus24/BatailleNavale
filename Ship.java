public class Ship 
{
    private ShipType type;
    private int remainingCellCount;
    private ShipCell shipcell;
    
    public Ship(ShipType type)
    {
        this.remainingCellCount = type.size;
        this.type = type;
    }
    
    public int getSize()
    {
        return this.remainingCellCount;
    }
    
    public Grid addToGrid(Grid grid, int rowIndex, int columnIndex, Orientation orientation)
    {
        shipcell = new ShipCell(this , orientation);
        if (orientation.isHorizontal())
        {
            for (int i = 0; i <= this.remainingCellCount; i++)
            {
                grid.setCell(rowIndex, columnIndex+i, shipcell);
            }
        }
        else
        {
            for (int i = 0; i <= this.remainingCellCount; i++)
            {
                grid.setCell(rowIndex+i, columnIndex, shipcell);
            }
        }
        return grid;
    }
    
    
    public ShipHit Hit()
    {
        ShipHit att = new ShipHit(this.type, this.remainingCellCount -=1);
        return att;
    }
}