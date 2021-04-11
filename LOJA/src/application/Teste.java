package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entity.Loja;
import entity.Roupa;

public class Teste {

	public static void main(String[] args) {
		Roupa roupa;
		int opcao;
		int x;
		int quantidade;
		
		Locale.setDefault(Locale.US);
		Scanner leia = new Scanner(System.in);
		 List <Roupa> lista = new ArrayList<>();
		 List <Roupa> carrinho = new ArrayList<>();
				
		lista.add(roupa = new Roupa("123","Calça",80,10,"FatalSurf"));
		
		lista.add(roupa = new Roupa("456","Camisa",50,10,"FatalSurf"));
		
		lista.add(roupa = new Roupa("789","Jaqueta",150,10,"FatalSurf"));
		
		lista.add(roupa = new Roupa("369","blusa",80,10,"FatalSurf"));
		
		lista.add(roupa = new Roupa("147","Short",40,10,"FatalSurf"));
		
		lista.add(roupa = new Roupa("7987","Saia",70,10,"FatalSurf"));
		
		boolean confirma[] = new boolean [lista.size()];
		
		for(x = 0;x<confirma.length;x++)
		{
			confirma[x]=true;
		}
		
		do {
			limpa();
			System.out.println("Menu de compra");
			for(x=0; x < lista.size();x++)
			{
				System.out.println((x+1)+" - "+lista.get(x).getDescricao());
			}
			System.out.println((x+1)+" - ir para carrinho");
			System.out.println((x+2)+" - sair");
			System.out.println("Digite um opcao: ");
			opcao = leia.nextInt();
			opcao--;
			
			if(opcao < lista.size() && opcao >= 0) 
			{
				if(confirma[opcao] == true)
				{
					System.out.printf("Descrição: %s |Marca: %s | Valor Unit.: R$%.2f | Em estoque: %d\n",lista.get(opcao).getDescricao(),lista.get(opcao).getMarca(),lista.get(opcao).getValorUnitario(),lista.get(opcao).getQtdeEstoque());
					System.out.print("insira quantidade: ");
					quantidade = leia.nextInt();
					
					if(quantidade <= lista.get(opcao).getQtdeEstoque() && quantidade >=0)
					{
						lista.get(opcao).tirarEstoque(quantidade);
						carrinho.add(roupa = new Roupa(lista.get(opcao).getCodigo(),lista.get(opcao).getDescricao(),lista.get(opcao).getValorUnitario(),quantidade,lista.get(opcao).getMarca()));
						
						if(quantidade > 0)
						{
							confirma[opcao] = false;
						}
					}
					else if(quantidade > lista.get(opcao).getQtdeEstoque())
					{
						System.out.println("Quantidade não disponivel!!!");
					}
					else
					{
						System.out.println("Opção invalida");
					}
				}
				else
				{
					System.out.println("Você não pode comprar o mesmo produto");
				}
			}
			else if(opcao == (x))
			{
				limpa();
				System.out.println("Ir carrinho");
				Loja loja = new Loja("teste","32144234");
				loja.emitirNota(carrinho);
				carrinho.clear();
				limpa();
				for(x = 0;x<confirma.length;x++)
				{
					confirma[x]=true;
				}	
			}
			else if(opcao == (x+1))
			{
				System.out.println("Fim do programa");
			}
			else {
				System.out.println("Opcao Invalida tente novamente!!!");
			}
		}while(opcao !=(lista.size()+1));
	}	

	public static void limpa() 
	{
		for(int y=0;y<=10;y++) {
			System.out.println();
		}
	}
}
