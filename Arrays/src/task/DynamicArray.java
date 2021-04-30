package task;

/**
 * Динамический массив
 */
public class DynamicArray extends StaticArray implements Dynamic {

    private static final int DEFAULT_CAPACITY = 10;
    private static final float GROW_FACTOR = 1.5f;

    /**
     * текущая длина массива
     */
    private int size;

    public DynamicArray() {
        super(new int[DEFAULT_CAPACITY]);
        size = 0;
    }

    public DynamicArray(int[] array) {
        super(array);
        size = array.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int value) {
        // TODO: добавить элемент в конец массива
        int i = array.length;
        array[i]= value;
    }

    @Override
    public void add(int index, int value) {
        // TODO: добавить элемент в указанный индекс (остальные сдвинуть вправо)
        for (int i = index; i<array.length; i++ ){
            array[i+1]= array[i];
        }
        array[index]=value;
    }

    @Override
    public void addAll(Array array) {
        // TODO: конкатенация с переданным массивом
    }

    @Override
    public boolean remove(int value) {
        // TODO: удалить элемент из массива
        for (int i=0;i<array.length;i++){
            if (array[i]==value){
                array.remove[i];
                return i;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(int[] values) {
        // TODO: удалить все указанные элементы из массива
        for(int i=0; i<array.length; i++){
            array.remove[i];
            return true;
        }
        return false;
    }

    @Override
    public int removeOf(int index) {
        // удалить элемент по индексу
        array.remove[index];
        return 0;
    }
}
