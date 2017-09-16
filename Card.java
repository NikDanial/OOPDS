
 /**
 * Card class for creating a card object. Attributes include
 * face for the face value of the card, suit for the suit value,
 * and point for the card point value. Methods include getters and setters
 * for face, suit and point
 * @author Nadhirah
 */
 
public class Card {
	private String face;
	private String suit;
	private int point;
	
	/**
         * Default Constructor for Card class
         */
	public Card() {
		this.face = "";
		this.suit = "";
		this.point = 0;
	}
	
	/**
         * Overloaded constructor for Card class with 3 arguments
         * @param face the face value of the card
         * @param suit the suit value of the card
         * @param point the point value of the card
         */
	public Card(String face, String suit, int point){
		this.face = face;
		this.suit = suit;
		this.point = point;
	}
        
	/**
         * get method for face. returns the value of face
         * @return face the face value of the card
         */
	public String getFace() { return face; }
        
        /**
         * set method for face
         * @param face the face value of the card to be updated
         */
	public void setFace(String face) { this.face = face; }
	
        /**
         * get method for suit
         * @return suit the suit value of the card
         */
	public String getSuit() { return suit; }
        
        /**
         * set method for suit
         * @param suit the suit value of the card to be updated
         */
	public void setSuit(String suit) { this.suit = suit; }
	
        /**
         * get method for point
         * @return point the point value of the card
         */
	public int getPoint() { return point; }
        
        /**
         * set method for point
         * @param point the point value of the card to be updated
         */
	public void setPoint(int point) { this.point = point; }
	
}
