/**
 *    author:  vinhntse160258
 *    created: 15.09.2021
**/
///----------------------------------------------
#include<stdio.h>
///---------------------------------------------- bai 2 ----------------------------------------------///
int n;
unsigned long s=1;
///----------------------------------------------
int tinh(){

      return s;
}
///----------------------------------------------
int main(){
    scanf("%d", &n);
    n--;
    for(int i = 1; i <= n; i ++) s *= i;
    printf("%ld\n", s);
}
