package DataObjects;

public class SamsungGalaxyA80 extends Samsung {
    private String thisIMEI;

    public SamsungGalaxyA80 () {
        thisIMEI = String.valueOf(++lastIMEI);
    }

    public SamsungGalaxyA80 (float nominalBatteryLife) {
        super(nominalBatteryLife);
        thisIMEI = String.valueOf(++lastIMEI);
    }

    public SamsungGalaxyA80 (float nominalBatteryLife, String phoneNumber) {
        super(nominalBatteryLife, phoneNumber);
        thisIMEI = String.valueOf(++lastIMEI);
    }
}
