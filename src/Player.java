/*
* Class Player, used to represent individual players,
* and their in game attributes.
* */
public class Player {
    private String name;
    private String guess;
    private int points = 0;
    /*
    * Constructor method for class Player.
    *
    * @param        String variable used to init player name
    * */
    public Player(String s) {
        this.name = s;
    }
    /*
    * Method for getting player name.
    *
    * @return       String representation of player name
    * */
    public String getName() {
        return name;
    }
    /*
    * Method for setting player name.
    *
    * @param        String for setting name
    * */
    public void setName(String name) {
        this.name = name;
    }
    /*
    * Method for getting players current score.
    *
    * @return       Returns an integer representation of player score
    * */
    public int getPoints() {
        return points;
    }
    /*
    * Method for increasing player score points.
    *
    * @param        Receive an integer to be added to current score
    * */
    public void setPoints(int points) {
        this.points += points;
    }

    /*
    * Method for getting players current guess.
    *
    * @return       String representation of player guess
    * */
    public String getGuess() {
        return guess;
    }
    /*
    * Method for setting players current guess.
    *
    * @param        String containing player inserted guess value
    * */
    public void setGuess(String guess) {
        this.guess = guess;
    }
    /*
    * An overwritten method for getting a String representation of Player object.
    *
    * @return       String representation of Player objects attributes
    * */
    @Override
    public String toString() {
        return this.getName() + ": " + this.getPoints();
    }
}
