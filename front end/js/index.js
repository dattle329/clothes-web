showUsernameOnHomePage();

function search() {
    let filter = document.getElementById('search').value.toUpperCase();
    let item = document.querySelectorAll('.item');
    let l = document.getElementsByTagName('h5');
    for(var i = 0;i<=l.length;i++){
    let a=item[i].getElementsByTagName('h5')[0];
    let value=a.innerHTML || a.innerText || a.textContent;
    if(value.toUpperCase().indexOf(filter) > -1) {
    item[i].style.display="";
    }
    else
    {
    item[i].style.display="none";
    }
    }
    }
 
    function logout(){
        localStorage.removeItem('accountLogin');
        window.open('../html/login.html', '_self');
    }

    function showUsernameOnHomePage() {
        var accountLocalStorage = JSON.parse(localStorage.getItem("accountLogin"));
        var username = accountLocalStorage.username;
    
        if (username) {
    
            document.getElementById('username-display').innerText = 'Welcome, ' + username + '!';
        } else {
            window.open('../html/login.html', '_self');
        }
    }

