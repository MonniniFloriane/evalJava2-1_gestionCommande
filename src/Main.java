public class Main {
    public static void main(String[] args) {
        Commande commande = new Commande.CommandeBuilder(1669, "Lait").prixTotal(13).status("Valide").build();
        System.out.println(commande.toString());
    }
}