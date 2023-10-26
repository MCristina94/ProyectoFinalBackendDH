window.addEventListener('load', function () {

    //Al cargar la pagina buscamos y obtenemos el formulario donde estarán
    //los datos que el usuario cargará del nuevo turno
    const formulario = document.querySelector('#turno');
   
   
    //Ante un submit del formulario se ejecutará la siguiente funcion
    formulario.addEventListener('submit', function (event) {

       //creamos un JSON que tendrá los datos de un nuevo turno
       
        const formData = {

            fechaTurno: document.querySelector('#fechaTurno').value,
            odontologo: document.querySelector('#IDodontologo').value,
            paciente: document.querySelector('#IDpaciente').value,
            
        };

        
       
        //invocamos utilizando la función fetch la API turnos con el método POST que guardará
        //el turno que enviaremos en formato JSON
        const url = 'http://localhost:8080/turnos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                 //Si no hay ningun error se muestra un mensaje diciendo que el turno
                 //se agrego bien
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Turno Asignado </div>'

                
                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();
                 

            })
            .catch(error => {
                    //Si hay algun error se muestra un mensaje diciendo que el turno
                    //no se pudo guardar y se intente nuevamente
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                      console.log("no se creo");
                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";
                     //se dejan todos los campos vacíos por si se quiere ingresar otro turno
                     
                     resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#fechaTurno').value = "";
        document.querySelector('#IDodontologo').value = "";
        document.querySelector('#IDpaciente').value = "";

    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/turnoList.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});