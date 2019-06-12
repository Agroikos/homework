package a_21_06.LibraryCatalogue;

import a_21_06.LibraryCatalogue.Entity.Book;

import java.util.Arrays;

public class ListOfItems {
    private Book[] titles;
    private int numberOfItems;


    //methods for adding and removing items from the list
    public void addItem (Book item) {
        titles[numberOfItems++] = item;
    }

    //add an array of items to the list
    public void addSeveralItems (Book[] items, int length) {
        for (int i=0; i<length;i++) {
            titles[numberOfItems++] = items[i];
        }
    }

    public boolean deleteItem (Book item) {
        for (int i = 0; i< numberOfItems; i++) {
            if (titles[i].equals(item)) {
                for (int j = i; j< numberOfItems -1; j++) titles[j] = titles[j+1];
                numberOfItems--;
                return true; //adica stergerea s-a facut
            }
        }
        return false; //adica nu s-a facut nici o stergere

    }

    //print what's in my collection

    public void printCollection () {
        for (int i=0; i<numberOfItems;i++) {
            System.out.println("Item " + i + ":" + titles[i].toString());
        }
    }

    //constructors

    public ListOfItems() {
        titles = new Book[20];
    }

    public ListOfItems(Book[] titles, int numberOfItems) {
        titles = new Book[20];
        this.titles = Arrays.copyOf(titles,numberOfItems);
        this.numberOfItems = numberOfItems;
    }

    public Book[] getTitles() {
        return titles;
    }

    public void setTitles(Book[] titles) {
        this.titles = titles;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }
    //no use having a set number of items since the number get increased automatically with every book added

}
