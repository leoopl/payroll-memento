package folha;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	private static List<Empregado> employedList = new ArrayList<Empregado>();

	// Memento
	private static Originator originator = new Originator();
	private static CareTaker careTakerUndo = new CareTaker();
	private static CareTaker careTakerRedo = new CareTaker();
	// Memento

	static boolean list(List<Empregado> employedList) {
		if (employedList.isEmpty()) {
			System.out.println("Nenhum empregrado cadastrado!");
			return false;
		} else {
			for (int i = 0; i < employedList.size(); i++) {
				System.out.println("ID: " + employedList.get(i).getID() + " - " + employedList.get(i).getName());
			}
		}
		return true;
	}

	static void add(int id) {

		Empregado emp = new Empregado();
		Scanner x = new Scanner(System.in);
		System.out.print("Name: ");
		String theName = x.nextLine();
		emp.setName(theName);
		System.out.print("Address: ");
		String theAddress = x.nextLine();
		emp.setAddress(theAddress);
		int input;
		do {
			System.out.println("Choose your employee type:\n [0] Hourly \n [1] Salaried \n [2] Commissioned");
			input = x.nextInt();
			if (input > 2 || input < 0) {
				System.out.println("Tente de novo!");
			} else {
				emp.setType(input);
			}
		} while (input > 2 || input < 0);
		System.out.println("Employee Salary: ");
		double salary = x.nextDouble();
		emp.setSalary(salary);
		do {
			System.out.println(
					"Choose your Payment Method:\n [0] Check payment by the post office \n [1] Check payment in hands \n [2] Bank deposit");
			input = x.nextInt();
			if (input > 2 || input < 0) {
				System.out.println("Tente de novo!");
			} else {
				emp.setPaymentMethod(input);
			}
		} while (input > 2 || input < 0);

		emp.setID(id);
		emp.getStatus();
		employedList.add(emp);

	}

	static void remove(List<Empregado> employedList) {
		if (list(employedList)) {
			Scanner x = new Scanner(System.in);
			System.out.println("id do funcionario que deseja remover: ");
			int input = x.nextInt();
			if (input > employedList.size()) {
				System.out.println("Empregado inexistente!");
			} else {
				employedList.remove(input);
			}
		} else {
			System.out.println("Não há empregrado para ser removido!");
		}
	}

	static void edit() {
		if (list(employedList)) {
			Scanner in = new Scanner(System.in);
			Scanner x = new Scanner(System.in);
			System.out.println("ID do funcionario que deseja motificar: ");
			int input = in.nextInt();
			int aux = 0;
			Empregado emp = null;
			
			for (Empregado empregado : employedList) {
				if(empregado.getID() == input) {
					emp = empregado;
					aux = employedList.indexOf(empregado);
				}
			}

			int editInput;
			do {
				System.out.println("O que você deseja editar: ");
				System.out.println("[1] Nome");
				System.out.println("[2] Endereço");
				System.out.println("[3] Tipo de Empregado");
				System.out.println("[4] Metodo de pagamento");
				System.out.println("[5] Sindicato");
				System.out.println("[6] Taxa sindical");
				System.out.println("[7] Salvar");

				editInput = in.nextInt();

				switch (editInput) {
				case 1:
					System.out.println("New name: ");
					String newName = x.nextLine();
					emp.setName(newName);
					break;
				case 2:
					System.out.println("New Address: ");
					String newAddress = x.nextLine();
					emp.setAddress(newAddress);
					break;
				case 3:
					System.out.println("Choose your employee type:\n [0] Hourly \n [1] Salaried \n [2] Commissioned");
					int theType = in.nextInt();
					if (theType > 2 || theType < 0) {
						System.out.println("Tipo Invalido");
					} else {
						emp.setType(theType);
					}
					break;
				case 4:
					System.out.println(
							"Choose your Payment Method:\n [0] Check payment by the post office \n [1] Check payment in hands \n [2] Bank deposit");
					int paymentMethod = in.nextInt();
					if (paymentMethod > 2 || paymentMethod < 0) {
						System.out.println("Método Invalido");
					} else {
						emp.setPaymentMethod(paymentMethod);
					}
					break;
				case 5:
					System.out.println("Mudar estado de sindicato:\n [1] Sim\n [2] Não");
					if (in.nextInt() == 1) {
						if (emp.getSyndicate() == false) {
							emp.setSyndicate(true);
						} else if (emp.getSyndicate() == true) {
							emp.setSyndicate(false);
						}
					}
					break;
				case 6:
					if (emp.getSyndicate() == true) {
						System.out.println("Digite a nova taxa sindical: ");
						emp.setSyndicateTax(in.nextDouble());
					} else {
						System.out.println("Empregado não participa do sindicato");
					}
					break;
				case 7:
					employedList.set(aux, emp);
					emp.getStatus();
					
					System.out.println(originator.toString());
					
					break;
				default:
					System.out.println("Opção invalida!");
					break;
				}

			} while (editInput != 7);

		} else {
			System.out.println("Não há empregrado para ser editado!");
		}
	}

	static void card(List<Empregado> employedList) {
		if (list(employedList)) {
			System.out.println("Escolha o ID do empregado que Lançar o cartão: ");
			Scanner in = new Scanner(System.in);
			int input = in.nextInt();
			if (input > employedList.size()) {
				System.out.println("Empregado inexistente!");
			} else {
				if (employedList.get(input).getType().equals("Hourly")) {
					System.out.println("Quantas horas vocês trabalhou: ");
					int scan = in.nextInt();
					employedList.get(input).setHours(scan);
				} else {
					System.out.println("Empregado não pode lançar cartão!");
				}
			}
		}
	}

	static void sale(List<Empregado> employedList) {
		if (list(employedList)) {
			System.out.println("Escolha o ID do empregado que Lançar a Venda: ");
			Scanner in = new Scanner(System.in);
			int input = in.nextInt();
			if (input > employedList.size()) {
				System.out.println("Empregado inexistente!");
			} else {
				if (employedList.get(input).getType().equals("Commissioned")) {
					System.out.println("Informe o valor da venda: ");
					double value = in.nextInt();
					System.out.println("Informe a porcentagem do vendedor: ");
					double pect = in.nextInt();
					value = (value * pect) / 100;
					System.out.println("Porcentagem recebida pelo vendedor: R$" + value);
					employedList.get(input).setSalary(employedList.get(input).getSalary() + value);
				} else {
					System.out.println("Empregado não pode lançar venda!");
				}
			}
		}
	}

	public static void main(String[] args) {

		int ID = 0;

		Scanner in = new Scanner(System.in);
		int input = 11;

		do {
			System.out.println("----------------MENU----------------");
			System.out.println("[1] Adição de um empregado");
			System.out.println("[2] Remoção de um empregado");
			System.out.println("[3] Lançar um Cartão de Ponto");
			System.out.println("[4] Lançar um Resultado Venda");
			// System.out.println("[5] Lançar uma taxa de serviço");
			System.out.println("[6] Alterar detalhes de um empregado");
			// System.out.println("[7] Rodar a folha de pagamento para hoje");
			// System.out.println("[8] Undo");
			// System.out.println("[9] Redo");
			// System.out.println("[10] Agenda de Pagamento");
			// System.out.println("[11] Nova Agenda de Pagamento");
			System.out.println("[0] Sair");

			input = in.nextInt();

			switch (input) {
			case 0:
				list(employedList);
				break;
			case 1:
				originator.setStatus(employedList);
				careTakerUndo.add(originator.saveMementoStatus());
				add(ID++);
				break;
			case 2:
				originator.setStatus(employedList);
				careTakerUndo.add(originator.saveMementoStatus());
				remove(employedList);
				break;
			case 3:
				originator.setStatus(employedList);
				careTakerUndo.add(originator.saveMementoStatus());
				card(employedList);
				break;
			case 4:
				originator.setStatus(employedList);
				careTakerUndo.add(originator.saveMementoStatus());
				sale(employedList);
				break;
			case 5:
				System.out.println("5:");
				break;
			case 6:
				originator.setStatus(employedList);
				careTakerUndo.add(originator.saveMementoStatus());
				edit();
				break;
			case 7:
				System.out.println("7:");
				break;
			case 8:
				originator.restore(careTakerUndo.getLastElement());
				employedList = originator.getStatus();
				System.out.println(originator.getStatus());
				System.out.println("8:");
				break;
			case 9:
				System.out.println("9:");
				break;
			case 10:
				System.out.println("10:");
				break;
			case 11:
				System.out.println("11:");
				break;
			default:
				System.out.println("Operação inválida!!");
				break;
			}
		} while (input != 0);

	}
}
