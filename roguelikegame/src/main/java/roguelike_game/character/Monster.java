package roguelike_game.character;

import roguelike_game.Items.IMoney;

public class Monster extends Character implements IMonster {

    public void stealMoney(ICharacter character, IMoney money) {
        if (character.canLoseMoney(money)) {
            character.loseMoney(money);
            this.takeMoney(money);
        }
    }
}
