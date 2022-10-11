
public class BuscaProfundidade {
	public static final byte branco = 0;
	public static byte cinza = 1;
	public static byte preto = 2;
	private int d[], t[], antecessor[];
	private String saida;
	private Grafo grafo;

	public BuscaProfundidade(Grafo g) {
		this.grafo = g;
		int n = grafo.ordem();
		d = new int[n];
		t = new int[n];
		antecessor = new int[n];
		saida = "";
	}

	/**
	 * Metodo auxiliar da busca em profundidade.
	 * 
	 * @param u
	 * @param tempo
	 * @param cor
	 * @return
	 */
	private int visitaDfs(int u, int tempo, int cor[]) {
		System.out.println(" Visitando o vertice: " + u);
		saida += u + ", "; // Armazena a ordem de visita dos vertices em uma string
		cor[u] = cinza;
		this.d[u] = ++tempo;
		if (grafo.vertices.size() > 0) {
			// List<Integer> listaAdj = grafo.vertices[u];
			// for (Integer v : listaAdj) {
			// if (cor[v] == branco) {
			// this.antecessor[v] = u;
			// tempo = this.visitaDfs(v, tempo, cor);
			// }
			// }
		}
		cor[u] = preto;
		this.t[u] = ++tempo;
		return tempo;
	}

	/**
	 * Metodo que realiza a busca em profundidade propriamente dita.
	 */
	public void buscaProfundidade() {
		int tempo = 0;
		int cor[] = new int[this.grafo.ordem()];
		for (int u = 0; u < this.grafo.ordem(); u++) {
			cor[u] = branco;
			this.antecessor[u] = -1;
		}
		for (int u = 0; u < grafo.ordem(); u++) {
			if (cor[u] == branco)
				tempo = this.visitaDfs(u, tempo, cor);
		}
		System.out.print("\n Ordem de visita: ");
		System.out.println(saida.substring(0, saida.lastIndexOf(",")));
		System.out.print("\n");
	}
}