window.addEventListener('load', function(){
    const formulario = document.querySelector('#update_turno');
    formulario.addEventListener('submit', function (event){
        
        findBy(document.querySelector('#turnoID').value);

        const formData ={

            idTurno: document.querySelector('#turnoID').value,
            fechaTurno: document.querySelector('#fechaTurno').value,
            odontologo: parseInt(document.querySelector('#IDodontologo').value),
            paciente: parseInt(document.querySelector('#IDpaciente').value),


        };

        const url = 'http://localhost:8080/turnos'
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
    const url = 'http://localhost:8080/turnos/'+ id;
    const settings ={
        method: 'GET'
    }
    fetch(url, settings)
    .then(response => response.json())
    .then(data => {
        let turno = data;

        document.querySelector('#turnoID').value = turno.idTurno;
        document.querySelector('#fechaTurno').value = turno.fechaTurno;
        document.querySelector('#IDodontologo').value = turno.odontologo.idOdontologo;
        document.querySelector('#IDpaciente').value = turno.paciente.idPaciente;
               
        document.querySelector('#update_paciente').style.display = "block";

    }).catch(error =>{
        console.log();("error" + error);
    })
}