package com.max;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CantBookExceptionTest {

    /*
     * Проверка успешного создания объекта CantBookException:
     * Проверяется, что объект CantBookException
     * создается успешно и является экземпляром класса Exception.
     */
    @Test
    public void testCantBookExceptionCreation() {
        CantBookException exception = new CantBookException();

        assertNotNull(exception);
        assertTrue(exception instanceof Exception);
    }
}