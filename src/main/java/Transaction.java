public class Transaction {
    private String date;
    private double amount;
    private String category;
    private String type;

    public Transaction(String date, double amount, String category, String type) {
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
}
