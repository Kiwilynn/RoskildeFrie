public class Born {

    private String fornavn;
    private String efternavn;
    private int alder;
    private int ind_Dato;
    private String stue;
    private String parent_Navn;

    public Born(String fornavn, String efternavn, int alder, int ind_Dato, String stue, String parent_Navn){
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.alder = alder;
        this. ind_Dato = ind_Dato;
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
    public int getInd_Dato() {
        return ind_Dato;
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
    public void setIndDato(int ind_Dato) {
        this.ind_Dato = ind_Dato;
    }
    public void setStue(String stue) {
        this.stue = stue;
    }
    public void setParent_Navn(String parent_Navn) {
        this.parent_Navn = parent_Navn;
    }
}
