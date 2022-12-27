# FizzBuzz:
Smells are : long method, comment.
Long method: ‘Say’ is a long method smell.
I have solved these smells by creating an Enum class named ‘Type’. I have finalized the values and checked them using a for each loop. 
Comment: Removed the comment as the code was readable.

# PlaintextToHTMLConverter:
Smells are : comment, large class, long method, switch, duplicate code, and Hidden Dependencies code smell.
Comment: Removed the comments by modifying the methods. Comments were in line 60-61 and 68-69 and removed them as those methods were readable.
Long Method : made methods smaller by using enum and for each loop (i.e. basicHtmlEncode)
Switch case : Replaced all switch cases using the enum
Hidden Dependencies code smell : I removed global variables as they are undesirable because it directly causes the Hidden Dependencies code smell.
Duplicate code: Line 51 was a duplicated code, which I resolved using the for loop.
Deleted method ‘pushACharacterToTheOutput’ as that method wasn’t that much necessary. 


# TriviaGame:
Smells are : long method, switch case, large class,duplicate method,inappropriate naming
Defined the type of every list.
Long method: Used enum Category to refactor the long method and if-else ladder in ‘currentCategory’ method.
Other long methods are : penaltyBoxAction,add,roll,currentCategory, wasCorrectlyAnswered,wrongAnswer
Extracted methods named 'resetPlayerLocationAndAskQuestion','getWinningStatus' for 'roll' and 'wasCorrectlyAnswered' methods. Others were solved by removing the duplication part and method extraction.
Feature Envy :Seperated two classes named Players and TrivialGame were created to seperate their responsibilities. 
Duplicate code: Many code snippet was duplicated in 'roll','wasCorrectlyAnswered','askQuestion' methods,they used large if-else ladder(switch case smell)  which was solved by method extraction name 'updateQuestionSet' 
Inappropriate naming: renamed 'add' and 'roll' method






