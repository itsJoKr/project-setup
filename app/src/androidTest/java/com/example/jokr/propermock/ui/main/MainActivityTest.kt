package com.example.jokr.propermock.ui.main

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withChild
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.jokr.propermock.R
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        onView(withId(R.id.recycler)).perform(ViewActions.swipeUp())
        onView(withId(R.id.recycler)).perform(ViewActions.swipeDown())
        onView(withId(R.id.recycler)).perform(ViewActions.swipeDown())

        onView(withText("ZG")).check(matches(isDisplayed()))
        onView(withText("R1")).check(matches(isDisplayed()))

        val zgText = withText("ZG")
        val rootView = allOf(withId(R.id.raceItemRoot), withChild(zgText))
        onView(allOf(withId(R.id.raceBackgroundImage), withParent(rootView))).check(
            matches(
                isDisplayed()
            )
        )

        onView(withText("R1")).perform(ViewActions.click())


        onView(withText("ZG")).check(matches(isDisplayed()))
        onView(withText("R1")).check(matches(isDisplayed()))
        onView(withId(R.id.description)).check(matches(isDisplayed()))
    }

}
