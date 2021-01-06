
import java.util.ArrayList;
import java.util.Iterator;

public class jugarjorge {



    public static String posicion(Tablero t , int x , int y ,char barco){
        String pos="";
        if(y+1<=10 && pos.isEmpty()){
            if (t.disparo(x, y+1) == barco) {
                pos="Hd";
                return pos;
            }
        }
        if(x+1<=10 && pos.isEmpty()){
            if (t.disparo(x+1, y) == barco) {
                pos="Vab";
                return pos;
            }
        }
        if(y-1>=1 && pos.isEmpty()){
            if (t.disparo(x, y-1) == barco) {
                pos="Hi";
                return pos;
            }
        }
        if(x-1>=1 && pos.isEmpty()){
            if (t.disparo(x-1, y) == barco) {
                pos="Var";
                return pos;
            }
        }
        return pos;
    }

    public static void ElegirBarco(char disparo, Tablero t, int x, int y, ArrayList<String> posdis){
        if(disparo == 'A'){
            MatarA(t,x,y,posdis);
        }
        if( disparo == 'B'){
            MatarB(t,x,y,posdis);
        }
        if( disparo == 'C'){
            MatarC(t,x,y,posdis);
        }
        if( disparo == 'S'){
            MatarS(t,x,y,posdis);
        }
        if( disparo == 'D'){
            MatarD(t,x,y,posdis);
        }
    }

