public class ArvoreBinaria {
    private Node raiz;
    public ArvoreBinaria() {
        raiz = null;
    }

    public Node getRaiz() {
        return raiz;
    }


    public void inserir(int informacao) {
        if (raiz != null) {
            raiz.inserir(informacao);
        } else {
            raiz = new Node(informacao);
        }
    }

    public void imprimir(int altura, String pos) {
        System.out.println("----- ARVORE -----");
        raiz.imprimir(0, null);
    }

    public void remover(int n) {
        if (!vazia()) {
            if (raiz.getInformacao() == n) {
                raiz = raiz.remover(raiz);
            } else {
                Node no = raiz.buscar(n);
                if (no != null) {
                    raiz.remover(no);
                } else {
                    System.out.println("valor nao existe");
                }
            }
        }
    }

    public Node buscar(int valor) {
        return raiz.buscar(valor);
    }

    public boolean vazia() {
        if (raiz == null){
            System.out.println("Arvore vazia!!");
            return true;
        } else {
            return false;
        }
    }

    public void rebalancear() {
        raiz = raiz.rebalancear();
    }
}