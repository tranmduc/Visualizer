package Item;

import javafx.scene.shape.Rectangle;

public class Item extends Rectangle implements Comparable {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 3;

    private int value;
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValue() {
        return value;
    }


    public Item(int  value) {
        super(WIDTH, value * HEIGHT);

        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        return - value + ((Item)o).value;
    }
}