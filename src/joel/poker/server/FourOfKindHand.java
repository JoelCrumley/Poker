package joel.poker.server;

import joel.poker.network.Card;

public class FourOfKindHand extends Hand {

    private Card.CardValue cardType;
    private Card.CardValue kicker;

    public FourOfKindHand(Card.CardValue cardType, Card.CardValue kicker) {
        super(HandType.FOUR_OF_A_KIND);

        this.cardType = cardType;
        this.kicker = kicker;
    }

    public Card.CardValue getCardType() {
        return cardType;
    }

    public Card.CardValue getKicker() {
        return kicker;
    }

    public HandComparison compare(Hand h) { // compare THIS hand to testHand, return what testHand is relative to this
        int handTypeID = h.getType().getID(); // lower is better
        if (handTypeID < getType().getID()) return HandComparison.BETTER;
        if (handTypeID == getType().getID()) {
            FourOfKindHand testHand = (FourOfKindHand) h;
            int testValue = testHand.getCardType().getValue();
            if (testValue > cardType.getValue()) return HandComparison.BETTER;
            if (testValue == cardType.getValue()) {
                if (testHand.getKicker().getValue() > kicker.getValue()) {
                    return HandComparison.BETTER;
                } else {
                    return HandComparison.WORSE;
                }
            }
            return HandComparison.WORSE;
        }
        return HandComparison.WORSE;
    }

    public String toString() {
        return getType().toString() + " value:" + cardType.toString() + " kicker:" + kicker.toString();
    }

//    public Card[] getCards() {
//        Card[] cards = new Card[5];
//        for (int i = 0; i < 4; i++) {
//            cards[i] = Card.get(cardType, CardSuit.fromID(i));
//        }
//        cards[4] = kicker;
//        return cards;
//    }

}
