package Domain;

/**
 *
 * @author Bo
 */
public class Ordre {
    
    private int ordre_id;
    private int user_id;
    private String reciveddate;

    public Ordre(int ordre_id, String reciveddate, int user_id) {
        this.ordre_id = ordre_id;
        this.reciveddate = reciveddate;
        this.user_id = user_id;
    }

    public Ordre(int user_id, String reciveddate) {
        this.user_id = user_id;
        this.reciveddate = reciveddate;
    }

    public Ordre(int user_id) {
        this.user_id = user_id;
    }

    public Ordre() {
       
    }

   

    public int getOrdre_id() {
        return ordre_id;
    }

    public void setOrdre_id(int ordre_id) {
        this.ordre_id = ordre_id;
    }

    public String getReciveddate() {
        return reciveddate;
    }

    public void setReciveddate(String reciveddate) {
        this.reciveddate = reciveddate;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Order nr.  " + ordre_id + ", Modtaget:  " + reciveddate + ", Bruger_id:  " + user_id ;
    }
    
    
    
}
