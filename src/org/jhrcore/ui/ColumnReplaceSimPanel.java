/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ColumnReplacePanel1.java
 *
 * Created on 2010-1-17, 13:28:40
 */
package org.jhrcore.ui;

import com.foundercy.pf.control.table.FBaseTableColumn;
import com.foundercy.pf.control.table.FTable;
import com.foundercy.pf.control.table.FTableColumnItem;
import com.foundercy.pf.control.table.FTableModel;
import com.foundercy.pf.control.table.ITableCellEditable;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jhrcore.client.CommUtil;
import org.jhrcore.util.DateUtil;
import org.jhrcore.util.SysUtil;
import org.jhrcore.client.UserContext;
import org.jhrcore.util.PublicUtil;
import org.jhrcore.entity.Code;
import org.jhrcore.util.UtilTool;
import org.jhrcore.entity.base.TempFieldInfo;
import org.jhrcore.entity.salary.ValidateSQLResult;
import org.jhrcore.rebuild.EntityBuilder;
import org.jhrcore.ui.listener.IPickReplaceListener;
import org.jhrcore.util.MsgUtil;

/**
 *
 * @author mxliteboss
 */
public class ColumnReplaceSimPanel extends javax.swing.JPanel implements IPickReplaceListener {

    private JComboBoxBinding com_binding;
    private List com_var = new ArrayList();
    private FTable ftable_top;
    private FTable ftable;
    private FTable ftable_view;
    private String db_type = UserContext.sql_dialect;
    private Class cur_class;
    private HashSet<String> entityName_keys = new HashSet<String>();
    private List<String> keys = new ArrayList();
    private String key_name;
    private TempFieldInfo cur_field;
    private Object old_obj = null;
    private Object new_obj = null;
    private Object replace_obj = null;
//    private List container_data = null;
    private String s_where_old = "1=1";
    private JComponent cur_com;
    private String replace_entityName;
    private List selectedList;
    private int method = 0;

    /** Creates new form ColumnReplacePanel1 */
    public ColumnReplaceSimPanel(FTable ftable){//, List container_data) {
//        this.container_data = container_data;
        this.ftable = ftable;
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        pnlTopMain = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlOld = new javax.swing.JPanel();
        pnlNew = new javax.swing.JPanel();
        jcbOld = new javax.swing.JCheckBox();
        jcbComp = new javax.swing.JComboBox();
        cb_setnull = new javax.swing.JCheckBox();

        jSplitPane1.setDividerLocation(300);
        jSplitPane1.setDividerSize(2);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        pnlTopMain.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTopMain.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTopMain, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTopMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
        );

        jSplitPane1.setTopComponent(jPanel1);

        jLabel2.setText("原值：");

        jLabel3.setText("新值：");

        pnlOld.setLayout(new java.awt.BorderLayout());

        pnlNew.setLayout(new java.awt.BorderLayout());

        jcbOld.setText("比对原值");

