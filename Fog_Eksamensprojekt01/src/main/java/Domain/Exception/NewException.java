package Domain.Exception;

/**
 * The purpose of LoginSampleException is to...
 * @author kasper
 */
public class NewException extends Exception{
    
    /**
     * Laver en ny instance af <code>NewException</code> uden en detailjeret besked.
     */
    public  NewException() {
        
    }

    /**
     * Laver en instance af <code>NewException</code> med en besked.
     * @param Msg Den besked, der bliver printet.
     */
    public NewException(String Msg) {
        super(Msg);
    }
    

}
