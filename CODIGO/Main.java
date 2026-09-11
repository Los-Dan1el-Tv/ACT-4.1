public class Main {
    public static void main(String[] args) {
        ArbolBinario a = new ArbolBinario();
        int[] sec = { 17, 81, 10, 99, 56, 14, 49, 66, 40, 100, 41, 35, 70, 1, 69, 36, 73, 58, 13, 54, 75, 34 };
        for (int i = 0; i < sec.length; i++) {
            a.insertar(sec[i]);
        }
        boolean r0 = a.eliminar(1);
        System.out.println("ELIMINADO:1=" + r0);
        boolean r1 = a.eliminar(10);
        System.out.println("ELIMINADO:10=" + r1);
        System.out.println("INORDEN:" + a.inorden());
        System.out.println("PREORDEN:" + a.preorden());
    }
}
