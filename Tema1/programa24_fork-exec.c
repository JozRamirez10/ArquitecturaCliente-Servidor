#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

// Esta funcion engendra al proceso hijo
// program: programa a ejecutar
// arg_list: lista de argumentos para la ejecucion del proceso hijo
int spawn (char* program, char** arg_list)
{
 // Variable del proceso hijo
 pid_t child_pid;
 child_pid = fork(); // Con el fork creamos el proceso hijo
 if (child_pid != 0) // El padre entra en este if
  return child_pid; // El padre regresa a la funcion principal
 else // El proceso hijo entra aqui
 {
  // RECUERDEN: Si execvp() se ejecuta exitosamente
  // el proceso "parent" termina en ese momento,
  // pero termina con exito
  execvp (program, arg_list); // El proceso hijo es remplazado por execvp
    // Si el proceso se ejecuta correctamente, hasta aqui llega la funcion
  printf ("ocurrio un error al ejecutar execvp(...)\n");
  // alternativa al printf:
  // fprintf (stderr, "ocurrio un error al ejecutar execvp(...)\\n");
  return 1; // termina con error
 }
}

// Funcion principal
int main ()
{
  // Lista de argumentos para la ejecucion de execvp
  char* arg_list[] = {
   "ls",
   "-l",
   "/",
   NULL
  };

  // Llama a la funcion para engendrar un hijo y ejecutar un proceso
  spawn ("ls", arg_list);
  printf ("Termina el proceso padre\n"); // Solo el padre llega a esta linea
  return 0; // Termina con exito
}