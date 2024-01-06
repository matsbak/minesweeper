package matsbakketeig.application.game;

/**
 * The Tile class represents a tile in the minefield. A tile has attributes such as being hidden,
 * flagged or a mine or not. A tile also has a number revealing how many mines are surrounding the
 * tile.
 * 
 * <p>A tile is by default hidden, not flagged and not a mine. The number revealing how many mines
 * are surrounding the tile is by default 0.</p>
 * 
 * @author  Mats Bakketeig
 * @version v1.0 (04.07.2023)
 */
public class Tile {
  // Class fields
  private boolean hidden;
  private int number;
  private boolean mine;
  private boolean flagged;

  /**
   * Constructs an instance of the Tile class.
   */
  public Tile() {
    this.hidden = true;
    this.number = 0;
    this.mine = false;
    this.flagged = false;
  }

  /**
   * Returns true if the tile is hidden or false if it is not.
   * 
   * @return True if the tile is hidden or false if it is not
   */
  public boolean getHidden() {
    return this.hidden;
  }

  /**
   * Returns the number of mines surrounding the tile.
   * 
   * @return The number of mines surrounding the tile
   */
  public int getNumber() {
    return this.number;
  }

  /**
   * Returns true if the tile is a mine or false if it is not.
   * 
   * @return True if the tile is a mine or false if it is not
   */
  public boolean getMine() {
    return this.mine;
  }

  /**
   * Returns true if the tile is flagged or false if it is not.
   * 
   * @return True if the tile is flagged or false if it is not
   */
  public boolean getFlagged() {
    return this.flagged;
  }

  /**
   * Shows the tile.
   */
  public void show() {
    this.hidden = false;
  }

  /**
   * Increments the number of the tile by 1.
   */
  public void increment() {
    this.number++;
  }

  /**
   * Plants a mine on the tile.
   */
  public void plant() {
    this.mine = true;
  }

  /**
   * Flags the tile.
   */
  public void flag() {
    this.flagged = true;
  }

  /**
   * Unflags the tile.
   */
  public void unflag() {
    this.flagged = false;
  }
}
