package matsbakketeig.application.game.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Game class represents the game logic of a minesweeper game. To make the logic of a game, the
 * desired amount of rows, columns and mines has to be passed to the constructor.
 * 
 * @author  Mats Bakketeig
 * @version v1.3 (2024.01.06)
 */
public class Game {
  // Class fields
  private List<List<Tile>> minefield;

  /**
   * Constructs an instance of the Game class.
   * 
   * <p>The specified amount of rows, columns and mines cannot be negative or 0 and the specified
   * amount of mines cannot be greater than the amount of tiles.</p>
   * 
   * @param rows The specified amount of rows
   * @param columns The specified amount of columns
   * @param mines The specified amount of mines
   */
  public Game(int rows, int columns, int mines) {
    if (rows <= 0) {
      throw new IllegalArgumentException("The specified amount of rows is negative or 0 in the " +
                                         "constructor");
    }
    if (columns <= 0) {
      throw new IllegalArgumentException("The specified amount of columns is negative or 0 in " +
                                         "the constructor");
    }
    if (mines <= 0) {
      throw new IllegalArgumentException("The specified amount of mines is negative or 0 in the " +
                                         "constructor");
    }
    if (mines > (rows * columns)) {
      throw new IllegalArgumentException("The specified amount of mines is greater than the " +
                                         "amount of tiles in the constructor");
    }
    this.generateTiles(rows, columns, mines);
  }

  /**
   * Generates all tiles to be used in the game and puts them in a list, which is shuffled
   * afterwards.
   * 
   * @param rows The specified amount of rows
   * @param columns The specified amount of columns
   * @param mines The specified amount of mines
   */
  private void generateTiles(int rows, int columns, int mines) {
    List<Tile> tiles = new ArrayList<>();

    int nonMines = (rows * columns) - mines;

    for (int i = 0; i < nonMines; i++) {
      Tile tile = new Tile();

      tiles.add(tile);
    }
    for (int i = 0; i < mines; i++) {
      Tile tile = new Tile();

      tile.plant();

      tiles.add(tile);
    }

    Collections.shuffle(tiles);

    this.allocateTiles(tiles, rows, columns);
  }

  /**
   * Allocates all tiles in the specified list of tiles to new lists of tiles for each row, which
   * are again put in a list of lists of tiles.
   * 
   * @param tiles The specified list of tiles
   * @param rows The specified amount of rows
   * @param columns The specified amount of columns
   */
  private void allocateTiles(List<Tile> tiles, int rows, int columns) {
    List<List<Tile>> tilesLists = new ArrayList<>();
        
    for (int i = 0; i < rows; i++) {
      List<Tile> row = new ArrayList<>();

      for (int j = 0; j < columns; j++) {
        Tile tile = tiles.get(0);

        row.add(tile);

        tiles.remove(0);
      }

      tilesLists.add(row);
    }

    this.updateTileMines(tilesLists, rows, columns);
  }

  /**
   * Updates the number revealing how many mines are surrounding the tile for each tile. This is
   * done by first checking if the tile is a mine. If the tile is not a mine, the eight tiles
   * surrounding the tile are checked. For each mine in the eight tiles surrounding the tile, the
   * number revealing how many mines are surrounding the tile is incremented.
   * 
   * <p>Because of the nature of this process, tiles that do not exist might be checked. If for
   * example, the tiles surrounding a tile at a corner are checked, tiles that do not exist will be
   * checked since the code expects to check eight tiles and not three. This is solved by simply
   * making the code skip to checking the next surrounding tile each time a tile that does not
   * exist is checked.</p>
   * 
   * @param tilesLists The specified list of lists of tiles
   * @param rows The specified amount of rows
   * @param columns The specified amount of columns
   */
  private void updateTileMines(List<List<Tile>> tilesLists, int rows, int columns) {
    List<List<Tile>> updatedTilesLists = new ArrayList<>();

    for (int i = 0; i < rows; i++) {
      List<Tile> updatedRow = new ArrayList<>();
            
      List<Tile> tilesList = tilesLists.get(i);
      List<Tile> prevTilesList = null;
      List<Tile> nextTilesList = null;

      try {
        prevTilesList = tilesLists.get(i - 1);
      } catch (IndexOutOfBoundsException e) {
        // Intentionally left blank
      }
      try {
        nextTilesList = tilesLists.get(i + 1);
      } catch (IndexOutOfBoundsException e) {
        // Intentionally left blank
      }

      for (int j = 0; j < columns; j++) {
        Tile tile = tilesList.get(j);

        if (!tile.getMine()) {
          try {
            if (tilesList.get(j - 1).getMine()) {
              tile.increment();
            }
          } catch (IndexOutOfBoundsException e) {
            // Intentionally left blank
          }
          try {
            if (tilesList.get(j + 1).getMine()) {
              tile.increment();
            }
          } catch (IndexOutOfBoundsException e) {
            // Intentionally left blank
          }
          if (prevTilesList != null) {
            if (prevTilesList.get(j).getMine()) {
              tile.increment();
            }
            try {
              if (prevTilesList.get(j - 1).getMine()) {
                tile.increment();
              }
            } catch (IndexOutOfBoundsException e) {
              // Intentionally left blank
            }
            try {
              if (prevTilesList.get(j + 1).getMine()) {
                tile.increment();
              }
            } catch (IndexOutOfBoundsException e) {
              // Intentionally left blank
            }
          }
          if (nextTilesList != null) {
            if (nextTilesList.get(j).getMine()) {
              tile.increment();
            }
            try {
              if (nextTilesList.get(j - 1).getMine()) {
                tile.increment();
              }
            } catch (IndexOutOfBoundsException e) {
              // Intentionally left blank
            }
            try {
              if (nextTilesList.get(j + 1).getMine()) {
                tile.increment();
              }
            } catch (IndexOutOfBoundsException e) {
              // Intentionally left blank
            }
          }
        }

        updatedRow.add(tile);
      }

      updatedTilesLists.add(updatedRow);
    }

    this.minefield = updatedTilesLists;
  }
}
