package step_Defs;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void beforeHooks(){
        System.out.println("This runs before");
    }

    @After
    public void afterhook(){
        System.out.println("This runs after");
    }
}
