import java.util.Scanner;

public class Principal {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int option;
		NoArvore abb = null;
		boolean first = true;
						
		do {
			System.out.println("Escolha uma opção");
			System.out.println("1- Inserir número");
			System.out.println("2- Remover");
			System.out.println("3- Buscar");
			System.out.println("4- Esvaziar arvore");
			System.out.println("5- Exibir arvore");
			System.out.println("0- Sair");
			
			option = input.nextInt();
			
			@SuppressWarnings("resource")
			Scanner num = new Scanner(System.in);
	
			switch (option) {
				case 1:
					// INPUT RGM
					System.out.println("Seu Nome: ");
					String newNome = num.nextLine();
					// INPUT NOME
					System.out.println("Seu RGM");
					int newNumber = num.nextInt();		
					
					if(first) {
						abb = new NoArvore(newNumber, newNome);	
						first = false;
					}else {
						abb.insere(abb, newNumber, newNome);
					}
				break;
				case 2:
					System.out.println("REMOVER UM NÓ");
					int numDel = num.nextInt();
					abb.remove(abb, numDel);
				break;
				case 3:
					System.out.println("BUSCAR");//PESQUISAR – fornecer o RGM a pesquisar
					int numSearch = num.nextInt();
					NoArvore resultado = abb.busca(abb, numSearch);
					
					if(resultado == null)
						System.out.println("Não encontrei o no " + numSearch);
					else
						System.out.println("Encontrei o nó: " + resultado.valor);
				break;
				case 4:
					System.out.println("ESVAZIAR A ÁRVORE");
					abb.clearArvore();
					first = true;
					abb = null;
				break;
				case 5:
					System.out.println("### EXIBIR ###");
					
					if(first)
						System.out.println("Arvore vazia");
					else {
						System.out.println("-----------\nPré:");
						abb.imprimePre(abb);
						System.out.print("-----------");
					
						
						System.out.print("\nPós: \n");
						abb.imprimePos(abb);
						System.out.print("-----------");
						
						System.out.print("\nIn: \n");
						abb.imprimeIn(abb);
						System.out.println();
					}
				break;
				case 0:
					System.out.println("### FIM DO PROGRAMA ###");
				break;
	
				default:
					System.out.println("Digite uma opção válida.");
				break;
			}	
			
		}while(option != 0);
	}

}
