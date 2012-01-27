import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class Main 
{    
    private static Grid gridJoueur;
    private static Grid gridadv;

    static Ship battleship = new Ship(ShipType.BATTLESHIP);
    static Ship aircraft = new Ship(ShipType.AIRCRAFT_CARRIER);
    static Ship submarin = new Ship(ShipType.SUBMARIN);
    
    public static void main(String[] args) 
    {
        
        JFrame jf;
        jf = new Fenetre("Bataille Navale !");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }
}
