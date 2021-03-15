package csc131.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThrows;
import org.junit.rules.ExpectedException;


class GiftCardTest {

	@Test
	public void testGetIssuingStore() {
		double       balance;
		GiftCard     card;
		int issuingStore;
		issuingStore = 1337;
		balance      = 100.00;
		
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());     
	}
	@Test
	public void getBalance() {
		double       balance;
		GiftCard     card;
		int issuingStore;
		double tolerance;
		
		issuingStore = 1337;
		balance      = 100.00;
		tolerance    = 0.001;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getBalance()", balance, card.getBalance(), tolerance);     
	}
	@Test 
	public void deduct_RemainingBalance() {
		double       balance;
		GiftCard     card;
		int issuingStore;
		String Remaining;
		
		issuingStore = 1337;
		balance      = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		Remaining = "Remaining Balance: " + String.format("%6.2f", 90.00);
		assertEquals("deduct(10.00)", Remaining, card.deduct(10.0));
		
		
	}
	@Test 
	public void deduct_Amount() {
		double       balance;
		GiftCard     card;
		int issuingStore;
		String Due;
		
		issuingStore = 1337;
		balance      = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		Due = "Amount Due: " + String.format("%6.2f", 10.00);
		assertEquals("deduct 110.00 from 100.00", Due, card.deduct(110.0));
	}
	@Test 
	public void deduct_InvalidTransaction() {
		double       balance;
		GiftCard     card;
		int issuingStore;
		String invalid;
			
		issuingStore = 1337;
		balance      = 100.00;
		card = new GiftCard(issuingStore, balance);
			
		invalid = "Invalid Transaction";
		assertEquals("deduct -10.00 from 100.00", invalid, card.deduct(-10.0));
	}
	@Test
	public void constructor_IncorrectBalance(){
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	}

	@Test
	public void constructor_IncorrectID_Low(){
	    assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1,100.00);}); 
	}
	@Test
	public void constructor_IncorrectID_High(){
	    assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000,100.00);}); 
	}
	
}
