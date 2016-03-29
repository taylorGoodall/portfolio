#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>
#include <sys/types.h>
#include <time.h> 
void info() {
    int port1 = 5000;
    printf("\nStarting Server.....\n");
    printf("---------------------------------------------------------------------\n");
    printf("|Port Is %d\n                                                        \n",port1);
    printf("|Ip Adress is: 127.0.0.1                                             \n");
    printf("---------------------------------------------------------------------\n");
}
int main(int argc, char *argv[])
{
    info();
    
    int listenfd = 0, connfd = 0;
    struct sockaddr_in serv_addr; 

    char sendBuff[1025];
    time_t ticks; 

    listenfd = socket(AF_INET, SOCK_STREAM, 0);
    memset(&serv_addr, '0', sizeof(serv_addr));
    memset(sendBuff, '0', sizeof(sendBuff)); 
//AF_INET
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);
    serv_addr.sin_port = htons(5000); 

    bind(listenfd, (struct sockaddr*)&serv_addr, sizeof(serv_addr));

    listen(listenfd, 10);
   

    while(1)
    {
        connfd = accept(listenfd, (struct sockaddr*)NULL, NULL); 

        ticks = time(NULL);
        snprintf(sendBuff, sizeof(sendBuff), "<html><b>Hello Taylor, The time is</b></br></center></html>%.24s\r\n",ctime(&ticks));

        write(connfd, sendBuff, strlen(sendBuff));
                snprintf(sendBuff, sizeof(sendBuff), "<html></br>Hi</br>");

        write(connfd, sendBuff, strlen(sendBuff));

        printf("Client Connected");
        close(connfd);
        sleep(1);
     }
}