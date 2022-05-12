package logicandlanguague;

import java.io.File;

public class Main {

	public static void main(String[] args) {
	
		//specify which file to parse
		HTMLparse test = new HTMLparse(new File("index.html"));
		
		//the parameter input into .parse is an arraylist<string> (getLines returns one that represents the file given)
		test.parse(test.getLines());
	}

}
