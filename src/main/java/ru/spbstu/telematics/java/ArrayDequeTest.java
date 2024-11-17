package ru.spbstu.telematics.java;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeTest {
    @Test
    public void addRemoveFirstTest()
    {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        Deque<Integer> myDeque = new MyArrayDeque<Integer>();
        deque.addFirst(1);
        myDeque.addFirst(1);
        // Проверяем, что оба дека возвращают одинаковый первый элемент
        Assert.assertEquals(deque.removeFirst(), myDeque.removeFirst());

        // Добавляем несколько элементов и проверяем
        deque.addFirst(2);
        myDeque.addFirst(2);

        deque.addFirst(3);
        myDeque.addFirst(3);

        // Проверяем порядок элементов
        Assert.assertEquals(deque.removeFirst(), myDeque.removeFirst());
        Assert.assertEquals(deque.removeFirst(), myDeque.removeFirst());

        // Проверяем, что размеры обеих дек одинаковые после операций
        Assert.assertEquals(deque.size(), myDeque.size());
    }

    @Test
    public void addLastRemoveFirstTest() {
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        // Добавляем элемент в конец
        deque.addLast(1);
        myDeque.addLast(1);

        // Проверяем, что оба дека возвращают одинаковый первый элемент
        Assert.assertEquals(deque.removeFirst(), myDeque.removeFirst());

        // Добавляем несколько элементов и проверяем
        deque.addLast(2);
        myDeque.addLast(2);

        deque.addLast(3);
        myDeque.addLast(3);

        // Проверяем порядок элементов
        Assert.assertEquals(deque.removeFirst(), myDeque.removeFirst());
        Assert.assertEquals(deque.removeFirst(), myDeque.removeFirst());

        // Проверяем, что размеры обеих дек одинаковые после операций
        Assert.assertEquals(deque.size(), myDeque.size());
    }

    @Test
    public void addFirstRemoveLastTest() {
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        // Добавим несколько элементов в начало
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        myDeque.addFirst(1);
        myDeque.addFirst(2);
        myDeque.addFirst(3);

        // Удалим и проверим, что последний элемент одинаков для обоих дек
        Assert.assertEquals(deque.removeLast(), myDeque.removeLast());

        // Проверим, что следующий последний элемент тоже удаляется правильно
        Assert.assertEquals(deque.removeLast(), myDeque.removeLast());

        // Проверим, что размеры обоих дек уменьшились
        Assert.assertEquals(deque.size(), myDeque.size());

        // Убедимся, что оставшийся элемент одинаков в обоих деках
        Assert.assertEquals(deque.removeLast(), myDeque.removeLast());

        // Убедимся, что оба деки теперь пусты
        Assert.assertTrue(deque.isEmpty());
        Assert.assertTrue(myDeque.isEmpty());
    }

    @Test
    public void addRemoveLastTest() {
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        // Добавим несколько элементов в конец
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        myDeque.addLast(1);
        myDeque.addLast(2);
        myDeque.addLast(3);

        // Удалим и проверим, что последний элемент одинаков для обоих дек
        Assert.assertEquals(deque.removeLast(), myDeque.removeLast());

        // Проверим, что следующий последний элемент тоже удаляется правильно
        Assert.assertEquals(deque.removeLast(), myDeque.removeLast());

        // Проверим, что размеры обоих дек уменьшились
        Assert.assertEquals(deque.size(), myDeque.size());

        // Убедимся, что оставшийся элемент одинаков в обоих деках
        Assert.assertEquals(deque.removeLast(), myDeque.removeLast());

        // Убедимся, что оба деки теперь пусты
        Assert.assertTrue(deque.isEmpty());
        Assert.assertTrue(myDeque.isEmpty());
    }

    @Test
    public void offerFirstTest() {
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        // Используем offerFirst для добавления элемента в начало
        Assert.assertTrue(myDeque.offerFirst(1));
        deque.addFirst(1);

        // Проверяем, что первый элемент одинаков для обоих дек
        Assert.assertEquals(deque.peekFirst(), myDeque.peekFirst());

        // Проверяем размер дека
        Assert.assertEquals(deque.size(), myDeque.size());
    }

    @Test
    public void offerLastTest() {
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> myDeque = new MyArrayDeque<>();

        // Используем offerLast для добавления элемента в конец
        Assert.assertTrue(myDeque.offerLast(1));
        deque.addLast(1);

        // Проверяем, что последний элемент одинаков для обоих дек
        Assert.assertEquals(deque.peekLast(), myDeque.peekLast());

        // Проверяем размер дека
        Assert.assertEquals(deque.size(), myDeque.size());
    }
}
