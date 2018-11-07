package roguelike_game.character;

import roguelike_game.Container.IChest;
import roguelike_game.Items.IArmor;
import roguelike_game.Items.IMoney;
import roguelike_game.Items.IWeapon;

public interface ICharacter {

    int hit ();

    void getHarm(int harm);

    void getWeapon(IWeapon weapon);

    void getArmor(IArmor armor);

    void setMainWeapon(IWeapon weapon);

    void setMainArmor(IArmor armor);

    int getMainWeaponHarm();

    int getMainArmorProtection(int harm);

    boolean canLoseMoney(IMoney money);

    void takeMoney(IMoney money);

    void loseMoney(IMoney money);

    void openChest(IChest chest);

}
