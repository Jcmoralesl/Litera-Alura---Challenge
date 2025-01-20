package com.alurachallenge.challengeLiteraAlura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private GutendexService gutendexService;

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run (String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			System.out.println("== Menú de opciones ==");
			System.out.println("1. Buscar libro por título");
			System.out.println("2. Listar libros registrados");
			System.out.println("3. Listar libros por idioma");
			System.out.println("4. Listar libros por autores registrados");
			System.out.println("5. Listar autores vivos en un determinado año");
			System.out.println("0. Salir");
			System.out.println("Elige una opción");

			int option = scanner.nextInt();

			switch (option) {
				case 1:
				System.out.println("Introduce el titulo del libro: ");
				String title = scanner.nextLine();
				List<Book> books = gutendexService.searchBookByTitle(title);
				if (books.isEmpty()) {
					System.out.println("No se ha encontrado con este titulo");
				} else {
					books.forEach(book -> System.out.println(book.getTitle() + " - " + book.getAuthor()));
				}
				break;

				case 2:

					List<Book> registeredBooks = gutendexService.listRegisterdBooks();
					if (registeredBooks.isEmpty()) {
						System.out.println("No hay libros registrados");
					} else {
						registeredBooks.forEach(book -> System.out.println(book.getTitle() + "" + book.getAuthor()));
					}
					break;

				case 3:
					System.out.println("Introduce el idioma");
					String language = scanner.nextLine();
					List<Book> booksByLanguage = gutendexService.listBooksByLanguage(language);
					if (booksByLanguage.isEmpty()) {
						System.out.println("No se encontraron libros en ese idioma.");
					} else {
						booksByLanguage.forEach(book -> System.out.println(book.getTitle() + " - " + book.getAuthor()));
					}
					break;


				case 4:
					System.out.println("Funcionalidad no implementada completamente.");
					break;

				case 5:
					System.out.print("Introduce el año: ");
					int year = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Funcionalidad no implementada completamente.");
					break;

				case 0:
					exit = true;
					System.out.println("Hasta luego, gracias por usar la aplicación");
					break;

				default:
					System.out.println("Opcion no valida, Intenta de nuevo");
			}
			}




		}
	}

