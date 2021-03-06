package Business.Domain;

/**
 * Klassen er objektet for LineItem.
 */
public class LineItem {
    
    private String description;
    private String material_name;
    private double dimension;
    private int amount;
    private String unit;

    public LineItem(String description, String material_name, double dimension, int amount, String unit) {
        this.description = description;
        this.material_name = material_name;
        this.dimension = dimension;
        this.amount = amount;
        this.unit = unit;
    }

    public LineItem(String description, String material_name, int amount, String unit) {
        this.description = description;
        this.material_name = material_name;
        this.amount = amount;
        this.unit = unit;
    }
    
    public LineItem() {
        
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public double getDimension() {
        return dimension;
    }

    public void setDimension(double dimension) {
        this.dimension = dimension;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
