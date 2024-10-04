import java.util.ArrayList;
import java.util.List;

public class PessoaService {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();
    private Gerente gerente;

    private static final int MAX_FUNCIONARIOS = 7;
    private static final int MAX_GERENTE = 1;

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente); // Não há limite para clientes
    }

    public void cadastrarClienteVip(ClienteVip clienteVip) {
        clientes.add(clienteVip);  // Clientes VIP são adicionados à lista de clientes
    }    

    public void cadastrarFuncionario(Funcionario funcionario) throws QuantidadeExcedidaException {
        if (funcionarios.size() >= MAX_FUNCIONARIOS) {
            throw new QuantidadeExcedidaException("Quantidade de funcionários excedida. Limite é " + MAX_FUNCIONARIOS + " funcionários.");
        }
        funcionarios.add(funcionario);
    }

    public void cadastrarGerente(Gerente novoGerente) throws QuantidadeExcedidaException {
        if (gerente != null) {
            throw new QuantidadeExcedidaException("Já existe um gerente cadastrado. Apenas um gerente é permitido.");
        }
        gerente = novoGerente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public Gerente getGerente() {
        return gerente;
    }
}
