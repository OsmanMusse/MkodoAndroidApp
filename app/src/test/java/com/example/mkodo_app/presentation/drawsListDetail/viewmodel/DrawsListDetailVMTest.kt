package com.example.mkodo_app.presentation.drawsListDetail.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import com.example.mkodo_app.data.repo.DrawRepository
import com.example.mkodo_app.util.GeneralHelper.getOrAwaitValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest=Config.NONE)
class DrawsListDetailVMTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    @Mock
     lateinit var repo:DrawRepository


    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }


    @Test
    fun `test refresh lottery data fetches from repository `() = runTest {
        Mockito. `when`(repo.getDraws(ApplicationProvider.getApplicationContext())).thenReturn(emptyList())

        val sut = DrawsListDetailVM(repo,ApplicationProvider.getApplicationContext())
        sut.fetchDraws()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = sut.drawListResult.getOrAwaitValue()
        Assert.assertEquals(0,result.size)
    }

}