import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/** 
 * MIT License
 *
 * Copyright(c) 2021 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
 * Classe básica para um Grafo simples
 */

interface Action<T> {
    void execute(T t);
}

interface Func<T, R> {
    R execute(T t);
}

class Pair<X, Y> {
    public final X x;
    public final Y y;

    public Pair(X x, Y y) {
        this.x = x;
        this.y = y;
    }
}

public class Grafo {
    public final String nome;
    public ABB<Vertice> vertices;

    /**
     * Construtor. Cria um grafo vazio com capacidade para MAX_VERTICES
     */
    public Grafo(String nome) {
        this.nome = nome;
        this.vertices = new ABB<>();
    }

    public List<String> caminhoEuleriano() {
        var clone = this.clone();
        // Find a vertex with odd degree
        var inicial = clone.vertices.find(1);
        for (var vertice : clone.vertices)
            if (vertice.getArestas().size() % 2 == 1) {
                inicial = vertice;
                break;
            }

        var resultado = new LinkedList<String>();
        eulerUtil(clone, inicial, resultado);
        return resultado;
    }

    public static String nome2 = "";

    private static String representacao(int origem, int destino) {
        if (origem < destino)
            return String.format("%d|%d", origem, destino);

        return String.format("%d|%d", destino, origem);
    }

    // private static String representacao(int origem, int destino) {
    // return String.format("%d|%d", origem, destino);
    // }

    public int numArestas() {
        Set<String> arestas = new HashSet<>();

        for (var vertice : vertices)
            for (var aresta : vertice.getArestas()) {
                int origem = vertice.getId();
                int destino = aresta.destino();
                arestas.add(representacao(origem, destino));
            }

        return arestas.size();
    }

    /**
     * Verifica se este é um grafo completo.
     * 
     * @return TRUE para grafo completo, FALSE caso contrário
     */

    public boolean completo() {
        int totalArestas = this.numArestas();
        int n = this.vertices.size();

        return (n * (n - 1)) / 2 == totalArestas;
    }

    private static Integer dfsCount(Grafo grafo, Vertice vertice) {
        vertice.visitar();
        int count = 1;
        for (var aresta : vertice.getArestas()) {
            var destino = grafo.vertices.find(aresta.destino());
            if (!destino.visitado())
                count += dfsCount(grafo, destino);
        }
        return count;
    };

    private static Boolean eulerNaoPonte(Grafo grafo, Pair<Vertice, Vertice> adj) {
        if (adj.x.getArestas().size() == 1)
            return true;

        int x = dfsCount(grafo, adj.x);

        grafo.delAresta(adj);

        for (var vertice : grafo.vertices)
            vertice.limparVisita();

        int y = dfsCount(grafo, adj.y);

        grafo.addAresta(adj.x.getId(), adj.y.getId());

        for (var vertice : grafo.vertices)
            vertice.limparVisita();

        return x > y ? false : true;
    };

    private static void eulerUtil(Grafo grafo, Vertice origem, List<String> resultado) {
        for (int i = 0; i < origem.getArestas().size(); i++) {
            var adjList = origem.getArestas().allElements(new Aresta[0]);
            var aresta = adjList[i];
            var destino = grafo.vertices.find(aresta.destino());
            var adj = new Pair<Vertice, Vertice>(origem, destino);

            if (eulerNaoPonte(grafo, adj)) {
                resultado.add(adj.x.getId() + "-" + adj.y.getId());
                grafo.delAresta(adj);
                eulerUtil(grafo, destino, resultado);
            }
        }
    }

    /*
     * Verificar se o grafo é euleriano
     */
    public boolean euleriano() {
        return caminhoEuleriano().size() == numArestas();
    }

    /**
     * It returns a vertex if it exists in the graph
     * 
     * @param idVertice The id of the vertex to be searched for.
     * @return The method is returning the vertice that has the same id as the
     *         parameter.
     */
    public Vertice existeVertice(int idVertice) {
        return this.vertices.find(idVertice);
    }

    /*
     * Verificar de existe aresta
     */
    public boolean existeAresta(int verticeA, int verticeB) {
        var vertice = this.vertices.find(verticeA);
        if (vertice == null)
            return false;

        return vertice
                .getArestas()
                .find(verticeB) != null;
    }

    /**
     * Given a list of vertices, return a new graph that contains only those
     * vertices and the edges
     * between them.
     * 
     * @param vertices a list of vertices
     * @return A new graph with the name "Subgraph of" + the name of the graph.
     */
    public Grafo subGrafo(Lista<Vertice> vertices) {
        Grafo subgrafo = new Grafo("Subgrafo de " + this.nome);

        return subgrafo;
    }

    /*
     * Verificar o tamanho do grafo
     */
    public int tamanho() {
        return 0;
    }

    public int ordem() {
        return this.vertices.size();
    }

    /**
     * Adiciona, se possível, um vértice ao grafo. O vértice é auto-nomeado com o
     * próximo id disponível.
     */
    public boolean addVertice(int id) {
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo.
     * Não verifica se os vértices pertencem ao grafo.
     * 
     * @param origem  Vértice de origem
     * @param destino Vértice de destino
     */
    public boolean addAresta(int origem, int destino) {
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if (saida != null && chegada != null) {
            saida.addAresta(destino);
            chegada.addAresta(origem);
            adicionou = true;
        }

        return adicionou;
    }

    private void delAresta(Pair<Vertice, Vertice> adj) {
        adj.x.delAresta(adj.y.getId());
        adj.y.delAresta(adj.x.getId());
    }

    public void carregar(String nomeArquivo) throws FileNotFoundException {
        this.vertices.clear();
        FileInputStream stream = new FileInputStream(nomeArquivo);
        InputStreamReader reader = new InputStreamReader(stream);
        try (BufferedReader br = new BufferedReader(reader)) {
            var line = br.readLine();
            for (var item : line.split(" "))
                if (item.trim().length() > 0)
                    this.addVertice(Integer.parseInt(item) - 1);

            br.readLine();

            String linha = br.readLine();
            int i = 0;
            while (linha != null) {
                var valido = linha.split("\\| ")[0];
                int j = 0;

                for (var item : valido.split(" ")) {
                    if (item.equals("1"))
                        this.addAresta(i, j);

                    j++;
                }

                linha = br.readLine();
                i++;
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public void salvar(String nomeArquivo) {
        FileWriter arq;
        try {
            arq = new FileWriter(nomeArquivo);
            PrintWriter gravarArq = new PrintWriter(arq);
            for (int i = 1; i <= vertices.size(); i++)
                gravarArq.printf("%d ", i);

            gravarArq.println();

            for (int i = 1; i <= vertices.size(); i++)
                gravarArq.printf("--");

            gravarArq.printf("---\n");

            for (int i = 0; i < vertices.size(); i++) {
                for (int j = 0; j < vertices.size(); j++) {
                    var resultado = this.existeAresta(i, j) ? 1 : 0;
                    var space = j == vertices.size() - 1 ? String.format(" | %d", i + 1) : " ";
                    gravarArq.printf("%d%s", resultado, space);
                }
                gravarArq.println();
            }

            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Grafo clone() {
        var grafo = new Grafo(this.nome);
        for (var vertice : vertices) {
            int origem = vertice.getId();
            grafo.addVertice(origem);
            for (var aresta : vertice.getArestas())
                grafo.addAresta(origem, aresta.destino());
        }
        return grafo;
    }
}
