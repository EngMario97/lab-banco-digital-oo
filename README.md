# Criando um Banco Digital com Java e Orientação a Objetos

## Digital Innovation One
### Bootcamps "TQI Fullstack Developer"

Projeto desenvolvido com instruções de [Venilton FalvoJr](https://github.com/falvojr) da [dio.me](https://dio.me/).

Link da base utilizada neste projeto: [falvojr/lab-banco-digital-oo](https://github.com/falvojr/lab-banco-digital-oo)

Abaixo seguem modificações feitas em relação ao projeto base:
* Foi criada a classe `Agencia` visto que um banco pode ter mais de uma agência;
* Foi criado método para permitir trocar o vínculo da agência das contas;
* A classe `Cliente` original foi modificada para abstrata para ser extendida em `ClientePessoaFisica` e `ClientePessoaJuridica`;
* Mudanças na classe `Main` para adaptar as mudanças realizadas.

Versões utilizadas no desenvolvimento:
* Java 11;
* IntelliJ IDEA Community Edition 2022
