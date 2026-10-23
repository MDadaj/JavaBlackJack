# Java BlackJack

### By Max Dadaj

## About this project:

I am a freshman Computer Science major, and I wanted to try to build something outside of my coursework, so I decided to recreate a card game using Java, the language I'm currently learning. It has been put together over extra time after I completed my homework, and is my first individual project (not for class). I plan to keep working on it, and I already have some plans for some new updates and functionality to come in future updates. 

## How to use:
First, ensure you have some version of Java installed:

```
java --version
```
```
javac --version
```

Then, enter the following into your terminal:

```
cd /path/to/folder-containing-BlackJack
```

```
javac BlackJack.java
```

```
java BlackJack
```

---

## Methods and method functions:
* `main(String[] args)`
    * Takes user input.
    * Runs playGame().
    * Asks the user if they want to play again and resets variables.

* `playGame()`
    * Allows player to take turns, choosing between a 'hit' or a 'stand'.
    * Hold win/loss conditions, and displays end message based on outcome.
    * Conditions checked:
        * Player can only take a turn when their score is less than 21.
        * The dealer is able to draw until they have a score of 17 or if their score exceeds 21.
        * Player wins if:
            * Dealer busts (score over 21).
            * Dealer can no longer draw, and player has a higher score.
        * Dealer wins if:
            * Player busts (score over 21).
            * Player chooses to stand, but the dealer ends with a higher score.
        * Draw (push) if scores are equal.
    
* `cardToString(int cardNum)`
    * Takes an input (1-13), and returns a string with the card name assigned to that number.

* `playerDraw()`
    * Picks a random number between 1 and 13, with 1 being ace, and 11-13 being face cards.
    * If an ace is drawn, one is added to playerAce, and 11 is added to playerScore.
    * If a face card is drawn, 10 is added to playerScore.

* `dealerDraw()`
    * Picks a random number between 1 and 13, with 1 being ace, and 11-13 being face cards.
    * If an ace is drawn, one is added to dealerAce, and 11 is added to dealerScore.
    * If a face card is drawn, 10 is added to dealerScore.

* `printPlayerCards()`
    * Calls `cardToString(playerCards[i])`, and prints every populated value of playerCards using a `for` loop.

* `printDealerCards()`
    * Calls `cardToString(dealerCards[i])`, and prints every populated value of dealerCards using a `for` loop.

* `finManager(String func, int amt)`
    * Implements a banking system.
    * Uses a switch for functions:
        * start: sets bank to the given amount.
        * doubledown: deducts the original bet again, and adds that value to hold.
        * lose: clears hold.
        * win: adds hold * 2 to the player's bank.
        * push: returns the player's money and clears hold.


## Future plans and upgrades:

* Monetary system: [x]
    * Implementing a banking system so that the user can bet [x]
    * Adding a starting amount of currency for the user [x]
    * Adding the option to double down on the player's turn [x]
* Splitting:
    * Adding a way for the user to split if they have 2 of the same cards (make 2 hands)
    * Utilizing the monetary system to hold more of the user's credits if they choose to split, with the chance of a higher reward
* Classes:
    * Making a separate class for cards, to make them easier to manage and for simplification of code.
 
## Gameplay Sample:

```
===================
===================
=  Blackjack 1.0  =
=  By Max Dadaj   =
===================
===================

Hello, would you like to play Blackjack? (Y/N): y

******************

How much would you like to bet? you currently have $5000. 500

******************

Dealer cards: Three 

Player cards: Jack Jack 

******************

Hit or stand? You may also choose to double down ("dd"): stand

******************

Dealer reveals second card: 
Dealer cards: Seven Three 

******************

Dealer is drawing...

******************

Push!

******************

Your score: 20

Dealer score: 20

******************

Dealer cards: Seven Three Jack 

Player cards: Jack Jack 

******************

You have a balance of $5000 remaining.

******************

Would you like to play again? 

```
