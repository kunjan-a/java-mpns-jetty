
/**
 * Created with IntelliJ IDEA.
 * User: sandeep
 * Date: 12/08/13
 * Time: 1:03 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class CancellableCallback implements Callback {

    private boolean cancel;

    public CancellableCallback() {
        this.cancel = false;
    }

    public void cancel() {
        this.cancel = true;
    }

    public boolean isCancelled() {
        return this.cancel;
    }
}
