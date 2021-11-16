console.error("this is an error")
console.log("this is log")
let b=1111
b=2222
console.log("b is  "+b)

const namee='wangchen';
const hello1=`my name is ${namee}`
console.log(hello1)

const t=1;
console.log(t+"\n\n\n\n");

const fruits=[11,22,33];
fruits.push(44);
fruits[0]=0;
console.log(fruits+'\n\n\n\n\n');

const person = {
    firstName:'John',
    lastName:'Doe',
    age:30,
    hobbies:['music','basketball','soccer'],
    address:{
        street:'50 Rd st',
        city:'Boston',
        state:'MA'
    }
}
console.log(person);
console.log(person.firstName);
console.log(person.hobbies[0]);



//function
console.log('\n\n\n\n\n\n\n')
function addNums(num1,num2){
    console.log(`the sum of num1 and num2 is  ${num1+num2}`);
}

addNums(1,2);//the sum of num1 and num2 is  3
addNums();//the sum of num1 and num2 is  NaN

const addNums1 = (num1,num2)=>{
    console.log(`the sum of num1 and num2 is  ${num1+num2}`);
}
const addNums2 = (num1 =1,num2=3)=>{
    return num1+num2;
}
//函数体只有一行，可省略{}
const addNums3 = (num1,num2)=>console.log(`the sum of num1 and num2 is  ${num1+num2}`);
const addNums4 = (num1,num2)=>num1+num2;//可省略return

const addNums5 = num1 => num1+5;//当只有一个参数时，可去掉()，但是不能有初始参数值

