package Assignment_4;
import java.util.*;

class Card {
    private int suit; // 0-3 represents Hearts, Diamonds, Clubs, Spades
    private int rank; // 1-13 represents ranks from Ace to King

    public Card() {
        this.suit = 0;
        this.rank = 1;
    }

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public void printCard() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        System.out.println(ranks[rank - 1] + " of " + suits[suit]);
    }

    public void printDeck(Card[] deck) {
        for (Card card : deck) {
            card.printCard();
        }
    }

    public boolean sameCard(Card card) {
        return (this.suit == card.suit && this.rank == card.rank);
    }

    public int compareCard(Card card) {
        if (this.rank > card.rank) return 1;
        else if (this.rank < card.rank) return -1;
        else {
            if (this.suit > card.suit) return 1;
            else if (this.suit < card.suit) return -1;
            else return 0;
        }
    }

    public Card[] sortCard(Card[] deck) {
        Arrays.sort(deck, Comparator.comparing(Card::getSuit).thenComparing(Card::getRank));
        return deck;
    }

    public boolean findCard(Card[] deck, Card card) {
        for (Card c : deck) {
            if (c.sameCard(card)) {
                return true;
            }
        }
        return false;
    }

    public Card[] dealCards(Card[] deck, int numCards) {
        Random rand = new Random();
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            int index = rand.nextInt(deck.length);
            hand.add(deck[index]);
        }
        return hand.toArray(new Card[0]);
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
}
