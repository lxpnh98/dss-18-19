/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

import javax.swing.table.DefaultTableModel;
import configurafacil.*;
import java.util.Collection;

/**
 * @author ASUS
 */
public class VerificaCarro extends javax.swing.JFrame {

    private static final long serialVersionUID = 1;
    private ConfiguraFacil cf;
    
    /**
     * Creates new form NewJFrame
     */
    public VerificaCarro(ConfiguraFacil cf) {
        this.cf = cf;
        initComponents();
    }
    
    public void showConfiguracaoBasica(Configuracao config){
        
        DefaultTableModel model = (DefaultTableModel)jTable_ConfB.getModel();
        Object[] row = new Object[1];
        model.setRowCount(0);
        row[0] = config.getMotor();
        model.addRow(row);
        row[0] = config.getJantes();
        model.addRow(row);
        row[0] = config.getPneus();
        model.addRow(row);
        row[0] = config.getPintura();
        model.addRow(row);
        row[0] = config.getDetInteriores();
        model.addRow(row);
        row[0] = config.getDetExteriores();
        model.addRow(row);
    }
    
    public void showComponentes(Configuracao config) {

       Collection<Integer> ids = config.getComponentes();
       DefaultTableModel model = (DefaultTableModel)jTable_Comp.getModel();
       Object[] row = new Object[3];
       model.setRowCount(0);
       int i = 0;
       for(Integer id : ids) {
           row[0] = this.cf.getComponente(id).getId();
           row[1] = this.cf.getComponente(id).getNome();
           row[2] = this.cf.getComponente(id).getStock();
           i++;
           model.addRow(row);
       }
    }
    
    public void showPacotes(Configuracao config) {

       Collection<Integer> ids = config.getPacotes();
       DefaultTableModel model = (DefaultTableModel)jTable_Pac.getModel();
       Object[] row = new Object[1];
       model.setRowCount(0);
       int i = 0;
       for(Integer id : ids) {
           row[0] = this.cf.getPacote(id).getNome();
           i++;
           model.addRow(row);
       }
    }
    
    public void showCliente(Cliente cliente){
        
        DefaultTableModel model = (DefaultTableModel)jTable_Cli.getModel();
        Object[] row = new Object[1];
        model.setRowCount(0);
        row[0] = cliente.getId();
        model.addRow(row);
        row[0] = cliente.getNome();
        model.addRow(row);
        row[0] = cliente.getTlmv();
        model.addRow(row);
        row[0] = cliente.getEmail();
        model.addRow(row);
        row[0] = cliente.getNif();
        model.addRow(row);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ConfB = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Comp = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_Pac = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_Cli = new javax.swing.JTable();
        jText_ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_ConfB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Configuração Básica"
            }
        ));
        jScrollPane1.setViewportView(jTable_ConfB);

        jLabel1.setText("Verificar Carro:");

        jTable_Comp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Componentes", "Stock"
            }
        ));
        jScrollPane2.setViewportView(jTable_Comp);
        if (jTable_Comp.getColumnModel().getColumnCount() > 0) {
            jTable_Comp.getColumnModel().getColumn(1).setResizable(false);
        }

        jTable_Pac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pacotes de Configuração"
            }
        ));
        jScrollPane3.setViewportView(jTable_Pac);

        jTable_Cli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Informação do Cliente"
            }
        ));
        jScrollPane4.setViewportView(jTable_Cli);

        jLabel2.setText("Id do Carro a Verificar:");

        jButton1.setText("Verificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jText_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(340, 340, 340))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jText_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CarroInfo carro;
        int id = Integer.parseInt(jText_ID.getText());
        
        carro = this.cf.verCarro(id);
        showConfiguracaoBasica(carro.getConfig());
        showComponentes(carro.getConfig());
        showPacotes(carro.getConfig());
        showCliente(carro.getClient());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Fabricante(this.cf).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable_Cli;
    private javax.swing.JTable jTable_Comp;
    private javax.swing.JTable jTable_ConfB;
    private javax.swing.JTable jTable_Pac;
    private javax.swing.JTextField jText_ID;
    // End of variables declaration//GEN-END:variables
}