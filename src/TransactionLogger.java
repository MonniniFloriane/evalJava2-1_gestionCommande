import java.util.ArrayList;
import java.util.List;

public class TransactionLogger {
    private final List<Commande> transactions = new ArrayList<>();

    public void afficherJournal() {
        for (Commande transaction : transactions) {
            System.out.println(transaction.toString());
        }
    }

    private void ajoutJournal(Commande transaction) {
        transactions.add(transaction);
    }

    public List<Commande> getTransaction() {
        return this.transactions;
    }
}
