package week3.dataobjects;

public class IphoneFive extends Iphone {
    private String thisIMEI;

    public IphoneFive () {
        thisIMEI = String.valueOf(++lastIMEI);
    }

    public IphoneFive (float nominalBatteryLife) {
        super(nominalBatteryLife);
        thisIMEI = String.valueOf(++lastIMEI);
    }

    public IphoneFive (float nominalBatteryLife, String phoneNumber) {
        super(nominalBatteryLife, phoneNumber);
        thisIMEI = String.valueOf(++lastIMEI);
    }
}
