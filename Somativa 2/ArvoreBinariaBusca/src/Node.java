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

        System.out.println(informacao);
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
                remover(menorElemento);
                informacao = menorElemento.informacao;
            }
        } else {
            filhoDireito = filhoDireito.remover(no);
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