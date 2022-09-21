public abstract class GrafoMutavel extends Grafo {

    public GrafoMutavel(String nome) {
        super(nome);
    }
    
    @Override
    public boolean addAresta(int origem, int destino) {
        return super.addAresta(origem, destino);
    }

    @Override
    public boolean addVertice(int id) {
        return super.addVertice(id);
    }

    public void carregar(String nomeArquivo) {
    }

    public boolean delAresta(int origem, int destino) {
        return false;
    }

    public boolean delVertice(int idVertice) {
        return false;
    }
    
    public void salvar(String nomeArquivo) {
    }
}
