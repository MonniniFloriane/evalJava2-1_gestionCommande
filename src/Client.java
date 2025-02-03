public class Client implements IObserver{
    private String status;

    @Override
    public void update(String status) {
        this.status = status;
        System.out.println("Votre commande est désormait " + status);
    }

    public String getStatus() {
        return status;
    }
}
