package ProductSearchPackage;


public class Output implements Common {
	
	public void showTShirts(SearchTShirts search_obj) {
		
		if(search_obj.available_tshirts.size() == 0) {
			System.out.println(NOT_AVAILABLE);
		}
		else {
			System.out.println("\n" + OUTPUT_DETAILS);
			int i = 1;
			for(Tshirt t_shirt : search_obj.available_tshirts) {
				System.out.println();
				System.out.println(i + ")" + " T-shirt");
				System.out.println(ID + " : " + t_shirt.getId());
				System.out.println(NAME + " : " + t_shirt.getName());
				System.out.println(COLOR + " : " + t_shirt.getColour());
				System.out.println(GENDER + " : " + t_shirt.getGender());
				System.out.println(SIZE + " : " + t_shirt.getSize());
				System.out.println(PRICE + " : " + t_shirt.getPrice());
				System.out.println(RATING + " : " + t_shirt.getRating());
				System.out.println(AVAILABILITY + " : " + t_shirt.getAvailability());
				i++;
			}
			System.out.println();
		}
		
	}
	
	
}
