/*
* Class Player, used to represent individual players,
* and their in game attributes.
* */
public class Player {
    private String name;
    private String guess;
    private int points = 0;

    public Player(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points += points;
    }
    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }
    @Override
    public String toString() {
        return this.getName() + ": " + this.getPoints();
    }
}
