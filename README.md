# AvFinalTeoriaComputacaoCaio

**Título:** Implementação de grafo em Java e busca em BFS

**Autor:** Caio Vinicius de Souza Costa - 836467

**Objetivos:** Adiciona vertices, arestas a um grafo, verifica os vizinhos de determinado verice, verifica a ligação entre dois vertices, além de implementar as operações de: Caminho, União e Intersecção de Grafos e realizar a busca em largura (BFS)

**Instalação:** Para executar o código, é necessário ter um compilador Java instalado na máquina, como o Intellij, Eclipse, Netbeans entre outros.

*Como usar:** Você pode utilizar o arquivo Main.java para acessar as funções da aplicação, como:

graph.addVertex("d"); - adicionar vertice<br>
graph.addEdge("a", "b"); - adicionar aresta<br>
graph.neighbours("a") - ver vizinhos de um vertice<br>
direct("a", "c") - verificar se 2 vertices estão ligados<br>
caminho("a", "b") - verificar se possue caminho entre 2 vertices<br>
graph.uniao(graph2) - mostrar a união entre 2 grafos<br>
graph.interseccao(graph2 - mostrar a intersecção entre 2 grafos<br>
List<Vertex> path = graph.buscaBfs("a", "e") - encontrar um caminho entre 2 vertices;
