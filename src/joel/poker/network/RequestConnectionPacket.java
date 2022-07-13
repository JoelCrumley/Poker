package joel.poker.network;

public class RequestConnectionPacket extends Packet {

    private RequestConnectionPacket(){}

    public String name;

    public RequestConnectionPacket(String name) {
        this.name = name;
    }

}
