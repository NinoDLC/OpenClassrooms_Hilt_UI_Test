package fr.delcey.hiltuitest.ui.main;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;
import fr.delcey.hiltuitest.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
@HiltAndroidTest
public class MainActivityTest {

    @Rule
    public HiltAndroidRule hiltRule = new HiltAndroidRule(this);

    @Before
    public void setUp() {
        ActivityScenario.launch(MainActivity.class);
    }

    @Test
    public void mainActivityTest() {
        onView(
            allOf(
                withId(R.id.main_tv_message),
                isDisplayed()
            )
        ).check(matches(withText("Your savings so far are : 3")));
    }
}
