/* Este programa puede marcar aviso (warning) o error al compilar 
ya que sys_nerr y sys_errlist estan desaprobados o descontinuados
La alternativa es el programa05 */

#include <stdio.h>

int main()
{
  int i;

  for(i=0; i < sys_nerr; i++)
  {
    printf( "%d: %s\n", i , sys_errlist[i] );
  }
  return 0;
}