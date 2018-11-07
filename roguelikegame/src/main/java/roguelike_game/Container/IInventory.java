package roguelike_game.Container;

import roguelike_game.Items.*;

public interface IInventory extends IContainer{

    void setMainWeapon(IWeapon weapon);

    void setMainArmor(IArmor armor);

    IWeapon getMainWeapon();

    IArmor getMainArmor();

    void addWeapon(IWeapon weapon);

    void addArmor(IArmor armor);

    void addMoney(IMoney money);

    boolean canLoseMoney(IMoney money);

    void loseMoney(IMoney money);

    boolean hasArmor();

    boolean hasWeapon();

    void add(IItem item);

}
