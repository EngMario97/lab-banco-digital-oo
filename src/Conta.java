public abstract class Conta implements IConta {

    private static int SEQUENCIAL = 1;

    protected Agencia agencia;
    protected final int numero;
    protected double saldo;
    protected Cliente cliente;


    public Conta(Agencia agencia, Cliente cliente) {
        this.agencia = agencia;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        agencia.adicionaConta(this);
    }

    public void trocarAgencia(Agencia novaAgencia) {
        Agencia agenciaAntiga = this.agencia;
        this.agencia = novaAgencia;
        novaAgencia.adicionaConta(this);
        agenciaAntiga.removeConta(this);
        System.out.printf("=============== ATENÇÃO ================\n" +
                        "A conta %d teve sua agência alterada:\n" +
                        "De %s, foi para %s.\n" +
                        "========================================\n",
                getNumero(), agenciaAntiga.getNome(), this.agencia.getNome()
        );
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferirValor(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void trocarTitularidade(Cliente novoCliente) {
        Cliente clienteAntigo = this.cliente;
        this.cliente = novoCliente;
        System.out.printf("============ ATENÇÃO =============\n" +
                        "A titularidade da conta %d mudou:\n" +
                        "De %s, foi para %s.\n" +
                        "==================================\n"
                ,getNumero(),clienteAntigo.getNome(), cliente.getNome()
        );
    }

    public String getNomeAgencia() {
        return this.agencia.getNome();
    }

    public int getNumero() {
        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.printf("%s \n" +
                        "Titular: %s \n" +
                        "Número: %d -- %s \n" +
                        "Saldo: %.2f\n"
                ,agencia.getBanco(), this.cliente.getNome(), this.numero, agencia, this.saldo);
    }

    @Override
    public String toString() {
        return String.format("Número: %d- Saldo atual: %.2f"
                ,getNumero(), getSaldo()
        );
    }
}
