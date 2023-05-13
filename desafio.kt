import java.time.LocalDate

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(
    val nome: String,
    val sobrenome: String,
    val email: String,
    val dataNascimento: LocalDate
){
    val nomeCompleto: String = "$nome $sobrenome"
    val formacoesConcluidas = mutableListOf<Formacao>()
    val formacaoInscritas = mutableListOf<Formacao>()

    fun inscrever(formacao: Formacao){
        if(!formacaoInscritas.contains(formacao)){
            formacaoInscritas.add(formacao)
            println("$nomeCompleto foi inscrito na formação ${formacao.nome}")
        }else
            println("$nomeCompleto ja está inscrito na formação ${formacao.nome}.")

    }

    fun concluir(formacao: Formacao){
        if(formacaoInscritas.contains(formacao)){
            formacaoInscritas.remove(formacao)
            formacoesConcluidas.add(formacao)
            println("$nomeCompleto concluiu ${formacao.nome}")
        }else{
            println("$nomeCompleto não está inscrito em ${formacao.nome}.")
        }
    }

    fun listaFormacaoInscritas(){
        println("Formações em que $nome esta inscrito")
        formacaoInscritas.forEach { println(it.nome) }
    }

    fun listaFormacaoConcluida(){
        println("Formações que $nome concluiu")
        formacoesConcluidas.forEach { println(it.nome) }
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    val concluintes = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario){
        if(inscritos.contains(usuario)){
            println("${usuario.nomeCompleto} ja está inscrito nesta formação")
        }else{
            usuario.inscrever(this)
            inscritos.add(usuario)
        }
    }

    fun concluir(usuario: Usuario) {
        if(concluintes.contains(usuario)){
            println("${usuario.nomeCompleto} ja concluiu esta formação")
        }else{
            usuario.concluir(this)
            concluintes.add(usuario)
            inscritos.remove(usuario)
        }
    }

    fun listaInscritos() {
        println("Usuários inscritos em $nome:")
        inscritos.forEach { println(it.nomeCompleto) }
    }

    fun listaConcluintes() {
        println("Usuários que concluiram $nome:")
        concluintes.forEach { println(it.nomeCompleto) }
    }

}

fun main() {
    val usuario1: Usuario = Usuario("Ana", "Silva", "ana.silva@gmail.com", LocalDate.of(1998, 12, 7))
    val usuario2: Usuario = Usuario("João", "Santos", "joao.santos@hotmail.com", LocalDate.of(1996, 10, 15))

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 120, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin", nivel = Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Desenvolvimento de Aplicações Android com Kotlin", 180, Nivel.AVANCADO)

    val formacao = Formacao("Formação Kotlin", listOf(conteudo1, conteudo2, conteudo3))

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.listaInscritos()

    println("")

    formacao.concluir(usuario1)
    formacao.concluir(usuario2)

    println("")

    formacao.listaInscritos()
    formacao.listaConcluintes()

}
