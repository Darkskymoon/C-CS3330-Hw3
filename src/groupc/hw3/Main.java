package groupc.hw3;

import groupc.hw3.stockManager.StockManagerSingleton;

import java.util.ArrayList;

import groupc.hw3.media.CDRecordProduct;
import groupc.hw3.media.Genre;
import groupc.hw3.media.MediaProduct;
import groupc.hw3.media.TapeRecordProduct;
import groupc.hw3.media.VinylRecordProduct;


public class Main {

	public static void main(String[] args) {
		// Creating stockManagerSingleton
		StockManagerSingleton manager = StockManagerSingleton.getInstance();
		StockManagerSingleton managerNew = StockManagerSingleton.getInstance();
		
		// Check that singleton design pattern works
		System.out.println("Testing whether Singleton design pattern works...");
		System.out.println("\tAre manager and managerNew the same: " + manager.equals(managerNew));
		System.out.println("----------------------------------------------------------------------------------------------");
		
		// initializeStock of manager
		System.out.println("\ninitializeStock method's return when...");
		System.out.println("\tGiven normal conditions (correct file path): " + manager.initializeStock());
		System.out.println("----------------------------------------------------------------------------------------------");
		
		// Create vinyl
		VinylRecordProduct vinyl1 = new VinylRecordProduct("Ride The Lightning", 29.99, 1984, Genre.ROCK);
		
		
		//Test addItem method
		System.out.println("\naddItem method's return when...");
		System.out.println("\tAdding valid product: " + manager.addItem(vinyl1));
		System.out.println("\tAdding invalid product: " + manager.addItem(null));
		System.out.println("----------------------------------------------------------------------------------------------");
		
		//Test updateItemPrice method
		System.out.println("\nupdateItemPrice method's return when...");
		System.out.println("\tUpdating valid product: " + manager.updateItemPrice(vinyl1, 34.99));
		System.out.println("\tUpdating invalid product: " + manager.updateItemPrice(null, 49.99));
		System.out.println("----------------------------------------------------------------------------------------------");
		
		//Creates a second Vinyl and adds it to the manager
		System.out.println("\nAdding a second vinyl returns...");
		VinylRecordProduct vinyl2 = new VinylRecordProduct("The Moss", 29.99, 2015, Genre.ELECTRONIC);
		System.out.println("\t" + manager.addItem(vinyl2));
		System.out.println("----------------------------------------------------------------------------------------------");
		
		//Creates a tape
		System.out.println("\nAdding a tape returns...");
		TapeRecordProduct tape1= new TapeRecordProduct("The Mind Electric", 400.0, 2012, Genre.ELECTRONIC);
		System.out.println("\t" + manager.addItem(tape1));
		System.out.println("----------------------------------------------------------------------------------------------");
		
		//creates a CD
		System.out.println("\nAdding a new CD returns...");
		CDRecordProduct CD1= new CDRecordProduct("Copacabana (At the Copa)", 32.99, 1985, Genre.POP);
		System.out.println("\t"+manager.addItem(CD1));
		
		
		//Creates an arrayList of the above created media types:
		ArrayList<MediaProduct> testList = new ArrayList<MediaProduct>();
		testList.add(tape1);
		testList.add(CD1);
		testList.add(vinyl2);
		testList.add(vinyl1);
		
		//tests printListOfMediaProduct output
		System.out.println("\n --------------------------Printing a list of the media products--------------------------\n");
		manager.printListOfMediaProduct();
		System.out.println("-----------------------------------------------------------------------------------------\n");
		
		//tests GetCDRecordsList output
		System.out.println("\n------------------------------Printing the list of CDs when...-----------------------------------\n");
		System.out.println("No valid list is passed in: "+ manager.getCDRecordsList(null));
		System.out.println("Valid List is passed in: "+ manager.getCDRecordsList(testList));
		
		//tests getTapeRecordList output
		System.out.println("\n------------------------------Printing the list of Tapes when...-----------------------------------\n");
		System.out.println("No valid list is passed in: "+manager.getTapeRecordList(null));
		System.out.println("valid list is passed in: "+manager.getTapeRecordList(testList));
		
		//test getVinylRecordsList output
		System.out.println("\n------------------------------Printing the list of Vinyls when...-----------------------------------\n");
		System.out.println("No valid list is passed in: "+ manager.getVinylRecordList(null));
		System.out.println("valid list is passed in: "+ manager.getVinylRecordList(testList));
		
		System.out.println("----------------------------------------------------------------------------------------------");
		
		//Tests the removal of vinyl2
		System.out.println("\nremoveItem method's return when...");
		System.out.println("\tremoving item correctly (does exist): "+manager.removeItem(vinyl2));
		System.out.println("\tremoving item incorrectly (doesn't exist): "+ manager.removeItem(vinyl2));
		System.out.println("----------------------------------------------------------------------------------------------");
		//Tests that saveStock worked correctly
		System.out.println("\nTesting saveStock function...");
		System.out.println("Saving stock worked: "+manager.saveStock());
		

		// Testing the print list of products with price <= x, where x is the price
		System.out.println("\n-------------------------Printing a list of products with price <=13------------------------");
		manager.printListOfMediaProduct(manager.getMediaProductBelowPrice(13));
		
		System.out.println("\n-------------------------Printing a list of products with price <=0------------------------");
		manager.printListOfMediaProduct(manager.getMediaProductBelowPrice(0));
		
		System.out.println("\n-------------------------Printing a list of products with price <=1000------------------------");
		manager.printListOfMediaProduct(manager.getMediaProductBelowPrice(1000));
	}

}
