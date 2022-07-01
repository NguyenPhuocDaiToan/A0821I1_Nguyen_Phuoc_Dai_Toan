// Xây dựng ứng dụng hiển thị một dãy số fibonacci và tính tổng các số đó
// In ra n số fibonacy

// Recursive
function fibonacy(n) {
    if (n == 1 || n == 2)   return 1;
    return fibonacy(n - 1) + fibonacy(n - 2);
}
for (var i = 1; i <= 10; i++)
    console.log(fibonacy(i));

// Dynamic planning algorithm
var x = 1, y = 1, z;
var n = 10;
if (n == 1)         console.log(1);
else if (n == 2)    console.log("1 1");
else {
    for (var i = 1; i <= 10; i++) {
        console.log(x + " ");
        z = x + y;
        x = y;
        y = z;
    }
}
