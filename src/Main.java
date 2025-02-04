public class Main {
    public static void main(String[] args) {
        //builder
        System.out.println("Design Pattern Builder");
        Commande commande1 = new Commande.CommandeBuilder(1, "Lait").prixTotal(13).status("Expédier").type(ETypePaiement.PAYPAL).build();
        Commande commande2 = new Commande.CommandeBuilder(2, "Beurre").prixTotal(10).status("En cours").type(ETypePaiement.CARTEBANCAIRE).build();
        System.out.println(commande1.toString() + "\n");

        //factory
        System.out.println("Design Pattern Factory");
        Paiement carte = FPaiement.getMoyenPaiement(ETypePaiement.CARTEBANCAIRE);
        assert carte != null;
        System.out.println(carte);

        Paiement paypal = FPaiement.getMoyenPaiement(ETypePaiement.PAYPAL);
        assert paypal != null;
        System.out.println(paypal);

        Paiement crypto = FPaiement.getMoyenPaiement(ETypePaiement.CRYPTOMONNAIE);
        assert crypto != null;
        System.out.println(crypto + "\n");

        //observer
        System.out.println("Design Pattern Observer");
        Client client = new Client();
        commande1.add(client);
        commande1.setStatus("En cours" + "\n");
        commande2.add(client);

        //chain of responsability
        System.out.println("Design Pattern Chain of responsibility");
        ISupportService stock = new StockSupport();
        ISupportService paiement = new PaiementSupport();
        ISupportService commande = new CommandeSupport();

        stock.setNext(paiement);
        paiement.setNext(commande);

        ServiceRequete requeteA = new ServiceRequete(ETypeVerification.STOCK, "Le produit est en stock, ajouter au panier ?");
        stock.handleVerification(requeteA);

        ServiceRequete requeteB = new ServiceRequete(ETypeVerification.PAIEMENT, "Le paiement est valider! Vous recevrais un mails dès que la commande sera envoyer");
        paiement.handleVerification(requeteB);

        ServiceRequete requeteC = new ServiceRequete(ETypeVerification.COMMANDE, "La commande est envoyer !");
        commande.handleVerification(requeteC);

        System.out.println(requeteA.getConclution());
        System.out.println(requeteB.getConclution());
        System.out.println(requeteC.getConclution() + "\n");

        //Singleton
        System.out.println("Design Pattern Singleton");
        STransactionLogger transactionLogger = STransactionLogger.getInstance();
        transactionLogger.ajoutJournal(commande1);
        transactionLogger.ajoutJournal(commande2);

        System.out.println("Journal des transactions : [");
        transactionLogger.afficherJournal();
        System.out.println("]");
    }
}