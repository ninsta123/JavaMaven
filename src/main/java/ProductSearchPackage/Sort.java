package ProductSearchPackage;

import java.util.Collections;


public class Sort {

	public void arrangeByPreference(SearchTShirts search_obj, int preference) {
		
		if(preference == 0) {
			Collections.sort(search_obj.available_tshirts, new PriceComparator());
		}
		else if(preference == 1) {
			Collections.sort(search_obj.available_tshirts, new RatingComparator());
		}
		else {
			Collections.sort(search_obj.available_tshirts, new PriceAndRatingComparator());
		}
	}
	
}
