package ru.netology.Tournament.repository;

import java.util.HashMap;

public class Game {

    HashMap<String, Integer> playerList = new HashMap<>();

    public void register(String name, Integer strength) {
        playerList.put(name, strength);
    }

    public int round(String playerName1, String playerName2) {
        int tmp1 = findByName(playerName1);
        int tmp2 = findByName(playerName2);
        if (tmp1 == 0 | tmp2 == 0) {
            throw new NotFoundException(
                    "Element with name: " + playerName1 + " or " + playerName2 + " not found."
            );
        }
        if (tmp1 < tmp2) {
            return 2;
        }
        if (tmp1 > tmp2) {
            return 1;
        }
        return 0;
    }

    public int findByName(String playerName) {
        for (String key : playerList.keySet()) {
            if (key.equals(playerName)) {
                int value = playerList.get(key);
                return value;
            }
        }
        return 0;
    }

}
