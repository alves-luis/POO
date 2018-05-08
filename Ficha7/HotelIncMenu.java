
/**
 * Acesso às funcionalidade de HotelInc com um menu.
 *
 * @author Luís Alves
 * @version 1.0
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class HotelIncMenu {

  // 2
  public static int consultarNumeroHoteis() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Selecione uma das opções digitando 1-3:");
    System.out.println("1) Quantos hoteis existem na cadeia toda");
    System.out.println("2) Quantos hoteis existem numa localidade");
    System.out.println("3) Quantos hoteis existem de determinado tipo");
    System.out.println("4) Regressar ao menu Inicial");
    int i = 4;
    try {
      i = sc.nextInt();
    }
    catch (InputMismatchException e) {
      System.out.println("Valor inválido! Regressando ao menu!");
    }
    return i;
  }

  public static int consultarFichaHoteis() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Selecione uma das opções digitando 1-2:");
    System.out.println("1) Obter listagem de todos os hóteis");
    System.out.println("2) Obter Ficha de um hotel dado o código");
    System.out.println("3) Regressar ao menu Inicial");
    int i = 3;
    try {
      i = sc.nextInt();
    }
    catch (InputMismatchException e) {
      System.out.println("Valor inválido! Regressando ao menu!");
    }
    return i;
  }

  public static int adicionarHoteis() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Selecione o tipo de Hotel a adicionar digitando 1-5");
    System.out.println("1) Hotel");
    System.out.println("2) Hotel Premium");
    System.out.println("3) Hotel Discount");
    System.out.println("4) Hotel Standard");
    System.out.println("5) Regressar ao menu Inicial");
    int i = 0;
    try {
      i = sc.nextInt();
    }
    catch (InputMismatchException e) {
      System.out.println("Valor inválido! Regressando ao Menu!");
    }
    return i;
  }

  public static int compararHoteis() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Escolha o tipo de comparação a usar:");
    System.out.println("1) Categoria");
    System.out.println("2) Número de Quartos");
    System.out.println("3) Voltar ao menu Inicial");
    int r = 3;
    try {
      r = sc.nextInt();
    }
    catch (InputMismatchException e) {
      System.out.println("Valor inválido! Regressando ao Menu!");
    }
    return r;
  }

  public static int guardarFicheiro() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Indique o tipo de gravação que deseja realizar:");
    System.out.println("1) Ficheiro binário");
    System.out.println("2) Ficheiro CSV");
    System.out.println("3) Regressar ao menu");
    int r = 3;
    try {
      r = sc.nextInt();
    }
    catch (InputMismatchException e) {
      System.out.println("Valor inválido! Regressando ao menu!");
    }
    return r;
  }

  public static int getOpcao() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite 1-11 para escolher o que deseja fazer");
    System.out.println("1) Verificar se existe um hotel com um determinado código");
    System.out.println("2) Consultar o nº de hoteis na cadeia");
    System.out.println("3) Obter a ficha de determinados hoteis");
    System.out.println("4) Adicionar hoteis à cadeia");
    System.out.println("5) Mudar todos os hóteis da cadeia para uma nova época");
    System.out.println("6) Obter o valor máximo de receita diária");
    System.out.println("7) Obter a listagem de hóteis que dão pontos");
    System.out.println("8) Obter a listagem de hóteis por determinada ordem");
    System.out.println("9) Gravar o estado da cadeia num ficheiro");
    System.out.println("10) Carregar uma nova cadeia");
    System.out.println("11) Sair do programa");
    int i = 0;
    try {
      i = sc.nextInt();
    }
    catch (InputMismatchException e) {
      System.out.println("Valor inválido!");
    }
    return i;
  }

  public static void bemVindo() {
    System.out.println("-----Bem-vindo ao HoteisInc!-----");
  }

}
