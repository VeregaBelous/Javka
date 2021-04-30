package task;

import java.util.Arrays;

/**
 * Обертка над статическим массивом
 */
public class StaticArray implements Array {

    protected int[] array;

    public StaticArray(int[] a) {
        this.array = new int[a.length];
        System.arraycopy(a, 0, this.array, 0, a.length);
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean contains(int value) {
        // TODO: проверить, что элемент есть в массиве
        for (int i=0; i < array.size; i++)
        {
            if (array[i] == value)
            {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public int get(int index) {
        int res = array[index];
        return res;
    }

    @Override
    public int set(int index, int value) {
        // TODO: присвоить значение по индексу. Вернуть значение элемента, которое заменили
        int k = array[index];
        array [index] = value;
        return k;
    }

    @Override
    public int indexOf(int value) {
        // TODO: получить индекс первого подходящего элемента
        for (int i =0; i<array.length; i++){
            if (array[i]==value){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        // TODO: получить индекс последнего подходящего элемента
        for ( int i = 0; i < array.length; i++) {
            if (array[i]==value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void reverse() {
        // TODO: перевернуть массив
        int buf = 0;
        int i = 0;
        int j = array.length;
        while (i <= j){
            array[j] = buf;
            array[i] = array[j];
            array[i] = buf;
            i++;
            j--;
        }
    }

    @Override
    public Array subArray(int fromIndex, int toIndex) {
        // TODO: вернуть подмассив, начиная с индекса fromIndex
        //  включительно и заканчивая индексом toIndex невкоючительно
        int[] Duck = new int[array.length - 1];
        int j = 0;
        for (int i = fromIndex; i <array.length; i++){
            if (i < toIndex){
                Duck[j] = array[i];
                j++;
            }
        }
        int length = j;
        int i = 0;
        for (j = 0; j < length; j++ ){
            ????[i] = Duck[j];
            i++;
        }
        return this;
    }

    @Override
    public void sort() {
        bubbleSort();
    }

    @Override
    public void sort(ArraySort sort) {
        switch (sort) {
            case BUBBLE:
                bubbleSort();
                break;
            case INSERTION:
            case SELECTION:
            case MERGE:
            case QUICK:
            default:
                sort();
        }
    }

    @Override
    public String toString() {
        // TODO: вернуть массив в виде строки. Например, [3, 4, 6, -2]
        return Arrays.toString(array);
    }

    private void bubbleSort() {
        // TODO: сортировка пузырьком (по возрастанию)
        int n = array.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
    }

    private void insertionSort() {
        //TODO*: сортировка вставками (по возрастанию)
        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            array[i + 1] = value;
        }
    }

    private void selectionSort() {
        //TODO*: сортировка выбором (по возрастанию)
        for (int left = 0; left < array.length; left++) {
            int minIndex = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            swap(array, left, minInd);
        }
    }

    private void mergeSort() {
        //TODO**: сортировка слиянием (по возрастанию)

    }

    private void quickSort() {
        //TODO**: быстрая сортировка (по возрастанию)
    }

    public boolean isAscSorted() {
        // TODO: проверить, что массив отсортирован по возрастанию
        for (int i=0 ; i<array.length; i++){
            if (array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }
}
