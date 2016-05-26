/*
 * H klash Pelaths, akolouthei ierarxika, kai klhronomei thn
 * yperklassh Atomo.
 */

package project2010;

import java.io.Serializable;

/**
 * ERGASIA ANAPTYKSHS EFARMOGHS SYNERGEIOY AYTOKINHTWN
 * @author George Ziogas AEM: 1461
 */
public class Pelaths extends Atomo implements Serializable
{
    private String thlefwno;
    private String odos;
    private String asfForeas;


    //Constructors gia thn klassh Pelaths
    public Pelaths(){}


    public Pelaths(String name, String surname, String thlefwno, String odos, String asfForeas) {
        
        //Elegxos kenhs eisodou timwn, gia ta stoixeia toy pelath
        if (name!=null)
        {
            this.setName(name);
        }else this.setName("(κενό)");

        if (surname!=null)
        {
            this.setSurname(surname);
        }else this.setSurname("(κενό)");

        if (thlefwno!=null)
        {
            this.setThlefwno(thlefwno);
        }else this.setThlefwno("(κενό)");

        if (odos!=null){
            this.setOdos(odos);
        }else this.setOdos("(κενό)");

        if (asfForeas!=null){
            this.setAsfForeas(asfForeas);
        }else this.setAsfForeas("(κενό)");
        
    }


    //Methodoi ths klasshs Pelaths
    public void setThlefwno(String thlefwno)
    {
        this.thlefwno = thlefwno;
    }

    public String getThlefwno()
    {
        return thlefwno;
    }

    public void setOdos(String odos)
    {
        this.odos = odos;
    }

    public String getOdos()
    {
        return odos;
    }

    public void setAsfForeas(String asfForeas)
    {
        this.asfForeas = asfForeas;
    }

    public String getAsfForeas()
    {
        return asfForeas;
    }



    public String ShowPelathsDetails()
    {
        //Xrhsh ths StringBuffer, gia dieykolynsh sthn diaxeirish ths listas
        //poy periexei ta diafora strings, apo thn efarmogh

        StringBuffer lista = new StringBuffer();
        lista.append("Ονομ/νυμο:  " + getName() + " " + getSurname());
        lista.append("\n");
        lista.append("Τηλέφωνο:  " + getThlefwno());
        lista.append("\n");
        lista.append("Οδός:  " + getOdos());
        lista.append("\n");
        lista.append("Ασφαλ. Φορέας:  " + getAsfForeas());
        lista.append("\n");

        return lista.toString();
    }
    
}
