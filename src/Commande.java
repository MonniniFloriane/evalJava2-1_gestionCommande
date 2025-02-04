import java.util.ArrayList;
import java.util.List;

public class Commande implements ISujet {
    private int id;
    private final String produits;
    private final int prixTotal;
    private String status;
    private final List<IObserver> observers;
    private final ETypePaiement type;

    Commande(CommandeBuilder builder) {
        this.id        = builder.id;
        this.produits  = builder.produits;
        this.prixTotal = builder.prixTotal;
        this.status    = builder.status;
        this.observers = builder.observers;
        this.type      = builder.type;
    }

    public int getId() {
        return id;
    }

    public String getProduits() {
        return produits;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public String getStatus() {
        return status;
    }

    public List<IObserver> getObservers() {
        return observers;
    }

    public void add(IObserver o) {
        observers.add(o);
    }

    public void remove(IObserver o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (IObserver o : observers) {
            o.update(status);
        }
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Commande" + "\n" +
                "id               : " + id + "\n" +
                "produits         : " + produits + '\n' +
                "prixTotal        : " + prixTotal + "\n" +
                "status           : " + status + "\n" +
                "type de paiement : " + type + "\n";
    }

    // ConcreteBuilder
    public static class CommandeBuilder implements ICommandeBuilder {
        private int id           = 0;
        private String produits  = "";
        private int prixTotal    = 0;
        private String status    = "";
        private List<IObserver> observers = new ArrayList<>();
        private ETypePaiement type;

        public CommandeBuilder(int id, String produits) {
            this.id        = id;
            this.produits  = produits;
            this.observers = new ArrayList<>();
        }

        public CommandeBuilder prixTotal(int valeur) {
            this.prixTotal = valeur;
            return this;
        }

        public CommandeBuilder status(String status) {
            this.status = status;
            return this;
        }

        public CommandeBuilder type(ETypePaiement type) {
            this.type = type;
            return this;
        }

        public Commande build() {
            return new Commande(this);
        }
    }
}
