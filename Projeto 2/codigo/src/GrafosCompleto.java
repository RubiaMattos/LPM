public class GrafosCompleto extends Grafo {

    private ABB<Aresta> arestas;
    public int ordem;

    public GrafosCompleto(String nome) {
        super(nome);
    }

    /**
     * If the number of edges in the graph is equal to the number of edges in a
     * complete graph with the
     * same number of vertices, then the graph is complete
     * 
     * @param n number of vertices
     * @return The method is returning a boolean value.
     */
    public boolean completo(int n) {
        if (n * (n - 1) / 2 == this.arestas.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existeAresta(int verticeA, int verticeB) {
        return super.existeAresta(verticeA, verticeB);
    }

    @Override
    public Vertice existeVertice(int idVertice) {
        return super.existeVertice(idVertice);
    }

    public boolean euleriano() {
        return false;
    }

    public Grafo subGrafo(Lista<Vertice> vertices) {
        Grafo subgrafo = new Grafo("Subgrafo de " + this.nome);
        return subgrafo;
    }

}
