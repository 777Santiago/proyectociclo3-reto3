function registro(){
    var elemento={
        id:$("#id").val(),
        messagetext:$("#messagetext").val()
    }
    
    $.ajax({
        dataType: 'json',
        data:elemento,
        url:"https://g572236cd0d24a7-dbproyecto.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/message/message",
        type:'POST',

        success:function(response){
            console.log(response);
        },

        error: function(jqXHR, textStatus, errorThrown){
        }
    });
}

function obtenerItems(){
    $.ajax({
        dataType: 'json',
        url:"https://g572236cd0d24a7-dbproyecto.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/message/message",
        type:'GET',
    
        success:function(response){
            var misItems=response.items;

            for(i=0;i<misItems.length;i++){
                $("#resultadosItems").append("<tr>");
                $("#resultadosItems").append("<td>"+misItems[i].id+"</td>");
                $("#resultadosItems").append("<td>"+misItems[i].messagetext+"</td>");
                $("#resultadosItems").append('<td><button onclick="borrar('+misItems[i].id+')">borrar</button></td>');
                $("#resultadosItems").append('<td><button onclick="obtenerItemEspecifico('+misItems[i].id+')">cargar</button></td>');
                $("#resultadosItems").append("</tr>");
            }
        },
    
        error: function(jqXHR, textStatus, errorThrown){
        }
    });
}

function borrar(idElemento){
    var elemento={
        id:idElemento
    }

    var dataToSend=JSON.stringify(elemento)

    $.ajax({
        dataType: 'json',
        data:dataToSend,
        contentType:'application/json',
        url:"https://g572236cd0d24a7-dbproyecto.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/message/message",
        type:'DELETE',
    
        success:function(response){
            console.log(response);
        },
    
        error: function(jqXHR, textStatus, errorThrown){
        }
    });
}

function obtenerItemEspecifico(idItem){
    $.ajax({
        dataType: 'json',
        url:"https://g572236cd0d24a7-dbproyecto.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/message/message",
        type:'GET',
        data:idItem,
    
        success:function(response){
            var item=response.items[0];
            
            $("#id").val(item.id);
            $("#messagetext").val(item.messagetext);
        },
    
        error: function(jqXHR, textStatus, errorThrown){    
        }
    });
}

function actualizar(){
    var elemento={
        id:$("#id").val(),
        messagetext:$("#messagetext").val()
    }

    var dataToSend=JSON.stringify(elemento);

    $.ajax({
        dataType: 'json',
        data:dataToSend,
        contentType:'application/json',
        url:"https://g572236cd0d24a7-dbproyecto.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/message/message",
        type:'PUT',

        success:function(response){
            console.log(response);
        },

        error: function(jqXHR, textStatus, errorThrown){
        }
    });
}