/*
 * H kyria klassh gia oles tis leitoyrgies ths efarmoghs
 * synergeiou aytokinhtwn.
 */

package project2010;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.*;


import javax.swing.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



/**
 * ERGASIA ANAPTYKSHS EFARMOGHS SYNERGEIOY AYTOKINHTWN
 * @author George Ziogas AEM: 1461
 */
public class TechJob {

//Listes typou Pelaths-Texnikos-Grammateas
//Listes eggegrammenwn atomwn sthn efarmogh (pelates-texnikoi-grammateis)
public static List<Pelaths> listaPelatwn = new ArrayList<Pelaths>();
public static List<Texnikos> listaTexnikwn = new ArrayList<Texnikos>();
public static List<Grammateas> listaGrammatewn = new ArrayList<Grammateas>();
public static List<hmerolTech> hmerologioTexnikou = new ArrayList<hmerolTech>();
//Proswrinh lista hmerologiou texnikou gia thn euresh toy eidoys ergasias
public static List<hmerolTech> tempHmerolTech = new ArrayList<hmerolTech>();
public static List<carCheck> listaErgasiwnCar = new ArrayList<carCheck>();
public static List<IstorikoPelath> istoriko = new ArrayList<IstorikoPelath>();

//-----------------------------------------------------------------//
//-----------------------------------------------------------------//

    //Methodoi diaxeirhshs fortoshs/apothikeyshs arxeiwn
    public void Load()
    {        
        loadTexnikos("texnikoi.bin");
        loadGrammateas("grammateis.bin");
        loadPelaths("pelates.bin");
    }

    public void Save()
    {
        saveTexnikos("texnikoi.bin");
        saveGrammateas("grammateis.bin");
        savePelaths("pelates.bin");
    }
    
    
    //Methodoi load/save arxeiwn Texnikwn
    public void loadTexnikos(String fileName)
    {
        //Dhlwsh revmatos eisodou antikeimenou gia antikeimeno typoy Texnikos
        ObjectInputStream oisTech = null;

        //Diaxeirish exceptions gia thn fortwsh toy arxeioy.
        try {

            //Dhmiourgia revmatos eisodou antikeimenwn gia antikeimeno typou
            //Texnikos.
            oisTech = new ObjectInputStream(new FileInputStream(fileName));

            //Kathe antikeimeno typou Object, einai yperklassh olwn twn antikeimenwn
            Object obj = null;
            
            //Metavivash twn antikeimenwn typoy "Texnikos" sto antikeimeno obj
            //apo thn anagnwsh toy arxeiou.
            //kai sth synexeia kathe antikeimeno prostithetai sthn listaTexnikwn
            while (((obj = oisTech.readObject()) != null))
            {
                if (obj instanceof Texnikos)
                {
                    listaTexnikwn.add((Texnikos)obj);
                }
            }

        //Diaxeirhsh exceptions
        }catch (Exception ex)//Genikh ekseraish
        {
           // System.out.println("Σφαλμα στην αναγνωση του αρχειου.");
        } finally {
            //Kleisimo toy revmatos eisodou antikeimenou oisTech
            try {
                if (oisTech != null) {
                    oisTech.close();
                }
            }catch (Exception ex)//Genikh ekseraish
            {
             // System.out.println("Σφαλμα στην αναγνωση του αρχειου.");
            }
        }
    }

