public class Main {
    public static void main(String[] args) {
        //builder
        System.out.println("Design Pattern : Builder");
        Commande commande1 = new Commande.CommandeBuilder(1669, "Lait").prixTotal(13).status("Valide").build();
        System.out.println(commande1.toString() + "\n");

        //factory
        System.out.println("Design Pattern : Factory");
        Paiement paypal = FPaiement.getMoyenPaiement(ETypePaiement.PAYPAL);
        assert paypal != null;
        System.out.println(paypal.toString() + "\n");

        //observer
        System.out.println("Design Pattern : Observer");
        Client client = new Client();
        commande1.add(client);
        commande1.setStatus("En cours");
        System.out.println("\n");

        //chain of responsability
        System.out.println("Design Pattern : Chain of responsibility");
        ISupportService stock = new StockSupport();
        ISupportService paiement = new PaiementSupport();
        ISupportService commande = new CommandeSupport();

        stock.setNext(paiement);
        paiement.setNext(commande);

        ServiceRequete requeteA = new ServiceRequete(ETypeVerification.STOCK, "Le produit est en stock, ajouter au panier ?");
        stock.handleVerification(requeteA);

        ServiceRequete requeteB = new ServiceRequete(ETypeVerification.PAIEMENT, "Le paiement est valider! Vous recevrais un mails dès que la commande sera envoyer");
        paiement.handleVerification(requeteB);

        ServiceRequete requeteC = new ServiceRequete(ETypeVerification.COMMANDE, "Erreur ! votre commande est annuler");
        commande.handleVerification(requeteC);

        System.out.println(requeteA.getConclution());
        System.out.println(requeteB.getConclution());
        System.out.println(requeteC.getConclution() + "\n");
    }
}