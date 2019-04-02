Feature: CN03-Criar Agendamento
  O cidadão que já esteja cadastrado em uma UBS e que tenha aderido ao sistema de agendamento, está apto para realizar
  agendamentos de consultas e exames.
  Para criar um novo agendamento basta clicar no botão com sinal de + e seguir os passos na tela.

  Scenario Outline: <TestCaseName>
    Given Que o usuário esteja logado com CNS <Login> e senha <Senha>
    When Efetuar um agendamento do tipo <TipoAgendamento>
    Then É apresentanda a mensagem <mensagem>
    And O agendamento é exibido na tela Agenda Ativa
    Examples:
      |TestCaseName                                                                            |Login          |Senha |TipoAgendamento  |mensagem                          |
      |TC01 - AgendamentoTriagemSaudeBucal_QdoEfetuarAgendamento_AgendamentoEfetuadoComSucesso |707706689085010|123456|TriagemSaudeBucal|Agendamento realizado com sucesso!|
      |TC02 - AgendamentoEquipeSaudeFamilia_QdoEfetuarAgendamento_AgendamentoEfetuadoComSucesso|707706689085010|123456|SaudeDaFamilia   |Agendamento realizado com sucesso!|