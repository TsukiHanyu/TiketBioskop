package tiketbioskop;

public class DataCustomerFix {
private DataCustomer pendaftarEntity;
private int indexKelas;
private String kodePendaftar;

public DataCustomerFix(DataCustomer pendaftarEntity, int indexKelas, String kodePendaftar){
    this.pendaftarEntity = pendaftarEntity;
    this.indexKelas = indexKelas;
    this.kodePendaftar = kodePendaftar;
    }

public DataCustomer getPendaftarEntity(){
    return pendaftarEntity;
    }

public void setpendaftarEntity(DataCustomer PendaftarEntity){
    this.pendaftarEntity = pendaftarEntity;
    }

public int getIndexKelas(){
    return indexKelas;
    }

public void setIndexKelas(int indexKelas){
    this.indexKelas = indexKelas;
    }

public String getKodePendaftar(){
    return kodePendaftar;
    }

public void setKodePendaftar(String kodePendaftar){
    this.kodePendaftar = kodePendaftar;
    }
}