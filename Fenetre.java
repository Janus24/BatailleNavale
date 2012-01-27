import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;

//C:/Users/Jiloko/Documents/BatailleNavale/src/

public class Fenetre extends JFrame
{
    private Grid gridtest;
    private ImageIcon iconeau = new ImageIcon("src/eau.png");
    private ImageIcon iconeautouch = new ImageIcon("src/eautouch.png");
    private ImageIcon icondebris = new ImageIcon("src/debris.png");
    private ImageIcon icondebristouch = new ImageIcon("src/debristouch.png");
    private ImageIcon iconbattle1h = new ImageIcon("src/battleship1h.png");
    private ImageIcon iconbattle2h = new ImageIcon("src/battleship2h.png");
    private ImageIcon iconbattle3h = new ImageIcon("src/battleship3h.png");
    private ImageIcon iconbattle4h = new ImageIcon("src/battleship4h.png");
    private ImageIcon iconbattle1v = new ImageIcon("src/battleship1v.png");
    private ImageIcon iconbattle2v = new ImageIcon("src/battleship2v.png");
    private ImageIcon iconbattle3v = new ImageIcon("src/battleship3v.png");
    private ImageIcon iconbattle4v = new ImageIcon("src/battleship4v.png");
    private ImageIcon iconsub1h = new ImageIcon("src/submarin1h.png");
    private ImageIcon iconsub2h = new ImageIcon("src/submarin2h.png");
    private ImageIcon iconsub3h = new ImageIcon("src/submarin3h.png");
    private ImageIcon iconsub1v = new ImageIcon("src/submarin1v.png");
    private ImageIcon iconsub2v = new ImageIcon("src/submarin2v.png");
    private ImageIcon iconsub3v = new ImageIcon("src/submarin3v.png");
    private ImageIcon iconair1h = new ImageIcon("src/aircraft1h.png");
    private ImageIcon iconair2h = new ImageIcon("src/aircraft2h.png");
    private ImageIcon iconair3h = new ImageIcon("src/aircraft3h.png");
    private ImageIcon iconair4h = new ImageIcon("src/aircraft4h.png");
    private ImageIcon iconair5h = new ImageIcon("src/aircraft5h.png");
    private ImageIcon iconair1v = new ImageIcon("src/aircraft1v.png");
    private ImageIcon iconair2v = new ImageIcon("src/aircraft2v.png");
    private ImageIcon iconair3v = new ImageIcon("src/aircraft3v.png");
    private ImageIcon iconair4v = new ImageIcon("src/aircraft4v.png");
    private ImageIcon iconair5v = new ImageIcon("src/aircraft5v.png");

    
    private JPanel jp_droite;
    private JLabel nom_J1;
    private JPanel jp_grille1;
    private JButton[][] tabbout1;
    
    private JPanel jpg_bas;
    
    private JPanel jp_gauche;
    private JLabel nom_J2;
    private JPanel jp_grille2;
    private JButton[][] tabbout2;
    public Player J1;
    
    
    private JButton jb_avion;
    private ActionListener al_avion;
    private JButton jb_cuir;
    private ActionListener al_cuir;
    private JButton jb_sub;
    private ActionListener al_sub;
    private JButton b_new;
    private ActionListener al_new;
    
    private boolean nbavion;
    private boolean nbcuir;
    private boolean nbsub;
    
    public Ship battleship = new Ship(ShipType.BATTLESHIP);
    public Ship aircraft = new Ship(ShipType.AIRCRAFT_CARRIER);
    public Ship submarin = new Ship(ShipType.SUBMARIN);
    
    static Insets m = new Insets(-3,-3,-3,-3);
    
    Partie jeu;
    Game game;
    Player P2; //toi
    Player P1; //adv
    Reseau resJeux;
    String ipJoueur;
    String ipAdv;
    
