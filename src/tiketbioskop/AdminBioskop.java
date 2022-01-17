package tiketbioskop;

public class AdminBioskop extends DataAdmin {
    private  String password;
    
    public AdminBioskop(String password, String nama, String id, String shift){
        super(nama, id, shift);
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
}