#include<stdio.h>
#include<netdb.h>
#include<arpa/inet.h>
#include<netinet/ip_icmp.h>
int main(int argc,char *argv[])
{
    struct protoent *protocol;
    printf("%d\n",argc);
    printf("%s,%s\n",argv[0],argv[1]);
    
    protocol = getprotobyname("icmp");
    printf("%s\n",protocol->p_name);

   int sockicmp = socket(PF_INET,SOCK_RAW,protocol->p_proto); 
   
   struct icmp *pIcmp;
   
   pIcmp->icmp_type = ICMP_ECHO;
   pIcmp->icmp_code = 0;
   pIcmp->icmp_cksum = 0;
   
   


}