/**
 *    author:  vinhntse160258
 *    created: 15.09.2021
**/
///----------------------------------------------
#include<stdio.h>
///---------------------------------------------- bai 4 ----------------------------------------------///
int n;
unsigned long s=0;
///----------------------------------------------
int tinh(){
      for(int i = 1; i <= n; i ++) s += (i & 1 ? i * (-1) : i);
      return s;
}
///----------------------------------------------
int tinh2(){
      return (n % 2 == 0 ? n / 2 : (n + 1) / 2 * -1);
}
///----------------------------------------------
int main(){
      printf("Nhap mot so nguyen n: ");
      scanf("%d", &n);
      printf("S = -1 + 2 - 3 + 4 - 5 + ... + n = %ld\n", tinh());
      //printf("S = -1 + 2 - 3 + 4 - 5 + ... + n = %ld\n", tinh2());
}
