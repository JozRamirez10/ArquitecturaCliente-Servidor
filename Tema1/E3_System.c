#include <stdlib.h>

/* System
* Invoca un programa con los privilegios de root
* usando la función System
* Depende de la versión shell que ocupe
*/

int main(){
    int return_value;
    
    // Ejecución de comando ls -l para el directorio raíz
    return_value = system("ls -l /");
    
    return return_value;
}