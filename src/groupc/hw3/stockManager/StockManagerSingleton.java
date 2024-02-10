package groupc.hw3.stockManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import groupc.hw3.media.CDRecordProduct;
import groupc.hw3.media.MediaProduct;
import groupc.hw3.media.TapeRecordProduct;
import groupc.hw3.media.VinylRecordProduct;

public class StockManagerSingleton {
	//Creates a static object for StockManagerSingleton so that there can only be 1 instance of the manager
	private static StockManagerSingleton instance = null;
	
	//Initializes the InventoryFilePath to the inventory.csv file provided from the assignment
	//private so that it's path can't be accessed outside the method. Declared final so that the path can't change
	private final String inventoryFilePath = "./src/groupc/hw3/files/inventory.csv";
	private ArrayList<MediaProduct> inventory = new ArrayList<MediaProduct>();
	
	/*
	 * method: initializeStock
	 * This method initializes the StockManager by 
	 * reading in the inventory data from the file found in inventoryFilePath
	 * and adding them to the inventory
	 * 
	 * @return true if initialization is successful, or false if it does not initialize because of some error
	 * 
	 */
	public boolean initializeStock()
	{
		Scanner fileScanner = null ; // initializes fileScanner to null
		
		try
		{
			
			// Attempt to open the file
			fileScanner = new Scanner(new FileInputStream(inventoryFilePath));
			
			// If file is empty, return false
			if(!fileScanner.hasNextLine()) {
				return false;
			}
			
			// Skip over variable / column names
			fileScanner.nextLine();
			
			// While there is a mediaProduct to read in...
			while(fileScanner.hasNextLine()) {
				String[] splitted = fileScanner.nextLine().split(",");
				for (String item : splitted) {
					System.out.print(item + " ");
				}
				System.out.println("\n");
			}
			
			
			// Return true to indicate file was successfully found and read
			return true;
		}
		catch (FileNotFoundException e)
		{
			// If the file could not be found or reading/initialization failed, we return false
			return false;
		}
		
	}
	
	
	/*
	 * method: updateItemPrice
	 * This method updates a media product price to an updated price.
	 * @param product product to update
	 * @param newPrice new price for the product to update
	 * @return true if an update succeeds and false if it does not succeed 
	 */
	public boolean updateItemPrice(MediaProduct product, double newPrice) {
		return false;
	}
	
	/*
	 * method: addItem
	 * This method adds a new media object to the manager inventory
	 * @param product The new MediaProduct to add to the manager
	 * @return true if the item was added and false if it was not added.
	 */
	public boolean addItem(MediaProduct product) {
		return false;
	}
	
	/*
	 * method: removeItem
	 * This method removes a media product from the inventory
	 * @param product The product to remove from the catalogue
	 * @return true if the item was removed or false if it was not removed
	 */
	public boolean removeItem(MediaProduct product) {
		return false;
	}
	
	/*
	 * method: saveStock
	 * This method updates the inventory in the "inventoryFilePath" csv file and saves it by overwriting the existing file
	 * @return true if the save was successful or false if it was not successful
	 */
	public boolean saveStock() {
		return false;
	}
	
	/*
	 * Method: getMediaProductBelowPrice
	 * This method creates a list of all of the products below a specified price
	 * @param maxPrice The maximum price of mediaProducts that the user wants to view
	 * @return ArrayList representing all of the media products that are below the price passed into the method
	 */
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice){
		return null;
	}
	
	/*
	 * method: printListOfMediaProduct
	 * This method prints all of the products in the media product list
	 * @param productList The list of products that the user wants to print
	 * 
	 */
	public void printListOfMediaProduct(ArrayList<MediaProduct> productList) {
		return;
	}
	
	/*
	 * method: getVinylRecordList
	 * This method gets all of the media products that are VINYLS 
	 * @param productList the list of products passed by the user
	 * @return A list representing all of the media products that are VINYLS
	 */
	public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList){
		return null;
	}
	
	/*
	 * method: getCDRecordsList
	 * This method gets all of the media products that are CDS
	 * @param productList the list of products passed by the user
	 * @return A list representing all of the media products that are CDS
	 */
	public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList){
		return null;
	}
	
	/*
	 * method: getTapeRecordList
	 * This method gets all of the media products that are TAPES
	 * @param productList the list of products passed by the user
	 * @return A list representing all of the media products that are TAPES
	 */
	public ArrayList<TapeRecordProduct> getTapeREcordList(ArrayList<MediaProduct> productList){
		return null;
	}

}
