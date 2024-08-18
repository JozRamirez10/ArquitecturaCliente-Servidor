#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

/* Exec
* El proceso actual termina inmediatamente y comienza a ejecutar
* el nuevo programa desde el inicio, asumiendo que exec() no encontró
* ningún error
*/


int main(void){
    char *args[] = {"/bin/ls", NULL};
    if(execve("bin/ls", args, NULL) == -1){
        perror("execve");
        exit(EXIT_FAILURE);
    }
    puts("shouldn't get here");
    exit(EXIT_SUCCESS);
}