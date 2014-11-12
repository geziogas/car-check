package project2010;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;



/**
 * ERGASIA ANAPTYKSHS EFARMOGHS SYNERGEIOY AYTOKINHTWN
 * @author George Ziogas AEM: 1461
 */
public class Menu extends JFrame
{

    private JLabel label = new JLabel("");    
    private JLabel pictureLabel;
    TechJob application = new TechJob();


    

    public Menu(){

//-----------------------------------------------------------------//
//-----------------------------------------------------------------//

//Oi methodoi file(eidos)Create("Onoma arxeiou"); dhmiourgoun ta
//arxika mas arxeia poy tha xreiastoyn.

        //Dhmiourgeia arxeiwn
        try {
            fileTechCreate("texnikoi.bin");
        } catch (IOException ex) {
            //Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            fileSecrCreate("grammateis.bin");
        } catch (IOException ex) {
            //Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            fileCustCreate("pelates.bin");
        } catch (IOException ex) {
            //Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        

//-----------------------------------------------------------------//

//-----------------------------------------------------------------//
//-----------------------------------------------------------------//

        //Parametropoihsh toy kentrikoy parathyroy typoy JFrame, menu
        setTitle("ΕΦΑΡΜΟΓΗ ΣΥΝΕΡΓΕΙΟΥ ΑΥΤΟΚΙΝΗΤΟΥ");


        setSize(700, 300);
        setLocationRelativeTo(null);        
              
        //Eksypnh xrhsh ths WindowListener kai toy setDefaultCloseOperation
        //gia to kleisimo ths efarmoghs        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        //Xrhsh ths synarthshs systemQuit wste na ginetai proeidopoihtiko
        //erwthma gia thn apothikeysh kata thn eksodo, kai kata to
        //kleisimo toy parathiroy (X)
        addWindowListener(new WindowAdapter(){        
        @Override
        public void windowClosing(WindowEvent e) 
        {
            
            systemQuit();
        }
            }   
        );

        setResizable(false); //Apagoreysh metavolhs megethoys parathyroy

        //Dhmioyrgia menu typoy JMenuBar
        JMenuBar menuBar = new JMenuBar();

        //Label gia thn xrhsh ths eikonas
        pictureLabel = new JLabel();


        //Dhmiourgia kentrikhs eikonas mesw ths synarthshs updatePicture()
        updatePicture();

        //Topothetish eikonidiou efarmoghs
        Image im = Toolkit.getDefaultToolkit().getImage("images/car.gif");
        setIconImage(im);
        
        
               
 //------------------------------------------------------------//
 //------------------------------------------------------------//
        //Dhmioyrgia kai sxediash arxikhs mparas typou JMenuBar

        //Kwdikas gia thn kartela "Arxeio"
        JMenu menuFile = new JMenu("Αρχείο");
        menuFile.setMnemonic(KeyEvent.VK_A);//Syntomeysh
        menuFile.setDisplayedMnemonicIndex(0);
        menuBar.add(menuFile);

        
        //Kwdikas gia thn kartela "Proswpiko"
        JMenu menuStaff = new JMenu("Προσωπικό");
        menuStaff.setMnemonic(KeyEvent.VK_R);//Syntomeysh
        menuStaff.setDisplayedMnemonicIndex(1);
        menuBar.add(menuStaff);


        //Kwdikas gia thn kartela "Pelaths"
        JMenu menuCustomer = new JMenu("Πελάτης");
        menuCustomer.setMnemonic(KeyEvent.VK_P);//Syntomeysh
        menuCustomer.setDisplayedMnemonicIndex(0);
        menuBar.add(menuCustomer);


        //Kwdikas gia thn kartela "Ergasia"
        JMenu menuJob = new JMenu("Εργασία");
        menuJob.setMnemonic(KeyEvent.VK_E);//Syntomeysh
        menuJob.setDisplayedMnemonicIndex(0);
        menuBar.add(menuJob);


        //Kwdikas gia thn kartela "Diagnwsh ergasias"
        JMenu menuResults = new JMenu("Διάγνωση εργασίας");
        menuResults.setMnemonic(KeyEvent.VK_G);//Syntomeysh
        menuResults.setDisplayedMnemonicIndex(3);
        menuBar.add(menuResults);


 //------------------------------------------------------------//
 //------------------------------------------------------------//
 //Periexomeno kartelas "Proswpiko"

        //"Texnikos"
        JMenu menuStaffTech = new JMenu("Τεχνικός");   
        menuStaff.add(menuStaffTech);

        //"Grammateas"
        JMenu menuStaffSecr = new JMenu("Γραμματέας");              
        menuStaff.add(menuStaffSecr);

           //Ypomemu TEXNIKOY-----------------
           //Ypomenu texnikou-kataxwrhsh
           JMenuItem menuTechNew = new JMenuItem("Καταχώρηση");
           menuTechNew.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
               public void actionPerformed(ActionEvent e)
               {
                try {
                    application.eggrafhTexnikwn();
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
               }
           });
           menuStaffTech.add(menuTechNew);

           //Diagrafh texnikoy
           JMenuItem menuTechDel = new JMenuItem("Διαγραφή");
           menuTechDel.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
                public void actionPerformed(ActionEvent e)
                {
                   application.deleteTexnikos();
                }
            });
            menuStaffTech.add(menuTechDel);

            //Diaxwristiko
           menuStaffTech.addSeparator();

           //Ypomenu texnikou-Emfanish hmerologiou
           JMenuItem menuTechShowRandevou = new JMenuItem("Προβολή ραντεβού(Λίστα)");
           menuTechShowRandevou.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
               public void actionPerformed(ActionEvent e)
               {
                   //epipleon entoles mpainoyn edw
                   application.showHmerolTexnikou();
               }
           });
           menuStaffTech.add(menuTechShowRandevou);

           //Ypomenu texnikou-Emfanish hmerologiou
           JMenuItem menuTechShowDiary = new JMenuItem("Προβολή ημερολογίου(Λίστα)");
           menuTechShowDiary.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
               public void actionPerformed(ActionEvent e)
               {
                   //epipleon entoles mpainoyn edw
                   application.showHmerolTexnikouFreeDays();
               }
           });
           menuStaffTech.add(menuTechShowDiary);


           //Diaxwristiko
           menuStaffTech.addSeparator();


           //Emfanish olwn twn texnikwn
           JMenuItem menuTechShowAll = new JMenuItem("Προβολή τεχνικών(Λίστα)");
           menuTechShowAll.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
               public void actionPerformed(ActionEvent e)
               {
                   application.printAllTexnikos();
               }
           });
           menuStaffTech.add(menuTechShowAll);

        //Ypomenu grammatews
        JMenuItem menuSecrNew = new JMenuItem("Καταχώρηση");
        menuSecrNew.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
            public void actionPerformed(ActionEvent e)
            {
                application.eggrafhGrammatewn();
            }
        });
        menuStaffSecr.add(menuSecrNew);

        //Diagrafh grammatea
        JMenuItem menuSecrDel = new JMenuItem("Διαγραφή");
           menuSecrDel.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
                public void actionPerformed(ActionEvent e)
                {
                   application.deleteGrammateas();
                }
            });
            menuStaffSecr.add(menuSecrDel);


        //Diaxwristiko
        menuStaffSecr.addSeparator();


        //Emfanish olwn twn grammatewn
           JMenuItem menuSecrShowAll = new JMenuItem("Προβολή γραμματέων(Λίστα)");
           menuSecrShowAll.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
               public void actionPerformed(ActionEvent e)
               {
                   application.printAllGrammateas();
               }
           });
           menuStaffSecr.add(menuSecrShowAll);


 //------------------------------------------------------------//


  //------------------------------------------------------------//
 //Periexomeno kartelas "Arxeio"


        //"Apothikeysh"
        JMenuItem menuFileSave = new JMenuItem("Αποθήκευση");
        menuFileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                ActionEvent.ALT_MASK));
        menuFileSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                application.Save();
                label.setText("Αποθήκευση δεδομένων επιτυχής!");
                //Parathyraki plhroforiwn gia epityxh fortvsh arxeiwn
                JOptionPane.showMessageDialog(null, "Αποθήκευση δεδομένων επιτυχής!",
                                "Αποθήκευση", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        menuFile.add(menuFileSave);


        //Diaxwristiko
        menuFile.addSeparator();


        //"Kleisimo" kai erwthsh asfaleias gia thn eksodo
        JMenuItem menuFileExit = new JMenuItem("Έξοδος");
        menuFileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                ActionEvent.ALT_MASK));
        menuFileExit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                systemQuit(); //Synarthsh eksodoy efarmoghs
            }
        });//Ektelesh leitoyrgias eksodoy
        menuFile.add(menuFileExit);

        //"Kleisimo" kai erwthsh asfaleias gia thn eksodo xwris apothikeysh
        JMenuItem menuFileExitNS = new JMenuItem("Έξοδος χωρίς αποθήκευση");
        menuFileExitNS.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0); //Synarthsh eksodoy efarmoghs
            }
        });//Ektelesh leitoyrgias eksodoy
        menuFile.add(menuFileExitNS);


 //------------------------------------------------------------//
 //Periexomeno kartelas "Pelaths"

        //"Kataxwrhsh pelath"
        JMenuItem menuCustomerNew = new JMenuItem("Καταχώρηση πελάτη");
        menuCustomerNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                ActionEvent.ALT_MASK));
        menuCustomerNew.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
            public void actionPerformed(ActionEvent e)
            {
                try {
                    application.eggrafhPelatwn();
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menuCustomer.add(menuCustomerNew);


        //"Allagh stoixeiwn pelath"
        JMenu menuCustChangeDet = new JMenu("Αλλαγή στοιχείων πελάτη");       
        menuCustomer.add(menuCustChangeDet);


        //Diaxwristiko
        menuCustomer.addSeparator();


        //"Emfanish olwn"
        JMenuItem menuCustomerShowALl = new JMenuItem("Προβολή πελατών(Λίστα)");
        menuCustomerShowALl.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
            public void actionPerformed(ActionEvent e)
            {
                application.printAllPelaths();
            }
        });
        menuCustomer.add(menuCustomerShowALl);

        //"Emfanish pelath"
        JMenuItem menuCustomerShow = new JMenuItem("Προβολή πελάτη");
        menuCustomerShow.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
            public void actionPerformed(ActionEvent e)
            {
                application.printPelathsDetails();
            }
        });
        menuCustomer.add(menuCustomerShow);




        //"Emfanish ergasiwn"
        JMenuItem menuCustomerShowJob = new JMenuItem("Προβολή εργασιών");
        menuCustomerShowJob.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //epipleon entoles mpainoyn edw
                application.provolhErgasiwnCar();            
            }
        });
        menuCustomer.add(menuCustomerShowJob);



        //Diaxwristiko
        menuCustomer.addSeparator();

        
        //"Emfanish istorikou"
        JMenuItem menuCustomerShowHist2 = new JMenuItem("Προβολή ιστορικού(Λίστα)");
        menuCustomerShowHist2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //epipleon entoles mpainoyn edw
                application.emfanishIstorikou2();
            }
        });
        menuCustomer.add(menuCustomerShowHist2);


        //"Emfanish istorikou"
        JMenuItem menuCustomerShowHist = new JMenuItem("Προβολή ιστορικού");
        menuCustomerShowHist.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //epipleon entoles mpainoyn edw
                application.emfanishIstorikou();
            }
        });
        menuCustomer.add(menuCustomerShowHist);



        //Diaxwristiko
        menuCustomer.addSeparator();


        //Diagrafh pelath
        JMenuItem menuCustomerDel = new JMenuItem("Διαγραφή πελάτη");
        menuCustomerDel.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
            public void actionPerformed(ActionEvent e)
            {
                application.deletePelaths();
            }
        });
        menuCustomer.add(menuCustomerDel);



            //Ypomenu twn allagwn twn stoixeiwn toy pelath

            //"Allagh stoixeiwn pelath-Allagh onomatos"
            JMenuItem menuCustChangeDetNam = new JMenuItem("Αλλαγή ονόματος");
            menuCustChangeDetNam.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    application.eureshCustChangeOnoma();
                 //epipleon entoles mpainoyn edw
                }
            });
            menuCustChangeDet.add(menuCustChangeDetNam);

            //"Allagh stoixeiwn pelath-Allagh epithetou"
            JMenuItem menuCustChangeDetSur = new JMenuItem("Αλλαγή επίθετου");
            menuCustChangeDetSur.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    application.eureshCustChangeSurname();
                }
            });
            menuCustChangeDet.add(menuCustChangeDetSur);

            //"Allagh stoixeiwn pelath-Allagh thlefwnou"
            JMenuItem menuCustChangeDetTel = new JMenuItem("Αλλαγή τηλέφωνου");
            menuCustChangeDetTel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    application.eureshCustChangeThl();
                }
            });
            menuCustChangeDet.add(menuCustChangeDetTel);

            //"Allagh stoixeiwn pelath-Allagh odou"
            JMenuItem menuCustChangeDetAddr = new JMenuItem("Αλλαγή οδού");
            menuCustChangeDetAddr.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                     application.eureshCustChangeOdos();
                }
            });
            menuCustChangeDet.add(menuCustChangeDetAddr);

            //"Allagh stoixeiwn pelath-Allagh asfalistikoy forea"
            JMenuItem menuCustChangeDetIns = new JMenuItem("Αλλαγή ασφ. φορέα");
            menuCustChangeDetIns.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                     application.eureshCustChangeAsfForeas();
                }
            });
            menuCustChangeDet.add(menuCustChangeDetIns);


  //------------------------------------------------------------//
 //Kartela ergasias

          //Ypomenu Programmatismou neas ergasias
           JMenuItem menuJobNew = new JMenuItem("Προγραμματισμός νέας εργασίας");
           menuJobNew.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e)
               {
                   //epipleon entoles mpainoyn edw
                   application.neaErgasiaCar();
               }
           });
           menuJob.add(menuJobNew);

 //------------------------------------------------------------//
 //Kartela diagnwshs

          //Ypomenu Programmatismou neas ergasias
           JMenuItem menuResultsNew = new JMenuItem("Εισαγωγή διάγνωσης");
           menuResultsNew.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e)
               {
                   //epipleon entoles mpainoyn edw
                   application.neaDiagnwshEurhmata();
               }
           });
           menuResults.add(menuResultsNew);

 //------------------------------------------------------------//
 //------------------------------------------------------------//
 //Topothethsh olwn twn epimerous COMPONENTS sto kyriws parathyro


        //Topothethsh toy MENUBAR panw sto FRAME
        add(menuBar);

        //Tropopoihsh toy "menu" san MenuBar
        setJMenuBar(menuBar);

        //Topothethsh toy label eikonas        
        add(pictureLabel,BorderLayout.NORTH);

        //Topothethsh toy label poy afora thn katastash ths efarmoghs
        add(label);

        //Entolh gia na ginetai orath h efarmogh
        setVisible(true);


        /*
        //Topothethsh proeidopoihtikoy mhnymatos
        String textAttention;
        textAttention = "ΠΡΟΣΟΧΗ!!!\nΣΕ ΚΑΘΕ ΕΚΚΙΝΗΣΗ ΤΟΥ ΠΡΟΓΡΑΜΜΑΤΟΣ,\nΜΗΝ ΞΕΧΝΑΤΕ ΝΑ ΠΑΤΑΤΕ \"ΦΟΡΤΩΣΗ\"!!!";

        JOptionPane.showMessageDialog(null, textAttention, "ΠΡΟΣΟΧΗ!!!",
                            JOptionPane.WARNING_MESSAGE);*/


        //Aytomath fortwsh dedomenwn se kathe ekkinhsh toy programmatos
        application.Load();
        label.setText("Φόρτωση δεδομένων επιτυχής!");

        //Parathyraki plhroforiwn gia epityxh fortvsh arxeiwn
        JOptionPane.showMessageDialog(null, "Φόρτωση δεδομένων επιτυχής!",
                "Φόρτωση...", JOptionPane.INFORMATION_MESSAGE);

        

 //------------------------------------------------------------//
    }

    //Synarthsh dhmiourgias kai topothethshs ths eikonas
    private void updatePicture() {
        String filename = "images/full_garage.gif";
        ImageIcon icon = new ImageIcon(filename);
        pictureLabel.setIcon(icon);
        
        //about
        pictureLabel.setToolTipText("www.users.auth.gr/~geziogas");

    }


    //Synarthsh gia thn epilogh ths eksodou
    //Erwthsh asfaleias kata thn eksodo, gia thn apothikeysh twn arxeiwn.
    private void systemQuit()
    {
        int bye;
                Object[] options = {"Ναι", "Όχι", "Άκυρο"};

                bye = JOptionPane.showOptionDialog(null, "Αποθήκευση αρχείων;",
                        "Αποθήκευση...", JOptionPane.YES_NO_CANCEL_OPTION,  JOptionPane.WARNING_MESSAGE,
                null, options, options[2]);//Proepilogh to AKYRO

                if (bye == JOptionPane.YES_OPTION)
                {
                    application.Save();
                    label.setText("Αποθήκευση δεδομένων επιτυχής!");
                    //Parathyraki plhroforiwn gia epityxh fortvsh arxeiwn
                    JOptionPane.showMessageDialog(null, "Αποθήκευση δεδομένων επιτυχής!",
                                "Αποθήκευση", JOptionPane.INFORMATION_MESSAGE);

                    JOptionPane.showMessageDialog(null,"Αντίο!", "Κλείσιμο...",
                                    JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);//Eksodos apo to programma
                                       
                }

                if (bye == JOptionPane.NO_OPTION)
                {
                    //Eksodos xwris apothikeysh
                    JOptionPane.showMessageDialog(null,"Αντίο!", "Κλείσιμο...",
                                    JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);//Eksodos apo to programma

                }
                if (bye == JOptionPane.CANCEL_OPTION)
                {
                    //Akyrwsh kleisimatos toy programmatos

                }
                
    }

