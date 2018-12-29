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
        String user = args[0];
        String password = args[1];
        String driver;

        if (args.length <= 2) {
            driver = "com.mysql.cj.jdbc.Driver";
        } else {
            driver = "com.mysql.jdbc.Driver";
        }

        DadosFacade dados = new DadosFacade(user, password, driver);

        ConfiguraFacil cf = new ConfiguraFacil(dados);

        displayInterface(cf);
    }
}
