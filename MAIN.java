package Assignment_4;

import java.util.Scanner;
public class MAIN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Card[] deck = new Card[52];
        for (int i = 0; i < 52; i++) {
            deck[i] = new Card(i % 4, (i % 13) + 1);
        }

        int choice;
        do {
            System.out.println("\n----- Menu -----");
            System.out.println("1. Create Deck");
            System.out.println("2. Print Deck");
            System.out.println("3. Check if two cards are the same");
            System.out.println("4. Compare two cards");
            System.out.println("5. Sort Deck");
            System.out.println("6. Find a Card in Deck");
            System.out.println("7. Deal Cards");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Deck created.");
                    break;
                case 2:
                    System.out.println("Printing Deck:");
                    new Card().printDeck(deck);
                    break;
                case 3:
                    System.out.println("Enter Card 1:");
                    Card card1 = readCard(scanner);
                    System.out.println("Enter Card 2:");
                    Card card2 = readCard(scanner);
                    System.out.println("Are the cards the same? " + card1.sameCard(card2));
                    break;
                case 4:
                    System.out.println("Enter Card 1:");
                    Card c1 = readCard(scanner);
                    System.out.println("Enter Card 2:");
                    Card c2 = readCard(scanner);
                    int result = c1.compareCard(c2);
                    if (result > 0) System.out.println("Card 1 is greater.");
                    else if (result < 0) System.out.println("Card 2 is greater.");
                    else System.out.println("Both cards are equal.");
                    break;
                case 5:
                    System.out.println("Sorting Deck:");
                    deck = new Card().sortCard(deck);
                    new Card().printDeck(deck);
                    break;
                case 6:
                    System.out.println("Enter Card to find:");
                    Card toFind = readCard(scanner);
                    boolean found = new Card().findCard(deck, toFind);
                    if (found) System.out.println("Card found in deck.");
                    else System.out.println("Card not found in deck.");
                    break;
                case 7:
                    System.out.print("Enter number of cards to deal: ");
                    int numCards = scanner.nextInt();
                    Card[] hand = new Card().dealCards(deck, numCards);
                    System.out.println("Dealt cards:");
                    new Card().printDeck(hand);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 8);

        scanner.close();
    }

    private static Card readCard(Scanner scanner) {
        System.out.print("Enter suit (0-3): ");
        int suit = scanner.nextInt();
        System.out.print("Enter rank (1-13): ");
        int rank = scanner.nextInt();
        return new Card(suit, rank);
    }
}