package cse12pa1student;

import java.util.Collection;
import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BasketTest {

	public static Collection<Object[]> BAGNUMS =
			Arrays.asList(new Object[][] { {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}, {12} });
	private int bagType;

	public BasketTest(int bagType) {
		super();
		this.bagType = bagType;
	}

	@Parameterized.Parameters(name = "Basket{index}")
	public static Collection<Object[]> bags() {
		return BAGNUMS;
	}
	
	private Basket makeBasket() {
		switch(this.bagType) {
			case 0: return new Basket0();
			case 1: return new Basket1();
			case 2: return new Basket2();
			case 3: return new Basket3();
			case 4: return new Basket4();
			case 5: return new Basket5();
			case 6: return new Basket6();
			case 7: return new Basket7();
			case 8: return new Basket8();
			case 9: return new Basket9();
			case 10: return new Basket10();
			case 11: return new Basket11();
			case 12: return new Basket12();
		}
		return null;
	}
	
	@Test
	public void addedHasCount1() { //test 1
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		assertEquals(1, basketToTest.count());
	}
	public void addedNone() { //test 2
		Basket basketToTest = makeBasket();
		
		assertEquals(0, basketToTest.count());
		assertEquals(0, basketToTest.totalCost());
	}
	public void addedItem1() { // test 3
		Basket basketToTest = makeBasket();
		
		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 5);
		Item k = new Item("Paper", 15);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(k);
		assertEquals(2, basketToTest.countItem(i));
		assertEquals(2, basketToTest.countItem(j));
		assertEquals(1, basketToTest.countItem(k));
	}
	public void addedNullVariable() { //test 4
		Basket basketToTest = makeBasket();
		Item i = null;
		basketToTest.addToBasket(i);
		assewrEquals(false, basketToTest.removeAllFromBasket(i));
	}
	public void addedDouble(){ //test 5
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Conditioner", 10);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(i);
		assertEquals(3, basketToTest.count()); 			
		assertEquals(2, basketToTest.countItem(i));	
		basketToTest.addToBasket(j);
		assertEquals(4, basketToTest.count());			
		assertEquals(2, basketToTest.countItem(j));
	}
	public void removeDouble(){ //test 6
		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.removeAllFromBasket(j);
		assertEquals(0,basketToTest.count());
	}
	public void removedNone(){ //test 7
		Item i = new Item("Shampoo", 5);
		basketToTest.removeAllFromBasket(i);
		assertEquals(0,basketToTest.count());
		assertEquals(0,basketToTest.totalCost());
	}
	public void removeToCount(){ //test 8
		Basket basketToTest = makeBasket();
		
		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		assertEquals(1, basketToTest.count());
		basketToTest.removeFromBasket(i);
		assertEquals(0, basketToTest.count());
	}
	public void removeAllOfOne(){ //test 9
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Conditioner", 10);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		assertEquals(3, basketToTest.count());
		basketToTest.removeAllFromBasket(i);
		assertEquals(1, basketToTest.count());
	}
	public void addRemoveThree(){ //test 10
		Basket basketToTest = makeBasket();
		
		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.removeFromBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.removeFromBasket(i);
		basketToTest.addToBasket(i);
		assertEquals(1, basketToTest.count());
		basketToTest.removeFromBasket(i);
		assertEquals(0, basketToTest.count());
	}
	public void addRemoveThreeStraight(){ //test 11
		Basket basketToTest = makeBasket();
		
		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		assertEquals(3, basketToTest.count());
		basketToTest.removeFromBasket(i);
		assertEquals(2, basketToTest.count());
		basketToTest.removeFromBasket(i);
		assertEquals(1, basketToTest.count());
		basketToTest.removeFromBasket(i);
		assertEquals(0, basketToTest.count());
	}
	public void removeNonExist(){ //test 12
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Conditioner", 10);
		basketToTest.addToBasket(i);
		assertEquals(false, basketToTest.removeFromBasket(j));
		assertEquals(true, basketToTest.removeFromBasket(i));
		basketToTest.removeAllFromBasket(i);
		assertEquals(false, basketToTest.removeFromBasket(i));
	}
	public void total(){ //test 13
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Conditioner", 10);
		Item k = new Item("Lotion", 20);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(k);
		assertEquals(35, basketToTest.totalCost());
	}

	public void removeMore(){ //test 14
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.removeFromBasket(i);
		assertEquals(0, basketToTest.count());
		assertEquals(0, basketToTest.totalCost());
	}
	public void removeMore1(){ //test 15
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Conditioner", 10);
		basketToTest.removeFromBasket(i);
		basketToTest.removeFromBasket(j);
		assertEquals(0, basketToTest.count());
		assertEquals(0, basketToTest.totalCost());
	}
	public void removeMore2(){ //test 16
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.removeAllFromBasket(i);
		assertEquals(0, basketToTest.count());
		assertEquals(0, basketToTest.totalCost());
	}
}
