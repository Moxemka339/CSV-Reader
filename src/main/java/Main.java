import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader("transactions.csv");
        List<Transaction> transactions = csvReader.readTransactions();

        // Створення об'єкта для аналізу транзакцій
        TransactionAnalyze transactionAnalyzer = new TransactionAnalyze(transactions);

        transactionAnalyzer.viewTransactions(transactions);
        // Розрахунок загального балансу
        double totalBalance = transactionAnalyzer.calculateTotalBalance();
        System.out.println("Загальний баланс: %.2f%n" + String.format("%.2f%n", totalBalance));


        // Підрахунок транзакцій за конкретний місяць (наприклад, січень 2023 року)
        String year = "2023";
        String month = "01";
        Map<String, Double> monthlyTransactions = transactionAnalyzer.calculateMonthlyTransactions(year, month);
        System.out.println("Транзакції за " + month + "/" + year + ":");
        for (Map.Entry<String, Double> entry : monthlyTransactions.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Визначення 10 найбільших витрат
        int n = 10;
        List<Transaction> topExpenses = transactionAnalyzer.getTopExpenses(n);
        System.out.println("Топ " + n + " витрат:");
        for (Transaction expense : topExpenses) {
            System.out.println(expense.getDate() + " - " + expense.getAmount() + " - " + expense.getCategory());
        }

        // Аналіз на що витрачено найбільше грошей
        String maxSpendingCategory = transactionAnalyzer.analyzeSpending();
        System.out.println("Найбільше грошей витрачено: " + maxSpendingCategory);
    }
}