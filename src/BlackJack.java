import java.util.*;

public class BlackJack {
    //Holds int values for player and dealer cards
    public static int[] playerCards = new int[16];
    public static int[] dealerCards = new int[16];

    //Counts aces
    public static int playerAce = 0;
    public static int dealerAce = 0;

    //Counts how many cards the player and dealer have (used for iterating the arrays)
    public static int cardNumDealer = 0;
    public static int cardNumPlayer = 0;

    //Scoring
    public static int playerScore = 0;
    public static int dealerScore = 0;

    //Converts cards from a number value to a string value
    public static String cardToString(int cardNum){
        if (cardNum == 1){
            return ("Ace");
        }
        if (cardNum == 2){
            return ("Two");
        }
        if (cardNum == 3){
            return ("Three");
        }
        if (cardNum == 4){
            return ("Four");
        }
        if (cardNum == 5){
            return ("Five");
        }
        if (cardNum == 6){
            return ("Six");
        }
        if (cardNum == 7){
            return ("Seven");
        }
        if (cardNum == 8){
            return ("Eight");
        }
        if (cardNum == 9){
            return ("Nine");
        }
        if (cardNum == 10){
            return ("Ten");
        }
        if (cardNum == 11){
            return ("Jack");
        }
        if (cardNum == 12){
            return ("Queen");
        }
        if (cardNum == 13){
            return ("King");
        }
        else{
            return "";
        }
    }

    //Allows the player to draw a card
    public static void playerDraw(){

        //Random number in range 1-13
        Random rand = new Random();
        int i = (rand.nextInt(13) + 1);
        playerCards[cardNumPlayer] = i;

        //Checking for aces
        if (i == 1){
            playerAce++;
        }
        cardNumPlayer += 1;
        //Checking for faces

        if((i > 10)){
            playerScore +=10;
        }
        //If ace

        else if((i == 1) && (playerScore <= 10)){
            playerScore += 11;
        }
        else{
            playerScore += i;
        }
    }

    //Allows the dealer to draw a card
    public static void dealerDraw(){

        //Random number in range 1-13
        Random rand = new Random();
        int i = (rand.nextInt(13) + 1);
        dealerCards[cardNumDealer] = i;

        //Checking for aces
        if (i == 1){
            dealerAce++;
        }
        cardNumDealer += 1;

        //Checking for faces
        if((i > 10)){
            dealerScore +=10;
        }

        //If ace
        else if((i == 1) && (dealerScore <= 10)){
            dealerScore += 11;
        }
        else{
            dealerScore += i;
        }
    }

    //Prints dealer cards from the array using the cardToString() method
    public static void printDealerCards(int val, int val2){
        System.out.print("Dealer cards: ");
        for (int i = 0 + val; i < cardNumDealer - val2; i++){
            System.out.print(cardToString(dealerCards[i]) + " ");
        }
        System.out.println();
    }

