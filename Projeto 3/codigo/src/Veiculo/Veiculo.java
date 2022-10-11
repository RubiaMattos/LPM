package Veiculo;

import java.util.regex.Pattern;

public abstract class Veiculo {

    private int tanque;
    private double ipva;
    private double seguro;
    private double autonomiaDiaria;
    private String placa;

    /**
     * Construtor. Lança exceção se a placa não coincidir com o padrão
     * @param placa Placa no padrão Mercosul/Brasil: AAA0A00
     * @throws PlacaInvalidaException Em caso de placa fora do padrão
     */
    public Veiculo(int tanque, double ipva, double seguro, double autonomiaDiaria, String placa) throws PlacaInvalidaException {
        if (!Pattern.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}", placa))
            throw new PlacaInvalidaException(placa);
        this.placa = placa;
    }

}

