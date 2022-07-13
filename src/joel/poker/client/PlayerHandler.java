package joel.poker.client;

import joel.poker.network.PlayerData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerHandler {

    public volatile List<PlayerData> players;

    public PlayerHandler() {
        players = new ArrayList<PlayerData>();
    }

    public PlayerData getPlayer(int id) {
        for (PlayerData player : players) if (player.id == id) return player;
        return null;
    }

    public void removePlayer(int id) {
        Iterator<PlayerData> it = players.iterator();
        while (it.hasNext()) {
            PlayerData player = it.next();
            if (player.id == id) it.remove();
        }
    }

}