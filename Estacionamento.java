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
    }    

    public static void cadastrarVeiculo(Scanner scanner) {
        System.out.println("Cadastrar Veiculo");
        System.out.println("Informe o nome do modelo do Veiculo:");
        String nome = scanner.next();
        System.out.println("Digite o tipo: ([M] Moto; [C] Carro; [B] Bicicleta)");
        String tipo = scanner.next();
        try{
            switch (tipo) {
                case "M":
                    System.out.println("Informe a placa da moto:");
                    String placaMoto = scanner.next();
                    System.out.println("Informe a quantidade de cilindradas da moto:");
                    int cilindrada = scanner.nextInt();
                    try {
                        Moto moto = new Moto(
                            nome,
                            placaMoto,
                            cilindrada
                        );
                        System.out.println("Moto cadastrada com sucesso!");
                        System.out.println(moto);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "C":
                    System.out.println("Informe a placa do carro:");
                    String placaCarro = scanner.next();
                    System.out.println("Informe a cor do carro:");
                    String corCarro = scanner.next();
                    try {
                        Carro carro = new Carro(
                            nome,
                            placaCarro,
                            corCarro
                        );
                        System.out.println("Carro cadastrado com sucesso!");
                        System.out.println(carro);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "B":
                    System.out.println("Informe a marca da Bike:");
                    String marcaBike = scanner.next();
                    System.out.println("Informe a cor da Bike:");
                    String corBike = scanner.next();
                    try {
                        Bicicleta bicicleta = new Bicicleta(
                            nome,
                            marcaBike,
                            corBike
                        );
                        System.out.println("Bicicleta cadastrada com sucesso!");
                        System.out.println(bicicleta);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cadastrarVaga(Scanner scanner) {
        System.out.println("Cadastrar Vaga");
        System.out.println("Informe o numero da vaga:");
        int numero = scanner.nextInt();
        System.out.println("Cadastre o tipo da vaga, informando para qual dos veiculos a vaga pertence \n ([M] Moto; [C] Carro; [B] Bicicleta):");
        String tipoVaga = scanner.next();
        try{
            switch (tipoVaga) {
                case "M":
                tipoVaga = "Moto";
                    break;
                case "C":
                tipoVaga = "Carro";
                    break;
                case "B":
                tipoVaga = "Bicicleta";
                    break;
                default:
                    break;
            }
            if (tipoVaga == null) {
                System.out.println("Veiculo não existe");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
            System.out.println("Cadastre o tamanho da vaga \n ([P] Pequeno; [M] Médio; [G] Grande): ");
            String tamanho = scanner.next();
        try {
            switch (tamanho) {
                case "P":
                tamanho = "Pequeno";
                    break;
                case "M":
                tamanho = "Médio";
                    break;
                case "G":
                tamanho = "Grande";
                    break;
                default:
                    break;
            }
            if (tamanho == null) {
                System.out.println("Tamanho não existe");
            }       
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            System.out.println("Cadastre o valor da vaga: ");
            Double preco = scanner.nextDouble();
            
            Vaga vaga = new Vaga(numero, tipoVaga, tamanho, preco);
            System.out.println("Vaga cadastrada com sucesso!");
            System.out.println(vaga);
    }


    public static void cadastrarLocacao(Scanner scanner) {
        System.out.println("Cadastrar locação");
        System.out.println("Informe a data da locação:");
        String data = scanner.next();
        System.out.println("Digite o id da vaga: ");
        try {
            int idVaga = scanner.nextInt();
            Vaga vaga = Vaga.getVaga(idVaga);
            System.out.println("Digite o id do veiculo: ");
            int idVeiculo = scanner.nextInt();
            String tipo = vaga.getTipo();
            Veiculo veiculo = null;
            switch (tipo) {
                case "C":
                    veiculo = Carro.getCarro(idVeiculo);
                    break;
                case "M":
                    veiculo = Moto.getMoto(idVeiculo);
                    break;
                case "B":
                    veiculo = Bicicleta.getBicicleta(idVeiculo);
                    break;
                default:
                    break;
            }
            if (veiculo == null) {
                throw new Exception("Veiculo não existe");
            }
            Locacao locacao = new Locacao(data, veiculo, vaga);
            System.out.println("Locação cadastrada com sucesso!");
            System.out.println(locacao);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void listarVeiculos() {
        try{
            System.out.println("Listar motos");
            for (Moto moto : Moto.getMotos()) {
                System.out.println(moto);
            }
            System.out.println("Listar carros");
            for (Carro carro : Carro.getCarros()) {
                System.out.println(carro);
            }
            System.out.println("Listar bikes");
            for (Bicicleta bicicleta : Bicicleta.getBicicletas()) {
                System.out.println(bicicleta);
            }
        }catch(Exception e) {
            System.out.println("Erro ao listar veioculos " + e.getMessage());
        }
    }

    public static void listarVagas() {
        try{
            System.out.println("Listar vagas");
            for (Vaga vaga : Vaga.getVagas()) {
                System.out.println(vaga);
            }
        }catch(Exception e) {
            System.out.println("Erro ao listar vagas " + e.getMessage());
        }
    }

    public static void listarLocacoes() {
        try{
            System.out.println("Listar locações");
            for (Locacao locacao : Locacao.getLocacoes()) {
                System.out.println(locacao);
            }
        }catch(Exception e) {
            System.out.println("Erro ao listar locações " + e.getMessage());
        }
    }

    public static void removerVeiculo(Scanner scanner) {
        System.out.println("Remover veiculo");
        System.out.println("Informe o Id do veiculo:");
        int idVeiculo = scanner.nextInt();
        System.out.println("Informe o tipo ([M] Moto; [C] Carro; [B] Bicicleta): ");
        String tipoVeiculo = scanner.next();

        try {
            switch (tipoVeiculo) {
                case "M":
                    Moto.removeMoto(idVeiculo);
                    break;
                case "C":
                    Carro.removeCarro(idVeiculo);
                    break;
                case "B":
                    Bicicleta.removeBicicleta(idVeiculo);
                    break;
                default:
                    break;
            }
            System.out.println("Veiculo removido com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void removerVaga(Scanner scanner) {
        System.out.println("Remover Vaga");
        System.out.println("Informe o Id da vaga:");
        int idVaga = scanner.nextInt();
        try {
            Vaga.removeVaga(idVaga);
            System.out.println("Vaga removida com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void removerLocacao(Scanner scanner) {
        System.out.println("Remover locação");
        System.out.println("Informe o Id da locação:");
        int idLocacao = scanner.nextInt();
        try {
            Locacao.removeLocacao(idLocacao);
            System.out.println("Locação removida com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sair() {
        System.out.println("Saindo...");
        System.exit(0);
    }
    
    
}