package DataObjects;

import DataModels.Call;
import DataModels.Phone;

import java.util.List;

public abstract class Samsung extends Phone {

    Samsung () {}

    Samsung (float nominalBatteryLife) {
        super (nominalBatteryLife);
    }

    Samsung (float nominalBatteryLife, String phoneNumber) {
        super (nominalBatteryLife, phoneNumber);
    }

}
