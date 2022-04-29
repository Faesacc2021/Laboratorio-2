class Main07 {
  public static void main(String[] args) {

	// impressao de valores junto com string  

        int num, a, b, c, d;
        System.out.println("O número inteiro informado de 4 dígitos é 2459!");
        num = 2459;
        d = num/1000;
        a = (num/100)%10;
        b = (num%100)/10;
        c = (num%100)%10;
        System.out.printf("Resultado: %d, %d, %d, %d.", d, a, b, c);     
  }
}
