package manipulacao_de_listas

import java.util.Scanner
fun main(){
    val comecoCodigo = System.currentTimeMillis()

    val listaL = mutableListOf<Int>()

    addToList(listaL) //adiciona os itens na lista

    val listaMerge = mergeSort(listaL)

    val terceiroMaiorElemento = listaMerge[listaL.size - 3]

    println("Essa foi a lista utilizada: $listaMerge")
    println("O terceiro maior elemento dessa lista é: $terceiroMaiorElemento")

    //avaliando o tempo da execução
    val fimCodigo = System.currentTimeMillis()
    val tempoDeExecucao = fimCodigo - comecoCodigo

    println("Tempo de execução: $tempoDeExecucao milissegundos")
}
fun mergeSort(lista: MutableList<Int>): MutableList<Int> {
    if (lista.size <= 1) {
        return lista
    }

    val meio = lista.size / 2
    val esquerda = lista.subList(0, meio)
    val direita = lista.subList(meio, lista.size)

    return merge(mergeSort(esquerda), mergeSort(direita))
}

fun merge(esquerda: MutableList<Int>, direita: MutableList<Int>): MutableList<Int> {
    val listaFinal = mutableListOf<Int>()
    var indiceEsquerda = 0
    var indiceDireita = 0

    while (indiceEsquerda < esquerda.size && indiceDireita < direita.size) {
        if (esquerda[indiceEsquerda] <= direita[indiceDireita]) {
            listaFinal.add(esquerda[indiceEsquerda])
            indiceEsquerda++
        } else {
            listaFinal.add(direita[indiceDireita])
            indiceDireita++
        }
    }

    listaFinal.addAll(esquerda.subList(indiceEsquerda, esquerda.size))
    listaFinal.addAll(direita.subList(indiceDireita, direita.size))

    return listaFinal
}

fun addToList(lista: MutableList<Int>){
    val scanner = Scanner(System.`in`)
    println("Escolha o tamanho da lista: ")
    val tamLista: Int = scanner.nextInt()

    println("Escolha todos os $tamLista itens para a lista 1:")
    while (lista.size<tamLista){
        lista.add(scanner.nextInt())
    }
    scanner.close()
}