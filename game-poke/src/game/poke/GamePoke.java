
package game.poke;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class pkmn
{

String name;
String type;
    int hp;
    int cp;
boolean catchstatus;
    public pkmn(String n,String t,int h,int c)
{this.name=n;
this.type=t;
this.hp=h;
this.cp=c;
}
}

class evolve extends pkmn
{
public evolve(String n, String t, int h, int c) {
        super(n, t, h, c);
        hp=hp+10;
        cp=cp+10;
    }
}



public class GamePoke {
final static int[] a= new int[10];
 static int balls=20;
 static int count=0;
 static int poke=0;
 static int plhp;
 static int ghp;
 static String gp;
 static int candies=0;
  static int catchem()
{poke = ThreadLocalRandom.current().nextInt(0,10); 
    

if(a[poke]!=0)
{while(a[poke]==1)
    poke=ThreadLocalRandom.current().nextInt(0,10);
}
if((poke==0)||(poke==1)||(poke==2)||(poke==2)||(poke==3)||(poke==4)||(poke==5)||(poke==6)||(poke==7)||(poke==8)||(poke==9))
{System.out.println("A wild pokemon has appeared!!!");
    for(int x=0;;x++)
{System.out.println("pokeballs left - "+balls);
if(balls==0)
    break;
    System.out.println("choose 1.throw pokeball 2.run");
Scanner s= new Scanner(System.in);
int option=s.nextInt();
if(option==1)
{int n = ThreadLocalRandom.current().nextInt(0,3); 
if(n==1)
{   System.out.println("beep beep beeeeeep!!!!");
    System.out.println("caught");
balls--;
a[poke]=1;
count=0;
for(int i=0;i<10;i++)
{if(a[i]==1)
    count++;
    }
if(count>10)
{cls();
    System.out.println("you've caught'em all!!");   
System.out.println("Go challenge the gymleader!!");}
return poke;
}

else
{ System.out.println("beep beep bwaaaaaam!!!!");
    System.out.println("you had almost caught it");
balls--;}}
else if(option==2)
{ System.out.println("ran away successfully");
cls();
break;}
}
}

return 10;}
 
 static int gattack(int atk)
 {System.out.println("Gym Leader's pokemon attacked!!");
  plhp=plhp-atk;
  System.out.println("Player's pokemon hp-"+plhp);
  if(plhp<=0)
    {System.out.println("you lost");
     return 1;   }
  else
      return 0;
 }
 
 static int pattack(int atk) 
 {
     System.out.println("Your Attack was successful!!");
     ghp=ghp-atk;
     System.out.println("Gym leader's pokemon hp-"+ghp);
  if(ghp<=0)
    {System.out.println("you won");
    return 1;}   
  else
      return 0;
 }
 
  static void fight(String gympoke,int hp,int php,String tpoke,String t,String ptype,String gtype)
{int n=0,chance = 0,gval=0,pval=0,pattack=0,gattack=0;
if(ptype==gtype) 
{pattack=php/10;
gattack=hp/10;}
else if(((ptype=="fire")&&(gtype=="grass"))||((ptype=="water")&&(gtype=="fire"))||((ptype=="grass")&&(gtype=="water")))
{pattack=php/5;
gattack=hp/10;}
else
{pattack=php/10;
gattack=hp/5;}    
 ghp=hp;
 plhp=php;
    System.out.println("you're up against the gym leader!!");
    System.out.println("gymn leader chooses "+gympoke);
    System.out.println(t+" chooses "+tpoke);
    System.out.println("both pokemons are at 50hp!");
    for(int i=0;;i++)
    {
        {System.out.println("choose what your pokemon does");
        System.out.println("1.attack 2.dodge");
        Scanner decision=new Scanner(System.in);
        int dec=decision.nextInt();
        if(dec==1)
        {chance=ThreadLocalRandom.current().nextInt(0,6);
          if((chance==0)||(chance==2)||(chance==4)) 
          {pval=pattack(pattack);
          if(pval==1)
          {  System.out.println("congratulations you defeated the gymleader!!");
          break;}}
          else if(chance==5)
                System.out.println("your pokemon attacked but it missed it's attack completely");
          else
          { System.out.println("your pokemon attacked!!");  
              System.out.println("but the gym leader's pokemon dodged it successfully!!");
          dec=2;}
        }        
        else
        {if(dec==2)
            chance=ThreadLocalRandom.current().nextInt(0,5);
          if((chance==0)||(chance==2)||(chance==4)) 
          {   System.out.println("gym leader's pokemon attacked!!!");
              System.out.println("your pokemon dodged successfully!!!");
          }
          else
          {System.out.println("dodge failed!!!");
           gval=gattack(gattack);
            if(gval==1)
          {  System.out.println("you were defeated by the gymleader better luck nex time!!");
          break;}
          }}
        cls();
        if(dec!=2)
        {n=ThreadLocalRandom.current().nextInt(0,4);
        if(n==1)
                System.out.println("gym leader's pokemon attacked but it has misssed it's target!!");
        else
            gval=gattack(gattack);}
        if(gval==1)
          {  System.out.println("you were defeated by the gymleader better luck next time!!");
          break;}
        }
}}
 
 
 private static void cls()
    {for(int i=0;i<3;i++)
    System.out.println("\b");
    }
    
