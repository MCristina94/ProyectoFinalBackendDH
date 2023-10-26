window.addEventListener('load', function () {
    (function(){

      //con fetch invocamos a la API de odontologos con el método GET
      //nos devolverá un JSON con una colección de odontologos
      const url = 'http://localhost:8080/odontologos';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
        
       
      //recorremos la colección de odontologos del JSON
         for(let odontologo of data){
            
            //por cada odontologo armaremos una fila de la tabla
            //cada fila tendrá un id
            var table = document.getElementById("odontologoTable");
            var odontologoRow =table.insertRow();
            let tr_id = 'tr_' + odontologo.idOdontologo;
            odontologoRow.id = tr_id;

            //boton delete
            let deleteButton = '<button '+
                                'id=' + '\"' + 'btn_delete_' + odontologo.idOdontologo + '\"' +
                                ' type = \"button\" onclick=\"deleteBy('+ odontologo.idOdontologo +')\" class=\"btn btn-danger btn_id\">'+ 'Eliminar' +'</button>';

            //boton modificar
            let updateButton = '<button '+
                                'id=' + '\"' + 'btn_update_' + odontologo.idOdontologo + '\"' +
                                ' type = \"button\" onclick=\"findBy('+ odontologo.idOdontologo +')\" class=\"btn btn-info btn_id\">'+ odontologo.idOdontologo+'</button>';


            //armamos cada columna de la fila
            odontologoRow.innerHTML =  '<td>' + updateButton + '</td>' +
                                        '<td class=\"td_nombre\">' + odontologo.nombre.toUpperCase() + '</td>' +
                                        '<td class=\"td_apellido\">' + odontologo.apellido.toUpperCase() + '</td>'+
                                        '<td class=\"td_matricula\">' + odontologo.matricula + '</td>'+
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