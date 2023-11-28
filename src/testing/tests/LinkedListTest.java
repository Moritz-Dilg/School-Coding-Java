package testing.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testing.LinkedList.EmptyListException;
import testing.LinkedList.LinkedList;

public class LinkedListTest {
    LinkedList linkedList;

    @BeforeEach
    public void setUp() {
        linkedList = new LinkedList();
    }


    @Test
    public void testAppend1() {
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        Assertions.assertDoesNotThrow(() -> {
            Assertions.assertEquals(linkedList.popFront(), 1);
            Assertions.assertEquals(linkedList.popFront(), 2);
            Assertions.assertEquals(linkedList.popFront(), 3);
        });
    }

    @Test
    public void testPrepend1() {
        linkedList.prepend(1);
        linkedList.prepend(2);
        linkedList.prepend(3);

        Assertions.assertDoesNotThrow(() -> {
            Assertions.assertEquals(linkedList.popFront(), 3);
            Assertions.assertEquals(linkedList.popFront(), 2);
            Assertions.assertEquals(linkedList.popFront(), 1);
        });
    }

    @Test
    public void testPopFront1() {
        Exception exception = Assertions.assertThrows(EmptyListException.class, () -> linkedList.popFront());

        String expectedMessage = "Cannot pop from an empty linked list";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testPopFront2() {
        linkedList.append(-1);
        linkedList.append(2);
        linkedList.append(3);

        Assertions.assertDoesNotThrow(() -> {
            Assertions.assertEquals(linkedList.popFront(), -1);
            Assertions.assertEquals(linkedList.popFront(), 2);
            Assertions.assertEquals(linkedList.popFront(), 3);
        });

        Exception exception = Assertions.assertThrows(EmptyListException.class, () -> linkedList.popFront());

        String expectedMessage = "Cannot pop from an empty linked list";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testPopBack1() {
        Exception exception = Assertions.assertThrows(EmptyListException.class, () -> linkedList.popBack());

        String expectedMessage = "Cannot pop from an empty linked list";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testPopBack2() {
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        Assertions.assertDoesNotThrow(() -> {
            Assertions.assertEquals(linkedList.popBack(), 3);
            Assertions.assertEquals(linkedList.popBack(), 2);
            Assertions.assertEquals(linkedList.popBack(), 1);
        });

        Exception exception = Assertions.assertThrows(EmptyListException.class, () -> linkedList.popBack());

        String expectedMessage = "Cannot pop from an empty linked list";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testToString1() {
        Assertions.assertEquals("", linkedList.toString());
    }

    @Test
    public void testToString2() {
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        Assertions.assertEquals("1 2 3", linkedList.toString());
    }

}
