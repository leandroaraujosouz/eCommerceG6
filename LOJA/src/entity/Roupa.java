package entity;

public class Roupa extends Produto{

	private String marca;

	//construtor
	public Roupa(String codigo, String descricao,  double valorUnitario, int qtdeEstoque, String marca) {
		super(codigo, descricao,  valorUnitario, qtdeEstoque);
		this.marca = marca;
	}
	//encapsulamento
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}
