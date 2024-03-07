import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private String filePath;

    public CSVReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Transaction> readTransactions() {
        List<Transaction> transacts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean headerSkipped = false;
            while ((line = br.readLine()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }
                String[] parts = line.split(",");
                String date = parts[0];
                double amount = Double.parseDouble(parts[1]);
                String category = parts[2];
                String type = parts[3];
                Transaction transaction = new Transaction(date, amount, category, type);
                transacts.add(transaction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transacts;
    }
}

