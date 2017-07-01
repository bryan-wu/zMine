package testMine;

import java.awt.BorderLayout;

import javax.swing.JFrame;


/**
 * Main.
 *
 * @author Austin Cheng
 * @version May 25, 2016
 * @author Period: 3
 * @author Assignment: The Final
 *
 * @author Sources: None
 */
public class Main
{

    /**
     * Main.
     * 
     * @param args
     *            args
     */
    public static void main( String[] args )
    {
        // basic parameters
        int X = 50;
        int Y = 50;
        int players = 1;
        int enemies = 25;
        // create a listener first
        Listener lis = new Listener();
        // displayer
        Displayer dis = new Displayer();
        World world = new World( X, Y, players, enemies, lis );
        BorderLayout layout = new BorderLayout();

        dis.addWorld( world );
        JFrame frame = new JFrame();
        frame.setSize( X * 10 + 6, Y * 10 + 28 );
        frame.setLayout( layout );
        frame.add( dis, BorderLayout.CENTER );
        frame.addKeyListener( lis );

        frame.setVisible( true );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setResizable( false );
        world.runWorld();
    }
}