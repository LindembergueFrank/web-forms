const form = document.querySelector("form");

form.addEventListener('submit', async function (event) {
    event.preventDefault();

    // Captura os valores do formulário
    const formData = new FormData(form);
    const data = {
        nome: formData.get('name'),
        email: formData.get('email'),
        telefone: formData.get('phone'),
        cargoDesejado: formData.get('desired-position'),
        escolaridade: formData.get('education'),
        observacoes: formData.get('observations') || null // Observações é opcional
    };

    // Captura o arquivo do currículo
    const fileInput = document.getElementById('resume');
    const file = fileInput.files[0];

    if (!file) {
        alert('Por favor, envie um currículo válido.');
        return;
    }

    // Monta um objeto FormData para incluir o arquivo
    const payload = new FormData();
    Object.keys(data).forEach(key => payload.append(key, data[key]));
    payload.append('curriculo', file);

    try {
        // Faz a requisição para a API
        const response = await fetch('http://sua-api.com/endpoint', { // Substitua pela URL real
            method: 'POST',
            body: payload
        });

        if (response.ok) {
            alert('Formulário enviado com sucesso!');
            form.reset(); // Limpa o formulário após o envio
        } else {
            alert('Ocorreu um erro ao enviar o formulário. Tente novamente.');
        }
    } catch (error) {
        console.error('Erro na requisição:', error);
        alert('Erro ao enviar o formulário.');
    }

    console.log(data);
});

function validateFile(input) {
    const file = input.files[0];
    const allowedExtensions = ['.doc', '.docx', '.pdf'];
    const maxSize = 1 * 1024 * 1024;

    if (file) {
        const fileExtension = file.name.slice(file.name.lastIndexOf('.')).toLowerCase();
        if (!allowedExtensions.includes(fileExtension)) {
            alert('Somente arquivos .doc, .docx ou .pdf são permitidos.');
            input.value = '';
            return;
        }

        if (file.size > maxSize) {
            alert('O tamanho máximo do arquivo é de 1MB.');
            input.value = '';
            return;
        }
    }
}