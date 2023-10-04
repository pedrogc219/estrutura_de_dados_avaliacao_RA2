public class Node {
    private int informacao;
    private Node filhoEsquerdo;
    private Node filhoDireito;
    public Node(int informacao) {
        this.informacao = informacao;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
    }

    public int getInformacao() {
        return informacao;
    }
    public void setInformacao(int informacao) {
        this.informacao = informacao;
    }

    public Node getFilhoEsquerdo() {
        return filhoEsquerdo;
    }
    public void setFilhoEsquerdo(Node filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public Node getFilhoDireito() {
        return filhoDireito;
    }
    public void setFilhoDireito(Node filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    public void inserir(int informacao) {
        if (informacao < this.informacao) {
            if (filhoEsquerdo != null) {
                filhoEsquerdo.inserir(informacao);
            } else {
                filhoEsquerdo = new Node(informacao);
            }
        } else {
            if (filhoDireito != null) {
                filhoDireito.inserir(informacao);
            } else {
                filhoDireito = new Node(informacao);
            }
        }
    }

    public void imprimir(int altura, String pos) {
        for (int i = 0; i < altura; i++) {
            System.out.print("-");
        }
        if (pos == null) {
            System.out.print("R ");
        } else {
            System.out.print(pos);
        }

        System.out.print(informacao);
        System.out.println(" "+balanceamento());
        if (filhoEsquerdo != null) {
            filhoEsquerdo.imprimir(altura+1, "E ");
        }
        if (filhoDireito != null) {
            filhoDireito.imprimir(altura+1, "D ");
        }
    }

    public Node remover(Node no) {
        if (no.informacao < informacao) {
            filhoEsquerdo = filhoEsquerdo.remover(no);
        } else if (no.informacao > informacao) {
            filhoDireito = filhoDireito.remover(no);
        } else if (this.equals(no)) {
            if (filhoEsquerdo == null) {
                return filhoDireito;
            } else if (filhoDireito == null) {
                return filhoEsquerdo;
            } else {
                Node menorElemento = filhoDireito.menorElemento();
                filhoDireito.remover(menorElemento);
                informacao = menorElemento.informacao;
            }
        } else {
            filhoEsquerdo = filhoEsquerdo.remover(no);
        }
        return this;
    }

    public Node menorElemento() {
        if (filhoEsquerdo == null) {
            return this;
        } else {
            return filhoEsquerdo.menorElemento();
        }
    }

    private int altura(Node no) {
        if (no == null) {
            return -1;
        }
        int esquerda = altura(no.filhoEsquerdo);
        int direita = altura(no.filhoDireito);
        if (esquerda > direita) {
            return 1 + esquerda;
        }
        return 1 + direita;
    }

    public int balanceamento() {
        return altura(filhoEsquerdo) - altura(filhoDireito);
    }

    public Node rebalancear() {
        // Rebalancemento dos filhos primeiro
        if (filhoEsquerdo != null) {
            filhoEsquerdo = filhoEsquerdo.rebalancear();
        }
        if (filhoDireito != null) {
            filhoDireito = filhoDireito.rebalancear();
        }

        // ROTAÇÃO PARA DIREITA
        if (balanceamento() == 2) {
            if (filhoEsquerdo.balanceamento() == -1) {
                filhoEsquerdo = filhoEsquerdo.rotacaoEsquerda();
                return rotacaoDireita();
            } else {
                return rotacaoDireita();
            }
        } else if (balanceamento() == -2) {   // ROTAÇÃO PARA ESQUERDA
            if (filhoDireito.balanceamento() == 1) {
                filhoDireito = filhoDireito.rotacaoDireita();
                return rotacaoEsquerda();
            } else {
                return rotacaoEsquerda();
            }
        } else {    // JA BALANCEADA
            return this;
        }
    }

    private Node rotacaoEsquerda() {
        Node novaRaiz = filhoDireito;
        Node temp = novaRaiz.filhoEsquerdo;
        novaRaiz.setFilhoEsquerdo(this);
        filhoDireito = temp;
        return novaRaiz;
    }
    private Node rotacaoDireita() {
        Node novaRaiz = filhoEsquerdo;
        Node temp = novaRaiz.filhoDireito;
        novaRaiz.setFilhoDireito(this);
        filhoEsquerdo = temp;
        return novaRaiz;
    }

    public Node buscar(int valor) {
        if (valor == informacao) {
            return this;
        } else if (valor < informacao && filhoEsquerdo != null) {
            return filhoEsquerdo.buscar(valor);
        } else if (valor > informacao && filhoDireito != null) {
            return filhoDireito.buscar(valor);
        } else {
            return null;
        }
    }
}