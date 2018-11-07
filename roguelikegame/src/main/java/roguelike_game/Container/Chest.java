package roguelike_game.Container;

import roguelike_game.Items.IArmor;
import roguelike_game.Items.IItem;
import roguelike_game.Items.IWeapon;

import java.util.LinkedList;
import java.util.List;

public class Chest implements IChest{
    List<IItem> content = new LinkedList<IItem>();

    public List<IItem> getAll(){
        List<IItem> treasure = new LinkedList<IItem>();
        for (int i = 0; i < content.size(); i++) {
            treasure.add(content.get(i));
        }
        content.clear();
        return treasure;
    }

    public void add(IItem item) {
        content.add(item);
    }
}
