import java.util.*;

public class ProgramaCidades {
    public static void main(String[] args) {
        // Criação das cidades (marcando as capitais como true)
        List<Cidade> cidades = Arrays.asList(
                new Cidade("Anápolis", "GO", false),
                new Cidade("Goiânia", "GO", true),
                new Cidade("Ribeirão Preto", "SP", false),
                new Cidade("Campinas", "SP", false),
                new Cidade("Belo Horizonte", "MG", true),
                new Cidade("Uberlândia", "MG", false),
                new Cidade("Montes Claros", "MG", false),
                new Cidade("Unaí", "MG", false),
                new Cidade("Palmas", "TO", true),
                new Cidade("Araguarí", "TO", false),
                new Cidade("Cuiabá", "MT", true),
                new Cidade("Dourados", "MS", false),
                new Cidade("Campo Grande", "MS", true),
                new Cidade("Corumbá", "MS", false),
                new Cidade("Barra do Garças", "MT", false),
                new Cidade("Araguaiana", "MT", false),
                new Cidade("Porto Velho", "RO", true),
                new Cidade("Costa Marques", "RO", false)
        );

        // Estrutura 1: TreeMap para garantir UFs únicas e ordenação
        Map<String, Set<Cidade>> cidadesPorUF = new TreeMap<>();

        for (Cidade cidade : cidades) {
            cidadesPorUF.computeIfAbsent(cidade.getUf(), k -> new TreeSet<>(
                    Comparator.comparing(Cidade::getNome)
            )).add(cidade);
        }

        System.out.println("\n=== Estrutura 1: Cidades agrupadas por UF (ordem alfabética) ===");
        cidadesPorUF.forEach((uf, conjunto) -> {
            System.out.println("\nUF: " + uf);
            conjunto.forEach(cidade -> System.out.println("  " + cidade.getNome()));
        });

        // Estrutura 2: Ordenação por capital e nome
        System.out.println("\n=== Estrutura 2: Cidades ordenadas por capital e nome ===");
        List<Cidade> cidadesOrdenadas = new ArrayList<>(cidades);
        cidadesOrdenadas.sort((c1, c2) -> {
            if (c1.isCapital() != c2.isCapital()) {
                return c2.isCapital() ? 1 : -1;
            }
            return c1.getNome().compareTo(c2.getNome());
        });

        cidadesOrdenadas.forEach(System.out::println);

        // Estrutura 3: TreeSet com ordenação decrescente
        System.out.println("\n=== Estrutura 3: Cidades em ordem alfabética decrescente ===");
        TreeSet<Cidade> cidadesDecrescente = new TreeSet<>((c1, c2) ->
                c2.getNome().compareTo(c1.getNome())
        );
        cidadesDecrescente.addAll(cidades);

        cidadesDecrescente.forEach(cidade ->
                System.out.println(cidade.getNome() + " - " + cidade.getUf())
        );
    }
}