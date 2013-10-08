/**
 * Created with IntelliJ IDEA.
 * User: sandeep
 * Date: 07/08/13
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */

public interface Callback<T, U> {
    public void onSuccess(T result);

    public void onFailure(U error);
}
