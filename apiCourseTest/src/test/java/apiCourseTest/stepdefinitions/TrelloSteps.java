package apiCourseTest.stepdefinitions;

import apiCourseTest.domain.Board;
import apiCourseTest.domain.List;
import apiCourseTest.helpers.TestCaseContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

import static apiCourseTest.clients.TrelloClient.*;
import static apiCourseTest.constants.ProjectConstants.BOARD_ID;
import static apiCourseTest.constants.ProjectConstants.BOARD_NAME;

public class TrelloSteps {
    @Given("The board exists and contains the correct information")
    public void getBoardAndCheckInfo (){
        Response response = getBoardInfo(BOARD_ID);
        Board board = response.as(Board.class);
        TestCaseContext.setBoard(board);

        Assertions.assertThat(board.getId())
                .as("We assert that the board ID is correct")
                .isEqualTo(BOARD_ID);

        Assertions.assertThat(board.getName())
                .as("We assert that the board name is correct")
                .isEqualTo(BOARD_NAME);

    }

    @When("I change the board title to {string}")
    public void changeBoardTitle(String title){
        Response response = changeBoardName(title, TestCaseContext.getBoard().getId());
        Board board = response.as(Board.class);
        TestCaseContext.setBoard(board);
    }

    @And("I check that the board name was updated to {string}")
    public void checkBoardTitle(String name) {
        Assertions.assertThat(TestCaseContext.getBoard().getName())
                .as("We check that the board name was updated to " + name)
                .isEqualTo(name);
    }

    @Then("I add a list with title {string} to the board")
    public void addNewList(String name){
        Response response = createList(name, TestCaseContext.getBoard().getId());
        List list = response.as(List.class);
        TestCaseContext.setList(list);

        Assertions.assertThat(list.getName())
                .as("The list was created with name " + name)
        .isEqualTo(name);

        TestCaseContext.getScenario().log("The list ID is " + list.getId());
    }

}
