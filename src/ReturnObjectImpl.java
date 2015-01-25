
/**
 * Created by Basil on 30/11/2014.
 *
 * Implements ReturnObject.
 *
 */
public class ReturnObjectImpl implements ReturnObject {

    // class variables

    private ErrorMessage err;
    private Object data;

    // constructors

    /**
     * default constructor, empty structure
     */
    public ReturnObjectImpl() {
        this(null, ErrorMessage.EMPTY_STRUCTURE);
    }

    /**
     * data only constructor, no error
     * @param data contains data part of returnObject
     */
    public ReturnObjectImpl(Object data) {
        this(data, ErrorMessage.NO_ERROR);
    }

    /**
     * fully initialised constructor
     * @param data contains data part of returnObject
     * @param err contains error message for returnObject
     */
    public ReturnObjectImpl(Object data, ErrorMessage err) {
        this.data = data;
        this.err = err;
    }

    /**
     * Returns whether there has been an error
     * @return whether there has been an error
     */
    public boolean hasError() {
        return (this.err == ErrorMessage.NO_ERROR) ? false : true;
    }

    /**
     * Returns the error message.
     *
     * This method must return NO_ERROR if and only if
     * {@hasError} returns false.
     *
     * @return the error message
     */
    public ErrorMessage getError() {
        if (!hasError()) {
            return ErrorMessage.NO_ERROR;
        } else {
            return err;
        }
    }

    /**
     * Returns the object wrapped in this ReturnObject, i.e. the
     * result of the operation if it was successful, or null if
     * there has been error.
     *
     * Note that the output of this method must be null if {@see
     * hasError} returns true, but the opposite is not true: if
     * {@see hasError} returns false, this method may or may not
     * return null.
     *
     * @return the return value from the method or null if there has been an
     *         error
     */
    public Object getReturnValue() {
        return (hasError()) ? null : data;
    }

}
