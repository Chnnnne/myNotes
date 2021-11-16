const myForm = document.querySelector('#my-form');
const nameInput= document.querySelector("#name");
const emailInput= document.querySelector("#email");
const msg= document.querySelector(".msg");
const userList= document.querySelector("#users");


//监听表单的提交事件
myForm.addEventListener('submit',onSubmit);

function onSubmit(e) {
    e.preventDefault();
    if(nameInput.value === '' ||emailInput.value ===''){
        // alert('Plz enter all the fields');
        msg.classList.add('error');
        msg.innerHTML='Plz enter all firlds';

        setTimeout(()=>msg.remove(),2000);
    }else{
        const li =document.createElement('li');
        li.appendChild(document.createTextNode(
            `${nameInput.value} : ${emailInput.value} `
        ));
        userList.appendChild(li);

        //clear fileds
        nameInput.value='';
        emailInput.value='';
    }
}