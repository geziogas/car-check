/*
 * H klash Grammateas, akolouthei ierarxika, kai klhronomei thn
 * yperklassh "Proswpiko".
 */

package project2010;

import java.io.Serializable;

/**
 * ERGASIA ANAPTYKSHS EFARMOGHS SYNERGEIOY AYTOKINHTWN
 * @author George Ziogas AEM: 1461
 */
public class Grammateas extends Proswpiko implements Serializable{


    //Constructor
    public Grammateas(String name, String surname)
    {
        this.setName(name);
        this.setSurname(surname);
    }

    //Methodoi klasshs grammatews
    public String ShowSecrDetails() {

        //Xrhsh ths StringBuffer, gia dieykolynsh sthn diaxeirish ths listas
        //poy periexei ta diafora strings


        StringBuffer lista = new StringBuffer();
        lista.append("Ονομ/νυμο:  " + this.getName() + " " + this.getSurname());
        lista.append("\n");

        return lista.toString();
    }

}
