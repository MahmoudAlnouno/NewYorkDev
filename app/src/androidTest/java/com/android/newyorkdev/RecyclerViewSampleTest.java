package com.android.newyorkdev;

import com.android.newyorkdev.ui.main.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RecyclerViewSampleTest {
    private static final int ITEM_BELOW_THE_FOLD = 40;
    //This rule provides functional testing of a single activity.
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickRandomItem() {
        //Magic happening
        int x = getRandomRecyclerPosition(R.id.recyclerPopular);
        onView(withId(R.id.recyclerPopular))
                .perform(RecyclerViewActions
                        .actionOnItemAtPosition(x, click()));
        onView(withId(R.id.recyclerPopular))
                .perform(RecyclerViewActions
                        .actionOnItemAtPosition(x, click()));
    }

    private int getRandomRecyclerPosition(int recyclerId) {
        Random ran = new Random();
        //Get the actual drawn RecyclerView
        RecyclerView recyclerView = (RecyclerView) mActivityRule
                .getActivity().findViewById(recyclerId);

        //If the RecyclerView exists, get the item count from the adapter
        int n = (recyclerView == null)
                ? 1
                : recyclerView.getAdapter().getItemCount();

        //Return a random number from 0 (inclusive) to adapter.itemCount() (exclusive)
        return ran.nextInt(n);
    }


}
