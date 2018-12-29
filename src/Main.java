import pkginterface.MenuInicial;
import pkgdados.DadosFacade;
import configurafacil.ConfiguraFacil;

public class Main {

    private static void displayInterface(ConfiguraFacil cf) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuInicial(cf).setVisible(true);
            }
        });
    }
    
    public static void main(String[] args) {
        String user = args[1];
        String password = args[2];
        String cj = args[3];
        String driver = (cj.equals("") == false ? "com.mysql.cj.jdbc.Driver" : "com.mysql.jdbc.Driver");

        DadosFacade dados = new DadosFacade(user, password, driver);

        ConfiguraFacil cf = new ConfiguraFacil(dados);

        displayInterface(cf);
    }
}
