import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class VentanaViewBattleReports extends JFrame implements ActionListener , MouseListener {

    private JMenuBar menu;
    private JMenu ViewPlanetStats,Build,UpgradeTecnology,ViewBattleReports,Exit;
    private JMenuItem BuildDefense,BuildShips;

    private JButton bSelect;

    private JPanel principal,derecha,izquierda;
    private JPanel dArriba,dAvajo;
    private JPanel iArriva,iAvajo;
    private JPanel iArmy,iEnemyArmy,iCost,iEnemyCost,iPerdidas,iEnemyPerdidas;

    private JTextArea turnos;
    private JScrollPane sTurnos;
    private JComboBox selector;

    private JLabel armyPlanet, unitPlanet, dropPlanet;
    private JLabel iArmyLH,iArmyHH,iArmyBS,iArmyAS,iArmyML,iArmyIC,iArmyPC;
    private JLabel iArmyCantLH,iArmyCantHH,iArmyCantBS,iArmyCantAS,iArmyCantML,iArmyCantIC,iArmyCantPC;
    private JLabel iArmyDropLH,iArmyDropHH,iArmyDropBS,iArmyDropAS,iArmyDropML,iArmyDropIC,iArmyDropPC;

    private JLabel armyEnemy, unitEnemy, dropEnemy;
    private JLabel iEnemyArmyLH,iEnemyArmyHH,iEnemyArmyBS,iEnemyArmyAS,iEnemyArmyML,iEnemyArmyIC,iEnemyArmyPC;
    private JLabel iEnemyArmyCantLH,iEnemyArmyCantHH,iEnemyArmyCantBS,iEnemyArmyCantAS,iEnemyArmyCantML,iEnemyArmyCantIC,iEnemyArmyCantPC;
    private JLabel iEnemyArmyDropLH,iEnemyArmyDropHH,iEnemyArmyDropBS,iEnemyArmyDropAS,iEnemyArmyDropML,iEnemyArmyDropIC,iEnemyArmyDropPC;

    private JLabel iMetal,iMetalCant,iDeuterium,iDeuteriumCant;
    private JLabel iRelleno1,iRelleno2,iRelleno3,iRelleno4,iRelleno5,iRelleno6,iRelleno7,iRelleno8,iRelleno9,iRelleno10,iRelleno11,iRelleno12,iRelleno13,iRelleno14,iRelleno15,iRelleno16;

    private JLabel iEnemyMetal,iEnemyMetalCant,iEnemyDeuterium,iEnemyDeuteriumCant;
    private JLabel iEnemyRelleno1,iEnemyRelleno2,iEnemyRelleno3,iEnemyRelleno4,iEnemyRelleno5,iEnemyRelleno6,iEnemyRelleno7,iEnemyRelleno8,iEnemyRelleno9,iEnemyRelleno10,iEnemyRelleno11,iEnemyRelleno12,iEnemyRelleno13,iEnemyRelleno14,iEnemyRelleno15,iEnemyRelleno16;

    private JLabel iLostMetal,iLostMetalCant,iLostDeuterium,iLostDeuteriumCant,iLostWheighted,iLostWheightedCant;
    private JLabel iLostRelleno1,iLostRelleno2,iLostRelleno3,iLostRelleno4,iLostRelleno5,iLostRelleno6,iLostRelleno7,iLostRelleno8,iLostRelleno9,iLostRelleno10;

    private JLabel iLostEnemyMetal,iLostEnemyMetalCant,iLostEnemyDeuterium,iLostEnemyDeuteriumCant,iLostEnemyWheighted,iLostEnemyWheightedCant;
    private JLabel iLostEnemyRelleno1,iLostEnemyRelleno2,iLostEnemyRelleno3,iLostEnemyRelleno4,iLostEnemyRelleno5,iLostEnemyRelleno6,iLostEnemyRelleno7,iLostEnemyRelleno8,iLostEnemyRelleno9,iLostEnemyRelleno10;

    private JLabel iGenMetal,iGenMetalCant,iGenDeuterium,iGenDeuteriumCant;

    public VentanaViewBattleReports() {

        BaseDatos b = new BaseDatos();

        principal = new JPanel();
        derecha = new JPanel();
        iArriva = new JPanel();
        iAvajo = new JPanel();

        dArriba = new JPanel();
        turnos = new JTextArea(30,20);
        sTurnos = new JScrollPane();
        turnos.setEditable(false);
        sTurnos.setViewportView(turnos);

        dArriba.add(sTurnos,BorderLayout.EAST);
        dAvajo = new JPanel();

        iGenMetal =  new JLabel("Metal");
        iGenMetalCant =  new JLabel("0");
        iGenDeuterium =  new JLabel("Deuterium");
        iGenDeuteriumCant =  new JLabel("0");

        izquierda = new JPanel();
        izquierda.setLayout(new BoxLayout(izquierda, BoxLayout.Y_AXIS));
        izquierda.add(iArriva);
        izquierda.add(iAvajo);
        bSelect = new JButton("Select");
        selector = new JComboBox<String>();
        selector.setBounds(10,10,40,20);
        int selector1;
        int selector2;
        int selector3;
        int selector4;
        int selector5;

        try {
            selector1 = b.getIdBattle(1);
            selector2 = b.getIdBattle(2);
            selector3 = b.getIdBattle(3);
            selector4 = b.getIdBattle(4);
            selector5 = b.getIdBattle(5);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        selector.addItem(String.valueOf(selector1));
        selector.addItem(String.valueOf(selector2));
        selector.addItem(String.valueOf(selector3));
        selector.addItem(String.valueOf(selector4));
        selector.addItem(String.valueOf(selector5));
        iArriva.add(selector);
        iArriva.add(bSelect);

        iArmy = new JPanel();

        armyPlanet = new JLabel("Army Planet");
        unitPlanet = new JLabel("Units");
        dropPlanet = new JLabel("Drops");

        iArmyLH = new JLabel("Ligth Hunter");
        iArmyCantLH = new JLabel("0");
        iArmyDropLH = new JLabel("0");

        iArmyHH = new JLabel("Heavy Hunter");
        iArmyCantHH = new JLabel("0");
        iArmyDropHH = new JLabel("0");

        iArmyBS = new JLabel("Battle Ship");
        iArmyCantBS = new JLabel("0");
        iArmyDropBS = new JLabel("0");

        iArmyAS = new JLabel("Armored Ship");
        iArmyCantAS = new JLabel("0");
        iArmyDropAS = new JLabel("0");

        iArmyML = new JLabel("Missile Launcher");
        iArmyCantML = new JLabel("0");
        iArmyDropML = new JLabel("0");

        iArmyIC = new JLabel("Ion Cannon");
        iArmyCantIC = new JLabel("0");
        iArmyDropIC = new JLabel("0");

        iArmyPC = new JLabel("Plasma Cannon");
        iArmyCantPC = new JLabel("0");
        iArmyDropPC = new JLabel("0");

        iEnemyArmy = new JPanel();

        armyEnemy = new JLabel("Army Enemy");
        unitEnemy = new JLabel("Units");
        dropEnemy = new JLabel("Drops");

        iEnemyArmyLH = new JLabel("Ligth Hunter");
        iEnemyArmyCantLH = new JLabel("0");
        iEnemyArmyDropLH = new JLabel("0");

        iEnemyArmyHH = new JLabel("Heavy Hunter");
        iEnemyArmyCantHH = new JLabel("0");
        iEnemyArmyDropHH = new JLabel("0");

        iEnemyArmyBS = new JLabel("Battle Ship");
        iEnemyArmyCantBS = new JLabel("0");
        iEnemyArmyDropBS = new JLabel("0");

        iEnemyArmyAS = new JLabel("Armored Ship");
        iEnemyArmyCantAS = new JLabel("0");
        iEnemyArmyDropAS = new JLabel("0");

        iEnemyArmyML = new JLabel();
        iEnemyArmyCantML = new JLabel();
        iEnemyArmyDropML = new JLabel();

        iEnemyArmyIC = new JLabel();
        iEnemyArmyCantIC = new JLabel();
        iEnemyArmyDropIC = new JLabel();

        iEnemyArmyPC = new JLabel();
        iEnemyArmyCantPC = new JLabel();
        iEnemyArmyDropPC = new JLabel();



        iCost = new JPanel();
        iCost.setLayout(new GridLayout(5,4,10,5));
        iMetal =  new JLabel("Metal:");
        iMetalCant =  new JLabel("0");
        iRelleno1 = new JLabel(" ");
        iRelleno2 = new JLabel();
        iDeuterium =  new JLabel("Deuterium:");
        iDeuteriumCant =  new JLabel("0");
        iRelleno1 = new JLabel();
        iRelleno2 = new JLabel();
        iRelleno3 = new JLabel();
        iRelleno4 = new JLabel();

        iRelleno5 = new JLabel();
        iRelleno6 = new JLabel();
        iRelleno7 = new JLabel();
        iRelleno8 = new JLabel();

        iRelleno9 = new JLabel();
        iRelleno10 = new JLabel();
        iRelleno11 = new JLabel();
        iRelleno12 = new JLabel();

        iRelleno13 = new JLabel();
        iRelleno14 = new JLabel();
        iRelleno15 = new JLabel();
        iRelleno16 = new JLabel();

        iEnemyCost = new JPanel();
        iEnemyCost.setLayout(new GridLayout(5,4,10,5));

        iEnemyMetal =  new JLabel("Metal:");
        iEnemyMetalCant =  new JLabel("0");
        iEnemyDeuterium =  new JLabel("Deuterium:");
        iEnemyDeuteriumCant =  new JLabel("0");
        iEnemyRelleno1 = new JLabel();
        iEnemyRelleno2 = new JLabel();
        iEnemyRelleno3 = new JLabel();
        iEnemyRelleno4 = new JLabel();

        iEnemyRelleno5 = new JLabel();
        iEnemyRelleno6 = new JLabel();
        iEnemyRelleno7 = new JLabel();
        iEnemyRelleno8 = new JLabel();

        iEnemyRelleno9 = new JLabel();
        iEnemyRelleno10 = new JLabel();
        iEnemyRelleno11 = new JLabel();
        iEnemyRelleno12 = new JLabel();

        iEnemyRelleno13 = new JLabel();
        iEnemyRelleno14 = new JLabel();
        iEnemyRelleno15 = new JLabel();
        iEnemyRelleno16 = new JLabel();

        iPerdidas = new JPanel();

        iLostRelleno1 = new JLabel();
        iLostMetal =  new JLabel("Metal:");
        iLostMetalCant =  new JLabel("0");
        iLostRelleno2 = new JLabel();

        iLostRelleno3 = new JLabel();
        iLostDeuterium =  new JLabel("Deuterium:");
        iLostDeuteriumCant =  new JLabel("0");
        iLostRelleno4 = new JLabel();

        iLostRelleno5 = new JLabel();
        iLostWheighted =  new JLabel("Wheighted");
        iLostWheightedCant =  new JLabel("0");
        iLostRelleno6 = new JLabel();

        iLostRelleno7 = new JLabel();
        iLostRelleno8 = new JLabel();
        iLostRelleno9 = new JLabel();
        iLostRelleno10 = new JLabel();
        iEnemyPerdidas = new JPanel();

        iLostEnemyRelleno1 = new JLabel();
        iLostEnemyMetal =  new JLabel("Metal:");
        iLostEnemyMetalCant =  new JLabel("0");
        iLostEnemyRelleno2 = new JLabel();

        iLostEnemyRelleno3 = new JLabel();
        iLostEnemyDeuterium =  new JLabel("Deuterium:");
        iLostEnemyDeuteriumCant =  new JLabel("0");
        iLostEnemyRelleno4 = new JLabel();

        iLostEnemyRelleno5 = new JLabel();
        iLostEnemyWheighted =  new JLabel("Wheighted");
        iLostEnemyWheightedCant =  new JLabel("0");
        iLostEnemyRelleno6 = new JLabel();

        iLostEnemyRelleno7 = new JLabel();
        iLostEnemyRelleno8 = new JLabel();
        iLostEnemyRelleno9 = new JLabel();
        iLostEnemyRelleno10 = new JLabel();

        principal.setLayout(new BoxLayout(principal, BoxLayout.X_AXIS));
        this.add(principal);
        principal.setBackground(Color.ORANGE);

        iAvajo.setLayout(new GridLayout(3, 2));
        principal.add(izquierda,BorderLayout.CENTER);
        iArmy.setLayout(new GridLayout(8,3,10,10));
        iArmy.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Army Planet", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        iArmy.add(armyPlanet);
        iArmy.add(unitPlanet);
        iArmy.add(dropPlanet);

        iArmy.add(iArmyLH);
        iArmy.add(iArmyCantLH);
        iArmy.add(iArmyDropLH);

        iArmy.add(iArmyHH);
        iArmy.add(iArmyCantHH);
        iArmy.add(iArmyDropHH);

        iArmy.add(iArmyBS);
        iArmy.add(iArmyCantBS);
        iArmy.add(iArmyDropBS);

        iArmy.add(iArmyAS);
        iArmy.add(iArmyCantAS);
        iArmy.add(iArmyDropAS);

        iArmy.add(iArmyML);
        iArmy.add(iArmyCantML);
        iArmy.add(iArmyDropML);

        iArmy.add(iArmyIC);
        iArmy.add(iArmyCantIC);
        iArmy.add(iArmyDropIC);

        iArmy.add(iArmyPC);
        iArmy.add(iArmyCantPC);
        iArmy.add(iArmyDropPC);

        iAvajo.add(iArmy);


        iEnemyArmy.setLayout(new GridLayout(8,3,10,10));
        iEnemyArmy.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Enemy Army", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        iEnemyArmy.add(armyEnemy);
        iEnemyArmy.add(unitEnemy);
        iEnemyArmy.add(dropEnemy);

        iEnemyArmy.add(iEnemyArmyLH);
        iEnemyArmy.add(iEnemyArmyCantLH);
        iEnemyArmy.add(iEnemyArmyDropLH);

        iEnemyArmy.add(iEnemyArmyHH);
        iEnemyArmy.add(iEnemyArmyCantHH);
        iEnemyArmy.add(iEnemyArmyDropHH);

        iEnemyArmy.add(iEnemyArmyBS);
        iEnemyArmy.add(iEnemyArmyCantBS);
        iEnemyArmy.add(iEnemyArmyDropBS);

        iEnemyArmy.add(iEnemyArmyAS);
        iEnemyArmy.add(iEnemyArmyCantAS);
        iEnemyArmy.add(iEnemyArmyDropAS);

        iEnemyArmy.add(iEnemyArmyML);
        iEnemyArmy.add(iEnemyArmyCantML);
        iEnemyArmy.add(iEnemyArmyDropML);

        iEnemyArmy.add(iEnemyArmyIC);
        iEnemyArmy.add(iEnemyArmyCantIC);
        iEnemyArmy.add(iEnemyArmyDropIC);

        iEnemyArmy.add(iEnemyArmyPC);
        iEnemyArmy.add(iEnemyArmyCantPC);
        iEnemyArmy.add(iEnemyArmyDropPC);

        iAvajo.add(iEnemyArmy);


        iAvajo.add(iCost);
        iCost.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Cost Army Planet", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        iCost.add(iRelleno5);
        iCost.add(iRelleno6);
        iCost.add(iRelleno7);
        iCost.add(iRelleno8);

        iCost.add(iRelleno1);
        iCost.add(iMetal);
        iCost.add(iMetalCant);
        iCost.add(iRelleno2);

        iCost.add(iRelleno3);
        iCost.add(iDeuterium);
        iCost.add(iDeuteriumCant);
        iCost.add(iRelleno4);

        iCost.add(iRelleno9);
        iCost.add(iRelleno10);
        iCost.add(iRelleno11);
        iCost.add(iRelleno12);

        iCost.add(iRelleno13);
        iCost.add(iRelleno14);
        iCost.add(iRelleno15);
        iCost.add(iRelleno16);


        iAvajo.add(iEnemyCost);
        iEnemyCost.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Cost Army Enemy", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        iEnemyCost.add(iEnemyRelleno5);
        iEnemyCost.add(iEnemyRelleno6);
        iEnemyCost.add(iEnemyRelleno7);
        iEnemyCost.add(iEnemyRelleno8);

        iEnemyCost.add(iEnemyRelleno1);
        iEnemyCost.add(iEnemyMetal);
        iEnemyCost.add(iEnemyMetalCant);
        iEnemyCost.add(iEnemyRelleno2);

        iEnemyCost.add(iEnemyRelleno3);
        iEnemyCost.add(iEnemyDeuterium);
        iEnemyCost.add(iEnemyDeuteriumCant);
        iEnemyCost.add(iEnemyRelleno4);

        iEnemyCost.add(iEnemyRelleno9);
        iEnemyCost.add(iEnemyRelleno10);
        iEnemyCost.add(iEnemyRelleno11);
        iEnemyCost.add(iEnemyRelleno12);

        iEnemyCost.add(iEnemyRelleno13);
        iEnemyCost.add(iEnemyRelleno14);
        iEnemyCost.add(iEnemyRelleno15);
        iEnemyCost.add(iEnemyRelleno16);



        iPerdidas.setLayout(new GridLayout(4,4, 10,5));
        iPerdidas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Losses Army Planet", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        iPerdidas.add(iLostRelleno1);
        iPerdidas.add(iLostMetal);
        iPerdidas.add(iLostMetalCant);
        iPerdidas.add(iLostRelleno2);

        iPerdidas.add(iLostRelleno3);
        iPerdidas.add(iLostDeuterium);
        iPerdidas.add(iLostDeuteriumCant);
        iPerdidas.add(iLostRelleno4);

        iPerdidas.add(iLostRelleno5);
        iPerdidas.add(iLostWheighted);
        iPerdidas.add(iLostWheightedCant);
        iPerdidas.add(iLostRelleno6);

        iPerdidas.add(iLostRelleno7);
        iPerdidas.add(iLostRelleno8);
        iPerdidas.add(iLostRelleno9);
        iPerdidas.add(iLostRelleno10);

        iAvajo.add(iPerdidas);


        iEnemyPerdidas.setLayout(new GridLayout(4,4, 10,5));
        iEnemyPerdidas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Losses Army Enemy", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        iEnemyPerdidas.add(iLostEnemyRelleno1);
        iEnemyPerdidas.add(iLostEnemyMetal);
        iEnemyPerdidas.add(iLostEnemyMetalCant);
        iEnemyPerdidas.add(iLostEnemyRelleno2);

        iEnemyPerdidas.add(iLostEnemyRelleno3);
        iEnemyPerdidas.add(iLostEnemyDeuterium);
        iEnemyPerdidas.add(iLostEnemyDeuteriumCant);
        iEnemyPerdidas.add(iLostEnemyRelleno4);

        iEnemyPerdidas.add(iLostEnemyRelleno5);
        iEnemyPerdidas.add(iLostEnemyWheighted);
        iEnemyPerdidas.add(iLostEnemyWheightedCant);
        iEnemyPerdidas.add(iLostEnemyRelleno6);

        iEnemyPerdidas.add(iLostEnemyRelleno7);
        iEnemyPerdidas.add(iLostEnemyRelleno8);
        iEnemyPerdidas.add(iLostEnemyRelleno9);
        iEnemyPerdidas.add(iLostEnemyRelleno10);

        iAvajo.add(iEnemyPerdidas);

        iAvajo.setBackground(Color.GRAY);

        derecha.setLayout(new BoxLayout(derecha, BoxLayout.Y_AXIS));
        principal.add(derecha);
        derecha.add(dArriba);

        dAvajo.setLayout(new GridLayout(2,2));
        dAvajo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Wasted Generated", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        dAvajo.add(iGenMetal);
        dAvajo.add(iGenMetalCant);
        dAvajo.add(iGenDeuterium);
        dAvajo.add(iGenDeuteriumCant);
        derecha.add(dAvajo);
        derecha.setBackground(Color.GREEN);



        menu = new JMenuBar();

        ViewPlanetStats = new JMenu("<html><p style='text-align:center;width:150px;'>View Planet Stats</p></html>");
        Build = new JMenu("<html><p style='text-align:center;width:150px;'>Build");
        UpgradeTecnology = new JMenu("<html><p style='text-align:center;width:150px;'>Upgrade Technology");
        ViewBattleReports = new JMenu("<html><p style='text-align:center;width:150px;'>View Battle Reports");
        Exit = new JMenu("<html><p style='text-align:center;width:150px;'>Exit");

        BuildDefense = new JMenuItem("<html><p style='text-align:center;width:140px;'>Defense");
        BuildShips = new JMenuItem("<html><p style='text-align:center;width:140px;'>Ships");

        Build.add(BuildShips);
        Build.add(BuildDefense);

        menu.add(ViewPlanetStats);
        menu.add(Build);
        menu.add(UpgradeTecnology);
        menu.add(ViewBattleReports);
        menu.add(Exit);

        ViewPlanetStats.addMouseListener(this);
        ViewBattleReports.addMouseListener(this);
        Exit.addMouseListener(this);
        UpgradeTecnology.addMouseListener(this);


        BuildShips.addActionListener(this);
        BuildDefense.addActionListener(this);

        bSelect.addActionListener(this);


        add(menu, BorderLayout.NORTH);
        menu.add(Box.createRigidArea(new Dimension(20,50)));
        //menu.setMargin(new Insets(0,50,0,50));

        this.setTitle("Planet Wars");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(1024,768);
        this.setResizable(false);

        Toolkit pantalla = Toolkit.getDefaultToolkit();

        Dimension grandaria = pantalla.getScreenSize();
        int ancho = grandaria.width;
        int alto = grandaria.height;

        this.setLocation((ancho/2) - (this.getWidth() / 2), (alto / 2) - (this.getHeight() / 2));

        Image imagen = pantalla.getImage("./src/Planet Wars.png");

        this.setIconImage(imagen);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(BuildShips)) {
            VentanaBuildShip vbs = new VentanaBuildShip();
            vbs.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(BuildDefense)) {
            VentanaBuildDefense vbd = new VentanaBuildDefense();
            vbd.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(bSelect)) {
            BaseDatos bd = new BaseDatos();
            String num = (String) selector.getSelectedItem();

            //Units

            int lightHunter;
            int heavyHunter;
            int battleShip;
            int armoredShip;
            int missileLauncher;
            int ionCannon;
            int plasmaCannon;

            int enemyLightHunter;
            int enemyHeavyHunter;
            int enemyBattleShip;
            int enemyArmoredShip;

            // Drops

            int dropLightHunter;
            int dropHeavyHunter;
            int dropBattleShip;
            int dropArmoredShip;
            int dropMissileLauncher;
            int dropIonCannon;
            int dropPlasmaCannon;

            int dropEnemyLightHunter;
            int dropEnemyHeavyHunter;
            int dropEnemyBattleShip;
            int dropEnemyArmoredShip;

            int initArmyMetal;
            int initArmyDeuterium;
            int initEnemyArmyMetal;
            int initEnemyArmyDeuterium;

            int wastMetal;
            int wastDeuterium;

            try {

                //Unit

                lightHunter = bd.getbLogStartLH(Integer.parseInt(num));
                heavyHunter = bd.getbLogStartHH(Integer.parseInt(num));
                battleShip = bd.getbLogStartBS(Integer.parseInt(num));
                armoredShip = bd.getbLogStartAS(Integer.parseInt(num));
                missileLauncher = bd.getbLogStartML(Integer.parseInt(num));
                ionCannon = bd.getbLogStartIC(Integer.parseInt(num));
                plasmaCannon = bd.getbLogStartPC(Integer.parseInt(num));

                enemyLightHunter = bd.getbEnemiLogStartLH(Integer.parseInt(num));
                enemyHeavyHunter = bd.getbEnemiLogStartHH(Integer.parseInt(num));
                enemyBattleShip = bd.getbEnemiLogStartBS(Integer.parseInt(num));
                enemyArmoredShip = bd.getbEnemiLogStartAS(Integer.parseInt(num));


                //Drop

                dropLightHunter = bd.getbLogEndLH(Integer.parseInt(num));
                dropHeavyHunter = bd.getbLogEndHH(Integer.parseInt(num));
                dropBattleShip = bd.getbLogEndBS(Integer.parseInt(num));
                dropArmoredShip = bd.getbLogEndAS(Integer.parseInt(num));
                dropMissileLauncher = bd.getbLogEndML(Integer.parseInt(num));
                dropIonCannon = bd.getbLogEndIC(Integer.parseInt(num));
                dropPlasmaCannon = bd.getbLogEndPC(Integer.parseInt(num));

                dropEnemyLightHunter = bd.getbEnemiLogEndLH(Integer.parseInt(num));
                dropEnemyHeavyHunter = bd.getbEnemiLogEndHH(Integer.parseInt(num));
                dropEnemyBattleShip = bd.getbEnemiLogEndBS(Integer.parseInt(num));
                dropEnemyArmoredShip = bd.getbEnemiLogEndAS(Integer.parseInt(num));

                //Wast

                wastMetal = bd.getWastMetal(Integer.parseInt(num));
                wastDeuterium = bd.getWastDeuterium(Integer.parseInt(num));

                initArmyMetal = bd.getCostArmyMetal(Integer.parseInt(num));
                initArmyDeuterium = bd.getCostArmyDeuterium(Integer.parseInt(num));
                initEnemyArmyMetal = bd.getCostEnemyArmyMetal(Integer.parseInt(num));
                initEnemyArmyDeuterium = bd.getCostEnemyArmyDeuterium(Integer.parseInt(num));

            } catch (SQLException s) {
                throw new RuntimeException(s);
            }

            //Unit

            iArmyCantLH.setText(String.valueOf(lightHunter));
            iArmyCantHH.setText(String.valueOf(heavyHunter));
            iArmyCantBS.setText(String.valueOf(battleShip));
            iArmyCantAS.setText(String.valueOf(armoredShip));
            iArmyCantML.setText(String.valueOf(missileLauncher));
            iArmyCantIC.setText(String.valueOf(ionCannon));
            iArmyCantPC.setText(String.valueOf(plasmaCannon));

            iEnemyArmyCantLH.setText(String.valueOf(enemyLightHunter));
            iEnemyArmyCantHH.setText(String.valueOf(enemyHeavyHunter));
            iEnemyArmyCantBS.setText(String.valueOf(enemyBattleShip));
            iEnemyArmyCantAS.setText(String.valueOf(enemyArmoredShip));


            //Drop

            iArmyDropLH.setText(String.valueOf(dropLightHunter));
            iArmyDropHH.setText(String.valueOf(dropHeavyHunter));
            iArmyDropBS.setText(String.valueOf(dropBattleShip));
            iArmyDropAS.setText(String.valueOf(dropArmoredShip));
            iArmyDropML.setText(String.valueOf(dropMissileLauncher));
            iArmyDropIC.setText(String.valueOf(dropIonCannon));
            iArmyDropPC.setText(String.valueOf(dropPlasmaCannon));

            iEnemyArmyDropLH.setText(String.valueOf(dropEnemyLightHunter));
            iEnemyArmyDropHH.setText(String.valueOf(dropEnemyHeavyHunter));
            iEnemyArmyDropBS.setText(String.valueOf(dropEnemyBattleShip));
            iEnemyArmyDropAS.setText(String.valueOf(dropEnemyArmoredShip));

            iGenMetalCant.setText(String.valueOf(wastMetal));
            iGenDeuteriumCant.setText(String.valueOf(wastDeuterium));

            iMetalCant.setText(String.valueOf(initArmyMetal));
            iDeuteriumCant.setText(String.valueOf(initArmyDeuterium));
            iEnemyMetalCant.setText(String.valueOf(initEnemyArmyMetal));
            iEnemyDeuteriumCant.setText(String.valueOf(initEnemyArmyDeuterium));

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(ViewPlanetStats)) {
            Main vps = new Main();
            vps.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(UpgradeTecnology)) {
            VentanaUpgradeTechnology vup = new VentanaUpgradeTechnology();
            vup.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(ViewBattleReports)) {
            JOptionPane.showMessageDialog(null,"Ya estas en este menu","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource().equals(Exit)) {
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
