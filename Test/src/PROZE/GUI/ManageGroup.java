/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.GUI;

import EntitiesModels.GroupEntity;
import EntitiesModels.TestDescription;
import EntitiesModels.UserEntity;
import PROZE.GUI.EventListeners.GroupManagerListener;
import PROZE.GUI.EventListeners.NavigationListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
 -Okienko dodawnania do grupy (źle się wyświetla) tak samo jak okieno edycji opisu.
 -Zdefiniowanie eventListenera dla tego panelu oraz dodanie metod dodawania i usuwania tych listenerów - ZROBIONE
 -Obsługa kliknięć (wywoływanie metod listenerów)
 -Umożliwienie edytowania opisu - ZROBIONE
 -Stan edytora i metody pozwalajace określić grupę, którą zarządza - ZROBIONE
 */
/**
 *
 * @author Maciek
 */
public class ManageGroup extends javax.swing.JPanel {

    private enum ManagerState {

        NO_GROUP_LOADED, GROUP_CREATED, GROUP_MANAGED

    }

    private ManagerState managerState;
    private GroupEntity groupEntity;
    private final DefaultListModel<TestDescription> testsListModel = new DefaultListModel<>();
    private final DefaultListModel<UserEntity> usersListModel = new DefaultListModel<>();
    private final Set<GroupManagerListener> groupManagerListeners = new HashSet<>();
    private final Set<NavigationListener> navigationListeners = new HashSet<>();
    private String temporaryDescription;

    /**
     * Creates new form MenageGroup
     */
    private void initTestContent() {
        GroupEntity group = new GroupEntity("Grupa", true);
        try {
            group.setDescription("Opis grupy");
        } catch (IllegalAccessException ex) {
        }
        UserEntity member = new UserEntity("Login1", true);
        UserEntity member2 = new UserEntity("Login2", true);
        TestDescription test = new TestDescription(1, "Nazwatestu", new Date(), "Nazwa grupy", "member1", "Kateogria2", "Opis testu", 5, true);
        this.loadGroupEntity(group);
        List<UserEntity> users = new ArrayList<>();
        users.add(member);
        users.add(member2);
        this.setMembersDisplayed(users);
        List<TestDescription> tests = new ArrayList<>();
        tests.add(test);
        this.setTestsDisplayed(tests);
    }

    public ManageGroup() {
        initComponents();
        this.addUserListPopupMenu();
        this.addTestListPopupMenu();
        this.setManagerState(ManagerState.NO_GROUP_LOADED);
        this.initTestContent();
    }

    private void addUserListPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu() {

            @Override
            public void show(Component invoker, int x, int y) {
                int selectedIndex = usersList.getSelectedIndex();
                if (selectedIndex == usersList.locationToIndex(new Point(x, y))) {
                    super.show(invoker, x, y);
                }
            }

        };

