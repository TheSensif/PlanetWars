import java.awt.BorderLayout;

import javax.swing.*;
public class Exemple1 extends JFrame{
    private JMenuBar menu;
    public Exemple1(){
        menu=new JMenuBar();
        JMenu arxiu=new JMenu("Arxiu");
        JMenuItem nou=new JMenuItem("Nou");
        arxiu.add(nou);
        JMenuItem obrir=new JMenuItem("Obrir");
        arxiu.add(obrir);
        JMenu editar=new JMenu("Editar");
        JMenuItem copiar=new JMenuItem("Copiar");
        editar.add(copiar);
        JMenuItem pegar=new JMenuItem("Pegar");
        editar.add(pegar);
        menu.add(arxiu);
        menu.add(editar);
        this. add(menu, BorderLayout.NORTH);
        this.setTitle("Exemple JMenu...");
        this.setSize(400, 250);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args){
        new Exemple1();
    }
}