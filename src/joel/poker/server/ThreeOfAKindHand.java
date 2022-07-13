package joel.poker.server;

import joel.poker.network.Card;

public class ThreeOfAKindHand extends Hand {

    private Card.CardValue three, kicker1, kicker2;

    public ThreeOfAKindHand(Card.CardValue three, Card.CardValue kicker1, Card.CardValue kicker2) {
        super(HandType.THREE_OF_A_KIND);

        this.three = three;
        this.kicker1 = kicker1;
        this.kicker2 = kicker2;
    }

    public Card.CardValue getThree() {
        return three;
    }

    public Card.CardValue getKicker1() {
        return kicker1;
    }

    public Card.CardValue getKicker2() {
        return kicker2;
    }

    public HandComparison compare(Hand h) { // compare THIS hand to testHand, return what testHand is relative to this
        int handTypeID = h.getType().getID(); // lower is better
        if (handTypeID < getType().getID()) return HandComparison.BETTER;
        if (handTypeID == getType().getID()) {
            ThreeOfAKindHand testHand = (ThreeOfAKindHand) h;
            if (testHand.getThree().getValue() > getThree().getValue()) return HandComparison.BETTER;
            if (testHand.getThree().getValue() == getThree().getValue()) {
                if (testHand.getKicker1().getValue() > getKicker1().getValue()) return HandComparison.BETTER;
                if (testHand.getKicker1().getValue() == getKicker1().getValue()) {
                    if (testHand.getKicker2().getValue() > getKicker2().getValue()) return HandComparison.BETTER;
                    if (testHand.getKicker2().getValue() == getKicker2().getValue()) return HandComparison.EQUAL;
                }
            }
        }
        return HandComparison.WORSE;
    }

    public String toString() {
        return getType().toString() + " three:" + three.toString() + " kicker1:" + kicker1.toString() + " kicker2:" + kicker2.toString();
    }

}
