package pkginterface;

import configurafacil.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;

/**
 * @author ASUS
 */
public class ConfiguracaoBasica extends javax.swing.JFrame implements Observer {

    private static final long serialVersionUID = 1;
    private Configuracao config;
    
    /**
     * Creates new form ConfiguracaoBasica
     */
    public ConfiguracaoBasica(Configuracao config) {
        this.config = config;
        this.config.addObserver(this);
        initComponents();
        showCategorias();
        showConfiguracao();
    }

    public void showCategorias() {
       
        DefaultListModel<String> cat = new DefaultListModel<>();
        cat.addElement("Motor");
        cat.addElement("Jantes");
        cat.addElement("Pneus");
        cat.addElement("Pintura");
        cat.addElement("Detalhes Internos");
        cat.addElement("Detalhes Externos");
        
        jList_Categorias.setModel(cat);
    }
    
    public void showConfiguracao(){
        
        DefaultTableModel model = (DefaultTableModel)jTable_Configuracao.getModel();
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
    }
    
    public void showOpcoes(){
        DefaultListModel<String> opcoes = new DefaultListModel<>();
        String s = jList_Categorias.getSelectedValue();
        
        switch(s){
            case "Motor":
                opcoes.addElement("Motor tipo 1");
                jList_Opcoes.setModel(opcoes);
                break;
            case "Jantes":
                opcoes.addElement("Jantes tipo 1");
                jList_Opcoes.setModel(opcoes);
                break;
            case "Pneus":
                opcoes.addElement("Pneus tipo 1");
                jList_Opcoes.setModel(opcoes);
                break;
            case "Pintura":
                opcoes.addElement("Pintura tipo 1");
                jList_Opcoes.setModel(opcoes);
                break;
            case "Detalhes Internos":
                opcoes.addElement("Tipo 1");
                jList_Opcoes.setModel(opcoes);
                break;
            case "Detalhes Externos":
                opcoes.addElement("Tipo 1");
                jList_Opcoes.setModel(opcoes);
                break;
            default:
                opcoes.addElement("Algo errado não está certo");
                jList_Opcoes.setModel(opcoes);
                break;
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

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_Categorias = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList_Opcoes = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Configuracao = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Configurações básicas do carro");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Próximo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Selecionar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList_Categorias);

        jScrollPane3.setViewportView(jList_Opcoes);

        jLabel3.setText("Categorias:");

        jLabel4.setText("Opções:");

        jTable_Configuracao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente"
            }
        ));
        jScrollPane2.setViewportView(jTable_Configuracao);

        jButton4.setText("Adicionar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 48, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new MenuInicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       // try { 
            new OpcoesdeConfiguracao(this.config).setVisible(true);
            this.dispose();
       // } catch (SemConfigBasicaException e) {
        
        //}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        showOpcoes();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.config.deleteObservers();
    }//GEN-LAST:event_formWindowClosed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String cat = jList_Categorias.getSelectedValue();
        String opt = jList_Opcoes.getSelectedValue();
        
        switch(cat){
            case "Motor":
                this.config.setMotor(opt);
                showConfiguracao();
                break;
            case "Jantes":
                this.config.setJantes(opt);
                showConfiguracao();
                break;
            case "Pneus":
                this.config.setPneus(opt);
                showConfiguracao();
                break;
            case "Pintura":
                this.config.setPintura(opt);
                showConfiguracao();
                break;
            case "Detalhes Internos":
                this.config.setDetInteriores(opt);
                showConfiguracao();
                break;
            case "Detalhes Externos":
                this.config.setDetExteriores(opt);
                showConfiguracao();
                break;
            default:
                showConfiguracao();
                break;
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList_Categorias;
    private javax.swing.JList<String> jList_Opcoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_Configuracao;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
       showConfiguracao();
       showOpcoes();
    }
}
