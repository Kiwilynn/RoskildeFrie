import java.util.*;

public class Menu {

    public void menu() {

        Scanner scan = new Scanner(System.in);
        Logind bruger = new Logind();
        boolean go = true;
        int svar = 0;

        while(go){

            System.out.println("1: Vagtplan \n2: Telefon liste\n3: Indskrevet børn\n4: Hjælp");
            svar = scan.nextInt();

        switch (svar) {

            case 1:
                if(bruger.Bruger().equals("Leder")){
                    System.out.println("Hello");
                }



        }
        }
    }
}
