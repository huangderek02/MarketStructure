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
import androidx.test.rule.ActivityTestRule;

import com.example.marketstructure.R;
import com.example.marketstructure.RegisterActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RegisterTest {

    @Rule
    public ActivityTestRule<RegisterActivity> activityTestRule = new ActivityTestRule<>(RegisterActivity.class);

    @Test
    public void emailIsEmpty(){
        onView(withId(R.id.email)).perform(clearText());
        onView(withId(R.id.username)).perform(typeText("testEspresso1"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("123456"),closeSoftKeyboard());
        onView(withId(R.id.con_password)).perform(typeText("123456"),closeSoftKeyboard());
        onView(withId(R.id.sign_up_button)).perform(click());
        onView(withId(R.id.email)).check(matches(withError("Empty Email are invalid")));
    }

    @Test
    public void nameIsEmpty(){
        onView(withId(R.id.email)).perform(typeText("testlogin2@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.username)).perform(clearText());
        onView(withId(R.id.password)).perform(typeText("123456"),closeSoftKeyboard());
        onView(withId(R.id.con_password)).perform(typeText("123456"),closeSoftKeyboard());
        onView(withId(R.id.sign_up_button)).perform(click());
        onView(withId(R.id.username)).check(matches(withError("Empty name are invalid")));
    }

    @Test
    public void passIsEmpty(){
        onView(withId(R.id.email)).perform(typeText("testlogin2@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.username)).perform(typeText("testEspresso1"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(clearText());
        onView(withId(R.id.con_password)).perform(typeText("123456"),closeSoftKeyboard());
        onView(withId(R.id.sign_up_button)).perform(click());
        onView(withId(R.id.password)).check(matches(withError("Empty password are invalid")));
    }

    @Test
    public void cPassIsEmpty(){
        onView(withId(R.id.email)).perform(typeText("testlogin2@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.username)).perform(typeText("testEspresso1"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("123456"),closeSoftKeyboard());
        onView(withId(R.id.con_password)).perform(clearText());
        onView(withId(R.id.sign_up_button)).perform(click());
        onView(withId(R.id.con_password)).check(matches(withError("Empty password are invalid")));
    }

    @Test
    public void passNotMatch(){
        onView(withId(R.id.email)).perform(typeText("testlogin2@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.username)).perform(typeText("testEspresso1"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("123456"),closeSoftKeyboard());
        onView(withId(R.id.con_password)).perform(typeText("123457"),closeSoftKeyboard());
        onView(withId(R.id.sign_up_button)).perform(click());
        onView(withId(R.id.con_password)).check(matches(withError("Password not match")));
    }




    @Test
    public void passIsShort(){
        onView(withId(R.id.email)).perform(typeText("testlogin2@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.username)).perform(typeText("testEspresso1"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("12345"),closeSoftKeyboard());
        onView(withId(R.id.con_password)).perform(typeText("12345"),closeSoftKeyboard());
        onView(withId(R.id.sign_up_button)).perform(click());
        onView(withId(R.id.password)).check(matches(withError("Password length is less than 6")));
    }

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
