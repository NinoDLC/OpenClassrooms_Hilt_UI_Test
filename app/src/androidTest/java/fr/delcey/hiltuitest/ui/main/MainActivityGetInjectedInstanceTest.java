package fr.delcey.hiltuitest.ui.main;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;
import fr.delcey.hiltuitest.R;
import fr.delcey.hiltuitest.data.SavingsRepository;

@LargeTest
@RunWith(AndroidJUnit4.class)
@HiltAndroidTest
public class MainActivityGetInjectedInstanceTest {

    @Rule
    public HiltAndroidRule hiltRule = new HiltAndroidRule(this);

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    // In our UI test class, we have access to the same instance that is used by the source code !
    @Inject
    SavingsRepository savingsRepository;

    @Before
    public void setUp() {
        hiltRule.inject();

        ActivityScenario.launch(MainActivity.class);
    }

    @Test
    public void mainActivityTest() {
        // By default, we should display 3...
        onView(
            allOf(
                withId(R.id.main_tv_message),
                isDisplayed()
            )
        ).check(matches(withText("Your savings so far are : 3")));

        // ... but if we manipulate the instance ourselves in the UI test class...
        savingsRepository.updateSavings(5);

        // ... the change is updated in our view !
        onView(
            allOf(
                withId(R.id.main_tv_message),
                isDisplayed()
            )
        ).check(matches(withText("Your savings so far are : 5")));
    }
}
