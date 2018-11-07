package roguelike_game.Items;

public interface IMoney extends IItem {

    int getCount();

    void add(IMoney money);

    boolean canLose(IMoney money);

    void lose(IMoney money);

}
