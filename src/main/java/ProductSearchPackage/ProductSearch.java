package ProductSearchPackage;

import java.util.Scanner;

public class ProductSearch implements Common {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String decision = "y";
		
		do {
			
			try {
				
				// Calling for user inputs
				UserInput inputs = new UserInput();
				inputs.takeInput();
				
				// Calling for searching the available t-shirts on the basis of user inputs
				SearchTShirts search_obj = new SearchTShirts();
				search_obj.search(inputs);
				
				// Calling for displaying the available t-shirts
				Output output_obj = new Output();
				output_obj.showTShirts(search_obj);
				
			}
			catch(Exception e) {
				
				System.out.println(INVALID_INPUT);
				
			}
			finally {
				
				// Asking for new search
				System.out.print(ASK_FOR_NEW_OPERATION);
				decision = sc.next();
				
			}
			
			
		}while(decision.equals("y") || decision.equals("Y"));
		
		sc.close();
	}

}
