package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        IRadio radio = new CarRadio(); // usamos la interfaz
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0) {

            System.out.println("1. Prender radio");
            System.out.println("2. Cambiar AM/FM");
            System.out.println("3. Avanzar en el dial");
            System.out.println("4. Guardar Estacion");
            System.out.println("5. Seleccionar Estacion guardada");
            System.out.println("6. Apagar radio");
            System.out.println("0. Salir");

            option = sc.nextInt();

            if (option == 1) {
                radio.turnOn();

            } else if (option == 2) {
                radio.toggleStationType();

            } else if (option == 3) {
                radio.goForward();

            } else if (option == 4) {
                if (radio.getCurrentStation() != null) {
                    System.out.print("Ingrese botón (1-12): ");
                    int pos = sc.nextInt();
                    radio.saveStation(radio.getCurrentStation(), pos);
                } else {
                    System.out.println("El radio está apagado.");
                }

            } else if (option == 5) {
                System.out.print("Ingrese botón (1-12): ");
                int pos = sc.nextInt();
                radio.selectStation(pos);

            } else if (option == 6) {
                radio.turnOff();

            } else if (option != 0) {
                System.out.println("Opción inválida.");
            }

            if (radio.getCurrentStation() != null) {
                System.out.println("Estación actual: "
                        + radio.getCurrentStation().getFrequency()
                        + " " + radio.getCurrentStation().getType());
            }
        }

        sc.close();
    }
}