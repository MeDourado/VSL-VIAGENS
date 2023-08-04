Algoritmo "SISTEMA DE VIAGENS"
// Disciplina   : [Linguagem e Lógica de Programação] 


// DECLARAR VARIAVEIS
Var
   nomeMatriz: vetor [1..100, 1..2] de inteiro
   clientes : vetor[1..100, 0..4] de caracter
   destinos : vetor[1..100, 0..2] de caracter
   i, j, totalCliente, totalDestino, opcao : inteiro
   rotuloCliente : vetor[0..4] de caracter
   rotuloDestino : vetor[0..2] de caracter


// CADASTRAR CLIENTE
procedimento cadastroCliente()
inicio
    se (totalCliente >= 100) entao
        escreval("Limite de clientes cadastrados atingido. Não é possível cadastrar novos clientes.")
    senao
        rotuloCliente[0] <- "Nome: "
        rotuloCliente[1] <- "Sobrenome: "
        rotuloCliente[2] <- "CPF: "
        rotuloCliente[3] <- "Cidade: "
        rotuloCliente[4] <- "Estado: "

        escreval("Digite os dados do cliente: ")

        i <- totalCliente + 1

        para j de 0 até 4 faça
            escreva(rotuloCliente[j])
            leia(clientes[i, j])
        fimpara

        totalCliente <- totalCliente + 1
        escreval("Cliente ", totalCliente, " cadastrado com sucesso!")

    fimse
fimprocedimento

// CADASTRAR DESTINO
procedimento cadastroDestino()
inicio
    se (totalDestino >= 100) entao
        escreval("Limite de destinos cadastrados atingido. Não é possível cadastrar novos destinos.")
    senao
        rotuloDestino[0] <- "Nome do destino: "
        rotuloDestino[1] <- "Localização: "
        rotuloDestino[2] <- "Atrações:"

        escreval("Digite os dados do destino: ")

        i <- totalDestino + 1

        para j de 0 até 2 faça
            escreva(rotuloDestino[j])
            leia(destinos[i, j])
        fimpara

        totalDestino <- totalDestino + 1
        escreval("Destino ", totalDestino, " cadastrado com sucesso!")

    fimse
fimprocedimento


//EXIBIR CLIENTES
procedimento exibirClientes()
inicio
    se (totalCliente = 0) entao
        escreval("Não há clientes cadastrados.")
    senao
        escreval("**** DADOS DOS CLIENTES ****")

        para i de 1 até totalCliente faça
            escreval()
            escreva("Cliente ", i, ": ")
            para j de 0 até 4 faça
                escreva(rotuloCliente[j], clientes[i, j], " | ")
            fimpara
        fimpara
        Escreval("")

    fimse
fimprocedimento

procedimento exibirDestinos()
inicio
    se (totalDestino = 0) entao
        escreval("Não há destinos cadastrados.")
    senao
        escreval("**** DADOS DOS DESTINOS ****")

        para i de 1 até totalDestino faça
            escreval()
            escreva("Destino ", i, ": ")
            para j de 0 até 2 faça
                escreva(rotuloDestino[j], destinos[i, j], " | ")
            fimpara
        fimpara
        Escreval("")

    fimse
fimprocedimento

// MENU
procedimento menu()
inicio
     repita
        Escreval("")
        Escreval("-------- Menu da Agência de Viagens --------")
        Escreval("1 - Cadastrar novo cliente")
        Escreval("2 - Cadastrar novo destino")
        Escreval("3 - Consultar clientes")
        Escreval("4 - Consultar destinos")
        Escreval("5 - Sair")
        Escreval("--------------------------------------------")
        Escreval("Escolha uma opção: ")
        leia(opcao)

        escolha opcao
            caso 1
                cadastroCliente()
            caso 2
                cadastroDestino()
            caso 3
                exibirClientes()
            caso 4
                exibirDestinos()



        fimescolha

    se (opcao > 5) entao
       Escreval("Opção inválida! Escolha uma opção válida.")
    fimse
    até (opcao = 5)
fimprocedimento

Inicio
    totalCliente <- 0
    totalDestino <- 0
    menu()
Fimalgoritmo