    public Fenetre(String titre)
    {
        super(titre);
        
        //Gauche de l'application
        jp_gauche = new JPanel();
        String nomJ1 = "Joueur 1";
// nomJ1 = JOptionPane.showInputDialog("Quel est votre nom de capitaine ?");  //(Chiant)
        nom_J1 = new JLabel(nomJ1);
        
        
        //grille J1
        jp_grille1 = new JPanel(new GridLayout(10,10));
        tabbout1 = new JButton[10][10];
        for (int i = 0; i<10 ; i++) //ligne
        {
            for (int j = 0; j<10; j++) //colonne
            {
                JButton boutton = new JButton(new ImageIcon("src/eau.png"));
                boutton.setMargin(m);
                jp_grille1.add(boutton);
               // boutton.addActionListener(ecouteur);
                tabbout1[i][j]=boutton;
            }
        }
        
        jp_gauche.add(nom_J1, BorderLayout.NORTH);
        jp_gauche.add(jp_grille1, BorderLayout.CENTER);
        
        
        //bas pour le J1
        b_new = new JButton("Nouvelle partie");
        
        jpg_bas = new JPanel();
        jpg_bas.add(b_new);
        

        jb_sub = new JButton("Sous-marin");
        jb_avion = new JButton("Porte-avion");
        jb_cuir = new JButton("Cuirrassé");
        
        this.al_sub = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(nbsub)
                {
                    Partie.demande(submarin, J1);
                    majgrid1(J1);
                    nbsub=false;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Vous avez déjà placé votre sous-marin", "Erreur 005", JOptionPane.ERROR_MESSAGE);
                }
                
            }  
        };
        this.jb_sub.addActionListener(al_sub);

        
        this.al_cuir = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(nbcuir)
                {
                    Partie.demande(battleship, J1);
                    majgrid1(J1);
                    nbcuir = false;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Vous avez déjà placé votre cuirrassé", "Erreur 004", JOptionPane.ERROR_MESSAGE);
                }
            }  
        };
        this.jb_cuir.addActionListener(al_cuir);
        
        
        
        this.al_avion = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(nbavion)
                {
                    Partie.demande(aircraft, J1);
                    majgrid1(J1);
                    nbavion = false;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Vous avez déjà placé votre porte-avion", "Erreur 003", JOptionPane.ERROR_MESSAGE);
                }
            }  
        };
        this.jb_avion.addActionListener(al_avion);
        
        jb_sub.setVisible(false);
        jb_cuir.setVisible(false);
        jb_avion.setVisible(false);
        
        jpg_bas.add(jb_sub);
        jpg_bas.add(jb_cuir);
        jpg_bas.add(jb_avion);
        
        
        
        jp_gauche.add(jpg_bas, BorderLayout.SOUTH);
        
        //Droite de l'application
        jp_droite = new JPanel();
        String nomJ2 = "Joueur 2";
        nom_J2 = new JLabel(nomJ2);                   //Nom du joueur 2 à récupéré sur le serveur
        jp_droite.add(nom_J2);
        
         //grille J2
        jp_grille2 = new JPanel(new GridLayout(10,10));
        tabbout2 = new JButton[10][10];
        for (int i = 0; i<10 ; i++) //ligne
        {
            for (int j = 0; j<10; j++) //colonne
            {
                JButton boutton = new JButton(new ImageIcon("src/brouillard.png"));
                boutton.setMargin(m);
                jp_grille2.add(boutton);
                tabbout2[i][j]=boutton;
            }
        }
        jp_droite.add(nom_J2, BorderLayout.NORTH);
        jp_droite.add(jp_grille2, BorderLayout.SOUTH);
        
        
        //Mise en page
        this.add(jp_gauche, BorderLayout.WEST);
        this.add(jp_droite, BorderLayout.EAST);
        
        //bouton b_new commence une partie
        this.al_new = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                jeu = new Partie();
                J1 = new Player();
                jb_sub.setVisible(true);
                jb_cuir.setVisible(true);
                jb_avion.setVisible(true);
                
                b_new.setVisible(false);
                
                nbavion = true;
                nbcuir = true;
                nbsub = true;
            }
        };
        this.b_new.addActionListener(al_new);
        
        //algo
