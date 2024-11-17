package ru.spbstu.telematics.java;
import java.util.*;

class MyArrayDeque<T> implements Deque<T>
{
    private Object[] array;
    private int size;

    public MyArrayDeque()
    {
        this.array = new Object[0];
        this.size = 0;
    }

    public MyArrayDeque(int numElements)
    {
        if (numElements < 1)
        {
            this.array = new Object[1];
            this.size = 1;
            return;
        }
        if (numElements == Integer.MAX_VALUE)
        {
            this.array = new Object[Integer.MAX_VALUE];
            this.size = Integer.MAX_VALUE;
        }
        this.array = new Object[numElements];
        this.size = numElements;
    }

    public MyArrayDeque(Collection<? extends T> c)
    {
        this.array = new Object[c.size()];
        this.size = 0;
        for (Iterator<? extends T> iter = c.iterator(); iter.hasNext(); )
        {
            T element = iter.next();
            this.array[this.size++] = element;
        }
    }

    @Override
    public void addFirst(T t) {
        if (t == null)
            throw new NullPointerException();
        Object[] ex = new Object[this.size];
        System.arraycopy(this.array, 0, ex, 0, this.size);
        this.array = new Object[this.size + 1];
        this.array[0] = t;
        System.arraycopy(ex, 0, this.array, 1, ex.length);
        this.size++;
    }

    @Override
    public void addLast(T t) {
        if (t == null)
            throw new NullPointerException();
        Object[] ex = new Object[this.size];
        System.arraycopy(this.array, 0, ex, 0, this.size);
        this.array = new Object[this.size + 1];
        System.arraycopy(ex, 0, this.array, 0, ex.length);
        this.array[this.size] = t;
        this.size++;
    }

    @Override
    public boolean offerFirst(T t) {
        this.addFirst(t);
        return true;
    }

    @Override
    public boolean offerLast(T t) {
        this.addLast(t);
        return true;
    }

    @Override
    public T removeFirst() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        return this.pollFirst();
    }

    @Override
    public T removeLast() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        return this.pollLast();
    }

    @Override
    public T pollFirst() {
        if (this.isEmpty())
            return null;
        T firstElement = this.getFirst();
        this.del(0);
        this.size--;
        return firstElement;
    }

    @Override
    public T pollLast() {
        if (this.isEmpty())
            return null;
        T lastElement = this.getLast();
        this.del(this.size - 1);
        this.size--;
        return lastElement;
    }

    @Override
    public T getFirst() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        return this.peekFirst();
    }

    @Override
    public T getLast() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        return this.peekLast();
    }

    @Override
    public T peekFirst() {
        if (this.isEmpty())
            return null;
        return (T) this.array[0];
    }

    @Override
    public T peekLast() {
        if (this.isEmpty())
            return null;
        return (T) this.array[this.size - 1];
    }

    private void del(int index) {
        if (index < 0 || index >= this.array.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + array.length);
        }
        Object[] newArray = new Object[this.array.length - 1];
        for (int i = 0, j = 0; i < this.array.length; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }
        this.array = newArray;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        if (o == null)
            return false;
        for (int i = 0; i < this.size; i++) {
            if (o.equals(this.array[i])) {
                this.del(i);
                this.size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        if (o == null)
            return false;
        for (int i = this.size - 1; i >= 0; i--) {
            if (o.equals(this.array[i])) {
                this.del(i);
                this.size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(T t) {
        this.addLast(t);
        return true;
    }

    @Override
    public boolean offer(T t) {
        return this.offerLast(t);
    }

    @Override
    public T remove() {
        return this.removeFirst();
    }

    @Override
    public T poll() {
        return this.pollFirst();
    }

    @Override
    public T element() {
        return this.getFirst();
    }

    @Override
    public T peek() {
        return this.peekFirst();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int s = this.size;
        for (T element : c) {
            this.addLast(element);
        }
        return s != this.size;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int s = this.size;
        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < this.size; j++) {
                if (c.contains(this.array[j])) {
                    this.del(j);
                    this.size--;
                }
            }
        }
        return s != this.size;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.array = new Object[0];
        this.size = 0;
    }

    @Override
    public void push(T t) {
        this.addFirst(t);
    }

    @Override
    public T pop() {
        return removeFirst();
    }

    @Override
    public boolean remove(Object o) {
        return this.removeFirstOccurrence(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return this.array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < this.size) {
            return (T1[]) Arrays.copyOf(this.array, this.size, a.getClass());
        }

        System.arraycopy(this.array, 0, a, 0, this.size);

        if (a.length > this.size) {
            a[this.size] = null; // Если переданный массив больше по размеру, установить следующий элемент как null
        }

        return a;
    }

    @Override
    public Iterator<T> descendingIterator() {
        return null;
    }
}
