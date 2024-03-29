package joel.poker.network;

public class PlayerBetPacket extends Packet {

    public int id, newBetAmount, newBalance, nextTurn, currentBet, toStay, minimumRaise, maximumBet, potAmount, currentChips;

    public PlayerBetPacket(int id, int newBetAmount, int newBalance, int nextTurn, int currentBet, int toStay, int minimumRaise, int maximumBet,
                           int potAmount, int currentChips) {
        this.id = id;
        this.newBetAmount = newBetAmount;
        this.newBalance = newBalance;
        this.nextTurn = nextTurn;
        this.currentBet = currentBet;
        this.toStay = toStay;
        this.minimumRaise = minimumRaise;
        this.maximumBet = maximumBet;
        this.potAmount = potAmount;
        this.currentChips = currentChips;
    }

}
