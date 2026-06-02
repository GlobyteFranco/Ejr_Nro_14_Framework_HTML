import java.util.Scanner;

import controllers.ControllerHTML;
import views.ViewHtml;

public class App {
    public static void main(String[] args) {
        System.out.println("HEllowyyyyy beautifully worldyyyy");
        ViewHtml view = new ViewHtml(new Scanner(System.in), new ControllerHTML());
        view.startProgram();
    }
}