#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

int main(void){
    char envval[] = {"MYPATH=/user/local/someapp/bin"};
    if(putenv(envval))
        puts("putenv failed");
    else
        puts("putenv succeeded");

    if(getenv("MYPATH"))
        printf("MYPAHT=%s\n", getenv("MYPATH"));
    else  
        puts("MYPATH unassigned");

    if(getenv("YOURPATH"))
        printf("YOURPATH=%s\n", getenv("YOURPATH"));
    else
        puts("YOURPATH unassigned");
    
    exit(EXIT_SUCCESS);
}