function fibonacy(n) {
    if (n == 1 || n == 2)
        return 1;
    return fibonacy(n - 1) + fibonacy(n - 2);
}
for (let i = 1; i <= 10; i++)
    console.log(fibonacy(i));
let x = 1, y = 1, z;
let n = 10;
if (n == 1)
    console.log(1);
else if (n == 2)
    console.log("1 1");
else
    for (let i = 1; i <= 10; i++) {
        console.log(x + " ");
        z = x + y;
        x = y;
        y = z;
    }
//# sourceMappingURL=fibonacy.js.map