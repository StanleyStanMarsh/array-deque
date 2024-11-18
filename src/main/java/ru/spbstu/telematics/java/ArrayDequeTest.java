package ru.spbstu.telematics.java;

import org.junit.Test;
import org.junit.Assert;

import java.util.*;

public class ArrayDequeTest {
    @Test
    public void addRemoveFirstTest()
    {
        Deque<Integer> javaDeque = new ArrayDeque<Integer>();
        Deque<Integer> myDeque = new MyArrayDeque<Integer>();
        javaDeque.addFirst(1);
        myDeque.addFirst(1);
        // Проверяем, что оба дека возвращают одинаковый первый элемент
        Assert.assertEquals(javaDeque.removeFirst(), myDeque.removeFirst());

        // Добавляем несколько элементов и проверяем
        javaDeque.addFirst(2);
        myDeque.addFirst(2);

        javaDeque.addFirst(3);
        myDeque.addFirst(3);

        // Проверяем порядок элементов
        Assert.assertEquals(javaDeque.removeFirst(), myDeque.removeFirst());
        Assert.assertEquals(javaDeque.removeFirst(), myDeque.removeFirst());

        // Проверяем, что размеры обеих дек одинаковые после операций
        Assert.assertEquals(javaDeque.size(), myDeque.size());
    }

    @Test
    public void addLastRemoveFirstTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        try {
            myDeque.addLast(null);
            Assert.fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            // Ожидается это исключение
        }

        // Добавляем элемент в конец
        javaDeque.addLast(1);
        myDeque.addLast(1);

        // Проверяем, что оба дека возвращают одинаковый первый элемент
        Assert.assertEquals(javaDeque.removeFirst(), myDeque.removeFirst());

        // Добавляем несколько элементов и проверяем
        javaDeque.addLast(2);
        myDeque.addLast(2);

        javaDeque.addLast(3);
        myDeque.addLast(3);

        // Проверяем порядок элементов
        Assert.assertEquals(javaDeque.removeFirst(), myDeque.removeFirst());
        Assert.assertEquals(javaDeque.removeFirst(), myDeque.removeFirst());

