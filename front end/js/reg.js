const BASE_URL = "http://localhost:8080"
const formUsername = document.getElementById("username")
const formPassword = document.getElementById("password")
const formFullName = document.getElementById("name")
const formEmail = document.getElementById("email")

const form = document.getElementById("user-create-form")


function create(){
    fetch(`${BASE_URL}/api/v1/user`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            username: formUsername.value,
            password: formPassword.value,
            name: formFullName.value,
            email: formEmail.value
        })
    }).then(response => {
        if (!response.ok) {
            throw new Error('Invalid username or password');
        }
        return response.json();
    })
    .then(data => {
        alert('Đăng ký thành công!');
        window.open('../html/login.html', '_self');
    });
    
}