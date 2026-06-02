package views;

import java.util.Scanner;

import controllers.ControllerHTML;

public class ViewHtml {
    Scanner scanner;
    ControllerHTML controller;

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
                addParragraphTag(true);
                break;
            case 3:
                addAnchorTag(true);
                break;
            case 4:
                addImageTag(true);
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

    public void displayMinorTagMenu() {
        System.out.println(
                "Select tag... \n\n[1]--><p> \n[2]--><a> \n[3]--><img>");
        selectMinorOption();

    }

    public void selectMinorOption() {

        try {
            int option;
            option = Integer.parseInt(scanner.nextLine());
            while (option > 3 || option < 1) {
                System.err.println("Selected option is waaay beyond program understanding");
                option = Integer.parseInt(scanner.nextLine());
            }
            caseMinorOption(option);
            System.out.println(
                    "Select tag... \n\n[1]--><p> \n[2]--><a> \n[3]--><img>");

        } catch (Exception e) {
            System.err.println("Invalid value, pls try again" + e);
        }

    }

    public void caseMinorOption(int value) {
        switch (value) {
            case 1:
                addParragraphTag(false);
                break;
            case 2:
                addAnchorTag(false);
                break;
            case 3:
                addImageTag(false);
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

    public void addParragraphTag(boolean isInsertingInDOM) {
        boolean insertingInDOM = isInsertingInDOM;
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
                    if (insertingInDOM) {
                        System.out.println("Escriba el texto debajo por favor");
                        String text;
                        text = scanner.nextLine();
                        controller.createParragraph(text, null);
                    } else {
                        System.out.println("Escriba el texto debajo por favor");
                        String text;
                        text = scanner.nextLine();
                        controller.insertParragraphInLastTag(text, null);
                    }

                    break;
                case 2:

                    if (insertingInDOM) {

                        controller.createParragraph(null, null);
                        displayMinorTagMenu();

                    } else {
                        controller.insertParragraphInLastTag(null, null);
                        // ultimo elemento en vez del DOM
                        displayMinorTagMenu();

                    }

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
        boolean insertingInDOM = recursiveParameter;
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
                    if (insertingInDOM) {

                        controller.createAnchor(text, href, null);
                    } else {
                        controller.insertAnchorInLastTag(text, text, null);
                    }

                    break;
                case 2:

                    System.out.println("A continuacion elija el tag a insertar");
                    if (insertingInDOM) {
                        controller.createAnchor("", href, null);
                        displayMinorTagMenu();
                    } else {
                        // de tags recursivo
                        controller.insertAnchorInLastTag("", href, null);
                        displayMinorTagMenu();
                    }

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

    public void addImageTag(boolean recursiveParameter) {
        boolean insertingInDOM = recursiveParameter;
        String url;
        String alt;
        System.out.println("Ingrese el URL");
        url = scanner.nextLine();
        System.out.println("Ingrese el texto alternativo");
        alt = scanner.nextLine();
        if (insertingInDOM) {

            controller.createImage(url, alt);
        } else {
            controller.insertImageInLastTag(url, alt);

        }
        showPage();
    }

    public void byeBye() {
        System.out.println("Grancias por probarmeee!!!");
        scanner.close();
        System.exit(0);
    }

}
