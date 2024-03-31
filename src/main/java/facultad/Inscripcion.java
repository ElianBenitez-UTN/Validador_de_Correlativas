package facultad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Inscripcion {
    private List<Materia> materias;
    private Alumno alumno;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materias = new ArrayList<>();
    }

    public void agregarMaterias(Materia ... materias) {
        Collections.addAll(this.materias, materias);
    }

    public Boolean aprobada() {
        return verificoCorrelativas();
    }

    public List<Materia> obtengoCorrelativas() {
        return materias.stream().
                flatMap(materia -> materia.correlativas().stream())
                .collect(Collectors.toList());
    }

    public List<Materia> materiasAprobadasAlumno() {
        return alumno.materiasAprobadas;
    }

    public Boolean verificoCorrelativas() {
        return obtengoCorrelativas().stream().allMatch(this::estaAprobada);
    }

    public Boolean estaAprobada(Materia materia) {
        return materiasAprobadasAlumno().contains(materia);
    }
}
