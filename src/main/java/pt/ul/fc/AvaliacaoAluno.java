package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Avaliar um aluno. */
@StateSet({"inscrito", "entregue", "avaliado", "publicado", "desistente"})
public class AvaliacaoAluno {

    @StateRefinement(to="inscrito()")
    public AvaliacaoAluno() {}

    /** O aluno entrega o trabalho. */
    @StateRefinement(from="inscrito()", to="entregue()")
    public void entregar() {}

    /** Publica a nota (definitivo). */
    @StateRefinement(from="avaliado()", to="publicado()")
    public void publicar() {}

    /** O aluno desiste da avaliação (definitivo). */
    @StateRefinement(from="inscrito() || entregue()", to="desistente()")
    public void desistir() {}

    /** O aluno pede revisão da nota; o trabalho volta a ser avaliado. */
    @StateRefinement(from="avaliado()", to="entregue()")
    public void pedirRevisao() {}

    /** O docente atribui a nota ao trabalho entregue. */
    @StateRefinement(from="entregue()", to="avaliado()")
    public void avaliar() {}
}
