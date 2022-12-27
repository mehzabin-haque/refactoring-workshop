package workshop;

import java.util.ArrayList;
import java.util.LinkedList;

public class TriviaGame {
    LinkedList<String> popQuestions = new LinkedList<>();
    LinkedList<String> scienceQuestions = new LinkedList<>();
    LinkedList<String> sportsQuestions = new LinkedList<>();
    LinkedList<String> rockQuestions = new LinkedList<>();

    Players player = new Players();

    public TriviaGame() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question " + i);
        }
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

     String currentCategory() {
    
        for (Category c : Category.values()) {
            if ((places[currentPlayer]-c.val)%4==0){
                return  c.type;
            }
        }

        return Category.ROCK.type;
       
    }
    

}
