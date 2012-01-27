public enum ShipType 
{
    AIRCRAFT_CARRIER(4),
    BATTLESHIP(3),
    SUBMARIN(2);

    public final int size;
    
    private ShipType(int Size)
    {
        this.size = Size;
    }
    
    public int getCellCount()
    {
        return this.size;
    }
    
}