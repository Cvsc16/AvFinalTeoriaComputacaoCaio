# AvParcialTeoriaComputacaoCaio

*Título:* Implementação de grafo em C

*Autor:* Caio Vinicius de Souza Costa - 836467

*Objetivos:* Adiciona vertices, arestas a um grafo, verifica os vizinhos de determinado verice, verifica a ligação entre dois vertices, além de implementar as novas operações: Caminho, União e Intersecção de Grafos

*Instalação:* Para executar o código, é necessário ter um compilador Java instalado na máquina, como o Intellij, Eclipse, Netbeans entre outros.

*Como usar:* Você pode utilizar o arquivo Main para acessar as funções da aplicação, como:

graph.addVertex("d"); - adicionar vertice
graph.addEdge("a", "b"); - adicionar aresta
graph.neighbours("a") - ver vizinhos de um vertice
direct("a", "c") - verificar se 2 vertices estão ligados
caminho("a", "b") - verificar se possue caminho entre 2 vertices
graph.uniao(graph2) - mostrar a união entre 2 grafos
graph.interseccao(graph2 - mostrar a intersecção entre 2 grafos
