package testMine;

import java.awt.Color;


/**
 * SilverTile.
 *
 * @author Austin Cheng
 * @version May 25, 2016
 * @author Period: 3
 * @author Assignment: The Final
 *
 * @author Sources: None
 */
public class SilverTile extends Tile
{

    private boolean gold;


    /**
     * @param x
     *            x
     * @param y
     *            y
     * @param world
     *            world
     */
    public SilverTile( int x, int y, World world )
    {
        super( false, 500, Color.GRAY, x, y, world );
        gold = true;
    }

}
