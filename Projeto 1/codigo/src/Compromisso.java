
public class Compromisso {

	private int nDia;
	private String assunto;

	/**
	 * Construtor simples para criação de um objeto da classe Compromisso
	 */

	public Compromisso() {
	}

	/**
	 * Construtor da classe Compromisso para criação de um objeto com número do dia e assunto
	 * 
	 * @param ndia Inteiro referente ao dia incrementado a partir do dia 01/01/0001
	 * @param assunto Assunto que descreve o compromisso
	 */

	public Compromisso(int ndia, String assunto) {
		
		this.nDia = ndia;
		this.assunto = assunto;
	}

	/**
	 * Método para a criação de uma sequência de compromissos, através dos parâmetros requiridos, retorna um array de compromissos
	 * 
	 * @param ndia Inteiro referente ao dia incrementado a partir do dia 01/01/0001
	 * @param assunto Assunto que descreve o compromisso
	 * @param recorrente Número de ocorrências/repetições do compromisso
	 * @param intevalo Intervalo de dias entre as repetições
	 * @return Array de compromissos
	 */
	public static Compromisso[] criaLoteCompromissos(int ndia, String assunto, int recorrente, int intevalo) {
		
		Compromisso[] LoteCompromissos = new Compromisso[recorrente];
		
		for (int i = 0; i < recorrente; i++) {
			LoteCompromissos[i] = new Compromisso(ndia + (i * intevalo), i + 1 + "/" + recorrente + "_" + assunto); //
		}
		return LoteCompromissos;
	}



	public int getnDia() {
		return nDia;
	}

	public void setnDia(int ndia) {
		this.nDia = ndia;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

}