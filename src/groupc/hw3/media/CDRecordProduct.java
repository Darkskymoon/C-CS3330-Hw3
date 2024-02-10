package groupc.hw3.media;

/*
 * Subclass of the MediaProduct Class.
 */
public class CDRecordProduct extends MediaProduct{
	//Base constructor
	public CDRecordProduct() {
		// TODO 
	}
	
	//Parameterized Constructor
	public CDRecordProduct(String title, double price, int year, Genre genre) {
		//Initializes the CD using the superclass constructor
		super(title, price, year, genre);
	}

	//Copy Constructor
	public CDRecordProduct(CDRecordProduct media) {
		super(media);
	}
	
	

}
