package Domain.Exception;

/**
 *
 * 
 */
public class FogException extends Exception {
    
    /**
     * Creates a new instance of <code>FogException</code> without detail
     * message.
     */
    public FogException() {
    }

    /**
     * Constructs an instance of <code>FogException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FogException(String msg) {
        super(msg);
    }
    
}
