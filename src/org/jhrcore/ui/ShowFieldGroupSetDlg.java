/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ShowFieldGroupSetDlg1.java
 *
 * Created on 2010-1-16, 16:18:15
 */
package org.jhrcore.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import org.jhrcore.client.CommUtil;
import org.jhrcore.util.SysUtil;
import org.jhrcore.client.UserContext;
import org.jhrcore.util.UtilTool;
import org.jhrcore.entity.base.TempFieldInfo;
import org.jhrcore.entity.salary.ValidateSQLResult;
import org.jhrcore.entity.showstyle.ShowFieldGroup;
import org.jhrcore.entity.showstyle.ShowSchemeGroup;
import org.jhrcore.iservice.impl.CommImpl;
import org.jhrcore.ui.action.CloseAction;
import org.jhrcore.ui.renderer.HRRendererView;
import org.jhrcore.util.MsgUtil;

/**
 *
 * @author mxliteboss
 */
public class ShowFieldGroupSetDlg extends javax.swing.JDialog {

    private List<ShowFieldGroup> groups = new ArrayList<ShowFieldGroup>();
    private String entity_name;
    private String person_code;
    private List<TempFieldInfo> all_fields;
    private List<TempFieldInfo> select_fields;
    private JTree field_tree;
    private JTree group_tree;
    private ShowFieldTreeModel leftModel;
    private DefaultMutableTreeNode rootNode;
    private DefaultMutableTreeNode cur_group_node;
    private Hashtable<String, DefaultMutableTreeNode> group_node_keys = new Hashtable<String, DefaultMutableTreeNode>();
    private Hashtable<String, ShowSchemeGroup> exist_group_keys = new Hashtable<String, ShowSchemeGroup>();
    private boolean click_ok = false;

    public boolean isClick_ok() {
        return click_ok;
    }

