/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.GUI;

import EntitiesModels.OpenQuestionEntity;
import EntitiesModels.QuestionEntity;
import EntitiesModels.QuestionProposition;
import EntitiesModels.TestEntity;
import PROZE.GUI.EventListeners.TestManagerListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.ListCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maciek
 */
public class TestManagerPanel extends javax.swing.JPanel {

    private enum EditorState {

        NO_TEST_LOADED, TEST_CREATED, TEST_EDITED

    }

    private EditorState editorState;
    private TestEntity testEntity;

    private final DefaultListModel<QuestionEntity> questionsListModel = new DefaultListModel<>();
    private final DefaultComboBoxModel<String> categoriesComboBoxModel = new DefaultComboBoxModel<>();
    private final DefaultListModel<QuestionProposition> questionPropositionsListModel = new DefaultListModel<>();
    private final Set<TestManagerListener> testEditorListeners = new HashSet<>();

    private void initTestContent() {
        TestEntity test1 = new TestEntity(1, "Nazwa testu", "Nazwa grupy", new Date(), "Ja", true);
        try {
            test1.setDescription("Krótki opis");
            QuestionEntity question1 = new OpenQuestionEntity();
            question1.setContent("Pytanie1");
            test1.addQuestion(question1);
            test1.setCategory("Kategoria2");
        } catch (IllegalAccessException ex) {

        }
        this.setAllowedCategories(new String[]{"Kategoria1", "Kategoria2"});
        this.loadTest(test1);
    }

    /**
     * Creates new form MenageTest
     */
    public TestManagerPanel() {
        initComponents();
        addQuestionPopupMenu();
        addProposedQuestionPopupMenu();
        this.setEditorState(EditorState.NO_TEST_LOADED);
        this.initTestContent();
    }

    public void addTestEditorListener(TestManagerListener listener) {
        this.testEditorListeners.add(listener);
    }

    public void removeTestEditorListener(TestManagerListener listener) {
        this.testEditorListeners.remove(listener);
    }

    private void addQuestionPopupMenu() {
        JPopupMenu popupMenu1 = new JPopupMenu() {

            @Override
            public void show(Component invoker, int x, int y) {
                int selectedIndex = questionsList.getSelectedIndex();
                if (selectedIndex == questionsList.locationToIndex(new Point(x, y))) {
                    super.show(invoker, x, y);
                }
            }

        };

        JMenuItem editQuestion = new JMenuItem("Edytuj pytanie");
        editQuestion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        popupMenu1.add(editQuestion);
        JMenuItem removeQuestion = new JMenuItem("Usuń pytanie");
        removeQuestion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        popupMenu1.add(removeQuestion);
        this.questionsList.setComponentPopupMenu(popupMenu1);

    }

    private void setEditorState(EditorState state) {
        switch (state) {
            case NO_TEST_LOADED:
                setContainerEnabled(this, false);
                this.nameField.setText("");
                break;
            case TEST_CREATED:
                setContainerEnabled(this, false);
                this.nameField.setEditable(true);
                this.nameField.setText("<Nazwa testu>");
                this.nameField.setEnabled(true);
                break;
            case TEST_EDITED:
                setContainerEnabled(this, true);
                this.nameField.setEditable(false);
        }
    }

    private void addProposedQuestionPopupMenu() {
        JPopupMenu popupMenu2 = new JPopupMenu() {

            @Override
            public void show(Component invoker, int x, int y) {
                int selectedIndex = proposedQuestionsList.getSelectedIndex();
                if (selectedIndex == proposedQuestionsList.locationToIndex(new Point(x, y))) {
                    super.show(invoker, x, y);
                }
            }

        };

        JMenuItem editOpenQuestion = new JMenuItem("Otwórz/edytuj pytanie");
        editOpenQuestion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        popupMenu2.add(editOpenQuestion);
        JMenuItem addProposeQuestion = new JMenuItem("Dodaj do testu");
        addProposeQuestion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        popupMenu2.add(addProposeQuestion);
        this.proposedQuestionsList.setComponentPopupMenu(popupMenu2);

        JMenuItem removeProposeQuestion = new JMenuItem("Usuń pytanie");
        removeProposeQuestion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        popupMenu2.add(removeProposeQuestion);
        this.proposedQuestionsList.setComponentPopupMenu(popupMenu2);
    }

    private static void setContainerEnabled(Container container, boolean enabled) {
        for (Component c : container.getComponents()) {
            c.setEnabled(enabled);
            if (c instanceof Container) {
                setContainerEnabled((Container) c, enabled);
            }
        }
    }

