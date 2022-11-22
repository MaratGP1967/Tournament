package ru.netology.Tournament.repository;

import ru.netology.Tournament.domain.Player;

import java.util.ArrayList;

public class Game {

    ArrayList<Player> playerList = new ArrayList<>();

    public void register(Player player) {
        playerList.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player tmp1 = findByName(playerName1);
        Player tmp2 = findByName(playerName2);
        if (tmp1 == null | tmp2 == null) {
            throw new NotFoundException(
                    "Element with name: " + playerName1 + " or " + playerName2 + " not found."
            );
        }
        if (tmp1.getStrength() < tmp2.getStrength()) {
            return 2;
        }
        if (tmp1.getStrength() > tmp2.getStrength()) {
            return 1;
        }
        return 0;
    }

    public Player findByName(String playerName) {
        for (Player player : playerList) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

}
