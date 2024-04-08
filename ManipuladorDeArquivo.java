import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ManipuladorDeArquivo {
    public static void main(String[] args) {
        ManipuladorDeArquivo manipulador = new ManipuladorDeArquivo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----Menu----");
            System.out.println("1. Inserir nome no arquivo");
            System.out.println("2. Mostrar todos os nomes do arquivo");
            System.out.println("3. Apagar todo o arquivo");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome para ser inserido: ");
                    String nome = scanner.nextLine();
                    manipulador.inserirNome(nome);
                    break;
                case 2:
                    System.out.println("Nomes no arquivo:");
                    manipulador.mostrarNomes();
                    break;
                case 3:
                    manipulador.apagarArquivo();
                    break;
                case 4:
                    System.out.println("Saindo.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public void inserirNome(String nome) {
        try {
            File arquivo = new File("nomes.txt");
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            FileWriter writer = new FileWriter(arquivo, true);
            writer.write(nome + "\n");
            writer.close();
            System.out.println("Nome inserido com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao inserir o nome no arquivo.");
            e.printStackTrace();
        }
    }

    public void mostrarNomes() {
        try {
            File arquivo = new File("nomes.txt");
            if (!arquivo.exists()) {
                System.out.println("O arquivo não existe.");
                return;
            }
            Scanner scanner = new Scanner(arquivo);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Erro ao mostrar os nomes do arquivo.");
            e.printStackTrace();
        }
    }

    public void apagarArquivo() {
        File arquivo = new File("nomes.txt");
        if (!arquivo.exists()) {
            System.out.println("O arquivo não existe.");
            return;
        }
        if (arquivo.delete()) {
            System.out.println("Arquivo apagado.");
        } else {
            System.out.println("Erro ao apagar o arquivo.");
        }
    }
}