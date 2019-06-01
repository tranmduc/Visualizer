package Item;

import javafx.animation.*;
import javafx.util.Duration;

public class ItemArray {
    public static final int HEIGHT = 3;
    public static final int DISTANCE = 25;
    public static final int RANDOM = 50;
    public static final int SCENE_WIDTH = 600;
    public static final int SCENE_HEIGHT = 300;
    public static final double DURATION = 0.2;

    private Item [] items;

    private SequentialTransition animation;

    public ItemArray(int length) {
        items = new Item[length];
        animation = new SequentialTransition();

        for (int i = 0; i<length; i++) {
            int value = (int) ( Math.random() * RANDOM ) + 1;
            items[i] = new Item(value);
            items[i].setIndex(i);

            items[i].setX(SCENE_WIDTH/2 - DISTANCE * length/2 + i * DISTANCE);
            items[i].setY(SCENE_HEIGHT*0.7 - value * HEIGHT);

            System.out.print(value + " ");
        }
    }

    public Item [] getAll () {
        return items;
    }

    public Item getItemAt(int i) {
        return items[i];
    }

    public int length() {
        return items.length;
    }


    public void swap(int i, int j) {
        Item tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;

        items[i].setIndex(i);
        items[j].setIndex(j);

        TranslateTransition tt1 = new TranslateTransition();
        tt1.setDuration(Duration.seconds(DURATION));
        tt1.setByX(DISTANCE * (i-j));
        tt1.setNode(items[i]);

        TranslateTransition tt2 = new TranslateTransition();
        tt2.setDuration(Duration.seconds(DURATION));
        tt2.setByX(DISTANCE * (j-i));
        tt2.setNode(items[j]);

        ParallelTransition pt = new ParallelTransition();
        pt.getChildren().addAll(tt1, tt2);

        animation.getChildren().add(pt);
    }

    public boolean compareAndSwap(int i, int j) {
        if (items[i].compareTo(items[j]) < 0) {
            swap(i, j);
            return true;
        }
        return false;
    }

    public SequentialTransition getAnimation() {
        return animation;
    }

    public int compare(int i, int j) {
        return items[i].compareTo(items[j]);
    }
}
