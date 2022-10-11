public class PlacaInvalidaException extends IllegalArgumentException{
    private final String placa;

    public PlacaInvalidaException(String placa){
        super();
        this.placa = placa;
    }

    public String getPlaca(){

        return this.placa;
    }

}
