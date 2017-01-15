/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ColumnSumDialog.java
 *
 * Created on 2009-10-5, 16:31:58
 */
package org.jhrcore.ui;

import com.foundercy.pf.control.table.FTable;
import com.foundercy.pf.control.table.RowChangeListner;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import org.jhrcore.client.UserContext;
import org.jhrcore.util.UtilTool;
import org.jhrcore.entity.base.TempFieldInfo;
import org.jhrcore.entity.salary.ValidateSQLResult;
import org.jhrcore.entity.showstyle.ColumnSum;
import org.jhrcore.iservice.impl.CommImpl;
import org.jhrcore.rebuild.EntityBuilder;
import org.jhrcore.ui.action.CloseAction;
import org.jhrcore.ui.renderer.HRRendererView;
import org.jhrcore.util.MsgUtil;

/**
 *
 * @author mxliteboss
 */
public class ColumnSumDialog extends javax.swing.JDialog {

    private Class<?> cur_class;
    private String module_code;
    private List<TempFieldInfo> list_all_field = new ArrayList<TempFieldInfo>();
    private JTree fieldTree;
    private ShowFieldTreeModel sftModel;
    private FTable ftable;
    private List<ColumnSum> exist_sums;
    private boolean click_ok = false;
    private List<ColumnSum> col_sums = new ArrayList<ColumnSum>();

    public boolean isClick_ok() {
        return click_ok;
    }

    public List<ColumnSum> getCol_sums() {
        return col_sums;
    }

