public class ArbolBinario {

    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }
/ ===== FASE 1: INSERCIÓN =====
    public void insertar(int d) {
        raiz = insertarRec(raiz, d);
    }

    private Nodo insertarRec(Nodo n, int d) {
        if (n == null) {
            return new Nodo(d);
        }
        if (d < n.getDato()) {
            n.setIzq(insertarRec(n.getIzq(), d));
        } else if (d > n.getDato()) {
            n.setDer(insertarRec(n.getDer(), d));
        }
        return n;
    }

    // ===== FASE 2: RECORRIDOS =====
    public String inorden() {
        StringBuilder sb = new StringBuilder();
        inordenRec(raiz, sb);
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private void inordenRec(Nodo n, StringBuilder sb) {
        if (n != null) {
            inordenRec(n.getIzq(), sb);
            sb.append(n.getDato()).append(",");
            inordenRec(n.getDer(), sb);
        }
    }

    public String preorden() {
        StringBuilder sb = new StringBuilder();
        preordenRec(raiz, sb);
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private void preordenRec(Nodo n, StringBuilder sb) {
        if (n != null) {
            sb.append(n.getDato()).append(",");
            preordenRec(n.getIzq(), sb);
            preordenRec(n.getDer(), sb);
        }
    }

    public String postorden() {
        StringBuilder sb = new StringBuilder();
        postordenRec(raiz, sb);
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private void postordenRec(Nodo n, StringBuilder sb) {
        if (n != null) {
            postordenRec(n.getIzq(), sb);
            postordenRec(n.getDer(), sb);
            sb.append(n.getDato()).append(",");
        }
    }
