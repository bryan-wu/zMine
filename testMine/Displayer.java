package testMine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;


/**
 * Displayer for enemy, player, and world
 *
 * @author Austin Cheng and Connor Jeng
 * @version May 24, 2016
 * @author Period: 3
 * @author Assignment: The Final
 *
 * @author Sources: urmum
 */
public class Displayer extends JPanel
{
    World world;

    int width;

    int height;

    Graphics g;

    // Bullet bullet;//ill do this later
    Enemy enemy;

    Player player;

    Dimension x;

    boolean endTheGame = false;

    private String words = "Gold: ";

    private String say = "";

    private String whatistime = "Time underground: ";

    private String saytime = "";


    /**
     * Empty method for displayer
     */
    public Displayer()
    {

    }


    /**
     * Add world dimensions
     * 
     * @param w
     *            world
     */
    public void addWorld( World w )
    {
        world = w;
        width = w.xDim * 10;
        height = w.yDim * 10;
        x = new Dimension( width, height );
        world.setDisplayer( this );
        this.setSize( x );

    }


    @Override
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.translate( width / 2 - world.thePlayers.get( 0 ).getX() * 20,
            height / 2 - world.thePlayers.get( 0 ).getY() * 20 );
        this.g = g;
        g.setColor( Color.BLACK );
        g.fillRect( -width, -height, width * 4, height * 4 );
        for ( int x = 0; x < world.theWorld[0].length; x++ )
        {
            for ( int y = 0; y < world.theWorld.length; y++ )
            {
                drawTile( world.theWorld[y][x], x, y );
            }
        }

        for ( int x = 0; x < world.thePlayers.size(); x++ )
        {
            drawPlayer( world.thePlayers.get( x ) );
        }

        for ( int x = 0; x < world.theEnemies.size(); x++ )
        {
            drawEnemy( world.theEnemies.get( x ) );
        }
        g.setColor( Color.WHITE );
        say = world.thePlayers.get( 0 ).getGold() + "";
        say = words + say;
        saytime = world.countoftime / 100 + "";
        saytime = whatistime + saytime;
        g.setFont( new Font( "Courier", Font.BOLD, 30 ) );
        g.drawString( say, world.thePlayers.get( 0 ).getX() * 20 - 200, world.thePlayers.get( 0 ).getY() * 20 - 200 );
        g.drawString( saytime,
            world.thePlayers.get( 0 ).getX() * 20 - 200,
            world.thePlayers.get( 0 ).getY() * 20 - 160 );
        if ( endTheGame )
        {
            g.translate( -(width / 2 - world.thePlayers.get( 0 ).getX() * 20),
            -(height / 2 - world.thePlayers.get( 0 ).getY() * 20 ));
            world.endGame( g );
        }
    }


    /**
     * Draws player
     * 
     * @param player2
     *            player2
     */
    private void drawPlayer( Player player2 )
    {
        player2.drawMe( g );
    }


    /**
     * Draw Enemy
     * 
     * @param enemy2
     *            enemy2
     */
    private void drawEnemy( Enemy enemy2 )
    {
        if ( 6 > distance( world.thePlayers.get( 0 ).getX(), enemy2.getX() )
            + distance( world.thePlayers.get( 0 ).getY(), enemy2.getY() ) )
        {
            enemy2.drawMe( g );
        }
        else
        {
            // enemy2.drawMe( g );
            // dont draw over the black tile
        }
    }


    /**
     * Draw tile
     * 
     * @param dTile
     *            dTile
     * @param x
     *            x
     * @param y
     *            y
     */
    public void drawTile( Tile dTile, int x, int y )
    {
        if ( 6 > distance( world.thePlayers.get( 0 ).getX(), x ) + distance( world.thePlayers.get( 0 ).getY(), y ) )
        {
            dTile.drawSelf( g );
        }
        else
        {
            // dTile.drawSelf( g );
            g.drawRect( x, y, 20, 20 );
        }
    }


    /**
     * Distance between two objects
     * 
     * @param x
     *            x
     * @param y
     *            y
     * @return
     */
    public int distance( int x, int y )
    {
        return Math.abs( x - y );
    }
}
