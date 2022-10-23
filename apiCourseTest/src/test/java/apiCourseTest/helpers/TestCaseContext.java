package apiCourseTest.helpers;

import apiCourseTest.domain.Board;
import apiCourseTest.domain.List;
import io.cucumber.java.Scenario;

public class TestCaseContext {
    private static Board board;
    private static List list;
    private static Scenario scenario;

    public static void init(){
        board = null;
        list = null;
    }

    public static Board getBoard() {
        return board;
    }

    public static void setBoard(Board board) {
        TestCaseContext.board = board; //this. is not used in static variables because we can have multiple instances of TestCaseContext
    }

    public static List getList() {
        return list;
    }

    public static void setList(List list) {
        TestCaseContext.list = list;
    }

    public static Scenario getScenario() {
        return scenario;
    }

    public static void setScenario(Scenario scenario) {
        TestCaseContext.scenario = scenario;
    }
}
