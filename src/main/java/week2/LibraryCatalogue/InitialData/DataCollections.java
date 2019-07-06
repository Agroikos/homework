package week2.LibraryCatalogue.InitialData;

import week2.LibraryCatalogue.Entity.Album;
import week2.LibraryCatalogue.Entity.Novel;

import java.util.ArrayList;
import java.util.Arrays;

import static week2.LibraryCatalogue.Entity.Album.PaperQuality.*;
import static week2.LibraryCatalogue.Entity.Album.PaperQuality.Coarse;
import static week2.LibraryCatalogue.Entity.Novel.Type.Romance;
import static week2.LibraryCatalogue.Entity.Novel.Type.SciFi;

public class DataCollections {
    //testing values

    public static ArrayList<Novel> myNovelSubCollection = new ArrayList<Novel>(Arrays.asList(
            new Novel("Anna Karenina",800, Romance),
            new Novel("David Copperfield",450, Romance),
            new Novel("Solaris",300, SciFi)));

    public static ArrayList<Album> myAlbumSubCollection = new ArrayList<Album>(Arrays.asList(
            new Album("Salvador Dali",700, Glossy),
            new Album("Otto Dix",330, BlackAndWhite),
            new Album("Renoir",300, Color),
            new Album("Ancient Greek Art",500, Coarse)
    ));

}
