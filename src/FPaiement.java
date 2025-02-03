public class FPaiement implements IFPaiement {
    public static Paiement getMoyenPaiement(ETypePaiement type) {
        switch (type) {
            case CARTEBANCAIRE -> {
                return new Paiement(ETypePaiement.CARTEBANCAIRE);
            }
            case PAYPAL -> {
                return new Paiement(ETypePaiement.PAYPAL);
            }
            case CRYPTOMONNAIE -> {
                return new Paiement(ETypePaiement.CRYPTOMONNAIE);
            }
        }
        return null;
    }
}
