package com.example.uiperformance;


import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ListPerformanceTest {

//    private static final String TEXT_ITEM_30 = "item: 30";
//
//    private static final String TEXT_ITEM_30_SELECTED = "30";
//
//    private static final String TEXT_ITEM_60 = "item: 60";
//
//    // Match the last item by matching its text.
//    private static final String LAST_ITEM_ID = "item: 99";
   private static final int RV_ID = R.id.recyclerview;


    protected ActivityScenario<MainActivity> recyclerViewActivityScenario;

    @Before
    public void setUp() throws Exception {
        recyclerViewActivityScenario = ActivityScenario.launch(MainActivity.class);
    }



//    @Rule
//    public ActivityScenarioRule<MainActivity> rule = new ActivityScenarioRule<>(
//            MainActivity.class);


    @Test
    public void scroolTest(){
        for(int i = 0; i < 10;i++){
            forward();
            revert();
        }
        //onView(withId(RV_ID)).perform(scrollTo(hasDescendant(withText(ITEM_64))));
        //onView(withItemText(ITEM_64)).check(matches(isDisplayed()));
    }

    public void forward(){
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(10)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(20)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(30)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(40)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(50)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(60)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(70)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(80)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(90)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(100)
                //actionOnItemAtPosition(step, scrollTo())
        );
    }

    public void revert(){
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(90)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(80)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(70)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(60)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(50)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(40)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(30)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(20)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(10)
                //actionOnItemAtPosition(step, scrollTo())
        );
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition(0)
                //actionOnItemAtPosition(step, scrollTo())
        );
    }

//    @Test
//    public void testSample(){
//        onView(withId(R.id.recyclerview)).perform(
//                RecyclerViewActions.actionOnItemAtPosition(0, click())
//        );
//    }

//    @Test
//    public void lastItem_NotDisplayed() {
//        // Last item should not exist if the list wasn't scrolled down.
//        onView(withText(LAST_ITEM_ID)).check(doesNotExist());
//    }
//
//
//    @Test
//    public void list_Scrolls() {
//        onRow(LAST_ITEM_ID).check(matches(isCompletelyDisplayed()));
//    }


//    @Test
//    public void row_Click() {
//        // Click on one of the rows.
//        onRow(TEXT_ITEM_30).onChildView(withId(R.id.rowContentTextView)).perform(click());
//
//        // Check that the activity detected the click on the first column.
//        onView(ViewMatchers.withId(R.id.selection_row_value))
//                .check(matches(withText(TEXT_ITEM_30_SELECTED)));
//    }
//
//
//    @Test
//    public void toggle_Click() {
//        // Click on a toggle button.
//        onRow(TEXT_ITEM_30).onChildView(withId(R.id.rowToggleButton)).perform(click());
//
//        // Check that the toggle button is checked.
//        onRow(TEXT_ITEM_30).onChildView(withId(R.id.rowToggleButton)).check(matches(isChecked()));
//    }
//
//
//    @Test
//    public void toggle_ClickDoesntPropagate() {
//        // Click on one of the rows.
//        onRow(TEXT_ITEM_30).onChildView(withId(R.id.rowContentTextView)).perform(click());
//
//        // Click on the toggle button, in a different row.
//        onRow(TEXT_ITEM_60).onChildView(withId(R.id.rowToggleButton)).perform(click());
//
//        // Check that the activity didn't detect the click on the first column.
//        onView(ViewMatchers.withId(R.id.selection_row_value))
//                .check(matches(withText(TEXT_ITEM_30_SELECTED)));
//    }
//
//    private static DataInteraction onRow(String str) {
//        return onData(hasEntry(equalTo(MainActivity.ROW_TEXT), is(str)));
//    }


}