 private static String startscreen()
    {System.out.println("Welcome to Pokemon Go!!!");
    System.out.println("enter your name trainer!!");
    Scanner s = new Scanner(System.in);
    String name=s.next();
        System.out.println("Hello "+name+"! Nice to meet you! Here you're to catch 'em all!!!!!");
        System.out.println("You've been provided by 100 pokeballs! make good use of them!");
    
    return name;}
    
    public static void main(String[] args) {
 String name=startscreen();
 int count,choose=0;
       cls();
       pkmn gym1poke[]=new pkmn[3];
       gym1poke[0]=new pkmn("blastoise","water",50,50);
       gym1poke[1]=new pkmn("charizard","fire",50,50);
       gym1poke[2]=new pkmn("venasaur","grass",50,50);
       
       pkmn pokemon[]=new pkmn[10];
           pokemon[0]=new pkmn("charmander","fire",50,50);
           pokemon[1]=new pkmn("bulbasaur","grass",50,50);
           pokemon[2]=new pkmn("squirtle","water",50,50);
           pokemon[3]=new pkmn("torchic","fire",50,50);
           pokemon[4]=new pkmn("treecko","grass",50,50);
           pokemon[5]=new pkmn("mudkip","water",50,50);
           pokemon[6]=new pkmn("cyndaquil","fire",50,50);
           pokemon[7]=new pkmn("totodile","water",50,50);
           pokemon[8]=new pkmn("chikorita","grass",50,50);
           pokemon[9]=new pkmn("piplup","water",50,50);
          
          
          evolve p[]=new evolve[10];
p[0]=new evolve("prinplup","water",50,50);
p[1]=new evolve("croconaw","water",50,50);
p[2]=new evolve("wartortle","water",50,50);
p[3]=new evolve("marshtomp","water",50,50);
p[4]=new evolve("quilava","fire",50,50);
p[5]=new evolve("charmaleon","fire",50,50);
p[6]=new evolve("combusken","fire",50,50);
p[7]=new evolve("grovyle","green",50,50);
p[8]=new evolve("ivysaur","green",50,50);
p[9]=new evolve("bayleaf","fire",50,50);
          
 for(int i=0;;i++)          
 {int n=0;
    System.out.println("Choose what to do");
    System.out.println("You have "+balls+" pokeballs left");
     System.out.println("you have "+candies+" candies");
    System.out.println("1.catch pokemon 2.challenge gym 3.evolve pokemon 4.exit");
Scanner s= new Scanner(System.in);
int option=s.nextInt();
if(option==1)
{count=0;
    for(int z=0;z<10;z++)
    if(a[z]!=0)
        count++;
    if(count<10)
    {if(balls>0)
    {  n=catchem();
if(n==0)
      {pokemon[0].catchstatus=true;
           System.out.println("you caught a charmander");
           candies=candies+3;
      cls();}
      else if(n==1)
      { pokemon[1].catchstatus=true;
          System.out.println("you caught a bulbasaur");
           candies=candies+3;
      cls();
      }
      else if(n==2)
      {  pokemon[2].catchstatus=true;  
          System.out.println("you caught a squirtle");
           candies=candies+3;
      cls();}
      else if(n==3)
      {  pokemon[3].catchstatus=true;  
          System.out.println("you caught a torchic");
           candies=candies+3;
      cls();}
      else if(n==4)
      {  pokemon[4].catchstatus=true;  
          System.out.println("you caught a treecko");
           candies=candies+3;
      cls();}
      else if(n==5)
      {  pokemon[5].catchstatus=true;  
          System.out.println("you caught a mudkip");
           candies=candies+3;
      cls();}
      else if(n==6)
      {  pokemon[6].catchstatus=true;  
          System.out.println("you caught a cyndaquil");
           candies=candies+3;
      cls();}
      else if(n==7)
      {  pokemon[7].catchstatus=true;  
          System.out.println("you caught a totodile");
           candies=candies+3;
      cls();}
      else if(n==8)
      {  pokemon[8].catchstatus=true;  
          System.out.println("you caught a chikorita");
           candies=candies+3;
      cls();}
      else if(n==9)
      {  pokemon[9].catchstatus=true;  
          System.out.println("you caught a piplup");
           candies=candies+3;
      cls();}
      
      else 
            System.out.println("no balls left");}

}else 
{System.out.println("you've caught all pokemon");}
    
}

else if(option==3)
{if(candies>10)
{
    System.out.println("choose which pokemon to evolve");
for(int b=0;b<10;b++)
{if(pokemon[b].catchstatus==true)
    {
        System.out.println(pokemon[b].name+" type-"+pokemon[b].type+" hp-"+pokemon[b].hp);
    }
}
Scanner scan = new Scanner(System.in);
    String evolve=scan.next();
   
    if(null != evolve)
     switch (evolve) {
         case "piplup":
             pokemon[9].catchstatus=false;
             p[0].catchstatus=true;
             System.out.println("congrats your piplup evolved into prinplup");
             break;
         case "totodile":
             pokemon[7].catchstatus=false;
             p[1].catchstatus=true;
             System.out.println("congrats your totodile evolved into croconaw");
             break;
         case "squirtle":
             pokemon[2].catchstatus=false;
             p[2].catchstatus=true;
             System.out.println("congrats your squirtle evolved into wartortle");
             break;
         case "mudkip":
             pokemon[5].catchstatus=false;
             p[3].catchstatus=true;
             System.out.println("congrats your mudkip evolved into marshtomp");
             break;
         case "cyndaquil":
             pokemon[6].catchstatus=false;
             p[4].catchstatus=true;
             System.out.println("congrats your cyndaquil evolved into quilava");
             break;
         case "charmander":
             pokemon[0].catchstatus=false;
             p[5].catchstatus=true;
             System.out.println("congrats your charmander evolved into charmaleon");
             break;
         case "torchic":
             pokemon[3].catchstatus=false;
             p[6].catchstatus=true;
             System.out.println("congrats your torchic evolved into combusken");
             break;
         case "treecko":
             pokemon[4].catchstatus=false;
             p[7].catchstatus=true;
             System.out.println("congrats your treecko evolved into grovyle");
             break;
         case "bulbasaur":
             pokemon[1].catchstatus=false;
             p[8].catchstatus=true;
             System.out.println("congrats your bulbasaur evolved into ivysaur");
             break;
         case "chikorita":
             pokemon[8].catchstatus=false;
             p[9].catchstatus=true;
             System.out.println("congrats your chikorita evolved into bayleaf");
             break;
         default:
             break;
     }    
      candies=candies-10;  
}    
else 
        System.out.println("insufficient candies!!!! please catch more pokemon to gain more candies and then you can evolve your pokemon");
    cls();
}

else if(option==2)
{
    System.out.println("choose one of your pokemon");
    for(int e=0;e<10;e++)
    {
    if(p[e].catchstatus==true)
    {
        System.out.println(p[e].name+" type-"+p[e].type+" hp-"+p[e].hp);
    } 
        if(pokemon[e].catchstatus==true)
    {
        System.out.println(pokemon[e].name+" type-"+pokemon[e].type+" hp-"+pokemon[e].hp);
    }
      
        
    }
    System.out.println("enter the name of your pokemon to call it out of it's pokeball!!!");
     Scanner pokename = new Scanner(System.in);
    String pname=pokename.next();
    cls();
    for(int j=0;j<10;j++)
    if(pokemon[j].name.equals(pname))    
    { choose=ThreadLocalRandom.current().nextInt(0,3);  
    fight(gym1poke[choose].name,gym1poke[choose].hp,pokemon[j].hp,pokemon[j].name,name,pokemon[j].type,gym1poke[choose].type);
    }
    else if(p[j].name.equals(pname))
    fight(gym1poke[choose].name,gym1poke[choose].hp,p[j].hp,p[j].name,name,p[j].type,gym1poke[choose].type);   
    cls();
}

else if(option==4)
{System.out.println("thanks for playing hope you liked the game!!! ");
    System.exit(0);
 }}          
    }
    
    
}

  