    /** Creates new form ShowFieldGroupSetDlg1 */
    public ShowFieldGroupSetDlg(java.awt.Frame parent, String entity_name, List<TempFieldInfo> all_fields, List<TempFieldInfo> select_fields) {
        super(parent);
        this.setTitle("字段分组");
        this.all_fields = all_fields;
        this.select_fields = select_fields;
        this.entity_name = entity_name;
        person_code = UserContext.person_code;
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

        jSeparator1 = new javax.swing.JSeparator();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnAddAll = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnDelAll = new javax.swing.JButton();
        pnlRight = new javax.swing.JPanel();
        pnlLeft = new javax.swing.JPanel();
        btnDown = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        toolbar = new javax.swing.JToolBar();
        btnAddGroup = new javax.swing.JButton();
        btnEditGroup = new javax.swing.JButton();
        btnDelGroup = new javax.swing.JButton();
        jcbShow = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        btnOk.setText("确定");

        btnCancel.setText("取消");

        btnAddAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/select_all.png"))); // NOI18N

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/select_one.png"))); // NOI18N

        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/remove_one.png"))); // NOI18N

        btnDelAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/remove_all.png"))); // NOI18N

        pnlRight.setBorder(javax.swing.BorderFactory.createTitledBorder("已分组字段："));
        pnlRight.setPreferredSize(new java.awt.Dimension(175, 230));
        pnlRight.setLayout(new java.awt.BorderLayout());

        pnlLeft.setBorder(javax.swing.BorderFactory.createTitledBorder("未分组字段："));
        pnlLeft.setLayout(new java.awt.BorderLayout());

        btnDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/move_down.png"))); // NOI18N

        btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/move_up.png"))); // NOI18N

        toolbar.setFloatable(false);
        toolbar.setRollover(true);

        btnAddGroup.setText("新增分组");
        btnAddGroup.setFocusable(false);
        btnAddGroup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddGroup.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar.add(btnAddGroup);

        btnEditGroup.setText("改分组名");
        btnEditGroup.setFocusable(false);
        btnEditGroup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditGroup.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar.add(btnEditGroup);

        btnDelGroup.setText("删除分组");
        btnDelGroup.setFocusable(false);
        btnDelGroup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelGroup.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar.add(btnDelGroup);

        jcbShow.setText("只显示已选字段");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jcbShow))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAddAll, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnDelAll, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(277, Short.MAX_VALUE)
                .addComponent(btnOk)
                .addGap(26, 26, 26)
                .addComponent(btnCancel)
                .addGap(40, 40, 40))
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
            .addComponent(toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlRight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnAddAll, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelAll, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlLeft, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbShow))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddAll;
    private javax.swing.JButton btnAddGroup;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnDelAll;
    private javax.swing.JButton btnDelGroup;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnEditGroup;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnUp;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox jcbShow;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JToolBar toolbar;
    // End of variables declaration//GEN-END:variables

    private void initOthers() {
        List group_list = CommUtil.fetchEntities("from ShowFieldGroup sfg where sfg.entity_name='" + entity_name + "' and sfg.person_code in('sa','" + person_code + "') order by sfg.order_no");
        for (Object obj : group_list) {
            ShowFieldGroup sfg = (ShowFieldGroup) obj;
            if (sfg.getPerson_code().equals(person_code)) {
                groups.add(sfg);
            }
        }
        if (groups.size() == 0) {
            for (Object obj : group_list) {
                ShowFieldGroup sfg = (ShowFieldGroup) obj;
                if (sfg.getPerson_code().equals(UserContext.sysManName)) {
                    groups.add(sfg);
                }
            }
        }
        List field_list = CommUtil.fetchEntities("from ShowSchemeGroup ssg where ssg.entity_name='" + entity_name + "' and ssg.person_code in('" + person_code + "','sa') order by ssg.order_no ");
        for (Object obj : field_list) {
            ShowSchemeGroup ssg = (ShowSchemeGroup) obj;
            if (ssg.getPerson_code().equals(person_code)) {
                exist_group_keys.put(ssg.getField_name().replace("_code_", ""), ssg);
            }
        }
        if (exist_group_keys.size() == 0) {
            for (Object obj : field_list) {
                ShowSchemeGroup ssg = (ShowSchemeGroup) obj;
                exist_group_keys.put(ssg.getField_name().replace("_code_", ""), ssg);
            }
        }
        rootNode = new DefaultMutableTreeNode("所有字段");
        for (ShowFieldGroup sfg : groups) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(sfg);
            rootNode.add(node);
            group_node_keys.put(sfg.getGroup_name(), node);
        }
        group_tree = new JTree(rootNode);
        HRRendererView.getCommMap().initTree(group_tree, TreeSelectMod.nodeManySelectMod);
        group_tree.setRootVisible(false);
        group_tree.expandRow(0);
        group_tree.setShowsRootHandles(true);
        pnlRight.add(new JScrollPane(group_tree), BorderLayout.CENTER);
        refreshFieldTree(jcbShow.isSelected());
        refreshFields();
    }

    private void refreshFields() {
        List<ShowSchemeGroup> selectList = new ArrayList<ShowSchemeGroup>();
        List<DefaultMutableTreeNode> remove_nodes = new ArrayList<DefaultMutableTreeNode>();
        Enumeration enumt = ((DefaultMutableTreeNode) leftModel.getRoot()).breadthFirstEnumeration();
        Hashtable<String, TempFieldInfo> field_keys = new Hashtable<String, TempFieldInfo>();
        while (enumt.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumt.nextElement();
            if (node.getUserObject() instanceof TempFieldInfo) {
                TempFieldInfo tfi = (TempFieldInfo) node.getUserObject();
                ShowSchemeGroup ssg = exist_group_keys.get(tfi.getField_name().replace("_code_", ""));
                if (ssg != null) {
                    selectList.add(ssg);
                    remove_nodes.add(node);
                    field_keys.put(tfi.getField_name().replace("_code_", ""), tfi);
                }

            }
        }
        SysUtil.sortListByInteger(selectList, "order_no");
        for (ShowSchemeGroup ssg : selectList) {
            TempFieldInfo tfi = field_keys.get(ssg.getField_name().replace("_code_", ""));
            if (tfi == null) {
                continue;
            }
            DefaultMutableTreeNode group_node = group_node_keys.get(ssg.getField_group());
            if (group_node == null) {
                continue;
            }
            tfi.setGroup_name(ssg.getField_group());
            group_node.add(new DefaultMutableTreeNode(tfi));
        }
        for (DefaultMutableTreeNode node : remove_nodes) {
            node.removeFromParent();
        }
        field_tree.updateUI();
        group_tree.updateUI();
    }

    private void setupEvents() {
        group_tree.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                cur_group_node = (DefaultMutableTreeNode) group_tree.getLastSelectedPathComponent();
            }
        });
        btnAddGroup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                editGroup(null, true);
            }
        });
        btnEditGroup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (cur_group_node == null || !(cur_group_node.getUserObject() instanceof ShowFieldGroup)) {
                    JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(btnEditGroup), "未选择分组");
                    return;
                }
                editGroup(cur_group_node.getUserObject(), false);
            }
        });
        btnDelGroup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (cur_group_node == null || !(cur_group_node.getUserObject() instanceof ShowFieldGroup)) {
                    JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(btnEditGroup), "未选择分组");
                    return;
                }
                Enumeration enumt = cur_group_node.children();
                List<TempFieldInfo> field_infos = new ArrayList<TempFieldInfo>();
                while (enumt.hasMoreElements()) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumt.nextElement();
                    field_infos.add((TempFieldInfo) node.getUserObject());
                }
                DefaultMutableTreeNode last_node = null;
                last_node = cur_group_node.getNextSibling();
                if (last_node == null) {
                    last_node = cur_group_node.getPreviousSibling();
                }
                if (last_node == null) {
                    last_node = (DefaultMutableTreeNode) cur_group_node.getParent();
                }
                cur_group_node.removeFromParent();
                if (last_node != null) {
                    group_tree.setSelectionPath(new TreePath(last_node.getPath()));
                }
                group_tree.updateUI();
                for (TempFieldInfo tfi : field_infos) {
                    last_node = leftModel.addNode(tfi);
                }
                if (last_node != null) {
                    field_tree.clearSelection();
                    field_tree.addSelectionPath(new TreePath(last_node.getPath()));
                }
                field_tree.updateUI();
            }
        });
        btnUp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                moveUp(-1);
            }
        });
        btnDown.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                moveUp(1);
            }
        });
        btnAddAll.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addShowSchemeDetail(true);
            }
        });
        jcbShow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refreshFieldTree(jcbShow.isSelected());
            }
        });
        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addShowSchemeDetail(false);
            }
        });
        btnDelAll.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                delShowSchemeDetail(true);
            }
        });
        btnDel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                delShowSchemeDetail(false);
            }
        });
        CloseAction.doCloseAction(btnCancel);
        btnOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                click_ok = true;
                Enumeration enumt2 = rootNode.children();
                List list = new ArrayList();
                List<ShowSchemeGroup> new_groups = new ArrayList<ShowSchemeGroup>();
                int i = 0;
                while (enumt2.hasMoreElements()) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumt2.nextElement();
                    int childcount = node.getChildCount();
                    if (childcount == 0) {
                        continue;
                    }
                    String group_name = node.getUserObject().toString();
                    Enumeration enumt = node.children();
                    while (enumt.hasMoreElements()) {
                        DefaultMutableTreeNode childnode = (DefaultMutableTreeNode) enumt.nextElement();
                        TempFieldInfo tfi = (TempFieldInfo) childnode.getUserObject();
                        ShowSchemeGroup ssg = new ShowSchemeGroup();
                        ssg.setShowSchemeGroup_key(entity_name + "_" + tfi.getField_name() + "_" + group_name + "_" + person_code);
                        new_groups.add(ssg);
                        list.add(ssg);
                        ssg.setField_name(tfi.getField_name());
                        ssg.setEntity_name(entity_name);
                        ssg.setPerson_code(person_code);
                        ssg.setField_group(group_name);
                        ssg.setOrder_no(i);
                        i++;
                    }
                }
                Enumeration enumt1 = rootNode.children();
                i = 0;
                while (enumt1.hasMoreElements()) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumt1.nextElement();
                    ShowFieldGroup sfg = (ShowFieldGroup) node.getUserObject();
                    sfg.setOrder_no(i);
                    ShowFieldGroup sfgNew = new ShowFieldGroup();
                    sfgNew.setShowFieldGroup_key(entity_name + "_" + sfg.getGroup_name() + "_" + person_code);
                    sfgNew.setEntity_name(sfg.getEntity_name());
                    sfgNew.setGroup_name(sfg.getGroup_name());
                    sfgNew.setOrder_no(sfg.getOrder_no());
                    sfgNew.setPerson_code(person_code);
                    list.add(sfgNew);
                    i++;
                }
                ValidateSQLResult result = CommImpl.saveShowSchemeGroup(list, person_code, entity_name);
                if (result.getResult() == 0) {
                    for (TempFieldInfo tfi : all_fields) {
                        tfi.setGroup_name("");
                    }
                    for (String group_name : group_node_keys.keySet()) {
                        DefaultMutableTreeNode node = group_node_keys.get(group_name);
                        int childcount = node.getChildCount();
                        if (childcount == 0) {
                            continue;
                        }
                        Enumeration enumt = node.children();
                        while (enumt.hasMoreElements()) {
                            DefaultMutableTreeNode childnode = (DefaultMutableTreeNode) enumt.nextElement();
                            TempFieldInfo tfi = (TempFieldInfo) childnode.getUserObject();
                            tfi.setGroup_name(group_name);
                        }
                    }
                    UIItemGroup.exist_groups.put(entity_name, new_groups);
                    MsgUtil.showHRSaveSuccessMsg(JOptionPane.getFrameForComponent(btnOk));
                    dispose();
                } else {
                    MsgUtil.showHRSaveErrorMsg(result);
                }
            }
        });

    }

    /**
     * 删除已选字段
     * @param all_flag：为True时表示将所有已选字段移除
     */
    private void delShowSchemeDetail(boolean all_flag) {
        List<TempFieldInfo> field_infos = new ArrayList<TempFieldInfo>();
        DefaultMutableTreeNode last_node = null;
        HashSet<DefaultMutableTreeNode> remove_nodes = new HashSet<DefaultMutableTreeNode>();
        if (all_flag) {
            Enumeration enumt = rootNode.breadthFirstEnumeration();
            while (enumt.hasMoreElements()) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumt.nextElement();
                if (node == rootNode || node.getUserObject() instanceof String) {
                    continue;
                }
                remove_nodes.add(node);
            }
        } else {
            TreePath[] select_path = group_tree.getSelectionPaths();
            if (select_path == null || select_path.length == 0) {
                return;
            }
            for (TreePath tp : select_path) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tp.getLastPathComponent();
                Object obj = node.getUserObject();
                if (obj instanceof String) {
                    Enumeration enumt = node.children();
                    while (enumt.hasMoreElements()) {
                        DefaultMutableTreeNode child = (DefaultMutableTreeNode) enumt.nextElement();
                        if (!remove_nodes.contains(child)) {
                            remove_nodes.add(child);
                        }
                    }
                    remove_nodes.add(node);
                } else if (obj instanceof TempFieldInfo) {
                    if (remove_nodes.contains(node)) {
                        continue;
                    }
                    remove_nodes.add(node);
                }
            }
        }
        List<DefaultMutableTreeNode> nodes = new ArrayList<DefaultMutableTreeNode>();
        for (DefaultMutableTreeNode node : remove_nodes) {
            Object obj = node.getUserObject();
            if (obj instanceof TempFieldInfo) {
                last_node = node.getPreviousSibling();
                if (last_node == null) {
                    last_node = (DefaultMutableTreeNode) node.getParent();
                }
                nodes.add(node);
                field_infos.add((TempFieldInfo) obj);
                node.removeFromParent();
            }
        }
        remove_nodes.removeAll(nodes);
        for (DefaultMutableTreeNode node : remove_nodes) {
            last_node = node.getPreviousSibling();
            if (last_node == null) {
                last_node = node.getNextSibling();
            }
            node.removeFromParent();
        }
        if (last_node != null) {
            group_tree.clearSelection();
            group_tree.addSelectionPath(new TreePath(last_node.getPath()));
        }
        group_tree.updateUI();
        for (TempFieldInfo tfi : field_infos) {
            last_node = leftModel.addNode(tfi);
        }
        if (last_node != null) {
            field_tree.clearSelection();
            field_tree.addSelectionPath(new TreePath(last_node.getPath()));
        }
        field_tree.updateUI();
    }

    /**
     * 该方法用于增加显示字段
     * @param all_flag：是否将全部字段作为显示字段
     */
    private void addShowSchemeDetail(boolean all_flag) {
        DefaultMutableTreeNode group_node = (DefaultMutableTreeNode) group_tree.getLastSelectedPathComponent();
        if (group_node == null) {
            return;
        }
        Object group_obj = group_node.getUserObject();
        if (group_obj instanceof TempFieldInfo) {
            group_node = (DefaultMutableTreeNode) group_node.getParent();
        }
        List<TempFieldInfo> field_infos = new ArrayList<TempFieldInfo>();
        DefaultMutableTreeNode next_node = null;
        if (all_flag) {
            Enumeration enumt = ((DefaultMutableTreeNode) leftModel.getRoot()).breadthFirstEnumeration();
            List<DefaultMutableTreeNode> nodes = new ArrayList<DefaultMutableTreeNode>();
            while (enumt.hasMoreElements()) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumt.nextElement();
                Object obj = node.getUserObject();
                if (obj instanceof TempFieldInfo) {
                    TempFieldInfo tfi = (TempFieldInfo) obj;
                    field_infos.add(tfi);
                    nodes.add(node);
                }
            }
            for (DefaultMutableTreeNode node : nodes) {
                next_node = node.getNextSibling();
                if (next_node == null) {
                    next_node = (DefaultMutableTreeNode) node.getParent();
                }
                node.removeFromParent();
            }
        } else {
            TreePath[] select_path = field_tree.getSelectionPaths();
            if (select_path == null) {
                return;
            }
            List<String> add_fields = new ArrayList();
            Hashtable<String, TreePath> tree_path_keys = new Hashtable<String, TreePath>();
            for (TreePath tp : select_path) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tp.getLastPathComponent();
                if (!(node.getUserObject() instanceof TempFieldInfo)) {
                    Enumeration enumt = node.children();
                    while (enumt.hasMoreElements()) {
                        DefaultMutableTreeNode child = (DefaultMutableTreeNode) enumt.nextElement();
                        TempFieldInfo tfi = (TempFieldInfo) child.getUserObject();
                        if (tree_path_keys.get(tfi.getField_name()) == null) {
                            add_fields.add(tfi.getField_name());//entity_name);
                            tree_path_keys.put(tfi.getField_name(), new TreePath(child.getPath()));
                        }
                    }
                } else {
                    add_fields.add(((TempFieldInfo) node.getUserObject()).getField_name());
                    tree_path_keys.put(((TempFieldInfo) node.getUserObject()).getField_name(), tp);
                }
            }
            for (String key : add_fields) {
                TreePath tp = tree_path_keys.get(key);
                Object[] objs = tp.getPath();
                for (Object obj : objs) {
                    if (obj instanceof DefaultMutableTreeNode) {
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) obj;
                        next_node = node.getNextSibling();
                        if (next_node == null) {
                            next_node = (DefaultMutableTreeNode) node.getParent();
                        }
                        if (node.getUserObject() instanceof TempFieldInfo) {
                            field_infos.add((TempFieldInfo) node.getUserObject());
                            node.removeFromParent();
                        }
                    }
                }
            }
        }
        field_tree.clearSelection();
        field_tree.addSelectionPath(new TreePath(next_node.getPath()));
        field_tree.updateUI();
        for (TempFieldInfo tfi : field_infos) {
            next_node = new DefaultMutableTreeNode(tfi);
            group_node.add(next_node);
        }
        if (next_node != null) {
            group_tree.clearSelection();
            group_tree.addSelectionPath(new TreePath(next_node.getPath()));
        }
        group_tree.updateUI();
    }

    private void editGroup(Object obj, boolean isNew) {
        ShowFieldGroup sfg = null;
        String title = "新增分组:";
        if (obj == null || isNew) {
            sfg = (ShowFieldGroup) UtilTool.createUIDEntity(ShowFieldGroup.class);
            sfg.setOrder_no(rootNode.getChildCount());
            sfg.setEntity_name(entity_name);
            sfg.setPerson_code(person_code);
        } else {
            title = "改分组名:";
            sfg = ((ShowFieldGroup) obj);
        }
        ValidateEntity ve = new ValidateEntity() {

            @Override
            public boolean isEntityValidate(Object obj) {
                ShowFieldGroup sfg = (ShowFieldGroup) obj;
                if (sfg.getGroup_name() == null || sfg.getGroup_name().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "分组名不可为空", "错误", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                Enumeration enumt = rootNode.children();
                boolean group_exists = false;
                while (enumt.hasMoreElements()) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumt.nextElement();
                    ShowFieldGroup sfg1 = (ShowFieldGroup) node.getUserObject();
                    if (sfg1.getShowFieldGroup_key().equals(sfg.getShowFieldGroup_key())) {
                        continue;
                    }
                    if (sfg1.getGroup_name().equals(sfg.getGroup_name())) {
                        group_exists = true;
                        break;
                    }
                }
                if (group_exists) {
                    JOptionPane.showMessageDialog(null, "分组名已存在", "错误", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                return true;
            }
        };
        List<String> fields = new ArrayList<String>();
        fields.add("group_name");
        if (BeanPanel.edit(sfg, fields, title, ve)) {
            if (isNew) {
                rootNode.add(new DefaultMutableTreeNode(sfg));
            } else {
                cur_group_node.setUserObject(sfg);
            }
            group_tree.updateUI();
        }
    }

    private void refreshFieldTree(boolean show_select_fields) {
        List<TempFieldInfo> fields = new ArrayList<TempFieldInfo>();
        if (show_select_fields) {
            fields.addAll(select_fields);
        } else {
            fields.addAll(all_fields);
        }
        Enumeration enumt = rootNode.breadthFirstEnumeration();
        while (enumt.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumt.nextElement();
            Object obj = node.getUserObject();
            if (obj instanceof TempFieldInfo) {
                fields.remove((TempFieldInfo) obj);
            }
        }
        pnlLeft.removeAll();
        leftModel = new ShowFieldTreeModel(fields);
        field_tree = new JTree(leftModel);
        HRRendererView.getCommMap().initTree(field_tree, TreeSelectMod.nodeManySelectMod);
        field_tree.setRootVisible(false);
        field_tree.expandRow(0);
        field_tree.setShowsRootHandles(true);
        pnlLeft.add(new JScrollPane(field_tree), BorderLayout.CENTER);
        pnlLeft.updateUI();
    }

    private void moveUp(int step) {
        if (cur_group_node == null) {
            return;
        }
        Object obj = cur_group_node.getUserObject();
        if (obj == null) {
            return;
        }
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) cur_group_node.getParent();
        int ind = cur_group_node.getParent().getIndex(cur_group_node);
        int count = cur_group_node.getParent().getChildCount();
        ind = ind + step;
        ind = ind >= count ? 0 : ind;
        cur_group_node.removeFromParent();
        if (ind < 0 || ind == (count - 1)) {
            parent.add(cur_group_node);
        } else {
            parent.insert(cur_group_node, ind);
        }
        group_tree.updateUI();
    }
}
