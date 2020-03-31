package problem2;

public class Application {

	public static void main(String[] args){
		
		DuplicateCounter file = new DuplicateCounter();
		file.count("problem2.txt");
		file.write("unique_word_counts.txt");
	}
}
 	