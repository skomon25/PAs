
class UpperCaseTransformer implements MyTransformer<String> {

	public String transformElement(String s) {
		return s.toUpperCase();
	}

}

// Add your transformers here
class ReverseSignTransformer implements MyTransformer<Integer>{
	

	@Override
	public Integer transformElement(Integer e) {
		return e * -1;
	}
}

class AddTwoTransformer implements MyTransformer<Integer>{

	@Override
	public Integer transformElement(Integer e) {
		// TODO Auto-generated method stub
		return e + 2;
	}
}