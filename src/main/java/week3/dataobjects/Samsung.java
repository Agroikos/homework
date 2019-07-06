package week3.dataobjects;

import week3.datamodels.Phone;

public abstract class Samsung extends Phone {

    Samsung () {}

    Samsung (float nominalBatteryLife) {
        super (nominalBatteryLife);
    }

    Samsung (float nominalBatteryLife, String phoneNumber) {
        super (nominalBatteryLife, phoneNumber);
    }

}
