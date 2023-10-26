window.addEventListener('load', function(){
    const formulario = document.querySelector('#update_odontologo');
    formulario.addEventListener('submit', function (event){
        findBy(document.querySelector('#odontologoID').value);

        const formData ={
            idOdontologo: parseInt(document.querySelector('#odontologoID').value),
            matricula: parseInt(document.querySelector('#matricula').value),
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
        };

        const url = 'http://localhost:8080/odontologos'
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type':'application/json',
            },
            body: JSON.stringify(formData)
        }
        fetch(url, settings)
        .then(response => response.json())
        .catch(error =>{
            console.log(error);
            
        })
    })
})

function findBy(id){
    const url = 'http://localhost:8080/odontologos/'+id;
    const settings ={
        method: 'GET'
    }
    fetch(url, settings)
    .then(response => response.json())
    .then(data => {
        let odontologo = data;
        document.querySelector('#odontologoID').value = odontologo.idOdontologo;
        document.querySelector('#matricula').value = odontologo.matricula;
        document.querySelector('#nombre').value = odontologo.nombre;
        document.querySelector('#apellido').value = odontologo.apellido;

        document.querySelector('#update_odontologo').style.display = "block";

    }).catch(error =>{
        console.log();("error" + error);
    })
}