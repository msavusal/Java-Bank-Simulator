import java.io.*;
import java.util.*;

public class Pankkitili {
    //Jäsenmuuttujat/Attribuutit
	private String omistaja;
	private String tilinumero;
	private double saldo;

	//Muodostimet
	public Pankkitili(final String o_par,final String t_par,final double s_par){
        omistaja = o_par;
        tilinumero = t_par;
        saldo = s_par;
	}

	//Rakentajat/Konstruktorit
    public void setOmistaja(final String o_par){
        omistaja=o_par;
        //this.omistaja=omistaja;
	}
	public void setTilinumero(final String t_par){
        tilinumero=t_par;
        //this.tilinumero=tilinumero;
	}
	public void setSaldo(final double s_par){
        saldo=s_par;
        //this.saldo=saldo;
	}

	public String getOmistaja(){
        return omistaja;
	}
	public String getTilinumero(){
        return tilinumero;
	}
	public double getSaldo(){
        return saldo;
	}
}
