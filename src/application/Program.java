package application;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados da conta");
		System.out.print("Número: ");
		int num = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String titular = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double saldo = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double limite = sc.nextDouble();
		
		Account account = new Account(num, titular, saldo, limite); // construtor
		
		System.out.println();
		System.out.print("Entre com o montante a ser retirado: ");
		
		try {
		account.withdraw(sc.nextDouble());
		System.out.println("Novo saldo: " + String.format("%.2f", account.getBalance()));
		}
		catch (DomainException e ){
			System.out.println("Erro na retirada: " + e.getMessage());
		}		
		sc.close();
	}

}
