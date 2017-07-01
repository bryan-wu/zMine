package testMine;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;


/**
 * GoldTile class.
 *
 * @author Austin Cheng, Bryan Wu
 * @version May 22, 2016
 * @author Period: 3
 * @author Assignment: The Final
 *
 * @author Sources: None
 */
public class GoldTile extends Tile
{

    private boolean gold;


    /**
     * @param c
     *            col
     * @param r
     *            row
     * @param world
     *            world
     */
    public GoldTile( int c, int r, World world )
    {
        super( false, 1000, Color.YELLOW, c, r, world );
        gold = true;
    }

}
