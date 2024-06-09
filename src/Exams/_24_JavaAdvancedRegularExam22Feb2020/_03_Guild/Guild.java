package Exams._24_JavaAdvancedRegularExam22Feb2020._03_Guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {

    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }
    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }
    public boolean removePlayer(String name) {
        return roster.removeIf(player -> player.getName().equals(name));
    }

    public void promotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
                break;
            }
        }
    }
    public void demotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
                break;
            }
        }
    }
    public Player[] kickPlayersByClass(String clazz) {
        Player[] players = this.roster.stream().filter(player -> player.getClazz().equals(clazz)).toArray(Player[]::new);

        for (Player player : players) {
            this.roster.removeIf(p->p.getClazz().equals(clazz));
        }
        return players;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder text = new StringBuilder();
        text.append("Players in the guild: ").append(this.getName()).append(":").append(System.lineSeparator());

        for (Player player : roster) {
            text.append(player.toString()).append(System.lineSeparator());
        }

        return text.toString().trim();
    }
}
