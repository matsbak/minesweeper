package matsbakketeig.application.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game
{
    private List<List<Tile>> minefield;

    public Game(int rows, int columns, int mines)
    {
        if(rows <= 0)
        {
            throw new IllegalArgumentException("Specified amount of rows is negative or 0 in the constructor");
        }
        if(columns <= 0)
        {
            throw new IllegalArgumentException("Specified amount of columns is negative or 0 in the constructor");
        }
        if(mines <= 0)
        {
            throw new IllegalArgumentException("Specified amount of mines is negative or 0 in the constructor");
        }
        if(mines > (rows * columns))
        {
            throw new IllegalArgumentException("Specified amount of mines is greater than amount of tiles in the constructor");
        }

        List<Tile> tiles = this.generateTiles(rows, columns, mines);

        List<List<Tile>> tilesLists = this.allocateTiles(tiles, rows, columns);

        List<List<Tile>> updatedTilesLists = this.updateNumbers(tilesLists, rows, columns);

        this.minefield = updatedTilesLists;
    }

    private List<Tile> generateTiles(int rows, int columns, int mines)
    {
        List<Tile> tiles = new ArrayList<>();

        int nonMines = (rows * columns) - mines;

        for(int i = 0; i < nonMines; i++)
        {
            Tile tile = new Tile();

            tiles.add(tile);
        }
        for(int i = 0; i < mines; i++)
        {
            Tile tile = new Tile();

            tile.plant();

            tiles.add(tile);
        }

        Collections.shuffle(tiles);

        return tiles;
    }

    private List<List<Tile>> allocateTiles(List<Tile> tiles, int rows, int columns)
    {
        List<List<Tile>> tilesLists = new ArrayList<>();
        
        for(int i = 0; i < rows; i++)
        {
            List<Tile> row = new ArrayList<>();

            for(int j = 0; j < columns; j++)
            {
                Tile tile = tiles.get(0);

                row.add(tile);

                tiles.remove(0);
            }

            tilesLists.add(row);
        }

        return tilesLists;
    }

    private List<List<Tile>> updateNumbers(List<List<Tile>> tilesLists, int rows, int columns)
    {
        List<List<Tile>> updatedTilesLists = new ArrayList<>();

        for(int i = 0; i < rows; i++)
        {
            List<Tile> updatedRow = new ArrayList<>();
            
            List<Tile> tilesList = tilesLists.get(i);
            List<Tile> prevTilesList = null;
            List<Tile> nextTilesList = null;

            try
            {
                prevTilesList = tilesLists.get(i - 1);
            }
            catch(IndexOutOfBoundsException exception)
            {
            }
            try
            {
                nextTilesList = tilesLists.get(i + 1);
            }
            catch(IndexOutOfBoundsException exception)
            {
            }

            for(int j = 0; j < columns; j++)
            {
                Tile tile = tilesList.get(j);

                if(!tile.getMine())
                {
                    try
                    {
                        if(tilesList.get(j - 1).getMine())
                        {
                            tile.increment();
                        }
                    }
                    catch(IndexOutOfBoundsException exception)
                    {
                    }
                    try
                    {
                        if(tilesList.get(j + 1).getMine())
                        {
                            tile.increment();
                        }
                    }
                    catch(IndexOutOfBoundsException exception)
                    {
                    }
                    if(prevTilesList != null)
                    {
                        if(prevTilesList.get(j).getMine())
                        {
                            tile.increment();
                        }
                        try
                        {
                            if(prevTilesList.get(j - 1).getMine())
                            {
                                tile.increment();
                            }
                        }
                        catch(IndexOutOfBoundsException exception)
                        {
                        }
                        try
                        {
                            if(prevTilesList.get(j + 1).getMine())
                            {
                                tile.increment();
                            }
                        }
                        catch(IndexOutOfBoundsException exception)
                        {
                        }
                    }
                    if(nextTilesList != null)
                    {
                        if(nextTilesList.get(j).getMine())
                        {
                            tile.increment();
                        }
                        try
                        {
                            if(nextTilesList.get(j - 1).getMine())
                            {
                                tile.increment();
                            }
                        }
                        catch(IndexOutOfBoundsException exception)
                        {
                        }
                        try
                        {
                            if(nextTilesList.get(j + 1).getMine())
                            {
                                tile.increment();
                            }
                        }
                        catch(IndexOutOfBoundsException exception)
                        {
                        }
                    }
                }

                updatedRow.add(tile);
            }

            updatedTilesLists.add(updatedRow);
        }

        return updatedTilesLists;
    }
}
