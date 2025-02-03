public class Main {
    public static void main(String[] args) {
        //builder
        Commande commande = new Commande.CommandeBuilder(1669, "Lait").prixTotal(13).status("Valide").build();
        System.out.println(commande.toString());

        //factory
        Paiement paypal = FPaiement.getMoyenPaiement(ETypePaiement.PAYPAL);
        assert paypal != null;
        System.out.println(paypal.toString());

        //observer
        Client client = new Client();
        commande.add(client);
        commande.setStatus("En cours");
    }
}