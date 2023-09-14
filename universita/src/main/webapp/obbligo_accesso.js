$(document).ready(function()
{
$("#formlogin").submit(function()

{
var nome=document.getElementById("utente").value;
var passwor=document.getElementById("pw").value;
if(nome=="" ){
alert("Inseire un utente");
return false;
}else{
return true;
}
});
});