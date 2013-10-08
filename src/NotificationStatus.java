/**
 * Created with IntelliJ IDEA.
 * User: sandeep
 * Date: 11/08/13
 * Time: 1:25 PM
 * To change this template use File | Settings | File Templates.
 */

public enum NotificationStatus {

    RECEIVED("received"),
    QUEUEFULL("queuefull"),
    SUPPRESSED("suppressed"),
    DROPPED("dropped"),
    UNDEFINED("undefined");

    public static final String X_NOTIFICATION_STATUS = "x-notificationstatus";

    public static final String NOTIFICATION_STATUS_RECEIVED = "received";
    public static final String NOTIFICATION_STATUS_QUEUEFULL = "queuefull";
    public static final String NOTIFICATION_STATUS_SUPPRESSED = "suppressed";
    public static final String NOTIFICATION_STATUS_DROPPED = "dropped";

    private String _name;

    NotificationStatus(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public static NotificationStatus getNotificationStatus(String name) {
        if (name.toLowerCase().equals(NOTIFICATION_STATUS_RECEIVED)) {
            return RECEIVED;
        } else if (name.toLowerCase().equals(NOTIFICATION_STATUS_QUEUEFULL)) {
            return QUEUEFULL;
        } else if (name.toLowerCase().equals(NOTIFICATION_STATUS_SUPPRESSED)) {
            return SUPPRESSED;
        } else if (name.toLowerCase().equals(NOTIFICATION_STATUS_DROPPED)) {
            return DROPPED;
        }
        return UNDEFINED;
    }
}
