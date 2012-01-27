import java.util.StringTokenizer;
import javax.swing.JOptionPane;
public class Game 
{
    private Player currentPlayerIndex;
    private Player P1;
    private Player P2;
    private Reseau resJeux;
    
    public Game(Player j1, Player j2,Reseau res)
    {
        this.P1 = j1;
        this.P2 = j2;
        this.currentPlayerIndex = j1;
        this.resJeux = res;
    }
    
    public Player isPlayer()
    {
        return this.currentPlayerIndex;
    }
    
    public Player getCurrentEnnemy()
    {
        if(this.P1 == this.currentPlayerIndex)
        {
            return this.P2;
        }
        else
        {
            return P1;
        }
    }
    
    public void nextTurn()
    {
        if(this.P1 == this.currentPlayerIndex)
        {
            this.currentPlayerIndex = this.P2;
        }
        else
        {
            this.currentPlayerIndex = this.P1;
        }
    }
    
    public int fire(int rowIndex,int columnIndex) {
        boolean res;
        this.resJeux.Send(rowIndex + ";" + columnIndex);
        String rep = this.resJeux.Receive();
        return Integer.parseInt(rep);
        }
    
    public void waitt(){
        String rep = this.resJeux.Receive();
        String[] result = rep.split(";");
        for (int x=0; x<result.length; x++)
            System.out.println(result[x]);
        int rowIndex = Integer.parseInt(result[0]);
        int columnIndex = Integer.parseInt(result[1]);
        HitResult res = this.getCurrentEnnemy().hit(rowIndex, columnIndex);
        int resultat;
        if(res instanceof MissedHit)
        {
            resultat = 0;
            this.getCurrentEnnemy().getGridJoueur().setTouchOcean(rowIndex,columnIndex);
        }
        else
        {
            resultat = 1;
            this.getCurrentEnnemy().getGridJoueur().setTouchShip(rowIndex,columnIndex);
        }
        this.resJeux.Send(String.valueOf(resultat));
    }
}
