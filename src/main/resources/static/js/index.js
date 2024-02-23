$(document).ready(function () {
    $("#getAllOrdersButton").click(function() {
        $.ajax({
        type: "GET",
        url: "/order/getAllOrders",
        data: null,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(response) {
        var tableBodyHTML = '';
        tableBodyHTML = tableBodyHTML + '<tbody>';
        $.each(response, function(index) {
        tableBodyHTML = tableBodyHTML + '<tr>';
        tableBodyHTML = tableBodyHTML + '<td>'+response[index].orderId+'</td>';
        tableBodyHTML = tableBodyHTML + '<td>'+response[index].transcationId+'</td>';
        
        tableBodyHTML = tableBodyHTML + '<td>'+response[index].customerName+'</td>';
        
        tableBodyHTML = tableBodyHTML + '<td>'+response[index].productName+'</td>';
        
        tableBodyHTML = tableBodyHTML + '<td>'+response[index].price+'</td>';
        
        tableBodyHTML = tableBodyHTML + '<td>'+response[index].full_address+'</td>';
        
        tableBodyHTML = tableBodyHTML + '<td>'+response[index].paymentType+'</td>';
        
        tableBodyHTML = tableBodyHTML + '<td>'+response[index].description+'</td>';
        
        tableBodyHTML = tableBodyHTML + '</tr>';
        
        });
        
        tableBodyHTML = tableBodyHTML + '</tbody>';
        
        $("#orderTable").append(tableBodyHTML);
        
        $("#orderTable").toggle();
        
        $("#orderTable").DataTable();
        
        },
        
        failure: function(response) {
        
        alert(response);
        
        },
        
        error: function(response) {
        
        alert(response);
        
        }
        
        });
        
        });        



$("#createNewOrder").on("click",function(){
$("#orderTable").toggle();
$("#orderTable_wrapper").toggle();

$("#createNewForm").css("display","block")
});
$("#usercheck").hide();
$("#customerCheck").hide();
$("#paymenttype").hide();
$("#fulladress").hide();
let usernameError = true;
  $("#Pname").keyup(function () {
    validateUsername();
  });
  
   $("#Cname").keyup(function () {
    validateCustomerName();
  });
  
   $("#fullAddress").keyup(function () {
    validateAddress();
  });
  
  $("#Ptype").keyup(function () {
    validatePaymentType();
  });
 
  function validateUsername() {
    let usernameValue = $("#Pname").val();
    if (usernameValue.length == "") {
      $("#usercheck").show();
      usernameError = false;
      return false;
    } else if (usernameValue.length < 3 || usernameValue.length > 10) {
      $("#usercheck").show();
      $("#usercheck").html("**length of product name must be between 3 and 10");
      usernameError = false;
      return false;
    } else {
      $("#usercheck").hide();
    }
  }
  
  function validateCustomerName() {
    let customerValue = $("#Cname").val();
    if (customerValue.length == "") {
      $("#customerCheck").show();
     customerNameError = false;
      return false;
    } else if (customerValue.length < 3 || customerValue.length > 10) {
      $("#customerCheck").show();
      $("#customerCheck").html("**length of customer name must be between 2 and 10");
      customerNameError = false;
      return false;
    } else {
      $("#customerCheck").hide();
    }
  }
  
    function validateAddress() {
    let addressValue = $("#fullAddress").val();
    if (addressValue.length == "") {
      $("#fulladress").show();
     addressError = false;
      return false;
    } else if (addressValue.length < 3 || addressValue.length > 10) {
      $("#fulladress").show();
      $("#fulladress").html("**length of address must be between 2 and 10");
      addressError = false;
      return false;
    } else {
      $("#fulladress").hide();
    }
  }
  
     function validatePaymentType() {
    let paymentValue = $("#Ptype").val();
    if (paymentValue.length == "") {
      $("#paymenttype").show();
     paymentError = false;
      return false;
    } else if (paymentValue.length < 3 || paymentValue.length > 10) {
      $("#paymenttype").show();
      $("#paymenttype").html("**length of address must be between 2 and 10");
      paymentError = false;
      return false;
    } else {
      $("#paymenttype").hide();
    }
  }
  
  
        
        $("#getAllOrdersButton").click(function() {
$.ajax({
type: "GET",
url: "/order/getAllOrders",
data: null,
contentType: "application/json; charset=utf-8",
dataType: "json",
success: function(response) {
var tableBodyHTML = '';
tableBodyHTML = tableBodyHTML + '<tbody>';
$.each(response, function(index) {
tableBodyHTML = tableBodyHTML + '<tr>';
tableBodyHTML = tableBodyHTML + '<td>'+response[index].orderId+'</td>';
tableBodyHTML = tableBodyHTML + '<td>'+response[index].transcationId+'</td>';

tableBodyHTML = tableBodyHTML + '<td>'+response[index].customerName+'</td>';

tableBodyHTML = tableBodyHTML + '<td>'+response[index].productName+'</td>';

tableBodyHTML = tableBodyHTML + '<td>'+response[index].price+'</td>';

tableBodyHTML = tableBodyHTML + '<td>'+response[index].full_address+'</td>';

tableBodyHTML = tableBodyHTML + '<td>'+response[index].paymentType+'</td>';

tableBodyHTML = tableBodyHTML + '<td>'+response[index].description+'</td>';

tableBodyHTML = tableBodyHTML + '</tr>';

});

tableBodyHTML = tableBodyHTML + '</tbody>';

$("#orderTable").append(tableBodyHTML);

$("#orderTable").show();

$("#orderTable").DataTable();

},

failure: function(response) {

alert(response);

},

error: function(response) {

alert(response);

}

});

});

$("#submitbtn").on("click",function(){
    var data = {}
    data["productName"] = $("#Pname").val();
    data["customerName"] = $("#Cname").val();
    data["fullAddress"] = $("#fullAddress").val();
    data["paymentType"] = $("#Ptype").val();
    
    $.ajax({
             method: "POST",
             contentType: "application/json",
             url: "/order/setAllOrders",
             data: JSON.stringify(data),
             dataType: 'json',
             timeout: 600000,
             success: function (data) {
 
             },
             error: function (e) {
             
             }
    })
			});

        })
        