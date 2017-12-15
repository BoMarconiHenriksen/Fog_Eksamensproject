
package Business.ConfigurationException;

import java.util.logging.Logger;

/**
 *Formålet med Configuration configuration af en loggerfil som bliver gemt på
 * tomcatserveren i en logfil. Bruges til exceptionhandling. 
 * 
 */
public class Configuration {
    
    /**
     * PRODUCTION sættes til false når man deployer lokalt og til true når man 
     * deployer projektet på sin tomcatserver, hvor logfilen skal skrives til. 
     */
    public static final boolean PRODUCTION = false;

    /**
     * LOGFILEPATH den fil der bliver skabt når der kastes fanges og håndteres 
     * en exception og som kan findes i roden af ens server. 
     */
    public static final String LOGFILEPATH = "/var/log/tomcat8/fogEx.log";

    /**
     * en logger
     */
    public static Logger myLogger = Logger.getLogger("");
    
}
