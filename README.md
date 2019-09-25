# Exercício 3

O exercício consiste no desenvolvimento de um aplicativo para gerenciar uma lista de tarefas. Cada tarefa possui uma descrição e uma prioridade entre 1 e 10, de forma que, quanto menor o número, mais prioritária é a tarefa. Não pode haver duas tarefas com a mesma descrição. A lista de tarefas é ordenada por prioridade, da mais prioritária para a menos prioritária; no caso de tarefas com prioridade igual, usa-se a ordem de inserção (tarefas adicionadas mais recentemente aparecem no final).

Note que o layout já está pronto, assim como a classe `Tarefa`.

A interface gráfica está ilustrada na imagem `screenshot.png` nesta pasta. O botão `Adicionar` insere uma tarefa na lista, com os dados digitados pelo usuário (se os dados forem válidos). O botão `Remover 1º` remove o primeiro item da lista. Sempre que a lista estiver vazia, o botão deve estar desativado. Clicar em um item também resulta na sua remoção.

Mensagens:

- Ao tentar inserir uma tarefa com a mesma descrição de uma tarefa da lista, o aplicativo deve exibir um `Toast` com o texto "Tarefa já cadastrada."
- Ao tentar inserir uma tarefa com prioridade inválida, o aplicativo deve exibir um `Toast` com o texto "A prioridade deve estar entre 1 e 10.".
