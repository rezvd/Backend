package roguelike_game.Items;

public class Weapon implements IWeapon{
    private int harmPoints;

    public Weapon(int harmPoints) {
        this.harmPoints = harmPoints;
    }

    public int getHarmPoints() {
        return harmPoints;
    }
}
