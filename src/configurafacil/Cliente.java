package configurafacil;

import java.lang.String;

public class Cliente {
    private int id;
    private String nome;
    private String tlmv;
    private String email;
    private String nif;

    public Cliente() {
        this.id = 0;
        this.nome = "";
        this.tlmv = "";
        this.email = "";
        this.nif = "";
    }

    public Cliente(int id, String nome, String tlmv, String email, String nif) {
        this.id = id;
        this.nome = nome;
        this.tlmv = tlmv;
        this.email = email;
        this.nif = nif;
    }

    public Cliente(Cliente c) {
        this.id = c.getId();
        this.nome = c.getNome();
        this.tlmv = c.getTlmv();
        this.email = c.getEmail();
        this.nif = c.getNif();
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }
    
    public String getTlmv() {
        return this.tlmv;
    }

    public String getEmail() {
        return this.email;
    }
    
    public String getNif() {
        return this.nif;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTlmv(String tlmv) {
        this.tlmv = tlmv;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public static boolean validaInfo(String nome, String tlmv, String email, String nif) {
        if(numerosValidos(tlmv) && numerosValidos(nif) && nome.length()!=0 && verificaMail(email)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean numerosValidos(String numeros) {
        int length = numeros.length();
        if(length != 9) {
            return false;
        }
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

    public static boolean verificaMail(String mail) {
        for(int i = 0; i < mail.length(); i++)  {
            if(mail.charAt(i)=='@' && i != mail.length()-1)
                return true;
        }
        return false;
    }

    public Cliente clone() {
        return new Cliente(this);
    }

    public String toString() {
        return "Nome: " + this.nome + "\nId:" + this.id + "\nTlmv: " + this.tlmv +
               "\nEmail: " + this.email + "\nNif: " + this.nif;
    }
}
