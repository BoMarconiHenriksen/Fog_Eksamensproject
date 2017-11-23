package Domain;

/**
 *
 * @author Bo
 */
public class Odetaljer {
    
   private int odetaljerId; 
   private int ordreId;
   private int vareId;
   private int linjelisteId;
   private String ordreStatus;
   private double carportLength;
   private double carportWidth;
   private double carportHeight;
   private double lengthRedskabsrum;
   private double widthRedskabsrum;
   private int tagType;

    public Odetaljer(int odetaljerId, int ordreId, int vareId, int linjelisteId, String ordreStatus, double carportLength, double carportWidth, double carportHeight, double lengthRedskabsrum, double widthRedskabsrum, int tagType) {
        this.odetaljerId = odetaljerId;
        this.ordreId = ordreId;
        this.vareId = vareId;
        this.linjelisteId = linjelisteId;
        this.ordreStatus = ordreStatus;
        this.carportLength = carportLength;
        this.carportWidth = carportWidth;
        this.carportHeight = carportHeight;
        this.lengthRedskabsrum = lengthRedskabsrum;
        this.widthRedskabsrum = widthRedskabsrum;
        this.tagType = tagType;
    }

    public Odetaljer(int ordreId, double carportLength, double carportWidth, double carportHeight) {
       this.ordreId = ordreId;
        this.carportLength = carportLength;
        this.carportWidth = carportWidth;
        this.carportHeight = carportHeight;
    }

    public Odetaljer(int odetaljerId, int ordreId, int vareId, int linjelisteId, double carportLength, double carportWidth, double carportHeight, double lengthRedskabsrum,  int tagType) {
       this.odetaljerId = odetaljerId;
        this.ordreId = ordreId;
        this.vareId = vareId;
        this.linjelisteId = linjelisteId;
        this.carportLength = carportLength;
        this.carportWidth = carportWidth;
        this.carportHeight = carportHeight;
        this.lengthRedskabsrum = lengthRedskabsrum;
//        this.widthRedskabsrum = widthRedskabsrum;
        this.tagType = tagType;
    }

    public int getOdetaljerId() {
        return odetaljerId;
    }

    public void setOdetaljerId(int odetaljerId) {
        this.odetaljerId = odetaljerId;
    }

    public int getOrdreId() {
        return ordreId;
    }

    public void setOrdreId(int ordreId) {
        this.ordreId = ordreId;
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
        return ordreStatus;
    }

    public void setOrdreStatus(String ordreStatus) {
        this.ordreStatus = ordreStatus;
    }

    public double getCarportLength() {
        return carportLength;
    }

    public void setCarportLength(double carportLength) {
        this.carportLength = carportLength;
    }

    public double getCarportWidth() {
        return carportWidth;
    }

    public void setCarportWidth(double carportWidth) {
        this.carportWidth = carportWidth;
    }

    public double getCarportHeight() {
        return carportHeight;
    }

    public void setCarportHeight(double carportHeight) {
        this.carportHeight = carportHeight;
    }

    public double getLengthRedskabsrum() {
        return lengthRedskabsrum;
    }

    public void setLengthRedskabsrum(double lengthRedskabsrum) {
        this.lengthRedskabsrum = lengthRedskabsrum;
    }

    public double getWidthRedskabsrum() {
        return widthRedskabsrum;
    }

    public void setWidthRedskabsrum(double widthRedskabsrum) {
        this.widthRedskabsrum = widthRedskabsrum;
    }

    public int getTagType() {
        return tagType;
    }

    public void setTagType(int tagType) {
        this.tagType = tagType;
    }

    @Override
    public String toString() {
        return "Odetaljer{" + "odetaljerId=" + odetaljerId + ", ordreId=" + ordreId + ", vareId=" + vareId + ", linjelisteId=" + linjelisteId + ", ordreStatus=" + ordreStatus + ", carportLength=" + carportLength + ", carportWidth=" + carportWidth + ", carportHeight=" + carportHeight + ", lengthRedskabsrum=" + lengthRedskabsrum + ", widthRedskabsrum=" + widthRedskabsrum + ", tagType=" + tagType + '}';
    }
   
   
    
    
    
}
