public record Paiement(ETypePaiement type) implements IMoyenPaiement {

    @Override
    public double payer(double montant) {
        return 0;
    }

    @Override
    public String getPaiementString() {
        switch (this.type) {
            case CARTEBANCAIRE -> {
                return "Cartebancaire";
            }
            case PAYPAL -> {
                return "Paypal";
            }
            case CRYPTOMONNAIE -> {
                return "Cryptomonnaie";
            }
        }
        return "";
    }

    @Override
    public String toString() {
        return "Type de paiement : " + this.getPaiementString();
    }
}
