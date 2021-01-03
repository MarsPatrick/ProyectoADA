import java.util.ArrayList;

public class jugar {
    public static String posicion(Tablero t , int x , int y ,char barco){
        String pos="";
        if(y+1<=10 && pos.isEmpty()){
            if (t.disparo(x, y+1) == barco) {
                pos="Hd";
            }
        }
        if(x+1<=10 && pos.isEmpty()){
            if (t.disparo(x+1, y) == barco) {
                pos="Vab";
            }
        }
        if(y-1>=1 && pos.isEmpty()){
            if (t.disparo(x, y-1) == barco) {
                pos="Hi";
            }
        }
        if(x-1>=1 && pos.isEmpty()){
            if (t.disparo(x-1, y) == barco) {
                pos="Var";
            }
        }
        return pos;
    }
    public static void MatarA(Tablero t , int x , int y){
        String pos = posicion(t, x, y, 'A');
        if (pos.equalsIgnoreCase("Hd")) {
            if(t.disparo(x, y+2) == 'A' && y+2<=10){
                if(t.disparo(x, y+3) == 'A'&& y+3<=10){
                    if(t.disparo(x, y+4) == 'A'&& y+4<=10){

                    }else{
                        t.disparo(x, y-1);
                    }
                }else{
                    t.disparo(x, y-1);
                    t.disparo(x, y-2);
                }
            }else{
                t.disparo(x, y-1);
                t.disparo(x, y-2);
                t.disparo(x, y-3);
            }
        }
        if (pos.equalsIgnoreCase("Hi")) {
            if(t.disparo(x, y-2) == 'A' && y-2>=1){
                if(t.disparo(x, y-3) == 'A' && y-3>=1){
                    if(t.disparo(x, y-4) == 'A' && y-4>=1){

                    }else{
                        t.disparo(x, y+1);
                    }
                }else{
                    t.disparo(x, y+1);
                    t.disparo(x, y+2);
                }
            }else{
                t.disparo(x, y+1);
                t.disparo(x, y+2);
                t.disparo(x, y+3);
            }
        }
        if (pos.equalsIgnoreCase("Var")) {
            if(t.disparo(x-2, y) == 'A' && x-2>=1){
                if(t.disparo(x-3, y) == 'A' && x-3>=1){
                    if(t.disparo(x-4, y) == 'A' && x-4>=1){

                    }else{
                        t.disparo(x+1, y);
                    }
                }else{
                    t.disparo(x+1, y);
                    t.disparo(x+2, y);
                }
            }else{
                t.disparo(x+1, y);
                t.disparo(x+2, y);
                t.disparo(x+3, y);
            }
        }
        if (pos.equalsIgnoreCase("Vab")) {
            if(t.disparo(x+2, y) == 'A' && x+2<=10){
                if(t.disparo(x+3, y) == 'A' && x+3<=10){
                    if(t.disparo(x+4, y) == 'A' && x+4<=10){

                    }else{
                        t.disparo(x-1, y);
                    }
                }else{
                    t.disparo(x-1, y);
                    t.disparo(x-2, y);
                }
            }else{
                t.disparo(x-1, y);
                t.disparo(x-2, y);
                t.disparo(x-3, y);
            }
        }

    }
    public static void MatarB(Tablero t , int x , int y){
        String pos = posicion(t, x, y, 'B');
        if (pos.equalsIgnoreCase("Hd")) {
            if(t.disparo(x, y+2) == 'B' && y+2<=10){
                if(t.disparo(x, y+3)== 'B' && y+3<=10){

                }else{
                    t.disparo(x, y-1);
                }
            }else{
                t.disparo(x, y-1);
                t.disparo(x, y-2);
            }
        }
        if (pos.equalsIgnoreCase("Hi")) {
            if(t.disparo(x, y-2) == 'B' && y-2>=1){
                if(t.disparo(x, y-3) == 'B' && y-2>=1){

                }else{
                    t.disparo(x, y+1);
                }
            }else{
                t.disparo(x, y+1);
                t.disparo(x, y+2);
            }
        }
        if (pos.equalsIgnoreCase("Var")) {
            if(t.disparo(x-2, y) == 'B' && x-2>=1){
                if(t.disparo(x-3, y) == 'B' && x-3>=1){

                }else{
                    t.disparo(x+1, y);
                }
            }else{
                t.disparo(x+1, y);
                t.disparo(x+2, y);
            }

        }
        if (pos.equalsIgnoreCase("Vab")) {
            if(t.disparo(x+2, y) == 'B' && x+2<=10){
                if(t.disparo(x+3, y) == 'B' && x+3<=10){

                }else{
                    t.disparo(x-1, y);
                }
            }else{
                t.disparo(x-1, y);
                t.disparo(x-2, y);
            }
        }

    }
    public static void MatarC(Tablero t , int x , int y){
        String pos = posicion(t, x, y, 'C');
        if (pos.equalsIgnoreCase("Hd")) {
            if(t.disparo(x, y+2) == 'C'){

            }else{
                t.disparo(x, y-1);
            }
        }
        if (pos.equalsIgnoreCase("Hi")) {
            if(t.disparo(x, y-2) == 'C'){

            }else{
                t.disparo(x, y+1);
            }
        }
        if (pos.equalsIgnoreCase("Var")) {
            if(t.disparo(x-2, y) == 'C'){

            }else{
                t.disparo(x+1, y);
            }
        }
        if (pos.equalsIgnoreCase("Vab")) {
            if(t.disparo(x+2, y) == 'C'){

            }else{
                t.disparo(x-1, y);
            }
        }

    }
    public static void MatarS(Tablero t , int x , int y){
        String pos = posicion(t, x, y, 'S');
        if (pos.equalsIgnoreCase("Hd")) {
            if(t.disparo(x, y+2) == 'S'){

            }else{
                t.disparo(x, y-1);
            }
        }
        if (pos.equalsIgnoreCase("Hi")) {
            if(t.disparo(x, y-2) == 'S'){

            }else{
                t.disparo(x, y+1);
            }
        }
        if (pos.equalsIgnoreCase("Var")) {
            if(t.disparo(x-2, y) == 'S'){

            }else{
                t.disparo(x+1, y);
            }
        }
        if (pos.equalsIgnoreCase("Vab")) {
            if(t.disparo(x+2, y) == 'S'){

            }else{
                t.disparo(x-1, y);
            }
        }
    }
    public static void MatarD(Tablero t , int x , int y){
        String pos = posicion(t, x, y, 'S');

    }

