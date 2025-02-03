public class PaiementSupport implements ISupportService{
    private ISupportService next = null;

    @Override
    public void setNext(ISupportService next) {
        this.next = next;
    }

    @Override
    public void handleVerification(ServiceRequete requete) {
        if (requete.getType() == ETypeVerification.PAIEMENT) {
            requete.setConclution("Le paiement est valider! Vous recevrais un mails dès que la commande sera envoyer");
        } else {
            if (next != null) {
                next.handleVerification(requete);
            }
        }
    }
}
