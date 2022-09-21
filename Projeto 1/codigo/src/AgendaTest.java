import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AgendaTest {

    @Test
    public void testePopularCompromissosNaAgenda() {

        Compromisso compromissoSimples = new Compromisso();
        Compromisso[] recorrenciaCompromissos = compromissoSimples.criaLoteCompromissos(738393, "Teste criando compromisso em lote", 3, 7);
        Agenda agenda = new Agenda();

        agenda.setAgenda(recorrenciaCompromissos);

        assertEquals(3, agenda.getquantCompromissosAgendados());

        
    }
}