public class GrafoPonderado extends GrafoMutavel {

    Aresta arestas;

    public GrafoPonderado(String nome) {
        super(nome);
    }

    @Override
    public boolean addAresta(int origem, int destino) {
        return super.addAresta(origem, destino);
    }

    public boolean addAresta(int origem, int destino, int peso) {
        return arestas.add(destino, new Aresta(0, destino));
    }

    public void carregar(String nomeArquivo) {

    }
    
    public Grafo subGrafo(Lista<Vertice> vertices) {
        Grafo subgrafo = new Grafo("Subgrafo de " + this.nome);

        return subgrafo;
    }
}
