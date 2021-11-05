function registro(){
    var elemento={
        id:$("id").val(),
        email:$("#email").val(),
        password:$("#password").val(),
        name:$("#name").val(),
        age:$("#age").val()
    }
    
    $.ajax({
        dataType: 'json',
        data:elemento,
        url:"http://168.138.148.181:8080/api/Client/save",
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
        url:"http://168.138.148.181:8080/api/Client/{id}",
        type:'GET',
    
        success:function(response){
            var misItems=response.items;

            for(i=0;i<misItems.length;i++){
                $("#resultadosItems").append("<tr>");
                $("#resultadosItems").append("<td>"+misItems[i].name+"</td>");
                $("#resultadosItems").append("<td>"+misItems[i].email+"</td>");
                $("#resultadosItems").append("<td>"+misItems[i].age+"</td>");
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
        url:"http://168.138.148.181:8080/api/Client/{id}",
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
        url:"http://168.138.148.181:8080/api/Client/{id}",
        type:'GET',
        data:idItem,
    
        success:function(response){
            var item=response.items[0];
            
            $("#id").val(item.id);
            $("#name").val(item.name);
            $("#email").val(item.email);
            $("#age").val(item.age);
        },
    
        error: function(jqXHR, textStatus, errorThrown){    
        }
    });
}

function actualizar(){
    var elemento={
        email:$("#email").val(),
        password:$("#password").val(),
        name:$("#name").val(),
        age:$("#age").val()
    }

    var dataToSend=JSON.stringify(elemento);

    $.ajax({
        dataType: 'json',
        data:dataToSend,
        contentType:'application/json',
        url:"http://168.138.148.181:8080/api/Client/update",
        type:'PUT',

        success:function(response){
            console.log(response);
        },

        error: function(jqXHR, textStatus, errorThrown){
        }
    });
}