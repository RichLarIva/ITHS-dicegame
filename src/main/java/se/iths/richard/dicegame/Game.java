package se.iths.richard.dicegame;

public class Game
{
    private boolean isDone = false;
    private Player playerOne;
    private Player playerTwo;
    public static int round = 0;

    private static final String menu = "Currently in game!\nq. to quit";

    public void startGame()
    {

        IO.println("WELCOME TO RICHARDS DICE GAME!!!!\n");

        IO.println("Create first player");
        playerOne = createPlayer(1);

        IO.println("Create second player");
        playerTwo = createPlayer(2);

        while(!isDone)
        {
            IO.println(menu);
            String input = IO.readln();
            switch(input)
            {
                case "q":
                    isDone = true;
                    break;
                default:
                    if(round % 2 == 0)
                    {
                        playerTwo.addToScore(Dice.throwDice());

                    }
            }
        }

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
