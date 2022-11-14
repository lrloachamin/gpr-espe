package ec.edu.espe.gpr.model;

public class TareaDocenteProyecto {
    
    private TareaDocente tareaDocente;
    private Tarea tarea;

    public TareaDocenteProyecto() {
    }
    
    public TareaDocenteProyecto(TareaDocente tareaDocente, Tarea tarea) {
        this.tareaDocente = tareaDocente;
        this.tarea = tarea;
    }
    public TareaDocente getTareaDocente() {
        return tareaDocente;
    }
    public void setTareaDocente(TareaDocente tareaDocente) {
        this.tareaDocente = tareaDocente;
    }
    public Tarea getTarea() {
        return tarea;
    }
    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
    
}
