/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project2010;

import java.io.*;

/**
 * ERGASIA ANAPTYKSHS EFARMOGHS SYNERGEIOY AYTOKINHTWN
 * @author George Ziogas AEM: 1461
 */


public class carCheck implements Serializable
{
   private  String mmera, wwra, ccheckType, ttechName, ttechSurname;

   public carCheck(String mera, String wra, String checkType, String techName, String techSurname)
   {
        mmera = mera;
        wwra = wra;
        ccheckType = checkType;
        ttechName = techName;
        ttechSurname = techSurname;
   }

   public String getHmeraErgasias()
   {
       return mmera;
   }

   public String getWraErgasias()
   {
       return wwra;
   }

   public String getEidosErgasias()
   {
       return ccheckType;
   }

   public String getTechName()
   {
       return ttechName;
   }
   public String getTechSurname()
   {
       return ttechSurname;
   }

   public String showKataxwrhshErgasias()
   {
        StringBuffer lista = new StringBuffer();
        lista.append("--------------------------------------------------------");
        lista.append("\n");
        lista.append("Ημέρα(ΗΗ/ΜΜ/ΧΧΧΧ): " + mmera);
        lista.append("\n");
        lista.append("Ώρα(ΩΩ:ΛΛ): " + wwra);
        lista.append("\n");
        lista.append("Είδος εργασίας αυτοκινήτου: " + ccheckType);
        lista.append("\n");
        lista.append("Υπεύθυνος τεχνικός εργασίας: " + ttechName + " " + ttechSurname);
        lista.append("\n");
        //lista.append("------------------------------------------------------\n");
        return lista.toString();
    }
}