        JMenuItem viewProfileMenuItem = new JMenuItem("Zobacz profil");
        viewProfileMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UserEntity selectedUser = usersListModel.getElementAt(usersList.getSelectedIndex());
                loginLabel.setText(selectedUser.getLogin());
                nameLabel.setText(selectedUser.getFirstName());
                lastNameLabel.setText(selectedUser.getLastName());
                emailLabel.setText(selectedUser.getMailAddress());
                viewProfileDialog.setVisible(true);
            }
        });
        popupMenu.add(viewProfileMenuItem);
        JMenuItem removeMemberMenuItem = new JMenuItem("Usuń z grupy");
        removeMemberMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(usersList.getSelectedValue());
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        popupMenu.add(removeMemberMenuItem);
        this.usersList.setComponentPopupMenu(popupMenu);
    }

    private void addTestListPopupMenu() {
        JPopupMenu popupMenu2 = new JPopupMenu() {

            @Override
            public void show(Component invoker, int x, int y) {
                int selectedIndex = testsList.getSelectedIndex();
                if (selectedIndex == testsList.locationToIndex(new Point(x, y))) {
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
        this.testsList.setComponentPopupMenu(popupMenu2);
    }

    public void addGroupManagerListener(GroupManagerListener listener) {
        this.groupManagerListeners.add(listener);
    }

    public void removeGroupManagerListener(GroupManagerListener listener) {
        this.groupManagerListeners.remove(listener);
    }

    public void addNavigationListener(NavigationListener listener) {
        this.navigationListeners.add(listener);
    }

    public void removeNavigationListener(NavigationListener listener) {
        this.navigationListeners.remove(listener);
    }

    private static void setContainerEnabled(Container container, boolean enabled) {
        for (Component c : container.getComponents()) {
            c.setEnabled(enabled);
            if (c instanceof Container) {
                setContainerEnabled((Container) c, enabled);
            }
        }
    }

    private void setManagerState(ManagerState state) {
        switch (state) {
            case NO_GROUP_LOADED:
                setContainerEnabled(this, false);
                this.nameField.setText("");
                break;
            case GROUP_CREATED:
                setContainerEnabled(this, false);
                this.nameField.setEnabled(true);
                this.nameField.setEditable(true);
                this.nameField.setText("<Nazwa grupy>");
                this.saveButton.setEnabled(true);
                break;
            case GROUP_MANAGED:
                setContainerEnabled(this, true);
                this.nameField.setEditable(false);
                break;
        }
    }

    private void restoreComponentsState() {
        this.nameField.setText("");
        this.descriptionTextArea.setText("");
        this.usersListModel.clear();
        this.testsListModel.clear();
    }

    public void resetGroupEntity() {
        this.restoreComponentsState();
        this.setManagerState(ManagerState.NO_GROUP_LOADED);
    }

    public void loadGroupEntity(GroupEntity groupEntity) {
        this.groupEntity = groupEntity;
        this.setManagerState(ManagerState.GROUP_MANAGED);
    }

    public void createNewGroup() {
        this.groupEntity = null;
        this.restoreComponentsState();
        this.setManagerState(ManagerState.GROUP_CREATED);
    }

    private void initComponentsWithGroupEntity(GroupEntity groupEntity) {
        this.nameField.setText(groupEntity.getName());
        this.descriptionTextArea.setText(groupEntity.getDescription());
    }

    public void setMembersDisplayed(Collection<UserEntity> users) {
        this.usersListModel.clear();
        for (UserEntity user : users) {
            this.usersListModel.addElement(user);
        }
    }

    public void setTestsDisplayed(Collection<TestDescription> tests) {
        this.testsListModel.clear();
        for (TestDescription test : tests) {
            this.testsListModel.addElement(test);
        }
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
        jLabel5 = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        closeViewProfileDialog = new javax.swing.JButton();
        editDescriptionDialog = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        canelDescriptionDialogButton = new javax.swing.JButton();
        okDescriptionDialogButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        createNewTestButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        usersList = new javax.swing.JList();
        chooseMemberButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        testsList = new javax.swing.JList();
        editDescriptionButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("            Login:");
        jPanel6.add(jLabel5);

        loginLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel6.add(loginLabel);

        jPanel5.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 204, 51));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("            Imie:");
        jPanel7.add(jLabel6);

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel7.add(nameLabel);

        jPanel5.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(0, 204, 51));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("            Nazwisko:");
        jPanel8.add(jLabel7);

        lastNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel8.add(lastNameLabel);

        jPanel5.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(0, 204, 51));
        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("            Email:");
        jPanel9.add(jLabel8);

        emailLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel9.add(emailLabel);

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

        editDescriptionDialog.setBackground(new java.awt.Color(0, 204, 51));
        editDescriptionDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                editDescriptionDialogWindowActivated(evt);
            }
        });

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        jScrollPane1.setViewportView(descriptionTextArea);

        canelDescriptionDialogButton.setText("Anuluj");
        canelDescriptionDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canelDescriptionDialogButtonActionPerformed(evt);
            }
        });

        okDescriptionDialogButton.setText("OK");
        okDescriptionDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okDescriptionDialogButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editDescriptionDialogLayout = new javax.swing.GroupLayout(editDescriptionDialog.getContentPane());
        editDescriptionDialog.getContentPane().setLayout(editDescriptionDialogLayout);
        editDescriptionDialogLayout.setHorizontalGroup(
            editDescriptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editDescriptionDialogLayout.createSequentialGroup()
                .addGroup(editDescriptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editDescriptionDialogLayout.createSequentialGroup()
                        .addContainerGap(270, Short.MAX_VALUE)
                        .addComponent(okDescriptionDialogButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(canelDescriptionDialogButton))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        editDescriptionDialogLayout.setVerticalGroup(
            editDescriptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editDescriptionDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editDescriptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(canelDescriptionDialogButton)
                    .addComponent(okDescriptionDialogButton))
                .addContainerGap())
        );

        setBackground(new java.awt.Color(0, 204, 51));
        setMinimumSize(new java.awt.Dimension(300, 300));
        setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setText("Testy w grupie:");

        createNewTestButton.setText("Dodaj nowy test");
        createNewTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewTestButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Członkowie grupy:");

        usersList.setModel(this.usersListModel);
        usersList.setCellRenderer(new UserCellRenderer());
        jScrollPane2.setViewportView(usersList);

        chooseMemberButton.setText("Dodaj użytkownika");
        chooseMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseMemberButtonActionPerformed(evt);
            }
        });

        testsList.setModel(this.testsListModel);
        jScrollPane4.setViewportView(testsList);

        editDescriptionButton.setText("Opis");
        editDescriptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDescriptionButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Zapisz");

        nameField.setBackground(new java.awt.Color(0, 204, 51));
        nameField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameField.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveButton)
                        .addGap(18, 18, 18)
                        .addComponent(editDescriptionButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chooseMemberButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(createNewTestButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editDescriptionButton)
                    .addComponent(saveButton)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(createNewTestButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chooseMemberButton)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
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

    private void editDescriptionDialogWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_editDescriptionDialogWindowActivated
        this.temporaryDescription = this.descriptionTextArea.getText();
    }//GEN-LAST:event_editDescriptionDialogWindowActivated

    private void canelDescriptionDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canelDescriptionDialogButtonActionPerformed
        this.descriptionTextArea.setText(this.temporaryDescription);
        this.editDescriptionDialog.setVisible(false);
    }//GEN-LAST:event_canelDescriptionDialogButtonActionPerformed

    private void okDescriptionDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okDescriptionDialogButtonActionPerformed
        this.editDescriptionDialog.setVisible(false);
    }//GEN-LAST:event_okDescriptionDialogButtonActionPerformed

    private void editDescriptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDescriptionButtonActionPerformed
        this.editDescriptionDialog.setVisible(true);
    }//GEN-LAST:event_editDescriptionButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMemberButton;
    private javax.swing.JDialog addMemberDialog;
    private javax.swing.JList allUsersList;
    private javax.swing.JButton cancelAddingMemberButton;
    private javax.swing.JButton canelDescriptionDialogButton;
    private javax.swing.JButton chooseMemberButton;
    private javax.swing.JButton closeViewProfileDialog;
    private javax.swing.JButton createNewTestButton;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JButton editDescriptionButton;
    private javax.swing.JDialog editDescriptionDialog;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton okDescriptionDialogButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JList testsList;
    private javax.swing.JList usersList;
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
