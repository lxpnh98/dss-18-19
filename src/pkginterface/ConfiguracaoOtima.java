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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static pkginterface.Vendedor.infoBox;

/**
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
        this.configA.addObserver(this);
        initComponents();
        showConfiguracaoAtual();
    }
    
    public void showConfiguracaoAtual() {
        
       Collection<Integer> ids = this.cf.getConfiguracaoAtual().getComponentes();
       Collection<Integer> pacotes = this.cf.getConfiguracaoAtual().getPacotes();
       DefaultTableModel model = (DefaultTableModel)jTable_Atual.getModel();
       Object[] row = new Object[1];
       model.setRowCount(0);
       int i = 0;
       for(Integer id : ids) {
           row[0] = this.cf.getComponente(id).getNome();
           i++;
           model.addRow(row);
       }
       for(Integer p : pacotes) {
           row[0] = this.cf.getPacote(p).getNome();
           i++;
           model.addRow(row);
       }
    }
    
    public void showConfiguracaoOtima(Configuracao config) {

       Collection<Integer> ids = config.getComponentes();
       Collection<Integer> pacotes = config.getPacotes();
       DefaultTableModel model = (DefaultTableModel)jTable_Otima.getModel();
       Object[] row = new Object[1];
       model.setRowCount(0);
       int i = 0;
       for(Integer id : ids) {
           row[0] = this.cf.getComponente(id).getNome();
           i++;
           model.addRow(row);
       }
       for(Integer id : pacotes) {
           row[0] = this.cf.getPacote(id).getNome();
           i++;
           model.addRow(row);
       }
    }
    
    public static boolean isDigit(String numeros) {
        int length = numeros.length();

        for (int i = 0; i < length; i++) {
            if(numeros.charAt(i)=='1' || numeros.charAt(i)=='2' || numeros.charAt(i)=='3' ||
               numeros.charAt(i)=='4' || numeros.charAt(i)=='5' || numeros.charAt(i)=='6' ||
               numeros.charAt(i)=='7' || numeros.charAt(i)=='8' || numeros.charAt(i)=='9'    ) {
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static void infoBox(String infoMessage, String titleBar) {
        
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    
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
        jButton3 = new javax.swing.JButton();
        jText_orc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_Atual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente"
            }
        ));
        jScrollPane1.setViewportView(jTable_Atual);

        jLabel1.setText("Configuração Atual:");

        jTable_Otima.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente"
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

        jButton3.setText("Calcular Configuração Ótima");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Orçamento:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jText_orc, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3))
                    .addComponent(jText_orc))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new OpcoesdeConfiguracao(this.cf).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.cf.setConfigAtual(this.configO);
        showConfiguracaoAtual();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if ("".equals(jText_orc.getText()) || !isDigit(jText_orc.getText())) {
            infoBox("Orçamento incorreto.", "Informação de Orçamento");
        } else {
            float orcamento = Float.parseFloat(jText_orc.getText());
            this.configO = this.cf.calculaConfiguracaoOtima(orcamento);
            showConfiguracaoOtima(this.cf.calculaConfiguracaoOtima(orcamento));
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Atual;
    private javax.swing.JTable jTable_Otima;
    private javax.swing.JTextField jText_orc;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
       showConfiguracaoAtual();
    }
}
