package matriz

import java.io.File
import java.io.FileNotFoundException

fun main() {
   ler() //utilize o caminho "absoluto" para o arquivo matrz!
}

//seleciona o arquivo a ser lido e então chama as funções necessárias para printar o arquivo
fun ler(){
    println("Escreva o diretório em que seu arquivo deve ser lido (exemplo: C:/Users/user1/Documentos/Arquivo.txt) : ")
    val fileNome = readlnOrNull()
    if (fileNome!=null){
        try {

            printarFile(fileNome)

        } catch (e: FileNotFoundException) {

            println("Falha ao ler o arquivo")
            e.printStackTrace()
        }
    }else{
        ler()
    }
}

//printa a matriz e troca os valores repetidos por zero
fun printarFile(linhaLida: String) {
    val listaComparacao = mutableListOf<String>()
    File(linhaLida).forEachLine {
        val arrayLinha = it.split(",").toMutableList() //obtem a list
        for(i in arrayLinha.indices) {
            if(!pertence(arrayLinha[i], listaComparacao)){
                    listaComparacao.add(arrayLinha[i]) //a lista de comparação receberá o valor
            }else {
                listaComparacao.add("0") //a lista de comparação receberá 0
            }
        }
        listaComparacao.add("\n")
    }
    printMatrizToInt(listaComparacao) //tirar uma dúvida em relação a questão de ter que imprimir inteiros
}

//a função verifica se o predicado/string está dentro da lista definida
fun pertence(pred: String, lista: MutableList<String>): Boolean {
    for(i in lista.indices){
        if (pred == lista[i]){
            return true
        }else{
            continue
        }
    }
    return false
}

//transforma a matriz de String para Int
fun printMatrizToInt(matriz: MutableList<String>): MutableList<Int> {
    val matrizInt = mutableListOf<Int>()

    for(i in matriz.indices){
        if(matriz[i]!="," && matriz[i]!="\n"){
            matrizInt.add(matriz[i].toInt())
            print("${ matriz[i].toInt() }, ")
        }else{
            println("")
        }
    }
    return matrizInt
}