    public static void main(String[] args) {
        int sum=0;
        int repeticiones=1000;
        ArrayList<String> pos = new ArrayList();
        int j;

        for (int i = 1; i <= 10; i++) {
            j=1;
            if(i%2 == 0){
                j=2;
            }
            for (j = j; j <= 10; j=j+2) {
                pos.add(i+" "+j);
                //System.out.println(i+" "+j);
            }
        }

        for (int veces = 0; veces < repeticiones; veces++) {
            Tablero t = new Tablero(10);
            ArrayList<Integer> NumeG = new ArrayList();

            for (int i = 0; i < 50; i++) {
                boolean yaestoy=false;
                int disparorandom = (int) (Math.random()*50 +0);
                for (Integer num : NumeG) {
                    if (num == disparorandom) {
                        yaestoy=true;
                    }
                }
                if(yaestoy==true && NumeG.size()!= 50){
                    i=i-1;
                    continue;
                }else{
                    NumeG.add(disparorandom);
                }
            }

            for (int i = 0; i < 50; i++) {
                String[] tiropos = pos.get(NumeG.get(i)).split(" ");
                int x = Integer.parseInt(tiropos[0]);
                int y = Integer.parseInt(tiropos[1]);
                if (t.ganar() == 0) {
                    char disparo = t.disparo(x, y);
                    if (disparo == 'A') {
                        MatarA(t, x, y);
                    }
                    if (disparo == 'B') {
                        MatarB(t, x, y);
                    }
                    if (disparo == 'C') {
                        MatarC(t, x, y);
                    }
                    if (disparo == 'S') {
                        MatarS(t, x, y);
                    }
                    if (disparo == 'D') {
                        MatarD(t, x, y);
                    }
                }
            }

            System.out.println(veces);
            t.Imprimir();
            sum+=t.ganar();
        }
        System.out.println(sum/repeticiones);
    }
}