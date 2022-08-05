package ProductSearchPackage;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.Session;
import org.hibernate.Transaction;

class SearchFilesInFolder implements Runnable {
	
	private CountDownLatch done_signal;
	private File folder;
	List<String> filenames;
	
	// Constructor
	public SearchFilesInFolder(CountDownLatch done_signal, File folder, List<String> filenames) {
		this.done_signal = done_signal;
		this.folder = folder;
		this.filenames = filenames;
	}
	
	@Override
	public void run() {
		
		for (final File fileEntry : folder.listFiles()) {
        	if(fileEntry.getName().contains(".csv")) {
        		AddDataToDatabase.filenames.add(fileEntry.getName());
        	}
        		
	    }
		
		this.done_signal.countDown();          // sending signal that SearchFilesInFolder is over
	}
	
}


public class AddDataToDatabase implements Common {
	
	private static final String folder_location = "C:\Users\nishthaarora";
	protected static List<String> filenames = new LinkedList<String>();
	
	
	
	// Method to update the database
	public static void add(Session session) {
		
		// Creating a folder object for the location of folder where we have to search the csv files 
		File folder = new File(AddDataToDatabase.folder_location);
		
		// Creating a signal object to check whether threading task is finished or not
		CountDownLatch done_signal = new CountDownLatch(1);
		
		// Creating a new thread
		Thread thread = new Thread(new SearchFilesInFolder(done_signal, folder, AddDataToDatabase.filenames));
		thread.start();
		
		try {
			// SearchTShirts will wait until SearchFilesInFolder finished
			done_signal.await();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Taking new file from the list
		for(String file: AddDataToDatabase.filenames) {
			
			try (Reader reader = Files.newBufferedReader(Paths.get(AddDataToDatabase.folder_location + "\\" + file))) {
				
				
			    // read csv file
			    Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
			    
			    for (CSVRecord record : records) {
			    	
			    	
			    	if(!record.get(0).equals("ID")) {
			    		
			    		// Creating new object of Tshirt for the new record
			    		Tshirt t_shirt = new Tshirt();
			    		
			    		// Setting the details of t-shirt
				    	t_shirt.setId(record.get(0));
				    	t_shirt.setName(record.get(1));
				    	t_shirt.setColor(record.get(2));
				    	t_shirt.setGender(record.get(3).trim().toCharArray()[0]);
				    	t_shirt.setSize(record.get(4));
				    	t_shirt.setPrice(Double.valueOf(record.get(5).trim()));
				    	t_shirt.setRating(Float.valueOf(record.get(6)));
				    	t_shirt.setAvailability(record.get(7).trim().toCharArray()[0]);
				    	
				    	// Get the details of t_shirt from the database if it is already exits
				    	Tshirt tshirt = (Tshirt)session.get(Tshirt.class, t_shirt.getId());
				    	
				    	// Checking whether the t_shirt is already exist in the database or not?
				    	if(tshirt == null) {
				    		Transaction tx = session.beginTransaction();
					    	session.save(t_shirt);
					    	tx.commit();
					    	
				    	}
				    	
			    	}   // Closing of outer if body
			    	
			    }  // Closing of inner for loop
			    
			}  // Closing of try block
			catch (IOException ex) {
				System.out.println(FILE_NOT_FOUND);
			}
			
		} 	// Closing of outer for loop
		
		
	}
	
}
