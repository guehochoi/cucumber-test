package step_definitions;

import cucumber.api.java.en.*;

import cucumber.api.PendingException;

import implementation.Checkout;
import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.*;

public class CheckoutSteps {
	Checkout checkout = new Checkout();
	
	Map<String, Integer> prices = new HashMap<>();
	
	@Given("^the price of a \"([^\"]*)\" is (\\d+)c$")
	public void thePriceOfAIsC(String name, int price) throws Throwable {
		prices.put(name, price);
	}

	@When("^I checkout (\\d+) \"([^\"]*)\"$")
	public void iCheckout(int itemCount, String itemName) throws Throwable {
		checkout.add(itemName, itemCount, prices.get(itemName));
	}

	@Then("^the total price should be (\\d+)c$")
	public void theTotalPriceShouldBeC(int total) throws Throwable {
		assertEquals(total, checkout.total());
	}
}