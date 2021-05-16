$(document).ready(function(){
    $.ajax({
        url: '/Resumen-SERVICE/rest/Resumenes',
        type: 'get',
        dataType: 'JSON',
        success: function(response){
            var len = response.length;
            for(var i=0; i<len; i++){
                var email = response[i].email;
                var name = response[i].name;
                var autor = response[i].autor;
                var title = response[i].title;
                var status = response[i].status;
                var document = response[i].document;
                var puntuacion = response[i].puntuacion;
                var comentario = response[i].comentario;
                var tr_str = "<tr>" +
                    "<td align='center'>" + email + "</td>" +
                    "<td align='center'>" + name + "</td>" +
                    "<td align='center'>" + title + "</td>" +
                    "<td align='center'>" + status + "</td>" +
                    "<td align='center'>" + puntuacion + "</td>" +
                    "<td align='center'>" + autor + "</td>" +
                    "<td align='center'>" + comentario + "</td>" +
                    "</tr>";
                $("#userTable tbody").append(tr_str);
            }
        }
    });
});