package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja {
	private String nome;
	private String cnpj;
	Scanner leia = new Scanner(System.in);
	private List<Roupa> lista = new ArrayList<>();
	public Loja(String nome, String cnpj) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
		
	public void emitirNota(List<Roupa> lista)
	{
		double total =0;
		double desconto =0;
		double juros10 =0;
		double juros20=0;
		double imposto=0;
		int opcao;
		
		System.out.printf("Loja: %s\nCNPJ: %s\n",nome,cnpj);
		
		for(Roupa itens : lista)
		{
			System.out.printf("Descrição: %s | Valor Unit.: %.2f | Qtde: %d Valor: R$ %.2f\n",itens.getDescricao(),itens.getValorUnitario(),itens.getQtdeEstoque(),(itens.getValorUnitario()*itens.getQtdeEstoque()));
			total = total + (itens.getValorUnitario()*itens.getQtdeEstoque());
		}
		imposto = total*0.09;
		System.out.println("Total: "+total);
		System.out.println("Forma de pagamento");
		System.out.println("1 - À vista (10% de desconto)"+"\n2 - Debito"+"\n3 - Credito");
		
		opcao = leia.nextInt();
		
		System.out.printf("Nota Fiscal: 1238091238458790348\n");
		if(opcao == 1)
		{
			desconto = total*0.1;
			System.out.printf("Imposto: %.2f\nDesconto: %.2f\nTotal compra: %.2f\n\n",imposto,desconto,(total-desconto));
		}
		else if (opcao == 2)
		{
			System.out.printf("Imposto: %.2f\nTotal compra: %.2f\n\n",imposto,total);
		}
		else if(opcao ==3)
		{
			System.out.println("1 - 1x 10% juros\n2 - 2x 20% juros: ");
			opcao = leia.nextInt();
			if(opcao == 1)
			{
				juros10 = total*0.1;
				System.out.printf("Taxa de imposto: %.2f\nJuros: %.2f\n1 Parcela de: %.2f\n\n",imposto,juros10,(total+juros10));
			}
			else
			{
				juros20 = total*0.2;
				System.out.printf("Taxa de imposto: %.2f\nJuros: %.2f\n2 Parcela de: %.2f\nTotal compra %.2f\n\n",imposto,juros20,((total+juros20)/2),(total+juros20));
			}
			
		}
		System.out.printf("Loja: %s\n CNPJ: %s\n",nome,cnpj);
		System.out.println("Digite qualquer tecla para continuar");
		leia.next();
	}
	
	
}
