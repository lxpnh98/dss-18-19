package configurafacil;

/**
 *
 * @author TIagoasfasf
 */
public class CarroInfo extends java.util.Observable {
	private Cliente client;
	private Configuracao config;
	private Pacote pacote;

	public CarroInfo() {
		this.client = new Cliente();
		this.config = new Configuracao();
		this.pacote = new Pacote();
	}

	public CarroInfo(Cliente client, Configuracao config, Pacote pacote) {
		this.client = client;
		this.config = config;
		this.pacote = pacote;
	}

	public CarroInfo(CarroInfo car) {
		this.client = car.getClient();
		this.config = car.getConfig();
		this.pacote = car.getPacote();
	}

	public Cliente getClient() {
		return this.client;
	}

	public Configuracao getConfig() {
		return this.config;
	}

	public Pacote getPacote() {
		return this.pacote;
	}
}