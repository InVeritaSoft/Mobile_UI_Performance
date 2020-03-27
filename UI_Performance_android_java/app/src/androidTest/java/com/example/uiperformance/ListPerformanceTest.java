package com.example.uiperformance;


import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ListPerformanceTest {

    protected ActivityScenario<MainActivity> recyclerViewActivityScenario;

    @Before
    public void setUp() {
        recyclerViewActivityScenario = ActivityScenario.launch(MainActivity.class);
    }


    @Test
    public void scroolTest(){
        for(int i = 0; i < 1 ;i++){
            forward();
            revert();
        }
    }

    public void forward(){
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(10)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(20)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(30)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(40)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(50)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(60)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(70)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(80)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(90)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(100)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));
    }

    public void revert(){
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(90)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(80)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(70)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(60)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(50)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(40)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(30)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(20)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(10)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));

        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(0)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(isRoot()).perform(waitFor(1100));
    }


    public static ViewAction waitFor(final long delay) {
        return new ViewAction() {
            @Override public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override public String getDescription() {
                return "wait for " + delay + "milliseconds";
            }

            @Override public void perform(UiController uiController, View view) {
                uiController.loopMainThreadForAtLeast(delay);
            }
        };
    }

}
