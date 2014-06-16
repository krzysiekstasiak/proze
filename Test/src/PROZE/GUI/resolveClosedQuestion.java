/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PROZE.GUI;

import EntitiesModels.MultipleChoiceQuestionEntity;
import java.util.List;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Maciek
 */
public class resolveClosedQuestion extends javax.swing.JPanel {

    private MultipleChoiceQuestionEntity question;
    /**
     * Creates new form resolveOpenQuestion
     */
    public resolveClosedQuestion() {
        initComponents();
        answersList.setSelectionMode(
        ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        answersList.setSelectionModel(new DefaultListSelectionModel() {
    @Override
    public void setSelectionInterval(int index0, int index1) {
        if (isSelectedIndex(index0))
            super.removeSelectionInterval(index0, index1);
        else
            super.addSelectionInterval(index0, index1);
    }
});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        questionTextArena = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        answersList = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        unknownButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 204, 51));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(0, 204, 51));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setText("Pytanie");
        jPanel1.add(jLabel1);

        questionTextArena.setEditable(false);
        questionTextArena.setBackground(new java.awt.Color(255, 255, 255));
        questionTextArena.setMaximumSize(new java.awt.Dimension(2147483647, 600));
        questionTextArena.setPreferredSize(new java.awt.Dimension(400, 80));
        jPanel1.add(questionTextArena);

        add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 204, 51));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jLabel2.setText("Odpowiedź");
        jPanel2.add(jLabel2);

        answersList.setModel(question.getAnswers());
        jScrollPane2.setViewportView(answersList);

        jPanel2.add(jScrollPane2);

        add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 204, 51));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS));

        okButton.setText("Ok");
        okButton.setMaximumSize(new java.awt.Dimension(75, 23));
        okButton.setMinimumSize(new java.awt.Dimension(75, 23));
        okButton.setPreferredSize(new java.awt.Dimension(75, 23));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        jPanel3.add(okButton);

        unknownButton.setText("Nie wiem");
        jPanel3.add(unknownButton);

        add(jPanel3);
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        List<String> selections =
                        this.answersList.getSelectedValuesList();
    }//GEN-LAST:event_okButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList answersList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField questionTextArena;
    private javax.swing.JButton unknownButton;
    // End of variables declaration//GEN-END:variables
}