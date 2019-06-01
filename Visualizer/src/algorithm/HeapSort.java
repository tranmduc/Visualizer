package algorithm;

import Item.ItemArray;

public class HeapSort
{

    public HeapSort() {
    }

    public void sort(ItemArray array)
    {
        for (int i = (array.length() - 2) / 2; i >= 0; i--)
            heapify( array , i , array.length() - 1 );

        for (int i = array.length() - 1; i > 0; i--) {
            array.swap(0, i);
            heapify(array , 0 , i - 1 );
        }
    }

    private void heapify(ItemArray array, int i, int m) {
        int j;
        while ( 2 * i + 1 <= m ) {
            j = 2 * i + 1;
            if ( j < m ) {
                if ( array.getItemAt(j).compareTo(array.getItemAt(j + 1)) < 0   )
                    j++;
            }
            if (array.getItemAt(i).compareTo(array.getItemAt(j)) < 0 )  {
                array.swap(i, j);
                i = j;
            } else
                i = m;
        }
    }
}
