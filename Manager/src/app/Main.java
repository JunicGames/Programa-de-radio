package app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IRadio radio = new CarRadio();

        boolean running = true;

        while (running) {
            System.out.println("--- RADIO ---");
            System.out.println("1. Encender radio");
            System.out.println("2. Cambiar AM / FM");
            System.out.println("3. Avanzar emisora");
            System.out.println("4. Retroceder emisora");
            System.out.println("5. Guardar emisora");
            System.out.println("6. Seleccionar emisora guardada");
            System.out.println("7. Apagar radio");
            System.out.println("8. Salir");
            System.out.print("Seleccione opción: ");

            int option = scanner.nextInt();

            switch (option) {
                    case 1:
                        radio.turnOn();
                        System.out.println("Radio encendido");
                        break;

                    case 2:
                        radio.toggleStationType();
                        break;

                    case 3:
                        radio.goForward();
                        break;

                    case 4:
                        radio.goBackwards();
                        break;

                    case 5:
                        System.out.print("Botón (1-12): ");
                        int pos = scanner.nextInt();
                        StationValue current = radio.getCurrentStation();
                        if (current != null) {
                            radio.saveStation(current, pos);
                            System.out.println("Emisora guardada");
                        }
                        break;

                    case 6:
                        System.out.print("Botón (1-12): ");
                        int select = scanner.nextInt();
                        radio.selectStation(select);
                        break;

                    case 7:
                        radio.turnOff();
                        System.out.println("Radio apagado");
                        break;

                    case 8:
                        running = false;
                        break;
                }

            StationValue station = radio.getCurrentStation();
            if (station != null) {
                System.out.println("Estación actual: " + station);
            }
        }

        scanner.close();
    }
}