import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CompromissoTest {

    static Compromisso compromisso = new Compromisso(738391, "Testando compromisso");
    
    @Test
    public void testeConstrutorComParametro(){

        assertEquals("Testando compromisso", compromisso.getAssunto());
    }


    @Test
    public void testecriarCompromissosEmLote(){

        Compromisso compromissoSimples = new Compromisso();
        Compromisso[] recorrenciaCompromissos = compromissoSimples.criaLoteCompromissos(738393, "Teste criando compromisso em lote", 3, 7);

        assertEquals("2/3_Teste criando compromisso em lote", recorrenciaCompromissos[1].getAssunto());
    }
}
