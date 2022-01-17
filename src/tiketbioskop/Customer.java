package tiketbioskop;

public abstract class Customer {
    protected String namaCustomer, film, jamTayang;
    
    public Customer(String namaCustomer, String film, String jamTayang){
        this.namaCustomer = namaCustomer;
        this.film = film;
        this.jamTayang = jamTayang;
    }
    
    public String getNama(){
        return namaCustomer;
    }
    
    public void setNamaCustomer(String namaCustomer){
        this.namaCustomer = namaCustomer;
    }
    
    public String getfilm(){
        return film;
    }
    
    public void setFilm(String film){
        this.film = film;
    }
    
    public String getJaTayang(){
        return jamTayang;
    }
    
    public void setJamtayang(String jamTayang){
        this.jamTayang = jamTayang;
    }
}