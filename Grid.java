public class Grid 
{
    
    private Cell[][] tabGrid;
    
    public Grid()
    {
        this.tabGrid = new Cell[10][10];
        
        for (int i =0; i<10; i++)
        {
            for(int j =0; j<10;j++)
            {
                tabGrid[i][j] = new OceanCell();
            }
        }
    }
    
    public Cell getCell( int rowIndex, int columnIndex)
    {
        return this.tabGrid[rowIndex][columnIndex];
    }
    
    public void setCell( int rowIndex, int columnIndex, ShipCell newCell)
    {
        this.tabGrid[rowIndex][columnIndex] =  newCell ;
    }
    
    public void setTouchOcean( int rowIndex, int columnIndex)
    {
        TouchOceanCell newCell = new TouchOceanCell(); 
        this.tabGrid[rowIndex][columnIndex] =  newCell ;
    }
    
    public void setTouchShip( int rowIndex, int columnIndex)
    {
        TouchShipCell newCell = new TouchShipCell(); 
        this.tabGrid[rowIndex][columnIndex] =  newCell ;
    }
}