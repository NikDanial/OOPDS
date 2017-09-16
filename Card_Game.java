
/**
 * Main driver program for classes Card_Player and Card
 * @author Nadhirah
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

public class Card_Game {
	
/** 
 * Method to easily display used cards in
 * either list D, H, C and S 
 * @param usedCards a String list to store used cards
 */
public static void DisplayUsedCards(List<String> usedCards){
    for (int i=0;i<usedCards.size();i++)
	System.out.print(usedCards.get(i) + " ");
    System.out.println("");
}
        
/**
 * main method driver
 * @param args arguments for command line
 */
public static void main (String[] args){
    Scanner input = new Scanner(System.in);
    int no_players, round = 0, winnerIndex, winnerSum, gameWinnerIndex, gameWinnerSum;  // winner for finding winner in each round,
    char cont = 'N';																    //   gameWinner for finding winner in each game 
		
    /** 
     * Every Card object has a face, a suit, and a point attribute. Here, 'deck' is a list of Card objects. 52 cards to be exact.
     * The arrays faceList, pointList and suitList make it easier to assign each card their corresponding face, suit and point attribute 
     * for when we use a forloop later 
     */	
    String[] faceList = {"A", "2", "3", "4", "5","6", "7", "8", "9", "10", "J", "Q", "K"};
    int[] pointList = {1,2,3,4,5,6,7,8,9,0,0,0,0};
    String[] suitList = {"D", "C", "H", "S"};
		
    /**
     * the lists of used cards. List is used here since we wanna append every card we use up, and delete all later 
     */
    List<String> usedCardsD =  new ArrayList<String>();
    List<String> usedCardsC =  new ArrayList<String>();
    List<String> usedCardsH =  new ArrayList<String>();
    List<String> usedCardsS =  new ArrayList<String>();
    List<Card> deck = new ArrayList<Card>();
		
    /** START WHILE HERE */
    while ( (cont == 'N') || (cont == 'n') ){
			
	System.out.print("How many players? : ");
	no_players = input.nextInt();
		
	/** create how many Player objects we want and store into players array */
	Card_Player[] players = new Card_Player[no_players];
	for (int i=0;i<no_players;i++)
            players[i] = new Card_Player();
        
	for (int i=0;i<4;i++){ /** look back at the picture of cards in the assignment question. 4 rows, and 13 columns right? */
            for (int j=0;j<13;j++) /** each row different suit (variable i here), and in one raw all different faces and points (variable j) */
                deck.add(new Card(faceList[j], suitList[i], pointList[j])); /** add to the deck a new Card object every time */
	}
		
	Collections.shuffle(deck); /**shuffle dem cards */
		
        System.out.println("-----------------------------------------------------\n");
	System.out.print("Win count : ");
	for (int i=0;i<no_players;i++) 
            System.out.print("P" + (i+1) + "=" + players[i].getWinCount() + "       "); /** display win counts */

	System.out.println("");
		
        System.out.println("Available cards : ");
	for (int i=0;i<deck.size();i++)
            System.out.print(deck.get(i).getSuit() + deck.get(i).getFace() + " "); /** display the suits and faces of every card in the deck available */
        System.out.println("");
		
	System.out.println("Used cards : "); /**display the cards using the method we made at the top of the code */
	System.out.print("C: ");
	DisplayUsedCards(usedCardsC);
	System.out.print("D: ");
	DisplayUsedCards(usedCardsD);
	System.out.print("H: ");
	DisplayUsedCards(usedCardsH);
	System.out.print("S: ");
	DisplayUsedCards(usedCardsS);
		
	round++;
		
	while (deck.size() >= (3*no_players)) {
				
            System.out.println("");
            System.out.print("Press ENTER to deal cards : "); 
            input.nextLine();
            System.out.println("");
			
            System.out.println("Round " + round);
            System.out.println("----------------------------------------");
			 
            for (int i=0;i<3;i++){
                for (int j=0;j<no_players;j++){
                    /** for every jth player in the forloop, we assign 3 cards each from the last card of the deck, i.e deck.size()-1.
                     *  Each card is then deducted from the 'deck' list.
                     */
                    players[j].setCardFace(i, deck.get(deck.size()-1).getFace());
                    players[j].setCardSuit(i, deck.get(deck.size()-1).getSuit());
                    players[j].setCardPoint(i, deck.get(deck.size()-1).getPoint());
                    players[j].setSumCards(players[j].getSumCards() + players[j].getCardPoint(i)); /** basically saying each player's sumCards = sumCards + CardPoint. It does this 3 times */
				   
                    /** Adding the used cards correspondingly to their lists */
                    if (deck.get(deck.size()-1).getSuit() == "D")
			usedCardsD.add(deck.get(deck.size()-1).getFace());
                    else if (deck.get(deck.size()-1).getSuit() == "H")
			usedCardsH.add(deck.get(deck.size()-1).getFace());
                    else if (deck.get(deck.size()-1).getSuit() == "C")
                        usedCardsC.add(deck.get(deck.size()-1).getFace());
                    else if (deck.get(deck.size()-1).getSuit() == "S")
			usedCardsS.add(deck.get(deck.size()-1).getFace());
				   
                    /** last card from the deck is removed */
                    deck.remove(deck.size()-1);
                }
            }
			 
            /** Calculate who wins the round */
            winnerIndex = 0;
            winnerSum = players[0].getSumCards();
            for (int i=1;i<no_players;i++){
                if (players[i].getSumCards() > winnerSum ){
                    winnerSum = players[i].getSumCards();
                    winnerIndex = i;
		}
            }
            /** basically saying players[winnerIndex].setWinCount++ */
            players[winnerIndex].setWinCount(players[winnerIndex].getWinCount()+1);
			 
            for (int i =0;i<no_players;i++){
		if (i == winnerIndex)
                    players[winnerIndex].setAppendWinner("<-- Winner (First arrival priority)"); /** this means that just in case a tie happens eg */
		else										 /** between P1 and P2, P1 will win because 1 higher than 2. */
                    players[i].setAppendWinner(""); /** every Player object's AppendWinner attribute is set to null at first. */
            }						/** whoever wins the round, their appendWinner will be set to "Winner" */
			 
            for (int i=0;i<no_players;i++){
                System.out.print("Player " + (i+1) + " cards :  ");
                for (int j=0;j<3;j++)
                    System.out.print(players[i].getCardSuit(j) + players[i].getCardFace(j) + " ");
                System.out.println("\t| Sum = " + players[i].getSumCards() + "\t" + players[i].getAppendWinner());
                System.out.println(""); 
            }
            round++;
			
            System.out.println("Deck size is now : " + deck.size());
            System.out.print("Win count : ");
            for (int i=0;i<no_players;i++) 
		System.out.print("P" + (i+1) + "=" + players[i].getWinCount() + "       ");
            System.out.println("");
			
		
            System.out.print("Available cards : ");
            for (int i=0;i<deck.size();i++)
                System.out.print(deck.get(i).getSuit() + deck.get(i).getFace() + " ");
            System.out.println("");
			
            System.out.println("Used cards : ");
            System.out.print("C: ");
            DisplayUsedCards(usedCardsC);
            System.out.print("D: ");
            DisplayUsedCards(usedCardsD);
            System.out.print("H: ");
            DisplayUsedCards(usedCardsH);
            System.out.print("S: ");
            DisplayUsedCards(usedCardsS);
            System.out.println("");
				
            for (int i=0;i<no_players;i++)
		players[i].setSumCards(0); /** clear all players' sumCards back to 0 */
	}
		
	/** Calculate the GAME winner */
        gameWinnerIndex = 0;
	gameWinnerSum = players[0].getWinCount();
	for (int i=1;i<no_players;i++){
            if (players[i].getWinCount() > gameWinnerSum){
		gameWinnerSum = players[i].getWinCount();
		gameWinnerIndex = i;
            }
        }
		
	usedCardsD.clear(); /** clear all usedCards lists */
	usedCardsH.clear();
	usedCardsC.clear();
	usedCardsS.clear();
	deck.clear(); /** clear the deck */
		
	for (int i=0;i<no_players;i++){
            players[i].setWinCount(0);
            players[i].setSumCards(0); /** clear everything */
	}
	round =0;
		
		
	System.out.println("P" + (gameWinnerIndex+1) + " wins! Congrats!\n");
	System.out.print("Press Q to quit the game. Press N to start a new game : ");
	cont = input.next().charAt(0);
		
    }
		
 }
}