    public static ArrayList<String> MatarA(Tablero t , int x , int y, ArrayList<String> posdis){
        String pos = posicion(t, x, y, 'A');
        char disparo;
        if (pos.equalsIgnoreCase("Hd")) {
            //posdis.add(x+" "+(y+1));
            disparo=t.disparo(x, y+2);
            if( disparo == 'A'){
                posdis.add(x+" "+(y+2));
                disparo=t.disparo(x, y+3);
                if(disparo == 'A'){
                    //posdis.add(x+" "+(y+3));
                    disparo=t.disparo(x, y+4);
                    if(disparo == 'A'){
                        posdis.add(x+" "+(y+4));
                    }else{
                        t.disparo(x, y-1);
                        //posdis.add(x+" "+(y-1));
                        if(disparo!='0' && disparo!='X'){
                            ElegirBarco(disparo,t,x,y,posdis);
                        }
                    }
                }else{
                    t.disparo(x, y-1);
                    t.disparo(x, y-2);
                    //posdis.add(x+" "+(y-1));
                    posdis.add(x+" "+(y-2));
                    if(disparo!='0' && disparo!='X'){
                        ElegirBarco(disparo,t,x,y,posdis);
                    }
                }
            }else{
                t.disparo(x, y-1);
                t.disparo(x, y-2);
                t.disparo(x, y-3);
                //posdis.add(x+" "+(y-1));
                posdis.add(x+" "+(y-2));
                //posdis.add(x+" "+(y-3));
                if(disparo!='0' && disparo!='X'){
                    ElegirBarco(disparo,t,x,y,posdis);
                }
            }

        }

        if (pos.equalsIgnoreCase("Vab")) {
            //posdis.add((x+1)+" "+y);
            if(t.disparo(x+2, y) == 'A'){
                posdis.add((x+2)+" "+y);
                if(t.disparo(x+3, y) == 'A'){
                    //posdis.add((x+3)+" "+y);
                    if(t.disparo(x+4, y) == 'A'){
                        posdis.add((x+4)+" "+y);
                    }else{
                        t.disparo(x-1, y);
                        //posdis.add((x-1)+" "+y);

                    }
                }else{
                    t.disparo(x-1, y);
                    t.disparo(x-2, y);
                    //posdis.add((x-1)+" "+y);
                    posdis.add((x-2)+" "+y);

                }
            }else{
                t.disparo(x-1, y);
                t.disparo(x-2, y);
                t.disparo(x-3, y);
                //posdis.add((x-1)+" "+y);
                posdis.add((x-2)+" "+y);
                //posdis.add((x-3)+" "+y);

            }
        }
        if (pos.equalsIgnoreCase("Hi")) {
            //posdis.add(x+" "+(y-1));
            if (t.disparo(x, y-2) == 'A') {
                t.disparo(x, y-3);
                t.disparo(x, y-4);
                posdis.add(x+" "+(y-2));
                //posdis.add(x+" "+(y-3));
                posdis.add(x+" "+(y-4));

            }
        }
        if (pos.equalsIgnoreCase("Var")) {
            if(t.disparo(x-2, y)== 'A'){
                t.disparo(x-3, y);
                t.disparo(x-4, y);
                posdis.add((x-2)+" "+y);
                //posdis.add((x-3)+" "+y);
                posdis.add((x-4)+" "+y);
            }
        }

        return posdis;

    }
    public static ArrayList<String> MatarB(Tablero t , int x , int y, ArrayList<String> posdis){
        String pos = posicion(t, x, y, 'B');
        if (pos.equalsIgnoreCase("Hd")) {
            //posdis.add(x+" "+(y+1));
            if(t.disparo(x, y+2) == 'B'){
                posdis.add(x+" "+(y+2));
                if(t.disparo(x, y+3) == 'B'){
                    //posdis.add(x+" "+(y+3));
                }else{
                    t.disparo(x, y-1);
                    //posdis.add(x+" "+(y-1));
                }
            }else{
                t.disparo(x, y-1);
                t.disparo(x, y-2);
                //posdis.add(x+" "+(y-1));
                posdis.add(x+" "+(y-2));

            }
        }
        if (pos.equalsIgnoreCase("Vab")) {
            //posdis.add((x+1)+" "+y);
            if(t.disparo(x+2, y) == 'B'){
                posdis.add((x+2)+" "+y);
                if(t.disparo(x+3, y) == 'B'){
                    //posdis.add((x+3)+" "+y);
                }else{
                    t.disparo(x-1, y);
                    //posdis.add((x-1)+" "+y);
                }
            }else{
                t.disparo(x-1, y);
                t.disparo(x-2, y);
                //posdis.add((x-1)+" "+y);
                posdis.add((x-2)+" "+y);
            }
        }
        if (pos.equalsIgnoreCase("Hi")) {
            //posdis.add(x+" "+(y-1));
            if (t.disparo(x, y-2) == 'B') {
                t.disparo(x, y-3);
                posdis.add(x+" "+(y-2));
                //posdis.add(x+" "+(y-3));

            }
        }
        if (pos.equalsIgnoreCase("Var")) {
            if(t.disparo(x-2, y) == 'B'){
                t.disparo(x-3, y);
                posdis.add((x-2)+" "+y);
                //posdis.add((x-3)+" "+y);

            }

        }

        return posdis;

    }
    public static ArrayList<String> MatarC(Tablero t , int x , int y, ArrayList<String> posdis){
        String pos = posicion(t, x, y, 'C');
        if (pos.equalsIgnoreCase("Hd")) {
            //posdis.add(x+" "+(y+1));
            if(t.disparo(x, y+2) == 'C'){
                posdis.add(x+" "+(y+2));

            }else{
                t.disparo(x, y-1);
                //posdis.add(x+" "+(y-1));
            }
        }
        if (pos.equalsIgnoreCase("Vab")) {
            //posdis.add((x+1)+" "+y);
            if(t.disparo(x+2, y) == 'C'){
                posdis.add((x+2)+" "+y);
            }else{
                t.disparo(x-1, y);
                //posdis.add((x-1)+" "+y);
            }
        }
        if (pos.equalsIgnoreCase("Hi")) {
            //posdis.add(x+" "+(y-1));
            if(t.disparo(x, y-2) == 'C'){
                posdis.add(x+" "+(y-2));
            }
        }
        if (pos.equalsIgnoreCase("Var")) {
            //posdis.add((x-1)+" "+y);
            if(t.disparo(x-2, y) == 'C'){
                posdis.add((x-2)+" "+y);
            }
        }

        return posdis;
    }
    public static ArrayList<String> MatarS(Tablero t , int x , int y, ArrayList<String> posdis){
        String pos = posicion(t, x, y, 'S');
        if (pos.equalsIgnoreCase("Hd")) {
            //posdis.add(x+" "+(y+1));
            if(t.disparo(x, y+2) == 'S'){
                posdis.add(x+" "+(y+2));

            }else{
                t.disparo(x, y-1);
                //posdis.add(x+" "+(y-1));
            }
        }
        if (pos.equalsIgnoreCase("Vab")) {
            //posdis.add((x+1)+" "+y);
            if(t.disparo(x+2, y) == 'S'){
                posdis.add((x+2)+" "+y);
            }else{
                t.disparo(x-1, y);
                //posdis.add((x-1)+" "+y);
            }
        }
        if (pos.equalsIgnoreCase("Hi")) {
            //posdis.add(x+" "+(y-1));
            if(t.disparo(x, y-2) == 'S'){
                posdis.add(x+" "+(y-2));
            }
        }
        if (pos.equalsIgnoreCase("Var")) {
            //posdis.add((x-1)+" "+y);
            if(t.disparo(x-2, y) == 'S'){
                posdis.add((x-2)+" "+y);
            }
        }

        return posdis;
    }
    public static ArrayList<String> MatarD(Tablero t , int x , int y, ArrayList<String> posdis){
        String pos = posicion(t, x, y, 'S');
        /*if (pos.equalsIgnoreCase("Hd")) {
            posdis.add(x+" "+(y+1));

        }
        if (pos.equalsIgnoreCase("Vab")) {
            posdis.add((x+1)+" "+y);

        }
        if (pos.equalsIgnoreCase("Hi")) {
            posdis.add(x+" "+(y-1));

        }
        if (pos.equalsIgnoreCase("Var")) {
            posdis.add((x-1)+" "+y);

        }
        */
        return posdis;
    }