        // Проверяем, что размеры обеих дек одинаковые после операций
        Assert.assertEquals(javaDeque.size(), myDeque.size());
    }

    @Test
    public void addFirstRemoveLastTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        try {
            myDeque.addFirst(null);
            Assert.fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            // Ожидается это исключение
        }

        // Добавим несколько элементов в начало
        javaDeque.addFirst(1);
        javaDeque.addFirst(2);
        javaDeque.addFirst(3);

        myDeque.addFirst(1);
        myDeque.addFirst(2);
        myDeque.addFirst(3);

        // Удалим и проверим, что последний элемент одинаков для обоих дек
        Assert.assertEquals(javaDeque.removeLast(), myDeque.removeLast());

        // Проверим, что следующий последний элемент тоже удаляется правильно
        Assert.assertEquals(javaDeque.removeLast(), myDeque.removeLast());

        // Проверим, что размеры обоих дек уменьшились
        Assert.assertEquals(javaDeque.size(), myDeque.size());

        // Убедимся, что оставшийся элемент одинаков в обоих деках
        Assert.assertEquals(javaDeque.removeLast(), myDeque.removeLast());

        // Убедимся, что оба деки теперь пусты
        Assert.assertTrue(javaDeque.isEmpty());
        Assert.assertTrue(myDeque.isEmpty());
    }

    @Test
    public void addRemoveLastTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        // Добавим несколько элементов в конец
        javaDeque.addLast(1);
        javaDeque.addLast(2);
        javaDeque.addLast(3);

        myDeque.addLast(1);
        myDeque.addLast(2);
        myDeque.addLast(3);

        // Удалим и проверим, что последний элемент одинаков для обоих дек
        Assert.assertEquals(javaDeque.removeLast(), myDeque.removeLast());

        // Проверим, что следующий последний элемент тоже удаляется правильно
        Assert.assertEquals(javaDeque.removeLast(), myDeque.removeLast());

        // Проверим, что размеры обоих дек уменьшились
        Assert.assertEquals(javaDeque.size(), myDeque.size());

        // Убедимся, что оставшийся элемент одинаков в обоих деках
        Assert.assertEquals(javaDeque.removeLast(), myDeque.removeLast());

        // Убедимся, что оба деки теперь пусты
        Assert.assertTrue(javaDeque.isEmpty());
        Assert.assertTrue(myDeque.isEmpty());
    }

    @Test
    public void offerFirstTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        // Используем offerFirst для добавления элемента в начало
        Assert.assertTrue(myDeque.offerFirst(1));
        javaDeque.addFirst(1);

        // Проверяем, что первый элемент одинаков для обоих дек
        Assert.assertEquals(javaDeque.peekFirst(), myDeque.peekFirst());

        // Проверяем размер дека
        Assert.assertEquals(javaDeque.size(), myDeque.size());
    }

    @Test
    public void offerLastTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        // Используем offerLast для добавления элемента в конец
        Assert.assertTrue(myDeque.offerLast(1));
        javaDeque.addLast(1);

        // Проверяем, что последний элемент одинаков для обоих дек
        Assert.assertEquals(javaDeque.peekLast(), myDeque.peekLast());

        // Проверяем размер дека
        Assert.assertEquals(javaDeque.size(), myDeque.size());
    }

    @Test
    public void getFirstTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        // Проверяем поведение при пустом деке, должно вызываться исключение
        try {
            myDeque.getFirst();
            Assert.fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
            // Ожидается это исключение
        }

        // Добавляем элемент и проверяем, что getFirst возвращает его
        javaDeque.addFirst(1);
        myDeque.addFirst(1);
        Assert.assertEquals(javaDeque.getFirst(), myDeque.getFirst());

        // Добавляем еще один элемент в начало и проверяем
        javaDeque.addFirst(2);
        myDeque.addFirst(2);
        Assert.assertEquals(javaDeque.getFirst(), myDeque.getFirst());
    }

    @Test
    public void getLastTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        // Проверка поведения на пустом деке - должно вызываться исключение
        try {
            myDeque.getLast();
            Assert.fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
            // Ожидается это исключение
        }

        // Добавляем элемент и проверяем, что getLast возвращает его
        javaDeque.addLast(1);
        myDeque.addLast(1);
        Assert.assertEquals(javaDeque.getLast(), myDeque.getLast());

        // Добавляем еще один элемент в конец и проверяем
        javaDeque.addLast(2);
        myDeque.addLast(2);
        Assert.assertEquals(javaDeque.getLast(), myDeque.getLast());
    }

    @Test
    public void removeFirstOccurrenceTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        MyArrayDeque<Integer> myDeque = new MyArrayDeque<>();

        // Добавляем элементы в оба дека
        Integer[] elements = {1, 2, 3, 4, 5, 3};
        for (Integer element : elements) {
            javaDeque.addFirst(element);
            myDeque.addFirst(element);
        }

        // Удаляем первое вхождение элемента `3`
        javaDeque.removeFirstOccurrence(3);
        myDeque.removeFirstOccurrence(3);

        // Сравниваем дек, чтобы они были одинаковы после удаления
        Assert.assertEquals(javaDeque.size(), myDeque.size());

        Integer[] javaDequeArray = javaDeque.toArray(new Integer[0]);
        Integer[] myDequeArray = myDeque.toArray(new Integer[0]);

        Assert.assertArrayEquals(javaDequeArray, myDequeArray);
    }

    @Test
    public void removeLastOccurrenceTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        MyArrayDeque<Integer> myDeque = new MyArrayDeque<>();

        // Добавляем элементы в оба дека
        Integer[] elements = {1, 2, 3, 4, 5, 3};
        for (Integer element : elements) {
            javaDeque.addFirst(element);
            myDeque.addFirst(element);
        }

        // Удаляем последнее вхождение элемента `3`
        javaDeque.removeLastOccurrence(3);
        myDeque.removeLastOccurrence(3);

        // Сравниваем дек, чтобы они были одинаковы после удаления
        Assert.assertEquals(javaDeque.size(), myDeque.size());

        Integer[] javaDequeArray = javaDeque.toArray(new Integer[0]);
        Integer[] myDequeArray = myDeque.toArray(new Integer[0]);

        Assert.assertArrayEquals(javaDequeArray, myDequeArray);
    }

    @Test
    public void addTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        Integer[] elements = {1, 2, 3, 4, 5, 3};
        for (Integer element : elements) {
            javaDeque.add(element);
            myDeque.add(element);
        }

        Assert.assertEquals(javaDeque.size(), myDeque.size());

        Integer[] javaDequeArray = javaDeque.toArray(new Integer[0]);
        Integer[] myDequeArray = myDeque.toArray(new Integer[0]);

        Assert.assertArrayEquals(javaDequeArray, myDequeArray);
    }

    @Test
    public void offerTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        Integer[] elements = {1, 2, 3, 4, 5, 3};
        for (Integer element : elements) {
            javaDeque.offer(element);
            myDeque.offer(element);
        }

        Assert.assertEquals(javaDeque.size(), myDeque.size());

        Integer[] javaDequeArray = javaDeque.toArray(new Integer[0]);
        Integer[] myDequeArray = myDeque.toArray(new Integer[0]);

        Assert.assertArrayEquals(javaDequeArray, myDequeArray);
    }

    @Test
    public void removeTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        Integer[] elements = {1, 2, 3, 4, 5, 3};
        for (Integer element : elements) {
            javaDeque.offer(element);
            myDeque.offer(element);
        }

        javaDeque.remove();
        javaDeque.remove();
        myDeque.remove();
        myDeque.remove();

        Assert.assertEquals(javaDeque.size(), myDeque.size());

        Integer[] javaDequeArray = javaDeque.toArray(new Integer[0]);
        Integer[] myDequeArray = myDeque.toArray(new Integer[0]);

        Assert.assertArrayEquals(javaDequeArray, myDequeArray);
    }

    @Test
    public void pollTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        Integer[] elements = {1, 2, 3, 4, 5, 3};
        for (Integer element : elements) {
            javaDeque.offer(element);
            myDeque.offer(element);
        }

        javaDeque.poll();
        javaDeque.poll();
        myDeque.poll();
        myDeque.poll();

        Assert.assertEquals(javaDeque.size(), myDeque.size());

        Integer[] javaDequeArray = javaDeque.toArray(new Integer[0]);
        Integer[] myDequeArray = myDeque.toArray(new Integer[0]);

        Assert.assertArrayEquals(javaDequeArray, myDequeArray);
    }

    @Test
    public void elementTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        Integer[] elements = {1, 2, 3, 4, 5, 3};
        for (Integer element : elements) {
            javaDeque.addFirst(element);
            myDeque.addFirst(element);
        }

        Assert.assertEquals(javaDeque.element(), myDeque.element());
    }

    @Test
    public void peekFirstTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();
        // Добавляем элементы
        javaDeque.addLast(10);
        myDeque.addLast(10);

        javaDeque.addLast(20);
        myDeque.addLast(20);

        // Проверяем первый элемент
        Assert.assertEquals(javaDeque.peekFirst(), myDeque.peekFirst());
    }

    @Test
    public void peekLastTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();
        // Добавляем элементы
        javaDeque.addLast(10);
        myDeque.addLast(10);

        javaDeque.addLast(20);
        myDeque.addLast(20);

        // Проверяем последний элемент
        Assert.assertEquals(javaDeque.peekLast(), myDeque.peekLast());
    }

    @Test
    public void peekTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();
        // Добавляем элементы
        javaDeque.addLast(10);
        myDeque.addLast(10);

        javaDeque.addLast(20);
        myDeque.addLast(20);

        // Проверяем первый элемент с помощью метода peek
        Assert.assertEquals(javaDeque.peek(), myDeque.peek());
    }

    @Test
    public void pushTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();
        // Добавляем элементы
        javaDeque.push(1);
        myDeque.push(1);

        javaDeque.push(2);
        myDeque.push(2);

        // Проверяем верхний элемент после push
        Assert.assertEquals(javaDeque.peek(), myDeque.peek());

        // Проверяем размеры дека
        Assert.assertEquals(javaDeque.size(), myDeque.size());
    }

    @Test
    public void popTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();
        // Добавляем и извлекаем элементы
        javaDeque.push(1);
        myDeque.push(1);

        javaDeque.push(2);
        myDeque.push(2);

        // Удаляем верхний элемент и проверяем
        Assert.assertEquals(javaDeque.pop(), myDeque.pop());

        // Проверяем оставшийся верхний элемент
        Assert.assertEquals(javaDeque.peek(), myDeque.peek());

        // Проверяем размеры дека
        Assert.assertEquals(javaDeque.size(), myDeque.size());
    }

    @Test
    public void removeBoolTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();
        // Заполняем дек
        javaDeque.addLast(1);
        myDeque.addLast(1);

        javaDeque.addLast(2);
        myDeque.addLast(2);

        javaDeque.addLast(3);
        myDeque.addLast(3);

        // Удаляем элемент
        Assert.assertEquals(javaDeque.remove((Integer) 2), myDeque.remove((Integer) 2));

        // Проверяем, что размер уменьшился
        Assert.assertEquals(javaDeque.size(), myDeque.size());

        // Проверяем, что элемента больше нет
        Assert.assertArrayEquals(javaDeque.toArray(), myDeque.toArray());
    }

    @Test
    public void clearTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();
        // Заполняем дек
        javaDeque.add(1);
        myDeque.addLast(1);

        javaDeque.add(2);
        myDeque.addLast(2);

        javaDeque.add(3);
        myDeque.addLast(3);

        // Очищаем оба дека
        javaDeque.clear();
        myDeque.clear();

        // Проверяем, что дек пуст
        Assert.assertTrue(javaDeque.isEmpty());
        Assert.assertTrue(myDeque.isEmpty());

        // Проверяем, что размеры дек равны 0
        Assert.assertEquals(0, javaDeque.size());
        Assert.assertEquals(0, myDeque.size());
    }

    @Test
    public void addAllTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        Collection<Integer> collection = Arrays.asList(1, 2, 3);

        // Пытаемся добавить все элементы из коллекции
        boolean result1 = javaDeque.addAll(collection);
        boolean result2 = myDeque.addAll(collection);

        Assert.assertEquals(result1, result2);

        Integer[] javaDequeArray = javaDeque.toArray(new Integer[0]);
        Integer[] myDequeArray = myDeque.toArray(new Integer[0]);

        Assert.assertArrayEquals(javaDequeArray, myDequeArray);
    }

    @Test
    public void removeAllTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        Collection<Integer> initialCollection = Arrays.asList(1, 2, 3, 4, 5);
        myDeque.addAll(initialCollection);
        javaDeque.addAll(initialCollection);

        Collection<Integer> removeCollection = Arrays.asList(2, 4);

        // Пытаемся удалить элементы
        boolean result1 = javaDeque.removeAll(removeCollection);
        boolean result2 = myDeque.removeAll(removeCollection);

        Assert.assertEquals(result1, result2);

        Integer[] javaDequeArray = javaDeque.toArray(new Integer[0]);
        Integer[] myDequeArray = myDeque.toArray(new Integer[0]);

        Assert.assertArrayEquals(javaDequeArray, myDequeArray);
    }

    @Test
    public void retainAllTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        Collection<Integer> initialCollection = Arrays.asList(1, 2, 3, 4, 5);
        myDeque.addAll(initialCollection);
        javaDeque.addAll(initialCollection);

        Collection<Integer> removeCollection = Arrays.asList(2, 4);

        // Пытаемся удалить элементы
        boolean result1 = javaDeque.retainAll(removeCollection);
        boolean result2 = myDeque.retainAll(removeCollection);

        Assert.assertEquals(result1, result2);

        Integer[] javaDequeArray = javaDeque.toArray(new Integer[0]);
        Integer[] myDequeArray = myDeque.toArray(new Integer[0]);

        Assert.assertArrayEquals(javaDequeArray, myDequeArray);
    }

    @Test
    public void containsTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();
        Collection<Integer> initialCollection = Arrays.asList(1, 2, 3, 4, 5);
        javaDeque.addAll(initialCollection);
        myDeque.addAll(initialCollection);
        for (int i = 1; i <= 5; i++) {
            Assert.assertEquals(javaDeque.contains(i), myDeque.contains(i));
        }
        Assert.assertEquals(javaDeque.contains(6), myDeque.contains(6));
        Assert.assertEquals(javaDeque.contains(null), myDeque.contains(null));
    }

    @Test
    public void containsAllTest() {
        Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();
        Collection<Integer> collection1 = Arrays.asList(2, 3, 4);
        Collection<Integer> collection2 = Arrays.asList(1, 5);
        Collection<Integer> collection3 = Arrays.asList(6, 7);
        Collection<Integer> collection4 = Arrays.asList(1, 2, 6);

        Assert.assertEquals(javaDeque.containsAll(collection1), myDeque.containsAll(collection1));
        Assert.assertEquals(javaDeque.containsAll(collection2), myDeque.containsAll(collection2));
        Assert.assertEquals(javaDeque.containsAll(collection3), myDeque.containsAll(collection3));
        Assert.assertEquals(javaDeque.containsAll(collection4), myDeque.containsAll(collection4));
    }
}
