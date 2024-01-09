const BASE_URL = "http://localhost:8080"
const formId = document.getElementById("id");
const formNameProd = document.getElementById("nameProd");
const formImgProd = document.getElementById("imgProd");
const formPriceProd = document.getElementById("priceProd");
const formQuantity = document.getElementById("quantity");


const form = document.getElementById("product-create-form")
const tbody = document.getElementById("products")

form.addEventListener("submit", async function (e){
    e.preventDefault();
    // await createOrUpdate();
    findAll();
    await create();
    this.reset();
})

findAll();


        var accountLocalStorage = JSON.parse(localStorage.getItem("accountLogin"));
        var userLo = accountLocalStorage.username;
        var passLo = accountLocalStorage.password;
    // async function createOrUpdate(){
    //     const id = formId.value;
    //     const url = id ? `${BASE_URL}/api/v1/product/${id}` : `${BASE_URL}/api/v1/product`
    //     const method = id ? "PUT" : "POST"
    //     const response = await fetch(url, {
    //         method: method,
    //         headers: {
    //             "Content-Type": "application/json",
    //             "Authorization": "Basic " + btoa(`${userLo}:${passLo}`)
    //         },
    //         body: JSON.stringify({
    //             name: formNameProd.value,
    //             img: formImgProd.value,
    //             price: formPriceProd.value
    //         })
    //     });
    //     const body = await response.json();
    //     console.log(body);
    // }
async function create(userId, productId){
    var userId = accountLocalStorage.id;
    var productId = formId.value;
    const response = await fetch(`${BASE_URL}/api/v1/user/${userId}/product/${productId}/order`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Basic " + btoa(`${userLo}:${passLo}`)
        },
        body: JSON.stringify({
            quantity: formQuantity.value
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
        btnEdit.classList.add("fa-solid", "fa-plus");
        btnEdit.addEventListener("click", function(){
            formId.value = product.id;
            formNameProd.value = product.name;
            formImgProd.value = product.img;
            formPriceProd.value = product.price;
        })

        
        row.insertCell().append(btnEdit);

        const quantityCell = row.insertCell(); // Thêm cột "Quantity" mới
        const quantityInput = document.createElement("input");
        quantityInput.type = "number";
        quantityInput.value = 0;
        quantityInput.min = 0;
        quantityCell.appendChild(quantityInput);


        const totalPriceCell = row.insertCell();
        const totalPriceInput = document.createElement("input");
        totalPriceInput.type = "text";
        totalPriceInput.readOnly = true;
        totalPriceCell.appendChild(totalPriceInput);

        quantityInput.addEventListener("input", function () {
            const quantityValue = quantityInput.value;
            if (!isNaN(quantityValue) && quantityValue >= 0) {
                const totalPriceValue = price * quantityValue;
                totalPriceInput.value = totalPriceValue;
            }
        });
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

