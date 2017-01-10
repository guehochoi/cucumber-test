package com.checkout.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.*;
import cucumber.api.junit.Cucumber;

import com.checkout.impl.Checkout;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:src/test/resources/features/checkout.feature")
public class CheckoutSteps {
	Checkout checkout = new Checkout();
	int bananaPrice = 0;
	
	@Given("^the price of a \"([^\"]*)\" is (\\d+)c$")
	public void thePriceOfAIsC(String name, int price) throws Throwable {
		bananaPrice = price;
	}

	@When("^I checkout (\\d+) \"([^\"]*)\"$")
	public void iCheckout(int itemCount, String itemName) throws Throwable {
		checkout.add(itemName, itemCount, bananaPrice);
	}

	@Then("^the total price should be (\\d+)c$")
	public void theTotalPriceShouldBeC(int total) throws Throwable {
		assertEquals(total, checkout.total());
	}
}