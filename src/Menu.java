import java.util.*;

public class Menu {

    public void menu() {

        Scanner scan = new Scanner(System.in);
        Logind bruger = new Logind();
        boolean go = true;
        int svar = 0;

        while(go){

            bruger.Logind();
            System.out.println("1: Telefon liste \n2: Indskrevet børn\n3: Hjælp\n4: Sluk program");
            svar = scan.nextInt();

        switch (svar) {

            case 1:
                if(bruger.getStatus().equals("Leder")){
                    System.out.println("Leder");
                    // rediger og vis telefon liste
                }
                else if (bruger.getStatus().equals("Ansat")){
                    //vis telefon liste
                    System.out.println("Ansat");
                }
            case 2:

            case 3:

            case 4:
                go = false;
        }
        }
    }
}