    //Prints player cards from the array using the cardToString() method
    public static void printPlayerCards(){
        System.out.print("Player cards: ");
        for (int i = 0; i < cardNumPlayer; i++){
            System.out.print(cardToString(playerCards[i]) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){

        //variables
        String play;
        Scanner scan = new Scanner(System.in);
        String move;

        //initial config
        System.out.print("===================\n===================\n=  Blackjack 1.0  =\n=  By Max Dadaj   =\n===================\n===================\n");
        System.out.print("\nHello, would you like to play Blackjack? (Y/N): ");
        play = scan.next();
        if(play.equals( "y")){

            //Both the player and the dealer draw 2 cards
            dealerDraw();
            dealerDraw();
            System.out.println();
            System.out.println("******************");
            System.out.println();

            //Only one of the dealer's cards is revealed
            printDealerCards(1, 0);
            System.out.println();
            playerDraw();
            playerDraw();
            printPlayerCards();
            System.out.println();
            System.out.println("******************");
            System.out.println();
            int numPlayerMoves = 1;
            while (playerScore < 21 && (dealerScore - dealerCards[1]) < 21){
                System.out.print("Hit or stand? ");
                move = scan.next();
                if (move.equals("hit")){

                    //Player draws another card
                    playerDraw();
                    System.out.println();

                    //Dealer reveals second card
                    if (numPlayerMoves == 1){
                    System.out.println("******************");
                    System.out.println();
                    System.out.println("Dealer reveals second card: ");
                    System.out.println();
                    System.out.println("******************");
                    System.out.println();
                    printDealerCards(0, 0);
                    }

                    //Checking for an ace
                    if ((playerScore > 21) && (playerAce > 0)){
                        playerScore -= 10;
                        playerAce -= 1;
                    }
                    numPlayerMoves++;
                    System.out.println();
                    printPlayerCards();
                    System.out.println();

                    //Prints difference of scores
                    System.out.println("******************");
                    System.out.println();
                    System.out.println("You are currently " + Math.abs(playerScore - dealerScore) + " points different from the dealer.\n\nYour score: " + playerScore + "\n\nDealer score: " + dealerScore);
                    System.out.println("");
                    System.out.println("******************");
                    System.out.println("");
                }
                else if (move.equals("stand")){

                    //Shows dealer's second card
                    if (cardNumDealer == 2){
                        System.out.println();
                        System.out.println("******************");
                        System.out.println();
                        System.out.print("Dealer reveals second card: \n");
                        printDealerCards(0, 0);
                        System.out.println();
                        System.out.println("******************");
                        System.out.println();
                    }
                    //Exits the loop
                    break;
                }
            
            }

            //Checks if the player busts (score exceeding 21).
            if(playerScore > 21){
                System.out.println("Player busts. Dealer wins.");
                System.out.println();
                System.out.println("******************");
                System.out.println();
                System.out.println("Your score: " + playerScore + "\n\nDealer score: " + dealerScore);
                System.exit(0);
            }

            //The dealer is not allowed to draw after they have a score above 17.
            while (dealerScore < 17){
                System.out.println("Dealer is drawing...");
                System.out.println();
                System.out.println("******************");
                System.out.println();
                dealerDraw();

                //Checking for an ace
                if ((dealerScore > 21) && (dealerAce > 0)){
                        dealerScore -= 10;
                        dealerAce -= 1;
                    }

            }

            //Checks if the dealer busts (score exceeding 21).
            if (dealerScore > 21){
                System.out.println("Dealer busts. player wins.");
                System.out.println();
                System.out.println("******************");
                System.out.println();
                System.out.println("Your score: " + playerScore + "\n\nDealer score: " + dealerScore);
                System.out.println();
                System.out.println("******************");
                System.out.println();
                printDealerCards(0,0);
                System.out.println();
                printPlayerCards();
                System.out.println();
                System.out.println("******************");
                System.out.println();
            }else{

                //Checks if the player has a higher score
                if (playerScore > dealerScore){
                    System.out.println("Player wins!");
                    System.out.println();
                    System.out.println("******************");
                    System.out.println();
                    System.out.println("Your score: " + playerScore + "\n\nDealer score: " + dealerScore);
                    System.out.println();
                    System.out.println("******************");
                    System.out.println();
                    printDealerCards(0,0);
                    System.out.println();
                    printPlayerCards();
                    System.out.println();
                    System.out.println("******************");
                    System.out.println();
                }

                //Checks if the dealer holds a higher score
                else if (playerScore < dealerScore){
                    System.out.println("Dealer wins!");
                    System.out.println();
                    System.out.println("******************");
                    System.out.println();
                    System.out.println("Your score: " + playerScore + "\n\nDealer score: " + dealerScore);
                    System.out.println();
                    System.out.println("******************");
                    System.out.println();
                    printDealerCards(0,0);
                    System.out.println();
                    printPlayerCards();
                    System.out.println();
                    System.out.println("******************");
                    System.out.println();
                }

                //Checks if the player and dealer scores are the same
                else if(playerScore == dealerScore){
                    System.out.println("Push!");
                    System.out.println();
                    System.out.println("******************");
                    System.out.println();
                    System.out.println("Your score: " + playerScore + "\n\nDealer score: " + dealerScore);
                    System.out.println();
                    System.out.println("******************");
                    System.out.println();
                    printDealerCards(0,0);
                    System.out.println();
                    printPlayerCards();
                    System.out.println();
                    System.out.println("******************");
                    System.out.println();
                }
            }
        }
        
        //If the user does not want to play, the program terminates.
        else{
            System.out.println("Goodbye. Exiting...");
        }
    }
    
}
