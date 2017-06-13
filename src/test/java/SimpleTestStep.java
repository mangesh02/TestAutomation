import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SimpleTestStep {
	
	@Given("^user is on given statement$")
	public void given(){
		System.out.println("This is given statement");
	}

	@When("^user is on when statement$")
	public void when(){
		System.out.println("This is when statement");
	}
	
	@Then("^user is on then statement$")
	public void then(){
		System.out.println("This is then statement");
	}
}
