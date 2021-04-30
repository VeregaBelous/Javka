package course.task;

/**
 * Сортированный статический массив (по возрастанию).
 *
 * Любая операция должна гарантировать, что массив, по ее окончании, отстортирован
 */
public class SortedArray extends StaticArray {

    public SortedArray(int[] array) {
        super(array);
        if (!isAscSorted()) {
            sort();
        }
    }

    @Override
    public boolean contains(int value) {
        return binarySearch(value, 0, array.length) != -1;
    }

    @Override
    public int set(int index, int value) {
        // TODO: присовить значение по индексу
        return 0;
    }

    @Override
    public int indexOf(int value) {
        return binarySearch(value, 0, array.length - 1);
    }

    @Override
    public int lastIndexOf(int value) {
        // TODO: получить индекс последнего подходящего элемента
        return -1;
    }

    @Override
    public void sort() {}

    @Override
    public void sort(ArraySort sort) {}

    private int binarySearch(int value, int left, int right) {
        // TODO: реализовать бинарный поиск
        return -1;
    }

    public SortedArray merge(SortedArray other) {
        // TODO: произвести слиянеие двух сортированных массивов
        return this;
    }

    public SortedArray mergeAll(SortedArray... others) {
        // TODO: произвести слиянеие N + 1 сортированных массивов
        return this;
    }
}
