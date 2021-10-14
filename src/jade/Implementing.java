package jade;

public class Implementing {
    
    private double matrizX [][];
    private double vectorY [][];
    private double transX [][];
    
    
    //Inicializando
    public Implementing(){
        
        this.matrizX = new double[][] { {1,41.9,29.1}, {1,43.4,29.3}, {1,43.9,29.5}, {1,44.5,29.7},
                                        {1,47.3,29.9}, {1,47.5,30.3}, {1,47.9,30.5}, {1,50.2,30.7},
                                        {1,52.8,30.8}, {1,53.2,30.9}, {1,56.7,31.5}, {1,57.0,31.7},
                                        {1,63.5,31.9}, {1,65.3,32.0}, {1,71.1,32.1}, {1,77.0,32.5},
                                        {1,77.8,32.9}
        };
        
        this.vectorY = new double[][] { {251.3}, {251.3}, {248.3}, {267.5}, {273.0}, {276.5}, {270.3}, {274.9},
                                        {285.0}, {290.0}, {297.0}, {302.5}, {304.5}, {309.3}, {321.7}, {330.7},
                                        {349.0},
        
        };
        
        this.transX = new double[this.matrizX[0].length][this.matrizX.length];
        
    }
    
    public double[][] Multiplicacion(double[][] value1, double[][] value2){
        
        int fila1 = value1.length;
        int columna1 = value1[0].length;
        
        int fila2 = value2.length;
        int columna2 = value2[0].length;
        
        double [][] multiplica = new double [fila1][columna2];
        
        for(int i = 0; i < fila1; i++){
            for(int j = 0; j < columna2; j++){
                for(int k = 0; k < columna1; k++){
                    multiplica[i][j] += value1[i][k] * value2[k][j];
                }
            }
        }
        
        return multiplica;
    }
    
    public double[][] Transpuesta(double [][] matriz){
        
        int fila = matriz.length;
        int columna = matriz[0].length;
        
        double [][] aux = new double [columna][fila];
        
        for(int i = 0; i < fila; i++){
            for(int j = 0; j < columna; j++){
                aux[j][i] = matriz[i][j];
            }
        }
        return aux;
    }
    
    public double Determinante(double [][] matriz){
        
        double aux1, aux2, aux3, resultado;
        aux1 = (matriz[0][0] * matriz[1][1] * matriz[2][2]) + (matriz[0][2] * matriz[0][1] * matriz[1][2]);
        aux2 = (matriz[0][2] * matriz[1][2] * matriz[0][1]) - (matriz[0][2] * matriz[1][1] * matriz[0][2]);
        aux3 = - (matriz[0][0] * matriz[1][2] * matriz[2][1]) - (matriz[2][2] * matriz[0][1] * matriz[1][0]);
        resultado = (aux1 + aux2 + aux3);
       
        return resultado;
    }

    public double[][] AdjuntaCofactor(double [][] matriz){
        
        double aux[][] = new double[3][3];
        aux[0][0] = ((matriz[1][1] * matriz[2][2])) - ((matriz[1][2] * matriz[2][1]));
        aux[0][1] = -1 * ((matriz[1][0] * matriz[2][2]) - ((matriz[1][2] * matriz[2][0])));
        aux[0][2] = ((matriz[1][2] * matriz[0][1])) - ((matriz[1][1] * matriz[0][2]));
        aux[1][0] = -1 * ((matriz[0][1] * matriz[2][2]) - ((matriz[0][2] * matriz[2][1])));
        aux[1][1] = ((matriz[0][0] * matriz[2][2])) - ((matriz[0][2] * matriz[2][0]));
        aux[1][2] = -1 * ((matriz[0][0] * matriz[2][1]) - ((matriz[0][1] * matriz[2][0])));
        aux[2][0] = ((matriz[0][1] * matriz[1][2])) - ((matriz[0][2] * matriz[1][1]));
        aux[2][1] = -1 * ((matriz[0][0] * matriz[1][2]) - ((matriz[0][2] * matriz[1][0])));
        aux[2][2] = ((matriz[0][0] * matriz[1][1])) - ((matriz[0][1] * matriz[1][0]));
        
        return aux;
    }
    
    public double[][] Inversa(double [][] matriz){
        
        double aux1 = 1 / Determinante(matriz);
        double aux2[][] = AdjuntaCofactor(matriz);
        int fila = aux2.length;
        int columna = aux2[0].length;
        double resultado[][] = new double[fila][columna];
        
        for(int i = 0; i < fila; i++){
            for(int j = 0; j < columna; j++){
                resultado[i][j] = aux2[i][j] * aux1;
            }
        }
        
        return resultado;
    }
    
    
    
    public void ResultadoFinal(){
        
        this.transX = Transpuesta(this.matrizX);
        
        double[][] XtransX = new double[this.transX.length][this.matrizX[0].length];
        XtransX = Multiplicacion(this.transX, this.matrizX);
        
        double[][] XtransY = new double[this.transX.length][this.vectorY[0].length];
        XtransY = Multiplicacion(this.transX, this.vectorY);
        
        double[][] resInv = Inversa(XtransX);
        double[][] resultado = Multiplicacion(resInv, XtransY);
        
        Imprimir(resultado);
    }
    
    public void Imprimir(double x[][]){
    double fila= x.length;
    double columnas= x[0].length;

    for(int i=0;i<fila;i++){
            for(int j=0;j<columnas;j++){
                System.out.print(x[i][j]+" ");
            }
             System.out.println("\n");
        }
    }
    
}