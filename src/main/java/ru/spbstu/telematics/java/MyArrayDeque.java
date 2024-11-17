package ru.spbstu.telematics.java;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
        T firstElement = (T) this.array[0];
        Object[] newArray = new Object[this.size - 1];
        System.arraycopy(this.array, 1, newArray, 0, this.size - 1);
        this.array = newArray;
        this.size--;
        return firstElement;
    }

    @Override
    public T pollLast() {
        if (this.isEmpty())
            return null;
        T lastElement = (T) this.array[this.size - 1];
        Object[] newArray = new Object[this.size - 1];
        System.arraycopy(this.array, 0, newArray, 0, this.size - 1);
        this.array = newArray;
        this.size--;
        return lastElement;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public T peekFirst() {
        return null;
    }

    @Override
    public T peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void push(T t) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
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
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public Iterator<T> descendingIterator() {
        return null;
    }
}
