function registro(){
    var elemento={
        id:$("#id").val(),
        brand:$("#brand").val(),
        model:$("#model").val(),
        category_id:$("#category_id").val(),
        name:$("#name").val()
    }
    
    $.ajax({
        dataType: 'json',
        data:elemento,
        url:"https://g572236cd0d24a7-dbproyecto.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/skate/skate",
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
        url:"https://g572236cd0d24a7-dbproyecto.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/skate/skate",
        type:'GET',
    
        success:function(response){
            var misItems=response.items;

            for(i=0;i<misItems.length;i++){
                $("#resultadosItems").append("<tr>");
                $("#resultadosItems").append("<td>"+misItems[i].id+"</td>");
                $("#resultadosItems").append("<td>"+misItems[i].brand+"</td>");
                $("#resultadosItems").append("<td>"+misItems[i].model+"</td>");
                $("#resultadosItems").append("<td>"+misItems[i].category_id+"</td>");
                $("#resultadosItems").append("<td>"+misItems[i].name+"</td>");
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
        url:"https://g572236cd0d24a7-dbproyecto.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/skate/skate",
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
        url:"https://g572236cd0d24a7-dbproyecto.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/skate/skate",
        type:'GET',
        data:idItem,
    
        success:function(response){
            var item=response.items[0];
            
            $("#id").val(item.id);
            $("#brand").val(item.brand);
            $("#model").val(item.model);
            $("#category_id").val(item.category_id);
            $("#name").val(item.name);
        },
    
        error: function(jqXHR, textStatus, errorThrown){    
        }
    });
}

function actualizar(){
    var elemento={
        id:$("#id").val(),
        brand:$("#brand").val(),
        model:$("#model").val(),
        category_id:$("#category_id").val(),
        name:$("#name").val()
    }

    var dataToSend=JSON.stringify(elemento);

    $.ajax({
        dataType: 'json',
        data:dataToSend,
        contentType:'application/json',
        url:"https://g572236cd0d24a7-dbproyecto.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/skate/skate",
        type:'PUT',

        success:function(response){
            console.log(response);
        },

        error: function(jqXHR, textStatus, errorThrown){
        }
    });
}