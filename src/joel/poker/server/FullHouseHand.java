package joel.poker.server;

import joel.poker.network.Card;

public class FullHouseHand extends Hand {

    private Card.CardValue three, pair;

    public FullHouseHand(Card.CardValue three, Card.CardValue pair) {
        super(HandType.FULL_HOUSE);

        this.three = three;
        this.pair = pair;

    }

    public Card.CardValue getThree() {
        return three;
    }

    public Card.CardValue getPair() {
        return pair;
    }

    public HandComparison compare(Hand h) { // compare THIS hand to testHand, return what testHand is relative to this
        int handTypeID = h.getType().getID(); // lower is better
        if (handTypeID < getType().getID()) return HandComparison.BETTER;
        if (handTypeID == getType().getID()) {
            FullHouseHand testHand = (FullHouseHand) h;
            if (testHand.getThree().getValue() > getThree().getValue()) return HandComparison.BETTER;
            if (testHand.getThree().getValue() == getThree().getValue()) {
                if (testHand.getPair().getValue() > getPair().getValue()) return HandComparison.BETTER;
                if (testHand.getPair().getValue() == getPair().getValue()) return HandComparison.EQUAL;
            }
        }
        return HandComparison.WORSE;
    }

    public String toString() {
        return getType().toString() + " three:" + three.toString() + " pair:" + pair.toString();
    }

}
