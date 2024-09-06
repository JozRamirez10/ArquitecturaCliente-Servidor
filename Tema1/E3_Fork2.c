#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

int main(void){
    pid_t child;
    if(child = fork() == -1 ){
        perror("fork");
        exit(EXIT_FAILURE);
    }else if(child == 0){
        puts("In child");
        printf("\tchild pid = %d\n", getpid());
        printf("\tchild ppid = %d\n", getppid());
        exit(EXIT_SUCCESS);
    }else{
        puts("In parent");
        printf("\tparend pid = %d\n", getpid());
        printf("\tparend ppid = %d\n", getppid());
    }
    exit(EXIT_SUCCESS);
}