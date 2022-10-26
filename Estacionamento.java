import java.util.Scanner;

public class Estacionamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        System.out.println("Estaciomento");
        System.out.println("Bem-vindo ao Estaciomento!");

        do {
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Cadastrar Veiculo");
            System.out.println("2 - Cadastrar Vaga");
            System.out.println("3 - Cadastrar Locação");
            System.out.println("4 - Listar Veiculos");
            System.out.println("5 - Listar Vaga");
            System.out.println("6 - Listar Locação");
            System.out.println("7 - Remover Veiculos");
            System.out.println("8 - Remover Vaga");
            System.out.println("9 - Remover Locação");
            System.out.println("10 - Sair");
            System.out.print("Opção: ");
            try {
                opcao = scanner.nextInt();
            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    cadastrarVeiculo(scanner);
                    break;
                case 2:
                    cadastrarVaga(scanner);
                    break;
                case 3:
                    cadastrarLocacao(scanner);
                    break;
                case 4:
                    listarVeiculos();
                    break;
                case 5:
                    listarVagas();
                    break;
                case 6:
                    listarLocacoes();
                    break;
                case 7:
                    removerVeiculo(scanner);
                    break;
                case 8:
                    removerVaga(scanner);
                    break;
                case 9:
                    removerLocacao(scanner);
                    break;
                case 10:
                    sair();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 10);
        

        public static void cadastrarVeiculo(Scanner scanner) {
            System.out.println("Cadastrar Veiculo");
            System.out.println("Informe o nome do Veiculo:");
            String nome = scanner.next();
    
            System.out.println("Digite o tipo: ([M] Moto; [C] Carro; [B] Bicicleta)");
            String tipo = scanner.next();
    
            switch (tipo) {
                case "M":
                    System.out.println("Informe o tempo de gestação:");
                    int gestacao = scanner.nextInt();
                    System.out.println("Informe o número da jaula:");
                    int idJaula = scanner.nextInt();
                    try {
                        Jaula jaula = Jaula.getJaula(idJaula);
                        Mamifero mamifero = new Mamifero(
                            nome,
                            especie,
                            jaula,
                            gestacao
                        );
                        System.out.println("Mamífero cadastrado com sucesso!");
                        System.out.println(mamifero);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "C":
                    System.out.println("Informe o habitat:");
                    String habitat = scanner.next();
                    System.out.println("Informe o número da jaula:");
                    idJaula = scanner.nextInt();
                    try {
                        Jaula jaula = Jaula.getJaula(idJaula);
                        Reptil reptil = new Reptil(
                            nome,
                            especie,
                            jaula,
                            habitat
                        );
                        System.out.println("Réptil cadastrado com sucesso!");
                        System.out.println(reptil);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "B":
                    System.out.println("Informe a cor da pena:");
                    String corPena = scanner.next();
                    System.out.println("Informe o número da jaula:");
                    idJaula = scanner.nextInt();
                    try {
                        Jaula jaula = Jaula.getJaula(idJaula);
                        Ave ave = new Ave(
                            nome,
                            especie,
                            jaula,
                            corPena
                        );
                        System.out.println("Ave cadastrada com sucesso!");
                        System.out.println(ave);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    
        public static void cadastrarJaula(Scanner scanner) {
            System.out.println("Cadastrar jaula");
            System.out.println("Informe o nome da jaula:");
            String nome = scanner.next();
            System.out.println("Informe o tipo da jaula:");
            String tipo = scanner.next();
            Jaula jaula = new Jaula(nome, tipo);
            System.out.println("Jaula cadastrada com sucesso!");
            System.out.println(jaula);
        }
    
        public static void cadastrarAlimentacao(Scanner scanner) {
            System.out.println("Cadastrar alimentação");
            System.out.println("Informe a data da alimentação:");
            String data = scanner.next();
            System.out.println("Informe a descrição da alimentação:");
            String descricao = scanner.next();
            System.out.println("Informe a espécie: ");
            String especie = scanner.next();
            System.out.println("Informe o número do animal:");
            int idAnimal = scanner.nextInt();
            try {
                Animal animal = null;
                switch (especie) {
                    case "M":
                        animal = Mamifero.getMamifero(idAnimal);
                        break;
                    case "R":
                        animal = Reptil.getReptil(idAnimal);
                        break;
                    case "A":
                        animal = Ave.getAve(idAnimal);
                        break;
                    default:
                        break;
                }
                if (animal == null) {
                    throw new Exception("Animal não existe");
                }
                Alimentacao alimentacao = new Alimentacao(data, descricao, animal);
                System.out.println("Alimentação cadastrada com sucesso!");
                System.out.println(alimentacao);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    
        public static void cadastrarLimpeza(Scanner scanner) {
            System.out.println("Cadastrar limpeza");
            System.out.println("Informe a data da limpeza:");
            String data = scanner.next();
            System.out.println("Informe a descrição da limpeza:");
            String descricao = scanner.next();
            System.out.println("Informe o número da jaula:");
            int idJaula = scanner.nextInt();
            try {
                Jaula jaula = Jaula.getJaula(idJaula);
                Limpeza limpeza = new Limpeza(data, descricao, jaula);
                System.out.println("Limpeza cadastrada com sucesso!");
                System.out.println(limpeza);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    
        public static void listarAlimentacoes() {
            System.out.println("Listar alimentações");
            for (Alimentacao alimentacao : Alimentacao.getAlimentacoes()) {
                System.out.println(alimentacao);
            }
        }
    
        public static void listarLimpezas() {
            System.out.println("Listar limpezas");
            for (Limpeza limpeza : Limpeza.getLimpezas()) {
                System.out.println(limpeza);
            }
        }
    
        public static void listarAnimais() {
            System.out.println("Listar aves");
            for (Ave ave : Ave.getAves()) {
                System.out.println(ave);
            }
            System.out.println("Listar mamíferos");
            for (Mamifero mamifero : Mamifero.getMamiferos()) {
                System.out.println(mamifero);
            }
            System.out.println("Listar répteis");
            for (Reptil reptil : Reptil.getRepteis()) {
                System.out.println(reptil);
            }
        }
    
        public static void listarJaulas() {
            System.out.println("Listar jaulas");
            for (Jaula jaula : Jaula.getJaulas()) {
                System.out.println(jaula);
            }
        }
    
        public static void removerAnimal(Scanner scanner) {
            System.out.println("Remover animal");
            System.out.println("Informe a espécie: ");
            String especie = scanner.next();
            System.out.println("Informe o número do animal:");
            int idAnimal = scanner.nextInt();
            try {
                switch (especie) {
                    case "M":
                        Mamifero.removeMamifero(idAnimal);
                        break;
                    case "R":
                        Reptil.removeReptil(idAnimal);
                        break;
                    case "A":
                        Ave.removeAve(idAnimal);
                        break;
                    default:
                        break;
                }
                System.out.println("Animal removido com sucesso!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    
        public static void removerJaula(Scanner scanner) {
            System.out.println("Remover jaula");
            System.out.println("Informe o número da jaula:");
            int idJaula = scanner.nextInt();
            try {
                Jaula.removeJaula(idJaula);
                System.out.println("Jaula removida com sucesso!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    
        public static void removerLimpeza(Scanner scanner) {
            System.out.println("Remover limpeza");
            System.out.println("Informe o número da limpeza:");
            int idLimpeza = scanner.nextInt();
            try {
                Limpeza.removeLimpeza(idLimpeza);
                System.out.println("Limpeza removida com sucesso!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    
        public static void removerAlimentacao(Scanner scanner) {
            System.out.println("Remover alimentação");
            System.out.println("Informe o número da alimentação:");
            int idAlimentacao = scanner.nextInt();
            try {
                Alimentacao.removeAlimentacao(idAlimentacao);
                System.out.println("Alimentação removida com sucesso!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    
        public static void sair() {
            System.out.println("Saindo...");
            System.exit(0);
        }
    
    
    
    }