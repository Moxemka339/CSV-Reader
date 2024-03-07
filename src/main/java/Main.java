import java.util.List;
public class Main {
    public static void main(String[] args) {
        CSVReader CSVReader = new CSVReader("transactions.csv");
        List<Transaction> transactions = CSVReader.readTransactions();

        // Розрахунок загального балансу
        double totalBalance = TransactionAnalyze.calculateTotalBalance(transactions);
        System.out.println("Загальний баланс: " + totalBalance);

        // Підрахунок транзакцій за конкретний місяць
        int month = 6; // Наприклад, червень
        int transactionsCount = TransactionAnalyze.countTransactionsByMonth(transactions, month);
        System.out.println("Кількість транзакцій у червні: " + transactionsCount);

        // Визначення 10 найбільших витрат
        List<Transaction> topExpenses = TransactionAnalyze.getTopExpenses(transactions, 10);
        System.out.println("10 найбільших витрат:");
        for (Transaction expense : topExpenses) {
            System.out.println(expense);
        }

        // Аналіз на що витрачено найбільше грошей
        String mostSpentCategory = TransactionAnalyze.analyzeExpensesCategories(transactions);
        System.out.println(mostSpentCategory);
    }
}