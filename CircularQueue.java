public class CircularQueue<T> {
    private int top = -1;
    private int base = 0;
    private T[] data;

    @SuppressWarnings("unchecked")
    public CircularQueue(int size) {
        data = (T[]) new Object[size];
    }

    public void add(T value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        top = move(top);
        data[top] = value;
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T value = data[base];
        data[base] = null;

        if (base == top) {
            base = 0;
            top = -1;
        } else {
            base = move(base);
        }
        return value;
    }

    public boolean isFull() {
        return move(top) == base && data[move(top)] != null;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private int move(int position) {
        return (position + 1) % data.length;
    }

    public void clear() {
        top = -1;
        base = 0;
        data = (T[]) new Object[data.length];
    }
}