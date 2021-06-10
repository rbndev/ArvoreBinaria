
public class NoArvore {
	int			valor;
	String nome;
	NoArvore	direita;
	NoArvore	esquerda;
	
    public NoArvore(){
        this.valor = 0;
        this.nome = "";
        this.direita = null;
        this.esquerda = null;
    }
    
    public NoArvore(int novovalor, String nome){
        this.valor = novovalor;
        this.nome = nome;
        this.direita = null;
        this.esquerda = null;
    }
    
    public void clearArvore() {
        int undefined = 0;
		this.valor = undefined;
        this.nome = "";
        this.direita = null;
        this.esquerda = null;
    }

	public NoArvore busca(NoArvore no, int valorprocurado) {
		if(no == null)
			return null;
		
		if(no.valor > valorprocurado)
			return busca(no.esquerda, valorprocurado);
		else if(no.valor < valorprocurado)
			return busca(no.direita, valorprocurado);
		else
			return no;
	}
	
	public NoArvore insere(NoArvore no, int novovalor, String nome) {
		if(no == null) {
			no = new NoArvore();
			no.valor = novovalor;
			no.nome = nome;
			no.esquerda = no.direita = null;
		}
		else if(novovalor < no.valor)
			no.esquerda = insere(no.esquerda, novovalor, nome);
		else if(novovalor > no.valor)
			no.direita = insere(no.direita, novovalor, nome);
	
		return no;
	}

	public void imprimePre(NoArvore raiz) {
		if (raiz != null) {
			System.out.println("Rgm:" + raiz.valor);
			System.out.println("Nome:" + raiz.nome + "\n");
			imprimePre(raiz.esquerda);
			imprimePre(raiz.direita);
		}
	}
	
	public void imprimeIn(NoArvore raiz) {
		if (raiz != null) {
			imprimeIn(raiz.esquerda);
			System.out.println("Rgm:" + raiz.valor);
			System.out.println("Nome:" + raiz.nome + "\n");
			imprimeIn(raiz.direita);
		}
	}
	
	public void imprimePos(NoArvore raiz) {
		if (raiz != null) {
			imprimePos(raiz.esquerda);
			imprimePos(raiz.direita);
			System.out.println("Rgm:" + raiz.valor);
			System.out.println("Nome:" + raiz.nome + "\n");
		}
	}
	
	public NoArvore remove(NoArvore raiz, int valoraremover) {
		// faz a busca pelo valor a ser removido
		if (raiz == null)
			return null;
		else if (raiz.valor > valoraremover)
			raiz.esquerda = remove(raiz.esquerda, valoraremover);
		else if (raiz.valor < valoraremover)
			raiz.direita = remove(raiz.direita, valoraremover);
		else {	// passar por aqui significa que achou o nó com o
				// valora remover procurado e agora vai removê-lo
				// segundo as 4 situações a seguir:
			// Não ter filhos (esquerda e direita == null)
			if (raiz.esquerda == null && raiz.direita == null) {
				raiz = null;
			}
			// Ter filho apenas à direita (esquerda == null)
			else if (raiz. esquerda == null) {
				raiz = raiz.direita;
			}
			// Ter filho apenas à esquerda (direita == null)
			else if (raiz.direita == null) {
				raiz = raiz.esquerda;
			}
			// Ter dois filhos (esquerda e direita != null)
			else {
				NoArvore sub_esquerda = raiz.esquerda;
				// encontrar o nó com maior valor na subárvore esquerda
				while (sub_esquerda.direita != null) {
					sub_esquerda = sub_esquerda.direita;
				}
				// aqui a sub_esquerda.valor tem o maior valor
				raiz.valor = sub_esquerda.valor;
				sub_esquerda.valor = valoraremover;
				raiz.esquerda = remove(raiz.esquerda, valoraremover);
			}
		}
		return raiz;		
	}

}