    public static void main(String[] args) {
        int sum=0;
        int rep=100000 ;
        int cont=0;
        for (int veces = 1; veces <= rep; veces=veces+1) {
            ArrayList<String> pos = new ArrayList();
            int j;
            for (int i = 1; i <= 10; i++) {
                j=1;
                if(i%2 != 0){
                    j=2;
                }
                for (j = j; j <= 10; j=j+2) {
                    pos.add(i+" "+j);
                }
            }
            Tablero t = new Tablero(10);
            ArrayList<Integer> numeros = new ArrayList();
            ArrayList<String> disparoshechos = new ArrayList();
            for (int i = 1; i <= 50; i++) {
                boolean yaestoy=false;
                int nr = (int) (Math.random()*pos.size() +0);

                for (Integer num : numeros) {
                    if (num == nr) {
                        yaestoy=true;

                    }
                }
                if(yaestoy==true && numeros.size()!= pos.size()){
                    i=i-1;
                    continue;
                }else{
                    numeros.add(nr);
                }
            }//genera numeros aleatorios

            for (int nrr = 0; nrr < pos.size(); nrr++) {
                String[] tiropos = pos.get(nrr).split(" ");
                int x=Integer.parseInt(tiropos[0]);
                int y=Integer.parseInt(tiropos[1]);
                if (t.ganar() == 0) {
                    char disparo=t.disparo(x,y);
                    if(disparo == 'A'){
                        disparoshechos=MatarA(t,x,y,disparoshechos);

                    }
                    if( disparo == 'B'){
                        disparoshechos=MatarB(t,x,y,disparoshechos);

                    }
                    if( disparo == 'C'){
                        disparoshechos=MatarC(t,x,y,disparoshechos);

                    }
                    if( disparo == 'S'){
                        disparoshechos=MatarS(t,x,y,disparoshechos);

                    }
                    if( disparo == 'D'){
                        disparoshechos=MatarS(t,x,y,disparoshechos);

                    }
                    Iterator it = pos.iterator();
                    while(it.hasNext()){
                        String asas = (String) it.next();
                        String[] aa= asas.split(" ");
                        String px=aa[0];
                        String py=aa[1];
                        for (String d : disparoshechos) {
                            String[] a=d.split(" ");
                            String hx=a[0];
                            String hy=a[1];
                            if (hx.equals(px) && hy.equals(py)) {
                                it.remove();
                            }
                        }
                    }

                }
            }//disparar
            //t.Imprimir();
            //System.out.println(t.ganar());
            //System.out.println(pos);
            sum+=t.ganar();
            if(t.ganar()!=0){
                cont+=1;
                //System.out.println(t.ganar());
            }else{
                t.Imprimir();
                System.out.println(numeros);
                System.out.println(pos);
                System.out.println();
            }
        }
        System.out.println(cont);
        System.out.println("Promedio en "+rep+" intentos = "+sum/cont);
    }
}
