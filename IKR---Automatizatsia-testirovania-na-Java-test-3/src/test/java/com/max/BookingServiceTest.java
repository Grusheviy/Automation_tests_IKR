package com.max;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    /*
     * Тест успешного бронирования (book):
     * Проверяется, что при правильных параметрах бронирования
     *  метод book возвращает true.
     */
    @Test
    public void testBookSuccess() throws CantBookException {
        BookingService bookingService = new BookingService();
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = from.plusHours(2);
        String userId = "user123";

        BookingService mockedService = Mockito.spy(bookingService);
        doReturn(true).when(mockedService).checkTimeInBD(from, to);
        doReturn(true).when(mockedService).createBook(userId, from, to);

        assertTrue(mockedService.book(userId, from, to));

        verify(mockedService, times(1)).checkTimeInBD(from, to);
        verify(mockedService, times(1)).createBook(userId, from, to);
    }


    // Тесты для checkTimeInBD и createBook

    /*
     * Тест возвращения false методом checkTimeInBD:
     * Проверяется, что метод checkTimeInBD возвращает false при
     *  определенных параметрах времени.
     */
    @Test
    public void testCheckTimeInBDReturnFalse() {
        BookingService bookingService = new BookingService();
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = from.plusHours(2);

        assertFalse(bookingService.checkTimeInBD(from, to));
    }

    /*
     * Тест успешного создания брони (createBook):
     * Проверяется, что при успешном создании брони
     * метод createBook возвращает true.
     */
    @Test
    public void testCreateBookSuccess() throws CantBookException {
        BookingService bookingService = new BookingService();
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = from.plusHours(2);
        String userId = "user123";

        BookingService mockedService = Mockito.spy(bookingService);
        doReturn(true).when(mockedService).createBook(userId, from, to);

        assertTrue(mockedService.createBook(userId, from, to));
        verify(mockedService, times(1)).createBook(userId, from, to);
    }

    /*
     * Тест неуспешного создания брони (createBook):
     * Проверяется, что при неудачном создании брони
     * метод createBook возвращает false.
     */
    @Test
    public void testCreateBookFailure() throws CantBookException {
        BookingService bookingService = new BookingService();
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = from.plusHours(2);
        String userId = "user123";

        assertFalse(bookingService.createBook(userId, from, to));
    }

    // Тесты для book, используя реальные методы checkTimeInBD и createBook


    /*
     * Тест неуспешного бронирования из-за недоступности времени (book):
     * Проверяется, что при недоступном времени бронирование
     * выбрасывает CantBookException и createBook не вызывается.
     */
    @Test
    public void testBookFailureDueToTimeUnavailable() {
        BookingService bookingService = new BookingService();
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = from.plusHours(2);
        String userId = "user123";

        BookingService mockedService = Mockito.spy(bookingService);
        doReturn(false).when(mockedService).checkTimeInBD(from, to);

        assertThrows(CantBookException.class, () -> mockedService.book(userId, from, to));

        verify(mockedService, times(1)).checkTimeInBD(from, to);
        verify(mockedService, never()).createBook(any(), any(), any());
    }

    /*
     * Тест неуспешного бронирования из-за исключения CantBookException (book):
     * Проверяется, что при исключении CantBookException при бронировании,
     * createBook не вызывается.
     */
    @Test
    public void testBookFailureDueToException() throws CantBookException {
        BookingService bookingService = new BookingService();
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = from.plusHours(2);
        String userId = "user123";

        BookingService mockedService = Mockito.spy(bookingService);
        doAnswer(invocation -> {
            throw new CantBookException();
        }).when(mockedService).checkTimeInBD(from, to);

        assertThrows(CantBookException.class, () -> mockedService.book(userId, from, to));

        verify(mockedService, times(1)).checkTimeInBD(from, to);
        verify(mockedService, never()).createBook(any(), any(), any());
    }
}