package project.masoumi.espressomockito

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import project.masoumi.espressomockito.bookservice.BookService
import project.masoumi.espressomockito.bookservice.LendBookManager

@RunWith(MockitoJUnitRunner::class)
class BookServiceTest {

    @Test(expected = IllegalStateException::class)
    fun whenBookIsNotAvailable_thenAnExceptionIsThrown() {
        val mockBookService = Mockito.mock(BookService::class.java)
        Mockito.`when`(mockBookService. inStock(100)).thenReturn(false)
        val manager = LendBookManager(mockBookService)
        manager.checkout(100, 1)
    }

    @Test
    fun whenBookIsAvailable_thenLendMethodIsCalled() {
        val mockBookService = Mockito.mock(BookService::class.java)
        Mockito.`when`(mockBookService. inStock(100)).thenReturn(true)
        val manager = LendBookManager(mockBookService)
        manager.checkout(100, 1)
        Mockito.verify(mockBookService).lend(100, 1)
    }
}