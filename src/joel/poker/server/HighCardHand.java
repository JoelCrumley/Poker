package joel.poker.server;

import joel.poker.network.Card;

public class HighCardHand extends Hand {

    private Card.CardValue[] cards; // cards[0] > cards[1] > ... > cards[4]

    public HighCardHand(Card.CardValue card1, Card.CardValue card2, Card.CardValue card3, Card.CardValue card4, Card.CardValue card5) {
        super(HandType.HIGH_CARD);

        this.cards = new Card.CardValue[] { card1, card2, card3, card4, card5 };
    }

    public Card.CardValue[] getCards() {
        return cards;
    }

    public HandComparison compare(Hand h) { // compare THIS hand to testHand, return what testHand is relative to this
        int handTypeID = h.getType().getID(); // lower is better
        if (handTypeID < getType().getID()) return HandComparison.BETTER;
        if (handTypeID == getType().getID()) {
            HighCardHand testHand = (HighCardHand) h;
            Card.CardValue[] testCards = testHand.getCards();
            for (int i = 0; i < 5; i++) {
                if (testCards[i].getValue() > cards[i].getValue()) return HandComparison.BETTER;
                if (testCards[i].getValue() == cards[i].getValue()) {
                    if (i == 4) return HandComparison.EQUAL;
                    continue;
                }
                return HandComparison.WORSE;
            }
        }
        return HandComparison.WORSE;
    }

    public String toString() {
        return getType().toString() + " card1:" + cards[0].toString() + " card2:" + cards[1].toString() + " card3:" + cards[2].toString() +
                " card4:" + cards[3].toString() + " card5:" + cards[4].toString();
    }

}
