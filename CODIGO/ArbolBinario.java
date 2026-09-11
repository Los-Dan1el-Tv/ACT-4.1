public class ArbolBinario {

    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    // ===== FASE 1: INSERCIÓN =====
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

    // ===== FASE 3: BÚSQUEDA =====
    public boolean buscar(int d) {
        return buscarRec(raiz, d);
    }

    private boolean buscarRec(Nodo n, int d) {
        if (n == null) {
            return false;
        }
        if (d == n.getDato()) {
            return true;
        } else if (d < n.getDato()) {
            return buscarRec(n.getIzq(), d);
        } else {
            return buscarRec(n.getDer(), d);
        }
    }

    private Nodo buscarNodo(Nodo n, int d) {
        if (n == null) {
            return null;
        }
        if (d == n.getDato()) {
            return n;
        } else if (d < n.getDato()) {
            return buscarNodo(n.getIzq(), d);
        } else {
            return buscarNodo(n.getDer(), d);
        }
    }

    public String claseNodo(int d) {
        Nodo n = buscarNodo(raiz, d);
        if (n == null) {
            return "NO_EXISTE";
        }
        if (n == raiz) {
            return "RAIZ";
        }
        if (n.getIzq() == null && n.getDer() == null) {
            return "HOJA";
        }
        if (n.getIzq() != null && n.getDer() != null) {
            return "DOS_HIJOS";
        }
        return "UN_HIJO";
    }

    // ===== FASE 4/5: ELIMINACIÓN (hoja, un hijo, dos hijos) =====
    public boolean eliminar(int d) {
        if (!buscar(d)) {
            return false;
        }
        raiz = eliminarRec(raiz, d);
        return true;
    }

    private Nodo eliminarRec(Nodo n, int d) {
        if (n == null) {
            return null;
        }
        if (d < n.getDato()) {
            n.setIzq(eliminarRec(n.getIzq(), d));
        } else if (d > n.getDato()) {
            n.setDer(eliminarRec(n.getDer(), d));
        } else {
            // Caso HOJA: sin hijos
            if (n.getIzq() == null && n.getDer() == null) {
                return null;
            }
            // Caso: un solo hijo
            if (n.getIzq() == null) {
                return n.getDer();
            }
            if (n.getDer() == null) {
                return n.getIzq();
            }
            // Caso: dos hijos -> buscar el menor del subárbol derecho
            Nodo sucesor = n.getDer();
            while (sucesor.getIzq() != null) {
                sucesor = sucesor.getIzq();
            }
            n.setDato(sucesor.getDato());
            n.setDer(eliminarRec(n.getDer(), sucesor.getDato()));
        }
        return n;
    }
}
