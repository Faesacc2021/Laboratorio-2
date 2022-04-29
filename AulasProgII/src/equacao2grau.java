import java.util.*;
import java.lang.Math;

class segundoGrau {
  public static void main(String[] args) {  
        double a, b, c, delta, x1, x2;
      
        Scanner teclado = new Scanner(System.in);
      
        System.out.println("Digite a variável a da equacao de 2 grau:/n> ");
        a = teclado.nextDouble();
        System.out.println("Digite a variável b da equacao de 2 grau:/n> ");
        b = teclado.nextDouble();
        System.out.println("Digite a variável c da equacao de 2 grau:/n> ");
        c = teclado.nextDouble();
        
        delta = Math.pow(b,2)- 4 * a * c;
        x1 = -b + Math.sqrt(delta);
        x2 = -b - Math.sqrt(delta);

      if (delta <= 0) {
          System.out.println("Essa equacao nao apresenta raizes...");
      }
      else {
          System.out.printf("As raízes da equação são: x1 = %f e x2 = %f", x1, x2);
      }
      
  }
}