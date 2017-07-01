package testMine;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


/**
 * Player class.
 *
 * @author Austin Cheng, Bryan Wu, Connor Jeng
 * @version May 22, 2016
 * @author Period: 3
 * @author Assignment: The Final
 *
 * @author Sources: None
 */
public class Player extends Character
{
    private int gold;

    private int bombs;

    private boolean bombWait;


    /**
     * @param c
     *            c position
     * @param r
     *            r position
     * @param vC
     *            c velocity
     * @param vR
     *            r velocity
     * @param hitPoints
     *            hitPoints
     * @param color
     *            color
     * @param world
     *            world
     */
    public Player( int x, int y, int vX, int vY, int hitPoints, Color color, World world )
    {
        super( x, y, vX, vY, hitPoints, color, world );
        gold = 0;
        bombs = 10;
        bombWait = false;
    }


    /**
     * @param damage
     *            damage value
     * 
     */
    public void takeDamage( int damage )
    {
        setHP( getHP() - damage );
        System.out.println( getHP() );
        if ( !isAlive() )
        {
            getWorld().playerDeath( this );
        }
    }


    /**
     * Deploys bomb
     */
    public void bomb()
    {
        if ( bombs > 0 && !bombWait )
        {
            bombs--;
            getWorld().bombArea( getX(), getY(), 3000 );
            System.out.println( "Placed bomb" );
            bombWait = true;
            return;
        }
        System.out.println( "Out of bombs! Or wait a bit!" );
    }


    /**
     * Mines tile in front of player.
     */
    public void mine()
    {
        if ( getVX() == 0 && getVY() == 0 ) // player starts out with no
                                            // direction!
        {
            System.out.println( "move!" );
        }
        else
        {
            setCount( getCount() + 1 );
            if ( getCount() == 5 && getY() + getVY() > -1 && getY() + getVY() < getWorld().yDim && getX() + getVX() > -1
                && getX() + getVX() < getWorld().xDim )
            {
                getWorld().theWorld[getY() + getVY()][getX() + getVX()].getTile().destroyTile();
                setCount( 0 );
            }
        }
    }


    /**
     * Returns player's gold amount.
     * 
     * @return gold value
     */
    public int getGold()
    {
        return gold;
    }


    /**
     * Set the bombWait boolean to true or false.
     * 
     * @param b
     *            bomb state
     */
    public void setBombWait( boolean b )
    {
        bombWait = b;
    }


    /**
     * Adds gold value to player's current amount.
     * 
     * @param g
     *            gold value
     */
    public void addGold( int g )
    {
        gold += g;
        System.out.println( "I have this much gold: " + gold );
    }

}
