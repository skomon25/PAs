
import static org.junit.Assert.*;

import java.beans.Transient;
import java.util.Arrays;
import java.util.Collection; 
import java.util.NoSuchElementException;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestLists {

	public static Collection<Object[]> LISTNUMS =
			Arrays.asList(new Object[][] { {"Linked"}, {"Array"} });
	private String listType;

	public TestLists(String listType) {
		super();
		this.listType = listType;
	}

	@Parameterized.Parameters(name = "{0}List")
	public static Collection<Object[]> bags() {
		return LISTNUMS;
	}

	private <E> MyList<E> makeList(E[] contents) {
		switch (this.listType) {
		case "Linked":
			return new LinkedGL<E>(contents);
		case "Array":
			return new ArrayGL<E>(contents);
		}
		return null;
	}

  // Don't change code above this line, it ensures the autograder works as
  // expected


  // This is a sample test; you can keep it, change it, or remove it as you like.
  // Note that it uses the method `assertArrayEquals`, which you should use to
  // test equality of arrays in this PA.
	@Test
	public void testSimpleToArray() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {1, 2, 3};
		MyList<Integer> int_s = makeList(int_input);
		assertArrayEquals(int_input, int_s.toArray());
		
		// Using the generic list to create a String list
		String[] string_input = {"a", "b", "c"};
		MyList<String> string_s = makeList(string_input);
		assertArrayEquals(string_input, string_s.toArray());
	}
	@Test
	public void testChooserAndTransform(MyTransformer ReverseSignTransformer, MyChooser DivisibleByThreeChooser, MyTransformer AddTwoTransformer, MyChooser StringBChooser){
		Integer[] int_input = {1, 2, 3};
		MyList<Integer> int_s = makeList(int_input);
		Integer[] int_input2 = {3, 6, 12};
		MyList<Integer> int_t = makeList(int_input2);
		Integer[] int_input3 = {-1, 2, -3};
		MyList<Integer> int_u = makeList(int_input3);
		String[] string_input = {"a", "b", "c"};
		MyList<String> string_s = makeList(string_input);
		String[] string_input2 = {"bat", "cat", "rat"};
		MyList<String> string_t = makeList(string_input2);
		String[] string_input3 = {"a", "e", "c"};
		MyList<String> string_u = makeList(string_input3);

		Integer[] int_result = {-1,-2,-3};
		Integer[] int_result2 = {-3,-6,-12};
		Integer[] int_result3 = {1,-2,3};
		Integer[] int_result4 = {3};
		Integer[] int_result5 = {3,6,12};
		Integer[] int_result6 = {-3};
		Integer[] int_result7 = {3,4,5};
		Integer[] int_result8 = {5,8,14};
		Integer[] int_result9 = {1,4,-1};

		String[] string_result = {"b"};
		String[] string_result2 = {"bat"};
		String[] string_result3 = {};

		assertArrayEquals(int_result, int_s.transformAll(ReverseSignTransformer));
		assertArrayEquals(int_result2, int_t.transformAll(ReverseSignTransformer));
		assertArrayEquals(int_result3, int_u.transformAll(ReverseSignTransformer));
		assertArrayEquals(int_result4, int_s.chooseAll(DivisibleByThreeChooser));
		assertArrayEquals(int_result5, int_t.chooseAll(DivisibleByThreeChooser));
		assertArrayEquals(int_result6, int_u.chooseAll(DivisibleByThreeChooser));
		assertArrayEquals(int_result7, int_s.transformAll(AddTwoTransformer));
		assertArrayEquals(int_result8, int_t.transformAll(AddTwoTransformer));
		assertArrayEquals(int_result9, int_u.transformAll(AddTwoTransformer));
		assertArrayEquals(string_result, string_s.chooseAll(StringBChooser));
		assertArrayEquals(string_result2, string_t.chooseAll(StringBChooser));
		assertArrayEquals(string_result3, string_u.chooseAll(StringBChooser));
	}

}