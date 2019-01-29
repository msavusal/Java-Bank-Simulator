import java.io.*;
import java.util.*;

class PankkitiliMain{
    static Pankkitili tili = new Pankkitili("Oletusomistaja","12345",500);
    static Scanner input = new Scanner(System.in);

    //Pääohjelma
    public static void main(String [] args){
        int i = 1;
        String omistaja,tilinumero;
        double saldo;
        tilinumero=tili.getTilinumero();
        omistaja=tili.getOmistaja();
        saldo=tili.getSaldo();

        //Valikko
        while(i == 1) {
            System.out.print("Valitse vaihtoehto: \n");
            System.out.print("Luo tili = 1\n");
            System.out.print("Nosta tililtä = 2\n");
            System.out.print("Talleta tiliin = 3\n");
            System.out.print("Tulosta tili = 4\n");
            System.out.print("Lopeta = 5\n");

            if (!input.hasNextInt()) {
            System.out.println("Syotto hyvaksyy vain luvun\n");
            input.nextLine();
            continue;
            }
            int answer = input.nextInt();
            switch(answer) {
            //Tilin luonti
            case 1:
                System.out.print("Luodaan tili\n");
                omistaja=luoOmistaja();
                tilinumero=luoTilinumero();
                saldo=luoSaldo();
                tili = new Pankkitili(omistaja,tilinumero,saldo);
                break;
            //Tililtä nosto
            case 2:
                System.out.print("Nostetaan tililta\n");
                saldo=nostaTili();
                tili = new Pankkitili(omistaja,tilinumero,saldo);
                break;
            //Tiliin talletus
            case 3:
                System.out.print("Talletetaan tiliin\n");
                saldo=talletaTiliin();
                tili = new Pankkitili(omistaja,tilinumero,saldo);
                break;
            //Tilin tulostus
            case 4:
                System.out.print("Tulostetaan tili\n");
                tulostaTili();
                break;
            //Ohjelman lopetus
            case 5:
                System.out.print("Ohjelma lopetetaan\n");
                i = 2;
                break;
            default:
                System.out.print("Valinta ei ole mahdollinen\n");
                continue;
            }
        }
    }

	//Metodit
	static public double luoDouble(){
        double luku = 0;
        boolean ok = false;
        while (!ok){
            try{
                luku = input.nextDouble();
                input.nextLine();
            }catch(InputMismatchException ime) {
                System.out.println("Syotto hyvaksyy vain luvun: " + ime + "\n");
                input.nextLine();
            } ok = true;
        } return luku;
	}

    static public String luoOmistaja(){
        System.out.print("Anna tilinomistajan nimi > ");
        input.nextLine();
        String omistaja = input.nextLine();
        System.out.println("Tilinomistaja on: " + omistaja + "\n");
        return omistaja;
    }

    static public String luoTilinumero(){
        System.out.print("Anna tilinumero > ");
        String tilinumero = input.nextLine();
        System.out.println("Tilinumero on: " + tilinumero + "\n");
        return tilinumero;
    }

    static public double luoSaldo(){
        System.out.print("Anna saldo > ");
        double saldo = luoDouble();
        System.out.println("Saldo on: " + saldo + " euroa\n");
        return saldo;
    }

    static public double nostaTili(){
            String omistaja = tili.getOmistaja();
            String tilinumero = tili.getTilinumero();
            double saldo1 = tili.getSaldo();
            double saldo2,saldo = 0;

            System.out.println("Omistaja on: " + omistaja + "\n");
            System.out.println("Tilinumero on: " + tilinumero);
            System.out.println("Saldo ennen nostoa on: " + saldo1 + " euroa\n");
            System.out.print("Anna nostettava rahamaara > ");
            saldo2 = luoDouble();
            if (saldo2 < 0) {
                System.out.print("Ei voi nostaa negatiivista rahamaaraa\n");
            }
            else if (saldo2 > saldo1) {
                System.out.print("Ei voi nostaa yli saldon\n");
            }else{
                saldo = saldo1 - saldo2;

                System.out.println("Omistaja on: " + omistaja + "\n");
                System.out.println("Tilinumero on: " + tilinumero + "\n");
                System.out.println("Saldo noston jalkeen on: " + saldo + " euroa\n");
            }
        return saldo;
    }

    static public double talletaTiliin(){
            String omistaja = tili.getOmistaja();
            String tilinumero = tili.getTilinumero();
            double saldo1 = tili.getSaldo();
            double saldo2,saldo = 0;

            System.out.println("Omistaja on: " + omistaja + "\n");
            System.out.println("Tilinumero on: " + tilinumero + "\n");
            System.out.println("Saldo ennen talletusta on: " + saldo1 + " euroa\n");
            System.out.print("Anna talletettava rahamaara > ");
            saldo2 = luoDouble();
            if (saldo2 < 0) {
                System.out.print("Ei voi tallettaa negatiivista rahamaaraa\n");
            }else{
                saldo = saldo1 + saldo2;

                System.out.println("Omistaja on: " + omistaja + "\n");
                System.out.println("Tilinumero on: " + tilinumero + "\n");
                System.out.println("Saldo talletuksen jalkeen on: " + saldo + " euroa\n");
            }
        return saldo;
    }

    static public void tulostaTili(){
        String omistaja = tili.getOmistaja();
        String tilinumero = tili.getTilinumero();
        double saldo1 = tili.getSaldo();

        System.out.println("Omistaja on: " + omistaja + "\n");
        System.out.println("Tilinumero on: " + tilinumero + "\n");
        System.out.println("Saldo on: " + saldo1 + " euroa\n");
    }
}
