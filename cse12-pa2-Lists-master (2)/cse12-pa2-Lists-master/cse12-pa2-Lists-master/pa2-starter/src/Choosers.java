
class LongWordChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		return s.length() > 5;
	}

} 

// Add your choosers here
class StringBChooser implements MyChooser<String>{

	@Override
	public boolean chooseElement(String e) {
		for(int i = 0 ; i < e.length() ; i++){
			if(e.substring(i, i+1).equals("b")){
				return true;
			}
			return false;
		}
	}
}

class DivisibleByThreeChooser implements MyChooser<Integer>{

	@Override
	public boolean chooseElement(Integer e) {
		if(e % 3 == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
}