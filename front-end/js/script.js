const formulario = document.querySelector("#form-web");

formulario.addEventListener("submit", function (event) {
    event.preventDefault(); // Previne o comportamento padrão do formulário

    const formData = new FormData(formulario); // Cria uma instância de FormData com o formulário

    // Validação básica do arquivo (verifica tipo e tamanho)
    const resumeFile = formData.get("resume");
    const allowedExtensions = [".doc", ".docx", ".pdf"];
    const maxSize = 1 * 1024 * 1024; // 1MB

    if (resumeFile) {
        const fileExtension = resumeFile.name.split('.').pop().toLowerCase();
        if (!allowedExtensions.includes(`.${fileExtension}`)) {
            alert("Por favor, envie um arquivo válido (.doc, .docx, .pdf).");
            return;
        }
        if (resumeFile.size > maxSize) {
            alert("O arquivo deve ter no máximo 1MB.");
            return;
        }
    }

    // Criando o objeto com os dados do formulário
    const data = {
        name: formData.get("name"),
        email: formData.get("email"),
        phoneNumber: formData.get("phoneNumber"),
        desiredPosition: formData.get("desired-position"),
        education: formData.get("education"),
        observations: formData.get("observations") || null,
        resume: resumeFile // O arquivo será enviado em FormData no backend
    };

    console.log(data);

    fetch("http://localhost:8080/form", {
        method: "POST",
        body: formData, // FormData para enviar arquivos
    })
        .then((response) => {
            if (!response.ok) {
                throw new Error("Erro ao enviar o formulário.");
            }
            return response.json();
        })
        .then((result) => {
            console.log("Sucesso:", result);
            alert("Formulário enviado com sucesso!");
        })
        .catch((error) => {
            console.error("Erro:", error);
            alert("Houve um erro ao enviar o formulário.");
        });
});