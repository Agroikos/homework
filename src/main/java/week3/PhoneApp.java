package week3;

import week3.datamodels.MessageOverMaximumAdmissibleLengthException;
import week3.datamodels.OutOfBatteryException;
import week3.datamodels.Phone;
import week3.dataobjects.IphoneFive;
import week3.dataobjects.IphoneX;
import week3.dataobjects.SamsungGalaxyA80;
import week3.dataobjects.SamsungGalaxyS6;

public class PhoneApp {
    public static void main(String[] args) {

        Phone mySamsungGalaxyS6 = new SamsungGalaxyS6(72, "555 883 7858");
        Phone mySamsungGalaxyA80 = new SamsungGalaxyA80(96, "885 598 3480");
        Phone myIphoneX = new IphoneX(120, "555 885 3949");
        Phone myIphoneFive = new IphoneFive(120, "789 987 5479");

        mySamsungGalaxyS6.addContact(1, "072 123 345", "John", "Doe");
        mySamsungGalaxyS6.addContact(2, "072 321 654", "Jane", "Doe");
        mySamsungGalaxyS6.addContact(3, "072 678 543", "Michael", "Smith");
        mySamsungGalaxyS6.addContact(4, "072 890 000", "Andrew", "Bird");

        mySamsungGalaxyS6.listContacts();
        System.out.println(mySamsungGalaxyS6.getNominalBatteryLife());
        System.out.println(mySamsungGalaxyS6.getPhoneNumber());

        mySamsungGalaxyA80.addContact(1, "072 555 345", "Mike", "Anderws");
        mySamsungGalaxyA80.addContact(2, "072 444 654", "Jane", "Bond");
        mySamsungGalaxyA80.addContact(3, "072 888 543", "Michael", "Leafly");
        mySamsungGalaxyA80.addContact(4, "072 999 000", "Joseph", "Nacdonald");

        myIphoneX.addContact(1, "072 555 222", "Snow", "White");
        myIphoneX.addContact(2, "072 111 555", "Bugs", "Bunny");
        myIphoneX.addContact(3, "072 234 543", "Michael", "Foucault");
        myIphoneX.addContact(4, "072 236 765", "Joseph", "Stanley");

        myIphoneX.listContacts();

        //System.out.println("iphone number" + myIphoneX.getPhoneNumber());

        System.out.println();
        //send message from mySamsungGalaxyS6 to myIphoneX
        System.out.println("Send a message");
        try {
            myIphoneX.sendMessage(mySamsungGalaxyA80.getPhoneNumber(), " this is my test text message");
        } catch (OutOfBatteryException e) {
            e.printStackTrace();
        } catch (MessageOverMaximumAdmissibleLengthException e) {
            e.printStackTrace();
        }

        //make a call
        System.out.println("Make a call");
        try {
            mySamsungGalaxyS6.call(myIphoneX.getPhoneNumber());
        } catch (OutOfBatteryException e) {
            e.printStackTrace();
        }
    }
}
