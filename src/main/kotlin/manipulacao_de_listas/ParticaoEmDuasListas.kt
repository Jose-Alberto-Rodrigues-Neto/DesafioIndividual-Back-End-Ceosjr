package manipulacao_de_listas

import java.util.Scanner

fun main(){
    val comecoCodigo = System.currentTimeMillis()

    var lista1 = mutableListOf<Int>()
    var lista2 = mutableListOf<Int>()

    val scanner = Scanner(System.`in`)

    println("Escolha o tamanho da primeira lista: ")
    val tamL1: Int = scanner.nextInt()
    println("Escolha o tamanho da segunda lista: ")
    val tamL2: Int = scanner.nextInt()

    println("Escolha todos os $tamL1 itens para a lista 1:")
    while (lista1.size<tamL1){
        lista1.add(scanner.nextInt())
    }
    println("Escolha todos os $tamL2 itens para a lista 2:")
    while (lista2.size<tamL2){
        lista2.add(scanner.nextInt())
    }

    val listaTotal = mergeSort((lista1+lista2).toMutableList()) //utiliza o mergeSort usado no código anterior
    //divide a lista novamente
    lista1 = listaTotal.subList(0, listaTotal.size / 2 ) //verificar outras formas de fazer a divisão do array, já que provavelmente essa não será uma resposta válida
    lista2 = listaTotal.subList(listaTotal.size / 2, listaTotal.size)


    println("A lista 1 ($lista1) sempre terá itens menores que a lista 2 ($lista2)!")
    scanner.close()
    val fimCodigo = System.currentTimeMillis()
    val tempoDeExecucao = fimCodigo - comecoCodigo
    println("Tempo de execução: $tempoDeExecucao milissegundos")

}
