package tiketbioskop;

public class DataCustomer extends Customer {
    private String jumlah;
 
    public DataCustomer(String jumlah, String namaCustomer, String film, String jamTayang){
        super(namaCustomer, film, jamTayang);
        this.jumlah = jumlah;
    }

    public String getJumlah(){
        return jumlah;
    }
    
    public void setJumlah(String jumlah){
        this.jumlah = jumlah;
    }
    
    @Override
    public String getNama(){
        return namaCustomer;
    }
    
    @Override
    public void setNamaCustomer(String namaCustomer){
        this.namaCustomer = namaCustomer;
    }
    
    @Override
    public String getfilm(){
        return film;
    }
    
    @Override
    public void setFilm(String film){
        this.film = film;
    }
    
    @Override
    public String getJaTayang(){
        return jamTayang;
    }
    
    @Override
    public void setJamtayang(String jamTayang){
        this.jamTayang = jamTayang;
    }

    String jamTayang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String film() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}