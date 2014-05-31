/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JSplitPane;

/**
 *
 * @author Maciek
 */
public class MainFrame extends javax.swing.JFrame implements Runnable {
    
    private Timer hideLeftPanelTimer;
    private boolean leftPanelVisible;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        initHidingLeftPanel();
    }
    
    private void initHidingLeftPanel() {
        this.hideLeftPanelTimer = new Timer();
        this.leftPanelVisible = true;
        this.jSplitPane1.getLeftComponent().addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (!leftPanelVisible) {
                    showLeftPanel();
                }
                hideLeftPanelTimer.cancel();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                hideLeftPanelTimer.cancel();
                hideLeftPanelTimer = new Timer();
                TimerTask hideLeftPanelTask = new TimerTask() {
                    
                    @Override
                    public void run() {
                        hideLeftPanel();
                    }
                };
                hideLeftPanelTimer.schedule(hideLeftPanelTask, 2000);
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

        jSplitPane1 = new javax.swing.JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new LeftPanel(), new ManageTest());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setDividerSize(0);
        jSplitPane1.setDoubleBuffered(true);
        jSplitPane1.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        this.jSplitPane1.setDividerLocation((this.leftPanelVisible) ? 10 + this.dividerLocation : 10);
    }//GEN-LAST:event_formComponentResized
    
    private void hideLeftPanel() {
        Thread hideThread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                for (int i = 49; i > 0; --i) {
                    jSplitPane1.setDividerLocation(10 + i * dividerLocation / 50);
                    jSplitPane1.repaint();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException ex) {
                    }
                }
                leftPanelVisible = false;
            }
        });
        hideThread.start();
    }
    
    private void showLeftPanel() {
        Thread showThread;
        showThread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                leftPanelVisible = true;
                for (int i = 0; i < 50; ++i) {
                    jSplitPane1.setDividerLocation(10 + i * dividerLocation / 50);
                    jSplitPane1.repaint();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException ex) {
                        
                    }
                }
            }
        });
        showThread.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    private final int dividerLocation = 250;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
