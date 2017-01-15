/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ParamPickerPanel.java
 *
 * Created on 2009-9-3, 18:39:47
 */
package org.jhrcore.client.report;

import com.fr.cell.ReportPane;
import com.fr.design.actions.report.ReportParameterAction;
import com.fr.report.Report;
import com.fr.report.ReportParameterAttr;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTextPane;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JListBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author wangzhenhua
 */
public class ParamPickerPanel extends javax.swing.JPanel {

    private JTextPane textPane;
    private ArrayList localArrayList = new ArrayList();

    public ArrayList getLocalArrayList() {
        return localArrayList;
    }
    private JListBinding listBinding;
    private static ParamPickerPanel paramPickerPanel;

    public static ParamPickerPanel getParamPickerPanel() {
        return paramPickerPanel;
    }

    /** Creates new form ParamPickerPanel */
    public ParamPickerPanel(JTextPane tp) {
        paramPickerPanel = this;
        textPane = tp;
        initComponents();
        showReportParamters();
        setupEvents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("�༭");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(267, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void setupEvents() {
        jList1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() < 2) {
                    return;
                }
                if (jList1.getSelectedValue() == null)
                    return;
                
                int i = textPane.getCaretPosition();
                String content = "[?" + jList1.getSelectedValue().toString().replaceFirst("\\$", "") + "?]";
                String s = textPane.getText().substring(0, textPane.getCaretPosition()) + content + textPane.getText().substring(textPane.getCaretPosition());
                textPane.setText(s);
                textPane.setCaretPosition(i + content.length());
            }
        });
        jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ReportParameterAction ac = new ReportParameterAction();
                ac.executeAction(null);
                showReportParamters();
            }
            
        });
    }
    // End of variables declaration

    public void showReportParamters() {
        ReportPane localReportPane = ReportPanel.getJWorkSheet();
        Report localReport = localReportPane.getEditingReport();
        /*ParameterArrayPane localParameterArrayPane = new ParameterArrayPane();
        BasicDialog localBasicDialog = localParameterArrayPane.showWindow(SwingUtilities.getWindowAncestor(localReportPane), Inter.getLocText("ParameterD-Report_Parameter"), 600, 490);
        localBasicDialog.setModal(true);*/        
        ReportParameterAttr localReportParameterAttr = localReport.getWorkBook().getReportParameterAttr();
        
        localArrayList.clear();
        if (localReportParameterAttr != null) {
            int i = 0;
            int j = localReportParameterAttr.getParameters().length;
            while (i < j) {
                localArrayList.add(localReportParameterAttr.getParameters()[i]);
                ++i;
            }
        }

        if (listBinding == null) {
            listBinding = SwingBindings.createJListBinding(UpdateStrategy.READ, localArrayList, jList1);
        } else listBinding.unbind();
        listBinding.bind();
    }
}
