import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {
	
	static ArrayList<Card> cards;
	static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		int diffCard = initializeCards();		
		play(diffCard);
			
	}
	
	static int initializeCards() {
		cards = new ArrayList<Card>();
		int rand1 = (int)(Math.random()*10);
		int rand2 = (int)(Math.random()*10);
		int randomCard = (int)(Math.random()*5+1);		
		
		for(int i=0; i<randomCard; i++)
			cards.add(new Card(0, rand1));
		
		cards.add(new Card(0, rand2));
		
		for(int i=randomCard+1; i<6; i++) {
			cards.add(new Card(0, rand1));
		}
		
		return rand2;
	}
	
	static void play(int diffCard) {
		int chosenCard;
		
		for(int i=0; i<6; i++)
			System.out.print("* ");
		
		do{
			System.out.println("\nChoose a card between 1-6");
			chosenCard = scan.nextInt()-1;
			cards.get(chosenCard).setStatus(1);
			
			for(int i=0; i<6; i++) {
				if(cards.get(i).getStatus() == 0)
					System.out.print("* ");			
				else
					System.out.print(cards.get(i).getValue() + " ");
			}		
		}while(cards.get(chosenCard).getValue() != diffCard);
		
		System.out.println("\n");
		for(int i=0; i<6; i++) {		
			System.out.print(cards.get(i).getValue() + " ");
		}
		
		System.out.println("\nYou have found the different Card!");
		System.out.println("1 - Play Again");
		System.out.println("2 - Quit");
		
		int playAgain = scan.nextInt();
		
		switch(playAgain) {
			case 1:
				diffCard = initializeCards();
				play(diffCard);
				break;
			case 2:
				break;
			default:
				System.out.println("Unvalid number");
		}
	}
}

class Card {	
	int status;
	int value;
	
	Card(int status, int value) {
		this.status = status;
		this.value = value;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getValue() {
		return value;
	}
}