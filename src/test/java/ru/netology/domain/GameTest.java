package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.data.Player;
import ru.netology.exceptions.NotRegisteredException;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();

    private Player player1 = new Player(1, "Денис", 1000);
    private Player player2 = new Player(2, "Дмитрий", 2000);
    private Player player3 = new Player(3, "Сергей", 2000);
    private Player player4 = new Player(4, "Александр", 4000);
    private Player player5 = new Player(5, "Анатолий", 3000);

    @Test
    public void shouldShowWhereNoPlayers() {
        String playerName1 = "Денис";
        String playerName2 = "Дмитрий";

        assertThrows(NotRegisteredException.class, () -> game.round(playerName1, playerName2));
    }

    @Test
    public void shouldShowWhereOnePlayer() {
        game.register(player1);

        String playerName1 = "Денис";
        String playerName2 = "Дмитрий";

        assertThrows(NotRegisteredException.class, () -> game.round(playerName1, playerName2));
    }

    @Test
    public void shouldFindWhereTwoPlayers() {
        game.register(player1);
        game.register(player2);

        String playerName1 = "Денис";
        String playerName2 = "Дмитрий";

        assertEquals(2, game.round(playerName1, playerName2));
    }

    @Test
    public void shouldFindWhereWinFirstPlayer() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        String playerName1 = "Дмитрий";
        String playerName2 = "Денис";

        assertEquals(1, game.round(playerName1, playerName2));
    }

    @Test
    public void shouldFindWhereWinSecondPlayer() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        String playerName1 = "Денис";
        String playerName2 = "Дмитрий";

        assertEquals(2, game.round(playerName1, playerName2));
    }

    @Test
    public void shouldFindWhereDraw() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        String playerName1 = "Дмитрий";
        String playerName2 = "Сергей";

        assertEquals(0, game.round(playerName1, playerName2));
    }

    @Test
    public void shouldFindWhereNoMatch() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        String playerName1 = "Виталий";
        String playerName2 = "Петр";

        assertThrows(NotRegisteredException.class, () -> game.round(playerName1, playerName2));
    }

    @Test
    public void shouldFindWhereOneMatch() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        String playerName1 = "Дмитрий";
        String playerName2 = "Владимир";

        assertThrows(NotRegisteredException.class, () -> game.round(playerName1, playerName2));
    }
}