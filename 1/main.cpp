#include <iostream>
#include <cmath>

using namespace std;

bool isPrime(int x);

int main(void) {
    int sum = 0;
    for (int i = 2; i < 3000; i++)
        if (isPrime(i))
            sum += i;
    cout << sum << endl;
    return 0;
}

bool isPrime(int x) {
    for (int i = 2; i <= (int) sqrt(x); i++)
        if (x % i == 0)
            return false;
    return true;
}
