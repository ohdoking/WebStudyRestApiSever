function addPeople() {
       $('#peopleDialog').dialog("option", "title", 'Add People');
       $('#peopleDialog').dialog('open');
}

function editPeople(id) {

       $.get("get/" + id, function(result) {

              $("#peopleDialog").html(result);
              $('#peopleDialog').dialog("option", "title", 'Edit People');
              $("#peopleDialog").dialog('open');

              initializeDatePicker();
       });
}

function initializeDatePicker() {
       $(".datepicker").datepicker({
              dateFormat : "yy-mm-dd",
              changeMonth : true,
              changeYear : true,
              showButtonPanel : true
       });
}

function resetDialog(form) {

       form.find("input").val("");
}

$(document).ready(function() {

       $('#peopleDialog').dialog({

              autoOpen : false,
              position : 'center',
              modal : true,
              resizable : false,
              width : 440,
              buttons : {
                     "Save" : function() {
                           $('#peopleForm').submit();
                     },
                     "Cancel" : function() {
                           $(this).dialog('close');
                     }
              },
              close : function() {

                     resetDialog($('#peopleForm'));
                     $(this).dialog('close');
              }
       });

       initializeDatePicker();
});