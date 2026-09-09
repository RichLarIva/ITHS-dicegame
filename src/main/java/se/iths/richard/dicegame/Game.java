package se.iths.richard.dicegame;

public class Game
{
    private boolean isDone = false;
    private Player playerOne;
    private Player playerTwo;
    public static int round = 0;

    private static final int THROWS_PER_TURN = 2;
    private static final int ROUNDS_PER_TURN = 1;

    private static final String MENU = "Currently in game!\nq. to quit: ";
    private static final String CONTINUE_MENU = "Do you wish to continue?\n1. Yes\n2. No:";

    public void startGame()
    {
        IO.println("WELCOME TO RICHARDS DICE GAME!!!!\n");
        playerOne = createPlayer(1);
        playerTwo = createPlayer(2);
        while (!isDone)
        {
            if (!playRound())
            {
                break;
            }
            round++;
            if (round == ROUNDS_PER_TURN)
            {
                checkWinner();
                if (!askToContinue())
                {
                    isDone = true;
                }
                resetGame();
            }
        }
        IO.println("Goodbye!");
    }

    private boolean playRound()
    {
        if (!takeTurn(playerOne))
        {
            return false;
        }

        return takeTurn(playerTwo);
    }

    private boolean takeTurn(Player player)
    {
        for (int i = 0; i < THROWS_PER_TURN; i++)
        {
            String input = IO.readln(MENU).trim();
            if (input.equalsIgnoreCase("q"))
            {
                return false;
            }
            scorePoints(player);
        }
        scorePoints(player);
        return true;
    }

    private void checkWinner()
    {
        if (playerOne.getScore() > playerTwo.getScore())
        {
            IO.println(playerOne.getFullName() + " won the game!");
        }
        else if (playerOne.getScore() < playerTwo.getScore())
        {
            IO.println(playerTwo.getFullName() + " won the game!");
        }
        else
        {
            IO.println("Nobody won the game!");
        }
    }

    private void scorePoints(Player player)
    {
        int tempScore = Dice.throwDice();
        player.addToScore(tempScore);
        IO.println(player.getFullName() + " threw: " + player.getScore());
    }

    private boolean askToContinue()
    {
        String input = IO.readln(CONTINUE_MENU).trim();
        return !input.equalsIgnoreCase("2") && !input.equalsIgnoreCase("no");
    }

    private void resetGame()
    {
        playerOne.resetScore();
        playerTwo.resetScore();
        round = 0;
    }

    private Player createPlayer(int playersNumber)
    {
        while (true)
        {
            String firstName = IO.readln(String.format("Please put in Player %d's Firstname: ", playersNumber));
            String lastName = IO.readln(String.format("Please put in Player %d's Lastname: ", playersNumber));
            try
            {
                Player player = new Player(firstName, lastName);
                IO.println("Successfully created player");
                return player;
            }
            catch (IllegalArgumentException e)
            {
                IO.println("You can't have a blank name!");
            }
        }
    }

}
