package com.example.desafio_android.presentation.ui

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.desafio_android.R
import com.example.desafio_android.presentation.viewmodel.MainViewModel
import io.mockk.mockk
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val server = MockWebServer()

    private val intent = Intent(
        ApplicationProvider.getApplicationContext(), MainActivity::class.java
    )
    private lateinit var mainActivity: ActivityScenario<MainActivity>
    private lateinit var _context: Context
    private val viewModelMock: MainViewModel = mockk(relaxed = true)

    @Before
    fun setUp() {
        startKoin {
            viewModelMock
        }
        mainActivity = ActivityScenario.launch(intent)
        mainActivity.onActivity {
            _context = it
        }
    }

    @Test
    fun shouldDisplayListItem() {
        server.start(8080)

        activityRule.scenario.onActivity {
            onView(withId(R.id.recyclerRepos)).check(matches(isDisplayed()))

            Thread.sleep(3000)

            onView(withId(R.id.txtTitleRepo)).check(matches(isDisplayed()))
            onView(withId(R.id.txtForkTitle)).check(matches(isDisplayed()))
            onView(withId(R.id.txtStarQtd)).check(matches(isDisplayed()))
        }

        server.close()
    }
}