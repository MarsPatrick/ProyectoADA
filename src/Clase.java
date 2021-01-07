import java.util.ArrayList;

public class Clase {

    public ArrayList<String> tirohechos;
    public Tablero t;

    public String posicion(Tablero t , int x , int y ,char barco){
        String pos="";
        char disparo='0';
        if(y+1<=10){
            if(validartiro(x,(y+1))){
                tirohechos.add(x+" "+(y+1));
                disparo=t.disparo(x, y+1);
            }
            if (disparo == barco) {
                pos="Hd";
                return pos;
            }else{
                if(disparo !='0' && disparo !='X'){
                    Matar(t,x,(y+1),disparo);
                }
            }
        }
        disparo='0';
        if(x+1<=10){
            if(validartiro((x+1),y)){
                tirohechos.add((x+1)+" "+y);
                disparo=t.disparo(x+1, y);
            }
            if (disparo == barco) {
                pos="Vab";
                return pos;
            }else{
                if(disparo !='0' && disparo !='X'){
                    Matar(t,(x+1),y,disparo);
                }
            }
        }
        disparo='0';
        if(y-1>=1){
            if(validartiro(x,(y-1))){
                tirohechos.add(x+" "+(y-1));
                disparo=t.disparo(x, y-1);
            }
            if (disparo == barco) {
                pos="Hi";
                return pos;
            }else{
                if(disparo !='0' && disparo !='X'){
                    Matar(t,x,(y-1),disparo);
                }
            }
        }
        disparo='0';
        if(x-1>=1){
            if(validartiro((x-1),y)){
                tirohechos.add((x-1)+" "+y);
                disparo=t.disparo(x-1, y);
            }
            if (disparo == barco) {
                pos="Var";
                return pos;
            }else{
                if(disparo !='0' && disparo !='X'){
                    Matar(t,(x-1),y,disparo);
                }
            }
        }
        return pos;
    }

