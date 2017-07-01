package testMine;

import java.awt.Color;


/**
 * Regular tile.
 *
 * @author Austin Cheng
 * @version May 25, 2016
 * @author Period: 3
 * @author Assignment: The Final
 *
 * @author Sources: None
 */
public class RegularTile extends Tile
{
    /**
     * @param passable
     *            passable.
     * @param loot
     *            loot
     * @param color
     *            color
     * @param x
     *            x
     * @param y
     *            y
     * @param world
     *            world
     */
    public RegularTile( boolean passable, int loot, Color color, int x, int y, World world )
    {
        super( passable, loot, color, x, y, world );
    }
}