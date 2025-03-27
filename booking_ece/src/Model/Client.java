package Model;

public interface Client {
    public int getClientId();
    public String getClientNom();
    public String getClientMail();
    public String getClientPassword();
    public void setClientPassword(String password);
    public void setClientMail(String mail);
    public void setClientNom(String nom);
}
