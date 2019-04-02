Feature: CN01-Primeiro acesso - Adesão
  O cidadão que deseja usar o aplicativo AGENDA FACIL em seu aparelho móvel para agendar, confirmar e cancelar consultas
  e exames, primeiro precisa solicitar um código de acesso em alguma UBS do municipio de residencia.
  Com o código de acesso em mãos o próximo passo é realizar o cadastrado/Adesão através do botão PRIMEIRO ACESSO,
  basta clicar neste botão e preencher os dados solicitados.

  Scenario Outline: <TestCaseName>
    Given Que o aplicativo esteja aberto na pagina primeiro acesso
    When Informar CPF/CNS <cpf_cns> e data de nascimento <dataNascimento>
    And  Clicar no botão Enviar
    Then É apresentanda a mensagem <mensagem>
    Examples:
   |TestCaseName                                                                             |cpf_cns           |dataNascimento |mensagem                                                                 |
   |TC01 - CadastroDeSenha_QdoInformarCNSInvalido_ExibirMensagemDeValidacao                  |152992195720000678|16/set/1979    |CNS Preenchido não é válido!                                             |
   |TC02 - CadastroDeSenha_QdoInformarDataNascimentoInvalida_ExibirMensagemDeValidacao       |706506370214697   |16/set/1980    |Paciente não encontrado É necessário se cadastrar em uma UBS mais próxima|
   |TC03 - CadastroDeSenha_QdoInformarDataNascimentoMaiorDataAtual_ExibirMensagemDeValidacao |706506370214697   |faker          |Favor preencher os campos corretamente.                                  |
   |TC04 - CadastroDeSenha_QdoInformarCNSCadastrado_ExibirMensagemDeValidacao                |707009888406932   |16/set/1979    |Usuário já esta cadastrado com esse CNS no município                     |
   |TC05 - CadastroDeSenha_QdoInformarCNSQueNaoTemEquipeCadastrada_ExibirMensagemDeValidacao |152992195720000   |16/set/1979    |CNS Invalido                                                             |
   |TC06 - CadastroDeSenha_QdoNaoInformarCNSDataNascimento_ExibirMensagemDeValidacao         |                  |               |Favor preencher os campos corretamente.                                  |


  Scenario Outline: <TestCaseName>
    Given Que o aplicativo esteja aberto na pagina primeiro acesso
    When Informar CPF/CNS <cns> e data de nascimento <dataNascimento>
    And  Clicar no botão Enviar
    And  Informar os dados cpf <cpf>, Nome completo <NomeCompleto>, nome da mae <NomeMae>, telefone <Telefone>, email <Email>, confirme email <ConfirmeEmail>, senha <Senha> e confirmar senha <ConfirmarSenha>
    And  Clicar no botão Cadastrar
    Then É apresentanda a mensagem <mensagem>
    Examples:
    |TestCaseName                                                                                   |cns            |dataNascimento |cpf                    |NomeCompleto           |NomeMae                |Telefone   |Email              |ConfirmeEmail      |Senha |ConfirmarSenha|mensagem                               |
    |TC07 - CadastroDeSenha_QdoInformarTelefoneInvalido_ExibirMensagemDeValidacao                   |700006115148809|04/out/2002    |geraDocumento.geraCPF()|faker.name().fullName()|faker.name().fullName()|11215625369|automacao@teste.com|automacao@teste.com|123456|123456        |Favor preencher os campos corretamente.|
    |TC08 - CadastroDeSenha_QdoInformarEmailInvalido_ExibirMensagemDeValidacao                      |700006115148809|04/out/2002    |geraDocumento.geraCPF()|faker.name().fullName()|faker.name().fullName()|11993942300|automacao.teste.com|automacao@teste.com|123456|123456        |Favor preencher os campos corretamente.|
    |TC09 - CadastroDeSenha_QdoInformarConfirmeSeuEmailInvalido_ExibirMensagemDeValidacao           |700006115148809|04/out/2002    |geraDocumento.geraCPF()|faker.name().fullName()|faker.name().fullName()|11993942300|automacao@teste.com|automacao.teste.com|123456|123456        |Favor preencher os campos corretamente.|
    |TC10 - CadastroDeSenha_QdoInformarEmailEConfirmeSeuEmailDiferente_ExibirMensagemDeValidacao    |700006115148809|04/out/2002    |geraDocumento.geraCPF()|faker.name().fullName()|faker.name().fullName()|11993942300|automacao@teste.com|auto@teste.com     |123456|123456        |Favor preencher os campos corretamente.|
    |TC11 - CadastroDeSenha_QdoInformarConfirmacaoDaSenhaDiferenteDaSenha_ExibirMensagemDeValidacao |700006115148809|04/out/2002    |geraDocumento.geraCPF()|faker.name().fullName()|faker.name().fullName()|11993942300|automacao@teste.com|automacao@teste.com|123456|1234567       |Favor preencher os campos corretamente.|
    |TC12 - CadastroDeSenha_QdoInformarCPFCadastradoAnteriomente_ExibirMensagemDeValidacao          |700006115148809|04/out/2002    |96404187906            |faker.name().fullName()|faker.name().fullName()|11993942300|automacao@teste.com|automacao@teste.com|123456|123456        |Favor preencher os campos corretamente.|
    #|TC13 - CadastroDeSenha_QdoInformarDadosValidos_CadastroRelizado                                |898004846351353|31/mai/1993    |geraDocumento.geraCPF()|faker.name().fullName()|faker.name().fullName()|11993942300|automacao@teste.com|automacao@teste.com|123456|123456        |Adesão concluída com sucesso!          |