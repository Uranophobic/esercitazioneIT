const usernameInput = document.getElementById("username");
const passwordInput = document.getElementById("password");
const submitButton = document.getElementById("submit");
submitButton.disabled=true;
usernameInput.addEventListener("input", buttonisDisabled);
passwordInput.addEventListener("input", buttonisDisabled);

function buttonisDisabled() {
  const usernameValue = usernameInput.value;
  const passwordValue = passwordInput.value;

  if (usernameValue.trim() !== "" && passwordValue.trim() !== "") {
    submitButton.disabled = false;
  } else {
    submitButton.disabled = true;
  }
}