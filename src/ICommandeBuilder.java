public interface ICommandeBuilder {
    public Commande.CommandeBuilder prixTotal(int prixTotal);
    public Commande.CommandeBuilder status(String status);
    public Commande build();
}
