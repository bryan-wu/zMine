package testMine;

import java.awt.Color;


/**
 * Entrance tile
 *
 * @author Austin Cheng
 * @version May 24, 2016
 * @author Period: 3
 * @author Assignment: The Final
 *
 * @author Sources: None
 */
public class EntranceTile extends Tile
{

    /**
     * @param x
     *            x
     * @param y
     *            y
     * @param world
     *            world
     */
    public EntranceTile( int x, int y, World world )
    {
        // TODO Auto-generated constructor stub
        super( true, 0, Color.BLUE, x, y, world );
    }


    @Override
    public void destroyTile()
    {
        // cant destroy me hahaha!
    }

}
