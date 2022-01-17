package tiketbioskop;

public abstract class DataAdmin {
    protected String nama, id, shift;
    
    public DataAdmin(String nama, String id, String shift){
        this.nama = nama;
        this.id = id;
        this.shift = shift;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getShift(){
        return shift;
    }
    
    public void setShift(String shift){
        this.shift = shift;
    }
}