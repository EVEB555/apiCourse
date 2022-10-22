package apiCourseTest.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrelloSteps {

    @Given("The board exists and contains the correct information")
    public void getBoardAndCheckInfo (){
        System.out.println("The first step is being executed");
    }

    @When("I change the board title to {string}")
    public void changeBoardTitle(String title){
        System.out.println("The title was changed to: " + title);
    }

    @And("I check that the board name was updated to {string}")
    public void checkBoardTitle(String name) {
        System.out.println("The board name was updated to: " + name);
    }

    @Then("I add a list with title {string} to the board")
    public void addNewList(String name){
        System.out.println("We added a new list with name: " + name);
    }

}
