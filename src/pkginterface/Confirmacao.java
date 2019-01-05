package pkginterface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import configurafacil.*;
import java.util.Collection;
import javax.swing.table.DefaultTableModel;
import static pkginterface.ConfiguracaoOtima.infoBox;

/**
 *
 * @author ASUS
 */
public class Confirmacao extends javax.swing.JFrame {

    private static final long serialVersionUID = 1;
    private Configuracao config;
    private ConfiguraFacil cf;
    
    /**
     * Creates new form Confirmacao
     */
    public Confirmacao(ConfiguraFacil cf) {
        this.cf = cf;
        this.config = this.cf.getConfiguracaoAtual();
        initComponents();
        showConfiguracao();
        showPreco();
    }
    
    public void showConfiguracao() {

        Collection<Integer> ids = this.config.getComponentes();
        Collection<Integer> pacotes = this.cf.getConfiguracaoAtual().getPacotes();
        DefaultTableModel model = (DefaultTableModel)jTable_ConfigFinal.getModel();
        Object[] row = new Object[1];
        
        model.setRowCount(0);
        row[0] = this.config.getMotor();
        model.addRow(row);
        row[0] = this.config.getJantes();
        model.addRow(row);
        row[0] = this.config.getPneus();
        model.addRow(row);
        row[0] = this.config.getPintura();
        model.addRow(row);
        row[0] = this.config.getDetInteriores();
        model.addRow(row);
        row[0] = this.config.getDetExteriores();
        model.addRow(row);
        
        for(Integer id : ids) {
           row[0] = this.cf.getComponente(id).getNome();
           model.addRow(row);
        }
        
        for(Integer p : pacotes) {
           row[0] = this.cf.getPacote(p).getNome();
           model.addRow(row);
       }
    }
    
    public void showPreco() {
        float r = getPrecoMotor();
        r += getPrecoPintura();
        r += getPrecoJantes();
        r += getPrecoPneus();
        r += getPrecoDetEx();
        r += getPrecoDetIn();
        
        DefaultTableModel model = (DefaultTableModel)jTable_Preco.getModel();
        Object[] row = new Object[1];
        model.setRowCount(0);
        row[0] = r + this.cf.getPreco(this.cf.getConfiguracaoAtual().getComponentes(), this.cf.getConfiguracaoAtual().getPacotes());
        model.addRow(row);
    }
    
    public float getPrecoMotor(){
        String s = this.config.getMotor();
        float p = 0;
        
        switch(s){
            case "Motor A":
                p = 2500;
                break;
            case "Motor B":
                p = 3000;
                break;
            case "Motor C":
                p = 3500;
                break;
            default:
                    p = 0;
        }
        return p;
    }
    
    public float getPrecoPintura(){
        String s = this.config.getPintura();
        float p = 0;
        
        switch(s){
                case "Preto":
                    p = 200;
                    break;
                case "Cinzento":
                    p = 200;
                    break;
                case "Branco":
                    p = 3500;
                    break;
                default:
                    p = 0;
        }
        return p;
    }
    
    public float getPrecoJantes(){
        String s = this.config.getJantes();
        float p = 0;
        
        switch(s){
                case "Jantes A":
                    p = 100;
                    break;
                case "Jantes B":
                    p = 200;
                    break;
                case "Jantes C":
                    p = 400;
                    break;
                default:
                    p = 0;
        }
        return p;
    }
    
    public float getPrecoPneus(){
        String s = this.config.getPneus();
        float p = 0;
        
        switch(s){
                case "Pneus A":
                    p = 100;
                    break;
                case "Pneus B":
                    p = 200;
                    break;
                case "Pneus C":
                    p = 300;
                    break;
                default:
                    p = 0;
        }
        return p;
    }
    
    public float getPrecoDetIn(){
        String s = this.config.getDetInteriores();
        System.out.println(s);
        float p = 0;
        
        switch(s){
                case "Estofos simples":
                    p = 500;
                    break;
                case "Estofos de pele":
                    p = 1000;
                    break;
                default:
                    p = 0;
        }
        return p;
    }
    
    public float getPrecoDetEx(){
        String s = this.config.getDetExteriores();
        System.out.println(s);
        float p = 0;
        
        switch(s){
                case "Textura simples":
                    p = 500;
                    break;
                default:
                    p = 0;
        }
        return p;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ConfigFinal = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_Preco = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Configuração final do carro:");

        jButton1.setText("Encomendar");
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

        jTable_ConfigFinal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente"
            }
        ));
        jScrollPane1.setViewportView(jTable_ConfigFinal);

        jTable_Preco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Preço"
            }
        ));
        jScrollPane3.setViewportView(jTable_Preco);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new OpcoesdeConfiguracao(this.cf).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.cf.setConfigAtual(this.config);
        this.cf.adicionaCarro();
        infoBox("Encomenda realizada com sucesso!", "Informação de encomenda");
        new MenuInicial(this.cf).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable_ConfigFinal;
    private javax.swing.JTable jTable_Preco;
    // End of variables declaration//GEN-END:variables
}