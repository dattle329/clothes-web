function handleLogin() {
    var usernameInput = document.getElementById('username').value;
    var passwordInput = document.getElementById('password').value;
  
    var url = 'http://localhost:8080/api/v1/login';
  
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Basic ' + btoa(`${usernameInput}:${passwordInput}`)
        },
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Invalid username or password');
        }
        return response.json();
    })
    .then(data => {
        var accountLogin = {
            id: data.id,
            username: data.username,
            password: passwordInput,
            email: data.email
        };
        localStorage.setItem('accountLogin', JSON.stringify(accountLogin));

        alert('Đăng nhập thành công!');
        window.open('../html/index.html', '_self');
    })
    .catch(error => {
        document.getElementById('wr-info').innerText = 'sai thông tin đăng nhập';
        document.getElementById('wr-info').style.color = 'red';
    });
  }

  
  


