public class StockSupport implements ISupportService {
    private ISupportService next = null;

    @Override
    public void setNext(ISupportService next) {
        this.next = next;
    }

    @Override
    public void handleVerification(ServiceRequete requete) {
        if (requete.getType() == ETypeVerification.STOCK) {
            requete.setConclution("Le produit est en stock, ajouter au panier ?");
        } else {
            if (next != null) {
                next.handleVerification(requete);
            }
        }
    }
}
