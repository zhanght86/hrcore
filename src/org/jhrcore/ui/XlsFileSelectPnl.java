/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * XlsFileSelectPnl.java
 *
 * Created on 2013-10-25, 15:46:48
 */
package org.jhrcore.ui;

import com.foundercy.pf.control.listener.IPickPopupListener;
import com.foundercy.pf.control.table.FTable;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import org.jhrcore.entity.FileManager;
import org.jhrcore.msg.CommMsg;
import org.jhrcore.util.FileChooserUtil;
import org.jhrcore.util.MsgUtil;

/**
 *
 * @author mxliteboss
 */
public class XlsFileSelectPnl extends javax.swing.JPanel {

    private JMenuItem miAdd = new JMenuItem("��ȡ�ļ�");
    private JMenuItem miDel = new JMenuItem("ɾ��");
    private FTable file_table;
    private HashSet<String> exist_files = new HashSet<String>();

    /** Creates new form XlsFileSelectPnl */
    public XlsFileSelectPnl() {
        initComponents();
        initOthers();
        setupEvents();
    }

    private void initOthers() {
        List<String> fields = new ArrayList<String>();
        fields.add("file_name");
        fields.add("file_type");
        fields.add("file_size");
        file_table = new FTable(FileManager.class, fields, false, false, false, "ImportXLSDialog");
        file_table.setRight_allow_flag(true);
        add(file_table, BorderLayout.CENTER);
        file_table.addPickPopupListener(new IPickPopupListener() {

            @Override
            public void addMenuItem(JPopupMenu pp) {
                pp.removeAll();
                pp.add(miAdd);
                pp.addSeparator();
                pp.add(miDel);
            }
        });
    }

    public List<FileManager> getSelectFiles() {
        return file_table.getObjects();
    }

    private void setupEvents() {
        miAdd.addActionListener(new XlsSelectAction());
        miDel.addActionListener(new XlsDelAction());
    }

    public void doXlsSelectAction(JButton btn) {
        btn.addActionListener(new XlsSelectAction());
    }

    public void doXlsDelAction(JButton btn) {
        btn.addActionListener(new XlsDelAction());
    }

    class XlsSelectAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            File file = FileChooserUtil.getXLSFile(CommMsg.SELECTXLSFILE_MESSAGE);
            if (file == null) {
                return;
            }
            String[] fileName = file.getName().split("\\.");
            if (exist_files.contains(fileName[0].toLowerCase())) {
                MsgUtil.showErrorMsg("�ļ��Ѵ���");
            } else {
                FileManager fm = new FileManager();
                fm.setFile(file);
                fm.setFile_name(fileName[0]);
                fm.setFile_type(fileName[fileName.length - 1]);
                fm.setFile_size(file.length() / 1024);
                file_table.addObject(fm);
                exist_files.add(fileName[0].toLowerCase());
            }
        }
    }

    class XlsDelAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            for (Object obj : file_table.getSelectObjects()) {
                exist_files.remove(((FileManager) obj).getFile_name());
            }
            file_table.deleteSelectedRows();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}