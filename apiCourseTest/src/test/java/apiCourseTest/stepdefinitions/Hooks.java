package apiCourseTest.stepdefinitions;

import apiCourseTest.helpers.TestCaseContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static apiCourseTest.clients.TrelloClient.changeBoardName;
import static apiCourseTest.clients.TrelloClient.deleteList;
import static apiCourseTest.constants.ProjectConstants.BOARD_NAME;

public class Hooks {
    @Before
    public void beforeHook(Scenario scenario){
        TestCaseContext.init();
        TestCaseContext.setScenario(scenario); //for reporting reasons
        System.out.println("THE SCENARIO HAS STARTED");
    }

    @After
    public void afterHook(){
        changeBoardName(BOARD_NAME, TestCaseContext.getBoard().getId());
        deleteList(TestCaseContext.getList().getId());
        System.out.println("THE SCENARIO HAS ENDED");
    }
}
