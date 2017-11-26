package Domain;

/**
 *
 * @author Bo
 */
public class Odetaljer {

    private int odetaljerId;
    private int ordre_id;
    private int vareId;
    private int linjelisteId;
    private String ordre_status;
    private double carport_length;
    private double carport_width;
    private double carport_height;
    private double length_redskabsrum;
    private double width_redskabsrum;
    private int tagType;

    public Odetaljer(int odetaljerId, int ordre_id, int vareId, int linjelisteId, String ordreStatus, double carport_length, double carport_width, double carport_height, double length_redskabsrum, double width_redskabsrum, int tagType) {
        this.odetaljerId = odetaljerId;
        this.ordre_id = ordre_id;
        this.vareId = vareId;
        this.linjelisteId = linjelisteId;
        this.ordre_status = ordre_status;
        this.carport_length = carport_length;
        this.carport_width = carport_width;
        this.carport_height = carport_height;
        this.length_redskabsrum = length_redskabsrum;
        this.width_redskabsrum = width_redskabsrum;
        this.tagType = tagType;
    }

    public Odetaljer(int ordre_id, String ordre_status, double carport_length, double carport_width, double carport_height, double length_redskabsrum, double width_redskabsrum) {
        this.ordre_id = ordre_id;
        this.ordre_status = ordre_status;
        this.carport_length = carport_length;
        this.carport_width = carport_width;
        this.carport_height = carport_height;
        this.length_redskabsrum = length_redskabsrum;
        this.width_redskabsrum = width_redskabsrum;
    }

    public Odetaljer(int ordre_id, String ordre_status, double carport_length, double carport_width, double carport_height) {
        this.ordre_id = ordre_id;
        this.ordre_status = ordre_status;
        this.carport_length = carport_length;
        this.carport_width = carport_width;
        this.carport_height = carport_height;
    }

    public Odetaljer(int ordre_id, double carport_length, double carport_width, double carport_height) {
        this.ordre_id = ordre_id;
        this.carport_length = carport_length;
        this.carport_width = carport_width;
        this.carport_height = carport_height;
    }
    
    
        public Odetaljer(String ordre_status, double carport_length, double carport_width, double carport_height, double length_redskabsrum, double width_redskabsrum) {
        this.ordre_status = ordre_status;
        this.carport_length = carport_length;
        this.carport_width = carport_width;
        this.carport_height = carport_height;
        this.length_redskabsrum = length_redskabsrum;
        this.width_redskabsrum = width_redskabsrum;
    }
    

    public int getOdetaljerId() {
        return odetaljerId;
    }

    public void setOdetaljerId(int odetaljerId) {
        this.odetaljerId = odetaljerId;
    }

    public int getOrdreId() {
        return ordre_id;
    }

    public void setOrdreId(int ordreId) {
        this.ordre_id = ordre_id;
    }

    public int getVareId() {
        return vareId;
    }

    public void setVareId(int vareId) {
        this.vareId = vareId;
    }

    public int getLinjelisteId() {
        return linjelisteId;
    }

    public void setLinjelisteId(int linjelisteId) {
        this.linjelisteId = linjelisteId;
    }

    public String getOrdreStatus() {
        return ordre_status;
    }

    public void setOrdreStatus(String ordreStatus) {
        this.ordre_status = ordre_status;
    }

    public double getCarportLength() {
        return carport_length;
    }

    public void setCarportLength(double carport_length) {
        this.carport_length = carport_length;
    }

    public double getCarportWidth() {
        return carport_width;
    }

    public void setCarportWidth(double carport_width) {
        this.carport_width = carport_width;
    }

    public double getCarportHeight() {
        return carport_height;
    }

    public void setCarportHeight(double carport_height) {
        this.carport_height = carport_height;
    }

    public double getLengthRedskabsrum() {
        return length_redskabsrum;
    }

    public void setLengthRedskabsrum(double length_Redskabsrum) {
        this.length_redskabsrum = length_redskabsrum;
    }

    public double getWidthRedskabsrum() {
        return width_redskabsrum;
    }

    public void setWidthRedskabsrum(double width_redskabsrum) {
        this.width_redskabsrum = width_redskabsrum;
    }

    public int getTagType() {
        return tagType;
    }

    public void setTagType(int tagType) {
        this.tagType = tagType;
    }

    @Override
    public String toString() {
        return "Odetaljer{" + "odetaljerId=" + odetaljerId + ", ordreId=" + ordre_id + ", vareId=" + vareId + ", linjelisteId=" + linjelisteId + ", ordreStatus=" + ordre_status + ", carportLength=" + carport_length + ", carportWidth=" + carport_width + ", carportHeight=" + carport_height + ", lengthRedskabsrum=" + length_redskabsrum + ", widthRedskabsrum=" + width_redskabsrum + ", tagType=" + tagType + '}';
    }

}
