/*
 * H klash Atomo, prwth ierarxika, gia tis ypoklaseis twn atomwn
 * pelatwn,giatrwn,grammatewn
 */
package project2010;

import java.io.Serializable;

/**
 * ERGASIA ANAPTYKSHS EFARMOGHS SYNERGEIOY AYTOKINHTWN
 * @author George Ziogas AEM: 1461
 */
public class Atomo implements Serializable
{
    private String name;
    private String surname;


    //Constructors
    public Atomo(){
        name = "(κενό)";
        surname = "(κενό)";
    }

    public Atomo(String nName, String sName)
    {
        name = nName;
        surname = sName;
    }

    //Methodoi klasshs atomou
    public void setName(String nName){
        name = nName;
    }

    public void setSurname(String sName){
        surname = sName;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }
}
