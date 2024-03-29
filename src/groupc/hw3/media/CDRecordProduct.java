package groupc.hw3.media;

/*
 * Subclass of the MediaProduct Class.
 */
public class CDRecordProduct extends MediaProduct{
	//Parameterized Constructor
	public CDRecordProduct(String title, double price, int year, Genre genre) {
		//Initializes the CD using the superclass constructor
		super(title, price, year, genre);
	}

	//Copy Constructor
	public CDRecordProduct(CDRecordProduct media) {
		super(media);
	}

	//To string method to represent a cd in the following format: "CD,title,price,year,genre"
	@Override
	public String toString() {
		return "CD,"+title+","+price +"," + year +"," + genre;
	}
	
}
