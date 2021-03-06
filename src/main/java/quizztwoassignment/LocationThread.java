/*
For each group of packages which are delivered to the same location on a given date, the system must calculate:

- the group value considering the package value
- the group revenue considering a fixed price of 1 LEU / 1 km

Each group of packages must be delivered by a separate thread that will print to the console a line like in the following example:
--------------------------------------------------
[Delivering for <Apahida> and date <2017-09-02> in <15> seconds]
 */
package quizztwoassignment;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class LocationThread extends Thread {

    public static int threadNum;

    private String thisLocation;
    private List<Package> delivsToThisLocation;

    private int totalVal = 0;
    private int totalRevenue = 0;


    public LocationThread(List<Package> delivs) {

        synchronized (this) {
            ++threadNum;
        }

        this.delivsToThisLocation = delivs;
        this.thisLocation = delivsToThisLocation.get(0).getLocation();
    }

    @Override
    public void run() {
        totalVal = delivsToThisLocation.stream().collect(Collectors.summingInt(Package::getValue));
        totalRevenue = delivsToThisLocation.stream().collect(Collectors.summingInt(Package::getDistance));

        printThread(delivsToThisLocation, totalVal, totalRevenue, thisLocation);

    }

    synchronized public static void printThread(List<Package> delivs, int totalVal, int totalRevenue, String thisLocation) {
        System.out.print(thisLocation + ": total value: " + totalVal + ",");
        System.out.println(" total revenue: " + totalRevenue + " Lei");

        delivs.stream().forEach(t -> System.out.println("[Delivering for <" + t.getLocation()
                + "> and date <" + t.getDate() + "> in <" + t.getDistance() + "> seconds]"));
    }
}