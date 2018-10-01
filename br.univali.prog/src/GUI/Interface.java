package GUI;

import DataTracker.AlertDataOrganizer;
import DataTracker.InOutManager;
import WorldContents.WFEvent;
import WorldContents.Alert;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

public class Interface extends javax.swing.JFrame  {

    List<WFEvent> alerts = new ArrayList();
    InOutManager inOutM = new InOutManager();
    String eventFragmented = "";
    EventTimeUpdate edu;
    JLabel jLabelFSGIF;
    Thread th;
    DefaultTableModel model;

    public Interface() {
        
        initComponents();
        edu = new EventTimeUpdate();
        jFinalSpaceGIF.setVisible(false);
        this.setLocationRelativeTo(null);
        this.jButtonMMenuAlerts.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                jFinalSpaceGIF.setVisible(true);
                jButtonMMenuAlerts.setEnabled(false);
                jTableAlertDataLoad();
            }
        });
        
        this.jButtonMAlertBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                th.interrupt();
                jButtonMMenuAlerts.setEnabled(true);
                jFinalSpaceGIF.setVisible(false);
                jPanelMAlert.setVisible(false);
                jPanelMMenu.setVisible(true);
            }
            
        });
        this.jButtonMAlertUpdate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                jTableAlertDataLoad();
            }
            
        });
        
    }
    
    class EventTimeUpdate extends SwingWorker<Void, Long>{
        Long evntTime;
        int indice = 0;
        @Override
        protected Void doInBackground() throws Exception {
         /*  Object rowData = new Object();
           while(jPanelMAlert.isVisible()){
               for(WFEvent wfevt: alerts){
                   rowData = ((Alert)wfevt).getExpTime() - System.currentTimeMillis();
                   model.fireTableCellUpdated(1, indice);
                   model.fireTableRowsUpdated(0, model.getRowCount());
                   indice++;
               }
               indice = 0;
           }*/
           
           return null;
        }
        
        @Override
        protected void done() { 
            super.done(); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    public void addRowToTable(DefaultTableModel model){
        Object[] rowData = new Object[6];
        //Iterator it = alerts.iterator();
        
        for(WFEvent wfevt: alerts){
            rowData[0] = ((Alert)wfevt).getTypeOf();
            rowData[1] = ((Alert)wfevt).getTimeLeft();
            rowData[2] = ((Alert)wfevt).getMinLvl();
            rowData[3] = ((Alert)wfevt).getMaxLvl();
            rowData[4] = ((Alert)wfevt).getRewardCredits();
            rowData[5] = ((Alert)wfevt).getRewardItem();
            model.addRow(rowData);
        }
        edu.execute();
    }
    
    public void jTableAlertDataLoad(){
        
        th = new Thread(){
            @Override
            public void run() {
                model = (DefaultTableModel)jTableAlerts.getModel();
                //System.out.println(model.getRowCount());
                
                model.setRowCount(0);
                //System.out.println(model.getRowCount() + "xx" );
                try {
                    inOutM.dataGather();
                    eventFragmented = inOutM.getAlerts();
                } catch (Exception e) {
                    JOptionPane.showConfirmDialog(null, e.getMessage());
                }
                AlertDataOrganizer.organizeManager(eventFragmented, alerts);
                addRowToTable(model);
                jPanelMMenu.setVisible(false);
                jPanelMAlert.setVisible(true);
            }
        };
        th.start();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelMMenu = new javax.swing.JPanel();
        jButtonMMenuAlerts = new javax.swing.JButton();
        jFinalSpaceGIF = new javax.swing.JLabel();
        jPanelMAlert = new javax.swing.JPanel();
        jScrollPaneAlerts = new javax.swing.JScrollPane();
        jTableAlerts = new javax.swing.JTable();
        jPanelMAlertBts = new javax.swing.JPanel();
        jButtonMAlertBack = new javax.swing.JButton();
        jButtonMAlertUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setName("frame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanelMMenu.setBackground(new java.awt.Color(0, 153, 153));
        jPanelMMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelMMenu.setLayout(new java.awt.GridBagLayout());

        jButtonMMenuAlerts.setText("Alerts");
        jPanelMMenu.add(jButtonMMenuAlerts, new java.awt.GridBagConstraints());

        jFinalSpaceGIF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VisualContent/finalSPace2.gif"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanelMMenu.add(jFinalSpaceGIF, gridBagConstraints);

        getContentPane().add(jPanelMMenu, "card2");

        jPanelMAlert.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMAlert.setPreferredSize(new java.awt.Dimension(700, 500));
        jPanelMAlert.setLayout(new java.awt.BorderLayout());

        jTableAlerts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Time Left ", "Enemy Min Lvl", "Enemy Man Lvl", "Credits Reward", "Item Reward"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableAlerts.setUpdateSelectionOnSort(false);
        jScrollPaneAlerts.setViewportView(jTableAlerts);

        jPanelMAlert.add(jScrollPaneAlerts, java.awt.BorderLayout.CENTER);

        jPanelMAlertBts.setBackground(new java.awt.Color(0, 102, 204));

        jButtonMAlertBack.setText("Back");

        jButtonMAlertUpdate.setText("Update");

        javax.swing.GroupLayout jPanelMAlertBtsLayout = new javax.swing.GroupLayout(jPanelMAlertBts);
        jPanelMAlertBts.setLayout(jPanelMAlertBtsLayout);
        jPanelMAlertBtsLayout.setHorizontalGroup(
            jPanelMAlertBtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMAlertBtsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButtonMAlertBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                .addComponent(jButtonMAlertUpdate)
                .addGap(21, 21, 21))
        );
        jPanelMAlertBtsLayout.setVerticalGroup(
            jPanelMAlertBtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMAlertBtsLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanelMAlertBtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMAlertBack)
                    .addComponent(jButtonMAlertUpdate))
                .addGap(33, 33, 33))
        );

        jPanelMAlert.add(jPanelMAlertBts, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanelMAlert, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMAlertBack;
    private javax.swing.JButton jButtonMAlertUpdate;
    private javax.swing.JButton jButtonMMenuAlerts;
    private javax.swing.JLabel jFinalSpaceGIF;
    private javax.swing.JPanel jPanelMAlert;
    private javax.swing.JPanel jPanelMAlertBts;
    private javax.swing.JPanel jPanelMMenu;
    public javax.swing.JScrollPane jScrollPaneAlerts;
    public javax.swing.JTable jTableAlerts;
    // End of variables declaration//GEN-END:variables
    
    

}