//------------------------------------------------------------//
//------------------------------------------------------------//
//------------------------------------------------------------//

    //Synarthsh diaxeirhshs arxeiwn Texnikou-Grammatews-Pelath
    public void fileTechCreate(String fileName) throws IOException
    {
        //Dhmiourgeia kai elegxos anagaiwn arxeiwn
        File fileTech;
        fileTech=new File(fileName);
        //Diaxeirhsh yparkshs arxeioy
        if(!fileTech.exists())
        {
        fileTech.createNewFile();
        //System.out.println("Το νεο αρχειο \"fileName\" δημιουργηθηκε στον φακελο του προγραμματος.");
        }
    }

    public void fileSecrCreate(String fileName) throws IOException
    {
        //Dhmiourgeia kai elegxos anagaiwn arxeiwn
        File fileSecr;
        fileSecr=new File(fileName);
        //Diaxeirhsh yparkshs arxeioy
        if(!fileSecr.exists())
        {
        fileSecr.createNewFile();
        //System.out.println("Το νεο αρχειο \"fileName\" δημιουργηθηκε στον φακελο του προγραμματος.");
        }
    }

    public void fileCustCreate(String fileName) throws IOException
    {
        //Dhmiourgeia kai elegxos anagaiwn arxeiwn
        File fileCust;
        fileCust=new File(fileName);
        //Diaxeirhsh yparkshs arxeioy
        if(!fileCust.exists())
        {
        fileCust.createNewFile();
        //System.out.println("Το νεο αρχειο \"fileName\" δημιουργηθηκε στον φακελο του προγραμματος.");
        }
    }


//------------------------------------------------------------//
//------------------------------------------------------------//
    public static void main(String[] args) 
    {
        Menu menu = new Menu();
    }

}
