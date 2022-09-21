import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class DataTest {

    static Data data;
    static Data dataFixa;
    static Data dataNumDiaFixo;
    
    @BeforeAll
    static void init(){
        data = new Data();
    }

    @Test
    public void testeDiaSemanaComConstrutorValoresPorParametro(){

        dataFixa = new Data(22, 02, 2022);
        assertEquals("Terca-feira", dataFixa.DiaSemana(dataFixa.getDia(), dataFixa.getMes(), dataFixa.getAno()));
    }

    @Test
    public void testeDiaSemanaComConstrutorNumeroDiaPorParametro() {

        dataNumDiaFixo = new Data(738391);
        assertEquals("Quarta-feira", dataNumDiaFixo.DiaSemana(dataNumDiaFixo.getDia(), dataNumDiaFixo.getMes(), dataNumDiaFixo.getAno()));
    }

    @Test
    public void testeAnoBissexto() {

        assertEquals(1, data.verificaBissexto(2024));
    }

    @Test
    public void testeAnoNaoBissexto() {
        
        assertEquals(0, data.verificaBissexto(2023));
    }

    @Test
    public void testeDiasDoMes() {
        
        assertEquals(29, data.diasMes(2, 2024));   
    }

    @Test
    public void testeValorAcumuladoDeDiasAPartirDeUmaData() {
        
        assertEquals(738392, data.diaAno(25, 8, 2022));
    }

    @Test
    public void testeDataDeUmDiaAcumulado() {
        
        int[] dataPartida = data.dataDiaAno(738394);
        assertEquals("Sabado", dataNumDiaFixo.DiaSemana(dataPartida[0], dataPartida[1], dataPartida[2]));
    }

    @Test
    public void testeVerificaSePossuiApenasNumeros() {
        
        String[] valoresNmericos = {"14324","432423","954945"};

        assertEquals(true, data.verificaNumero(valoresNmericos));
    }

    @Test
    public void testeVerificaSePossuiApenasNumerosIncorreto() {
        
        String[] valoresTexto = {"14324","dasdas","!-@#%="};

        assertEquals(false, data.verificaNumero(valoresTexto));
    }

    @Test
    public void testeVerificaValoresPossiveisParaDatas() {
        
        assertEquals(true, data.verificaValores(30, 03, 2022));
    }

    @Test
    public void testeVerificaValoresPossiveisParaDatasIncorreto() {
        
        assertEquals(false, data.verificaValores(30, 02, 2022));
    }

    @Test
    public void testeVerificarData() {

        Data novaData = new Data();        
        novaData = data.verificaData("23/10/2022");

        assertEquals("Domingo", novaData.DiaSemana(novaData.getDia(), novaData.getMes(), novaData.getAno()));
    }
}