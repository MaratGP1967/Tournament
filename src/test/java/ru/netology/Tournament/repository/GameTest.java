package ru.netology.Tournament.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Tournament.domain.Player;

public class GameTest {

    Player player1 = new Player(1, "Gamer1", 120);
    Player player2 = new Player(2, "Gamer2", 140);
    Player player3 = new Player(3, "Gamer3", 110);
    Player player4 = new Player(4, "Gamer4", 120);
    Player player5 = new Player(5, "Gamer5", 100);

    Game players = new Game();

    @Test
    public void roundWonFirstTest() {
        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);

        int expected = 1;
        int actual = players.round("Gamer2", "Gamer3");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundWonSecondTest() {
        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);

        int expected = 2;
        int actual = players.round("Gamer1", "Gamer2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundDrawTest() {
        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);

        int expected = 0;
        int actual = players.round("Gamer1", "Gamer4");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundNoWinnerTest() {
        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            players.round("Gamer7", "Gamer6");
        });
    }

}
