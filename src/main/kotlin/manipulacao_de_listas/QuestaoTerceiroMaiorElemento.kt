package manipulacao_de_listas

fun main(){
    val listaL = listOf(1,23,14,11,56,76,33,89,12,132,678,2132,78,33,123,999)

    val listaMerge = mergeSort(listaL)

    val terceiroMaiorElemento = listaMerge[listaL.size - 3]

    println("Essa foi a lista utilizada: $listaMerge")
    println("O terceiro maior elemento dessa lista é: $terceiroMaiorElemento")
}
fun mergeSort(lista: List<Int>): List<Int> {
    if (lista.size <= 1) {
        return lista
    }

    val meio = lista.size / 2
    val esquerda = lista.subList(0, meio)
    val direita = lista.subList(meio, lista.size)

    return merge(mergeSort(esquerda), mergeSort(direita))
}

fun merge(esquerda: List<Int>, direita: List<Int>): List<Int> {
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
