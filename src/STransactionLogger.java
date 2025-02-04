import java.util.ArrayList;
import java.util.List;

public class STransactionLogger {
    private static STransactionLogger instance;
    private final List<Commande> transactions;

    private STransactionLogger() {
        transactions = new ArrayList<>();
    }

    public static STransactionLogger getInstance() {
        if (instance == null) {
            instance = new STransactionLogger();
        }
        return instance;
    }

    public void ajoutJournal(Commande transaction) {
        transactions.add(transaction);
    }

    public void afficherJournal() {
        for (Commande transaction : transactions) {
            System.out.println(transaction.toString());
        }
    }
}
