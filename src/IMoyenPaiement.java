public interface IMoyenPaiement {
    double payer(double montant);

    String getPaiementString();
}
