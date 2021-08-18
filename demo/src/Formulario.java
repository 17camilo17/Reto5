import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.image;

public class Formulario extends Requerimientos {
    JFrame frame;
    JTable tabla1, tabla, tabla3 = new JTable();
    JButton send1, send2, send3;
    Image imagen;

    public Formulario() throws SQLException {

        initFormulario();
    }

    private void initFormulario() throws SQLException {

        frame = new JFrame("REto5");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setResizable(false);

        // menu Bar:

        JMenuBar mb = new JMenuBar();
        mb.setAlignmentY(Component.LEFT_ALIGNMENT);
        JMenu m1 = new JMenu("ARCHIVO");
        JMenu m2 = new JMenu("CONSULTAS");
        JMenu m3 = new JMenu("ACERCA DE");

        // ADiciones MEnu Bar:

        mb.add(m1);
        mb.add(m2);
        mb.add(m3);

        // Create JMenuItem:
        JMenuItem MeI1 = new JMenuItem("Salir");
        JMenuItem MeI2 = new JMenuItem("Consulta 1");
        JMenuItem MeI3 = new JMenuItem("Consulta 2");
        JMenuItem MeI4 = new JMenuItem("Consulta 3");
        JMenuItem MeI5 = new JMenuItem("Elaborado Por Camilo Fuentes Cardozo Grupo 72");

        // Add Jmenu

        m1.add(meI1);
        m2.add(meI2);
        m2.add(meI3);
        m2.add(meI4);
        m3.add(meI3);

        // Construccion del Objeto JPanel para guardar la botonera:
        JPanel Botonera = new JPanel();

        // instrucciones para que el layout y el flowlayout y sus componentes esten
        // centrados:
        Botonera.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Creacion de Label para dar Espaciado entre los Botones:
        JLabel espacio1 = new JLabel("        ");
        JLabel espacio2 = new JLabel("        ");

        // Construccion de Botones:
        JButton send1 = new JButton("Consulta 1");
        JButton send2 = new JButton("Consulta 2");
        JButton send3 = new JButton("Consulta 3");

        // Adicion de Botones Al Panel:
        Botonera.add(send1);
        Botonera.add(espacio1);
        Botonera.add(send2);
        Botonera.add(espacio2);
        Botonera.add(send3);

        // Creacion de Tablas Y Cabeceras:
        // First Query:
        String[] nombres1 = { "ID_Proyecto", "Ciudad", "Banco_Vinculado", "Constructora", "Clasificacion" };
        tabla1 = new JTable(mostrar(), nombres1);

        // Second Query:
        String[] nombres2 = { "Nombre", "Primer Apellido", "Ciudad Residencia", "Cargo", "Salario" };
        tabla2 = new JTable(mostrar2(), nombres2);

        // Thirth Query:
        String[] nombres3 = { "Proveedor", "Pagado", "Constructora" };
        tabla3 = new JTable(mostrar(), nombres3);

        // JscrollPane para Albergar las tablas:
        JScrollPane Panel = new JScrollPane();

        // Agregamos los Paneles al panel BordeLayout Que Sera el Principal:
        frame.getContentPane().add(BorderLayout.SOUTH, Botonera);
        frame.getContentPane().add(Panel, BorderLayout.CENTER);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        // Creacion de eventos Action Listener y los Adicionamos al Boton y a los
        // MenuItem
        ActionListener consulta1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                Panel.add(tabla1);
                Panel.setViewportView(tabla1);
            }
        };

        send2.addActionListener(consulta1);
        MeI2.addActionListener(consulta1);

        ActionListener consulta2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                Panel.add(tabla2);
                Panel.setViewportView(tabla2);
            }
        };

        send2.addActionListener(consulta2);
        MeI3.addActionListener(consulta3);

        ActionListener consulta3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                Panel.add(tabla3);
                Panel.setViewportView(tabla3);
            }
        };

        send3.addActionListener(consulta3);
        MeI4.addActionListener(consulta3);

        // EVENTO Action Listener Para Salir:
        ActionListener salir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                // Con esta linea Cerramos La Aplicacion:
                System.exit(0);
            }
        };

        MeI1.addActionListener(salir);

    }

}
