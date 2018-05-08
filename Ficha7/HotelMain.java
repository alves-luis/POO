
/**
 * Class to teste all the Hotel Classes
 *
 * @author Luís Alves
 * @version 1.5
 */

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Iterator;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class HotelMain{
    private static void verificaSeExiste(HotelInc inc) {
      System.out.println("Insira o código do Hotel:");
      Scanner sc = new Scanner(System.in);
      String cod = sc.nextLine();
      System.out.println(inc.existeHotel(cod));
    }

    private static void consultaNumeroHoteis(HotelInc inc, int op) {
      int result = 0;
      switch(op) {
        case 1: result = inc.quantos();
                break;
        case 2: System.out.println("Insira o nome da localidade");
                Scanner sc = new Scanner(System.in);
                String loc = sc.nextLine();
                result = inc.quantos(loc);
                break;
        case 3: System.out.println("Insira o tipo de Hotel");
                sc = new Scanner(System.in);
                String tipo = sc.nextLine();
                result = inc.quantosT(tipo);
                break;
        default: return;
      }
      System.out.println("Há " + result + ((result == 1) ? " hotel." : " hoteis."));
    }

    private static void consultaFichaHoteis(HotelInc inc, int num) {
      switch(num) {
        case 1: System.out.println(inc.getHoteis().toString());
                break;
        case 2: System.out.println("Insira o código do Hotel:");
                Scanner sc = new Scanner(System.in);
                String cod = sc.nextLine();
                try {
                  System.out.println(inc.getHotel(cod).toString());
                }
                catch (HotelException e) {
                  System.out.println(e.getMessage());
                }
                break;
        default: break;
      }
    }

    private static void adicionaHotel(HotelInc inc, int tipo) {
      if (tipo < 1 || tipo > 4) return;
      int numTentativas = 3;
      Scanner sc = new Scanner(System.in);
      Hotel h = new Hotel();

      System.out.println("Insira o nome do Hotel:");
      h.setNome(sc.nextLine());

      System.out.println("Insira o código do Hotel:");
      h.setCod(sc.nextLine());

      System.out.println("Insira a localização do Hotel:");
      h.setLocal(sc.nextLine());

      while (numTentativas > 0) {
        try {
          System.out.println("Insira a categoria do Hotel (de 1-5): (" + numTentativas + " tentativas restantes)");
          h.setCategoria(sc.nextInt());
          break;
        }
        catch (HotelParametersException e) {
          System.out.println(e.getMessage());
          numTentativas--;
          continue;
        }
        catch (InputMismatchException e) {
          System.out.println("Input errado!");
          numTentativas = 0;
          break;
        }
      }
      if (numTentativas == 0) {
        System.out.println("Falhaste em adicionar a categoria. Regressando ao Menu Inicial");
        return;
      }

      numTentativas = 3;
      while(numTentativas > 0) {
        try {
          System.out.println("Insira o nº de quartos disponíveis: (" + numTentativas + " tentativas restantes)");
          h.setDisponiveis(sc.nextInt());
          break;
        }
        catch (HotelParametersException e) {
          System.out.println(e.getMessage());
          numTentativas--;
          continue;
        }
        catch (InputMismatchException e) {
          System.out.println("Input do tipo errado!");
          numTentativas = 0;
          break;
        }
      }
      if (numTentativas == 0) {
        System.out.println("Falhaste em adicionar o nº de quartos disponíveis. Regressando ao Menu Inicial");
        return;
      }

      numTentativas = 3;
      while(numTentativas > 0) {
        try {
          System.out.println("Insira o preço: (" + numTentativas + " tentativas restantes)");
          h.setPreco(sc.nextInt());
          break;
        }
        catch (HotelParametersException e) {
          System.out.println(e.getMessage());
          numTentativas--;
          continue;
        }
        catch (InputMismatchException e) {
          System.out.println("Input do tipo errado! Regressando ao menu!");
          break;
        }
      }
      if (numTentativas == 0) {
        System.out.println("Falhaste em adicionar o preço. Regressando ao Menu Inicial");
        return;
      }

      switch(tipo) {
        case 1: try {
                  inc.adiciona(h.clone());
                }
                catch (HotelException e) {
                  System.out.println(e.getMessage());
                }
                break;
        case 2: numTentativas = 3;
                while(numTentativas > 0) {
                  try {
                    System.out.println("Insira a Taxa de Luxo: (" + numTentativas + " tentativas restantes)");
                    HotelPremium hp = new HotelPremium(h);
                    hp.setTaxaDeLuxo(sc.nextDouble());
                    System.out.println("Insira os Pontos por Euro:");
                    hp.setPontosPorEuro(sc.nextInt());
                    try {
                      inc.adiciona(hp.clone());
                    }
                    catch (HotelException e) {
                      System.out.println(e.getMessage());
                    }
                    catch (InputMismatchException e) {
                      System.out.println("Input inválido! Regressando ao menu inicial!");
                    }
                    break;
                  }
                  catch (HotelParametersException e) {
                    System.out.println(e.getMessage());
                    numTentativas--;
                    continue;
                  }
                }
                break;

        case 3: numTentativas = 3;
                while(numTentativas > 0) {
                  try {
                    System.out.println("Insira a Ocupação: (" + numTentativas + " tentativas restantes)");
                    HotelDiscount hd = new HotelDiscount(h);
                    hd.setOcupacao(sc.nextDouble());
                    try {
                      inc.adiciona(hd.clone());
                    }
                    catch (HotelException e) {
                      System.out.println(e.getMessage());
                    }
                    break;
                  }
                  catch (HotelParametersException e) {
                    System.out.println(e.getMessage());
                    numTentativas--;
                    continue;
                  }
                }
                break;
        case 4: System.out.println("Insira a Época (true/ALTA or false/BAIXA): (" + numTentativas + " tentativas restantes)");
                HotelStandard hs = new HotelStandard(h);
                hs.setEpoca(sc.nextBoolean());
                System.out.println("Insira os Pontos por Euro:");
                hs.setPontosPorEuro(sc.nextInt());
                try {
                  inc.adiciona(hs.clone());
                }
                catch (HotelException e) {
                  System.out.println(e.getMessage());
                }
                catch (InputMismatchException e) {
                  System.out.println("Input inválido! Regressando ao menu!");
                }
                break;
        default: break;
      }
      System.out.println("Hotel adicionado com sucesso!");
    }

    private static void mudarEpoca(HotelInc inc) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Indique a nova época (true/ALTA or false/BAIXA): ");
      inc.mudaPara(sc.nextBoolean());
    }

    private static void comparaHoteis(HotelInc inc, int comp) {
        TreeSet<Hotel> res;
        switch(comp) {
        case 1: res = inc.ordenarHoteis(HotelInc.getComparador("Categoria"));
                System.out.println(res.toString());
                break;
        case 2: res = inc.ordenarHoteis(HotelInc.getComparador("Quartos"));
                System.out.println(res.toString());
        default: break;

      }
    }

    private static void guardaHoteis(HotelInc inc, int r) {
      Scanner sc = new Scanner(System.in);
      switch (r) {
        case 1: System.out.println("Indique o nome do ficheiro:");
                try {
                  inc.guardaEstadoObject(sc.nextLine());
                }
                catch (FileNotFoundException e) {
                  System.out.println("Ficheiro não encontrado!");
                }
                catch (IOException e) {
                  System.out.println("Erro ao guardar o ficheiro!");
                }
                break;

        case 2: System.out.println("Indique o nome do ficheiro:");
                try {
                  inc.escreveEmFicheiroCSV(sc.nextLine());
                }
                catch (FileNotFoundException e) {
                  System.out.println("Ficheiro não encontrado!");
                }
                catch (IOException e) {
                  System.out.println("Erro ao guardar o ficheiro!");
                }
                break;
        default: break;
      }
    }

    private static HotelInc carregaHotel() {
      Scanner sc = new Scanner(System.in);
      HotelInc result = new HotelInc();
      System.out.println("Indique o nome do ficheiro:");
      try {
        result = HotelInc.carregaEstadoObject(sc.nextLine());
      }
      catch (FileNotFoundException e) {
        System.out.println("Ficheiro não encontrado!");
      }
      catch (IOException e) {
        System.out.println("Erro a carregar o ficheiro!");
      }
      catch (ClassNotFoundException e) {
        System.out.println("Classe não é válida!");
      }
      return result;
    }

    public static void main(String[] args) {
      HotelInc inc = new HotelInc();
      HotelInc.addComparador(new ComparadorPorCategoria(),"Categoria");
      HotelInc.addComparador(new ComparadorPorNumeroQuartos(),"Quartos");
      HotelIncMenu.bemVindo();
      int op;
      do {
        op = HotelIncMenu.getOpcao();
        switch (op) {
          case 1: verificaSeExiste(inc);
                  break;

          case 2: int numHoteis = HotelIncMenu.consultarNumeroHoteis();
                  consultaNumeroHoteis(inc,numHoteis);
                  break;

          case 3: int fichaHoteis = HotelIncMenu.consultarFichaHoteis();
                  consultaFichaHoteis(inc,fichaHoteis);
                  break;

          case 4: int adiciona = HotelIncMenu.adicionarHoteis();
                  adicionaHotel(inc,adiciona);
                  break;

          case 5: mudarEpoca(inc);
                  break;

          case 6: System.out.println("Máxima receita diária: " + inc.getMaxReceitaDiaria());
                  break;

          case 7: System.out.println(inc.daoPontos().toString());
                  break;

          case 8: int compara = HotelIncMenu.compararHoteis();
                  comparaHoteis(inc,compara);
                  break;

          case 9: int file = HotelIncMenu.guardarFicheiro();
                  guardaHoteis(inc,file);
                  break;

          case 10: inc = carregaHotel();
                   break;

          default: break;
        }
      } while (op != 11);
      System.out.println("Byeeee!");
    }
}
