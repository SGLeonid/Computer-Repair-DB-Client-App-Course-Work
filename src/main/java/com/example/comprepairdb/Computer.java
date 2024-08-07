public class Computer {
    public Computer() {}

    public Computer(int userId, String vendor, String model, String defect, int price, boolean repaired)
    {
        this.userId = userId;
        this.vendor = vendor;
        this.model = model;
        this.defect = defect;
        this.price = price;
        this.repaired = repaired;
    }

    public Computer(int computerId, int userId, String vendor, String model, String defect, int price, boolean repaired)
    {
        this.computerId = computerId;
        this.userId = userId;
        this.vendor = vendor;
        this.model = model;
        this.defect = defect;
        this.price = price;
        this.repaired = repaired;
    }

    public int getComputerId() {
        return computerId;
    }
    public void setComputerId(int computerId) {
        this.computerId = computerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDefect() {
        return defect;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isRepaired() {
        return repaired;
    }

    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
    }

    private int computerId;
    private int userId;
    private String vendor;
    private String model;
    private String defect;
    private int price;
    private boolean repaired;

    @Override
    public String toString()
    {
        return  "Computer [computerId:" + computerId +
                ", userId: " + userId +
                ", Vendoer: " + vendor +
                ", Model:  " + model +
                ", Deffect: " + defect +
                ", Price: " + price +
                ", Repaired: " + repaired + "]";
    }
}
