package manipulacao_de_listas

fun main(){
    val comecoCodigo = System.currentTimeMillis()

    val listaL1 = mutableListOf(12,11,22,14)
    val listaL2 = mutableListOf(22,14,11,12)

    val listaOrdenada1 = mergeSort(listaL1) //função que foi criada em outro arquivo, mas do mesmo pacote
    val listaOrdenada2 = mergeSort(listaL2)

    println(listaOrdenada1)
    println(listaOrdenada2)

    if (listaOrdenada1 == listaOrdenada2){
        println("Isso é uma permutação da lista $listaL1 e da lista $listaL2")
    }else{
        println("Isso não é uma permutação da lista $listaL1 e da lista $listaL2")
    }

    //avaliando o tempo da execução
    val fimCodigo = System.currentTimeMillis()
    val tempoDeExecucao = fimCodigo - comecoCodigo

    println("Tempo de execução: $tempoDeExecucao milissegundos")
}
