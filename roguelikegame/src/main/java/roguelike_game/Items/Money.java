package roguelike_game.Items;

public class Money implements IMoney {
    private int count = 0;

    public Money(int count) {
        this.count = count;
    }

    public Money() {
    }

    public int getCount() {
        return count;
    }

    public void add(IMoney money) {
        this.count += money.getCount();
    }

    public boolean canLose(IMoney money) {
        return (this.count >= money.getCount());
    }

    public void lose(IMoney money) {
        this.count -= money.getCount();
    }

    public boolean canLose(int count) {
        return (count > this.count);
    }
}
