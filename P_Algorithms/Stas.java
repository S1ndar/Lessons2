package P_Algorithms;

import java.util.EmptyStackException;


// Stack работает по принципу LIFO - Последним зашел, первым выйдет (как стопка бумаг)
// Никаких связей между элементами (в памяти только сам объект и i - его индекс) из-за этого скорость и меньше потребления памяти
// Как array, но проще
// В методе pop мы просто уменьшаем индекс элементов на 1, "удаляем" последний элемент и выводим его

public class Stas<T> {
    private T[] items;
    private int i;
    private static final int DEFAULT_CAP = 10; // Костыль

    @SuppressWarnings("unchecked") // Заглушка
    public Stas() {
        items = (T[]) new Object[DEFAULT_CAP];
        i = 0;
    }

    public void push(T item) {
        ensureCapacity();
        items[i] = item;
        i++;
    }

    public T pop() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        T topItem = items[i - 1];
        items[i - 1] = null;
        i--;
        return topItem;
    }

    public boolean isEmpty() {
        return i == 0;
    }

    @SuppressWarnings("unchecked") // Костыль, ну короче чтобы повышать предел количества элементов
    private void ensureCapacity() {
        if (i == items.length) {
            T[] newItems = (T[]) new Object[items.length * 2];
            System.arraycopy(items, 0, newItems, 0, i);
            items = newItems;
        }
    }

    public void print() {
        for (int j = 0; j < i; j++) {
            System.out.print(items[j] + "  ");
        }
        System.out.println("Размер: " + i);
    }
}
