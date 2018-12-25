import pkginterface.MenuInicial;
import pkgdados.DadosFacade;
import configurafacil.ConfiguraFacil;
import configurafacil.*;

public class Main {
    
    private static void displayInterface() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuInicial().setVisible(true);
            }
        });
    }
    
    public static void main(String[] args) {
        String user = "root";//args[1];
        String password = "password";//args[2];

        DadosFacade dados = new DadosFacade(user, password);

        ConfiguraFacil cf = new ConfiguraFacil(dados);

        //MenuInicial menu = new MenuInicial(cf);

        // TODO: iniciar GUI
        // ...
        
        displayInterface();
    }
}