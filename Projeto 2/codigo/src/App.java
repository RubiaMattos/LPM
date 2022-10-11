public class App {
    public static void main(String[] args) throws Exception {
        Grafo grafo = new Grafo("Teste");

        // for (int i = 0; i < 4; i++)
        // grafo.addVertice(i);

        // for (int i = 0; i < 4; i++)
        // for (int j = 0; j < 4; j++)
        // if (j != i)
        // grafo.addAresta(i, j);

        // System.out.println(grafo.completo());

        // for (var path : grafo.caminhoEuleriano()) {
        // System.out.printf("%s ", path);
        // }

        // System.out.println();

        // System.out.println(grafo.euleriano());

        grafo.carregar("C://dados//grafo.txt");
        grafo.salvar("C://dados//grafo.txt");
    }
}