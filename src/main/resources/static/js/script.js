// Aguarda o carregamento completo da página
document.addEventListener("DOMContentLoaded", function() {
    var isFinishedBtn = document.querySelectorAll('.isFinishedBtn');

    // Aplica o estilo "completed" com base no status ao carregar a página
    document.querySelectorAll('tr[data-finished="true"]').forEach(function(row) {
        var nameCell = row.querySelector('td:nth-child(2)');
        var descriptionCell = row.querySelector('td:nth-child(3)');
        nameCell.classList.add('completed');
        descriptionCell.classList.add('completed');
    });

    // Adiciona um evento de clique a cada botao
    isFinishedBtn.forEach(function(button) {
        button.addEventListener("click", function() {
            // Obtém o ID da tarefa a partir do atributo data-id
            var todoId = button.getAttribute('data-id');

            // Encontra a linha da tabela correspondente
            var todoRow = document.getElementById('todo-' + todoId);

            // Adiciona ou remove a classe "completed" no nome e na descrição da tarefa
            var nameCell = todoRow.querySelector('td:nth-child(2)');
            var descriptionCell = todoRow.querySelector('td:nth-child(3)');

            nameCell.classList.toggle('completed');
            descriptionCell.classList.toggle('completed');

            // Envia uma requisição ao backend para atualizar o status da tarefa
            fetch('/todos/toggle/' + todoId, {
                method: 'POST',
            })
            .then(response => response.json())
            .then(data => {
                console.log("Status succesfully updated", data.message);
                // Atualiza o atributo data-finished com o novo status
                todoRow.setAttribute('data-finished', data.isFinished);
            })
            .catch(error => {
                console.error("Update error: ", error);
            })

        })
    })
})