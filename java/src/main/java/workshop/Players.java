package workshop;

import java.util.ArrayList;
import java.util.LinkedList;

public class Players {

   private ArrayList<String> players = new ArrayList<>();
    int limits = 6;
    int[] places = new int[limits];
    int[] purses = new int[limits];
    boolean[] inPenaltyBox = new boolean[limits];


    TriviaGame triviaGame = new TriviaGame();

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public int howManyPlayers() {
        return players.size();
    }

    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == limits);
    }
    
    private boolean WinningStatus() {
        announce("Answer was correct!!!!");
        purses[currentPlayer]++;
        announce(players.get(currentPlayer)
                + " now has "
                + purses[currentPlayer]
                + " Gold Coins.");

        boolean winner = didPlayerWin();
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;

        return winner;
    }

    public void PlayerPositionAndRoll(int roll) {
        announce(players.get(currentPlayer) + " is the current player");
        announce("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;
                announce(players.get(currentPlayer) + " is getting out of the penalty box");
                PlayerLocationResetAndAskQuestion(roll);

            } else {
                announce(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else PlayerLocationResetAndAskQuestion(roll);
    }

    private void PlayerLocationResetAndAskQuestion(int roll) {
        places[currentPlayer] = places[currentPlayer] + roll;
        if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

        announce(players.get(currentPlayer)
                + "'s new location is "
                + places[currentPlayer]);
        announce("The category is " + triviaGame.currentCategory());
        triviaGame.askQuestion();
    }
    
    public boolean addPlayersAndDetails(String playerName) {

        players.add(playerName);
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        announce(playerName + " was added");
        announce("They are player number " + players.size());
        return true;
    }

    public boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayer]) {
            if (isGettingOutOfPenaltyBox) return getWinningStatus();
            else {
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;
                return true;
            }

        } else return getWinningStatus();
    }


    public boolean wrongAnswer() {
        announce("Question was incorrectly answered");
        announce(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
    }

    protected void announce(Object message) {
        System.out.println(message);
    }

}
