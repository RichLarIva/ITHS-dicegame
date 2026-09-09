package se.iths.richard.dicegame;

import java.util.random.RandomGenerator;

public class Dice
{
    public static int throwDice()
    {
        RandomGenerator randomGenerator = RandomGenerator.getDefault();
        int diceRoll = randomGenerator.nextInt(1, 7); // 7 because its does otherwise not generate 6!
        return diceRoll;
    }
}
