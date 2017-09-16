
/**
 * Card_Player class for creating a player object. Attributes include
 * sumCards for summing 3 player-held cards, winCount for totaling how many wins per game,
 * appendWinner to determine wins a round or not, and an array of 3 Card objects cards
 * @author Nadhirah
 */
public class Card_Player {
    Card[] cards = new Card[3];
    private int sumCards;
    private int winCount;
    private String appendWinner;
	
    /**
     * Card_Player default constructor. No parameters
     */
    public Card_Player() {
        for (int i=0;i<3;i++)
            cards[i] = new Card("", "", 0);
	this.sumCards = 0;
	this.winCount = 0;
	this.appendWinner = "";
    }
    
    /**
     * get method for sumCards
     * @return sumCards the sum of the 3 cards held by player
     */
    public int getSumCards() { return sumCards; }
    /**
     * set method for sumCards
     * @param sum the sum of cards held by player
     */
    public void setSumCards(int sum) { this.sumCards = sum; }
	
    /**
     * get method for winCount
     * @return winCount the total number of wins per game
     */
    public int getWinCount() { return winCount; }
    
    /**
     * set method for winCount
     * @param winCount the total number of wins per game
     */
    public void setWinCount(int winCount) { this.winCount = winCount; }
	
    /**
     * get method for appendWinner
     * @return appendWinner either blank "" or "<-- Winner" is appended to player after every round
     */
    public String getAppendWinner() { return appendWinner; }
    
    /**
     * set method for appendWinner
     * @param app sets the appendWinner to app
     */
    public void setAppendWinner(String app) { this.appendWinner = app; }

    /**
     * get method for cardFace of a particular card defined by an index
     * @param index the index of the 3 cards held by player
     * @return cards[index].getFace() the face value of a particular card object
     */
    public String getCardFace(int index) { return cards[index].getFace(); }
    
    /**
     * get method for cardSuit of a particular card defined by an index
     * @param index the index of the 3 cards held by player
     * @return cards[index].getSuit() the suit value of a particular card object
     */
    public String getCardSuit(int index) { return cards[index].getSuit(); }
    
    /**
     * get method for cardPoint of a particular card defined by an index
     * @param index the index of the 3 cards held by player
     * @return cards[index].getPoint() the point value of a particular card object
     */
    public int getCardPoint(int index){ return cards[index].getPoint(); }
	
    /**
     * set method for card face of a particular card
     * @param index  the index of the 3 cards held by player
     * @param face the face value of the particular card
     */
    public void setCardFace(int index, String face) { cards[index].setFace(face); }
    
    /**
     * set method for card point of a particular card
     * @param index  the index of the 3 cards held by player
     * @param point the point value of the particular card
     */
    public void setCardPoint(int index, int point) { cards[index].setPoint(point); }
    
    /**
     * set method for card suit of a particular card
     * @param index  the index of the 3 cards held by player
     * @param suit the suit value of the particular card
     */
    public void setCardSuit(int index, String suit) { cards[index].setSuit(suit); }
}
