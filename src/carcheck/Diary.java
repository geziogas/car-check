/*
 * H klassh "hmerolTech" opws leei kai to onoma ths, ylopoiei to
 * antikeimeno tou hmerologiou toy texnikoy aytokinhtwn, kai emperiexei, ta
 * stoixeia enos hmerologiou (wra, mera) kathws kai to se poion anhkei.
 */

package project2010;

import java.io.Serializable;

/**
 * ERGASIA ANAPTYKSHS EFARMOGHS SYNERGEIOY AYTOKINHTWN
 * @author George Ziogas AEM: 1461
 */
public class hmerolTech implements Serializable
{
    private String mera;
    private String wra;
    private String name;
    private String surname;

    public hmerolTech (String techMera, String techWra, String custName, String custSurname)
    {
        mera = techMera;
        wra = techWra;
        name = custName;
        surname = custSurname;
    }

    public hmerolTech ()
    {
        mera = "";
        wra = "";
        name = "";
        surname = "";
    }

    public void setHmerolMera(String mmera)
    {
        mera = mmera;
    }

    public String getHmerolMera()
    {
        return mera;
    }

    public String getHmerolWra()
    {
        return wra;
    }

    public void setHmerolWra(String wwra)
    {
        wra = wwra;
    }

    public String getHmerolCustName()
    {
        return name;
    }

    public String getHmerolCustSurname()
    {
        return surname;
    }

    //Emfanish plhroforiwn, toy hmerologiou, toy antistoixoy texnikoy
    public String showHmerolTechDetails()
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append(mera + " -- " + wra + " -- " + name + " " + surname);
        return buffer.toString();
    }
}
