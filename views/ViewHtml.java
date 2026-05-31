package views;

import java.util.Scanner;

import controllers.ControllerHTML;

public class ViewHtml {
    Scanner scanner;
    ControllerHTML controller;

    // Todo Empezar la funcionalidad para que se pueda agregar un tag dentro de otro
    public ViewHtml(Scanner scanner, ControllerHTML controller) {
        this.scanner = scanner;
        this.controller = controller;
    }

    public void startProgram() {
        System.out.println("Welcome to the HTML framework!!");
        displayTagMenu();
    }

    public void displayTagMenu() {
        System.out.println(
                "Select tag... \n\n [1]--><body> \n[2]--><p> \n[3]--><a> \n[4]--><img>\n [5]--> Insertar tag dentro de otro \n[6]--> Renderizar Pagina");

        selectOption();
    }

    public void selectOption() {
        while (true) {

            try {
                int option;
                option = Integer.parseInt(scanner.nextLine());
                while (option > 6 || option < 1) {
                    System.err.println("Selected option is waaay beyond program understanding");
                    option = Integer.parseInt(scanner.nextLine());
                }
                caseOption(option);
                System.out.println(
                        "Select tag... \n\n [1]--><body> \n[2]--><p> \n[3]--><a> \n[4]--><img>\n [5]--> Renderizar Pagina \n[6]--> Finalizar Programa");

            } catch (Exception e) {
                System.err.println("Invalid value, pls try again" + e);
            }
        }
    }

    public void caseOption(int value) {
        switch (value) {
            case 1:
                addBodyTag();
                break;
            case 2:
                addParragraphTag();
                break;
            case 3:
                addAnchorTag();
                break;
            case 4:
                addImageTag();
                break;
            case 5:
                showPage();
                break;
            case 6:
                byeBye();
                break;
            default:
                break;
        }
    }

    public void showPage() {
        System.out.println(controller.createPage());
    }

    public void addBodyTag() {
        controller.createBody();
        showPage();

    }

    public void addParragraphTag(boolean recursiveParameter) {
        boolean isRecursive = recursiveParameter;
        int opcion;
        System.out.println("\nElija una opcion para crear el <p>\n [1]--> Escribir \n [2]--> Insertar otro tag");
        try {

            opcion = Integer.parseInt(scanner.nextLine());
            while (opcion < 1 || opcion > 2) {
                System.out.println("Opcion fuera de rango, intentelo de nuevo por favor");
                opcion = Integer.parseInt(scanner.nextLine());
            }
            switch (opcion) {
                case 1:
                    if (!isRecursive) {
                        System.out.println("Escriba el texto debajo por favor");
                        String text;
                        text = scanner.nextLine();
                        controller.createParragraph(text, null);
                    }

                    break;
                case 2:
                    // TODO implementar la logica de insercion de tags compuestos
                    // Todo 1. Agregar el tag con los datos hasta el momento.
                    // todo 2. Ingresar el nuevo tag en la ultima referencia de tags, permitiendo
                    // esta operacion de manera recursiva.
                    // TODo entender bien las opciones, dedse el view, de agregar parrafo y Anchor
                    break;

                default:
                    break;
            }
            showPage();
        } catch (Exception e) {
            System.out.println("Ocurrio la siguiente excepcion: " + e);
        }

    }

    public void addAnchorTag(boolean recursiveParameter) {
        boolean isRecursive = recursiveParameter;
        String href;
        int opcion;
        System.out.println("\nEscriba el link por favor");
        href = scanner.nextLine();
        System.out.println(
                "\nElija una opcion para crear el <a>\n [1]--> Escribir Texto \n [2]--> Insertar otro tag");

        try {

            opcion = Integer.parseInt(scanner.nextLine());
            while (opcion < 1 || opcion > 2) {
                System.out.println("Opcion fuera de rango, intentelo de nuevo por favor");
                opcion = Integer.parseInt(scanner.nextLine());
            }
            switch (opcion) {
                case 1:
                    String text;
                    System.out.println("Ingrese el texto por favor");
                    text = scanner.nextLine();
                    controller.createAnchor(text, href, null);

                    break;
                case 2:
                    // TODO implementar la logica de insercion de tags compuestos

                    break;

                default:
                    break;
            }
            showPage();
        } catch (Exception e) {
            System.out.println("Ocurrio la siguiente excepcion: " + e);
        }
        showPage();
    }

    public void addImageTag() {
        String url;
        String alt;
        System.out.println("Ingrese el URL");
        url = scanner.nextLine();
        System.out.println("Ingrese el texto alternativo");
        alt = scanner.nextLine();
        controller.createImage(url, alt);
        showPage();
    }

    public void byeBye() {
        System.out.println("Grancias por probarmeee!!!");
        scanner.close();
        System.exit(0);
    }

}
