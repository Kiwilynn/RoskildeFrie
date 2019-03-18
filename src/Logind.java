import java.util.*;

public class Logind {

    public String Bruger(){


        int lederPW = 123;
        int ansatPW = 456;
        int svar = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Indtast kodeord");
        svar  = input.nextInt();
        try {
            if (svar == lederPW) {
                return "Leder";
            } else if (svar == ansatPW) {
                return "Ansat";
            } else {
                System.out.println("Dit svar var ikke et gyldigt kodeord");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Indtast venligst din kode, som består af udelukkende tal");
        }
        return null;
    }

}
