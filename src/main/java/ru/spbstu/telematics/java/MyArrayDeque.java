package ru.spbstu.telematics.java;
import java.util.*;

class MyArrayDeque<E> implements Deque<E>, Iterable<E>
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

    public MyArrayDeque(Collection<? extends E> c)
    {
        this.array = new Object[c.size()];
        this.size = 0;
        for (Iterator<? extends E> iter = c.iterator(); iter.hasNext(); )
        {
            E element = iter.next();
            this.array[this.size++] = element;
        }
    }

    @Override
    public void addFirst(E t) {
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
    public void addLast(E t) {
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
    public boolean offerFirst(E t) {
        this.addFirst(t);
        return true;
    }

    @Override
    public boolean offerLast(E t) {
        this.addLast(t);
        return true;
    }

    @Override
    public E removeFirst() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        return this.pollFirst();
    }

    @Override
    public E removeLast() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        return this.pollLast();
    }

    @Override
    public E pollFirst() {
        if (this.isEmpty())
            return null;
        E firstElement = this.getFirst();
        this.del(0);
        this.size--;
        return firstElement;
    }

    @Override
    public E pollLast() {
        if (this.isEmpty())
            return null;
        E lastElement = this.getLast();
        this.del(this.size - 1);
        this.size--;
        return lastElement;
    }

    @Override
    public E getFirst() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        return this.peekFirst();
    }

    @Override
    public E getLast() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        return this.peekLast();
    }

    @Override
    public E peekFirst() {
        if (this.isEmpty())
            return null;
        return (E) this.array[0];
    }

    @Override
    public E peekLast() {
        if (this.isEmpty())
            return null;
        return (E) this.array[this.size - 1];
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
    public boolean add(E t) {
        this.addLast(t);
        return true;
    }

    @Override
    public boolean offer(E t) {
        return this.offerLast(t);
    }

    @Override
    public E remove() {
        return this.removeFirst();
    }

    @Override
    public E poll() {
        return this.pollFirst();
    }

    @Override
    public E element() {
        return this.getFirst();
    }

    @Override
    public E peek() {
        return this.peekFirst();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int s = this.size;
        for (E element : c) {
            this.addLast(element);
        }
        return s != this.size;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int s = this.size;
        for (int j = 0; j < this.size; j++) {
            if (c.contains(this.array[j])) {
                this.del(j);
                this.size--;
            }
        }
        return s != this.size;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int s = this.size;
        for (int j = 0; j < this.size; j++) {
            if (!c.contains(this.array[j])) {
                this.del(j);
                this.size--;
            }
        }
        return s != this.size;
    }

    @Override
    public void clear() {
        this.array = new Object[0];
        this.size = 0;
    }

    @Override
    public void push(E t) {
        this.addFirst(t);
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public boolean remove(Object o) {
        return this.removeFirstOccurrence(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            return false;
        }

        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null)
            return false;
        for (int i = 0; i < this.size; i++) {
            if (o.equals(this.array[i])) {
                return true;
            }
        }
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
    public Iterator<E> iterator() {
        return new MyArrayDequeIterator();
    }

    private class MyArrayDequeIterator implements Iterator<E> {
        private int currentIndex = 0;
        private int lastReturnedIndex = -1;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturnedIndex = currentIndex;
            return (E) array[currentIndex++];
        }

        @Override
        public void remove() {
            if (lastReturnedIndex < 0) {
                throw new IllegalStateException("remove() can only be called once per call to next().");
            }

            System.arraycopy(array, lastReturnedIndex + 1, array,
                    lastReturnedIndex, size - lastReturnedIndex - 1);
            array[--size] = null;
            currentIndex = lastReturnedIndex;
            lastReturnedIndex = -1;
        }
    }

    @Override
    public Object[] toArray() {
        return this.array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < this.size) {
            return (T[]) Arrays.copyOf(this.array, this.size, a.getClass());
        }

        System.arraycopy(this.array, 0, a, 0, this.size);

        if (a.length > this.size) {
            a[this.size] = null; // Если переданный массив больше по размеру, установить следующий элемент как null
        }

        return a;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new DescendingIterator();
    }

    private class DescendingIterator implements Iterator<E> {
        private int currentIndex = size - 1;
        private int lastReturnedIndex = -1;

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturnedIndex = currentIndex;
            return (E) array[currentIndex--];
        }

        @Override
        public void remove() {
            if (lastReturnedIndex < 0) {
                throw new IllegalStateException("remove() can only be called once per call to next().");
            }

            System.arraycopy(array, lastReturnedIndex + 1, array,
                    lastReturnedIndex, size - lastReturnedIndex - 1);
            array[--size] = null;
            currentIndex = lastReturnedIndex - 1;
            lastReturnedIndex = -1;
        }
    }
}
