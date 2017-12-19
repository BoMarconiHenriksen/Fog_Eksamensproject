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
                //Bruges til at fjerne evt. input i et felt
//             $("#checkbox").val("");
        }
        });
        });

function show_confirmDeletetheOrder()
{
  var r = confirm("Er du sikker på, at du gerne vil slette denne ordre?");
  if(r === true)
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
  var r = confirm("Tryk OK for at logge af.");
  if(r === true)
  {
     // do something
     return true;
  } else {
     // do something
     return false;
  }
}

function checkNotnullOrEmpty()
{
    var firstname = document.register.firstname.value;
    var lastname = document.register.lastname.value;
    var addresse = document.register.addresse.value;
    var postnummer = document.register.postnummer.value;
    var telefonnummer = document.register.telefonnummer.value;
    var email = document.register.email.value;
    var password = document.register.password.value;
    var passwordRetype = document.register.passwordRetype.value;
    
    if (firstname === null || firstname === "")
    {
        alert("Husk at udfylde dit fornavn.");
        return false; //Forhindrer at formen bliver submittet
    } else if (password === null || password === "")
    {
        alert("Husk at udfylde dit password.");
        return false;
    } else if (lastname === null || lastname === "")
    {
        alert("Husk at udfylde dit efternavn.");
        return false;
    } else if (addresse === null || addresse === "")
    {
        alert("Husk at udfylde din adresse.");
        return false;
    } else if (postnummer === null || postnummer === "")
    {
        alert("Husk at udfylde dit postnummer.");
        return false;
    } else if (postnummer < 1000 || postnummer > 1000) {
        alert("Husk at udfylde dit postnummer. Da det eneste postnummer, der er sat ned i databasen er 1000. Er det pt det eneste postnummer, der kan bruges. Dette skal ændres på lændere sigt.");
        return false;
    } else if (telefonnummer === null || telefonnummer === "")
    {
        alert("Husk at udfylde dit telefonnummer.");
        return false;
    } else if (isNaN(telefonnummer)) { //isNan tjekker om der kun er tal
        alert("Telefonnummeret må kun består af tal, og ikke have tomme felter mellem tallene.");
        return false;
    }  else if (telefonnummer.length !== 8) {
        alert("Telefonnummeret skal have en længde på 8 cifre.");
        return false;
    } else if (email === null || email === "")
    {
        alert("Husk at udfylde din email.");
        return false;
    } else if (password !== passwordRetype)
    {
        alert("Password og password retype er ikke ens. Prøv igen!");
        return false;
    } 
}

// Til test
function myFunctionDeleteOrder() {
    document.getElementById("demo").innerHTML = "Hello World";
}


