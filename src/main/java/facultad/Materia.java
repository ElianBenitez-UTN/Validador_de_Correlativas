package facultad;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;

    private List<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }
}
