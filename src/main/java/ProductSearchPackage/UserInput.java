package ProductSearchPackage;

import java.util.Scanner;


public class UserInput implements Common {
	
	String color;
	String size;
	String gender;
	int preference;
	
	
	public void takeInput() throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(INPUT_DESCRIPTION);
		
		// Taking t-shirt colour as user input
		System.out.print(COLOR + " :\t");
		this.color = sc.nextLine().trim().toLowerCase();
		
		// Taking t-shirt size as user input
		System.out.print(SIZE + " " + SIZE_OPTION);
		this.size = sc.next().trim().toLowerCase();
		if(!this.size.equals("s") && !this.size.equals("m") && !this.size.equals("xl") && !this.size.equals("l")) {
			throw new Exception();
		}
		
		// Taking gender as user input
		System.out.print(GENDER + " " + GENDER_OPTION);
		this.gender = sc.next().toLowerCase().trim();
		if(!this.gender.equals("m") && !this.gender.equals("f")) {
			throw new Exception();
		}
		
		// Taking output preference as user input
		System.out.println(OUTPUT_DESCRIPTION);
		System.out.println(OUTPUT_PREFERENCE_CHOICES);
		System.out.print(ASK_FOR_OUTPUT_PREFERENCE);
		this.preference = sc.nextInt();			
		if(this.preference < 0 || this.preference > 2) {
			throw new Exception();
		}
		
	}
	
}
