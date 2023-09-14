const usernameInput = document.getElementById("username");
const passwordInput = document.getElementById("password");
const submitButton = document.getElementById("submit");
const span = document.getElementById("errore");
const mostrapassword = document.getElementById("mostra_password");
let check = false;
submitButton.disabled=true;
usernameInput.addEventListener("input", buttonisDisabled);
passwordInput.addEventListener("input", buttonisDisabled);
console.log(span);
function buttonisDisabled() {
  const usernameValue = usernameInput.value;
  const passwordValue = passwordInput.value;
  span.style.display = "none";
  
 
  if (usernameValue.trim() !== "" && passwordValue.trim() !== "") {
    submitButton.disabled = false;
  } else {
    submitButton.disabled = true;
  } 
} 
mostrapassword.addEventListener("click", (()=>{
	check = !check
	if (check){
		password.type = "text";
	}else{
		password.type = "password";
	}
}))