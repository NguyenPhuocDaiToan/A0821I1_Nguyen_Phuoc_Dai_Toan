// import {Rectangle} from "./rectangle";
// const rectangle = new Rectangle(5, 5, 10, 20);
// console.log(rectangle.toString());
// console.log(rectangle.area());

let money = 10000;
const buyACar = (car: string) => {
    return new Promise(((resolve, reject) => {
        setTimeout(() => {
            if (money >= 10000) {
                resolve("can buy " + car);
            } else {
                reject("Do not enough money");
            }
        }, 100);
    }));
}

money = 1000001;
const promise = buyACar("Vinfast").then(value => {
    console.log(value);
}, error => {
    console.log(error);
})