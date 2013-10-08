/**
 * Created with IntelliJ IDEA.
 * User: sandeep
 * Date: 11/08/13
 * Time: 1:45 PM
 * To change this template use File | Settings | File Templates.
 */

public enum SubscriptionStatus {

    ACTIVE("active"),
    EXPIRED("expired"),
    UNDEFINED("undefined");

    public static final String X_SUBSCRIPTION_STATUS = "x-subscriptionstatus";

    public static final String SUBSCRIPTION_STATUS_ACTIVE = "active";
    public static final String SUBSCRIPTION_STATUS_EXPIRED = "expired";
    public static final String SUBSCRIPTION_STATUS_UNDEFINED = "undefined";

    private String _name;

    SubscriptionStatus(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public static SubscriptionStatus getSubscriptionStatus(String name) {
        if (name.toLowerCase().equals(SUBSCRIPTION_STATUS_ACTIVE)) {
            return ACTIVE;
        } else if (name.toLowerCase().equals(SUBSCRIPTION_STATUS_EXPIRED)) {
            return EXPIRED;
        }
        return UNDEFINED;
    }

}