    public void saveTexnikos(String fileName)
    {

        //Dhlwsh revmatos eksodou antikeimenou gia antikeimeno typoy Texnikos
        ObjectOutputStream oosTech = null;

        //Diaxeirish exceptions gia thn apothikeysh toy arxeioy.
        try {

            //Dhmiourgia revmatos eksodou antikeimenwn gia antikeimeno typou
            //Texnikos.
            oosTech = new ObjectOutputStream(new FileOutputStream(fileName));
            int i;
            for(i=0;i<listaTexnikwn.size();i++)
            {
                //eggrafh kathe antikeimenou typou Texnikos apo thn lista
                // "listaTexnikwn".
                oosTech.writeObject(listaTexnikwn.get(i));
            }

        }  catch (IOException ex)
        {
            ex.printStackTrace();
        } finally
        {
            //Kleisimo toy revmatos eksodou antikeimenou oosTech
            try {
                if (oosTech != null)
                {
                    oosTech.flush();
                    oosTech.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }



    //Methodoi load/save arxeiwn Grammatewn
    public void loadGrammateas(String fileName)
    {
        //Dhlwsh revmatos eisodou antikeimenou gia antikeimeno typoy Grammateas
        ObjectInputStream oisSecr = null;

        try {
            //Dhmiourgia revmatos eisodou antikeimenwn gia antikeimeno typou
            //Grammateas.
            oisSecr = new ObjectInputStream(new FileInputStream(fileName));

            //Kathe antikeimeno typou Object, einai yperklassh olwn twn antikeimenwn
            Object obj = null;

            //Metavivash twn antikeimenwn typoy "Grammateas" sto antikeimeno obj
            //apo thn anagnwsh toy arxeiou.
            //kai sth synexeia kathe antikeimeno prostithetai sthn listaGrammatewn
            while (((obj = oisSecr.readObject()) != null))
            {
                if (obj instanceof Grammateas)
                {
                    listaGrammatewn.add((Grammateas)obj);
                }
            }


        //Diaxeirhsh exceptions
        }catch (Exception ex)//Genikh ekseraish
        {
           // System.out.println("Σφαλμα στην αναγνωση του αρχειου.");
        } finally {
            //Kleisimo toy revmatos eisodou antikeimenou oisSecr
            try {
                if (oisSecr != null) {
                    oisSecr.close();
                }
            } /*catch (IOException ex) {
                ex.printStackTrace();
            }*/catch (Exception ex)//Genikh ekseraish
            {
                // System.out.println("Σφαλμα στην αναγνωση του αρχειου.");
            }
            }
    }

    public void saveGrammateas(String fileName)
    {

        //Dhlwsh revmatos eksodou antikeimenou gia antikeimeno typoy Grammateas
        ObjectOutputStream oosSecr = null;

        //Diaxeirish exceptions gia thn apothikeysh toy arxeioy.
        try {

            //Dhmiourgia revmatos eksodou antikeimenwn gia antikeimeno typou
            //Grammateas.
            oosSecr = new ObjectOutputStream(new FileOutputStream(fileName));
            int i;
            for(i=0;i<listaGrammatewn.size();i++)
            {
                //eggrafh kathe antikeimenou typou Grammateas apo thn lista
                // "listaGrammatewn".
                oosSecr.writeObject(listaGrammatewn.get(i));
            }

        }catch (IOException ex)
        {
            ex.printStackTrace();
        } finally
        {
            //Kleisimo toy revmatos eksodou antikeimenou oosSecr
            try {
                if (oosSecr != null)
                {
                    oosSecr.flush();
                    oosSecr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }



    //Methodoi load/save arxeiwn Pelatwn
    public void loadPelaths(String fileName)
    {
        //Dhlwsh revmatos eisodou antikeimenou gia antikeimeno typoy Pelaths
        ObjectInputStream oisCust = null;

        try {
            //Dhmiourgia revmatos eisodou antikeimenwn gia antikeimeno typou
            //Pelaths.
            oisCust = new ObjectInputStream(new FileInputStream(fileName));

            //Kathe antikeimeno typou Object, einai yperklassh olwn twn antikeimenwn
            Object obj = null;

            //Metavivash twn antikeimenwn typoy "Pelaths" sto antikeimeno obj
            //apo thn anagnwsh toy arxeiou.
            //kai sth synexeia kathe antikeimeno prostithetai sthn listaPelatwn
            while (((obj = oisCust.readObject()) != null))
            {
                if (obj instanceof Pelaths)
                {
                    listaPelatwn.add((Pelaths)obj);
                }
            }


        //Diaxeirhsh exceptions
        } catch (Exception ex)//Genikh ekseraish
        {
           // System.out.println("Σφαλμα στην αναγνωση του αρχειου.");
        } finally {
            //Kleisimo toy revmatos eisodou antikeimenou oisCust
            try {
                if (oisCust != null) {
                    oisCust.close();
                }
            } /*catch (IOException ex) {
                ex.printStackTrace();
            }*/catch (Exception ex)//Genikh ekseraish
            {
                // System.out.println("Σφαλμα στην αναγνωση του αρχειου.");
            }
        }
    }

    public void savePelaths(String fileName)
    {

        //Dhlwsh revmatos eksodou antikeimenou gia antikeimeno typoy Pelaths
        ObjectOutputStream oosCust = null;

        //Diaxeirish exceptions gia thn apothikeysh toy arxeioy.
        try {

            //Dhmiourgia revmatos eksodou antikeimenwn gia antikeimeno typou
            //Pelaths.
            oosCust = new ObjectOutputStream(new FileOutputStream(fileName));
            int i;
            for(i=0;i<listaPelatwn.size();i++)
            {
                //eggrafh kathe antikeimenou typou Pelaths apo thn lista
                // "listaPelatwn".
                oosCust.writeObject(listaPelatwn.get(i));
            }

        } catch (IOException ex)
        {
            ex.printStackTrace();
        } finally
        {
            //Kleisimo toy revmatos eksodou antikeimenou oosCust
            try {
                if (oosCust != null)
                {
                    oosCust.flush();
                    oosCust.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

//-----------------------------------------------------------------//

    //Methodoi load/save arxeiwn hmerologio twn texnikwn
    public static void apothikeyshHmerolTexnikou(Texnikos tech)
    {

        //Dhlwsh revmatos eksodou antikeimenou gia antikeimeno typoy hmerolTech
        ObjectOutputStream oosHmerolTech = null;

        //Diaxeirish exceptions gia thn apothikeysh toy arxeioy.
        try {

            //Dhmiourgia revmatos eksodou antikeimenwn gia antikeimeno typou
            //hmerolTech, pros to arxeio "hmerol_.....".
            oosHmerolTech = new ObjectOutputStream(new FileOutputStream("hmerol_" +
                    tech.getName() + "_" +tech.getSurname() +".bin" ));

            int i;
            for(i=0;i<hmerologioTexnikou.size();i++)
            {
                //eggrafh kathe antikeimenou typou hmerolTech apo thn lista
                // "hmerologioTexnikou".
                oosHmerolTech.writeObject(hmerologioTexnikou.get(i));
            }        

        }catch (Exception ex) // Genikh eksairesh
        {
                // System.out.println("Σφαλμα στην αναγνωση του αρχειου.");
        }finally
        {
            //Kleisimo toy revmatos eksodou antikeimenou oosHmerolTech
            try {
                if (oosHmerolTech != null) {
                    oosHmerolTech.flush();
                    oosHmerolTech.close();
                    //hmerologioTexnikou.clear();
                }
            } catch (Exception ex) // Genikh eksairesh
            {
                // System.out.println("Σφαλμα στην αναγνωση του αρχειου.");
            }
        }
    }

    public static List<hmerolTech> fortoshHmerolTexnikou(Texnikos tech)
    {

        //Dhlwsh revmatos eisodou antikeimenou gia antikeimeno typoy hmerolTech
        ObjectInputStream oisHmerolTech = null;
        List<hmerolTech> hmerologio = new ArrayList<hmerolTech>();

        try {

            //Dhmiourgia revmatos eisodou antikeimenwn gia antikeimeno typou
            //hmerolTech.
            oisHmerolTech = new ObjectInputStream(new FileInputStream("hmerol_" +
                    tech.getName() + "_" +tech.getSurname() +".bin" ));


            //Kahte antikeimeno typou Object, einai yperklassh olwn twn antikeimenwn
            Object obj = null;

            //Metavivash twn antikeimenwn typoy "hmerolTech" sto antikeimeno obj
            //apo thn anagnwsh toy arxeiou.
            //kai sth synexeia kathe antikeimeno prostithetai sthn lista hmerologio
            while ((obj = oisHmerolTech.readObject()) != null)
            {
                if (obj instanceof hmerolTech)
                {
                    hmerologio.add((hmerolTech)obj);
                }
            }


        } catch(Exception ex)// Genikh eksairesh
        {
            //diaxeirhsh exception
        }finally {
            //Close the ObjectInputStream
            //Kleisimo toy revmatos eisodou antikeimenou oisHmerolTech
            try {
                if (oisHmerolTech != null) {
                    oisHmerolTech.close();
                }
            } catch (Exception ex) // Genikh eksairesh
            {
                // System.out.println("Σφαλμα στην αναγνωση του αρχειου.");
            }
        }
        return hmerologio;
    }


//-----------------------------------------------------------------//
//-----------------------------------------------------------------//
    public static void eggrafhPelatwn() throws IOException
    {
        //Dhmioyrgia antikeimenou Pelath
        Pelaths pelaths ;
    
        //Dhmioyrgia arxeiwn stoixeiwn kai istorikoy gia kathe pelath ksexwrista
        File fileCust;
        File fileHist;
        int flag = 0;

        int operation;
        String name,surname,thlefwno,odos,asfForeas;

        //Grafiko perivallon
        //Parathyrakia eisagwghs stoixeiwn typoy erwthshs
        do{
            name = JOptionPane.showInputDialog(null, "Όνομα", "Εισαγωγή πελάτη",
                               JOptionPane.QUESTION_MESSAGE);

            surname = JOptionPane.showInputDialog(null, "Επώνυμο", "Εισαγωγή πελάτη",
                            JOptionPane.QUESTION_MESSAGE);

            //Elegxos yparkshs toy pelath            
            if(eureshPelath(name,surname)!=null)
            {
                 flag=1;
                 Object[] options = {"Συνέχεια", "Ακύρωση"};

                 //Dhmiourgia menu epiloghs, gia epanalhpsh eisagwghs, h akyrwsh
                 operation = JOptionPane.showOptionDialog(null,
                         "Ο πελάτης αυτός υπάρχει ήδη!\nΕισάγετε νέο πελάτη...",
                         "Σφάλμα", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
                         null, options, options[1]);


                 if (operation == JOptionPane.NO_OPTION)
                {
                    //Eksodos xwris apothikeysh
                    return;

                }
            }else flag=0;

           }while(flag==1);


            thlefwno = JOptionPane.showInputDialog(null, "Τηλέφωνο", "Εισαγωγή πελάτη",
                                JOptionPane.QUESTION_MESSAGE);

            odos = JOptionPane.showInputDialog(null, "Οδός", "Εισαγωγή πελάτη",
                                JOptionPane.QUESTION_MESSAGE);

            asfForeas = JOptionPane.showInputDialog(null, "Ασφαλιστικός φορέας", "Εισαγωγή πελάτη",
                                JOptionPane.QUESTION_MESSAGE);
            
            

                             
            //Eisagwgh stoixeiwn sto antikeimeno toy pelath
            pelaths = new Pelaths(name, surname, thlefwno, odos, asfForeas);


            //Mhnyma epivevaiwshs gia OK h akyrwsh ths diadikasias
            int result = JOptionPane.showConfirmDialog(null, pelaths.ShowPelathsDetails(),
                                    "Επιβεβαίωση;", JOptionPane.OK_CANCEL_OPTION);


            //Mhnyma akyrwshs - Dhmioyrgia arxeiwn me to onoma toy pelath
            if(result == JOptionPane.CANCEL_OPTION)
            {
                //JOptionPane.showMessageDialog(null, "Ακυρώθηκε η διαδικασία εισαγωγής πελάτη!");
                JOptionPane.showMessageDialog(null, "Ακυρώθηκε η διαδικασία εισαγωγής πελάτη!",
                                            "Ακύρωση", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                listaPelatwn.add(pelaths);
                fileCust = new File("carcheck_" + pelaths.getName() +"_"+ pelaths.getSurname() +".bin");
                fileCust.createNewFile();
                fileHist = new File("istoriko_" + pelaths.getName() +"_"+ pelaths.getSurname() +".bin" );
                fileHist.createNewFile();
            }
            
    }

    public void deletePelaths()
    {
        
        String name = JOptionPane.showInputDialog(null, "Όνομα", "Διαγραφή Πελάτη",
                JOptionPane.QUESTION_MESSAGE);
        String surName = JOptionPane.showInputDialog(null, "Επώνυμο", "Διαγραφή Πελάτη",
                JOptionPane.QUESTION_MESSAGE);

        Pelaths temp;

        //Diagnwstika mhnymata kata thn diagrafh pelath, kai entolh diagrafhs
        int i=0;
        int flagAns=1;
        for (i=0;i<listaPelatwn.size();i++)
        {
            temp = listaPelatwn.get(i);
            if (temp.getName().equals(name) && temp.getSurname().equals(surName))
            {

                int bye;
                Object[] options = {"OK", "Άκυρο"};

                bye = JOptionPane.showOptionDialog(null, "Διαγραφή πελάτη;",
                        "Διαγραφή...", JOptionPane.YES_NO_OPTION,  JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

                if (bye == JOptionPane.YES_OPTION)
                {
                     flagAns = 0;
                     //Diagrafh kataxwrhshs apo thn lista pelatwn
                     listaPelatwn.remove(i);

                     File f1 = new File("carcheck_" + name +"_"+ surName +".bin");
                     File f2 = new File("istoriko_" + name +"_"+ surName +".bin");

                     //Diagrafh arxeiwn pelatwn
                     f1.delete();
                     f2.delete();

                     savePelaths("pelates.bin");

                     JOptionPane.showMessageDialog(null,  "Διαγράφτηκε...",
                             "Διαγραφή", JOptionPane.INFORMATION_MESSAGE);
                     break;
                }

                if (bye == JOptionPane.NO_OPTION)
                {
                    flagAns = 0;
                    JOptionPane.showMessageDialog(null, "Ακύρωση διαγραφής...",
                            "Διαγραφή", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                break;
            }else
                flagAns = 1;

        }

        //Ektypwsh diagnwstikoy mhnymatos MH eureshs toy pelath pros diagrafh
        if(flagAns==1)
            JOptionPane.showMessageDialog(null, "Δεν υπάρχει πελάτης\nμε αυτό το όνομα!",
                                        "Δεν βρέθηκε...", JOptionPane.ERROR_MESSAGE);

        
    }
//-----------------------------------------------------------------//

    //Eggrafh texnikou
    public static void eggrafhTexnikwn()throws IOException
    {
        Texnikos technician;        
        String name, surname, eidikothta;
        int operation;

        int flag=0;
        do
        {
            name = JOptionPane.showInputDialog(null, "Όνομα Τεχνικού", "Εισαγωγή Τεχνικού",
                            JOptionPane.QUESTION_MESSAGE);

            surname = JOptionPane.showInputDialog(null, "Επώνυμο Τεχνικού", "Εισαγωγή Τεχνικού",
                            JOptionPane.QUESTION_MESSAGE);

            //Elegxos yparkshs toy texnikou me ayto to onoma            
            if(eureshTexnikou(name,surname)!=null)
            {
                 flag=1;
                 Object[] options = {"Συνέχεια", "Ακύρωση"};
                 
                 //Dhmiourgia menu epiloghs, gia epanalhpsh eisagwghs, h akyrwsh
                 operation = JOptionPane.showOptionDialog(null,
                         "Ο τεχνικός αυτός υπάρχει ήδη!\nΕισάγετε νέο τεχνικό...",
                         "Σφάλμα", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
                         null, options, options[1]);


                 if (operation == JOptionPane.NO_OPTION)
                {
                    //Eksodos xwris apothikeysh
                    return;

                }

            }else flag=0;

        }while(flag==1);


        eidikothta = JOptionPane.showInputDialog(null, "Ειδικότητα Τεχνικού", "Εισαγωγή Τεχνικού",
                            JOptionPane.QUESTION_MESSAGE);

        technician = new Texnikos(name, surname, eidikothta);

        //Mhnyma epivevaiwshs gia OK h akyrwsh ths diadikasias
        int result = JOptionPane.showConfirmDialog(null, technician.ShowTechDetails(),
                                    "Επιβεβαίωση;", JOptionPane.OK_CANCEL_OPTION);

        if(result == JOptionPane.CANCEL_OPTION)
        {               
                JOptionPane.showMessageDialog(null, "Ακυρώθηκε η διαδικασία εισαγωγής τεχνικού!",
                                            "Ακύρωση", JOptionPane.WARNING_MESSAGE);
        }else
        {
            eisagwghHmerolTech(technician);
            listaTexnikwn.add(technician);
            File newTech = new File("hmerol_" + technician.getName() + "_" +technician.getSurname() +".bin");
            newTech.createNewFile();
        }

    }


    public void deleteTexnikos()
    {

        String name = JOptionPane.showInputDialog(null, "Όνομα", "Διαγραφή Τεχνικού",
                JOptionPane.QUESTION_MESSAGE);
        String surName = JOptionPane.showInputDialog(null, "Επώνυμο", "Διαγραφή Τεχνικού",
                JOptionPane.QUESTION_MESSAGE);

        Texnikos temp;


        //Diagnwstika mhnymata kata thn diagrafh texnikwn, kai entolh diagrafhs
        int i=0;
        int flagAns=1;
        for (i=0;i<listaTexnikwn.size();i++)
        {
            temp = listaTexnikwn.get(i);
            if (temp.getName().equals(name) && temp.getSurname().equals(surName))
            {

                flagAns = 0;
                int bye;
                Object[] options = {"OK", "Άκυρο"};

                bye = JOptionPane.showOptionDialog(null, "Διαγραφή Τεχνικού;",
                        "Διαγραφή...", JOptionPane.YES_NO_OPTION,  JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

                if (bye == JOptionPane.YES_OPTION)
                {
                     
                     //Diagrafh kataxwrhshs apo thn lista texnikwn
                     listaTexnikwn.remove(i);

                     File f1 = new File("hmerol_" + name + "_" +surName +".bin");


                     //Diagrafh arxeiwn texnikwn
                     f1.delete();

                     saveTexnikos("texnikoi.bin");

                     JOptionPane.showMessageDialog(null,  "Διαγράφτηκε...",
                             "Διαγραφή", JOptionPane.INFORMATION_MESSAGE);
                     break;
                }

                if (bye == JOptionPane.NO_OPTION)
                {
                    
                    JOptionPane.showMessageDialog(null, "Ακύρωση διαγραφής...",
                            "Διαγραφή", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                break;

            }else
                flagAns = 1;

        }

        //Ektypwsh diagnwstikoy mhnymatos MH eureshs toy texnikoy pros diagrafh
        if(flagAns==1)
            JOptionPane.showMessageDialog(null, "Δεν υπάρχει τεχνικός\nμε αυτό το όνομα!",
                                        "Δεν βρέθηκε...", JOptionPane.ERROR_MESSAGE);


    }


    public static void eisagwghHmerolTech(Texnikos tech)
    {

        JOptionPane.showMessageDialog(null, "Εισαγωγή διαθέσιμων\nημερών τεχνικού...",
                                    "Καταχώρηση ημερολογίου...",  JOptionPane.INFORMATION_MESSAGE);



        int flag = 1;
        do
        {
            String mera = JOptionPane.showInputDialog(null, "Ημέρα ΗΗ/ΜΜ/ΧΧΧΧ",
                               "Εισαγωγή διαθέσιμης μέρας", JOptionPane.QUESTION_MESSAGE);

            int result ;
            result = JOptionPane.showConfirmDialog(null, "Εισαγωγή επιπλέον ημέρας;","Καταχώρηση ημερολογίου",
                                            JOptionPane.YES_NO_OPTION);

            if(result==JOptionPane.NO_OPTION)
            {
                tech.hmerologioDiathesimothtas.add(mera);                
                flag=0;
            }
            else if(result==JOptionPane.YES_OPTION)
            {
                
                tech.hmerologioDiathesimothtas.add(mera);
                flag=1;
            }
       
        }while(flag==1);

        apothikeyshHmerolTexnikou(tech);

    }


    //Emfanish hmerologiou me lista JList
    public static void showHmerolTexnikou()
    {


        int megethosListas = listaTexnikwn.size();

        String[] listaToArray = new String[megethosListas];

        int k=0;
        for(Texnikos tech : listaTexnikwn)
        {
            listaToArray[k] = tech.getName()+" "+tech.getSurname();
            k++;
        }

        //Dhlwseis
        JFrame frame = new JFrame("Επιλογή Τεχνικού-->Προβολή ημερολογίου");

        JLabel labelCust = new JLabel();
        JPanel panel = new JPanel();

        final JList selector = new JList(listaToArray);
        Font SansSerif = new Font ("SansSerif", Font.BOLD, 14);
        selector.setFont(SansSerif);
        selector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selector.setListData(listaToArray);
        selector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);



        JScrollPane ListScrollPane = new JScrollPane(selector);
        JSplitPane splitPane = new JSplitPane();
       
        final StringBuffer showBuffer = new StringBuffer();


        selector.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent event)
            {
                //Katharismos toy showBuffer gia kathe Select Event
                showBuffer.delete(0, showBuffer.length());

                int index2 = selector.getSelectedIndex();
                int index = event.getFirstIndex();


                hmerologioTexnikou = fortoshHmerolTexnikou(listaTexnikwn.get(index2));
                tempHmerolTech = fortoshHmerolTexnikou(listaTexnikwn.get(index2));
                Texnikos tempTech = listaTexnikwn.get(index2);
                StringBuffer sb1 = new StringBuffer();

                int i;
                int l=0;


                for(i=0;i<hmerologioTexnikou.size();i++)
                {
                    sb1.append(hmerologioTexnikou.get(i).showHmerolTechDetails());

                    String name = hmerologioTexnikou.get(i).getHmerolCustName();
                    String surname = hmerologioTexnikou.get(i).getHmerolCustSurname();
                    String mera = hmerologioTexnikou.get(i).getHmerolMera();
                    String wra = hmerologioTexnikou.get(i).getHmerolWra();

                    //Patenta eureshs toy eidoys ergasias mesw hmerologioTexnikou
                    Pelaths tempCust = eureshPelath(name,surname);

                    
                    String eidosErgasias = eureshEidousErgasias(tempCust, tempTech, l);
                    
                    sb1.append(" -- Είδος εργασίας: "+eidosErgasias+"\n");
                    l++;
                }

                JOptionPane.showMessageDialog(null,"Μέρα               Ώρα       Πελάτης"+
                        "\n------------------------------------------------------\n"
                        +sb1.toString(),
                        listaTexnikwn.get(index2).getName()+" "+listaTexnikwn.get(index2).getSurname(),
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        String TelikoShow = showBuffer.toString();

        labelCust = new JLabel(TelikoShow);
        labelCust.setVisible(true);


        panel.add(labelCust);
        panel.setVisible(true);

        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(ListScrollPane);
        splitPane.setRightComponent(panel);
        splitPane.setDividerLocation(150);
        splitPane.setVisible(true);
        splitPane.setContinuousLayout(true);
        splitPane.setName("Επιλογή Τεχνικού");

        frame.add(splitPane);
        frame.setResizable(false);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);       
        frame.setVisible(true);
    }

    public static String eureshEidousErgasias(Pelaths cust,Texnikos tech,int k)
    {
        
        String a=null,b=null,c=null,d=null;
        
        listaErgasiwnCar = fortoshErgasiwnAytokinhtou(cust);

        //xrhsh prosorinhs listas pros fortosh toy hmerologiou toy texnikou
       
        int i;
        for(i=0;i<tempHmerolTech.size();i++)
        {
             if(tempHmerolTech.get(i).getHmerolCustName().equals(cust.getName()) &&
                    tempHmerolTech.get(i).getHmerolCustSurname().equals(cust.getSurname()))
             {
                a=tempHmerolTech.get(i).getHmerolMera();
                b=tempHmerolTech.get(i).getHmerolWra();
                
                tempHmerolTech.remove(i);
                break;
             }
        }
        int counter = 0;
        int key=-1;
        int j=0;
        for(j=0;j<listaErgasiwnCar.size();j++)
        {
            if(listaErgasiwnCar.get(j).getTechName().equals(tech.getName()) &&
                   listaErgasiwnCar.get(j).getTechSurname().equals(tech.getSurname()))
            {
                c=listaErgasiwnCar.get(j).getHmeraErgasias();
                d=listaErgasiwnCar.get(j).getWraErgasias();
                if(a.equals(c) && b.equals(d))
                    key = j;
            }
            counter++;
        }
        return listaErgasiwnCar.get(key).getEidosErgasias();
    }

    public static void showHmerolTexnikouFreeDays()
    {


        int megethosListas = listaTexnikwn.size();

        String[] listaToArray = new String[megethosListas];

        int k=0;
        for(Texnikos tech : listaTexnikwn)
        {
            listaToArray[k] = tech.getName()+" "+tech.getSurname();
            k++;
        }

        //Dhlwseis
        JFrame frame = new JFrame("Επιλογή Τεχνικού-->Προβολή ημερολογίου");

        JLabel labelCust = new JLabel();
        JPanel panel = new JPanel();

        final JList selector = new JList(listaToArray);
        Font SansSerif = new Font ("SansSerif", Font.BOLD, 14);
        selector.setFont(SansSerif);
        selector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selector.setListData(listaToArray);
        selector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);



        JScrollPane ListScrollPane = new JScrollPane(selector);
        JSplitPane splitPane = new JSplitPane();

     
        final StringBuffer showBuffer = new StringBuffer();


        selector.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent event)
            {
                //Katharismos toy showBuffer gia kathe Select Event
                showBuffer.delete(0, showBuffer.length());

                int index2 = selector.getSelectedIndex();
                int index = event.getFirstIndex();

               
                StringBuffer sb1 = new StringBuffer();
                int k;

                
                    int days;
                    days = listaTexnikwn.get(index2).hmerologioDiathesimothtas.size();
                    for(k=0; k<days; k++)
                    {
                        sb1.append(listaTexnikwn.get(index2).hmerologioDiathesimothtas.get(k));
                        sb1.append("\n");
                    }                   

                JOptionPane.showMessageDialog(null,
                        "Διαθέσιμες μέρες\n" + "---------------------------\n" + sb1.toString(),
                        listaTexnikwn.get(index2).getName()+" "+listaTexnikwn.get(index2).getSurname(),
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        String TelikoShow = showBuffer.toString();

        labelCust = new JLabel(TelikoShow);
        labelCust.setVisible(true);

        panel.add(labelCust);
        panel.setVisible(true);

        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(ListScrollPane);
        splitPane.setRightComponent(panel);
        splitPane.setDividerLocation(150);
        splitPane.setVisible(true);
        splitPane.setContinuousLayout(true);
        splitPane.setName("Επιλογή Τεχνικού");

        frame.add(splitPane);
        frame.setResizable(false);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);    
        frame.setVisible(true);
    }


    //Emfanish hmerologiou xwris lista JList
    public static void showHmerolTexnikouNL()
    {
        Texnikos tech = null;

            String techName = JOptionPane.showInputDialog(null, "Όνομα", "Εμφάνιση ημερολογίου τεχνικού",
                               JOptionPane.QUESTION_MESSAGE);
            String techSurname = JOptionPane.showInputDialog(null, "Επώνυμο", "Εμφάνιση ημερολογίου τεχνικού",
                               JOptionPane.QUESTION_MESSAGE);

            tech = eureshTexnikou(techName, techSurname);
            if(tech==null)
            {
                JOptionPane.showMessageDialog(null, "Δεν υπάρχει τεχνικός\nμε αυτό το όνομα!",
                                    "Δεν βρέθηκε...", JOptionPane.ERROR_MESSAGE);
                return;
            }


        hmerologioTexnikou = fortoshHmerolTexnikou(tech);


        StringBuffer sb1 = new StringBuffer();
        int i;

        for(i=0;i<hmerologioTexnikou.size();i++)
        {
            sb1.append(hmerologioTexnikou.get(i).showHmerolTechDetails());
            sb1.append("\n");
        }


        JOptionPane.showMessageDialog(null, sb1.toString(),
                techName+" "+techSurname,
                JOptionPane.INFORMATION_MESSAGE);
    }

//-----------------------------------------------------------------//

    //Eggrafh grammatews
    public static void eggrafhGrammatewn()
    {
        Grammateas secretary;
        String name, surname;
        int flag = 0;
        int operation;

        do
        {
            name = JOptionPane.showInputDialog(null, "Όνομα Γραμματέως", "Εισαγωγή Γραμματέως",
                            JOptionPane.QUESTION_MESSAGE);

            surname = JOptionPane.showInputDialog(null, "Επώνυμο Γραμματέως", "Εισαγωγή Γραμματέως",
                            JOptionPane.QUESTION_MESSAGE);
            
             //Elegxos yparkshs toy texnikou me ayto to onoma
            if(eureshGrammatea(name, surname)!=null)
            {
               flag=1;
                 Object[] options = {"Συνέχεια", "Ακύρωση"};

                 //Dhmiourgia menu epiloghs, gia epanalhpsh eisagwghs, h akyrwsh
                 operation = JOptionPane.showOptionDialog(null,
                         "Ο/Η γραμματέας αυτός υπάρχει ήδη!\nΕισάγετε νέο/α γραμματέα...",
                         "Σφάλμα", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
                         null, options, options[1]);

                 if (operation == JOptionPane.NO_OPTION)
                {
                    //Eksodos xwris apothikeysh
                    return;
                }
            }else flag = 0;

        }while(flag==1);


        secretary = new Grammateas(name, surname);

        //Mhnyma epivevaiwshs gia OK h akyrwsh ths diadikasias
        int result = JOptionPane.showConfirmDialog(null, secretary.ShowSecrDetails(),
                                    "Επιβεβαίωση;", JOptionPane.OK_CANCEL_OPTION);

        if(result == JOptionPane.CANCEL_OPTION)
        {
            JOptionPane.showMessageDialog(null, "Ακυρώθηκε η διαδικασία εισαγωγής γραμματέως!",
                                            "Ακύρωση", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            listaGrammatewn.add(secretary);
        }
    }


    public void deleteGrammateas()
    {

        String name = JOptionPane.showInputDialog(null, "Όνομα", "Διαγραφή Γραμματέα",
                JOptionPane.QUESTION_MESSAGE);
        String surName = JOptionPane.showInputDialog(null, "Επώνυμο", "Διαγραφή Γραμματέα",
                JOptionPane.QUESTION_MESSAGE);

        Grammateas temp;


        //Diagnwstika mhnymata kata thn diagrafh grammatewn, kai entolh diagrafhs
        int i=0;
        int flagAns=1;
        for (i=0;i<listaGrammatewn.size();i++)
        {
            temp = listaGrammatewn.get(i);
            if (temp.getName().equals(name) && temp.getSurname().equals(surName))
            {

                int bye;
                Object[] options = {"OK", "Άκυρο"};

                bye = JOptionPane.showOptionDialog(null, "Διαγραφή Γραμματέα;",
                        "Διαγραφή...", JOptionPane.YES_NO_OPTION,  JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

                if (bye == JOptionPane.YES_OPTION)
                {
                     flagAns = 0;
                     //Diagrafh kataxwrhshs apo thn lista pelatwn
                     listaGrammatewn.remove(i);

                     saveGrammateas("grammateis.bin");

                     JOptionPane.showMessageDialog(null,  "Διαγράφτηκε...",
                             "Διαγραφή", JOptionPane.INFORMATION_MESSAGE);
                     break;
                }

                if (bye == JOptionPane.NO_OPTION)
                {
                    flagAns = 0;
                    JOptionPane.showMessageDialog(null, "Ακύρωση διαγραφής...",
                            "Διαγραφή", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                break;
            }else
                flagAns = 1;

        }

        //Ektypwsh diagnwstikoy mhnymatos MH eureshs toy grammatea pros diagrafh
        if(flagAns==1)
            JOptionPane.showMessageDialog(null, "Δεν υπάρχει γραμματέας\nμε αυτό το όνομα!",
                                        "Δεν βρέθηκε...", JOptionPane.ERROR_MESSAGE);


    }



//-----------------------------------------------------------------//
//-----------------------------------------------------------------//

    


    //-----------------------------------------------------------------//

    public void emfanishIstorikou()
    {
        String name = JOptionPane.showInputDialog(null, "Εμφάνιση ιστορικού", "Όνομα πελάτη",
                               JOptionPane.QUESTION_MESSAGE);
        String surname = JOptionPane.showInputDialog(null, "Εμφάνιση ιστορικού", "Επώνυμο πελάτη",
                               JOptionPane.QUESTION_MESSAGE);
        Pelaths cust = null;

        cust = eureshPelath(name,surname);
        if(cust==null)
        {
            JOptionPane.showMessageDialog(null, "Δεν υπάρχει πελάτης\nμε αυτό το όνομα!",
                             "Δεν βρέθηκε...", JOptionPane.ERROR_MESSAGE);
            return;
        }


        istoriko = anagnwshIstorikou(cust);


        StringBuffer buffer = new StringBuffer();
        int i;

        for(i=0;i<istoriko.size();i++)
        {
            buffer.append(istoriko.get(i).showEvrhmata());
        }

        JOptionPane.showMessageDialog(null,buffer.toString(), 
                cust.getName()+" "+cust.getSurname(), JOptionPane.INFORMATION_MESSAGE);


    }

    //2os tropos emfanishs istorikou me thn xrhsh ths JList
    public void emfanishIstorikou2()
    {
        int megethosListas = listaPelatwn.size();

        String[] listaToArray = new String[megethosListas];

        int k=0;
        for(Pelaths p : listaPelatwn)
        {
            listaToArray[k] = p.getName()+" "+p.getSurname();
            k++;
        }

        //Dhlwseis
        JFrame frame = new JFrame("Επιλογή Πελάτη-->Προβολή ιστορικού");

        JLabel labelCust = new JLabel();
        JPanel panel = new JPanel();

        final JList selector = new JList(listaToArray);
        Font SansSerif = new Font ("SansSerif", Font.BOLD, 14);
        selector.setFont(SansSerif);
        selector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selector.setListData(listaToArray);
        selector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        


        JScrollPane ListScrollPane = new JScrollPane(selector);
        JSplitPane splitPane = new JSplitPane();

        //StringBuffer showBuffer = new StringBuffer();
        final StringBuffer showBuffer = new StringBuffer();


        selector.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent event)
            {
                //Katharismos toy showBuffer gia kathe Select Event
                showBuffer.delete(0, showBuffer.length());
              
                int index2 = selector.getSelectedIndex();
                int index = event.getFirstIndex();

                istoriko = anagnwshIstorikou(listaPelatwn.get(index2));
                StringBuffer buffer = new StringBuffer();
                int i;

                for(i=0;i<istoriko.size();i++)
                {
                   buffer.append(istoriko.get(i).showEvrhmata());
                }

                JOptionPane.showMessageDialog(null,buffer.toString(),
                        listaPelatwn.get(index2).getName()+" "+listaPelatwn.get(index2).getSurname(),
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
       
        String TelikoShow = showBuffer.toString();
       
        labelCust = new JLabel(TelikoShow);
        
        labelCust.setVisible(true);



        panel.add(labelCust);
        panel.setVisible(true);

        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(ListScrollPane);
        splitPane.setRightComponent(panel);
        splitPane.setDividerLocation(150);
        splitPane.setVisible(true);
        splitPane.setContinuousLayout(true);
        splitPane.setName("Επιλογή Πελάτη");



        frame.add(splitPane);
      
        frame.setResizable(false);


        frame.setSize(500, 400);

        frame.setLocationRelativeTo(null);
        //frame.setAlwaysOnTop(true);
        frame.setVisible(true);

    }

//-----------------------------------------------------------------//
//-----------------------------------------------------------------//
//-----------------------------------------------------------------//
    //Eisagwgh neou texnikou elegxoy aytokinhtoy toy pelath

    public void neaErgasiaCar()
    {
        String custName, custSurname, techName, techSurname;
        String checkType, mera, wra;
        int flag = 0;
        int flag2 = 0;
        int operation;


        

        Pelaths cust;
        //Elegxos yparkshs pelatwn, gia programmatismo ths ergasias tous.
        do
        {
            custName = JOptionPane.showInputDialog(null, "Όνομα Πελάτη", 
                    "Προγραμματισμός νέας εργασίας.",
                            JOptionPane.QUESTION_MESSAGE);

            custSurname = JOptionPane.showInputDialog(null, "Επώνυμο Πελάτη", 
                    "Προγραμματισμός νέας εργασίας.",
                            JOptionPane.QUESTION_MESSAGE);

             //Elegxos yparkshs toy pelath me ayto to onoma


            cust = eureshPelath(custName, custSurname);
            if(cust==null)
            {
               flag=1;
                 Object[] options = {"Συνέχεια", "Ακύρωση"};

                 //Dhmiourgia menu epiloghs, gia epanalhpsh eisagwghs, h akyrwsh
                 operation = JOptionPane.showOptionDialog(null,
                         "Ο πελάτης αυτός δεν υπάρχει!\nΕισάγετε νέο πελάτη...",
                         "Σφάλμα", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
                         null, options, options[1]);

                 if (operation == JOptionPane.NO_OPTION)
                {
                    //Eksodos xwris apothikeysh
                    return;
                }
            }else flag = 0;

        }while(flag==1);

        checkType = JOptionPane.showInputDialog(null, "Είδος εργασίας αυτοκινήτου.",
                "Προγραμματισμός νέας εργασίας.", JOptionPane.QUESTION_MESSAGE);

        mera = JOptionPane.showInputDialog(null, "Ημέρα εργασίας αυτοκινήτου.\nΗΗ/ΜΜ/ΧΧΧΧ",
                "Προγραμματισμός νέας εργασίας.", JOptionPane.QUESTION_MESSAGE);

        wra = JOptionPane.showInputDialog(null, "Ώρα εργασίας αυτοκινήτου.\nΩΩ:ΛΛ",
                "Προγραμματισμός νέας εργασίας..", JOptionPane.QUESTION_MESSAGE);


        Texnikos tech;    
        do
        {
            techName = JOptionPane.showInputDialog(null, "Όνομα Τεχνικού",
                    "Προγραμματισμός νέας εργασίας.",
                            JOptionPane.QUESTION_MESSAGE);

            techSurname = JOptionPane.showInputDialog(null, "Επώνυμο Τεχνικού",
                    "Προγραμματισμός νέας εργασίας.",
                            JOptionPane.QUESTION_MESSAGE);

             //Anazhthsh texnikou gia ton programmatismo ths
            //ergasias toy parapanw pelath
            tech = eureshTexnikou(techName, techSurname);
            if(tech==null)
            {
               flag2=1;
                 Object[] options = {"Συνέχεια", "Έξοδος"};

                 //Dhmiourgia menu epiloghs, gia epanalhpsh eisagwghs, h akyrwsh
                 operation = JOptionPane.showOptionDialog(null,
                         "Ο τεχνικός αυτός δεν υπάρχει!\nΕισάγετε νέο τεχνικό...",
                         "Σφάλμα", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
                         null, options, options[1]);

                 if (operation == JOptionPane.NO_OPTION)
                {
                    //Eksodos xwris apothikeysh
                    return;
                }
            }else flag2 = 0;

        }while(flag2==1);

        if (cust!=null && tech!=null)
        {
            int exec;
            exec = eureshDiathesimothtasErgasias(tech,mera,wra);
            if (exec == 1)
            {
                hmerolTech hmerologioTech = new hmerolTech(mera, wra,
                        cust.getName(), cust.getSurname());
                carCheck elegxosAytokinhtoy = new carCheck(mera, wra,
                        checkType, tech.getName(), tech.getSurname());

                //Apothikeysh ergasiwn, kai hmerologiou texnikou
                apothikeyshErgasias(tech, cust, hmerologioTech, elegxosAytokinhtoy);
            }
        }
    }


    //Provolh twn ergasiwn enos sygkekrikmenou pelath
    public void provolhErgasiwnCar()
    {


        int megethosListas = listaPelatwn.size();

        String[] listaToArray = new String[megethosListas];

        int k=0;
        for(Pelaths p : listaPelatwn)
        {
            listaToArray[k] = p.getName()+" "+p.getSurname();
            k++;
        }

        //Dhlwseis
        JFrame frame = new JFrame("Επιλογή Πελάτη-->Προβολή εργασιών αυτοκινήτου");

        JLabel labelCust = new JLabel();
        JPanel panel = new JPanel();

        final JList selector = new JList(listaToArray);
        Font SansSerif = new Font ("SansSerif", Font.BOLD, 14);
        selector.setFont(SansSerif);
        selector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selector.setListData(listaToArray);
        selector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);



        JScrollPane ListScrollPane = new JScrollPane(selector);
        JSplitPane splitPane = new JSplitPane();

        //StringBuffer showBuffer = new StringBuffer();
        final StringBuffer showBuffer = new StringBuffer();


        selector.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent event)
            {
                //Katharismos toy showBuffer gia kathe Select Event
                showBuffer.delete(0, showBuffer.length());

                int index2 = selector.getSelectedIndex();
                int index = event.getFirstIndex();

                listaErgasiwnCar = fortoshErgasiwnAytokinhtou(listaPelatwn.get(index2));
                StringBuffer sb = new StringBuffer();
                int i;

                for(i=0;i<listaErgasiwnCar.size();i++)
                {
                   sb.append(listaErgasiwnCar.get(i).showKataxwrhshErgasias());
                }

                JOptionPane.showMessageDialog(null,
                    listaPelatwn.get(index2).getName()+" "+listaPelatwn.get(index2).getSurname()
                    + "\n" + sb.toString(), "Προβολή εργασιών",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });

        String TelikoShow = showBuffer.toString();

        labelCust = new JLabel(TelikoShow);

        labelCust.setVisible(true);



        panel.add(labelCust);
        panel.setVisible(true);

        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(ListScrollPane);
        splitPane.setRightComponent(panel);
        splitPane.setDividerLocation(150);
        splitPane.setVisible(true);
        splitPane.setContinuousLayout(true);
        splitPane.setName("Επιλογή Πελάτη");



        frame.add(splitPane);

        frame.setResizable(false);


        frame.setSize(500, 400);

        frame.setLocationRelativeTo(null);
        //frame.setAlwaysOnTop(true);
        frame.setVisible(true);

    }


    
    public void neaDiagnwshEurhmata()
    {     
        //Metatroph toy ArrayList se String[] pinaka megethoys antistoixou me
        //thn lista
        int megethosListas = listaPelatwn.size();


        String[] listaToArray = new String[megethosListas];

        int k=0;
        for(Pelaths p : listaPelatwn)
        {
            listaToArray[k] = p.getName()+" "+p.getSurname();
            k++;
        }

        //Dhlwseis
        JFrame frame = new JFrame("Επιλογή Πελάτη-->Εμφάνιση εργασιών");
        
        JLabel labelCust = new JLabel();
        JPanel panel = new JPanel();

        final JList selector = new JList(listaToArray);
        Font SansSerif = new Font ("SansSerif", Font.BOLD, 14);
        selector.setFont(SansSerif);
        selector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selector.setListData(listaToArray);
        selector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      

        JScrollPane ListScrollPane = new JScrollPane(selector);
        JSplitPane splitPane = new JSplitPane();
       
        final StringBuffer sb = new StringBuffer();


        selector.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent event)
            {
                //Katharismos toy showBuffer gia kathe Select Event
                sb.delete(0, sb.length());

                int index2 = selector.getSelectedIndex();
                int index = event.getFirstIndex();

                //Afoy epilextei o pelaths, emfanizontai oi ergasies poy exei
                findCustExamsForHistory(index2);
            }
        });
        
        String TelikoShow = sb.toString();      

        labelCust = new JLabel(TelikoShow);

        labelCust.setVisible(true);        
        panel.add(labelCust);
        panel.setVisible(true);

        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(ListScrollPane);
        splitPane.setRightComponent(panel);
        splitPane.setDividerLocation(150);
        splitPane.setVisible(true);
        splitPane.setContinuousLayout(true);
        splitPane.setName("Επιλογή Πελάτη");


        frame.add(splitPane);    
        frame.setResizable(false);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);    
        frame.setVisible(true);
    
    }
    
    
    public void findCustExamsForHistory(int index2)
    {
        //Metatroph toy ArrayList se String[] pinaka megethoys antistoixou me
        //thn lista
        final Pelaths cust = listaPelatwn.get(index2);

        //Fortwsh twn antistoixwn listwn pros epeksergsia kai apothikeysh
        istoriko = anagnwshIstorikou(cust);
        listaErgasiwnCar = fortoshErgasiwnAytokinhtou(cust);


        //Megethos lista ergasiwn twn pelatwn
        int megethosListas;
        megethosListas = listaErgasiwnCar.size();

        String[] listaToArray = new String[megethosListas];

        int k=0;
        for(carCheck cCheck : listaErgasiwnCar)
        {
            //if(hmerologioTexnikou.)
            listaToArray[k] = cCheck.getHmeraErgasias()+" -- "
                    +cCheck.getWraErgasias()+" -- "
                    +cCheck.getEidosErgasias();
            k++;
        }

        //Dhlwseis
        JFrame frame2 = new JFrame("Επιλογή εργασιας-->Εισαγωγή Διάγνωσης/Ευρημάτων εργασίας");
        
        JLabel labelCust = new JLabel();
        JPanel panel = new JPanel();

        final JList selector2 = new JList(listaToArray);
        Font SansSerif = new Font ("SansSerif", Font.BOLD, 14);
        selector2.setFont(SansSerif);
        selector2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selector2.setListData(listaToArray);

        JScrollPane ListScrollPane = new JScrollPane(selector2);
        JSplitPane splitPane = new JSplitPane();

        final StringBuffer sb = new StringBuffer();


        selector2.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent event)
            {
                //Katharismos toy showBuffer gia kathe Select Event
                sb.delete(0, sb.length());

                int index3 = selector2.getSelectedIndex();
                int index = event.getFirstIndex();

                //Metavivash toy antikeimenou carCheck apo thn listaErgasiwnCar
                //me thesi index3, sthn proswrinh tempCheck, typou carCheck.
                carCheck tempCheck = listaErgasiwnCar.get(index3);

                //Dhlwsh metavlhtwn String gia thn apothikeysh twn stoixeiwn
                String mera,wra,techName,techSurname,checkTypeCar;

                //Euresh stoixeiwn ths sygkekrimenhs ergasias, gia ton sygkekrimeno
                //pelath "cust" me index2 apo thn prohgoymenh JList
                mera = tempCheck.getHmeraErgasias();
                wra = tempCheck.getWraErgasias();
                techSurname = tempCheck.getTechSurname();
                techName = tempCheck.getTechName();
                checkTypeCar = tempCheck.getEidosErgasias();

                //Euresh toy texnikou symfwna me ta stoixeia poy phrame apo thn
                //listaErgasiwnCar, apo to stigmiotypo me index3
                Texnikos tech = eureshTexnikou(techName,techSurname);

                //Dhmiourgia proswrinou istorikou pelath
                IstorikoPelath tempIstoriko;

                //Eisagwgh eurhmatwn kai apotelesmatos ergasias
                String diagnwshElegxou;
                diagnwshElegxou =
                        JOptionPane.showInputDialog(null,cust.getName()+" "+cust.getSurname()+
                        "\nΕργασία: \n"+
                        mera+" -- "+wra+" -- "+checkTypeCar+" -- "+
                        techName+" "+techSurname+"\n\n"+
                        "Εισάγεται την διάγνωση/ευρήματα για την συγκεκριμένη Εξέταση.",
                        "Εισαγωγή διάγνωσης/ευρημάτων",
                        JOptionPane.QUESTION_MESSAGE);


                int k = 0;

                //Fortwsh hmerologiou toy sygkekrimenou texnikou apo thn sygkekrimenh
                //ergasia poy epilexthke pio panw apo thn JList.
                hmerologioTexnikou = fortoshHmerolTexnikou(tech);

                //Diasxhsh ths listas hmerologioTexnikou gia thn euresh kai afairesh
                //tou antistoixou stigmiotupou toy hmerologiou
                for(hmerolTech hmerolDel : hmerologioTexnikou)
                {
                    if(hmerolDel.getHmerolMera().equals(mera) && hmerolDel.getHmerolWra().equals(wra))
                    {
                        hmerologioTexnikou.remove(k);                        
                        break;
                    }
                    k++;
                }
                //Apothikeysh toy ananewmenou hmerologiou toy texnikou
                apothikeyshHmerolTexnikou(tech);


                //Dhmiourgia neou stigmiotypou istorikou pelath
                tempIstoriko = new IstorikoPelath(mera,diagnwshElegxou);
                //kai prosthikh sthn lista istorikou toy sygkekrimenou pelath
                istoriko.add(tempIstoriko);
                //Apothikeush ananewmenou istorikou toy pelath
                apothikeushIstorikou(cust);
                
              
                listaErgasiwnCar = fortoshErgasiwnAytokinhtou(cust);
                carCheck ergasia = null;
                //Euresh ths antistoixhs ergasias kai afairesh ths apo thn lista
                //ergasiwn
                ergasia = eureshErgasias(mera,wra,checkTypeCar,techName,techSurname);                
                listaErgasiwnCar.remove(ergasia);
                //Apothikeush ths ananewmenhs listas ergasiwn
                apothikeushErgasiwnAytokinhtou(cust);
            }
        });
        

        String TelikoShow = sb.toString();
       
        labelCust = new JLabel(TelikoShow);  
        labelCust.setVisible(true);
        
        panel.add(labelCust);
        panel.setVisible(true);

        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(ListScrollPane);
        splitPane.setRightComponent(panel);
        splitPane.setDividerLocation(400);
        splitPane.setVisible(true);
        splitPane.setContinuousLayout(true);
        splitPane.setName("Επιλογή Πελάτη");

        frame2.add(splitPane);
       
        frame2.setResizable(false);
        frame2.setSize(500, 400);

        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
        
     }


    public carCheck eureshErgasias(String mera,String wra,String checkType,String techName,String techSurname)
    {
        carCheck check = null;
        carCheck temp;
        int i;
        for(i=0;i<listaErgasiwnCar.size();i++)
        {
            temp = listaErgasiwnCar.get(i);
            if (temp.getHmeraErgasias().equals(mera) &&
                    temp.getWraErgasias().equals(wra) &&
                    temp.getEidosErgasias().equals(checkType) &&
                    temp.getTechName().equals(techName) &&
                    temp.getTechSurname().equals(techSurname))
                check = temp;
        }
        return check;
    }

    public static hmerolTech eureshHmerolTech(String mera,String wra)
    {
        hmerolTech hmerologio = null;
        hmerolTech tmp;
        int i;
        for (i=0;i<hmerologioTexnikou.size();i++)
        {
            tmp = hmerologioTexnikou.get(i);
            if (tmp.getHmerolMera().equals(mera) && tmp.getHmerolWra().equals(wra))
                hmerologio = tmp;
        }
        return hmerologio;
    }
    

    public int eureshDiathesimothtasErgasias(Texnikos tech, String mera, String wra)
    {
        int execute = 0;
        int i;
        int operation;
        int flag = 0;

        //Logikes metavlhtes elegxou
        boolean isChosen = false;//Metavlhth poy mas deixnei an exei epilxthei
                                 //kapoia mera

        boolean available = true;//Metavlhth poy mas deixnei an einai diathesimh
                                 //h wra poy exei epilexthei gia thn sygkekrimenh
                                 //mera

        //Lista me tis eleftheres meres toy kathe texnikou
        List<String> hmerologioTechFreeDays = new ArrayList<String>();
        hmerologioTechFreeDays = tech.hmerologioDiathesimothtas;

        int count1 = hmerologioTechFreeDays.size();

        for(i=0;i<count1;i++)
        {
            if (hmerologioTechFreeDays.get(i).equals(mera))
            {
                //Yparksh ths sygkekrimenhs meras stis diathesimes toy texnikou
                flag = 1;
            }
        }

        //Lista me tis desmevmenes meres(rantevou) toy texnikou, apo tis ergasies
        List<hmerolTech> hmerologioTechRandevou = new ArrayList<hmerolTech>();
        hmerologioTechRandevou = fortoshHmerolTexnikou(tech);

        int count2 = hmerologioTechRandevou.size();
        if(flag==0)
        {
          JOptionPane.showMessageDialog(null, "Ο τεχνικός "+tech.getName()+" "+tech.getSurname()+
                  ", δεν είναι διαθέσιμος\nτην επιλεγμένη μέρα.",
                  "Σφάλμα", JOptionPane.WARNING_MESSAGE);

        }
        else if(flag == 1)
        {
          for(i=0;i<count2;i++)
          {
              if(hmerologioTechRandevou.get(i).getHmerolMera().equals(mera))
              {
                  //Dhlwsh oti h mera einai epilegmenh apo kapoio allo rantevou
                   isChosen=true;
              }
          }

          if (isChosen == true)
          {
              for(i=0;i<hmerologioTechRandevou.size();i++)
              {
                  if(hmerologioTechRandevou.get(i).getHmerolMera().equals(mera)  &&
                          hmerologioTechRandevou.get(i).getHmerolWra().equals(wra))
                  {
                      JOptionPane.showMessageDialog(null, "Την μέρα "+mera+" και ώρα "+wra+" που επιλέξατε "+
                              "υπάρχει ήδη ραντεβού για εργασία.\n"+
                              "Δεν μπορείτε να προγραμματίσετε ραντεβου την συγκεκριμενη μέρα/ώρα...",
                              "Διαθεσιμότητα μέρας/ώρας", JOptionPane.WARNING_MESSAGE);
                      available = false;
                  }
              }
          }

          if (isChosen==true && available == true)
          {

              Object[] options = {"Συνέχεια?", "Έξοδος"};

              //Dhmiourgia menu epiloghs, gia epanalhpsh eisagwghs, h akyrwsh
              operation = JOptionPane.showOptionDialog(null, "Δεν υπάρχει κανένα ραντεβού\n" +
                       "την ώρα "+wra+" της ημέρας "+mera+".\n"+
                       "Η εργασία σας προγραμματίστηκε για: "+mera+" στις "+wra,
                       "Διαθεσιμότητα μέρας/ώρας", JOptionPane.YES_NO_OPTION,
                       JOptionPane.QUESTION_MESSAGE,
                       null, options, options[1]);
              if (operation == JOptionPane.YES_OPTION)
              {
                    execute = 1;
              }
              if (operation == JOptionPane.NO_OPTION)
              {
                execute = 0;
              }
          }

          if (isChosen == false)
          {

              Object[] options = {"Συνέχεια?", "Έξοδος"};

              operation = JOptionPane.showOptionDialog(null, "Η μέρα "+mera+" είναι διαθέσιμη "+
                      "όλες τις ώρες."+"\nΗ εργασία σας προγραμματίστηκε για: "+mera+" στις "+wra,
                      "Διαθεσιμότητα μέρας/ώρας", JOptionPane.YES_NO_OPTION,
                       JOptionPane.QUESTION_MESSAGE,
                       null, options, options[1]);
              if (operation == JOptionPane.YES_OPTION)
              {
                    execute = 1;
              }
              if (operation == JOptionPane.NO_OPTION)
              {
                    execute = 0;
              }
          }
        }
        return execute;
    }


    public void apothikeyshErgasias(Texnikos tech,Pelaths cust,hmerolTech hmTech,carCheck cCheck)
    {
        hmerologioTexnikou = fortoshHmerolTexnikou(tech);
        listaErgasiwnCar = fortoshErgasiwnAytokinhtou(cust);

        hmerologioTexnikou.add(hmTech);
        listaErgasiwnCar.add(cCheck);

        apothikeyshHmerolTexnikou(tech);
        apothikeushErgasiwnAytokinhtou(cust);
    }


     public static void apothikeushErgasiwnAytokinhtou(Pelaths cust)
    {

        //Dhlwsh revmatos eksodou antikeimenou gia antikeimeno typoy carCheck
        ObjectOutputStream oosErgasia = null;


        //Dhmiourgia revmatos eksodou antikeimenwn gia antikeimeno typou
        //carCheck
        try
        {
            oosErgasia = new ObjectOutputStream(new FileOutputStream("carcheck_" +
                    cust.getName() +"_"+ cust.getSurname() +".bin" ));

            for(int i=0;i<listaErgasiwnCar.size();i++)
            {

                //eggrafh kathe antikeimenou typou Pelaths apo thn lista
                // "carCheck".

                oosErgasia.writeObject(listaErgasiwnCar.get(i));
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        } finally
        {
            //Kleisimo toy revmatos eksodou antikeimenou oosErgasia
            try
            {
                if (oosErgasia != null)
                {
                    oosErgasia.flush();
                    oosErgasia.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public static List<carCheck> fortoshErgasiwnAytokinhtou(Pelaths cust)
    {

        //Dhlwsh revmatos eisodou antikeimenou gia antikeimeno typoy carCheck
        ObjectInputStream oisErgasia = null;


        List<carCheck> elegxosAytokinhtoy = new ArrayList<carCheck>();

        //Dhmiourgia revmatos eisodou antikeimenwn gia antikeimeno typou
        //carCheck
        try
        {
            oisErgasia = new ObjectInputStream(new FileInputStream("carcheck_" +
                    cust.getName() + "_" + cust.getSurname() +".bin" ));

            //Kathe antikeimeno typou Object, einai yperklassh olwn twn antikeimenwn
            Object obj = null;

            //Metavivash twn antikeimenwn typoy "istorikoPelath" sto antikeimeno obj
            //apo thn anagnwsh toy arxeiou.
            //kai sth synexeia kathe antikeimeno prostithetai sthn lista history
            while ((obj = oisErgasia.readObject()) != null) {

                if (obj instanceof carCheck) {

                    elegxosAytokinhtoy.add((carCheck)obj);
                }
            }

        } catch (Exception ex)
        {
            //Diaxeirhsh exception
            //System.out.println("Σφαλμα στην αναγνωση του αρχειου.");
        }
        finally {
            //Kleisimo toy revmatos eksodou antikeimenou oisErgasia
            try {
                if (oisErgasia != null) {
                    oisErgasia.close();
                }
            }catch (Exception ex)
            {
                 //Diaxeirhsh exception
                // System.out.println("Σφαλμα στην αναγνωση του αρχειου.");
            }
        }
        return elegxosAytokinhtoy;
    }



//-----------------------------------------------------------------//
//-----------------------------------------------------------------//
//-----------------------------------------------------------------//


//KWDIKAS GIA DIORTHOSEIS

    public static void apothikeushIstorikou(Pelaths customer)
    {
        //Dhlwsh revmatos eksodou antikeimenou gia antikeimeno typoy istorikoPelath
        ObjectOutputStream oosHist = null;

         //Diaxeirish exceptions gia thn apothikeysh toy arxeioy.
        try {

            //Dhmiourgia revmatos eksodou antikeimenwn gia antikeimeno typou
            //istorikoPelath.
            oosHist = new ObjectOutputStream(new FileOutputStream("istoriko_"
                                + customer.getName() + "_" + customer.getSurname() +".bin" ));

            int i;
            for(i=0;i<istoriko.size();i++)
            {

                //eggrafh kathe antikeimenou typou Pelaths apo thn lista
                // "istorikoPelath".
                oosHist.writeObject(istoriko.get(i));
            }


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally
        {
            try {
                //Kleisimo toy revmatos eksodou antikeimenou oosHist
                if (oosHist != null) {
                    oosHist.flush();
                    oosHist.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

//-----------------------------------------------------------------//

    public static List<IstorikoPelath> anagnwshIstorikou(Pelaths customer)
    {
        //Dhlwsh revmatos eisodou antikeimenou gia antikeimeno typoy IstorikoPelath
        ObjectInputStream oisHist = null;

        List<IstorikoPelath> history = new ArrayList<IstorikoPelath>();


        //Dhmiourgia revmatos eisodou antikeimenwn gia antikeimeno typou
        //istorikoPelath
        try {
            oisHist = new ObjectInputStream(new FileInputStream("istoriko_"
                            + customer.getName() + "_" + customer.getSurname() +".bin" ));

            //Kathe antikeimeno typou Object, einai yperklassh olwn twn antikeimenwn
            Object obj = null;

            //Metavivash twn antikeimenwn typoy "istorikoPelath" sto antikeimeno obj
            //apo thn anagnwsh toy arxeiou.
            //kai sth synexeia kathe antikeimeno prostithetai sthn lista history
            while ((obj = oisHist.readObject()) != null) {

                if (obj instanceof IstorikoPelath) {
                    history.add((IstorikoPelath)obj);
                }
            }

        } catch (Exception ex){
            //Diaxeirhsh exception
            //System.out.println("Σφαλμα στην αναγνωση του αρχειου.");
        } finally {
            //Kleisimo toy revmatos eksodou antikeimenou oisHist
            try {
                //Kleisimo toy revmatos eisodou antikeimenou oisHist
                if (oisHist != null) {
                    oisHist.close();
                }
            } catch (Exception ex){
                 //Diaxeirhsh exception
                // System.out.println("Σφαλμα στην αναγνωση του αρχειου.");
            }
        }
        return history;
    }


//-----------------------------------------------------------------//
//-----------------------------------------------------------------//


    //Emfanish listwn twn atomwn poy einai eggegrammenoi sthn efarmogh
    //me thn morfh JList



    public void printAllPelaths()
    {

        //Metatroph toy ArrayList se String[] pinaka megethoys antistoixou me
        //thn lista
        int megethosListas = listaPelatwn.size();

        String[] listaToArray = new String[megethosListas];

        int k=0;
        for(Pelaths p : listaPelatwn)
        {
            listaToArray[k] = p.getName()+" "+p.getSurname();
            k++;
        }

        //Dhlwseis
        JFrame frame = new JFrame("Επιλογή Πελάτη-->Προβολή στοιχείων");
        
        JLabel labelCust = new JLabel();
        JPanel panel = new JPanel();

        final JList selector = new JList(listaToArray);
        Font SansSerif = new Font ("SansSerif", Font.BOLD, 14);
        selector.setFont(SansSerif);
        selector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selector.setListData(listaToArray);
        selector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //selector.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);


        JScrollPane ListScrollPane = new JScrollPane(selector);
        JSplitPane splitPane = new JSplitPane();

        //StringBuffer showBuffer = new StringBuffer();
        final StringBuffer sb = new StringBuffer();


        selector.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent event)
            {
                //Katharismos toy showBuffer gia kathe Select Event
                sb.delete(0, sb.length());

                //int index = event.getFirstIndex();
                int index2 = selector.getSelectedIndex();
                int index = event.getFirstIndex();
                sb.append("---------------------------------------");
                sb.append("\n");
                sb.append(listaPelatwn.get(index2).ShowPelathsDetails());
                sb.append("---------------------------------------");
                sb.append("\n");
                //System.out.println(showBuffer);
                //System.out.println(listaPelatwn.get(index).ShowPelathsDetails());
                JOptionPane.showMessageDialog(null, sb,
                        "Εμφάνιση Πελάτη", JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("OK!!!!!!");
                

            }
        });
        
        String TelikoShow = sb.toString();


        labelCust = new JLabel(TelikoShow);
        //labelCust.setText(TelikoShow);
        labelCust.setVisible(true);


        
        panel.add(labelCust);
        panel.setVisible(true);

        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(ListScrollPane);
        splitPane.setRightComponent(panel);
        splitPane.setDividerLocation(150);
        splitPane.setVisible(true);
        splitPane.setContinuousLayout(true);
        splitPane.setName("Επιλογή Πελάτη");



        frame.add(splitPane);
        //frame.add(ListScrollPane, BorderLayout.CENTER);
        frame.setResizable(false);


        frame.setSize(500, 400);

        frame.setLocationRelativeTo(null);
        //frame.setAlwaysOnTop(true);
        frame.setVisible(true);

     }


//-----------------------------------------------------------------//

    public static void printAllTexnikos()
    {
        {

        //Metatroph toy ArrayList se String[] pinaka megethoys antistoixou me
        //thn lista
        int megethosListas = listaTexnikwn.size();

        String[] listaToArray = new String[megethosListas];

        int k=0;
        for(Texnikos t : listaTexnikwn)
        {
            listaToArray[k] = t.getName()+" "+t.getSurname();
            k++;
        }

        //Dhlwseis
        JFrame frame = new JFrame("Επιλογή Τεχνικού-->Προβολή στοιχείων");

        JLabel labelCust = new JLabel();
        JPanel panel = new JPanel();

        final JList selector = new JList(listaToArray);
        Font SansSerif = new Font ("SansSerif", Font.BOLD, 14);
        selector.setFont(SansSerif);
        selector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selector.setListData(listaToArray);
        selector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //selector.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);


        JScrollPane ListScrollPane = new JScrollPane(selector);
        JSplitPane splitPane = new JSplitPane();

        //StringBuffer showBuffer = new StringBuffer();
        final StringBuffer sb = new StringBuffer();


        selector.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent event)
            {
                //Katharismos toy showBuffer gia kathe Select Event
                sb.delete(0, sb.length());

                //int index = event.getFirstIndex();
                int index2 = selector.getSelectedIndex();
                int index = event.getFirstIndex();
                sb.append("---------------------------------------");
                sb.append("\n");
                sb.append(listaTexnikwn.get(index2).ShowTechDetails());
                sb.append("---------------------------------------");
                sb.append("\n");
                
                JOptionPane.showMessageDialog(null, sb,
                        "Εμφάνιση Τεχνικού", JOptionPane.INFORMATION_MESSAGE);
      

            }
        });


        String TelikoShow = sb.toString();
        labelCust = new JLabel(TelikoShow);
        labelCust.setVisible(true);



        panel.add(labelCust);
        panel.setVisible(true);

        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(ListScrollPane);
        splitPane.setRightComponent(panel);
        splitPane.setDividerLocation(150);
        splitPane.setVisible(true);
        splitPane.setContinuousLayout(true);
        splitPane.setName("Επιλογή Τεχνικού");



        frame.add(splitPane);
       
        frame.setResizable(false);


        frame.setSize(500, 400);

        frame.setLocationRelativeTo(null);
       
        frame.setVisible(true);

     }

}


//-----------------------------------------------------------------//

    public static void printAllGrammateas()
    {

       {

        //Metatroph toy ArrayList se String[] pinaka megethoys antistoixou me
        //thn lista
        int megethosListas = listaGrammatewn.size();

        String[] listaToArray = new String[megethosListas];

        int k=0;
        for(Grammateas g : listaGrammatewn)
        {
            listaToArray[k] = g.getName()+" "+g.getSurname();
            k++;
        }

        //Dhlwseis
        JFrame frame = new JFrame("Επιλογή Γραμματέα-->Προβολή στοιχείων");

        JLabel labelCust = new JLabel();
        JPanel panel = new JPanel();

        final JList selector = new JList(listaToArray);
        Font SansSerif = new Font ("SansSerif", Font.BOLD, 14);
        selector.setFont(SansSerif);
        selector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selector.setListData(listaToArray);
        selector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   

        JScrollPane ListScrollPane = new JScrollPane(selector);
        JSplitPane splitPane = new JSplitPane();

        //StringBuffer showBuffer = new StringBuffer();
        final StringBuffer sb = new StringBuffer();


        selector.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent event)
            {
                //Katharismos toy showBuffer gia kathe Select Event
                sb.delete(0, sb.length());
                
                int index2 = selector.getSelectedIndex();
                int index = event.getFirstIndex();
                sb.append("---------------------------------------");
                sb.append("\n");
                sb.append(listaGrammatewn.get(index2).ShowSecrDetails());
                sb.append("---------------------------------------");
                sb.append("\n");
                
                JOptionPane.showMessageDialog(null, sb,
                        "Εμφάνιση Γραμματέα", JOptionPane.INFORMATION_MESSAGE);
              


            }
        });


        String TelikoShow = sb.toString();

        labelCust = new JLabel(TelikoShow);

        labelCust.setVisible(true);



        panel.add(labelCust);
        panel.setVisible(true);

        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(ListScrollPane);
        splitPane.setRightComponent(panel);
        splitPane.setDividerLocation(150);
        splitPane.setVisible(true);
        splitPane.setContinuousLayout(true);
        splitPane.setName("Επιλογή Γραμματέα");



        frame.add(splitPane);

        frame.setResizable(false);


        frame.setSize(500, 400);

        frame.setLocationRelativeTo(null);
        
        frame.setVisible(true);

     }

     }


//-----------------------------------------------------------------//
//-----------------------------------------------------------------//

    //Ektypwsh apotelesmatos anazhthshs sygkekrimenou pelath
    //eisagwntas onoma kai epitheto
    public static void printPelathsDetails()
    {
        Pelaths customer;        

        String name = JOptionPane.showInputDialog(null, "Όνομα", "Εμφάνιση στοιχείων",
                               JOptionPane.QUESTION_MESSAGE);
        String surname = JOptionPane.showInputDialog(null, "Επώνυμο", "Εμφάνιση στοιχείων",
                               JOptionPane.QUESTION_MESSAGE);

        customer = eureshPelath(name, surname);

        if (customer != null)
        {            
            JOptionPane.showMessageDialog(null, customer.ShowPelathsDetails(), "Βρέθηκε...",
                                            JOptionPane.INFORMATION_MESSAGE);
        }
        else {JOptionPane.showMessageDialog(null, "Δεν υπάρχει πελάτης\nμε αυτό το όνομα!",
                                        "Δεν βρέθηκε...", JOptionPane.ERROR_MESSAGE);}
    }


//-----------------------------------------------------------------//
//----------------EURESH ATOMWN------------------------------------//

    //Methodos gia thn euresh twn pelatwn, symfwna me to onoma kai to epwnymo
    public static Pelaths eureshPelath(String name, String surname)
    {
        Pelaths customer = null;
        Pelaths tempCust;
        int i;
        for (i=0;i<listaPelatwn.size();i++)
        {
            tempCust = listaPelatwn.get(i);
            if (tempCust.getName().equals(name) && tempCust.getSurname().equals(surname))
                
                //euresh sygkekrimenou pelath
                customer = tempCust;
        }
        //Epistrofh sygkekrimenou pelath
        return customer;
    }


    //Methodos gia thn euresh twn texnikwn, symfwna me to onoma kai to epwnymo
    public static Texnikos eureshTexnikou(String name, String surname)
    {
        Texnikos tech = null;
        Texnikos tempTech;
        int i;
        for (i=0;i<listaTexnikwn.size();i++)
        {
            tempTech = listaTexnikwn.get(i);
            if (tempTech.getName().equals(name) && tempTech.getSurname().equals(surname))
                tech = tempTech;
        }
        return tech;
    }


    //Methodos gia thn euresh twn grammatewn, symfwna me to onoma kai to epwnymo
    public static Grammateas eureshGrammatea(String name, String surname)
    {
        Grammateas secr = null;
        Grammateas tempSecr;

        int i;
        for (i=0;i<listaGrammatewn.size();i++)
        {
            tempSecr = listaGrammatewn.get(i);
            if (tempSecr.getName().equals(name) && tempSecr.getSurname().equals(surname))
                secr = tempSecr;
        }
        return secr;
    }

//-----------------------------------------------------------------//
//-----------------------------------------------------------------//
//Euresh kai diorthosh twn stoixeiwn toy pelath

    //Euresh kai diorthosh onomatos pelath kata onom/nymo
    public void eureshCustChangeOnoma()
    {
        Pelaths customer;      

        String nameOld = JOptionPane.showInputDialog(null, "Όνομα", "Αλλαγή ονόματος",
                               JOptionPane.QUESTION_MESSAGE);
        String surnameOld = JOptionPane.showInputDialog(null, "Επώνυμο", "Αλλαγή ονόματος",
                               JOptionPane.QUESTION_MESSAGE);


        customer = eureshPelath(nameOld, surnameOld);

        if (customer != null)
        {
           int id = listaPelatwn.indexOf(customer);


           //Palia arxeia
           File fileCustOld = new File("carcheck_" + listaPelatwn.get(id).getName() +"_"+
                                    listaPelatwn.get(id).getSurname() +".bin");

           File fileHistOld = new File("istoriko_" + listaPelatwn.get(id).getName() +"_"+
                                    listaPelatwn.get(id).getSurname() +".bin");

           String nameNew = JOptionPane.showInputDialog(null, "Παλιό Όνομα: "+listaPelatwn.get(id).getName(), 
                                            "Εισαγωγή νέου ονόματος", JOptionPane.QUESTION_MESSAGE);

           //String pnname = JOptionPane.showInputDialog("Νέο Όνομα");
           listaPelatwn.get(id).setName(nameNew);

           JOptionPane.showMessageDialog(null, 
                   "Το όνομα άλλαξε επιτυχώς!\nΝέο όνομα: "+listaPelatwn.get(id).getName(),
                                    "Αλλαγή", JOptionPane.INFORMATION_MESSAGE);

           //Metonomasia arxeiwn "carcheck_" kai "istoriko_"
           File fileCustNew = new File("carcheck_" + listaPelatwn.get(id).getName() +"_"+ listaPelatwn.get(id).getSurname() +".bin");
           boolean renameCarcheck = fileCustOld.renameTo(fileCustNew);

           File fileHistNew = new File("istoriko_" + listaPelatwn.get(id).getName() +"_"+ listaPelatwn.get(id).getSurname() +".bin");
           boolean renameIstoriko = fileHistOld.renameTo(fileHistNew);          

           savePelaths("pelates.bin");
        }
        else {JOptionPane.showMessageDialog(null, "Δεν υπάρχει πελάτης\nμε αυτό το όνομα!",
                                    "Δεν βρέθηκε...", JOptionPane.ERROR_MESSAGE);}


    }

    //Euresh kai diorthosh epithetoy pelath kata onom/nymo
    public void eureshCustChangeSurname()
    {
        Pelaths customer;
        
        String nameOld = JOptionPane.showInputDialog(null, "Όνομα", "Αλλαγή επιθέτου",
                               JOptionPane.QUESTION_MESSAGE);
        String surnameOld = JOptionPane.showInputDialog(null, "Επώνυμο", "Αλλαγή επιθέτου",
                               JOptionPane.QUESTION_MESSAGE);


        customer = eureshPelath(nameOld, surnameOld);

        if (customer != null)
        {
           int id = listaPelatwn.indexOf(customer);


           //Palia arxeia
           File fileCustOld = new File("carcheck_" + listaPelatwn.get(id).getName() +"_"+
                                    listaPelatwn.get(id).getSurname() +".bin");

           File fileHistOld = new File("istoriko_" + listaPelatwn.get(id).getName() +"_"+
                                    listaPelatwn.get(id).getSurname() +".bin");

           String surNameNew = JOptionPane.showInputDialog(null, "Παλιό επίθετο: "+listaPelatwn.get(id).getSurname(),
                                            "Εισαγωγή νέου επιθέτου", JOptionPane.QUESTION_MESSAGE);

           //String pnname = JOptionPane.showInputDialog("Νέο Όνομα");
           listaPelatwn.get(id).setSurname(surNameNew);

           JOptionPane.showMessageDialog(null,
                   "Το επίθετο άλλαξε επιτυχώς!\nΝέο επίθετο: "+listaPelatwn.get(id).getSurname(),
                                    "Αλλαγή", JOptionPane.INFORMATION_MESSAGE);

           //Metonomasia arxeiwn "carcheck_" kai "istoriko_"
           File fileCustNew = new File("carcheck_" + listaPelatwn.get(id).getName() +"_"+ listaPelatwn.get(id).getSurname() +".bin");
           boolean renameCarcheck = fileCustOld.renameTo(fileCustNew);

           File fileHistNew = new File("istoriko_" + listaPelatwn.get(id).getName() +"_"+ listaPelatwn.get(id).getSurname() +".bin");
           boolean renameIstoriko = fileHistOld.renameTo(fileHistNew);
          
           savePelaths("pelates.bin");
        }
        else {JOptionPane.showMessageDialog(null, "Δεν υπάρχει πελάτης\nμε αυτό το όνομα!",
                                    "Δεν βρέθηκε...", JOptionPane.ERROR_MESSAGE);}
    }

    //Euresh kai diorthosh thlefwnoy pelath kata onom/nymo
    public  void eureshCustChangeThl()
    {
        Pelaths customer;

        String name = JOptionPane.showInputDialog(null, "Όνομα", "Αλλαγή τηλεφώνου",
                               JOptionPane.QUESTION_MESSAGE);
        String surname = JOptionPane.showInputDialog(null, "Επώνυμο", "Αλλαγή τηλεφώνου",
                               JOptionPane.QUESTION_MESSAGE);

         customer = eureshPelath(name, surname);

         if (customer != null)
        {
           int id = listaPelatwn.indexOf(customer);
           String thlefwnoNew = JOptionPane.showInputDialog(null, "Παλιό τηλέφωνο: "+
                   listaPelatwn.get(id).getThlefwno(), "Εισαγωγή νέου τηλεφώνου", JOptionPane.QUESTION_MESSAGE);
          
           listaPelatwn.get(id).setThlefwno(thlefwnoNew);

           JOptionPane.showMessageDialog(null,
                   "Το επίθετο άλλαξε επιτυχώς!\nΝέο τηλέφωνο: "+listaPelatwn.get(id).getThlefwno(),
                                    "Αλλαγή", JOptionPane.INFORMATION_MESSAGE);
        }
        else {JOptionPane.showMessageDialog(null, "Δεν υπάρχει πελάτης\nμε αυτό το όνομα!",
                                    "Δεν βρέθηκε...", JOptionPane.ERROR_MESSAGE);}
    }

    //Euresh kai diorthosh odou pelath kata onom/nymo
    public  void eureshCustChangeOdos()
    {
        Pelaths customer;

        String name = JOptionPane.showInputDialog(null, "Όνομα", "Αλλαγή οδού",
                               JOptionPane.QUESTION_MESSAGE);
        String surname = JOptionPane.showInputDialog(null, "Επώνυμο", "Αλλαγή οδού",
                               JOptionPane.QUESTION_MESSAGE);

        customer = eureshPelath(name, surname);

        if (customer != null)
        {
           int id = listaPelatwn.indexOf(customer);
           String odosNew = JOptionPane.showInputDialog(null, "Παλιά οδός: "+
                   listaPelatwn.get(id).getOdos(), "Εισαγωγή νέας οδού", JOptionPane.QUESTION_MESSAGE);

           listaPelatwn.get(id).setOdos(odosNew);

           JOptionPane.showMessageDialog(null,
                   "Η οδός άλλαξε επιτυχώς!\nΝέα οδός: "+listaPelatwn.get(id).getOdos(),
                                    "Αλλαγή", JOptionPane.INFORMATION_MESSAGE);
        }
        else {JOptionPane.showMessageDialog(null, "Δεν υπάρχει πελάτης\nμε αυτό το όνομα!",
                                    "Δεν βρέθηκε...", JOptionPane.ERROR_MESSAGE);}
    }

    //Euresh kai diorthosh asfalistikou forea pelath kata onom/nymo
    public  void eureshCustChangeAsfForeas()
    {
        Pelaths customer;

        String name = JOptionPane.showInputDialog(null, "Όνομα", "Αλλαγή ασφ. φορέα",
                               JOptionPane.QUESTION_MESSAGE);
        String surname = JOptionPane.showInputDialog(null, "Επώνυμο", "Αλλαγή ασφ. φορέα",
                               JOptionPane.QUESTION_MESSAGE);

        customer = eureshPelath(name, surname);

        if (customer != null)
        {
           int id = listaPelatwn.indexOf(customer);
           String asfForeasNew = JOptionPane.showInputDialog(null, "Παλιός ασφ. φορέας: "+
                   listaPelatwn.get(id).getAsfForeas(), "Εισαγωγή νέου ασφ. φορέα", JOptionPane.QUESTION_MESSAGE);

           listaPelatwn.get(id).setAsfForeas(asfForeasNew);

           JOptionPane.showMessageDialog(null,
                   "Ο ασφ. φορέας άλλαξε επιτυχώς!\nΝέος ασφ. φορέας: "+listaPelatwn.get(id).getAsfForeas(),
                                    "Αλλαγή", JOptionPane.INFORMATION_MESSAGE);
        }
        else {JOptionPane.showMessageDialog(null, "Δεν υπάρχει πελάτης\nμε αυτό το όνομα!",
                                    "Δεν βρέθηκε...", JOptionPane.ERROR_MESSAGE);}
    }

//-----------------------------------------------------------------//
//-----------------------------------------------------------------//
    
}
