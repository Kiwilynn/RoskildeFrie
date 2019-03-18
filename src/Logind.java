import java.util.*;

public class Logind {

    String Status = null;

    public void Logind(){

        try {
        int lederPW = 123;
        int ansatPW = 456;
        int svar = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Indtast kodeord");
        svar  = input.nextInt();

            if (svar == lederPW) {
                Status = "Leder";
            } else if (svar == ansatPW) {
                Status = "Ansat";
            } else {
                System.out.println("Dit svar var ikke et gyldigt kodeord");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Indtast venligst din kode, som består af udelukkende tal");
        Logind();

        }
    }

    public String getStatus(){
        return Status;
    }

}
