/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StepWorkUserSelectPanel.java
 *
 * Created on 2010-5-18, 18:05:27
 */
package org.jhrcore.ui;

import com.foundercy.pf.control.table.FTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import org.jhrcore.client.CommUtil;
import org.jhrcore.util.SysUtil;
import org.jhrcore.client.UserContext;
import org.jhrcore.util.PublicUtil;
import org.jhrcore.entity.A01PassWord;
import org.jhrcore.entity.right.Role;
import org.jhrcore.ui.renderer.HRRendererView;
import org.jhrcore.util.ComponentUtil;

/**
 *
 * @author mxliteboss
 */
public class StepWorkUserSelectPanel extends javax.swing.JPanel {

    private JTree role_tree;
    private FTable tmp_tab;
    private String work_type = "";
    private List listRole = new ArrayList();
    private DefaultMutableTreeNode rootNode;
    private HashSet<String> selected_keys = new HashSet<String>();
    private TreeSelectionListener tree_listener;

    /** Creates new form StepWorkUserSelectPanel */
    public StepWorkUserSelectPanel() {
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
        pnlLeft = new javax.swing.JPanel();
        pnlRight = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        pnlUser = new javax.swing.JPanel();

        jSplitPane1.setDividerLocation(180);
        jSplitPane1.setDividerSize(2);

        pnlLeft.setLayout(new java.awt.BorderLayout());
        jSplitPane1.setLeftComponent(pnlLeft);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jLabel1.setText(" 查找：");
        jToolBar1.add(jLabel1);

        jtfSearch.setMaximumSize(new java.awt.Dimension(120, 2147483647));
        jtfSearch.setPreferredSize(new java.awt.Dimension(120, 21));
        jToolBar1.add(jtfSearch);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/search.png"))); // NOI18N
        btnSearch.setFocusable(false);
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearch.setMaximumSize(new java.awt.Dimension(24, 24));
        btnSearch.setPreferredSize(new java.awt.Dimension(22, 22));
        btnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnSearch);

