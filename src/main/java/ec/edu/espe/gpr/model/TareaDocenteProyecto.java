package ec.edu.espe.gpr.model;

import java.util.List;

public class TareaDocenteProyecto {
    private Tarea tarea;
    private List<TareaDocente> tareaDocente;
    private List<Indicador> indicadors;
        
    public TareaDocenteProyecto() {
    }

    public TareaDocenteProyecto(Tarea tarea, List<TareaDocente> tareaDocente, List<Indicador> indicadors) {
        this.tarea = tarea;
        this.tareaDocente = tareaDocente;
        this.indicadors = indicadors;
    }

    public Tarea getTarea() {
        return tarea;
    }
    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
    public List<TareaDocente> getTareaDocente() {
        return tareaDocente;
    }
    public void setTareaDocente(List<TareaDocente> tareaDocente) {
        this.tareaDocente = tareaDocente;
    }
    public List<Indicador> getIndicadors() {
        return indicadors;
    }
    public void setIndicadors(List<Indicador> indicadors) {
        this.indicadors = indicadors;
    }

}
