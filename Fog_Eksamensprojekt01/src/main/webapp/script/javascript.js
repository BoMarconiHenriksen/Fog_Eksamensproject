//Funktion til hidden skur
$(function () {

// Henter form felterne og hidden div
var checkbox = $("#trigger");
        var hidden = $("#hidden_fields");
        //Hvis checkboxen er markeret fjernes markering ved refresh.
        $(':checkbox:checked').prop('checked', false);
        // Hide
        hidden.hide();
        // Setup en event listener så man kan se hvornår checkbox state ændre sig
        checkbox.change(function () {
        // Checker for at se om checkboxen er chekket
        // Hvis den er så viser den tabellen
        // Hvis ikke så, gemmer den tabellen.
        if (checkbox.is(':checked')) {
        // Viser tabellen
        hidden.show();
        
        



        } else {
        // Være sikker på at tabellen er gemt
        hidden.hide();
                // You may also want to clear the value of the 
                // hidden fields here. Just in case somebody 
                // shows the fields, enters data to them and then 
                // unticks the checkbox.
                //
                // This would do the job:
                //
//             $("#checkbox").val("");
        }
        });
        });

function show_confirmDeletetheOrder()
{
  var r = confirm("Er du sikker på at du gerne vil slette denne ordre?");
  if(r == true)
  {
     // do something
     return true;
  } else {
     // do something
     return false;
  }
}

function show_confirmLogOff()
{
  var r = confirm("Tryk på OK for at logge af brugeren.");
  if(r == true)
  {
     // do something
     return true;
  } else {
     // do something
     return false;
  }
}
