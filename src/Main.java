import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();

        while (true) {
            System.out.println("\n=== TO-DO LIST ===");
            System.out.println("1 - Listar tarefas");
            System.out.println("2 - Adicionar tarefas");
            System.out.println("3 - Remover tarefas");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opcao: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    if (tasks.isEmpty()) {
                        System.out.println("Nenhum task foi encontrado.");
                    } else {
                        System.out.println("\nSuas tarefas:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + " - " + tasks.get(i));
                        }
                    }
                    break;

                case "2":
                    System.out.print("Digite a nova tarefa: ");
                    String newTask = scanner.nextLine();
                    if (!newTask.isBlank()) {
                        tasks.add(newTask);
                        System.out.println("Tarefa adicionada com sucesso!");
                    } else {
                        System.out.println("Tarefa vazia não foi adicionada.");
                    }
                    break;

                case "3":
                    if (tasks.isEmpty()) {
                        System.out.println("Não há tarefas para remover.");
                        break;
                    }
                    System.out.print("Digite o número da tarefa para remover: ");
                    try {
                        int index = Integer.parseInt(scanner.nextLine());
                        if (index >= 1 && index <= tasks.size()) {
                            String removed = tasks.remove(index - 1);
                            System.out.println("Removida: " + removed);
                        } else {
                            System.out.println("Número inválido.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Digite um número válido.");
                    }
                    break;

                case "4":
                    System.out.println("Saindo... até mais!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}