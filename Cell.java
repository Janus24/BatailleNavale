abstract class Cell {
    
    private boolean hit = false;
    
    public Cell() {
        
    }
    
    public boolean isHit(){
        return this.hit;
    }
    
    public HitResult hit() {
        HitResult res;
        if(hit = false)
        {           
             res = this.firstHit();
        }
        else
        {
            res = new MissedHit();
        }
        hit = true;
        return res;
    }
    protected abstract HitResult firstHit();
    
}