    public void loadTest(TestEntity testEntity) {
        if (testEntity == null) {
            throw new NullPointerException("TestEntity object cannot be null");
        }
        this.testEntity = testEntity;
        this.initComponentsWithTestEntity(testEntity);
        this.setEditorState(EditorState.TEST_EDITED);
    }

    public void createNewTest() {
        this.testEntity = null;
        this.restoreComponentsState();
        this.setEditorState(EditorState.TEST_CREATED);
    }

    public void resetTest() {
        this.testEntity = null;
        this.restoreComponentsState();
        this.setEditorState(EditorState.NO_TEST_LOADED);
    }

    private void restoreComponentsState() {
        this.nameField.setText("");
        this.questionsListModel.removeAllElements();
        throw new UnsupportedOperationException("Not implemented yet");
        //TODO: Pytania proponowane - trzeba zrobić klasę i model
    }

    private void initComponentsWithTestEntity(TestEntity testEntity) {
        this.nameField.setText(testEntity.getName());
        selectCategoryFromTest(testEntity);
        this.questionsListModel.removeAllElements();
        for (QuestionEntity question : testEntity.getQuestions()) {
            this.questionsListModel.addElement(question);
        }
    }

    private void selectCategoryFromTest(TestEntity testEntity) throws IllegalArgumentException {
        boolean found = false;
        for (int i = 0; i < this.categoriesComboBoxModel.getSize(); ++i) {
            if (this.categoriesComboBoxModel.getElementAt(i).equals(testEntity.getCategory())) {
                this.categoriesComboBoxModel.setSelectedItem(this.categoriesComboBoxModel.getElementAt(i));
                found = true;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("Cannot find matching category in allowed categories list");
        }
    }

    public void setAllowedCategories(String[] categories) {
        this.categoriesComboBoxModel.removeAllElements();
        for (String category : categories) {
            this.categoriesComboBoxModel.addElement(category);
        }
    }

    private void saveComponentsStateToTest() throws IllegalAccessException {
        this.testEntity.setCategory((String) this.categoriesComboBoxModel.getSelectedItem());
        this.testEntity.setDescription(this.descriptionField.getText());
        for (int i = 0; i < this.testEntity.getQuestions().size(); ++i) {
            this.testEntity.removeQuestion(this.testEntity.getQuestions().get(i));
        }
        for (QuestionEntity question : Collections.list(this.questionsListModel.elements())) {
            this.testEntity.addQuestion(question);
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

        editQuestionDialog = new javax.swing.JDialog();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        editDescriptionDialog = new javax.swing.JDialog();
        jScrollPane6 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        categoryBox = new javax.swing.JComboBox();
        addQuestionButton = new javax.swing.JButton();
        editDescriptionButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionsList = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        proposedQuestionsList = new javax.swing.JList();

        editQuestionDialog.getContentPane().setLayout(new javax.swing.BoxLayout(editQuestionDialog.getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jTabbedPane3.setBackground(new java.awt.Color(0, 204, 51));
        jTabbedPane3.setDoubleBuffered(true);
        jTabbedPane3.setMinimumSize(new java.awt.Dimension(400, 141));

        jPanel14.setBackground(new java.awt.Color(0, 204, 51));
        jPanel14.setForeground(new java.awt.Color(0, 204, 51));

        jLabel1.setText("Treść pytania:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel2.setText("Odpowiedzi:");

        jCheckBox1.setText("Wielkrotny wybór");

        jButton3.setText("Zapisz");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Anuluj");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {" ",  new Boolean(false)}
            },
            new String [] {
                "Odpowiedź", "Poprawna"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setColumnSelectionAllowed(true);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable2PropertyChange(evt);
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(1).setMinWidth(80);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1))
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Pytanie zamknięte", jPanel14);

        jPanel16.setBackground(new java.awt.Color(0, 204, 51));
        jPanel16.setForeground(new java.awt.Color(0, 204, 51));

        jLabel4.setText("Treść pytania:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        jLabel5.setText("Odpowiedź:");

        jButton5.setText("Zapisz");

        jButton6.setText("Anuluj");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(417, 417, 417))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Pytanie otwarte", jPanel16);

        editQuestionDialog.getContentPane().add(jTabbedPane3);

        descriptionField.setColumns(20);
        descriptionField.setRows(5);
        jScrollPane6.setViewportView(descriptionField);

        jLabel6.setText("Opis:");

        jButton8.setText("Anuluj");

        jButton9.setText("Zapisz");

        javax.swing.GroupLayout editDescriptionDialogLayout = new javax.swing.GroupLayout(editDescriptionDialog.getContentPane());
        editDescriptionDialog.getContentPane().setLayout(editDescriptionDialogLayout);
        editDescriptionDialogLayout.setHorizontalGroup(
            editDescriptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editDescriptionDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editDescriptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(editDescriptionDialogLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editDescriptionDialogLayout.createSequentialGroup()
                        .addGap(0, 248, Short.MAX_VALUE)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)))
                .addContainerGap())
        );
        editDescriptionDialogLayout.setVerticalGroup(
            editDescriptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editDescriptionDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(editDescriptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addContainerGap())
        );

        setBackground(new java.awt.Color(0, 204, 51));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setMaximumSize(new java.awt.Dimension(1800, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 50));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        nameField.setBackground(new java.awt.Color(240, 240, 240));
        nameField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameField.setBorder(null);
        nameField.setMaximumSize(new java.awt.Dimension(400, 2147483647));
        jPanel1.add(nameField);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        saveButton.setText("Zapisz");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel5.add(saveButton);

        jLabel3.setText("Kategoria:");
        jPanel5.add(jLabel3);

        categoryBox.setModel(this.categoriesComboBoxModel);
        jPanel5.add(categoryBox);

        addQuestionButton.setText("Dodaj pytanie");
        addQuestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addQuestionButtonActionPerformed(evt);
            }
        });
        jPanel5.add(addQuestionButton);

        editDescriptionButton.setText("Edytuj opis");
        editDescriptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDescriptionButtonActionPerformed(evt);
            }
        });
        jPanel5.add(editDescriptionButton);

        jPanel1.add(jPanel5);

        add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 204, 51));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jTabbedPane1.setDoubleBuffered(true);
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        questionsList.setCellRenderer(new QuestionCellRenderer());
        questionsList.setModel(this.questionsListModel);
        jScrollPane1.setViewportView(questionsList);

        jPanel3.add(jScrollPane1);

        jTabbedPane1.addTab("Pytania w teście", jPanel3);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        proposedQuestionsList.setModel(this.questionPropositionsListModel);
        jScrollPane2.setViewportView(proposedQuestionsList);

        jPanel4.add(jScrollPane2);

        jTabbedPane1.addTab("Pytania proponowane", jPanel4);

        jPanel2.add(jTabbedPane1);

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents

    private void addQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addQuestionButtonActionPerformed
        this.editQuestionDialog.setVisible(true);
        this.editQuestionDialog.setSize(this.editQuestionDialog.getPreferredSize());
    }//GEN-LAST:event_addQuestionButtonActionPerformed

    private void jTable2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable2PropertyChange

    }//GEN-LAST:event_jTable2PropertyChange

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (this.jTable2.getRowCount() == 0) {
                ((DefaultTableModel) this.jTable2.getModel()).addRow(new Object[]{" ", false});
            } else if ("".equals((String) this.jTable2.getModel().getValueAt(this.jTable2.getSelectedRow(), 0))) {
                ((DefaultTableModel) this.jTable2.getModel()).removeRow(this.jTable2.getSelectedRow());
            } else if (!" ".equals(this.jTable2.getModel().getValueAt(this.jTable2.getRowCount() - 1, 0))) {
                ((DefaultTableModel) this.jTable2.getModel()).addRow(new Object[]{" ", false});
            }
        }
    }//GEN-LAST:event_jTable2KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.editQuestionDialog.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.editQuestionDialog.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        this.nameField.setEditable(false);

    }//GEN-LAST:event_saveButtonActionPerformed

    private void editDescriptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDescriptionButtonActionPerformed
        this.editDescriptionDialog.setVisible(true);
        this.editDescriptionDialog.setSize(this.editDescriptionDialog.getPreferredSize());
    }//GEN-LAST:event_editDescriptionButtonActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if (this.jTabbedPane1.getSelectedIndex() == 1) {
            //TODO: Pobrać z bazy propozycje pytań (zajmę się tym) i usunąć kolejną linijkę ;)
            System.out.println("Wybrano propozycje pytań");
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addQuestionButton;
    private javax.swing.JComboBox categoryBox;
    private javax.swing.JTextArea descriptionField;
    private javax.swing.JButton editDescriptionButton;
    private javax.swing.JDialog editDescriptionDialog;
    private javax.swing.JDialog editQuestionDialog;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField nameField;
    private javax.swing.JList proposedQuestionsList;
    private javax.swing.JList questionsList;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    class QuestionCellRenderer extends JLabel implements ListCellRenderer {

        private final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

        public QuestionCellRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            QuestionEntity question = (QuestionEntity) value;
            setText(question.getContent());
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

    class ProposeQuestionCellRenderer extends JLabel implements ListCellRenderer {

        private final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

        public ProposeQuestionCellRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            QuestionProposition proposeQuestion = (QuestionProposition) value;
            setText((proposeQuestion.getProposedQuestion()).getContent() + ", Autor: " + proposeQuestion.getUserLogin());
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
