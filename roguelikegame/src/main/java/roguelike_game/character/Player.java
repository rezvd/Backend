package roguelike_game.character;

import roguelike_game.Items.IMoney;

public class Player extends Character implements IPlayer {

    public void giveMoney(ICharacter character, IMoney money) {
        if (this.canLoseMoney(money)) {
            this.loseMoney(money);
            character.takeMoney(money);
        }
    }
}
