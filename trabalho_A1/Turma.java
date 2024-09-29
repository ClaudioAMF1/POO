package trabalho_A1;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Professor professor;
    private Disciplina disciplina;
    private List<Aluno> alunos;

    public Turma(Professor professor, Disciplina disciplina) {
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = new ArrayList<>();
    }

    // Adicionar alunos à turma
    public void adicionarAluno(Aluno aluno) {
        if (aluno.getCurso().equals(disciplina.getCurso())) {
            alunos.add(aluno);
        }
    }

    // Exibir informações da turma
    public void mostrarInformacoes() {
        System.out.println("Turma de " + disciplina.getNome());
        System.out.println("Professor: " + professor.getNome());
        System.out.println("Alunos matriculados:");
        for (Aluno aluno : alunos) {
            System.out.println(" - " + aluno.getNome());
        }
        System.out.println();
    }
}
