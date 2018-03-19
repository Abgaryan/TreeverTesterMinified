package common;

import android.content.Context;

import com.treever_template_tester.TreeverTesterApplication;
import com.treever_template_tester.comman.API;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import common.Injection.component.DaggerTestComponent;
import common.Injection.component.TestComponent;
import common.Injection.module.ApplicationTestModule;

/**
 * Created by Abgaryan on 3/18/18.
 * Test rule that creates and sets a Dagger TestComponent into the application overriding the
 * existing application component.
 * Use this rule in your test case in order for the app to use mock dependencies.
 * It also exposes some of the dependencies so they can be easily accessed from the tests, e.g. to
 * stub mocks etc.
 */
public class TestComponentRule implements TestRule {

    private final TestComponent mTestComponent;
    private final Context mContext;

    public TestComponentRule(Context context) {
        mContext = context;
        TreeverTesterApplication application = TreeverTesterApplication.get(context);
        mTestComponent = DaggerTestComponent.builder()
                .applicationTestModule(new ApplicationTestModule(application))
                .build();
    }

    public Context getContext() {
        return mContext;
    }

    public API getMockAPI() {
        return mTestComponent.api();
    }

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                TreeverTesterApplication application = TreeverTesterApplication.get(mContext);
                application.setComponent(mTestComponent);
                base.evaluate();
                application.setComponent(null);
            }
        };
    }
}