        btnRefresh.setText("刷新");
        btnRefresh.setFocusable(false);
        btnRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnRefresh);

        pnlUser.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlUser.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnlRightLayout = new javax.swing.GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
            .addComponent(pnlUser, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlUser, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(pnlRight);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JPanel pnlUser;
    // End of variables declaration//GEN-END:variables

    private void initOthers() {
        if (!UserContext.isSA) {
            listRole.addAll(CommUtil.fetchEntities("from Role r where " + UserContext.role_right_str + " and r.role_key<>'&&&' order by r.role_code"));
        } else {
            listRole.addAll(CommUtil.fetchEntities("from Role r where r.role_key<>'&&&' order by r.role_code"));
        }
        List<String> fields = new ArrayList<String>();
        fields.add("a01.deptCode.content");
        fields.add("a01.a0190");
        fields.add("a01.a0101");
        tmp_tab = new FTable(A01PassWord.class, fields, false, false, false, "StepWorkItem");
        pnlUser.add(tmp_tab);
    }

    private void setupEvents() {
        ActionListener al_search = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String val = jtfSearch.getText().trim().toUpperCase();
                if (val == null || val.equals("")) {
                    return;
                }
                val = SysUtil.getQuickSearchText(val);
                String s_where = "A01.pydm like '" + val + "' or A01.a0101 like '" + val + "' or A01.a0177 like '" + val + "' or A01.a0190 like '" + val + "' ";
                fetchUser(s_where);
            }
        };
        jtfSearch.addActionListener(al_search);
        btnSearch.addActionListener(al_search);
        btnRefresh.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fetchUser(null);
            }
        });
        tree_listener = new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                if (e.getPath() == null || e.getPath().getLastPathComponent() == null) {
                    return;
                }
                fetchUser(null);
            }
        };
    }

    private void fetchUser(String s_where) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) role_tree.getLastSelectedPathComponent();
        if (node == null || node.getUserObject() == null) {
            return;
        }
        if (node.getUserObject() instanceof Role) {
            String roleKey = ((Role) node.getUserObject()).getRole_key();
            String hql = "select apw.a01password_key from A01PassWord apw,A01 a01,DeptCode d  where apw.a01_key=a01.a01_key and a01.deptCode_key=d.deptCode_key "
                    + "and exists(select 1 from RoleA01 ra where ra.role_key='" + roleKey + "' and ra.a01password_key=apw.a01password_key) ";//order by d.dept_code,a01.a0190";
            if (s_where != null) {
                hql += " and (" + s_where + ")";
            }
            hql += " order by d.dept_code,A01.a0190";
            List list = CommUtil.selectSQL(hql);
            if (work_type.equals("员工")) {
                list.removeAll(selected_keys);
            }
            PublicUtil.getProps_value().setProperty(A01PassWord.class.getName(), "from A01PassWord apw join fetch apw.a01 join fetch apw.a01.deptCode where apw.a01PassWord_key in ");
            tmp_tab.setObjects(list);
        }
    }

    public void buildTree(String work_type, HashSet<String> selected_keys) {
        pnlLeft.removeAll();
        this.selected_keys = selected_keys;
        if (!this.work_type.equals(work_type)) {
            this.work_type = work_type;
            if (work_type.equals("角色")) {
                rootNode = new CheckTreeNode("全部角色");
                role_tree = new JTree(rootNode);
                DefaultMutableTreeNode tmp = rootNode;
                for (Object obj : listRole) {
                    Role role = (Role) obj;
                    while (tmp != rootNode && !((Role) tmp.getUserObject()).getRole_code().equals(
                            role.getParent_code())) {
                        tmp = (DefaultMutableTreeNode) tmp.getParent();
                    }
                    CheckTreeNode cur = new CheckTreeNode(role);
                    if (selected_keys.contains(role.getRole_key())) {
                        cur.setSelected(true);
                    }
                    tmp.add(cur);
                    tmp = cur;
                }
                HRRendererView.getRoleMap().initTree(role_tree, TreeSelectMod.nodeCheckMod);
            } else {
                rootNode = new DefaultMutableTreeNode("全部角色");
                role_tree = new JTree(rootNode);
                DefaultMutableTreeNode tmp = rootNode;
                for (Object obj : listRole) {
                    Role role = (Role) obj;
                    while (tmp != rootNode && !((Role) tmp.getUserObject()).getRole_code().equals(
                            role.getParent_code())) {
                        tmp = (DefaultMutableTreeNode) tmp.getParent();
                    }
                    DefaultMutableTreeNode cur = new DefaultMutableTreeNode(role);
                    tmp.add(cur);
                    tmp = cur;
                }
                HRRendererView.getRoleMap().initTree(role_tree, TreeSelectMod.nodeSelectMod);
            }
            role_tree.addTreeSelectionListener(tree_listener);
            ComponentUtil.initTreeSelection(role_tree);
        } else {
            if (work_type.equals("员工")) {
                List remove_list = new ArrayList();
                List list = tmp_tab.getObjects();
                for (Object obj : list) {
                    if (obj instanceof String) {
                        if (selected_keys.contains(obj.toString())) {
                            remove_list.add(obj);
                        }
                    } else {
                        if (selected_keys.contains(((A01PassWord) obj).getA01PassWord_key())) {
                            remove_list.add(obj);
                        }
                    }
                }
                list.removeAll(remove_list);
                tmp_tab.setObjects(list);
            }
        }
        pnlLeft.add(new JScrollPane(role_tree));
        SearchTreeFieldDialog.doQuickSearch("StepWorkUserSelectPanel", role_tree);
        role_tree.updateUI();
        pnlLeft.updateUI();
    }

    public List getSelectObjs() {
        List list = new ArrayList();
        if (work_type.equals("员工")) {
            list.addAll(tmp_tab.getAllSelectObjects());
        } else {
            Enumeration enumt = ((DefaultMutableTreeNode) role_tree.getModel().getRoot()).breadthFirstEnumeration();
            while (enumt.hasMoreElements()) {
                CheckTreeNode c_node = (CheckTreeNode) enumt.nextElement();
                if (c_node.isSelected() && c_node.getUserObject() instanceof Role && !selected_keys.contains(((Role) c_node.getUserObject()).getRole_key())) {
                    list.add(c_node.getUserObject());
                }
            }
        }
        return list;
    }

    public List<String> getSelectObjKeys() {
        List list = new ArrayList();
        if (work_type.equals("员工")) {
            list.addAll(tmp_tab.getAllKeys());
        } else {
            Enumeration enumt = ((DefaultMutableTreeNode) role_tree.getModel().getRoot()).breadthFirstEnumeration();
            while (enumt.hasMoreElements()) {
                CheckTreeNode c_node = (CheckTreeNode) enumt.nextElement();
                if (c_node.isSelected() && c_node.getUserObject() instanceof Role && !selected_keys.contains(((Role) c_node.getUserObject()).getRole_key())) {
                    list.add(((Role) c_node.getUserObject()).getRole_key());
                }
            }
        }
        return list;
    }

    public FTable getFTable() {
        return tmp_tab;
    }
}
