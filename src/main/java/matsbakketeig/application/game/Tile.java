package matsbakketeig.application.game;

public class Tile
{
    private boolean hidden;
    private int number;
    private boolean mine;
    private boolean flagged;

    public Tile()
    {
        this.hidden = true;
        this.number = 0;
        this.mine = false;
        this.flagged = false;
    }

    public boolean getHidden()
    {
        return this.hidden;
    }

    public int getNumber()
    {
        return this.number;
    }

    public boolean getMine()
    {
        return this.mine;
    }

    public boolean getFlagged()
    {
        return this.flagged;
    }

    public void show()
    {
        this.hidden = false;
    }

    public void increment()
    {
        this.number++;
    }

    public void plant()
    {
        this.mine = true;
    }

    public void flag()
    {
        this.flagged = true;
    }

    public void unflag()
    {
        this.flagged = false;
    }
}
