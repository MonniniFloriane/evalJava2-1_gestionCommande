public class Paiement implements IMoyenPaiement {
    private ETypePaiement type;

    public Paiement(ETypePaiement type) {
        this.type = type;
    }

    public ETypePaiement getType() {
        return this.type;
    }

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
        return "Paiement{" +
                "type=" + this.getPaiementString() +
                '}';
    }
}
