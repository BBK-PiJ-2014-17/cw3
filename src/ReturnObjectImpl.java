
/**
 * Created by Basil on 30/11/2014.
 *
 * Implements ReturnObject {@see ReturnObject}
 * Status: Final.
 */
public class ReturnObjectImpl implements ReturnObject {

    // class variables

    private ErrorMessage err;   // error message
    private Object data;        // return object content

    // constructors

    /**
     * default constructor, empty structure
     */
    public ReturnObjectImpl() {
        this(null, ErrorMessage.EMPTY_STRUCTURE);
    }

    /**
     * data only constructor, no error by default
     * @param data contains data part of returnObject
     */
    public ReturnObjectImpl(Object data) {
        this(data, ErrorMessage.NO_ERROR);
    }

    /**
     * fully initialised constructor
     * @param data contains data part of returnObject
     * @param err contains error message {@see ErrorMessage} for returnObject
     */
    public ReturnObjectImpl(Object data, ErrorMessage err) {
        this.data = data;
        this.err = err;
    }

    // class methods

    /** {@inheritDoc}
     * checks err before returning boolean
     * @return returns true or false
     */
    @Override
    public boolean hasError() {
        return (this.err == ErrorMessage.NO_ERROR) ? false : true;
    }

    /** {@inheritDoc}
     * checks {@see hasError} before returning error
     * @return returns NO_ERROR or err
     */
    @Override
    public ErrorMessage getError() {
        if (!hasError()) {
            return ErrorMessage.NO_ERROR;
        } else {
            return err;
        }
    }

    /** {@inheritDoc}
     * checks {@see hasError} before returning data
     * @return returns null or data
     */
    @Override
    public Object getReturnValue() {
        return (hasError()) ? null : data;
    }

}
