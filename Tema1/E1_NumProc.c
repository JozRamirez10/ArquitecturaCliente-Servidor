#include <stdio.h>
#include <unistd.h> // Declara funciones que son parte del éstandar POSIX

int main(){
    // ID del proceso
    printf("The process ID is %d\n", getpid());
    
    // ID del proceso padre
    printf("The parent process ID is %d\n", (int)getppid());
    return 0;
}