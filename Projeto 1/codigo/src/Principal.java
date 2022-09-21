import java.util.Scanner;

public class Principal {

	static String excecao = "";
	public static Agenda agenda = new Agenda();

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		Scanner obj = new Scanner(System.in);

		System.out.println("\nAGENDA COMPROMISSOS\n");

		System.out.println("1 - Criar compromisso em datas especificas.");
		System.out.println("2 - Cadastrar compromissos periodicos:");
		System.out.println("3 - Fornecer relatorio de compromissos entre datas.");
		System.out.println("Entre com o numero correspondente a funcao da Agenda: ou f para sair:");
		System.out.println("\n");
		opcoes(obj.nextLine());
		obj.close();
	}

	public static void opcoes(String opcao) {
		Scanner obj = new Scanner(System.in);
		Data dtValida = new Data();
		String assuntoTemp = null;
		int recorre = 0;
		int interval = 0;
		switch (opcao) {

			case "1":
				System.out.println("Criar Compromisso:");
				System.out.println("Entre com uma data no formato DD/MM/AAAA: ");
				dtValida = Data.verificaData(obj.nextLine());

				if (dtValida.getDataValida() == true) {

					System.out.println("Entre com um assunto para compromisso nessa data");
					assuntoTemp = obj.nextLine();

					agenda.setAgenda(Compromisso.criaLoteCompromissos(dtValida.getDiaAno(), assuntoTemp, 1, 0));

					for (int i = 0; i < agenda.getquantCompromissosAgendados(); i++) {
						if (agenda.getAgenda().get(i).getnDia() == dtValida.getDiaAno()) {
							System.out.print("Compromisso:");
							imprimeCompromisso(agenda.getAgenda().get(i));
						}

					}
				} else {
					System.out.println(excecao);
					System.out.println("Digite 'Enter' para continuar...\n");
					opcoes(obj.nextLine());
				}
				menu();
				break;

			case "2":
				System.out.println("Criar Compromisso:");
				System.out.println("Entre com uma data no formato DD/MM/AAAA: ");
				dtValida = Data.verificaData(obj.nextLine());

				if (dtValida.getDataValida() == true) {
					
					System.out.println("Entre com um assunto para compromisso nessa data");
					assuntoTemp = obj.nextLine();
					System.out.println("Entre com quantidade de recorr�ncias do compromisso: ");
					recorre = Integer.parseInt(obj.nextLine());
					System.out.println("Entre com o intervalo de dias entre as ocorrencias");
					interval = Integer.parseInt(obj.nextLine());

					agenda.setAgenda(Compromisso.criaLoteCompromissos(dtValida.getDiaAno(), assuntoTemp, recorre, interval));
					for (Compromisso comp : agenda.getAgenda()) {
						if (comp.getnDia() == dtValida.getDiaAno()) {
							System.out.print("Compromisso:");
							imprimeCompromisso(comp);
						}
					}

				} else {
					System.out.println(excecao);
					System.out.println("Digite 'Enter' para continuar...\n");
					opcoes(obj.nextLine());
				}
				menu();
				break;
			case "3":
				System.out.println("Fornecer relatorio de compromissos entre datas:");
				Data dtInicial = new Data();
				Data dtFinal = new Data();
				System.out.println("Entre com data inicial no formato DD/MM/AAAA: ");
				dtInicial = Data.verificaData(obj.nextLine());
				System.out.println("Entre com data final no formato DD/MM/AAAA: ");
				dtFinal = Data.verificaData(obj.nextLine());

				if (dtInicial.getDataValida() && dtFinal.getDataValida()
						&& dtInicial.getDiaAno() < dtFinal.getDiaAno()) {
					for (Compromisso comp : agenda.getAgenda()) {
						if (comp.getnDia() >= dtInicial.getDiaAno() && comp.getnDia() <= dtFinal.getDiaAno()) {
							imprimeCompromisso(comp);
						} else {
							System.out.println(excecao);
							System.out.println("Digite 'Enter' para continuar...\n");
							opcoes(obj.nextLine());
						}
					}
				}
				menu();
				break;

			default:
				System.out.println("opcao invalida!");
				menu();
		}
		obj.close();
	}

	public static void imprimeCompromisso(Compromisso atual) {

		Data dt = new Data(atual.getnDia());
		String dtFormat = String.format("%02d", dt.getDia()) + "/" + String.format("%02d", dt.getMes()) + "/"
				+ String.format("%4d", dt.getAno());
		System.out.print("Dia: " + atual.getnDia() + " - " + dtFormat + " - " + dt.getDiaSemana());
		System.out.println(" Assunto " + atual.getAssunto());

	}

}