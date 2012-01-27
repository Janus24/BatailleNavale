public enum Orientation 
{
    HORIZONTAL(true),
    VERTICAL(false);
    
    public final boolean horizontal;
    
    private Orientation(boolean orient)  
    {
        this.horizontal = orient;
    }
    
    public boolean isHorizontal()
    {
        return this.horizontal;
    }
}
