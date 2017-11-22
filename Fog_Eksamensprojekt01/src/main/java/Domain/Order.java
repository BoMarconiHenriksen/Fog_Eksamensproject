package Domain;

import java.util.Date;

/**
 *
 * @author Ticondrus
 */
public class Order {

    /**
     * Her oprettes nogle af attributterne (eller resten f attirbutterne) for en
     * order.
     *
     * @param order_id 1
     * @param user_id 2
     * @param receiveddate 3
     */
    private int ordre_id;
    private int user_id;
    private String receiveddate;
    

    public Order(int ordre_id, String receiveddate, int user_id) {
        this.ordre_id = ordre_id;
        this.receiveddate = receiveddate;
        this.user_id = user_id;
    }

    public Order(int user_id, String receiveddate) {
        this.user_id = user_id;
        this.receiveddate = receiveddate;
    }
    
    public Order() {

    }

    @Override
    public String toString() {
        return "Order no  " + ordre_id + ", received:  " + receiveddate + ", user_id:  " + user_id ;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOrder_id() {
        return ordre_id;
    }

    public String getReciveddate() {
        return receiveddate;
    }

    public void setReciveddate(String receiveddate) {
        this.receiveddate = receiveddate;
    }

    public void setOrder_id(int ordre_id) {
        this.ordre_id = ordre_id;
    }

}
