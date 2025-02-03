public class ServiceRequete {
    private final ETypeVerification type;
    private String requete    = "";
    private String conclution = "";

    public ServiceRequete(ETypeVerification type, String requete) {
        this.type = type;
        this.requete = requete;
    }

    public ETypeVerification getType() {
        return type;
    }

    public String getRequete() {
        return requete;
    }

    public String getConclution() {
        return conclution;
    }

    public void setConclution(String conclution) {
        this.conclution = conclution;
    }
}
