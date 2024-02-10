package groupc.hw3.media;
/*
 * Subclass of MediaProduct that represents a tape product
 */
public class TapeRecordProduct extends MediaProduct{
	//base constructor
	public TapeRecordProduct() {
		// TODO 
	}
	
	//parameterized constructor
	public TapeRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
		
	}
	
	//Copy Constructor
	public TapeRecordProduct(TapeRecordProduct media) {
		super(media);
		
	}
	
	
}
