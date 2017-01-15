/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * QueryParaSimCreateDlg.java
 *
 * Created on 2010-2-4, 10:57:48
 */
package org.jhrcore.queryanalysis;

import com.foundercy.pf.control.table.FTable;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JListBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jhrcore.comm.CodeManager;
import org.jhrcore.entity.Code;
import org.jhrcore.util.UtilTool;
import org.jhrcore.entity.base.TempFieldInfo;
import org.jhrcore.entity.query.QueryPartPara;
import org.jhrcore.ui.BeanPanel;
import org.jhrcore.ui.CheckTreeNode;
import org.jhrcore.ui.CodeSelectTreeModel;
import org.jhrcore.ui.TreeSelectMod;
import org.jhrcore.ui.ValidateEntity;
import org.jhrcore.ui.renderer.HRRendererView;

/**
 *
 * @author mxliteboss
 */
public class QueryParaSimCreateDlg extends javax.swing.JDialog {

    private JCheckBox jcbDefault = new JCheckBox("编码即分段");
    private FTable ftable;
    private JTree code_tree;
    private CheckTreeNode rootNode;
    private TempFieldInfo tfi;
    private JListBinding condition_binding;
    private List conditions = new ArrayList();
    private QueryPartPara cur_para;
    private String cur_exp;
    private boolean default_flag = false;
    private boolean click_ok = false;
    private List<QueryPartPara> paras = new ArrayList<QueryPartPara>();
    private Binding binding;
    private QueryPartPara queryPartPara;
    private boolean transfer_to_SQL = false;

    public boolean isClick_ok() {
        return click_ok;
    }

    public List<QueryPartPara> getParas() {
        return paras;
    }

