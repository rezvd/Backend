package roguelike_game.Items;

import roguelike_game.character.IMonster;

public class Armor implements IArmor {
    private int protectionPoints = 0;
    private int health = 100;


    public Armor (int protectionPoints) {
        this.protectionPoints = protectionPoints;
    }
    
    public void getHarm() {
        health --;
    }

    public int getHealth() {
        return health;
    }

    public int getProtection() {
        getHarm();
        if (health == 0) {
            protectionPoints = 0;
        }
        return protectionPoints;
    }
}
