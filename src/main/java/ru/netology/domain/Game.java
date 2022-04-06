package ru.netology.domain;

import ru.netology.data.Player;
import ru.netology.exceptions.NotRegisteredException;

import java.util.*;

public class Game {
    private Collection<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName1 + " не найден");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName2 + " не найден");
        }

        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1.getStrength() - player2.getStrength() > 0) {
            return 1;
        }
        if (player1.getStrength() - player2.getStrength() < 0) {
            return 2;
        }
        return 0;
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
}