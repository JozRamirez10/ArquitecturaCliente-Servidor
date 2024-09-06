{\rtf1\ansi\ansicpg1252\cocoartf2639
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fmodern\fcharset0 Courier;}
{\colortbl;\red255\green255\blue255;\red255\green255\blue255;}
{\*\expandedcolortbl;;\cssrgb\c100000\c100000\c100000;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs26 \cf0 \expnd0\expndtw0\kerning0
#include <stdio.h>\
#include <stdlib.h>\
#include <sys/types.h>\
#include <unistd.h>\
\
int spawn (char* program, char** arg_list)\
\{\
 pid_t child_pid;\
 child_pid = fork ();\
 if (child_pid != 0)\
  return child_pid;\
 else\
 \{\
  // RECUERDEN: Si execvp() se ejecuta exitosamente\
  // el proceso "parent" termina en ese momento,\
  // pero termina con exito\
  execvp (program, arg_list);\
  printf ("ocurrio un error al ejecutar execvp(...)\\n");\
  // alternativa al printf:\
  // fprintf (stderr, "ocurrio un error al ejecutar execvp(...)\\n");\
  return 1; // termina con error\
 \}\
\}\
\
int main ()\
\{\
  char* arg_list[] = \{\
   "ls",\
   "-l",\
   "/",\
   NULL\
  \};\
\
  spawn ("ls", arg_list);\
  printf ("Termina el proceso padre\\n");\
  return 0; // Termina con exito\
\}}