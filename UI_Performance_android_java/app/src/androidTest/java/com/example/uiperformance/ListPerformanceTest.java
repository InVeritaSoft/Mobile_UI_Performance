package com.example.uiperformance;


import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
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
import static androidx.test.espresso.action.ViewActions.actionWithAssertions;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

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
           swipeUp()
        );
        onView(withId(R.id.item_text)).check(matches(withText("100")));
        onView(isRoot()).perform(waitFor(1100));
    }

    public void revert(){
        onView(withId(R.id.recyclerview)).perform(
            swipeDown()
        );
        onView(withId(R.id.item_text)).check(matches(withText("100")));
        onView(isRoot()).perform(waitFor(1100));
    }

    public static ViewAction swipeUp() {
        return actionWithAssertions(
                new GeneralSwipeAction(
                        Swipe.SLOW,
                        GeneralLocation.BOTTOM_CENTER,
                        GeneralLocation.TOP_CENTER,
                        Press.FINGER));
    }

    public static ViewAction swipeDown() {
        return actionWithAssertions(
                new GeneralSwipeAction(
                        Swipe.SLOW,
                        GeneralLocation.TOP_CENTER,
                        GeneralLocation.BOTTOM_CENTER,
                        Press.FINGER));
    }

//    String getText(final Matcher<View> matcher) {
//        final String[] stringHolder = { null };
//        onView(matcher).perform(new ViewAction() {
//            @Override
//            public Matcher<View> getConstraints() {
//                return isAssignableFrom(TextView.class);
//            }
//
//            @Override
//            public String getDescription() {
//                return "getting text from a TextView";
//            }
//
//            @Override
//            public void perform(UiController uiController, View view) {
//                TextView tv = (TextView)view; //Save, because of check in getConstraints()
//                stringHolder[0] = tv.getText().toString();
//            }
//        });
//        return stringHolder[0];
//    }



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
