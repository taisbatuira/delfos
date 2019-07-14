# Delfos

Delfos é uma biblioteca para se trabalhar com recomendações baseadas em grafos construída em cima da [JGraphT](http://jgrapht.org/).

## Formato do arquivo de listagem de alunos
* O arquivo deve ter o caminho seguido por um usuário por linha
* O caminho deve estar entre colchetes
> Exemplo:
>
> [1 2 3 4 5]
>
> [3 4 5 6 7]

## Formato do arquivo de-para de cursos substituídos
* O arquivo deve ter uma relação por linha
* O caminho deve estar entre colchetes
> Exemplo:
>
> [10 200]


## To do list
- [X] Implementar a busca em profundidade e busca em largura
- [X] Implementar a busca A* e Dijkstra
- [X] Atualizar os dados usando o arquivo de-para
- [ ] Usar um algoritmo Map para guardar o endereço de memória dos cursos e evitar percorrer todo o grafo em toda recomendação
- [ ] Considerar como peso conexões entre pré-requisitos
- [ ] Dar prioridade a recomendações para cursos de mesma categoria
- [ ] Implementando outras formas de ler um gráfico (banco de dados, web)
- [ ] Implantar uma rede neural para evolução do algoritmo
