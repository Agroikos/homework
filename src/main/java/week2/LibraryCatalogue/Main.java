package week2.LibraryCatalogue;

import week2.LibraryCatalogue.Entity.Album;
import week2.LibraryCatalogue.Entity.Novel;
import week2.LibraryCatalogue.InitialData.DataCollections;

public class Main {
    public static void main(String[] args) {

        //test data
        DataCollections dataCollections = new DataCollections();

        ListOfItems myCollection = new ListOfItems();


        /*
        //DataCollections mySubCollection = new DataCollections();
        System.out.println("Novels");
        DataCollections.myNovelSubCollection.stream().forEach(t-> System.out.println(t.toString()));
        System.out.println("Albums");
        DataCollections.myAlbumSubCollection.stream().forEach(t-> System.out.println(t.toString()));*/

        Novel[] myNovels = new Novel[10];
        dataCollections.myNovelSubCollection.toArray(myNovels);
        int novelListLength= dataCollections.myNovelSubCollection.size();


        //TODO: why is this cast not working?
        //myCollection.addSeveralItems((Novel[]) dataCollections.myNovelSubCollection.toArray(),novelListLength);
        myCollection.addSeveralItems(myNovels,novelListLength);

        System.out.println("My collection after adding the novels: ");
        myCollection.printCollection();

        Album[] myAlbums = new Album[10];
        int albumListLength = dataCollections.myAlbumSubCollection.size();
        //add the albums too
        dataCollections.myAlbumSubCollection.toArray(myAlbums);

        myCollection.addSeveralItems(myAlbums,albumListLength);

        System.out.println("Printing collection after adding the albums as well: ");
        myCollection.printCollection();

        //delete an item
        System.out.println("delete an album and then a novel");

        myCollection.deleteItem(myAlbums[2]);
        myCollection.deleteItem(myNovels[1]);

        myCollection.printCollection();
    }
}
