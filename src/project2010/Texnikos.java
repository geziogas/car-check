/*
 * H klash Texnikos, akolouthei ierarxika, kai klhronomei thn
 * yperklassh "Proswpiko".
 */

package project2010;


import java.util.*;
import java.io.*;


/**
 * ERGASIA ANAPTYKSHS EFARMOGHS SYNERGEIOY AYTOKINHTWN
 * @author George Ziogas AEM: 1461
 */
public class Texnikos extends Proswpiko implements Serializable
{
    
    //Lista hmerwn gia to hmerologio toy texnikoy
    public  List<String> hmerologioDiathesimothtas = new ArrayList<String>();
    private String speciality;

    //Constructors
    public Texnikos(String name, String surname, String speciality)
    {
        //Elegxos kenhs eisodou timwn, gia ta stoixeia toy pelath
        if (name!=null)
        {
            this.setName(name);
        }else this.setName("(κενό)");

        if (surname!=null)
        {
            this.setSurname(surname);
        }else this.setSurname("(κενό)");

        if (speciality!=null){
            this.setSpeciality(speciality);
        }else this.setSpeciality("(κενό)");
    }

    
    //Xrhsh methodwn kai idiothtwn ths yperklasshs "Proswpiko"    
    public void setSpeciality(String spec)
    {
        speciality=spec;
    }
    
    public String getSpeciality()
    {
        return speciality;
    }

    public String ShowTechDetails() {

        //Xrhsh ths StringBuffer, gia dieykolynsh sthn diaxeirish ths listas
        //poy periexei ta diafora strings
        StringBuffer lista = new StringBuffer();

        lista.append("Ονομ/νυμο:  " + this.getName() + " " + this.getSurname());
        lista.append("\n");
        lista.append("Ειδικότητα: " + getSpeciality());
        lista.append("\n");

        return lista.toString();
    }
}
