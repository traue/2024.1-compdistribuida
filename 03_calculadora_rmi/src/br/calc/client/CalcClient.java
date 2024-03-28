package br.calc.client;

import java.util.Scanner;
import br.calc.server.CalcInterface;
import java.rmi.Naming;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;

public class CalcClient {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {

			CalcInterface calc = (CalcInterface) Naming.lookup("//localhost:2300/Calculadora");

			System.out.print("Usuario: ");
			calc.setUsuario(sc.nextLine());
			float a, b;
			int opc = -1;
			while (opc != 0) {
				imprimeMenu();
				opc = sc.nextInt();

				switch (opc) {
				case 1:
					System.out.print("Valor A: ");
					a = sc.nextFloat();
					System.out.print("Valor B: ");
					b = sc.nextFloat();
					System.out.printf("  %.2f + %.2f = %.2f\n\n", a, b, calc.soma(a, b));
					break;
				case 2:
					System.out.print("Valor A: ");
					a = sc.nextFloat();
					System.out.print("Valor B: ");
					b = sc.nextFloat();
					System.out.printf("  %.2f - %.2f = %.2f\n\n", a, b, calc.subtrai(a, b));
					break;
				case 3:
					System.out.print("Valor A: ");
					a = sc.nextFloat();
					System.out.print("Valor B: ");
					b = sc.nextFloat();
					System.out.printf("  %.2f * %.2f = %.2f\n\n", a, b, calc.multiplica(a, b));
					break;
				case 4:
					System.out.print("Valor A: ");
					a = sc.nextFloat();
					System.out.print("Valor B: ");
					b = sc.nextFloat();
					if (b == 0) {
						System.out.println("Não pode dividir por zero!");
						break;
					}
						
					System.out.printf("  %.2f / %.2f = %.2f\n\n", a, b, calc.divide(a, b));
					break;
				default:
					continue;
				}

			}

		} catch (Exception e) {

		}

		sc.close();
	}

	private static void imprimeMenu() {
		System.out.println("----MENU----");
		System.out.println("[1]: Somar");
		System.out.println("[2]: Subtrair");
		System.out.println("[3]: Multiplicar");
		System.out.println("[4]: Dividir");
		System.out.println("[0]: Sair");
		System.out.print(">> Sua opção: ");

	}

}
