package joel.poker.server;

import joel.poker.network.Card;

public class FlushHand extends Hand {

    private Card.CardValue high;
    private Card.CardSuit suit;

    public FlushHand(Card.CardSuit suit, Card.CardValue high) {
        super(HandType.FLUSH);

        this.suit = suit;
        this.high = high;
    }

    public Card.CardValue getHigh() {
        return high;
    }

    public Card.CardSuit getSuit() {
        return suit;
    }

    public HandComparison compare(Hand h) { // compare THIS hand to testHand, return what testHand is relative to this
        int handTypeID = h.getType().getID(); // lower is better
        if (handTypeID < getType().getID()) return HandComparison.BETTER;
        if (handTypeID == getType().getID()) {
            FlushHand testHand = (FlushHand) h;
            if (testHand.getHigh().getValue() > high.getValue()) return HandComparison.BETTER;
            if (testHand.getHigh().getValue() == high.getValue()) return HandComparison.EQUAL;
        }
        return HandComparison.WORSE;
    }

    public String toString() {
        return getType().toString() + " suit:" + suit.toString() + " high:" + high.toString();
    }

}
