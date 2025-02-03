import java.util.ArrayList;

public class Commande {
    private int id;
    private String produits;
    private int prixTotal;
    private ArrayList<String> status;

    private Commande(CommandeBuilder builder) {
        this.id        = builder.id;
        this.produits  = builder.produits;
        this.prixTotal = builder.prixTotal;
        this.status    = builder.status;
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

    public ArrayList<String> getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", produits='" + produits + '\'' +
                ", prixTotal=" + prixTotal +
                ", status=" + status +
                '}';
    }

    // ConcreteBuilder
    public static class CommandeBuilder implements ICommandeBuilder {
        private int id                   = 0;
        private String produits          = "";
        private int prixTotal            = 0;
        private ArrayList<String> status = new ArrayList<>();

        public CommandeBuilder(int id, String produits) {
            this.id = id;
            this.produits = produits;
        }

        public CommandeBuilder prixTotal(int valeur) {
            this.prixTotal = valeur;
            return this;
        }

        public CommandeBuilder status(String status) {
            this.status.add(status);
            return this;
        }

        public Commande build() {
            return new Commande(this);
        }
    }
}
