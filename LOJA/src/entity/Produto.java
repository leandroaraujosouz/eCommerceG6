package entity;

public abstract class Produto {
	private String descricao;
	private String codigo;
	private double valorUnitario;
	private int qtdeEstoque = 0;
	
	public  Produto(String codigo, String descricao,  double valorUnitario, int qtdeEstoque)
	{
		super();
		this.descricao = descricao;
		this.codigo = codigo;
		this.valorUnitario = valorUnitario;
		this.qtdeEstoque = qtdeEstoque;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCodigo() {
		return codigo;
	}
	
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public int getQtdeEstoque() {
		return qtdeEstoque;
	}
	
	public void incluirEstoque(int qtdeEstoque)
	{
		this.qtdeEstoque = this.qtdeEstoque + qtdeEstoque;
	}
	
	public void tirarEstoque(int qtdeEstoque)
	{
		if(this.qtdeEstoque >= qtdeEstoque)
		{
			this.qtdeEstoque = this.qtdeEstoque - qtdeEstoque;
		}
		else
		{
			System.out.println("Estoque abaixo do pedido");
		}
	}
}
