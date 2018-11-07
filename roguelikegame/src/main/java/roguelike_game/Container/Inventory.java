package roguelike_game.Container;

import roguelike_game.Items.*;

import java.util.LinkedList;
import java.util.List;

public class Inventory implements IInventory {
    private List<IWeapon> weapons = new LinkedList<IWeapon>();
    private List<IArmor> armors = new LinkedList<IArmor>();
    private IMoney money = new Money();
    private IWeapon mainWeapon;
    private IArmor mainArmor;

    public void addWeapon(IWeapon weapon) {
        if (weapons.size() == 0) {
            setMainWeapon(weapon);
        }
        weapons.add(weapon);
    }

    public void addArmor(IArmor armor) {
        if (armors.size() == 0) {
            setMainArmor(armor);
        }
        armors.add(armor);
    }

    public void addMoney(IMoney money) {
        this.money.add(money);
    }

    public boolean canLoseMoney(IMoney money) {
        return this.money.getCount() >= money.getCount();
    }

    public void loseMoney(IMoney money) {
        this.money.lose(money);
    }

    public void setMainWeapon(IWeapon weapon) {
        mainWeapon = weapon;
    }

    public void setMainArmor(IArmor armor) {
        mainArmor = armor;
    }

    public IWeapon getMainWeapon() {
        return mainWeapon;
    }

    public IArmor getMainArmor() {
        return mainArmor;
    }

    public boolean hasWeapon() {
        return (weapons.size() != 0);
    }

    public boolean hasArmor() {
        return (armors.size() > 0);
    }

    public void add(IItem item) {
        if (item instanceof IWeapon) {
            this.addWeapon((IWeapon) item);
        } else {
            if (item instanceof IArmor) {
                this.addArmor((IArmor) item);
            } else {
                if (item instanceof IMoney) {
                    this.addMoney((IMoney) item);
                }
            }
        }
    }
}
