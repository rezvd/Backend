package roguelike_game;

import roguelike_game.Container.Chest;
import roguelike_game.Container.IChest;
import roguelike_game.Items.*;
import roguelike_game.character.*;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        IMonster bigScaryMonster = new Monster();
        IWeapon powerfulWeapon = new Weapon(10);
        IWeapon weakWeapon = new Weapon(3);
        IArmor bigArmor = new Armor(7);
        IArmor smallArmor = new Armor(3);
        IChest chestForPlayer = new Chest();
        chestForPlayer.add(powerfulWeapon);
        chestForPlayer.add(smallArmor);
        chestForPlayer.add(new Money(20));
        IChest chestForMonster = new Chest();
        chestForMonster.add(weakWeapon);
        chestForMonster.add(bigArmor);
        chestForMonster.add(new Money(100));

        player.openChest(chestForPlayer);
        bigScaryMonster.openChest(chestForMonster);
        bigScaryMonster.stealMoney(player, new Money(15));
        bigScaryMonster.getHarm(player.hit());
    }
}
