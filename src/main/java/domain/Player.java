package domain;

public class Player {
    private final PlayerName name;

    public Player(String name) {
        this.name = new PlayerName(name);
    }

    public String getName() {
        return name.getName();
    }
}