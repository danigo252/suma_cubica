import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main
{
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);               //Se crea un scanner con la variable in
        List<Integer> list = new ArrayList<Integer>(); //Se crea un Array list de longitud variable de enteros
        int T = in.nextInt();                                                   // Se declara T como el numero de veces que se van a realizar calculos
        for (int i = 0; i < T; i++)                                             //Ciclo For para T
        {
            list.clear();                                                             //Metodo .clear() para limpiar la lista antes de empezar
            int N = in.nextInt();                                             // Declaracion de variable N = [N][N][N]
            int O = in.nextInt();                                             // Declaracion de variable O = operaciones
            long arr[][][] = new long[N][N][N];                //Declaracion de variable array = arr[][][], dentro de los indices va N arr[N][N][N]
            for (int o = 0; o < O; o++) {                                 //Ciclo for para O
                String str = in.next();                                     //Scanner in en el String str
                if (str.equals("UPDATE"))                            //Ejecuta If el caso de que la variable sea str sea igual a String
                {
                    update(arr,in.nextInt(),in.nextInt(),in.nextInt(),in.nextLong(),list);  // Se ejecuta metodo update con los para parametros definidos
                } else {
                    querry(arr,in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),list); // Se ejecuta metodo querry con los parametros definidos
                           }
            }
        }
    }

    public static void update(long arr[][][],int i, int j, int k, long val, List<Integer> list) // Declaracion de metodo update con parametros
    {
        arr[i-1][j-1][k-1] = val;                                           //se resta 1 a los indices i , j , k
        list.add(i);                                                                //se agrega a la lista el indice i
        list.add(j);                                                               //se agrega a la lista el indice j
        list.add(k);                                                             //se agrega a la lista el indice k
    }

    public static void querry(long arr[][][],int px, int qx, int rx, int py, int qy, int ry, List<Integer> list) // Declaracion de metodo update con parametros
    {
        long sum=0;                                                          //Se inicializa variable sum=0
        for(int i = 0; i <= list.size()-3; i = i + 3) {         //Se inicia for , se obtiene la longitud de la lista y se resta 3 , a (i) se le suma 1
            int a = list.get(i);                                             //Se declara variable (a) donde se obtiene el resultado de (i)
            int b = list.get(i+1);                                        //Se declara variable (b) donde se obtiene el resultado de (i+1)
            int c = list.get(i+2);                                         //Se declara variable (c) donde se obtiene el resultado de (i+2)
            if ((a>=px && a<=py) && (b>=qx && b<=qy) && (c>=rx && c<=ry)) sum+=arr[a-1][b-1][c-1]; // Se validan los resultados para posteriormente realizar la suma
        }
        System.out.println(sum); //Muestra el valor de la suma
    }

}





