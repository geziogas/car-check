/*
 * H klash IstorikoPelath, einai yperklassh gia thn xrhsh toy istorikoy
 *
 */


package project2010;

import java.io.Serializable;

/**
 * ERGASIA ANAPTYKSHS EFARMOGHS SYNERGEIOY AYTOKINHTWN
 * @author George Ziogas AEM: 1461
 */
public class IstorikoPelath implements Serializable
{
    private String mera;
    private String evrhmata;

    public IstorikoPelath (){}

    public IstorikoPelath (String histMera, String histEvrhmata)
    {
        mera = histMera;
        evrhmata = histEvrhmata;
    }

    public String getDate()
    {
        return mera;
    }

    public String getDetails()
    {
        return evrhmata;
    }

    //Emfanish istorikou
    public String showEvrhmata() //Xrhsh buffer gia kalyterh diaxeirhsh symvoloseiras
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append(mera + " -- " + evrhmata + "\n");
        return buffer.toString();
    }

}
