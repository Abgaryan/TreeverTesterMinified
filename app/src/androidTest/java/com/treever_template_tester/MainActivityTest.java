package com.treever_template_tester;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.treever_template_tester.model.ModelTemplate;
import com.treever_template_tester.model.ModelTimeStamp;
import com.treever_template_tester.model.ServerResponseModel;
import com.treever_template_tester.ui.main_screen.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import rx.Observable;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.when;

/**
 * Created by Abgaryan on 3/19/18.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getTargetContext());
    public final ActivityTestRule<MainActivity> main =
            new ActivityTestRule<MainActivity>(MainActivity.class, false, false) {
                @Override
                protected Intent getActivityIntent() {
                    // Override the default intent so we pass a false flag for syncing so it doesn't
                    // start a sync service in the background that would affect  the behaviour of
                    // this test.
                    return MainActivity.getStartIntent(
                            InstrumentationRegistry.getTargetContext());
                }
            };

    // TestComponentRule needs to go first to make sure the Dagger ApplicationTestComponent is set
    // in the Application before any Activity is launched.
    @Rule
    public final TestRule chain = RuleChain.outerRule(component).around(main);



    @Test
    public void listOfTemplatesShows() {
        ModelTimeStamp modelTimeStamp = new ModelTimeStamp();
        modelTimeStamp.setLast_request(0);
        ServerResponseModel serverResponseModel = TestDataFactory.makeSereverResponesModel();
        ArrayList<ModelTemplate> templates = serverResponseModel.getServerDataModel().getModelTemplates();


        when(component.getMockAPI().getAssets(modelTimeStamp))
                .thenReturn(Observable.just(templates));

        main.launchActivity(null);

        int position = 0;
        for (ModelTemplate templates1 : templates) {
            onView(withId(R.id.to_be_tested_recyclerView))
                    .perform(RecyclerViewActions.scrollToPosition(position));
            String str ="#"+ templates1.getTemplate_cloud_id() +"     "+  templates1.getFile_name();
            onView(withText(str))
                    .check(matches(isDisplayed()));
            position++;
        }
    }

}
