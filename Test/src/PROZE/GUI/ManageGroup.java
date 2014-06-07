/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.GUI;

import EntitiesModels.TestDescription;
import EntitiesModels.UserEntity;
import PROZE.GUI.EventListeners.GroupManagerListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.ListCellRenderer;

/*
 Rzeczy do zrobienia:
 -Model listy dla testów i użytkowników - ZROBIONE
 -ListCellRenderer dla testów (ma być dla obiektów typu TestDescription
 -Okienko dodawnania do grupy (źle się wyświetla)
 -Zdefiniowanie eventListenera dla tego panelu oraz dodanie metod dodawania i usuwania tych listenerów - ZROBIONE
 -Obsługa kliknięć (wywoływanie metod listenerów)
 */
/**
 *
 * @author Maciek
 */
public class ManageGroup extends javax.swing.JPanel {

    private List<UserEntity> members = new ArrayList<>(); // do wywalenia

    private final DefaultListModel<TestDescription> testsListModel = new DefaultListModel<>();
    private final DefaultListModel<UserEntity> usersListModel = new DefaultListModel<>();
    private final Set<GroupManagerListener> groupManagerListeners = new HashSet<>();

    /**
     * Creates new form MenageGroup
     */
    private void initTestContent() {
        UserEntity user1 = new UserEntity("User1", true);

        try {
            user1.setFirstName("Jan");
            user1.setSecondName("Kowalski");
            user1.setMailAddress("jkowal@mail.com");
        } catch (IllegalAccessException exc) {

        }
        this.members.add(user1);
    }

    public ManageGroup() {
        this.initTestContent();
        initComponents();
        this.addUserListPopupMenu();
        this.addTestListPopupMenu();
    }

    private void addUserListPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu() {

            @Override
            public void show(Component invoker, int x, int y) {
                int selectedIndex = jList2.getSelectedIndex();
                if (selectedIndex == jList2.locationToIndex(new Point(x, y))) {
                    super.show(invoker, x, y);
                }
            }

        };

