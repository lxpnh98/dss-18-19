/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

import configurafacil.*;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ConfiguracaoOtima extends javax.swing.JFrame implements Observer {

    private static final long serialVersionUID = 1;
    private ConfiguraFacil cf;
    private Configuracao configA;
    private Configuracao configO;
    
    /**
     * Creates new form ConfiguraçãoOtima
     */
    public ConfiguracaoOtima(ConfiguraFacil cf) {
        this.cf = cf;
        this.configA = this.cf.getConfiguracaoAtual();
        //this.configO = calculaConfiguracaoOtima();
        this.configA.addObserver(this);
        //this.configO.addObserver(this);
        initComponents();
        showConfiguracaoAtual();
        //showConfiguracaoOtima();
    }
    
    public Configuracao getConfigOtima(){
        return this.configO;
    }
    
    public void showConfiguracaoAtual() {

       Collection<Integer> ids = this.configA.getComponentes();
       DefaultTableModel model = (DefaultTableModel)jTable_Atual.getModel();
       Object[] row = new Object[2];
       model.setRowCount(0);
       int i = 0;
       for(Integer id : ids) {
           row[0] = this.cf.getComponente(id).getNome();
           row[1] = this.cf.getComponente(id).getPreco();
           i++;
           model.addRow(row);
       }
    }
    /*
    public void showConfiguracaoOtima() {

       Collection<Integer> ids = this.configO.getComponentes();
       DefaultTableModel model = (DefaultTableModel)jTable_Otima.getModel();
       Object[] row = new Object[2];
       model.setRowCount(0);
       int i = 0;
       for(Integer id : ids) {
           //row[0] = this.cf.getComponente(id).getNome();
           //row[1] = this.cf.getComponente(id).getPreco();
           i++;
           model.addRow(row);
       }
    }
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Atual = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Otima = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_Atual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente", "Preço"
            }
        ));
        jScrollPane1.setViewportView(jTable_Atual);

        jLabel1.setText("Configuração Atual:");

        jTable_Otima.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente", "Preço"
            }
        ));
        jScrollPane2.setViewportView(jTable_Otima);

        jLabel2.setText("Configuração Ótima:");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Alterar Configuração");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new OpcoesdeConfiguracao(this.cf).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.cf.setConfigAtual(configO);
        showConfiguracaoAtual();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Atual;
    private javax.swing.JTable jTable_Otima;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
       showConfiguracaoAtual();
       //showConfiguracaoOtima();
    }
}