    public int LargoBarco(char barco){
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

    public boolean validartiro(int x, int y){
        if(x<1 || x>10)
            return false;
        if(y<1 || y>10)
            return false;
        if(x==1 && y==1)
            return false;
        if(x==10 && y==1)
            return false;
        if(x==1 && y==10)
            return false;
        if(x==10 && y==10)
            return false;
        if(YaEsta(x,y,tirohechos))
            return false;
        //System.out.println("dispare en "+ x+" "+y);
        return true;
    }

    public boolean YaEsta(int x, int y, ArrayList<String> Disparos){
        //System.out.println(x+" "+y);
        if(Disparos.isEmpty())
            return false;
        for(String disparo : Disparos){
            String[] tiropos = disparo.split(" ");
            int a = Integer.parseInt(tiropos[0]);
            int b = Integer.parseInt(tiropos[1]);
            if(a==x && b==y)
                return true;
        }
        if(t.ganar()!=0)
            return true;

        return false;
    }

    public void Matar(Tablero t , int x , int y, char barco){
        String pos = posicion(t, x, y, barco);
        int largobarco=LargoBarco(barco);
        char disparo=' ';
        int otrox=0;
        int otroy=0;
        int falle = largobarco;
        char otrobarco = '0';

        for(int i=2; i<(largobarco);i++){
            if (pos.equalsIgnoreCase("Var")) {
                if(validartiro(x-i,y)){
                    disparo=t.disparo((x-i), y);
                    tirohechos.add((x-i)+" "+y);
                    if(disparo != barco){
                        falle=i;
                        if(disparo!='0'){
                            otrobarco=disparo;
                            otrox=x-i;
                            otroy=y;
                        }
                        i=10;
                    }
                }else{
                    falle=i;
                    i=10;
                }
            }
            if (pos.equalsIgnoreCase("Hi")) {
                if(validartiro(x,y-i)){
                    disparo=t.disparo(x, (y-i));
                    tirohechos.add(x+" "+(y-i));
                    if(disparo != barco){
                        falle=i;
                        if(disparo!='0'){
                            otrobarco=disparo;
                            otrox=x;
                            otroy=y-i;
                        }
                        i=10;
                    }
                }else{
                    falle=i;
                    i=10;
                }
            }
            if (pos.equalsIgnoreCase("Vab")) {
                if(validartiro(x+i,y)){
                    disparo=t.disparo((x+i), y);
                    tirohechos.add((x+i)+" "+y);
                    if(disparo != barco){
                        falle=i;
                        if(disparo!='0'){
                            otrobarco=disparo;
                            otrox=x+i;
                            otroy=y;
                        }
                        i=10;
                    }
                }else{
                    falle=i;
                    i=10;
                }
            }
            if (pos.equalsIgnoreCase("Hd")) {
                if(validartiro(x,y+i)){
                    disparo=t.disparo(x, (y+i));
                    tirohechos.add(x+" "+(y+i));
                    if(disparo != barco){
                        falle=i;
                        if(disparo!='0'){
                            otrobarco=disparo;
                            otrox=x;
                            otroy=y+i;
                        }
                        i=10;
                    }
                }else{
                    falle=i;
                    i=10;
                }
            }
        }

        if(otrobarco!='0')
            Matar(t,otrox,otroy,otrobarco);


        otrobarco = '0';

        for(int i=1; i<=(largobarco-falle);i++){
            if (pos.equalsIgnoreCase("Var")) {
                if(validartiro(x+i,y)){
                    disparo=t.disparo((x+i), y);
                    tirohechos.add((x+i)+" "+y);
                    if(disparo != barco){
                        falle=i;
                        if(disparo!='0'){
                            otrobarco=disparo;
                            otrox=x+i;
                            otroy=y;
                        }
                    }
                }
            }
            if (pos.equalsIgnoreCase("Hi")) {
                if(validartiro(x,y+i)){
                    disparo=t.disparo(x, (y+i));
                    tirohechos.add(x+" "+(y+i));
                    if(disparo != barco){
                        falle=i;
                        if(disparo!='0'){
                            otrobarco=disparo;
                            otrox=x;
                            otroy=y+i;
                        }
                    }
                }
            }
            if (pos.equalsIgnoreCase("Vab")) {
                if(validartiro(x-i,y)){
                    disparo=t.disparo((x-i), y);
                    tirohechos.add((x-i)+" "+y);
                    if(disparo != barco){
                        falle=i;
                        if(disparo!='0'){
                            otrobarco=disparo;
                            otrox=x-i;
                            otroy=y;
                        }
                    }
                }
            }
            if (pos.equalsIgnoreCase("Hd")) {
                if(validartiro(x,y-i)){
                    disparo=t.disparo(x, (y-i));
                    tirohechos.add(x+" "+(y-i));
                    if(disparo != barco){
                        falle=i;
                        if(disparo!='0'){
                            otrobarco=disparo;
                            otrox=x;
                            otroy=y-i;
                        }
                    }
                }
            }
        }

        if(otrobarco!='0')
            Matar(t,otrox,otroy,otrobarco);

    }

    public ArrayList<String> TiroPosible(){
        ArrayList<String>tiropos=new ArrayList<>();
        int j;
        for (int i = 2; i < 10; i++) {
            j=1;
            if(i%2 == 0)
                j=2;
            for (; j <= 10; j=j+2) {
                if(j!=1 && j!=10)
                    tiropos.add(i + " " + j);
            }
        }
        return tiropos;
    }

    public ArrayList<String> MatarLaD(){
        ArrayList<String>tiropos=new ArrayList<>();
        tiropos.add(2 + " " + 3);
        tiropos.add(2 + " " + 5);
        tiropos.add(2 + " " + 7);
        tiropos.add(2 + " " + 9);

        tiropos.add(9 + " " + 2);
        tiropos.add(9 + " " + 4);
        tiropos.add(9 + " " + 6);
        tiropos.add(9 + " " + 8);

        tiropos.add(3 + " " + 2);
        tiropos.add(5 + " " + 2);
        tiropos.add(7 + " " + 2);
        tiropos.add(9 + " " + 2);

        tiropos.add(2 + " " + 9);
        tiropos.add(4 + " " + 9);
        tiropos.add(6 + " " + 9);
        tiropos.add(8 + " " + 9);
        return tiropos;
    }

    public int Jugar(int rep){
        int sum=0;
        int cont=0;
        for (int veces = 1; veces <= rep; veces=veces+1) {

            ArrayList<String> pos = TiroPosible();
            //System.out.println(pos);
            t = new Tablero(10);
            tirohechos = new ArrayList<>();

            for (String po : pos) {
                String[] tiropos = po.split(" ");
                int x = Integer.parseInt(tiropos[0]);
                int y = Integer.parseInt(tiropos[1]);
                if (t.ganar() == 0) {
                    char disparo = t.disparo(x, y);
                    if (disparo != '0' && disparo != 'X') {
                        if(validartiro(x,y)) {
                            tirohechos.add(po);
                            Matar(t, x, y, disparo);
                        }
                    }
                }
            }
            tirohechos.clear();
            sum+=t.ganar();
            if(t.ganar()!=0){
                cont+=1;
            }else{
                pos = MatarLaD();
                //System.out.println(pos);
                for (String po : pos) {
                    String[] tiropos = po.split(" ");
                    int x = Integer.parseInt(tiropos[0]);
                    int y = Integer.parseInt(tiropos[1]);
                    if (t.ganar() == 0) {
                        char disparo = t.disparo(x, y);
                        //System.out.println(x+" "+y+" "+disparo);
                        if (disparo != '0' && disparo != 'X') {
                            Matar(t, x, y, disparo);
                        }
                    }
                }
                sum+=t.ganar();
                if(t.ganar()!=0){
                    cont+=1;
                }else{
                    sum+=100;
                    cont+=1;
                }
            }
            tirohechos.clear();
        }
        System.out.println("Oceanos jugados: "+cont);
        return (sum/cont);
    }
}