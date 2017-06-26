/**
 * Created by Marcin on 25.06.2017.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SwingExamples implements ItemListener , ListSelectionListener {
    JLabel jlabSelected;
    JLabel jlabChanged;
    JCheckBox jcbAlpha;
    JCheckBox jcbBeta;
    JCheckBox jcbGamma;
    JList<String> jlst;
    JLabel jlab;
    JLabel jlab1;
    JScrollPane jscrlp;
    String[] names = {
        "Ewa","Janina","Robert","Sandra","Joanna","Rafał",
                "Bolek","Maria","Krzysio","Andrzej","Maciej","Tomek"
    };

    public SwingExamples() {
        JFrame jfrm = new JFrame("PC");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(220,300);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setLocationRelativeTo(null);


        jlabSelected = new JLabel("");
        jlabChanged = new JLabel("");
        jcbAlpha = new JCheckBox("Alfa");
        jcbBeta = new JCheckBox("Beta");
        jcbGamma = new JCheckBox("Gamma");
        jlst = new JList<String>(names);
        jscrlp = new JScrollPane(jlst);
        jscrlp.setPreferredSize(new Dimension(120,120));
        jlab = new JLabel("Aktualne imię: Wybierz imię");
        jlab1 = new JLabel("          ");

        jcbAlpha.addItemListener(this);
        jcbBeta.addItemListener(this);
        jcbGamma.addItemListener(this);
        jlst.addListSelectionListener(this);

        jfrm.add(jscrlp);
        jfrm.add(jlab);
        jfrm.add(jlab1);
        jfrm.add(jcbAlpha);
        jfrm.add(jcbBeta);
        jfrm.add(jcbGamma);
        jfrm.add(jlabChanged);
        jfrm.add(jlabSelected);

        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jfrm.setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        String str = "";

        JCheckBox cb = (JCheckBox) e.getItem();

        if (cb.isSelected()){
            jlabChanged.setText(cb.getText() + ": zaznaczone.");
        }else{
            jlabChanged.setText(cb.getText() + ": usunięte.");
        }

        if (jcbAlpha.isSelected()){
            str+=" Alfa ";
        }
        if (jcbBeta.isSelected()){
            str+=" Beta ";
        }
        if (jcbGamma.isSelected()){
            str+=" Gamma ";
        }
        jlabSelected.setText("Zaznaczone: " + str);
    }

    public void valueChanged(ListSelectionEvent e) {
        int idx = jlst.getSelectedIndex();

        if (idx != -1){
            jlab.setText("Aktualny wybór: " + names[idx]);
        }else{
            jlab.setText("Wybierz imię");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingExamples();
            }
        });
    }
}
