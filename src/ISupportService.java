public interface ISupportService {
    void setNext(ISupportService next);
    void handleVerification(ServiceRequete requete);
}
