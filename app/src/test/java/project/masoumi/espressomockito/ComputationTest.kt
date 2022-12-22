package project.masoumi.espressomockito

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import project.masoumi.espressomockito.computation.ComputationActivity
import project.masoumi.espressomockito.computation.Operations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class ComputationTest {
    @Mock
    lateinit var operators: Operations
    lateinit var computationActivity: ComputationActivity

    @Before
    fun setUp(){
        computationActivity = ComputationActivity(operators)
    }

    @Test
    fun givenValidInput_getAddition_shouldCallAddOperator() {
        val x = 5
        val y = 10
        computationActivity.getAddition(x, y)
        verify(operators).add(x, y)
    }
}