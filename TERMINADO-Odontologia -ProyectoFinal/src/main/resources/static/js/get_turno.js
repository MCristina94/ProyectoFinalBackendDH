window.addEventListener('load', function () {
    (function(){

      //con fetch invocamos a la API de turnos con el método GET
      //nos devolverá un JSON con una colección de turnos
      const url = 'http://localhost:8080/turnos';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
        
       
      //recorremos la colección de turnos del JSON
         for(let turno of data){
            
            //por cada turno armaremos una fila de la tabla
            //cada fila tendrá un id
            var table = document.getElementById("turnoTable");
            var turnoRow =table.insertRow();
            let tr_id = 'tr_' + turno.idTurno;
            turnoRow.id = tr_id;

            //boton delete
            let deleteButton = '<button '+
                                'id=' + '\"' + 'btn_delete_' + turno.idTurno + '\"' +
                                ' type = \"button\" onclick=\"deleteBy('+ turno.idTurno +')\" class=\"btn btn-danger btn_id\">'+ 'Eliminar' +'</button>';

            //boton modificar
            let updateButton = '<button '+
                                'id=' + '\"' + 'btn_update_' + turno.idTurno + '\"' +
                                ' type = \"button\" onclick=\"findBy('+ turno.idTurno +')\" class=\"btn btn-info btn_id\">'+ turno.idTurno +'</button>';


            //armamos cada columna de la fila
            turnoRow.innerHTML =  '<td>' + updateButton + '</td>' +
                                        '<td class=\"td_fechaTurno\">' + turno.fechaTurno + '</td>' +
                                        '<td class=\"td_idOdontologo\">' + turno.odontologo.idOdontologo + '</td>'+
                                        '<td class=\"td_idPaciente\">' + turno.paciente.idPaciente + '</td>'+
                                        '<td>' + deleteButton + '</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/odontologoList.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


    })