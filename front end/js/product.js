const BASE_URL = "http://localhost:8080"
const formId = document.getElementById("id");
const formNameProd = document.getElementById("nameProd");
const formImgProd = document.getElementById("imgProd");
const formPriceProd = document.getElementById("priceProd");


const form = document.getElementById("product-create-form")
const tbody = document.getElementById("products")

form.addEventListener("submit", async function (e){
    e.preventDefault();
    await createOrUpdate();
    findAll();
    this.reset();
})

findAll();


var accountLocalStorage = JSON.parse(localStorage.getItem("accountLogin"));
    var userLo = accountLocalStorage.username;
    var passLo = accountLocalStorage.password;
async function createOrUpdate(){
    const id = formId.value;
    const url = id ? `${BASE_URL}/api/v1/product/${id}` : `${BASE_URL}/api/v1/product`
    const method = id ? "PUT" : "POST"
    const response = await fetch(url, {
        method: method,
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Basic " + btoa(`${userLo}:${passLo}`)
        },
        body: JSON.stringify({
            name: formNameProd.value,
            img: formImgProd.value,
            price: formPriceProd.value
        })
    });
    const body = await response.json();
    console.log(body);
}


async function findAll(){
    const response = await fetch(`${BASE_URL}/api/v1/products`,{
        method: "GET",
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Basic " + btoa(`${userLo}:${passLo}`)
            }
        });
    const body = await response.json();
    console.log(body);
    showAllProducts(body.content);
}

async function showAllProducts(products){
    tbody.innerHTML = "";
    for(const product of products){
        const row = tbody.insertRow();

        const id = product.id;
        row.insertCell().innerText = id;

        const name = document.createTextNode(product.name)
        row.insertCell().appendChild(name);

    
        const img = document.createElement("img");
        img.src = product.img;
        row.insertCell().appendChild(img);


        const price = product.price;
        row.insertCell().innerText = price;


        const btnEdit = document.createElement("button")
        btnEdit.classList.add("fa-solid", "fa-pen-to-square");
        btnEdit.addEventListener("click", function(){
            formId.value = product.id;
            formNameProd.value = product.name;
            formImgProd.value = product.img;
            formPriceProd.value = product.price;
        })

        const btnDelete = document.createElement("button")
        btnDelete.classList.add("fa-solid", "fa-trash");
        btnDelete.addEventListener("click",async function(){
            const confirmed = confirm("Do u wanna delete?")
            if(confirmed){
               await deleteById(product.id);
               tbody.removeChild(row);
            }
        });
        row.insertCell().append(btnEdit, btnDelete);

    }
}

document.addEventListener('DOMContentLoaded', function () {
    findAll();
});



async function deleteById(id){
    const response = await fetch(`${BASE_URL}/api/v1/product/${id}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Basic " + btoa(`${userLo}:${passLo}`)
        }
    });

}

