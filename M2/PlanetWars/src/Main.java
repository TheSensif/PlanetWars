import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.*;
import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Main extends JFrame implements ActionListener,MouseListener {

    private JMenuBar menu;
    private JMenu ViewPlanetStats,Build,UpgradeTecnology,ViewBattleReports,Exit;
	private JMenuItem BuildDefense,BuildShips,AttackTechnology,DefenseTechnology;
    private JPanel center;
    private JLabel metal,nMetal,deuterium,nDeuterium;
    private String nombrePlaneta = "planeta";

    public Main() {
        menu = new JMenuBar();
        add(menu, BorderLayout.NORTH);
        menu.add(Box.createRigidArea(new Dimension(20,50)));

        center = new JPanel();
        this.add(center);
        center.setBackground(Color.white);

        center.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), nombrePlaneta, TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));

        //panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), nombrePlaneta, TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));

        metal = new JLabel("Metal:");
        nMetal = new JLabel("0");
        deuterium = new JLabel("Deuterium:");
        nDeuterium = new JLabel("2");

        center.add(metal);
        center.add(nMetal);
        center.add(deuterium);
        center.add(nDeuterium);
        /*
        metal = new JLabel("Metal");
        nMetal = new JLabel("0");
        panel.add(metal,BorderLayout.CENTER);
        panel.add(nMetal,BorderLayout.CENTER);

         */





        ViewPlanetStats = new JMenu("<html><p style='text-align:center;width:150px;'>View Planet Stats</p></html>");
        Build = new JMenu("<html><p style='text-align:center;width:150px;'>Build");
        UpgradeTecnology = new JMenu("<html><p style='text-align:center;width:150px;'>Upgrade Technology");
        ViewBattleReports = new JMenu("<html><p style='text-align:center;width:150px;'>View Battle Reports");
        Exit = new JMenu("<html><p style='text-align:center;width:150px;'>Exit");

        BuildDefense = new JMenuItem("<html><p style='text-align:center;width:140px;'>Defense");
        BuildShips = new JMenuItem("<html><p style='text-align:center;width:140px;'>Ships");

        AttackTechnology = new JMenuItem("<html><p style='text-align:center;width:140px;'>Attack Technology");
        DefenseTechnology = new JMenuItem("<html><p style='text-align:center;width:140px;'>Defense Technology");


        Build.add(BuildShips);
        Build.add(BuildDefense);
        UpgradeTecnology.add(AttackTechnology);
        UpgradeTecnology.add(DefenseTechnology);

        menu.add(ViewPlanetStats);
        menu.add(Build);
        menu.add(UpgradeTecnology);
        menu.add(ViewBattleReports);
        menu.add(Exit);

        ViewPlanetStats.addMouseListener(this);
        ViewBattleReports.addMouseListener(this);
        Exit.addMouseListener(this);


        BuildShips.addActionListener(this);
        BuildDefense.addActionListener(this);
        AttackTechnology.addActionListener(this);
        DefenseTechnology.addActionListener(this);


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

	public static void main(String[] args) {
		Main m = new Main();
		Planet p = new Planet();
		Timer timer = new Timer();
		TimerTask resourcesGeneration = new TimerTask() {
			public void run()
			{
				System.out.println("The resources has been generated");
				p.setMetal(p.getMetal() + 200);
				p.setDeuterium(p.getDeuterium() + 10);
				System.out.println("Actual metal -> " + p.getMetal());
				System.out.println("Actual deuterium -> " + p.getDeuterium());
			}
		};
		

		timer.schedule(resourcesGeneration, 5000, 5000); 
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
        if (e.getSource().equals(AttackTechnology)) {
            VentanaAttackTechnology vat = new VentanaAttackTechnology();
            vat.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(DefenseTechnology)) {
            VentanaDefenseTechnology vdt = new VentanaDefenseTechnology();
            vdt.setVisible(true);
            this.setVisible(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(ViewPlanetStats)) {
            JOptionPane.showMessageDialog(null,"Ya estas en este menu","Mensaje",JOptionPane.INFORMATION_MESSAGE);
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
