/**
 * Created with IntelliJ IDEA.
 * User: sandeep
 * Date: 11/08/13
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */

public enum DeviceConnectionStatus {

    CONNECTED("connected"),
    TEMPDISCONNECTED("tempdisconnected"),
    DISCONNECTED("disconnected"),
    INACTIVE("inactive"),
    UNDEFINED("undefined");


    public static final String X_DEVICE_CONNECTION_STATUS = "x-deviceconnectionstatus";

    public static final String DEVICE_CONNECTION_STATUS_CONNECTED = "connected";
    public static final String DEVICE_CONNECTION_STATUS_TEMPDISCONNECTED = "tempdisconnected";
    public static final String DEVICE_CONNECTION_STATUS_INACTIVE = "inactive";
    public static final String DEVICE_CONNECTION_STATUS_DISCONNECTED = "disconnected";
    public static final String DEVICE_CONNECTION_STATUS_UNDEFINED = "undefined";

    private String _name;

    DeviceConnectionStatus(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public static DeviceConnectionStatus getDeviceConnectionStatus(String name) {
        if (name.toLowerCase().equals(DEVICE_CONNECTION_STATUS_CONNECTED)) {
            return CONNECTED;
        } else if (name.toLowerCase().equals(DEVICE_CONNECTION_STATUS_DISCONNECTED)) {
            return DISCONNECTED;
        } else if (name.toLowerCase().equals(DEVICE_CONNECTION_STATUS_TEMPDISCONNECTED)) {
            return TEMPDISCONNECTED;
        } else if (name.toLowerCase().equals(DEVICE_CONNECTION_STATUS_INACTIVE)) {
            return INACTIVE;
        }
        return UNDEFINED;
    }

}