        JMenuItem viewProfileMenuItem = new JMenuItem("Zobacz profil");
        viewProfileMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                viewProfileDialog.setVisible(true);
            }
        });
        popupMenu.add(viewProfileMenuItem);
        JMenuItem removeMemberMenuItem = new JMenuItem("Usuń z grupy");
        removeMemberMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jList2.getSelectedValue());
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        popupMenu.add(removeMemberMenuItem);
        this.jList2.setComponentPopupMenu(popupMenu);
    }

    private void addTestListPopupMenu() {
        JPopupMenu popupMenu2 = new JPopupMenu() {

            @Override
            public void show(Component invoker, int x, int y) {
                int selectedIndex = jList3.getSelectedIndex();
                if (selectedIndex == jList3.locationToIndex(new Point(x, y))) {
                    super.show(invoker, x, y);
                }
            }

        };

        JMenuItem menageTestMenuItem = new JMenuItem("Edytuj test");
        menageTestMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        popupMenu2.add(menageTestMenuItem);

        JMenuItem removeTestMenuItem = new JMenuItem("Usuń test");
        removeTestMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        popupMenu2.add(removeTestMenuItem);
    }

    public void addGroupManagerListener(GroupManagerListener listener) {
        this.groupManagerListeners.add(listener);
    }

    public void removeGroupManagerListener(GroupManagerListener listener) {
        this.groupManagerListeners.remove(listener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMemberDialog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jSeparator6 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        allUsersList = new javax.swing.JList();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        addMemberButton = new javax.swing.JButton();
        cancelAddingMemberButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        viewProfileDialog = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        Login = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Name = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        SureName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        Email = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        closeViewProfileDialog = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        createNewTestButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList(this.members.toArray());
        chooseMemberButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();

        jPanel1.setBackground(new java.awt.Color(0, 204, 51));
        jPanel1.setForeground(new java.awt.Color(0, 204, 51));
        jPanel1.setMaximumSize(new java.awt.Dimension(124, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(124, 100));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jSeparator1.setBackground(new java.awt.Color(0, 204, 51));
        jSeparator1.setForeground(new java.awt.Color(0, 204, 51));
        jSeparator1.setMaximumSize(new java.awt.Dimension(32767, 10));
        jSeparator1.setMinimumSize(new java.awt.Dimension(0, 10));
        jSeparator1.setPreferredSize(new java.awt.Dimension(0, 10));
        jPanel1.add(jSeparator1);

        jPanel2.setBackground(new java.awt.Color(0, 204, 51));
        jPanel2.setForeground(new java.awt.Color(0, 204, 51));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.X_AXIS));

        jLabel4.setText("Wybierz użytkownika");
        jPanel2.add(jLabel4);

        jPanel1.add(jPanel2);

        jSeparator4.setBackground(new java.awt.Color(0, 204, 51));
        jSeparator4.setForeground(new java.awt.Color(0, 204, 51));
        jSeparator4.setMaximumSize(new java.awt.Dimension(32767, 10));
        jSeparator4.setMinimumSize(new java.awt.Dimension(0, 10));
        jSeparator4.setPreferredSize(new java.awt.Dimension(0, 10));
        jPanel1.add(jSeparator4);

        jPanel3.setBackground(new java.awt.Color(0, 204, 51));
        jPanel3.setForeground(new java.awt.Color(0, 204, 51));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator6.setBackground(new java.awt.Color(0, 204, 51));
        jSeparator6.setForeground(new java.awt.Color(0, 204, 51));
        jSeparator6.setMaximumSize(new java.awt.Dimension(10, 32767));
        jSeparator6.setMinimumSize(new java.awt.Dimension(10, 10));
        jSeparator6.setPreferredSize(new java.awt.Dimension(10, 10));
        jPanel3.add(jSeparator6);

        allUsersList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(allUsersList);

        jPanel3.add(jScrollPane3);

        jSeparator5.setBackground(new java.awt.Color(0, 204, 51));
        jSeparator5.setForeground(new java.awt.Color(0, 204, 51));
        jSeparator5.setMaximumSize(new java.awt.Dimension(10, 32767));
        jSeparator5.setMinimumSize(new java.awt.Dimension(10, 10));
        jSeparator5.setPreferredSize(new java.awt.Dimension(10, 10));
        jPanel3.add(jSeparator5);

        jPanel1.add(jPanel3);

        jSeparator3.setBackground(new java.awt.Color(0, 204, 51));
        jSeparator3.setForeground(new java.awt.Color(0, 204, 51));
        jSeparator3.setMaximumSize(new java.awt.Dimension(32767, 10));
        jSeparator3.setMinimumSize(new java.awt.Dimension(0, 10));
        jSeparator3.setPreferredSize(new java.awt.Dimension(0, 10));
        jPanel1.add(jSeparator3);

        jPanel4.setBackground(new java.awt.Color(0, 204, 51));
        jPanel4.setForeground(new java.awt.Color(0, 204, 51));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        addMemberButton.setText("Dodaj");
        addMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberButtonActionPerformed(evt);
            }
        });
        jPanel4.add(addMemberButton);

        cancelAddingMemberButton.setText("Anuluj");
        cancelAddingMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddingMemberButtonActionPerformed(evt);
            }
        });
        jPanel4.add(cancelAddingMemberButton);

        jPanel1.add(jPanel4);

        jSeparator2.setBackground(new java.awt.Color(0, 204, 51));
        jSeparator2.setForeground(new java.awt.Color(0, 204, 51));
        jSeparator2.setMaximumSize(new java.awt.Dimension(32767, 10));
        jSeparator2.setMinimumSize(new java.awt.Dimension(0, 10));
        jSeparator2.setPreferredSize(new java.awt.Dimension(0, 10));
        jPanel1.add(jSeparator2);

        javax.swing.GroupLayout addMemberDialogLayout = new javax.swing.GroupLayout(addMemberDialog.getContentPane());
        addMemberDialog.getContentPane().setLayout(addMemberDialogLayout);
        addMemberDialogLayout.setHorizontalGroup(
            addMemberDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        addMemberDialogLayout.setVerticalGroup(
            addMemberDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        viewProfileDialog.setTitle("Zobacz profil");
        viewProfileDialog.setMinimumSize(new java.awt.Dimension(280, 400));
        viewProfileDialog.setResizable(false);

        jPanel5.setBackground(new java.awt.Color(0, 204, 51));
        jPanel5.setMaximumSize(new java.awt.Dimension(283, 361));
        jPanel5.setMinimumSize(new java.awt.Dimension(283, 361));
        jPanel5.setPreferredSize(new java.awt.Dimension(283, 361));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        jPanel6.setBackground(new java.awt.Color(0, 204, 51));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        Login.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Login.setText("            Login:");
        jPanel6.add(Login);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel6.add(jLabel5);

        jPanel5.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 204, 51));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        Name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Name.setText("            Imie:");
        jPanel7.add(Name);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel7.add(jLabel6);

        jPanel5.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(0, 204, 51));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        SureName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SureName.setText("            Nazwisko:");
        jPanel8.add(SureName);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel8.add(jLabel7);

        jPanel5.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(0, 204, 51));
        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        Email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Email.setText("            Email:");
        jPanel9.add(Email);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel9.add(jLabel8);

        jPanel5.add(jPanel9);

        closeViewProfileDialog.setText("Zamknij");
        closeViewProfileDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeViewProfileDialogActionPerformed(evt);
            }
        });
        jPanel5.add(closeViewProfileDialog);

        javax.swing.GroupLayout viewProfileDialogLayout = new javax.swing.GroupLayout(viewProfileDialog.getContentPane());
        viewProfileDialog.getContentPane().setLayout(viewProfileDialogLayout);
        viewProfileDialogLayout.setHorizontalGroup(
            viewProfileDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
            .addGroup(viewProfileDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewProfileDialogLayout.setVerticalGroup(
            viewProfileDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(viewProfileDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(0, 204, 51));
        setMinimumSize(new java.awt.Dimension(300, 300));
        setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setText("Testy w grupie:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Nazwa grupy");

        createNewTestButton.setText("Dodaj nowy test");
        createNewTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewTestButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Członkowie grupy:");

        jList2.setModel(this.usersListModel);
        jList2.setCellRenderer(new UserCellRenderer());
        jScrollPane2.setViewportView(jList2);

        chooseMemberButton.setText("Dodaj użytkownika");
        chooseMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseMemberButtonActionPerformed(evt);
            }
        });

        jList3.setModel(this.testsListModel);
        jScrollPane4.setViewportView(jList3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                        .addComponent(createNewTestButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chooseMemberButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(createNewTestButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(chooseMemberButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createNewTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewTestButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createNewTestButtonActionPerformed

    private void chooseMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseMemberButtonActionPerformed
        this.addMemberDialog.setVisible(true);
    }//GEN-LAST:event_chooseMemberButtonActionPerformed

    private void addMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberButtonActionPerformed
        this.addMemberDialog.setVisible(false);
    }//GEN-LAST:event_addMemberButtonActionPerformed

    private void closeViewProfileDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeViewProfileDialogActionPerformed
        this.viewProfileDialog.setVisible(false);
    }//GEN-LAST:event_closeViewProfileDialogActionPerformed

    private void cancelAddingMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddingMemberButtonActionPerformed
        this.addMemberDialog.setVisible(false);
    }//GEN-LAST:event_cancelAddingMemberButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Email;
    private javax.swing.JLabel Login;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel SureName;
    private javax.swing.JButton addMemberButton;
    private javax.swing.JDialog addMemberDialog;
    private javax.swing.JList allUsersList;
    private javax.swing.JButton cancelAddingMemberButton;
    private javax.swing.JButton chooseMemberButton;
    private javax.swing.JButton closeViewProfileDialog;
    private javax.swing.JButton createNewTestButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JDialog viewProfileDialog;
    // End of variables declaration//GEN-END:variables

    class UserCellRenderer extends JLabel implements ListCellRenderer {

        private final Color HIGHLIGHT_COLOR = new Color(102, 255, 51);

        public UserCellRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            UserEntity userEntity = (UserEntity) value;
            setText(userEntity.getLogin() + " " + userEntity.getFirstName() + " " + userEntity.getLastName());
            if (isSelected) {
                setBackground(HIGHLIGHT_COLOR);
                setForeground(Color.white);
            } else {
                setBackground(Color.white);
                setForeground(Color.black);
            }
            return this;
        }
    }
}