    /** Creates new form QueryParaSimCreateDlg */
    public QueryParaSimCreateDlg(java.awt.Frame parent, TempFieldInfo tfi) {
        this.setTitle("直观挑选分段：");
        this.tfi = tfi;
        rootNode = new CheckTreeNode("所有编码");
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

        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        pnlCode = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        toolbar = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jSplitPane2 = new javax.swing.JSplitPane();
        pnlPara = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlsCon = new javax.swing.JList();
        jPanel6 = new javax.swing.JPanel();
        jtfExp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        btnOk.setText("确定");

        btnCancel.setText("取消");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(475, Short.MAX_VALUE)
                .addComponent(btnOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel)
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnOk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setDividerSize(1);

        pnlCode.setLayout(new java.awt.BorderLayout());
        jSplitPane1.setLeftComponent(pnlCode);

        toolbar.setFloatable(false);
        toolbar.setRollover(true);

        btnAdd.setText("新增");
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar.add(btnAdd);

        btnDel.setText("删除");
        btnDel.setFocusable(false);
        btnDel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar.add(btnDel);

        jSplitPane2.setDividerLocation(200);

        pnlPara.setLayout(new java.awt.BorderLayout());
        jSplitPane2.setLeftComponent(pnlPara);

        jlsCon.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jlsCon);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("运算表达式："));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtfExp, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtfExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane2.setRightComponent(jPanel5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnOk;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JList jlsCon;
    private javax.swing.JTextField jtfExp;
    private javax.swing.JPanel pnlCode;
    private javax.swing.JPanel pnlPara;
    private javax.swing.JToolBar toolbar;
    // End of variables declaration//GEN-END:variables

    private void initOthers() {
        toolbar.add(jcbDefault);
        CodeSelectTreeModel model = new CodeSelectTreeModel(CodeManager.getCodeManager().getCodeListBy(tfi.getCode_type_name()), tfi.getCode_type_name());
        code_tree = new JTree(model);
        HRRendererView.getCommMap().initTree(code_tree, TreeSelectMod.nodeCheckMod);
        pnlCode.add(new JScrollPane(code_tree), BorderLayout.CENTER);
        List<String> fields = new ArrayList<String>();
        fields.add("para_name");
        ftable = new FTable(QueryPartPara.class, fields, false, false, false, "QueryParaSimCreateDlg");
        pnlPara.add(ftable, BorderLayout.CENTER);
        condition_binding = SwingBindings.createJListBinding(UpdateStrategy.READ_WRITE, conditions, jlsCon);
        condition_binding.bind();
        BeanProperty beanP = BeanProperty.create("para_text");
        BeanProperty textP = BeanProperty.create("text_ON_ACTION_OR_FOCUS_LOST");
        queryPartPara = new QueryPartPara();
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, queryPartPara,
                beanP, jtfExp, textP, "para_text");
        binding.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (cur_para != null) {
                    cur_para.setPara_text(jtfExp.getText());
                    refreshSql(cur_para, transfer_to_SQL, conditions);
                }
            }
        });
        binding.bind();
    }

    private void setupEvents() {
        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Enumeration enumt = ((CheckTreeNode) code_tree.getModel().getRoot()).breadthFirstEnumeration();
                List<Code> select_codes = new ArrayList<Code>();
                while (enumt.hasMoreElements()) {
                    CheckTreeNode node = (CheckTreeNode) enumt.nextElement();
                    if (node.isSelected() && node.getUserObject() instanceof Code) {
                        select_codes.add((Code) node.getUserObject());
                    }
                }
                if (select_codes.size() == 0) {
                    JOptionPane.showMessageDialog(null, "select_codes");
                    return;
                }
                boolean isSingleCode = true;
                if (select_codes.get(0).getGrades() > 2) {
                    isSingleCode = false;
                }
                if (default_flag) {
                    for (Code c : select_codes) {
                        QueryPartPara qpp = (QueryPartPara) UtilTool.createUIDEntity(QueryPartPara.class);
                        qpp.setPara_name(c.getCode_name());
                        String this_meaning = "";
                        String this_mean = "";
                        if (isSingleCode) {
                            this_meaning = "1: " + tfi.getCaption_name() + "=" + c.getCode_name();
                            this_mean = "1: " + tfi.getEntity_name() + "." + tfi.getField_name().replace("_code_", "");
                            this_mean = this_mean + "='" + c.getCode_id() + "'";
                        } else {
                            this_meaning = "1: " + tfi.getCaption_name() + "like%" + c.getCode_name();
                            this_mean = "1: " + tfi.getEntity_name() + "." + tfi.getField_name().replace("_code_", "");
                            this_mean = this_mean + " like '" + c.getCode_id() + "%'";
                        }
                        qpp.setPara_mean(this_mean);
                        qpp.setPara_meaning(this_meaning);
                        qpp.setPara_text("1");
                        ftable.addObject(qpp);
                        List ex_conditions = new ArrayList();
                        String[] the_conditions = this_mean.split("\\;");
                        for (String str : the_conditions) {
                            ex_conditions.add(str);
                        }
                        refreshSql(qpp, true, ex_conditions);
                    }
                } else {
                    QueryPartPara qpp = (QueryPartPara) UtilTool.createUIDEntity(QueryPartPara.class);
                    List<String> fields = new ArrayList<String>();
                    fields.add("para_name");
                    ValidateEntity ve = new ValidateEntity() {

                        @Override
                        public boolean isEntityValidate(Object obj) {
                            if (((QueryPartPara) obj).getPara_name() == null || ((QueryPartPara) obj).getPara_name().trim().equals("")) {
                                JOptionPane.showMessageDialog(null, "分段描述不可为空");
                                return false;
                            }
                            return true;
                        }
                    };
                    if (BeanPanel.edit((JFrame) null, qpp, fields, "新增分段", ve)) {
                        String this_meaning = "";
                        String this_mean = "";
                        int index = 1;
                        String exp = "1";
                        if (isSingleCode) {
                            for (Code c : select_codes) {
                                this_meaning = this_meaning + ";" + index + ": " + tfi.getCaption_name() + "=" + c.getCode_name();
                                this_mean = this_mean + ";" + index + ": " + tfi.getEntity_name() + "." + tfi.getField_name().replace("_code_", "") + "='" + c.getCode_id() + "'";
                                exp = exp + "+" + index;
                                index++;
                            }
                        } else {
                            for (Code c : select_codes) {
                                this_meaning = this_meaning + ";" + index + ": " + tfi.getCaption_name() + "like%" + c.getCode_name();
                                this_mean = this_mean + ";" + index + ": " + tfi.getEntity_name() + "." + tfi.getField_name().replace("_code_", "") + " like '" + c.getCode_id() + "%'";
                                exp = exp + "+" + index;
                                index++;
                            }
                        }
                        exp = exp.substring(2);
                        qpp.setPara_text(exp);
                        qpp.setPara_mean(this_mean.equals("") ? "" : this_mean.substring(1));
                        qpp.setPara_meaning(this_meaning);
                        ftable.addObject(qpp);
                        List ex_conditions = new ArrayList();
                        String[] the_conditions = qpp.getPara_mean().split("\\;");
                        for (String str : the_conditions) {
                            ex_conditions.add(str);
                        }
                        refreshSql(qpp, true, ex_conditions);
                    }
                }
                int ind = ftable.getObjects().size() - 1;
                ftable.setRowSelectionInterval(ind, ind);
                enumt = ((CheckTreeNode) code_tree.getModel().getRoot()).breadthFirstEnumeration();
                while (enumt.hasMoreElements()) {
                    CheckTreeNode node = (CheckTreeNode) enumt.nextElement();
                    node.setSelected(false);
                }
                code_tree.updateUI();
            }
        });
        btnDel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ftable.deleteSelectedRows();
                ftable.updateUI();
            }
        });
        jcbDefault.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                default_flag = !default_flag;
            }
        });
        ftable.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (cur_para == ftable.getCurrentRow()) {
                    return;
                }
                cur_para = (QueryPartPara) ftable.getCurrentRow();
                if (cur_para == null) {
                    return;
                }
                cur_exp = cur_para.getPara_text();
                queryPartPara.setPara_text(cur_exp);
                conditions.clear();
                String condition = cur_para.getPara_meaning();
                if (condition != null) {
                    String[] con = condition.split(";");
                    for (String key : con) {
                        conditions.add(key);
                    }
                }
                condition_binding.unbind();
                condition_binding.bind();
                transfer_to_SQL = false;
                binding.unbind();
                binding.bind();
                transfer_to_SQL = true;
                //jtfExp.setText(cur_exp);
            }
        });
        btnOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                click_ok = true;
                paras.addAll(ftable.getObjects());
                dispose();
            }
        });
        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void refreshSql(QueryPartPara queryPartPara, boolean transfer_to_SQL, List conditions) {
        if (!transfer_to_SQL) {
            return;
        }
        String means = queryPartPara.getPara_mean();
        String this_exp = queryPartPara.getPara_text();
        this_exp = this_exp.replace("+", " and ");
        this_exp = this_exp.replace(",", " or ");
        for (int i = conditions.size(); i > 0; i--) {
            this_exp = this_exp.replace(i + "", "{" + i + "}");
        }
        String[] means_str = means.split("\\;");
        Hashtable<String, String> means_key = new Hashtable<String, String>();
        for (String str : means_str) {
            means_key.put(str.substring(0, str.indexOf(":") + 2), str.substring(str.indexOf(":") + 2, str.length()));
        }
        for (int i = conditions.size(); i > 0; i--) {
            this_exp = this_exp.replace("{" + i + "}", means_key.get(i + ": "));
        }
        queryPartPara.setPara_sql(this_exp);
    }
}
