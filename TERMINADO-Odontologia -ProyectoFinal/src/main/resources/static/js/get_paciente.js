window.addEventListener('load', function () {
    (function(){

      //con fetch invocamos a la API de paciente con el método GET
      //nos devolverá un JSON con una colección de pacientes
      const url = 'http://localhost:8080/pacientes';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
        
       
      //recorremos la colección de pacientes del JSON
         for(let paciente of data){
            
            //por cada paciente armaremos una fila de la tabla
            //cada fila tendrá un id
            var table = document.getElementById("pacienteTable");
            var pacienteRow =table.insertRow();
            let tr_id = 'tr_' + paciente.idPaciente;
            pacienteRow.id = tr_id;

            //boton delete
            let deleteButton = '<button '+
                                'id=' + '\"' + 'btn_delete_' + paciente.idPaciente + '\"' +
                                ' type = \"button\" onclick=\"deleteBy('+ paciente.idPaciente +')\" class=\"btn btn-danger btn_id\">'+ 'Eliminar' +'</button>';

            //boton modificar
            let updateButton = '<button '+
                                'id=' + '\"' + 'btn_update_' + paciente.idPaciente + '\"' +
                                ' type = \"button\" onclick=\"findBy('+ paciente.idPaciente +')\" class=\"btn btn-info btn_id\">'+ paciente.idPaciente +'</button>';


        
                                console.log(paciente.nombre);
                                console.log(paciente.apellido);
                                console.log(paciente.dni);
                                console.log(paciente.fechaAlta);
            //armamos cada columna de la fila
            pacienteRow.innerHTML =  '<td>' + updateButton + '</td>' +
                                        '<td class=\"td_nombre\">' + paciente.nombre.toUpperCase() + '</td>' +
                                        '<td class=\"td_apellido\">' + paciente.apellido.toUpperCase() + '</td>'+
                                        '<td class=\"td_dni\">' + paciente.dni + '</td>'+
                                        '<td>' + deleteButton + '</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/pacienteList.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


    })