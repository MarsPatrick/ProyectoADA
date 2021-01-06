import java.util.ArrayList;
import java.util.Iterator;

public class jugarmio {

    public static String posicion(Tablero t , int x , int y ,char barco,ArrayList<String> posdis){
        String pos="";
        char disparo;
        if(y+1<=10 && pos.isEmpty()){
            disparo=t.disparo(x, y+1);
            if (disparo == barco) {
                pos="Hd";
                return pos;
            }else{
                if(disparo !='0' && disparo !='X'){
                    Matar(t,x,(y+1),disparo,posdis);
                }
            }
        }
        if(x+1<=10 && pos.isEmpty()){
            disparo=t.disparo(x+1, y);
            if (disparo == barco) {
                pos="Vab";
                return pos;
            }else{
                if(disparo !='0' && disparo !='X'){
                    Matar(t,(x+1),y,disparo,posdis);
                }
            }
        }
        if(y-1>=1 && pos.isEmpty()){
            disparo=t.disparo(x, y-1);
            if (disparo == barco) {
                pos="Hi";
                return pos;
            }else{
                if(disparo !='0' && disparo !='X'){
                    Matar(t,x,(y-1),disparo,posdis);
                }
            }
        }
        if(x-1>=1 && pos.isEmpty()){
            disparo=t.disparo(x-1, y);
            if (disparo == barco) {
                pos="Var";
                return pos;
            }else{
                if(disparo !='0' && disparo !='X'){
                    Matar(t,(x-1),y,disparo,posdis);
                }
            }
        }
        return pos;
    }

    public static int LargoBarco(char barco){
        int largo=0;

        if(barco == 'A'){
            return 5;
        }
        if( barco == 'B'){
            return 4;
        }
        if( barco == 'C'){
            return 3;
        }
        if( barco == 'S'){
            return 3;
        }
        if( barco == 'D'){
            return 2;
        }

        return largo;
    }

