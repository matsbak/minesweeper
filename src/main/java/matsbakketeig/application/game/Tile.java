package matsbakketeig.application.game;

/**
 * The Tile class represents a tile in the minefield. A tile has attributes such as if it is hidden, flagged or a mine or not. A
 * tile also has a number revealing how many mines are surrounding the tile.
 * 
 * <p>A tile is by default hidden, not flagged nor a mine, and a number 0.</p>
 * 
 * @author  Mats Bakketeig
 * @version v1.0 (04.07.2023)
 */
public class Tile
{
    // Class fields
    private boolean hidden;
    private int number;
    private boolean mine;
    private boolean flagged;

    /**
     * Constructs an instance of the Tile class.
     */
    public Tile()
    {
        this.hidden = true;
        this.number = 0;
        this.mine = false;
        this.flagged = false;
    }

    /**
     * Returns if a tile is hidden or not.
     * 
     * @return If a tile is hidden or not.
     */
    public boolean getHidden()
    {
        return this.hidden;
    }

    /**
     * Returns the number of the tile.
     * 
     * @return The number of the tile.
     */
    public int getNumber()
    {
        return this.number;
    }

    /**
     * Returns if a tile is a mine or not.
     * 
     * @return If a tile is a mine or not.
     */
    public boolean getMine()
    {
        return this.mine;
    }

    /**
     * Returns if a tile is flagged or not.
     * 
     * @return If a tile is flagged or not.
     */
    public boolean getFlagged()
    {
        return this.flagged;
    }

    /**
     * Shows a tile.
     */
    public void show()
    {
        this.hidden = false;
    }

    /**
     * Increments the number of a tile by 1.
     */
    public void increment()
    {
        this.number++;
    }

    /**
     * Plants a mine on a tile.
     */
    public void plant()
    {
        this.mine = true;
    }

    /**
     * Flags a tile.
     */
    public void flag()
    {
        this.flagged = true;
    }

    /**
     * Unflags a tile.
     */
    public void unflag()
    {
        this.flagged = false;
    }
}
