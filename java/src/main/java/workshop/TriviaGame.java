package workshop;

import java.util.ArrayList;
import java.util.LinkedList;

public class TriviaGame {
    private ArrayList<String> players = new ArrayList<>();
    int limits = 6;
    int[] places = new int[limits];
    int[] purses = new int[limits];
    boolean[] inPenaltyBox = new boolean[limits];

    LinkedList<String> popQuestions = new LinkedList<>();
    LinkedList<String> scienceQuestions = new LinkedList<>();
    LinkedList<String> sportsQuestions = new LinkedList<>();
    LinkedList<String> rockQuestions = new LinkedList<>();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public TriviaGame() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public void add(String playerName) {

        players.add(playerName);
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        announce(playerName + " was added");
        announce("They are player number " + players.size());
        
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void rollPlayerLocation(int roll) {
        announce(players.get(currentPlayer) + " is the current player");
        announce("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;
                announce(players.get(currentPlayer) + " is getting out of the penalty box");
                resetPlayerLocationAndAskQuestion(roll);

            } else {
                announce(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else resetPlayerLocationAndAskQuestion(roll);
    }

    void askQuestion() {
        updateQuestionSet("Pop", popQuestions);
        updateQuestionSet("Science", scienceQuestions);
        updateQuestionSet("Sports", sportsQuestions);
        updateQuestionSet("Rock", rockQuestions);
    }

    private void updateQuestionSet(String category, LinkedList questionSet) {
        if (currentCategory().equals(category))
            player.announce(questionSet.removeFirst());
    }

    private String currentCategory() {
    
        for (Category c : Category.values()) {
            if ((places[currentPlayer]-c.val)%4==0){
                return  c.type;
            }
        }

        return Category.ROCK.type;
       
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
    private boolean didPlayerWin() {
        return purses[currentPlayer] != limits;
    }

    protected void announce(Object message) {
        System.out.println(message);
    }
}
