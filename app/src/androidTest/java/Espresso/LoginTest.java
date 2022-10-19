package Espresso;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;
import android.widget.EditText;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.example.marketstructure.LoginActivity;
import com.example.marketstructure.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginTest {


    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void emailIsEmpty(){
        onView(withId(R.id.lg_email)).perform(clearText());
        onView(withId(R.id.lg_loginButton)).perform(click());
        onView(withId(R.id.lg_email)).check(matches(withError("Empty Email")));
    }

    @Test
    public void passIsEmpty(){
        onView(withId(R.id.lg_email)).perform(typeText("testlogin2@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.lg_password)).perform(clearText());
        onView(withId(R.id.lg_loginButton)).perform(click());
        onView(withId(R.id.lg_password)).check(matches(withError("Empty Password")));
    }

    @Test
    public void passIsShort(){
        onView(withId(R.id.lg_email)).perform(typeText("testlogin2@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.lg_password)).perform(typeText("12345"),closeSoftKeyboard());
        onView(withId(R.id.lg_loginButton)).perform(click());
        onView(withId(R.id.lg_password)).check(matches(withError("Password length is less than 6")));
    }





    //Error test due to Firebase integration
    /*
    @Test
    public void loginSuccessfully(){
        onView(withId(R.id.lg_email)).perform(typeText("testlogin3update@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.lg_password)).perform(typeText("654321"),closeSoftKeyboard());
        onView(withId(R.id.lg_loginButton)).perform(click());
        onView(withText("Login Success. "))
                .inRoot(withDecorView(not(activityTestRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));
    }
     */
    private static Matcher<View> withError(final String expected){
        return new TypeSafeMatcher<View>(){
            @Override
            public void describeTo(Description description) {
                description.appendText("Not found error message" + expected + ", find it!");
            }

            @Override
            protected boolean matchesSafely(View item){
                if(item instanceof EditText){
                    return ((EditText)item).getError().toString().equals(expected);
                }
                return false;
            }
        };
    }
}