    public ColumnSumDialog(Class show_class, List<TempFieldInfo> all_fields, List<ColumnSum> exist_sums, String module_code) {
        this.setTitle("设置汇总行");
        cur_class = show_class;
        this.module_code = module_code;
        this.exist_sums = exist_sums;
        for (TempFieldInfo tfi : all_fields) {
            Field field = tfi.getField();
            if (field.getModifiers() >= Modifier.TRANSIENT) {
                continue;
            }
            list_all_field.add(tfi);
        }
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        initOthers();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        pnlField = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        pnlSum = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        btnSave.setText("应用");

        btnClose.setText("关闭");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(338, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(28, 28, 28)
                .addComponent(btnClose)
                .addGap(35, 35, 35))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(41, Short.MAX_VALUE)))
        );

        jLabel1.setText("字段列表：");

        jLabel2.setText("汇总字段：");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/select_one.png"))); // NOI18N

        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/remove_one.png"))); // NOI18N

        pnlField.setLayout(new java.awt.BorderLayout());

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("求和");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("平均");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("计数");

        pnlSum.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlSum.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jRadioButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jRadioButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jRadioButton3)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlSum, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jLabel2)))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jRadioButton1)
                            .addGap(9, 9, 9)
                            .addComponent(jRadioButton2)
                            .addGap(10, 10, 10)
                            .addComponent(jRadioButton3))
                        .addComponent(pnlField, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlSum, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlField;
    private javax.swing.JPanel pnlSum;
    // End of variables declaration//GEN-END:variables

    private void initOthers() {
        if (list_all_field.isEmpty()) {
            List<TempFieldInfo> list = EntityBuilder.getCommFieldInfoListOf(cur_class, EntityBuilder.COMM_FIELD_VISIBLE);
            for (TempFieldInfo tfi : list) {
                list_all_field.add(tfi);
            }
        }
        int i = 0;
        List removeInfos = new ArrayList();
        for (TempFieldInfo tfi : list_all_field) {
            if (tfi.getField_name().contains(".") && !tfi.getField_name().startsWith("#")) {
                removeInfos.add(tfi);
                continue;
            }
            i++;
            tfi.setOrder_no(i);
        }
        list_all_field.removeAll(removeInfos);
        sftModel = new ShowFieldTreeModel(list_all_field);
        fieldTree = new JTree(sftModel);
        HRRendererView.getCommMap().initTree(fieldTree);
        fieldTree.setRootVisible(false);
        fieldTree.setShowsRootHandles(true);
        pnlField.add(new JScrollPane(fieldTree));
        SearchTreeFieldDialog.doQuickSearch("字段列表", fieldTree);
        ftable = new FTable(ColumnSum.class, false, false);
        ftable.setEditable(true);
        pnlSum.add(ftable, BorderLayout.CENTER);
        if (exist_sums != null) {
            HashSet<String> exist_field_keys = new HashSet<String>();
            for (ColumnSum cs : exist_sums) {
                exist_field_keys.add(cs.getField_name().replace("_code_", ""));
            }
            ftable.setObjects(exist_sums);
            List<DefaultMutableTreeNode> removeNodes = new ArrayList<DefaultMutableTreeNode>();
            Enumeration enumt = ((DefaultMutableTreeNode) sftModel.getRoot()).breadthFirstEnumeration();
            while (enumt.hasMoreElements()) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumt.nextElement();
                Object obj = node.getUserObject();
                if (obj instanceof TempFieldInfo) {
                    if (exist_field_keys.contains(((TempFieldInfo) obj).getField_name().replace("_code_", ""))) {
                        removeNodes.add(node);
                    }
                }
            }
            for (DefaultMutableTreeNode node : removeNodes) {
                node.removeFromParent();
            }
            fieldTree.updateUI();
        }
    }

    private void setupEvents() {
        ftable.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    List list = ftable.getSelectObjects();
                    if (list.size() == 0) {
                        return;
                    }
                    delColumnSum(list);
                }
            }
        });
        fieldTree.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    if (fieldTree.getSelectionPath() == null) {
                        return;
                    }
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) fieldTree.getSelectionPath().getLastPathComponent();
                    Object obj = node.getUserObject();
                    if (obj instanceof TempFieldInfo) {
                        addColumnSum();
                    }
                }
            }
        });
        ftable.addRowChangeListner(new RowChangeListner() {

            @Override
            public void rowChanged(Object obj) {
                ColumnSum cs = (ColumnSum) obj;
                String sum_type = cs.getSum_type();
                String field_name = cs.getField_name().replace("_code_", "");
                if (!sum_type.equals("计数")) {
                    TempFieldInfo sel_tfi = null;
                    for (TempFieldInfo tfi : list_all_field) {
                        if (tfi.getField_name().replace("_code_", "").equals(field_name)) {
                            sel_tfi = tfi;
                            break;
                        }
                    }
                    if (sel_tfi != null) {
                        String field_type = sel_tfi.getField_type().toLowerCase();
                        if (!(field_type.equals("int") || field_type.equals("integer") || field_type.equals("float") || field_type.equals("bigdecimal"))) {
                            JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(btnSave), "非数值型字段仅能进行计数");
                            sum_type = "计数";
                        }
                    }
                }
                cs.setSum_type(sum_type);
                cs.setType(getType(sum_type));
                ftable.updateUI();
            }
        });
        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addColumnSum();
            }
        });
        btnDel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List list = ftable.getSelectObjects();
                if (list.size() == 0) {
                    return;
                }
                delColumnSum(list);
            }
        });
        btnSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ftable.stopEditing();
                saveColumnSum();
                col_sums = ftable.getObjects();
                click_ok = true;
                dispose();
            }
        });
        CloseAction.doCloseAction(btnClose);
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent e) {
                SearchTreeFieldDialog.cancelQuickSearch();
            }
        });
    }

    private void saveColumnSum() {
        ValidateSQLResult result = CommImpl.saveColumnSumScheme(module_code + "." + cur_class.getSimpleName(), UserContext.person_code, ftable.getObjects());
        if (result.getResult() == 0) {
            MsgUtil.showHRSaveSuccessMsg(JOptionPane.getFrameForComponent(btnSave));
        } else {
            MsgUtil.showHRSaveErrorMsg(result);
        }
    }

    private void delColumnSum(List list) {
        List<TempFieldInfo> remove_infos = new ArrayList<TempFieldInfo>();
        for (Object obj : list) {
            ColumnSum cs = (ColumnSum) obj;
            for (TempFieldInfo tfi : list_all_field) {
                if (tfi.getField_name().replace("_code_", "").equals(cs.getField_name().replace("_code_", ""))) {
                    remove_infos.add(tfi);
                    break;
                }
            }
        }
        DefaultMutableTreeNode last_node = null;
        for (TempFieldInfo tfi : remove_infos) {
            last_node = sftModel.addNode(tfi);
        }
        if (last_node != null) {
            fieldTree.clearSelection();
            fieldTree.addSelectionPath(new TreePath(last_node.getPath()));
        }
        fieldTree.updateUI();
        ftable.deleteSelectedRows();

    }

    private void addColumnSum() {
        List<TempFieldInfo> field_infos = new ArrayList<TempFieldInfo>();
        DefaultMutableTreeNode next_node = null;
        TreePath[] select_path = fieldTree.getSelectionPaths();
        Hashtable<String, TreePath> tree_path_keys = new Hashtable<String, TreePath>();
        for (TreePath tp : select_path) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tp.getLastPathComponent();
            if (!(node.getUserObject() instanceof TempFieldInfo)) {
                Enumeration enumt = node.children();
                while (enumt.hasMoreElements()) {
                    DefaultMutableTreeNode child = (DefaultMutableTreeNode) enumt.nextElement();
                    TempFieldInfo tfi = (TempFieldInfo) child.getUserObject();
                    if (tree_path_keys.get(tfi.getField_name()) == null) {
                        tree_path_keys.put(tfi.getField_name(), new TreePath(child.getPath()));
                    }
                }
            } else {
                tree_path_keys.put(((TempFieldInfo) node.getUserObject()).getField_name(), tp);
            }
        }
        String sumType = getSum_type();
        int type = getType(sumType);
        for (TreePath tp : tree_path_keys.values()) {
            Object[] objs = tp.getPath();
            for (Object obj : objs) {
                if (obj instanceof DefaultMutableTreeNode) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) obj;
                    next_node = node.getNextSibling();
                    if (next_node == null) {
                        next_node = (DefaultMutableTreeNode) node.getParent();
                    }
                    if (node.getUserObject() instanceof TempFieldInfo) {
                        TempFieldInfo tfi = (TempFieldInfo) node.getUserObject();
                        String field_type = tfi.getField_type().toLowerCase();
                        if (field_type.equals("int") || field_type.equals("integer") || field_type.equals("float") || field_type.equals("bigdecimal") || type == 2) {
                            field_infos.add((TempFieldInfo) node.getUserObject());
                            node.removeFromParent();
                        }
                    }
                }
            }
        }
        fieldTree.clearSelection();
        fieldTree.addSelectionPath(new TreePath(next_node.getPath()));
        fieldTree.updateUI();
        List<ColumnSum> add_sums = new ArrayList<ColumnSum>();
        for (TempFieldInfo tfi : field_infos) {
            ColumnSum cs = (ColumnSum) UtilTool.createUIDEntity(ColumnSum.class);
            cs.setField_name(tfi.getField_name());
            cs.setField_caption(tfi.getCaption_name());
            cs.setSum_type(sumType);
            cs.setType(type);
            cs.setField_type(tfi.getField_type());
            cs.setUser_code(UserContext.person_code);
            cs.setEntity_name(module_code + "." + cur_class.getSimpleName());
            add_sums.add(cs);
        }
        ftable.addObjects(add_sums);
    }
    //获得统计类型（String）

    private String getSum_type() {
        String sumType = "求和";
        if (jRadioButton2.isSelected()) {
            sumType = "平均";
        } else if (jRadioButton3.isSelected()) {
            sumType = "计数";
        }
        return sumType;
    }
    //获得相对于FTable中的统计类型（int）

    private int getType(String type) {
        int result = 0;
        if ("平均".equals(type)) {
            result = 1;
        } else if ("计数".equals(type)) {
            result = 2;
        }
        return result;
    }
}
