package week3.DataObjects;


public class SamsungGalaxyS6 extends Samsung {

    private String thisIMEI;

    public SamsungGalaxyS6() {
        thisIMEI = String.valueOf(++lastIMEI);
    }

    public SamsungGalaxyS6(float nominalBatteryLife) {
        super(nominalBatteryLife);
        thisIMEI = String.valueOf(++lastIMEI);
    }

    public SamsungGalaxyS6(float nominalBatteryLife, String phoneNumber) {
        super(nominalBatteryLife, phoneNumber);
        thisIMEI = String.valueOf(++lastIMEI);
    }
}
