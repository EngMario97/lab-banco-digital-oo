public class Main {

    public static void main(String[] args) {
        final String SEPARATOR = "=====================================================";

        Cliente mario = new ClientePessoaFisica("Mario");
        Cliente luidi = new ClientePessoaJuridica("Luidi");

        Banco bancoBB = new Banco(1,"Banco do Brasil");

        Agencia agenciaSP = new Agencia(bancoBB);
        agenciaSP.setNome("São Paulo");
        Agencia agenciaRJ = new Agencia(bancoBB,"Rio de Janeiro");

        Conta cc = new ContaCorrente(agenciaSP, mario);
        Conta poupanca = new ContaPoupanca(agenciaSP, mario);

        cc.trocarTitularidade(luidi);
        System.out.println(" ");

        cc.trocarAgencia(agenciaRJ);
        System.out.println(" ");

        cc.depositar(1500);
        cc.transferirValor(200, poupanca);

        cc.imprimirExtrato();
        System.out.println(" ");

        poupanca.imprimirExtrato();

        System.out.println(" ");
        System.out.println(SEPARATOR);
        System.out.printf("Lista de Agências do Banco: %s\n",bancoBB.getNome());
        for (Agencia agencia : bancoBB.getAgencias()){
            System.out.println(agencia);
        }
        System.out.println(SEPARATOR);
        System.out.println(" ");
        System.out.println(SEPARATOR);
        System.out.printf("Lista de Contas da Agência: %s\n",agenciaSP.getNome());
        for (Conta conta : agenciaSP.getContas()){
            System.out.println(conta);
        }
        System.out.println(SEPARATOR);
        System.out.println(" ");
        System.out.println(SEPARATOR);
        System.out.printf("Lista de Contas da Agência: %s\n",agenciaRJ.getNome());
        for (Conta conta : agenciaRJ.getContas()){
            System.out.println(conta);
        }
        System.out.println(SEPARATOR);
    }

}