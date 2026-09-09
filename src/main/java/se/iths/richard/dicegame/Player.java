package se.iths.richard.dicegame;

public class Player
{
    private final String firstName;
    private final String lastName;
    private int score;

    public Player(String firstName, String lastName)
    {
        if (firstName.isBlank() || lastName.isBlank())
        {
            throw new IllegalArgumentException("Names can't be empty");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = 0;
    }

    public void resetScore()
    {
        score = 0;
    }

    public int getScore()
    {
        return score;
    }

    public void addToScore(int score)
    {
        try
        {
            if (score < 0)
            {
                IO.println("Can't add a negative score!");
                return;
            }

            this.score += score;
        }
        catch (ArithmeticException e)
        {
            IO.println("Error: " + e.getLocalizedMessage());
        }
    }

    public String getFullName()
    {
        return String.format("%s %s", firstName, lastName);
    }

    @Override
    public String toString()
    {
        return getFullName() + "Score: " + this.score;
    }
}
