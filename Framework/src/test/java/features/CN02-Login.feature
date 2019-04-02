Feature:  CN02-Login - Controle de acesso
  Como usuário quero acessar o sistema informando login e senha
  Se informar login e senha corretos e direcionado para tela de agenda ativa
  Se informar login ou senha incorreto é apresentado mensagem de validação de login

  Scenario Outline: <TestCaseName>
    Given Que o aplicativo esteja aberto na pagina de login
    When Informar CPF/CNS <cpf_cns> e Senha <senha>
    And Clicar no botão Acessar
    Then É exibida a mensagem <mensagem> ou entra no sistema
    Examples:
    |TestCaseName                                                                               |cpf_cns        |senha  |mensagem                                                                                      |
    |TC01 - login_QdoInformarCPFValido_LoginOK                                                  |80177965797    |123456 |Você sabia? Você pode utilizar o mesmo celular para toda a sua família acessar o Hora Marcada.|
    |TC02 - login_QdoInformarCNSValido_LoginOK                                                  |707706689085010|123456 |Você sabia? Você pode utilizar o mesmo celular para toda a sua família acessar o Hora Marcada.|
    |TC03 - login_QdoInformarCPFInvalido_LoginNOK                                               |47570333039    |123456 |Login ou senha inválido                                                                       |
    |TC04 - login_QdoInformarCNSInvalido_LoginNOK                                               |700200935125224|123456 |Login ou senha inválido                                                                       |
    |TC05 - login_QdoInformarCPFValidoSenhaInvalida_LoginNOK                                    |80177965797    |143456 |Login ou senha inválido                                                                       |
    |TC06 - login_QdoInformarCNSValidoSenhaInvalida_LoginNOK                                    |707009888406932|133456 |Login ou senha inválido                                                                       |
    |TC07- login_QdoLoginSenhaVazio_LoginNOK                                                    |               |       |Favor preencher os campos corretamente.                                                       |