//        boolean test = true;
//        while(test){
//            if( nbavion == false && nbcuir == false && nbsub == false && b_new.isVisible() == false ) {
//                System.out.print("OUIIIIIIIII");
//                while(P1.isDestroyed() || P2.isDestroyed()){
//                    if(P1 != game.getCurrentEnnemy()){
//                        String x = JOptionPane.showInputDialog("Sur quel ligne voulez vous tirez ?");
//                        String y = JOptionPane.showInputDialog("Sur quel collonne voulez vous tirez ?");
//                        int res = game.fire(Integer.parseInt(x),Integer.parseInt(y));
//                        //majgrid2(res);
//                        game.nextTurn();
//                        }
//                    else{
//                        game.waitt();
//                        game.nextTurn();
//                    }
//                }
//                
//            test = false;
//            }
//            else
//            {
//                System.out.print("CACA");
//            }
        //}
               
    }
    private void majgrid2(int row, int col, int etat)
    {
        if (etat == 0)
        {
            tabbout2[row][col].setIcon(iconeau);
        }
        else
        {
            tabbout2[row][col].setIcon(icondebris);
        }
    }
    
    private void majgrid1(Player player)
    {
        gridtest = new Grid();
        gridtest = player.getGridJoueur();  
        
        ShipType type = ShipType.AIRCRAFT_CARRIER;
        Ship ship = new Ship(type);
        Orientation orient = Orientation.HORIZONTAL;
        for(int i=0; i<10 ; i++) //ligne
        {
            for (int j =0; j < 10; j++) //colonne
            {
                if (gridtest.getCell(i, j) instanceof OceanCell)
                {
                   tabbout1[i][j].setIcon(iconeau);
                }
//                else if(gridtest.getCell(i, j) instanceof TouchOceanCell)
//                {
//                    tabbout1[i][j].setIcon(iconeautouch);
//                }
//                else if(gridtest.getCell(i, j) instanceof TouchOceanCell)
//                {
//                    tabbout1[i][j].setIcon(icondebristouch);
//                }
                else if (gridtest.getCell(i, j) instanceof ShipCell)
                {
                   ship = ((ShipCell)gridtest.getCell(i, j)).getShip();
                   int size = ship.getSize();
                   orient = ((ShipCell)gridtest.getCell(i, j)).getOrient();
                   
                   if (orient.isHorizontal())
                   {
                       if (ship.getSize() == 2)
                       {
                           tabbout1[i][j].setIcon(iconsub1h);
                           tabbout1[i][j+1].setIcon(iconsub2h);
                           tabbout1[i][j+2].setIcon(iconsub3h);
                           j=j+2;

                       }
                       else if (ship.getSize() == 3) //battleship
                       {
                           tabbout1[i][j].setIcon(iconbattle1h);
                           tabbout1[i][j+1].setIcon(iconbattle2h);
                           tabbout1[i][j+2].setIcon(iconbattle3h);
                           tabbout1[i][j+3].setIcon(iconbattle4h);
                           j=j+3;
                       }
                       else
                       {
                           tabbout1[i][j].setIcon(iconair1h);
                           tabbout1[i][j+1].setIcon(iconair2h);
                           tabbout1[i][j+2].setIcon(iconair3h);
                           tabbout1[i][j+3].setIcon(iconair4h);
                           tabbout1[i][j+4].setIcon(iconair5h);
                           j=j+4;
                       }
                   }               
                }
            }
                
        for(int i2=0; i2<10 ; i2++) //ligne
        {
            for (int j2 =0; j2 < 10; j2++) //colonne
            {
                if (gridtest.getCell(i2, j2) instanceof ShipCell)
                {
                   ship = ((ShipCell)gridtest.getCell(i2, j2)).getShip();
                   orient = ((ShipCell)gridtest.getCell(i2, j2)).getOrient();
                   
                   if (!orient.isHorizontal())
                   {
                       if (ship.getSize() == 2)
                       {
                           tabbout1[i2][j2].setIcon(iconsub1v);
                           tabbout1[i2+1][j2].setIcon(iconsub2v);
                           tabbout1[i2+2][j2].setIcon(iconsub3v);
                           i2=i2+2;
                       }
                       else if (ship.getSize() == 3) //battleship
                       {
                           tabbout1[i2][j2].setIcon(iconbattle1v);
                           tabbout1[i2+1][j2].setIcon(iconbattle2v);
                           tabbout1[i2+2][j2].setIcon(iconbattle3v);
                           tabbout1[i2+3][j2].setIcon(iconbattle4v);
                           i2=i2+3;
                       }
                       else
                       {
                           tabbout1[i2][j2].setIcon(iconair1v);
                           tabbout1[i2+1][j2].setIcon(iconair2v);
                           tabbout1[i2+2][j2].setIcon(iconair3v);
                           tabbout1[i2+3][j2].setIcon(iconair4v);
                           tabbout1[i2+4][j2].setIcon(iconair5v);
                           i2=i2+4;
                       }
                   }               
                }
            }
        }
    }
    }
}
