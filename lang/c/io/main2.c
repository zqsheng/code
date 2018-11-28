#include<stdio.h>

int main()
{
   FILE *fp = fopen("/home/zqsheng/code/code/c/io/test.txt","r");
   char buff[255];
   fscanf(fp,"%s",buff);
   printf("1:%s\n",buff);

   fgets(buff, 255, (FILE*)fp);
   printf("2: %s\n", buff );
   
   fgets(buff, 255, (FILE*)fp);
   printf("3: %s\n", buff );
   fclose(fp);

}
