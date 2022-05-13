import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import java.awt.*;
import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class Main extends JFrame implements ActionListener,MouseListener, Variables {
	private ArrayList<MilitaryUnit>[] eArmy = new ArrayList[4];
	private int activePlanet;
	
	private JMenuBar menu;
    private JMenu ViewPlanetStats,Build,UpgradeTecnology,ViewBattleReports,Exit;
	private JMenuItem BuildDefense,BuildShips;
    private JPanel center;
    //Materiales
    private JLabel metal,nMetal,deuterium,nDeuterium;
    //Army
    private JLabel imagenLH,nombreLH,cantLH;
    private JLabel imagenHH,nombreHH,cantHH;
    private JLabel imagenBS,nombreBS,cantBS;
    private JLabel imagenAR,nombreAR,cantAR;
    private JLabel imagenMS,nombreMS,cantMS;
    private JLabel imagenIC,nombreIC,cantIC;
    private JLabel imagenPC,nombrePC,cantPC;
    
    private String nombrePlaneta = "planeta";

    public Main() throws IOException {
        menu = new JMenuBar();
        add(menu, BorderLayout.NORTH);
        menu.add(Box.createRigidArea(new Dimension(20,50)));

        center = new JPanel();
        this.add(center);
        center.setBackground(Color.white);

        center.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), nombrePlaneta, TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        //Panel Proincipal
        center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));
        JPanel derecha = new JPanel();
        JPanel izquierda = new JPanel();
        center.add(derecha);
        derecha.setBackground(Color.WHITE);
        center.add(izquierda);
        izquierda.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Army", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        izquierda.setBackground(Color.WHITE);

        //Panel derecha
        JPanel arriba = new JPanel();
        JPanel abajo = new JPanel();
        derecha.setLayout(new BoxLayout(derecha, BoxLayout.Y_AXIS));
        derecha.add(arriba);
        arriba.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Recursos", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        arriba.setBackground(Color.WHITE);

        JPanel pMetal = new JPanel();
        JPanel pDeuterium = new JPanel();

        arriba.setLayout(new BoxLayout(arriba, BoxLayout.X_AXIS));

        arriba.add(pMetal);
        arriba.add(pDeuterium);
        pMetal.setBackground(Color.WHITE);
        pDeuterium.setBackground(Color.WHITE);

        metal = new JLabel("Metal:");
        nMetal = new JLabel("0");

        pMetal.add(metal);
        pMetal.add(nMetal);

        deuterium = new JLabel("Deuterium:");
        nDeuterium = new JLabel("0");

        pDeuterium.add(deuterium);
        pDeuterium.add(nDeuterium);

        derecha.add(abajo);
        abajo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Defensa", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        abajo.setBackground(Color.WHITE);

        //Paneles arrmy

        JPanel ar1 = new JPanel();
        JPanel ar2 = new JPanel();
        JPanel ar3 = new JPanel();
        JPanel ar4 = new JPanel();
        JPanel ar5 = new JPanel();
        JPanel ar6 = new JPanel();
        JPanel ar7 = new JPanel();

        izquierda.setLayout(new BoxLayout(izquierda, BoxLayout.Y_AXIS));

        izquierda.add(ar1);
        ar1.setBackground(Color.LIGHT_GRAY);
        imagenLH = new JLabel();
        imagenLH.setLocation(0,0);
        nombreLH = new JLabel("LightHunter");
        cantLH = new JLabel("0");
        ar1.add(imagenLH);
        ar1.add(nombreLH);
        ar1.add(cantLH);
        
        izquierda.add(ar2);
        ar2.setBackground(Color.GRAY);
        imagenHH = new JLabel("");
        nombreHH = new JLabel("HeavyHunter");
        cantHH = new JLabel("0");
        ar2.add(imagenHH);
        ar2.add(nombreHH);
        ar2.add(cantHH);
        
        izquierda.add(ar3);
        ar3.setBackground(Color.LIGHT_GRAY);
        imagenBS = new JLabel("");
        nombreBS = new JLabel("BattleShip");
        cantBS = new JLabel("0");
        ar3.add(imagenBS);
        ar3.add(nombreBS);
        ar3.add(cantBS);

        izquierda.add(ar4);
        ar4.setBackground(Color.GRAY);
        imagenAR = new JLabel("");
        nombreAR = new JLabel("ArmoredShip");
        cantAR = new JLabel("0");
        ar4.add(imagenAR);
        ar4.add(nombreAR);
        ar4.add(cantAR);
        
        abajo.add(ar5);
        ar5.setBackground(Color.LIGHT_GRAY);
        imagenMS = new JLabel("");
        nombreMS = new JLabel("MissileLauncher");
        cantMS = new JLabel("0");
        ar5.add(imagenMS);
        ar5.add(nombreMS);
        ar5.add(cantMS);

        abajo.add(ar6);
        ar6.setBackground(Color.GRAY);
        imagenIC = new JLabel("");
        nombreIC = new JLabel("IonCannon");
        cantIC = new JLabel("0");
        ar6.add(imagenIC);
        ar6.add(nombreIC);
        ar6.add(cantIC);

        abajo.add(ar7);
        ar7.setBackground(Color.LIGHT_GRAY);
        imagenPC = new JLabel("");
        nombrePC = new JLabel("PlasmaCannon");
        cantPC = new JLabel("0");
        ar7.add(imagenPC);
        ar7.add(nombrePC);
        ar7.add(cantPC);

        abajo.setLayout(new BoxLayout(abajo, BoxLayout.Y_AXIS));

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
	
	public JLabel getnMetal() {
		return nMetal;
	}

	public void setnMetal(JLabel nMetal) {
		this.nMetal = nMetal;
	}

	public JLabel getnDeuterium() {
		return nDeuterium;
	}

	public void setnDeuterium(JLabel nDeuterium) {
		this.nDeuterium = nDeuterium;
	}

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		Planet p = new Planet();
		Timer timer = new Timer();
		BaseDatos bd = new BaseDatos();
		
		m.setActivePlanet(bd.checkUserPlanet("ItsIvanPsk"));
		System.out.println("PLANETID: " + m.getActivePlanet());
		
		TimerTask resourcesGeneration = new TimerTask() {
			public void run()
			{
				System.out.println("The resources has been generated");
				p.setMetal(p.getMetal() + 200);
				p.setDeuterium(p.getDeuterium() + 10);
				System.out.println("Actual metal -> " + p.getMetal());
				System.out.println("Actual deuterium -> " + p.getDeuterium());
				
				Integer metal = p.getMetal();
				Integer deuterium = p.getDeuterium();
				
				m.nMetal.setText(metal.toString());
				m.nDeuterium.setText(deuterium.toString());
			}

		};
		TimerTask atackWarning = new TimerTask() {
			public void run()
			{
				String warning = "The enemie will atack us in 1 planet rotation!!";
				System.out.println(warning);
			}

		};
		
		timer.schedule(atackWarning, 60000, 60000); 
		timer.schedule(resourcesGeneration, 1000, 1000); 
		System.out.println("Awita!");
	}

	public int getActivePlanet() {
		return activePlanet;
	}

	public void setActivePlanet(int activePlanet) {
		this.activePlanet = activePlanet;
	}

	public void ViewThread()
	{
		ArrayList<MilitaryUnit>[] threadArmy;
		threadArmy = createEnemyArmy();
		
		String header = "New Thread Incoming!";
		int lightHunterCant = threadArmy[0].size();
		int HeavyHunterCant = threadArmy[1].size();
		int BattleShipCant = threadArmy[2].size();
		int ArmoredShipCant = threadArmy[3].size();
	}
	
	public ArrayList<MilitaryUnit>[] createEnemyArmy()
	{
		int lightHunterCant = 0;
		int HeavyHunterCant = 0;
		int BattleShipCant = 0;
		int ArmoredShipCant = 0;
		
		int metalBase = METAL_BASE_ENEMY_ARMY;
		int deutBase = DEUTERIUM_BASE_ENEMY_ARMY;
		
		while (metalBase >= METAL_COST_LIGTHHUNTER && deutBase >= DEUTERIUM_COST_LIGTHHUNTER) {
			double r = Math.random() * 100;
			int random = (int) r;	
			/*
			 * 0-49% -> LH 
			 * 50-69% -> HH
			 * 70%-89 -> BS
			 * 90%-100% -> AS
			*/			
			if (random >=  0 && random <= 49) {
				if (metalBase >= METAL_COST_LIGTHHUNTER && deutBase >= DEUTERIUM_COST_LIGTHHUNTER) {
					metalBase -= METAL_COST_LIGTHHUNTER;
					deutBase -= DEUTERIUM_COST_LIGTHHUNTER;
					eArmy[0].add(new LightHunter());
				}
			}
			if (random >=  50 && random <= 69) {
				if (metalBase >= METAL_COST_HEAVYHUNTER && deutBase >= DEUTERIUM_COST_HEAVYHUNTER) {
					metalBase -= METAL_COST_HEAVYHUNTER;
					deutBase -= DEUTERIUM_COST_HEAVYHUNTER;
					eArmy[1].add(new HeavyHunter());
				}
			}
			if (random >=  70 && random <= 89) {
				if (metalBase >= METAL_COST_BATTLESHIP && deutBase >= DEUTERIUM_COST_BATTLESHIP) {
					metalBase -= METAL_COST_BATTLESHIP;
					deutBase -= DEUTERIUM_COST_BATTLESHIP;
					eArmy[2].add(new BattleShip());
				}
			}
			if (random >=  90 && random <= 100) {
				if (metalBase >= METAL_COST_ARMOREDSHIP && deutBase >= DEUTERIUM_COST_ARMOREDSHIP) {
					metalBase -= METAL_COST_ARMOREDSHIP;
					deutBase -= DEUTERIUM_COST_ARMOREDSHIP;
					eArmy[3].add(new ArmoredShip());
				}
			}
		}
		return eArmy;
	}

	@Override
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
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(ViewPlanetStats)) {
            JOptionPane.showMessageDialog(null,"Ya estas en este menu","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource().equals(UpgradeTecnology)) {
            VentanaUpgradeTechnology vup = new VentanaUpgradeTechnology();
            vup.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(ViewBattleReports)) {
            VentanaViewBattleReports vvbr = new VentanaViewBattleReports();
            vvbr.setVisible(true);
            this.setVisible(false);
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






