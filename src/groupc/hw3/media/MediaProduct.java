package groupc.hw3.media;

import java.util.Objects;

/*
 * Class: MediaProduct
 * This is the parent class of all of the different media products
 * Variables:
 * title: the name of the media
 * price: the cost of the media
 * year: the release date of the media
 * genre: what genre of media a particular piece of media is 
 */
public class MediaProduct {
	//Variables///////////////////
	protected String title;
	protected double price;
	protected int year;
	protected Genre genre;
	//////////////////////////////
	
	//Constructors////////////////
	//Base Constructor
	public MediaProduct() {
		//TODO
	}
	
	
	//parameterized constructor
	public MediaProduct(String title, double price, int year, Genre genre) {
		this.title=title;
		this.price=price;
		this.year=year;
		this.genre=genre;
	}
	
	//copy constructor
	public MediaProduct(MediaProduct media) {
		this.title= media.getTitle();
		this.price= media.getPrice();
		this.year= media.getYear();
		this.genre = media.getGenre();
		
	}
	///////////////////////////////


	
	//Getters and Setters/////////
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public Genre getGenre() {
		return genre;
	}


	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	/////////////////////////////
	
	
	
	//equals function to test if two pieces of media are the same
	public boolean equals(Object media) {
		//casts the media Object as a MediaProduct
		MediaProduct product = (MediaProduct)media;
		//Compares the two objects and if title, genre, price, and year are the same, then the objects are the same
		if(this.title == product.getTitle() 
				&& this.genre == product.getGenre()
				&& this.price == product.getPrice() 
				&& this.year == product.getYear()) {
			return true;
		}
		return false;
	}
	
	
	


}
