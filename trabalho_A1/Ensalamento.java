package trabalho_A1;

import java.util.ArrayList;
import java.util.List;

public class Ensalamento {
    private List<Curso> cursos;
    private List<Professor> professores;
    private List<Aluno> alunos;
    private List<Turma> turmas;

    public Ensalamento() {
        this.cursos = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.turmas = new ArrayList<>();
    }

    // Método para realizar o ensalamento
    public void executarEnsalamento() {
        criarCursosEDisciplinas();
        criarProfessores();
        criarAlunos();
        criarTurmas();
        alocarAlunosNasTurmas();
        mostrarInformacoesTurmas();
    }

    private void criarCursosEDisciplinas() {
        // Criando cursos
        Curso cursoTI = new Curso("TI");
        Curso cursoADM = new Curso("ADM");

        // Criando disciplinas
        Disciplina poo = new Disciplina("POO", cursoTI);
        Disciplina estruturaDados = new Disciplina("Estrutura de Dados", cursoTI);
        Disciplina bi = new Disciplina("BI", cursoADM);

        // Adicionando disciplinas aos cursos
        cursoTI.adicionarDisciplina(poo);
        cursoTI.adicionarDisciplina(estruturaDados);
        cursoADM.adicionarDisciplina(bi);

        // Adicionando cursos à lista
        cursos.add(cursoTI);
        cursos.add(cursoADM);
    }

    private void criarProfessores() {
        // Associando disciplinas aos professores
        Professor profMia = new Professor("Mia", new Disciplina("POO", buscarCursoPorNome("TI")));
        Professor profSaulo = new Professor("Saulo", new Disciplina("Estrutura de Dados", buscarCursoPorNome("TI")));
        Professor profPaula = new Professor("Paula", new Disciplina("BI", buscarCursoPorNome("ADM")));

        // Adicionando professores à lista
        professores.add(profMia);
        professores.add(profSaulo);
        professores.add(profPaula);
    }

    private void criarAlunos() {
        // Criando alunos e associando aos cursos
        alunos.add(new Aluno("Alfredo", buscarCursoPorNome("TI")));
        alunos.add(new Aluno("Amélia", buscarCursoPorNome("TI")));
        alunos.add(new Aluno("Ana", buscarCursoPorNome("ADM")));
        alunos.add(new Aluno("Bruno", buscarCursoPorNome("TI")));
        alunos.add(new Aluno("Bentinho", buscarCursoPorNome("ADM")));
        alunos.add(new Aluno("Capitú", buscarCursoPorNome("TI")));
        alunos.add(new Aluno("Debra", buscarCursoPorNome("TI")));
        alunos.add(new Aluno("Ian", buscarCursoPorNome("ADM")));
        alunos.add(new Aluno("Iracema", buscarCursoPorNome("TI")));
        alunos.add(new Aluno("Joelmir", buscarCursoPorNome("ADM")));
        alunos.add(new Aluno("Julieta", buscarCursoPorNome("TI")));
        alunos.add(new Aluno("Luana", buscarCursoPorNome("ADM")));
        alunos.add(new Aluno("Luciana", buscarCursoPorNome("TI")));
        alunos.add(new Aluno("Majô", buscarCursoPorNome("ADM")));
        alunos.add(new Aluno("Maria", buscarCursoPorNome("ADM")));
        alunos.add(new Aluno("Norberto", buscarCursoPorNome("TI")));
        alunos.add(new Aluno("Paulo", buscarCursoPorNome("ADM")));
        alunos.add(new Aluno("Romeu", buscarCursoPorNome("ADM")));
        alunos.add(new Aluno("Wendel", buscarCursoPorNome("TI")));
        alunos.add(new Aluno("Zoey", buscarCursoPorNome("TI")));
    }

    private void criarTurmas() {
        // Criando turmas associando professores e disciplinas
        turmas.add(new Turma(buscarProfessorPorNome("Mia"), buscarDisciplinaPorNome("POO")));
        turmas.add(new Turma(buscarProfessorPorNome("Saulo"), buscarDisciplinaPorNome("Estrutura de Dados")));
        turmas.add(new Turma(buscarProfessorPorNome("Paula"), buscarDisciplinaPorNome("BI")));
    }

    private void alocarAlunosNasTurmas() {
        // Alocando alunos nas turmas
        for (Aluno aluno : alunos) {
            for (Turma turma : turmas) {
                turma.adicionarAluno(aluno);
            }
        }
    }

    private void mostrarInformacoesTurmas() {
        // Exibindo informações das turmas
        for (Turma turma : turmas) {
            turma.mostrarInformacoes();
        }
    }

    // Métodos utilitários para buscar cursos, professores e disciplinas
    private Curso buscarCursoPorNome(String nome) {
        for (Curso curso : cursos) {
            if (curso.getNome().equals(nome)) {
                return curso;
            }
        }
        return null;
    }

    private Professor buscarProfessorPorNome(String nome) {
        for (Professor professor : professores) {
            if (professor.getNome().equals(nome)) {
                return professor;
            }
        }
        return null;
    }

    private Disciplina buscarDisciplinaPorNome(String nome) {
        for (Curso curso : cursos) {
            for (Disciplina disciplina : curso.getDisciplinas()) {
                if (disciplina.getNome().equals(nome)) {
                    return disciplina;
                }
            }
        }
        return null;
    }
}
