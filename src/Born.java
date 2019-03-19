import java.text.SimpleDateFormat;
import java.util.*;

public class Born {

    private String fornavn;
    private String efternavn;
    private int alder;
    private String stue;
    private String parent_Navn;

    //Formateret Date object fra java.util til at være en string
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private String dato;

    public Born(String fornavn, String efternavn, int alder, String stue, String parent_Navn, String dato){
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.alder = alder;
        this.dato = dato;
        this.stue = stue;
        this.parent_Navn = parent_Navn;
    }

    public String getFornavn() {
        return fornavn;
    }
    public String getEfternavn() {
        return efternavn;
    }
    public int getAlder() {
        return alder;
    }
    public String getDato() {
        return dato;
    }
    public String getStue() {
        return stue;
    }
    public String getParent_Navn() {
        return parent_Navn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }
    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }
    public void setAlder(int alder) {
        this.alder = alder;
    }
    public void setDato(String dato) { this.dato = dato; }
    public void setStue(String stue) {
        this.stue = stue;
    }
    public void setParent_Navn(String parent_Navn) {
        this.parent_Navn = parent_Navn;
    }

    public String toString(){
        return fornavn + efternavn + alder + stue + parent_Navn + dato;
    }
}
