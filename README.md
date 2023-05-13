# Aprenda Kotlin com Exemplos - Desafio de Projeto (Lab)

Este repositório contém uma solução em Kotlin para o desafio de projeto proposto pelo curso  [aprenda-kotlin-com-exemplos](https://github.com/digitalinnovationone/aprenda-kotlin-com-exemplos) da plataforma Digital Innovation One. O objetivo do desafio é criar uma solução que abstraia o domínio de Formações Educacionais e permita matricular alunos nessas formações.

## Domínio

A solução proposta abstrai o seguinte domínio de aplicação:

> **A [DIO](https://web.dio.me) possui `Formacoes` incríveis que têm como objetivo oferecer um conjunto de `ConteudosEducacionais` voltados para uma stack tecnológica específica, preparando profissionais de TI para o mercado de trabalho. `Formacoes` possuem algumas características importantes, como `nome`, `nivel` e seus respectivos `conteudosEducacionais`. Além disso, tais experiências educacionais têm um comportamento relevante ao nosso domínio, definido pela capacidade de `matricular` um ou mais `Alunos`.**

## Funcionalidades

A solução proposta permite a criação de Formações Educacionais e Conteúdos Educacionais, bem como a matrícula e conclusão de Formações Educacionais por Alunos. Alguns exemplos de funcionalidades são:

- Criação de Formações Educacionais
- Adição de Conteúdos Educacionais a uma Formação Educacional existente
- Matrícula de um Aluno em uma Formação Educacional
- Conclusão de uma Formação Educacional por um Aluno
- Listagem de Alunos matriculados em uma Formação Educacional
- Listagem de Alunos que concluíram uma Formação Educacional

## Estrutura do Código

O código da solução está organizado em duas classes principais:

- `Formacao`: representa uma Formação Educacional, contendo informações como nome, nível e uma lista de Conteúdos Educacionais.
- `Usuario`: representa um Aluno, contendo informações como nome, sobrenome, email, data de nascimento e as Formações Educacionais em que está matriculado ou já concluiu.

Além dessas classes, o código contém uma classe `ConteudoEducacional` que representa um Conteúdo Educacional, utilizado na composição das Formações Educacionais.

O código ainda utiliza enumerações (`enum class`) para representar o nível das Formações Educacionais e o status de matrícula dos Alunos.
