# C-CS3330-Hw3

_**Authors**_
--------------
- Darkskymoon: Zoe
- Derbzzzzzz: Ryan
- Andopepe: Ando
- LinYu-Ch: John

_**Description**_
------------------
This project implements a way of managing media products through an Inventory management system. It utilizes a singleton class for the manager, as to avoid making duplicates of the manager. 

It allows for the creation of vinyl, cd, and tape media items to be added to an inventory. The prices of those items can also be updated. Additionally, each item can be removed. The items can be retrieved via a method "getMediaProductBelowPrice(int maxPrice)", which allows the user to get items under a specified integer price. The items can also be retrieved in a list format for specific media types through the methods: getVinylRecordList, getCDRecordsList, and getTapeRecordList. Once the user has decided that they have added enough items and would like to save their media inventory, they can call the saveStock() method, which writes their current working inventory to a CSV file for later.

The project demonstrates, as stated above, the singleton design pattern for the manager. It also shows the concept of inheritance since each of the media types inherits from a superclass called "MediaProduct". 

_**Running the Code:**_
-----------------------
There are no dependencies needed to run the code. 
To run the code simply type: 
1. git clone https://github.com/Darkskymoon/C-CS3330-Hw3.git
2. ensure that eclipse has found the src folder (which should be done by default)
3. Hit the run button on eclipse. There should be output from main to demonstrate the code functions.
