package Business.Domain;

/**
 * Klassen er objektet for materialer.
 */
public class Materiale {

private int varenummer;
private String materialetype;
private String materialenavn;
private double enhedspris;
private String enhed;
private double msr;


    public Materiale(int varenummer, String materialetype, String materialenavn, double enhedspris, String enhed, double msr) {
        this.varenummer = varenummer;
        this.materialetype = materialetype;
        this.materialenavn = materialenavn;
        this.enhedspris = enhedspris;
        this.enhed = enhed;
        this.msr=msr;
    }

    public Materiale(int varenummer, double enhedspris) {
       this.varenummer = varenummer;
       this.enhedspris = enhedspris;
    }
    
    public Materiale() {
        
    }

    public int getVarenummer() {
        return varenummer;
    }

    public void setVarenummer(int varenummer) {
        this.varenummer = varenummer;
    }

    public String getMaterialetype() {
        return materialetype;
    }

    public void setMaterialetype(String materialetype) {
        this.materialetype = materialetype;
    }

    public String getMaterialenavn() {
        return materialenavn;
    }

    public void setMaterialenavn(String materialenavn) {
        this.materialenavn = materialenavn;
    }

    public double getEnhedspris() {
        return enhedspris;
    }

    public void setEnhedspris(double enhedspris) {
        this.enhedspris = enhedspris;
    }

    public String getEnhed() {
        return enhed;
    }

    public void setEnhed(String enhed) {
        this.enhed = enhed;
    }

    public double getMsr() {
        return msr;
    }

    public void setMsr(double msr) {
        this.msr = msr;
    }

    @Override
    public String toString() {
        return "Materiale{ materialetype=" + materialetype + ", materialenavn=" + materialenavn + ", enhedspris=" + enhedspris + ", enhed=" + enhed + ", msr=" + msr + '}';
    }

}