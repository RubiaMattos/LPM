public class GrafoNãoPonderado extends GrafoMutavel {

    public GrafoNãoPonderado(String nome) {
        super(nome);
    }

    @Override
    public boolean addAresta(int origem, int destino) {
        return super.addAresta(origem, destino);
    }

    @Override
    public Grafo subGrafo(Lista<Vertice> vertices) {
        Grafo subgrafo = new Grafo("Subgrafo de " + this.nome);

        return subgrafo;
    }
    
}
