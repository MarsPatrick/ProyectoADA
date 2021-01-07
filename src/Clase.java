import java.util.ArrayList;

public class Clase {

    public ArrayList<String> tirohechos;
    public Tablero t;

    /*public static int[][] probabilidades(){
        int [][] probabilidad = new int[11][11];
        String heatmap = "00 03 02 02 02 02 02 03 03 00 " +
                "03 20 23 25 26 26 25 23 20 03 " +
                "03 23 23 24 25 25 24 23 23 03 " +
                "02 25 24 25 26 26 25 24 25 02 " +
                "02 26 25 26 26 26 26 25 26 02 " +
                "02 26 25 26 26 26 26 25 26 02 " +
                "02 25 24 25 26 26 25 24 25 02 " +
                "03 23 23 24 25 25 24 23 23 02 " +
                "03 20 23 25 26 26 25 23 20 03 " +
                "00 03 03 02 02 02 02 03 03 00 ";
        String[] s = heatmap.split(" ");
        int cont=0;
        for(int i=1; i<11;i++){
            for(int j=1; j<11;j++){
                probabilidad[i][j]=Integer.parseInt(s[cont]);
                cont++;
            }
        }
        return probabilidad;

    }

    public static int MayorProb(int[][] prob){
        int mayor=0;
        for(int i=1; i<11;i++){
            for(int j=1; j<11;j++){
                if(prob[i][j]>mayor){
                    mayor = prob[i][j];
                }
            }
        }
        return mayor;
    }
*/
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
        int sum;
        if(largobarco>2){
            sum=2;
            if (pos.equalsIgnoreCase("Hd")) {
                if(validartiro(x,y+sum)){
                    disparo=t.disparo(x, (y+sum));
                    tirohechos.add(x+" "+(y+sum));
                }
                if(disparo != barco){
                    if(validartiro(x,y-(sum-1))){
                        t.disparo(x, (y-(sum-1)));
                        tirohechos.add(x+" "+(y-(sum-1)));
                    }
                    if(largobarco>3)
                        if(validartiro(x,y-sum)){
                            t.disparo(x, (y-(sum)));
                            tirohechos.add(x+" "+(y-sum));
                        }
                    if(largobarco>4)
                        if(validartiro(x,y-(sum+1))){
                            t.disparo(x, (y-(sum+1)));
                            tirohechos.add(x+" "+(y-(sum+1)));
                        }
                    if(disparo !='0' && disparo !='X'){
                        if(validartiro(x,y+sum))
                            Matar(t,x,(y+sum),disparo);
                    }
                    largobarco=0;
                }
            }
            if (pos.equalsIgnoreCase("Vab")) {
                if(validartiro((x+sum),y)){
                    disparo=t.disparo((x+sum), y);
                    tirohechos.add((x+sum)+" "+y);
                }
                if(disparo != barco){
                    if(validartiro((x-(sum-1)),y)){
                        t.disparo((x-(sum-1)), y);
                        tirohechos.add((x-(sum-1))+" "+y);
                    }
                    if(largobarco>3)
                        if(validartiro((x-sum),y)){
                            t.disparo((x-(sum)), y);
                            tirohechos.add((x-(sum))+" "+y);
                        }
                    if(largobarco>4)
                        if(validartiro((x-(sum+1)),y)){
                            t.disparo((x-(sum+1)), y);
                            tirohechos.add((x-(sum+1))+" "+y);
                        }
                    if(disparo !='0' && disparo !='X'){
                        if(validartiro((x+sum),y))
                            Matar(t,(x+sum),y,disparo);
                    }
                    largobarco=0;
                }
            }
            if (pos.equalsIgnoreCase("Hi")) {
                if(validartiro(x,y-sum)){
                    disparo=t.disparo(x, (y-sum));
                    tirohechos.add(x+" "+(y-sum));
                }
                if(disparo != barco){
                    if(validartiro(x,y+(sum-1))){
                        t.disparo(x, (y+(sum-1)));
                        tirohechos.add((x)+" "+(y+(sum-1)));
                    }
                    if(largobarco>3)
                        if(validartiro(x,y+sum)){
                            t.disparo(x, (y+(sum)));
                            tirohechos.add((x-(sum-1))+" "+(y+(sum)));
                        }
                    if(largobarco>4)
                        if(validartiro(x,y+sum+1)){
                            t.disparo(x, (y+(sum+1)));
                            tirohechos.add((x-(sum-1))+" "+(y+(sum+1)));
                        }
                    if(disparo !='0' && disparo !='X'){
                        if(validartiro(x,y-sum))
                            Matar(t,x,(y-sum),disparo);
                    }
                    largobarco=0;
                }
            }
            if (pos.equalsIgnoreCase("Var")) {
                if(validartiro(x-sum,y)){
                    disparo=t.disparo((x-sum), y);
                    tirohechos.add((x-sum)+" "+y);
                }
                if(disparo != barco){
                    if(validartiro(x+(sum-1),y)) {
                        t.disparo((x + (sum - 1)), y);
                        tirohechos.add((x + (sum - 1))+" "+y);
                    }
                    if(largobarco>3)
                        if(validartiro(x+sum,y)){
                            t.disparo((x+(sum)), y);
                            tirohechos.add((x + (sum))+" "+y);
                        }
                    if(largobarco>4)
                        if(validartiro(x+sum+1,y)){
                            t.disparo((x+(sum+1)), y);
                            tirohechos.add((x + (sum + 1))+" "+y);
                        }
                    if(disparo !='0' && disparo !='X'){
                        if(validartiro(x-sum,y))
                            Matar(t,(x-sum),y,disparo);
                    }
                    largobarco=0;
                }
            }
        }
        disparo=' ';
        if(largobarco>3){
            sum=3;
            if (pos.equalsIgnoreCase("Hd")) {
                if(validartiro(x,y+sum)){
                    disparo=t.disparo(x, (y+sum));
                    tirohechos.add((x)+" "+(y+sum));
                }
                if(disparo != barco){
                    if(validartiro(x,y-(sum-2))){
                        t.disparo(x, (y-(sum-2)));
                        tirohechos.add((x)+" "+(y-(sum-2)));
                    }
                    if(largobarco>4)
                        if(validartiro(x,y-(sum-1))){
                            t.disparo(x, (y-(sum-1)));
                            tirohechos.add((x)+" "+(y-(sum-1)));
                        }
                    if(disparo !='0' && disparo !='X'){
                        if(validartiro(x,y+sum))
                            Matar(t,x,(y+sum),disparo);
                    }
                    largobarco=0;
                }
            }
            if (pos.equalsIgnoreCase("Vab")) {
                if(validartiro(x+sum,y)){
                    disparo=t.disparo((x+sum), y);
                    tirohechos.add((x+sum)+" "+y);
                }
                if(disparo != barco){
                    if(validartiro(x-(sum-2),y)){
                        t.disparo((x-(sum-2)), y);
                        tirohechos.add((x-(sum-2))+" "+y);
                    }
                    if(largobarco>4)
                        if(validartiro(x-(sum-1),y)){
                            t.disparo((x-(sum-1)), y);
                            tirohechos.add((x-(sum-1))+" "+y);
                        }
                    if(disparo !='0' && disparo !='X'){
                        if(validartiro(x+sum,y))
                            Matar(t,(x+sum),y,disparo);
                    }
                    largobarco=0;
                }
            }
            if (pos.equalsIgnoreCase("Hi")) {
                if(validartiro(x,y-sum)){
                    disparo=t.disparo(x, (y-sum));
                    tirohechos.add(x+" "+(y-sum));
                }
                if(disparo != barco){
                    if(validartiro(x,y+(sum-2))){
                        t.disparo(x, (y+(sum-2)));
                        tirohechos.add(x+" "+(y+(sum-2)));
                    }
                    if(largobarco>4)
                        if(validartiro(x,y+(sum-1))){
                            t.disparo(x, (y+(sum-1)));
                            tirohechos.add(x+" "+(y+(sum-2)));
                        }
                    if(disparo !='0' && disparo !='X'){
                        if(validartiro(x,y-sum))
                            Matar(t,x,(y-sum),disparo);
                    }
                    largobarco=0;
                }
            }
            if (pos.equalsIgnoreCase("Var")) {
                if(validartiro(x-sum,y)){
                    disparo=t.disparo((x-sum), y);
                    tirohechos.add((x-sum)+" "+y);
                }
                if(disparo != barco){
                    if(validartiro(x+(sum-2),y)){
                        t.disparo((x+(sum-2)), y);
                        tirohechos.add((x+(sum-2))+" "+y);
                    }
                    if(largobarco>4)
                        if(validartiro(x+(sum-1),y)){
                            t.disparo((x+(sum-1)), y);
                            tirohechos.add((x+(sum-1))+" "+y);
                        }
                    if(disparo !='0' && disparo !='X'){
                        if(validartiro(x-sum,y))
                            Matar(t,(x-sum),y,disparo);
                    }
                    largobarco=0;
                }
            }
        }
        disparo=' ';
        if(largobarco>4){
            sum=4;
            if (pos.equalsIgnoreCase("Hd")) {
                if(validartiro(x,y+sum)){
                    disparo=t.disparo(x, (y+sum));
                    tirohechos.add(x+" "+(y+sum));
                }
                if(disparo != barco){
                    if(validartiro(x,y-(sum-3))){
                        t.disparo(x, (y-(sum-3)));
                        tirohechos.add(x+" "+(y-(sum-3)));
                    }
                    if(disparo !='0' && disparo !='X'){
                        if(validartiro(x,y+sum))
                            Matar(t,x,(y+sum),disparo);
                    }
                }
            }
            if (pos.equalsIgnoreCase("Vab")) {
                if(validartiro(x+sum,y)){
                    disparo=t.disparo((x+sum), y);
                    tirohechos.add((x+sum)+" "+y);
                }
                if(disparo != barco){
                    if(validartiro(x-(sum-3),y)){
                        t.disparo((x-(sum-3)), y);
                        tirohechos.add((x-(sum-3))+" "+y);
                    }
                    if(disparo !='0' && disparo !='X'){
                        if(validartiro(x+sum,y))
                            Matar(t,(x+sum),y,disparo);
                    }
                }
            }
            if (pos.equalsIgnoreCase("Hi")) {
                if(validartiro(x,y-sum)){
                    disparo=t.disparo(x, (y-sum));
                    tirohechos.add(x+" "+(y-sum));
                }
                if(disparo != barco){
                    if(validartiro(x,y+(sum-3))){
                        t.disparo(x, (y+(sum-3)));
                        tirohechos.add(x+" "+(y+(sum-3)));
                    }
                    if(disparo !='0' && disparo !='X'){
                        if(validartiro(x,y-sum))
                            Matar(t,x,(y-sum),disparo);
                    }
                }
            }
            if (pos.equalsIgnoreCase("Var")) {
                if(validartiro(x-sum,y)){
                    disparo=t.disparo((x-sum), y);
                    tirohechos.add((x-sum)+" "+y);
                }
                if(disparo != barco){
                    if(validartiro(x+(sum-3),y)){
                        t.disparo((x+(sum-3)), y);
                        tirohechos.add((x+(sum-3))+" "+y);
                    }
                    if(disparo !='0' && disparo !='X'){
                        if(validartiro(x-sum,y))
                            Matar(t,(x-sum),y,disparo);
                    }
                }
            }
        }
    }

    public ArrayList<String> TiroPosible(){
        ArrayList<String>tiropos=new ArrayList<>();
        int j;
        for (int i = 1; i <= 10; i++) {
            j=1;
            if(i%2 != 0)
                j=2;
            for (; j <= 10; j=j+2) {
                tiropos.add(i + " " + j);
            }
        }
        return tiropos;
    }

    public int Jugar(int rep){
        int sum=0;
        int cont=0;
        for (int veces = 1; veces <= rep; veces=veces+1) {

            ArrayList<String> pos = TiroPosible();
            t = new Tablero(10);
            tirohechos = new ArrayList<>();

            //int[][] probabilidad= probabilidades();
            //int mayorprobable= MayorProb(probabilidad);

            /*for(int i = 0; i<5; i++){
                for (String po : pos) {
                    String[] tiropos = po.split(" ");
                    int x = Integer.parseInt(tiropos[0]);
                    int y = Integer.parseInt(tiropos[1]);
                    if (t.ganar() == 0) {
                        if(probabilidad[x][y]==mayorprobable) {
                            char disparo = t.disparo(x, y);
                            if (disparo != '0' && disparo != 'X') {
                                if (validartiro(x, y)){
                                        tirohechos.add(po);
                                        Matar(t, x, y, disparo);
                                }
                            }
                            break;
                        }
                    }
                }
            }*/

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

            sum+=t.ganar();
            if(t.ganar()!=0){
                System.out.println(t.ganar());
                cont+=1;
            }
            //System.out.println(tirohechos);
            tirohechos.clear();
        }
        return (sum/cont);
    }
}