        jcbComp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cb_setnull.setText("替换成空值");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlNew, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_setnull))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jcbComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlOld, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcbOld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(287, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlNew, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_setnull))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbOld, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbComp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlOld, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
        );

        jSplitPane1.setRightComponent(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cb_setnull;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JComboBox jcbComp;
    private javax.swing.JCheckBox jcbOld;
    private javax.swing.JPanel pnlNew;
    private javax.swing.JPanel pnlOld;
    private javax.swing.JPanel pnlTopMain;
    // End of variables declaration//GEN-END:variables

    private void initOthers() {
        cur_class = ((FTableModel) ftable.getModel()).getEntityClass();
        old_obj = UtilTool.createUIDEntity(cur_class);
        new_obj = UtilTool.createUIDEntity(cur_class);
        ftable_top = new FTable(cur_class, ftable.getFields(), false, false, false, ftable.getUseModuleCode());
        ftable_view = new FTable(cur_class, ftable.getFields(), false, false, false, "sim_replace_view");
        ftable_top.setOther_entitys(ftable.getOther_entitys());
        ftable_top.setOther_entity_keys(ftable.getOther_entity_keys());
        ((FTableModel) ftable_top.getModel()).setHt_OtherTableSql(((FTableModel) ftable.getModel()).getHt_OtherTableSql());
        ftable_view.setOther_entitys(ftable.getOther_entitys());
        ftable_view.setOther_entity_keys(ftable.getOther_entity_keys());
        ftable_view.setAll_fields(ftable.getAll_fields(), ftable.getDefault_fields(), new ArrayList(), "sim_replace_view");
        ((FTableModel) ftable_view.getModel()).setHt_OtherTableSql(((FTableModel) ftable.getModel()).getHt_OtherTableSql());
        pnlTopMain.add(ftable_top, BorderLayout.CENTER);
        List<TempFieldInfo> all_infos = ftable.getAll_fields();
        for (TempFieldInfo tfi : all_infos) {
            entityName_keys.add(tfi.getEntity_name());
        }
        com_binding = SwingBindings.createJComboBoxBinding(UpdateStrategy.READ_WRITE, com_var, jcbComp);
        com_binding.bind();
    }

    private void setupEvents() {
        jcbOld.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refreshView();
            }
        });
        cb_setnull.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (pnlNew.getComponentCount() <= 0) {
                    return;
                }
                if (cb_setnull.isSelected()) {
                    pnlNew.getComponent(0).setEnabled(false);
                } else {
                    pnlNew.getComponent(0).setEnabled(true);
                }
            }
        });
    }

    private void refreshView() {
        boolean enable = jcbOld.isSelected();
        jcbComp.setEnabled(enable);
        if (cur_com == null) {
            return;
        }
        if (cur_com instanceof JPanel) {
            for (Component c : cur_com.getComponents()) {
                if (c instanceof JButton) {
                    c.setEnabled(enable);
                }
            }
        } else {
            cur_com.setEnabled(enable);
        }
    }

    private String transfer_to_SQL() {
        String tmp = "";
        if (cur_field == null) {
            return tmp;
        }
        String entityName = cur_field.getEntity_name();
        List<TempFieldInfo> fields = EntityBuilder.getDeclareFieldInfoListOf(cur_class, EntityBuilder.COMM_FIELD_VISIBLE);
        boolean not_exists = true;
        for (TempFieldInfo tfi : fields) {
            if (tfi.getField_name().equals(cur_field.getField_name())) {
                not_exists = false;
                break;
            }
        }
        if (not_exists) {
            entityName = cur_class.getSuperclass().getSimpleName();
        }
        replace_entityName = entityName;
        Object old_property = PublicUtil.getProperty(old_obj, cur_field.getField_name());
        Object new_property = PublicUtil.getProperty(new_obj, cur_field.getField_name());
        String field_type = cur_field.getField_type().toLowerCase();
        s_where_old = "";
        String fieldName = cur_field.getField_name().replace("_code_", "");
        boolean fetch_old = jcbOld.isSelected();
        String compare_option = jcbComp.getSelectedItem().toString();
        if (new_property == null && !cb_setnull.isSelected()) {
            return tmp;
        }
        if (cb_setnull.isSelected()) {
            tmp = "null";
            if (field_type.equals("date")) {
                if (old_property != null) {
                    if (cur_field.getFormat() != null && !"".equals(cur_field.getFormat()) && cur_field.getFormat().toLowerCase().contains("hh")) {
                        s_where_old += " and " + fieldName + " =" + DateUtil.toStringForQuery((Date) old_property, "yyyy-MM-dd HH:mm:ss");
                    } else {
                        s_where_old += " and " + fieldName + " =" + DateUtil.toStringForQuery((Date) old_property);
                    }
                }
            } else if (field_type.equals("string")) {
                if (old_property != null) {
                    s_where_old += " and " + fieldName + " ='" + old_property.toString() + "' ";
                }

            } else if (field_type.equals("code")) {
                if (old_property != null) {
                    s_where_old += " and " + fieldName + " ='" + ((Code) old_property).getCode_id() + "'";
                }

            } else if (field_type.equals("boolean")) {
                if (old_property != null) {
                    s_where_old += " and " + fieldName + " =" + SysUtil.BoolToInt((Boolean) old_property);
                }

            } else {
                if (old_property != null) {
                    s_where_old += " and " + fieldName + " =" + old_property.toString();
                }
            }
        } else {
            if (field_type.equals("date")) {
                String f = cur_field.getFormat();
                if (f != null && !"".equals(f) && f.toLowerCase().contains("hh")) {
                    tmp = DateUtil.toStringForQuery((Date) new_property, "yyyy-MM-dd HH:mm:ss");
                } else {
                    tmp = DateUtil.toStringForQuery((Date) new_property);
                }
                if (old_property != null) {
                    s_where_old += " and " + fieldName + " =" + DateUtil.toStringForQuery((Date) old_property);
                }
            } else if (field_type.equals("string")) {
                if (old_property != null) {
                    s_where_old += " and " + fieldName + " ='" + old_property.toString() + "' ";
                }
                tmp = "'" + new_property.toString() + "'";
            } else if (field_type.equals("code")) {
                if (old_property != null) {
                    s_where_old += " and " + fieldName + " ='" + ((Code) old_property).getCode_id() + "'";
                }
                tmp = "'" + ((Code) new_property).getCode_id() + "'";
            } else if (field_type.equals("boolean")) {
                if (old_property != null) {
                    s_where_old += " and " + fieldName + " =" + SysUtil.BoolToInt((Boolean) old_property);
                }
                tmp = SysUtil.BoolToInt((Boolean) new_property) + "";
            } else {
                if (old_property != null) {
                    s_where_old += " and " + fieldName + " =" + old_property.toString();
                }
                tmp = new_property.toString();
            }
        }
        if (old_property == null) {
            s_where_old += " and " + fieldName + " is null";
        }
        if (compare_option.equals("is null") || compare_option.equals("is not null")) {
            s_where_old = " and " + fieldName + " " + compare_option;
        } else if (compare_option.contains("like")) {
            if (compare_option.endsWith("like%")) {
                s_where_old = s_where_old.replace("='", "like '%");
            }
            if (compare_option.startsWith("%like")) {
                s_where_old = s_where_old.replace("='", "like '");
                s_where_old = s_where_old.substring(0, s_where_old.length() - 1) + "%'";
            }
        } else {
            s_where_old = s_where_old.replace("=", compare_option);
        }
        s_where_old = "1=1 " + s_where_old;
        if (db_type.equals("sqlserver")) {
            tmp = " update " + entityName + " set " + cur_field.getField_name().replace("_code_", "") + "=" + tmp + " where 1=1 ";
        } else {
            tmp = " update " + entityName + " " + entityName + " set " + entityName + "." + cur_field.getField_name().replace("_code_", "") + "= " + tmp + " where 1=1 ";
        }
        if (fetch_old) {
            tmp = tmp + " and " + s_where_old;
        }
        return tmp;
    }

    private void refreshReplaceObject(int method) {
        this.method = method;
        if (cur_field == null) {
            keys.clear();
            ftable_top.deleteAllRows();
            return;
        }
        if (method == 0) {
            ftable_top.setObjects(selectedList);
        } else if (method == 1) {
            ftable_top.setObjects(ftable.getObjects());
        } else {
//            if (container_data == null) {
//                container_data = new ArrayList();
//            }
//            ftable_top.setObjects(container_data);
        }
        key_name = EntityBuilder.getEntityKey(cur_class);
        List data = ftable_top.getAllObjects();
        ITableCellEditable it = ((FTableModel) ftable.getModel()).getiTableCellEditable();
        List list = new ArrayList();
        if (it != null) {
            for (Object obj : data) {
                int i = it.getCellEditable(obj, cur_field.getField_name());
                if (i < 0) {
                    continue;
                }
                list.add(obj);
            }
            ftable_top.setObjects(list);
        }
        list = ftable_top.getObjects();
        keys.clear();
        for (Object obj : list) {
            if (obj instanceof String) {
                keys.add(obj.toString());
            } else {
                keys.add(PublicUtil.getProperty(obj, key_name).toString());
            }
        }
    }

    private void showReplaceResult() {
        List<String> view_fields = new ArrayList<String>();
        view_fields.addAll(ftable.getFields());
        view_fields.remove(cur_field.getField_name());
        view_fields.add(0, cur_field.getField_name());
        String new_field = "#" + cur_field.getEntity_name() + "." + cur_field.getField_name();
        view_fields.add(1, "#" + cur_field.getEntity_name() + "." + cur_field.getField_name());
        ftable_view.setFields(view_fields);
        List columnList = ((FTableModel) ftable_view.getModel()).getColumnList();
        for (Object obj : columnList) {
            FTableColumnItem col = (FTableColumnItem) obj;
            if (col.getId().equals(cur_field.getField_name())) {
                col.setTitle(cur_field.getCaption_name() + "(替换前)");
                FBaseTableColumn fc = ftable_view.getColumnById(col.getId());
                fc.setTitle(cur_field.getCaption_name() + "(替换前)");
                fc.setPreferredWidth(fc.getWidth() + 20);
            } else if (col.getId().equals(new_field)) {
                col.setTitle(cur_field.getCaption_name() + "(替换后)");
                FBaseTableColumn fc = ftable_view.getColumnById(col.getId());
                fc.setTitle(cur_field.getCaption_name() + "(替换后)");
                fc.setPreferredWidth(fc.getWidth() + 20);
            }
        }
//        int len = ftable_top.getObjects().size();
//        Hashtable<String, HashMap> other_data = ((FTableModel) ftable_view.getModel()).getHt_OtherTable();
//        HashMap hm = new HashMap();
//        replace_obj = null;
//        if(!cb_setnull.isSelected()){
//            replace_obj = PublicUtil.getProperty(new_obj, cur_field.getField_name());
//        }     
//        String fieldName = cur_field.getField_name().replace("_code_", "");
//        hm.put(fieldName, replace_obj);
//        for (int i = 0; i < len; i++) {
//            other_data.put(cur_field.getEntity_name() + "@" + i, hm);
//        }
        List new_list = new ArrayList();
        if (jcbOld.isSelected()) {
            String key_str = cur_field.getEntity_name() + "_key";
            String t_name = cur_field.getEntity_name();
            if (cur_class.getSuperclass() != null && !"Model".equalsIgnoreCase(cur_class.getSuperclass().getSimpleName())) {
                key_str = cur_class.getSuperclass().getSimpleName() + "_key";
                if ("a01".equalsIgnoreCase(cur_class.getSuperclass().getSimpleName())) {
                    t_name = cur_class.getSuperclass().getSimpleName();
                }
            }
            List g_list = CommUtil.selectSQL("select " + key_str + " from " + t_name
                    + " where 1=1 and " + s_where_old + " and " + key_str + " in", ftable_top.getAllKeys());
            for (Object obj : ftable_top.getObjects()) {
                Object key_obj = PublicUtil.getProperty(obj, key_str.substring(0, 1).toLowerCase() + key_str.substring(1));
                if (g_list.contains(key_obj)) {
                    new_list.add(obj);
                }
            }
        } else {
            new_list.addAll(ftable_top.getObjects());
        }
        ftable_view.setObjects(new_list);
        int len = ftable_top.getObjects().size();
        Hashtable<String, HashMap> other_data = ((FTableModel) ftable_view.getModel()).getHt_OtherTable();
        HashMap hm = new HashMap();
        replace_obj = null;
        if (!cb_setnull.isSelected()) {
            replace_obj = PublicUtil.getProperty(new_obj, cur_field.getField_name());
        }
        String fieldName = cur_field.getField_name().replace("_code_", "");
        hm.put(fieldName, replace_obj);
        for (int i = 0; i < len; i++) {
            other_data.put(cur_field.getEntity_name() + "@" + i, hm);
        }
        ftable_view.updateUI();
        ModalDialog.doModal(jcbOld, ftable_view, "替换后结果预览：");
    }

    private boolean validateSQL(String sql_text, boolean show_sql) {
        String sql_msg = sql_text;
        sql_text += " and 1=0";
        ValidateSQLResult result = CommUtil.excuteSQL(sql_text);
        boolean pass = result.getResult() == 0;
        if (!pass) {
            sql_msg += ";\n错误提示：\n    " + result.getMsg();
        }
        if (show_sql || !pass) {
            MsgUtil.showHRValidateMsg(sql_msg, "", pass);
        }
        return pass;
    }

    private ValidateSQLResult replace(String sql) {
        int len = keys.size();
        int mod_len = len / 100;
        int rel_len = mod_len + (len % 100 > 0 ? 1 : 0);
        StringBuffer ex_sql = new StringBuffer();
        for (int i = 0; i < rel_len; i++) {
            StringBuffer str = new StringBuffer();
            str.append("'-1'");
            if (i < mod_len) {
                for (int j = 0; j < 100; j++) {
                    str.append(",'");
                    str.append(keys.get(i * 100 + j));
                    str.append("'");
                }
            } else {
                for (int j = 0; j < 100; j++) {
                    if ((i * 100 + j) >= len) {
                        break;
                    }
                    str.append(",'");
                    str.append(keys.get(i * 100 + j));
                    str.append("'");
                }
            }
            ex_sql.append(sql);
            ex_sql.append(" and ");
            if (!db_type.equals("sqlserver")) {
                ex_sql.append(replace_entityName).append(".");
            }
            ex_sql.append(key_name);
            ex_sql.append(" in(");
            ex_sql.append(str.toString());
            ex_sql.append(");");
        }
        return CommUtil.excuteSQLs(ex_sql.toString(), ";");
    }

    @Override
    public void preview() {
        String sql_text = transfer_to_SQL();
        if (sql_text == null || sql_text.trim().equals("")) {
            return;
        }
        if (validateSQL(sql_text, false)) {
            showReplaceResult();
        }
    }

    @Override
    public ValidateSQLResult replace() {
        String sql_text = transfer_to_SQL();
        if (sql_text == null || sql_text.trim().equals("")) {
            return null;
        }
        if (JOptionPane.showConfirmDialog(JOptionPane.getFrameForComponent(jcbOld),
                "当前替换字段：【" + cur_field.getCaption_name() + "】\n替换是不可逆的过程，确定要进行替换吗", "询问", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) != JOptionPane.OK_OPTION) {
            return null;
        }
        return replace(sql_text);
    }

    @Override
    public void check() {
    }

    @Override
    public void clear() {
    }

    @Override
    public void changeobject(int method) {
        refreshReplaceObject(method);
    }

    @Override
    public void setReplaceField(TempFieldInfo tfi) {
        cur_field = tfi;
        if (cur_field != null) {
            pnlOld.removeAll();
            pnlNew.removeAll();
            cur_com = EditorFactory.createEditorOf(old_obj, cur_field.getField_name());
            pnlOld.add(cur_com);
            pnlNew.add(EditorFactory.createEditorOf(new_obj, cur_field.getField_name()));
            pnlOld.updateUI();
            pnlNew.updateUI();
            com_var.clear();
            String field_type = cur_field.getField_type().toLowerCase();
            com_var.add("=");
            com_var.add("<");
            com_var.add("<=");
            com_var.add(">");
            com_var.add(">=");
            com_var.add("<>");
            if (field_type.equals("string") || field_type.equals("code")) {
                com_var.add("like%");
                com_var.add("%like");
                com_var.add("%like%");
            }
            com_var.add("is null");
            com_var.add("is not null");
            com_binding.unbind();
            com_binding.bind();
            if (cb_setnull.isSelected()) {
                pnlNew.getComponent(0).setEnabled(false);
            } else {
                pnlNew.getComponent(0).setEnabled(true);
            }
        }
        refreshView();
        refreshReplaceObject(method);
    }

//    @Override
//    public void setContainerData(List list) {
//        container_data = list;
//    }

    @Override
    public void setSelectedObject(List list) {
        this.selectedList = list;
    }

    @Override
    public void refreshData() {
        List list = new ArrayList();
        list.addAll(keys);
        ftable_top.setObjects(list);
    }
}
