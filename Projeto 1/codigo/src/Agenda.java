import java.util.ArrayList;

public class Agenda {

	private ArrayList<Compromisso> agenda = new ArrayList<Compromisso>();
	private int quantCompromissosAgendados = 0;

	/**
	 * Construtor simples para criação de um objeto da classe Agenda
	 */
	public Agenda() {

	}

	public ArrayList<Compromisso> getAgenda() {
		return agenda;
	}

	/**
	 * Método popula a agenda com o arraylist de compromissos informados por parâmetro. 
	 * @param compromissos Arraylist de compromissos da classe Compromisso
	 */

	public void setAgenda(Compromisso[] compromissos) {
		for (Compromisso comp : compromissos) {
			this.quantCompromissosAgendados++;
			this.agenda.add(comp);
		}
		
	}

	public int getquantCompromissosAgendados() {
		return quantCompromissosAgendados;
	}

	public void setquantCompromissosAgendados(int quantCompromissosAgendados) {
		this.quantCompromissosAgendados = quantCompromissosAgendados;
	}

}