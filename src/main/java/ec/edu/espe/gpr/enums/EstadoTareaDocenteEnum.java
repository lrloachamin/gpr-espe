package ec.edu.espe.gpr.enums;

public enum EstadoTareaDocenteEnum {
    ACTIVE("INICIADA", "Iniciada"),
    INACTIVE("FINALIZADA", "Finalizado");

    private final String value;
    private final String text;

    private EstadoTareaDocenteEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public String getValue() {
        return this.value;
    }
}
