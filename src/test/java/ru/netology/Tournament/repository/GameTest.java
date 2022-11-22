package ru.netology.Tournament.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game players = new Game();

    @Test
    public void roundWonFirstTest() {
        players.register("Gamer1", 120);
        players.register("Gamer2", 140);
        players.register("Gamer3", 110);
        players.register("Gamer4", 120);
        players.register("Gamer5", 100);

        int expected = 1;
        int actual = players.round("Gamer2", "Gamer3");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundWonSecondTest() {
        players.register("Gamer1", 120);
        players.register("Gamer2", 140);
        players.register("Gamer3", 110);
        players.register("Gamer4", 120);
        players.register("Gamer5", 100);

        int expected = 2;
        int actual = players.round("Gamer1", "Gamer2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundDrawTest() {
        players.register("Gamer1", 120);
        players.register("Gamer2", 140);
        players.register("Gamer3", 110);
        players.register("Gamer4", 120);
        players.register("Gamer5", 100);

        int expected = 0;
        int actual = players.round("Gamer1", "Gamer4");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundNoWinnerTest() {
        players.register("Gamer1", 120);
        players.register("Gamer2", 140);
        players.register("Gamer3", 110);
        players.register("Gamer4", 120);
        players.register("Gamer5", 100);

        Assertions.assertThrows(NotFoundException.class, () -> {
            players.round("Gamer7", "Gamer6");
        });
    }

}
