
#include<sys/types.h>
#include<sys/socket.h>
#include<stdio.h>
#include<string.h>
#include<arpa/inet.h>

#define PORT 9999
#define SIZE 1024

int Create_Socket()
{
    int listen_socket = socket(AF_INET,SOCK_STREAM,0);// 
    if(listen_socket == -1)
    {
        perror("socket");
    }
    struct sockaddr_in addr;
    memset(&addr,0,sizeof(addr));
    addr.sin_family = AF_INET;
    addr.sin_port = htons(PORT);
    addr.sin_addr.s_addr = htonl(INADDR_ANY);

    int ret = bind(listen_socket,(struct sockaddr *)&addr,sizeof(addr));
    if(ret == -1)
    {
        perror("bind");
        return -1;
    }
    ret = listen(listen_socket,5);
    if(ret == -1)
    {
        perror("listen");
        return -1;
    }
    return listen_socket;
}
int awit_client(int listen_socket)
{
    struct sockaddr_in cliaddr;
    int addrlen = sizeof(cliaddr);
    printf("awit client connecting ....\n");
    int clinet_sockent = accept(listen_socket,(struct sockaddr *)&cliaddr,&addrlen);
    if(clinet_sockent == -1)
    {
        perror("accept");
        return -1;
    }
    printf("success receive client socket message %s \n",inet_netof(cliaddr.sin_addr));
    return clinet_sockent;
}
void handle_client(int listen_socket,int clinet_sockent)
{
    char buf[SIZE];
    while(1)
    {
        int ret = read(clinet_sockent,buf,SIZE - 1);
        if(ret == -1)
        {
            perror("read");
            break;
        }
        if(ret == 0)
        {
            break;
        }
        buf[ret] = '\0';
        int i;
        for(i = 0;i < ret;i++)
        {
            buf[i] = buf[i] + 'A' - 'a';
        }
        printf("%s\n",buf);
        write(clinet_sockent,buf,ret);
        if(strncmp(buf,"end",3) == 0){
            break;
        }
    }
    close(clinet_sockent);
}

int main()
{
    int listen_socket = Create_Socket();
    int clinet_sockent = awit_client(listen_socket);
    handle_client(listen_socket,clinet_sockent);
    close(listen_socket);
    return 0;
}