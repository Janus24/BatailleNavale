import javax.swing.JOptionPane;

public class Partie 
{
    public static void placeship(Ship ship, int row, int column, Orientation orientation, Player player)
    {

        if (orientation.isHorizontal())
        {
            player.addShip(ship, row, column, Orientation.HORIZONTAL);
        }
        else
        {
            player.addShip(ship, row, column, Orientation.VERTICAL);
        }
    }
    
    public static boolean verif(Ship ship, int row, int column, Orientation orientation, Player player)
    {
        Grid grid = player.getGridJoueur();
        int size = ship.getSize();
        boolean res = true;
        if (orientation.isHorizontal())
        {
            if (column+size > 10)
            {
                JOptionPane.showMessageDialog(null, "Vous ne pouvez pas placer de bateau \n en dehors du cadre (bien essayé) !", "Erreur 001", JOptionPane.ERROR_MESSAGE);
                res = false;
            }
            else
            {
                for (int i=0; i<size;i++)
                {
                    if (grid.getCell(row, column+i) instanceof ShipCell)
                    {
                        JOptionPane.showMessageDialog(null, "Vous ne pouvez pas placer de bateau \n sur un autre bateau", "Erreur 002", JOptionPane.ERROR_MESSAGE);
                        res = false;
                        i=size;
                    }
                    else
                    {

                    }
                }
            }
        }
        else if(!orientation.isHorizontal())
        {
            if (row+size > 10)
            {
                JOptionPane.showMessageDialog(null, "Vous ne pouvez pas placer de bateau \n en dehors du cadre (bien essayé) !", "Erreur 001", JOptionPane.ERROR_MESSAGE);
                res = false;
            }
            else
            {
                for (int i=0; i<size;i++)
                {
                    if (grid.getCell(row+i, column) instanceof ShipCell)
                    {
                        JOptionPane.showMessageDialog(null, "Vous ne pouvez pas placer de bateau \n sur un autre bateau", "Erreur 002", JOptionPane.ERROR_MESSAGE);
                        res = false;
                        i=size;
                    }
                    else
                    {

                    }
                }
            }
        }
        else
        {
            
        }
        return res;
    }
    
    public static void demande(Ship ship, Player player)
    {
        boolean first = true;
        int row = 1;
        int col = 1;
        Orientation orientation = Orientation.HORIZONTAL;
        String stringship;
        
        if (ship.getSize() == 3)
        {
            stringship = "sous-marin";
        }
        else if (ship.getSize() == 4)
        {
            stringship ="Cuirrassé";
        }
        else
        {
            stringship = "Porte-avion";
        }
        boolean verif = false;
        while(!verif || first)
        {
            boolean first2= true;
            Object[] possibleValues = { "Horizontalement", "Verticalement"};
            Object selectedValue = JOptionPane.showInputDialog(null,
            "Comment-voulez vous placer votre " + stringship + " ?", "Input",
            JOptionPane.INFORMATION_MESSAGE, null,
            possibleValues, possibleValues[0]);
            if (selectedValue.equals("Horizontalement"))
            {
                orientation = Orientation.HORIZONTAL;
            }
            else
            {
                orientation = Orientation.VERTICAL;
            }
            
            while(row<0 || row>9 || col<0 || col>9 || first2)
            {
                row = -1;
                col = -1;
                String Row = JOptionPane.showInputDialog("Ligne ?");
                String Column = JOptionPane.showInputDialog("Colonne ?");
                if (Row.equals("") || Column.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Tapez quelque chose", "Erreur 008", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    int rowtest = Integer.parseInt(Row);
                    int coltest = Integer.parseInt(Column);
                    if(rowtest<0 || rowtest>9)
                    {
                        JOptionPane.showMessageDialog(null, "Tapez une valeur de ligne entre 1 et 10", "Erreur 006", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        row = Integer.parseInt(Row)-1;
                    }
                    if(coltest<0 || coltest>9)
                    {
                        JOptionPane.showMessageDialog(null, "Tapez une valeur de colonne entre 1 et 10", "Erreur 007", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        col = Integer.parseInt(Column)-1;
                    }
                    first2=false;
                }
            }
            
            first = false;
            verif = verif(ship, row, col, orientation, player);
        }
        placeship(ship, row, col, orientation, player);
    }
}
