package algorithm;

import Item.ItemArray;

public class BubbleSort {
    public BubbleSort() {
    }

    public void sort(ItemArray array) {
        for (int i = array.length(); i >= 1; i--) {
            for (int j = 0; j < i - 1; j++)
                array.compareAndSwap(j, j + 1);
        }
    }
}
