#include<stdio.h>

enum DAY
{
    MON = 1,TUE,WEB,THU,FRI,SAT,SUN
} day;
enum 
{
    BLACK,RED = 7,GREEN,YELLOW
} color;
int main()
{
    for (day = MON; day <= SUN; day ++){
        printf("element of day enum:%d \n",day);
    } 
    
    for (color = BLACK; color <= YELLOW; color ++){
           printf("element of color enum:%d \n",color);
    }
    return 0;
}