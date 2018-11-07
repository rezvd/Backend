package roguelike_game.character;

import roguelike_game.Container.IChest;
import roguelike_game.Container.Inventory;
import roguelike_game.Items.*;

import java.util.List;

public class Character implements ICharacter {
    private Inventory inventory = new Inventory();
    private int health = 100;
    private final int BASE_HARM_POINTS = 2;
    private boolean isAlive = true;

    public int hit() {
        return BASE_HARM_POINTS + getMainWeaponHarm();
    }

    public void getHarm(int harm) {
        int harmPoints = harm - getMainArmorProtection(harm);
        if (harmPoints < 0) harmPoints = 0;
        health -= harmPoints;
        if (health <= 0) {
            isAlive = false;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void getWeapon(IWeapon weapon) {
        inventory.addWeapon(weapon);
    }

    public void getArmor(IArmor armor) {
        inventory.addArmor(armor);
    }

    public void setMainWeapon(IWeapon weapon) {
        inventory.setMainWeapon(weapon);
    }

    public void setMainArmor(IArmor armor) {
        inventory.setMainArmor(armor);
    }

    public int getMainWeaponHarm() {
        if (inventory.hasWeapon()) {
            return inventory.getMainWeapon().getHarmPoints();
        } else {
            return 0;
        }
    }

    public int getMainArmorProtection(int harm) {
        if (inventory.hasArmor()) {
            return inventory.getMainArmor().getProtection();
        } else {
            return 0;
        }
    }

    public void takeMoney(IMoney money) {
        this.inventory.addMoney(money);
    }

    public boolean canLoseMoney(IMoney money) {
        return (this.inventory.canLoseMoney(money));
    }

    public void loseMoney(IMoney money) {
        if (this.inventory.canLoseMoney(money)) {
            this.inventory.loseMoney(money);
        }
    }

    public void openChest(IChest chest) {
        List<IItem> treasure = chest.getAll();
        for (Object current : treasure) {
            inventory.add((IItem) current);
        }
    }
}
