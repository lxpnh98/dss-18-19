import pkginterface.MenuInicial;
import pkgdados.DadosFacade;
import configurafacil.ConfiguraFacil;
import configurafacil.*;

public class Main {

    private static void displayInterface(ConfiguraFacil cf) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuInicial().setVisible(true); // TODO: passar cf como argumento
            }
        });
    }
    
    public static void main(String[] args) {
        String user = "root";//args[1];
        String password = "password";//args[2];

        DadosFacade dados = new DadosFacade(user, password);

        ConfiguraFacil cf = new ConfiguraFacil(dados);

        displayInterface(cf);
    }
}
