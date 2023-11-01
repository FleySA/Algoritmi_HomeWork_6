import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyArrayList mal = new MyArrayList();

        for (int i = 0; i < 100; i++) {
            mal.append(new Random().nextInt(10));
        }

        System.out.println("Current size: " + mal.size());
        System.out.println("Element at index 5: " + mal.get(5));

        int elementToRemove = mal.get(10); // Удаляем элемент по индексу 10
        mal.remove(10);

        System.out.println("Current size after removal: " + mal.size());
        System.out.println(mal);
    }
}

class MyArrayList {
    private int[] storage;
    private int index;

    public MyArrayList() {
        this.storage = new int[2];
        this.index = 0;
    }

    public void append(int item) {
        if (this.storage.length == this.index) {
            int[] temp = new int[2 * this.storage.length];
            System.arraycopy(this.storage, 0, temp, 0, this.storage.length);
            this.storage = temp;
        }

        this.storage[this.index] = item;
        this.index += 1;
    }

    public int get(int index) {
        if (index < 0 || index >= this.index) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return this.storage[index];
    }

    public int size() {
        return this.index;
    }

    public void remove(int index) {
        if (index < 0 || index >= this.index) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        // Сдвигаем элементы влево, чтобы заменить удаляемый элемент
        for (int i = index; i < this.index - 1; i++) {
            this.storage[i] = this.storage[i + 1];
        }

        this.storage[this.index - 1] = 0; // Очищаем последний элемент
        this.index -= 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < this.index; i++) {
            sb.append(String.format("%d ", this.storage[i]));
        }
        sb.append(']');
        return sb.toString();
    }
}