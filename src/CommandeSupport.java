public class CommandeSupport implements ISupportService{
    private ISupportService next = null;

    @Override
    public void setNext(ISupportService next) {
        this.next = next;
    }

    @Override
    public void handleVerification(ServiceRequete requete) {
        if (requete.getType() == ETypeVerification.COMMANDE) {
            requete.setConclution("La commande est envoyer !");
        } else {
            if (next != null) {
                next.handleVerification(requete);
            } else {
                requete.setConclution("Erreur ! votre commande est annuler");
            }
        }
    }
}
