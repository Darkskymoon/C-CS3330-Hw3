package groupc.hw3;

import groupc.hw3.stockManager.StockManagerSingleton;
import groupc.hw3.media.CDRecordProduct;
import groupc.hw3.media.Genre;
import groupc.hw3.media.TapeRecordProduct;
import groupc.hw3.media.VinylRecordProduct;


public class Main {

	public static void main(String[] args) {
		// Creating stockManagerSingleton
		StockManagerSingleton manager = StockManagerSingleton.getInstance();
		StockManagerSingleton managerNew = StockManagerSingleton.getInstance();
		
		// Check that singleton design pattern works
		System.out.println("Are manager and managerNew the same: " + manager.equals(managerNew));
		
		// initializeStock of manager
		manager.initializeStock();
		
		// Create vinyl and add it to the manager
		VinylRecordProduct vinyl1 = new VinylRecordProduct("Ride The Lightning", 29.99, 1984, Genre.ROCK);
		manager.addItem(vinyl1);
		manager.updateItemPrice(vinyl1, 34.99);
		
		//Creates a second Vinyl and adds it to the manager
		VinylRecordProduct vinyl2 = new VinylRecordProduct("The Moss", 29.99, 2015, Genre.ELECTRONIC);
		manager.addItem(vinyl2);
		
		//Tests the removal of vinyl2
		System.out.println(manager.removeItem(vinyl2));
		System.out.println(manager.removeItem(vinyl2));

	}

}
