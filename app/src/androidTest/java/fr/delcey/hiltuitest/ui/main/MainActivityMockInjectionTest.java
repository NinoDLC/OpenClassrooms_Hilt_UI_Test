package fr.delcey.hiltuitest.ui.main;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import dagger.hilt.android.testing.BindValue;
import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;
import fr.delcey.hiltuitest.R;
import fr.delcey.hiltuitest.data.SavingsRepository;

@LargeTest
@RunWith(AndroidJUnit4.class)
@HiltAndroidTest
public class MainActivityMockInjectionTest {

    @Rule
    public HiltAndroidRule hiltRule = new HiltAndroidRule(this);

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    // We replace the instance provided to the source code with this one instead (a Mockito mock)
    @BindValue
    SavingsRepository savingsRepository = Mockito.mock(SavingsRepository.class);

    private final MutableLiveData<Integer> savingsMutableLiveData = new MutableLiveData<>();

    @Before
    public void setUp() {
        Mockito.when(savingsRepository.getSavingsLiveData()).thenReturn(savingsMutableLiveData);

        ActivityScenario.launch(MainActivity.class);
    }

    @Test
    public void mainActivityTest() {
        savingsMutableLiveData.setValue(5);

        onView(
            allOf(
                withId(R.id.main_tv_message),
                isDisplayed()
            )
        ).check(matches(withText("Your savings so far are : 5")));
    }
}
