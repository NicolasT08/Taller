package org.example.view;

import org.example.control.RelationShipController;
import org.example.model.NPC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Window extends JFrame implements ActionListener {

    private RelationShipController controller;
    private JLabel title;
    private JComboBox jComboBox1;
    private JComboBox jComboBox2;
    private JTextField result;
    private JButton search;
    private JPanel principal;


    public Window(){
        super("Dijakstra");
        this.controller = new RelationShipController();

        setPanel();
        this.getVertex();
    }

    public void setPanel(){

        this.setSize(400,400);
        this.setResizable(false);

        this.principal = new JPanel(new GridLayout(2,1));

        JPanel firstRowPanel = new JPanel(new GridLayout(1, 2)); // 1 fila, 2 columnas


        // Izquierda superior
        JPanel panel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 30, 50, 0);


        JLabel label1 = new JLabel("Inicio");
        panel1.add(label1, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 10, 0);
        this.jComboBox1 = new JComboBox<String>();
        this.jComboBox1.setPreferredSize(new Dimension(100, 20));
        this.jComboBox1.setModel(new DefaultComboBoxModel<>(this.getVertex()));

        panel1.add(jComboBox1, gbc);

        firstRowPanel.add(panel1);


        //derecha superior

        JPanel panel2 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 30, 50, 0);


        JLabel label2 = new JLabel("Objetivo");
        panel2.add(label2, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 10, 0);
        this.jComboBox2 = new JComboBox<String>();
        this.jComboBox2.setPreferredSize(new Dimension(100, 20));
        this.jComboBox2.setModel(new DefaultComboBoxModel<>(this.getVertex()));

        panel2.add(jComboBox2, gbc);
        firstRowPanel.add(panel2);



        // Segunda fila
        JPanel secondRowPanel = new JPanel();
        JPanel panel3 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 160, 0, 0);

        this.search = new JButton("Search");
        this.search.addActionListener(this);

        panel3.add(this.search, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0);

        this.result = new JTextField("Resultado");
        this.result.setEditable(false);
        this.result.setPreferredSize(new Dimension(400,70));
        this.result.setBackground(null);
        this.result.setBorder(null);
        this.result.setHorizontalAlignment(SwingConstants.CENTER);

        panel3.add(this.result, gbc);


        secondRowPanel.add(panel3);


        this.principal.add(firstRowPanel);
        this.principal.add(secondRowPanel);
        this.getContentPane().add(this.principal);
        this.setVisible(true);

    }

    private String[] getVertex(){

        String[] result = new String[this.controller.getNpc().length];

        for ( int i = 0; i < result.length ; i++){
            result[i] = this.controller.getNpc()[i].getName();
        }

        return result;
    }
    private String getPath(List<NPC> shortestPath){

        String result = "";

        for ( int i = 0; i < shortestPath.size() ; i++ ){

            if( i < shortestPath.size()-1 ){
                result += shortestPath.get(i).getName()+"-->";
            } else {
                result += shortestPath.get(i).getName();
            }



        }

        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == this.search ){

            String source = (String) this.jComboBox1.getSelectedItem();
            String target = (String) this.jComboBox2.getSelectedItem();

            if( source.equals(target)){
                this.result.setText("Es el mismo NPC");
            }else {
                if ( this.controller.findNPC(source) != null && this.controller.findNPC(target) != null) {

                    List<NPC> shortestPath = controller.calculateShortestPath(source, target);

                    if (shortestPath != null) {

                        this.result.setText(this.getPath(shortestPath));

                    } else {
                        this.result.setText("No se encontró un camino entre los NPC.");
                    }
                } else {
                    this.result.setText("No se encontraron NPC con los nombres especificados.");
                }
            }

        }
    }
}