    public static ArrayList<String> Matar(Tablero t , int x , int y, char barco,ArrayList<String> posdis){
        String pos = posicion(t, x, y, barco,posdis);
        int largobarco=LargoBarco(barco);
        char disparo;
        int sum=0;
        if(largobarco>2){
            sum=2;
            if (pos.equalsIgnoreCase("Hd")) {
                disparo=t.disparo(x, (y+sum));
                if(disparo == barco){
                    posdis.add(x+" "+(y+sum));

                }else{
                    t.disparo(x, (y-(sum-1)));
                    if(largobarco>3)
                        t.disparo(x, (y-(sum)));
                    if(largobarco>4)
                        t.disparo(x, (y-(sum+1)));
                    if(disparo !='0' && disparo !='X'){
                        Matar(t,x,(y+sum),disparo,posdis);
                    }
                }
            }
            if (pos.equalsIgnoreCase("Vab")) {
                disparo=t.disparo((x+sum), y);
                if(disparo == barco){
                    posdis.add((x+sum)+" "+y);

                }else{
                    t.disparo((x-(sum-1)), y);
                    t.disparo((x-(sum-1)), y);
                    if(largobarco>3)
                        t.disparo((x-(sum)), y);
                    if(largobarco>4)
                        t.disparo((x-(sum+1)), y);
                    if(disparo !='0' && disparo !='X'){
                        Matar(t,(x+sum),y,disparo,posdis);
                    }
                }
            }
            if (pos.equalsIgnoreCase("Hi")) {
                disparo=t.disparo(x, (y-sum));
                if(disparo == barco){
                    posdis.add(x+" "+(y-sum));

                }else{
                    t.disparo(x, (y+(sum-1)));
                    if(largobarco>3)
                        t.disparo(x, (y+(sum)));
                    if(largobarco>4)
                        t.disparo(x, (y+(sum+1)));
                    if(disparo !='0' && disparo !='X'){
                        Matar(t,x,(y-sum),disparo,posdis);
                    }
                }
            }
            if (pos.equalsIgnoreCase("Var")) {
                disparo=t.disparo((x-sum), y);
                if(disparo == barco){
                    posdis.add((x-sum)+" "+y);

                }else{
                    t.disparo((x+(sum-1)), y);
                    if(largobarco>3)
                        t.disparo((x+(sum)), y);
                    if(largobarco>4)
                        t.disparo((x+(sum+1)), y);
                    if(disparo !='0' && disparo !='X'){
                        Matar(t,(x-sum),y,disparo,posdis);
                    }
                }
            }
        }

        if(largobarco>3){
            sum=3;
            if (pos.equalsIgnoreCase("Hd")) {
                disparo=t.disparo(x, (y+sum));
                if(disparo == barco){
                    posdis.add(x+" "+(y+sum));

                }else{
                    t.disparo(x, (y-(sum-2)));
                    t.disparo(x, (y-(sum-1)));
                    if(largobarco>4)
                        t.disparo(x,(y-sum));
                    if(disparo !='0' && disparo !='X'){
                        Matar(t,x,(y+sum),disparo,posdis);
                    }
                }
            }
            if (pos.equalsIgnoreCase("Vab")) {
                disparo=t.disparo((x+sum), y);
                if(disparo == barco){
                    posdis.add((x+sum)+" "+y);

                }else{
                    t.disparo((x-(sum-2)), y);
                    t.disparo((x-(sum-1)), y);
                    if(largobarco>4)
                        t.disparo((x-sum),y);
                    if(disparo !='0' && disparo !='X'){
                        Matar(t,(x+sum),y,disparo,posdis);
                    }
                }
            }
            if (pos.equalsIgnoreCase("Hi")) {
                disparo=t.disparo(x, (y-sum));
                if(disparo == barco){
                    posdis.add(x+" "+(y-sum));

                }else{
                    t.disparo(x, (y+(sum-1)));
                    t.disparo(x, (y+(sum-1)));
                    if(largobarco>4)
                        t.disparo(x,(y+sum));
                    if(disparo !='0' && disparo !='X'){
                        Matar(t,x,(y-sum),disparo,posdis);
                    }
                }
            }
            if (pos.equalsIgnoreCase("Var")) {
                disparo=t.disparo((x-sum), y);
                if(disparo == barco){
                    posdis.add((x-sum)+" "+y);

                }else{
                    t.disparo((x+(sum-2)), y);
                    t.disparo((x+(sum-1)), y);
                    if(largobarco>4)
                        t.disparo((x+sum),y);
                    if(disparo !='0' && disparo !='X'){
                        Matar(t,(x-sum),y,disparo,posdis);
                    }
                }
            }
        }

        if(largobarco>4){
            sum=4;
            if (pos.equalsIgnoreCase("Hd")) {
                disparo=t.disparo(x, (y+sum));
                if(disparo == barco){
                    posdis.add(x+" "+(y+sum));

                }else{
                    t.disparo(x, (y-(sum-3)));
                    t.disparo(x, (y-(sum-2)));
                    t.disparo(x, (y-(sum-1)));
                    if(disparo !='0' && disparo !='X'){
                        Matar(t,x,(y+sum),disparo,posdis);
                    }
                }
            }
            if (pos.equalsIgnoreCase("Vab")) {
                disparo=t.disparo((x+sum), y);
                if(disparo == barco){
                    posdis.add((x+sum)+" "+y);

                }else{
                    t.disparo((x-(sum-3)), y);
                    t.disparo((x-(sum-2)), y);
                    t.disparo((x-(sum-1)), y);
                    if(disparo !='0' && disparo !='X'){
                        Matar(t,(x+sum),y,disparo,posdis);
                    }
                }
            }
            if (pos.equalsIgnoreCase("Hi")) {
                disparo=t.disparo(x, (y-sum));
                if(disparo == barco){
                    posdis.add(x+" "+(y-sum));

                }else{
                    t.disparo(x, (y+(sum-3)));
                    t.disparo(x, (y+(sum-2)));
                    t.disparo(x, (y+(sum-1)));
                    if(disparo !='0' && disparo !='X'){
                        Matar(t,x,(y-sum),disparo,posdis);
                    }
                }
            }
            if (pos.equalsIgnoreCase("Var")) {
                disparo=t.disparo((x-sum), y);
                if(disparo == barco){
                    posdis.add((x-sum)+" "+y);

                }else{
                    t.disparo((x+(sum-3)), y);
                    t.disparo((x+(sum-2)), y);
                    t.disparo((x+(sum-1)), y);
                    if(disparo !='0' && disparo !='X'){
                        Matar(t,(x-sum),y,disparo,posdis);
                    }
                }
            }
        }

        return posdis;

    }

    public static void main(String[] args) {
        int sum=0;
        int rep=100000;
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
                    if(disparo !='0' && disparo !='X'){
                        disparoshechos=Matar(t,x,y,disparo,disparoshechos);
                    }
                    /*
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
                    */
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
