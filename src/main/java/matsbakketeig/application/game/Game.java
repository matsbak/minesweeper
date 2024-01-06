package matsbakketeig.application.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
  private List<List<Tile>> minefield;

  public Game(int rows, int columns, int mines) {
    if (rows <= 0) {
      throw new IllegalArgumentException("Specified amount of rows is negative or 0 in the " +
                                         "constructor");
    }
    if (columns <= 0) {
      throw new IllegalArgumentException("Specified amount of columns is negative or 0 in the " +
                                         "constructor");
    }
    if (mines <= 0) {
      throw new IllegalArgumentException("Specified amount of mines is negative or 0 in the " +
                                         "constructor");
    }
    if (mines > (rows * columns)) {
      throw new IllegalArgumentException("Specified amount of mines is greater than amount of " +
                                         "tiles in the constructor");
    }
    this.generateTiles(rows, columns, mines);
  }

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

    this.updateNumbers(tilesLists, rows, columns);
  }

  private void updateNumbers(List<List<Tile>> tilesLists, int rows, int columns) {
    List<List<Tile>> updatedTilesLists = new ArrayList<>();

    for (int i = 0; i < rows; i++) {
      List<Tile> updatedRow = new ArrayList<>();
            
      List<Tile> tilesList = tilesLists.get(i);
      List<Tile> prevTilesList = null;
      List<Tile> nextTilesList = null;

      try {
        prevTilesList = tilesLists.get(i - 1);
      } catch (IndexOutOfBoundsException e) {
      }
      try {
        nextTilesList = tilesLists.get(i + 1);
      } catch (IndexOutOfBoundsException e) {
      }

      for (int j = 0; j < columns; j++) {
        Tile tile = tilesList.get(j);

        if (tile.getMine() == false) {
          try {
            if (tilesList.get(j - 1).getMine() == true) {
              tile.increment();
            }
          } catch (IndexOutOfBoundsException e) {
          }
          try {
            if (tilesList.get(j + 1).getMine() == true) {
              tile.increment();
            }
          } catch (IndexOutOfBoundsException e) {
          }
          if (prevTilesList != null) {
            if (prevTilesList.get(j).getMine() == true) {
              tile.increment();
            }
            try {
              if (prevTilesList.get(j - 1).getMine() == true) {
                tile.increment();
              }
            } catch (IndexOutOfBoundsException e) {
            }
            try {
              if (prevTilesList.get(j + 1).getMine() == true) {
                tile.increment();
              }
            } catch (IndexOutOfBoundsException e) {
            }
          }
          if (nextTilesList != null) {
            if (nextTilesList.get(j).getMine() == true) {
              tile.increment();
            }
            try {
              if (nextTilesList.get(j - 1).getMine() == true) {
                tile.increment();
              }
            } catch (IndexOutOfBoundsException e) {
            }
            try {
              if (nextTilesList.get(j + 1).getMine() == true) {
                tile.increment();
              }
            } catch (IndexOutOfBoundsException e) {
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
