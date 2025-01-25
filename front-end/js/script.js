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