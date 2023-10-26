window.addEventListener('load', function(){
    const formulario = document.querySelector('#update_paciente');
    formulario.addEventListener('submit', function (event){
        findBy(document.querySelector('#pacienteID').value);

        const formData ={
            idPaciente: parseInt(document.querySelector('#pacienteID').value),
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: parseInt(document.querySelector('#dni').value),
            fechaAlta: document.querySelector('#fecha').value,
            domicilio:{
                calle: document.querySelector('#calle').value,
                numero: parseInt(document.querySelector('#numero').value),
                ciudad: document.querySelector('#ciudad').value,
                departamento: document.querySelector('#departamento').value,
            }
        };

        const url = 'http://localhost:8080/pacientes'
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
    const url = 'http://localhost:8080/pacientes/'+ id;
    const settings ={
        method: 'GET'
    }
    fetch(url, settings)
    .then(response => response.json())
    .then(data => {
        let paciente = data;
       
        document.querySelector('#pacienteID').value = paciente.idPaciente;
        document.querySelector('#nombre').value = paciente.nombre;
        document.querySelector('#apellido').value = paciente.apellido;
        document.querySelector('#dni').value = paciente.dni;
        document.querySelector('#fecha').value = paciente.fechaAlta;
        document.querySelector('#calle').value = paciente.calle;
        document.querySelector('#numero').value = paciente.numero;
        document.querySelector('#ciudad').value = paciente.ciudad;
        document.querySelector('#departamento').value = paciente.departamento;
        
        document.querySelector('#update_paciente').style.display = "block";

    }).catch(error =>{
        console.log();("error" + error);
    })
}