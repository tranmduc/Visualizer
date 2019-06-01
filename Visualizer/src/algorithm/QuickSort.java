package algorithm;

import Item.ItemArray;

public class QuickSort {
     public QuickSort() {
    }

    int partition(ItemArray arr, int low, int high) {
        int pivot = arr.getItemAt(high).getIndex();
        int i = (low - 1);
        for (int j = low; j < high; j++) {

            if (arr.compare(j,pivot) <= 0) {
                i++;

                arr.swap(i,j);
            }
        }

        arr.swap(i + 1, high);

        return i + 1;
    }


    public void sort(ItemArray arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
}
