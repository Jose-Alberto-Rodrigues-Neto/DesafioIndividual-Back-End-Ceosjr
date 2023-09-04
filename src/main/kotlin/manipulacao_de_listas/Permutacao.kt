package manipulacao_de_listas

import java.util.Scanner
fun main(){
    val listaL1 = mutableListOf<Int>()
    val listaL2 = mutableListOf<Int>()

    addToPermutacao(listaL1, listaL2) //adiciona valores escolhidos pelo usuário as duas listas

    val listaOrdenada1 = mergeSort(listaL1) //função que foi criada em outro arquivo, mas do mesmo pacote
    val listaOrdenada2 = mergeSort(listaL2)

    println(listaOrdenada1)
    println(listaOrdenada2)

    if (listaOrdenada1 == listaOrdenada2){
        println("Isso é uma permutação da lista $listaL1 e da lista $listaL2")
    }else{
        println("Isso não é uma permutação da lista $listaL1 e da lista $listaL2")
    }

}

fun addToPermutacao(lista1: MutableList<Int>, lista2: MutableList<Int>){
    println("Escolha o tamanho que as duas listas devem ter:")
    val readInt = Scanner(System.`in`)
    val tamLista = readInt.nextInt()
    println("Agora escreva os valores da lista L1:")
    while (lista1.size<tamLista){
        lista1.add(readInt.nextInt())
    }
    println("Agora escreva os valores da lista L2:")
    while (lista2.size<tamLista){
        lista2.add(readInt.nextInt())
    }
}
