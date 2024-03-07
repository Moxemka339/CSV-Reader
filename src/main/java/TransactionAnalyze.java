import java.util.*;

public class TransactionAnalyze {
        private List<Transaction> transactions;

        public TransactionAnalyze(List<Transaction> transactions) {
            this.transactions = transactions;
        }

    public void viewTransactions(List<Transaction> transacts){
        for(Transaction transaction : transacts){
            System.out.println(transaction.getDate() + " | " + transaction.getType() + " | "
                    + transaction.getCategory() + " | " + transaction.getAmount());
        }
    }
    public double calculateTotalBalance() {
        double totalBalance = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getType().equals("Replenishment")) {
                totalBalance += transaction.getAmount();
            } else {
                totalBalance -= transaction.getAmount();
            }
        }
        return totalBalance;
    }

    public Map<String, Double> calculateMonthlyTransactions(String year, String month) {
        Map<String, Double> monthlyTransactions = new HashMap<>();
        for (Transaction transaction : transactions) {
            String[] dateParts = transaction.getDate().split("-");
            String transactionYear = dateParts[0];
            String transactionMonth = dateParts[1];
            if (transactionYear.equals(year) && transactionMonth.equals(month)) {
                String category = transaction.getCategory();
                double amount = transaction.getAmount();
                monthlyTransactions.put(category, monthlyTransactions.getOrDefault(category, 0.0) + amount);
            }
        }
        return monthlyTransactions;
    }

    public List<Transaction> getTopExpenses(int n) {
        List<Transaction> expenses = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getType().equals("Expense")) {
                expenses.add(transaction);
            }
        }
        expenses.sort(Comparator.comparingDouble(Transaction::getAmount).reversed());
        return expenses.subList(0, Math.min(n, expenses.size()));
    }

    public String analyzeSpending() {
        Map<String, Double> spendingByCategory = new HashMap<>();
        for (Transaction transaction : transactions) {
            String category = transaction.getCategory();
            double amount = transaction.getAmount();
            spendingByCategory.put(category, spendingByCategory.getOrDefault(category, 0.0) + amount);
        }

        String maxSpendingCategory = (Collections.max(spendingByCategory.entrySet(), Map.Entry.comparingByValue()).getValue()).toString();
        return maxSpendingCategory;
    }
}