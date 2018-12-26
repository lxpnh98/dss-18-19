package configurafacil;

public class CarroInfo extends java.util.Observable {
	private Cliente client;
	private Configuracao config;
	private float preco;

	public CarroInfo() {
		this.client = new Cliente();
		this.config = new Configuracao();
		this.preco = 0;
	}

	public CarroInfo(Cliente client, Configuracao config, float preco) {
		this.client = client;
		this.config = config;
		this.preco = preco;
	}

	public CarroInfo(CarroInfo car) {
		this.client = car.getClient();
		this.config = car.getConfig();
		this.preco = car.getPreco();
	}

	public Cliente getClient() {
		return this.client;
	}

	public Configuracao getConfig() {
		return this.config;
	}

	public float getPreco() {
		return this.preco;
	}
}