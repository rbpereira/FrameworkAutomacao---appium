Feature: CN07-Sair do sistema - Logoff
  Dado que o cidadão esteja logado no aplicativo, quando ele clicar no menu sair o sistema encerra a sessão daquele usuário, retornando
  para tela de login.

  Scenario Outline: <TestCaseName>
    Given Que o usuário esteja logado com CNS <Login> e senha <Senha>
    When Clicar no menu Sair
    Then O sistema retorna para tela inicial
    Examples:
    |TestCaseName                                               |Login          |Senha |
    |TC01 - sairDoSistema_QdoAcionarMenuSair_UsuarioSaiDoSistema|707706689085010|123456|