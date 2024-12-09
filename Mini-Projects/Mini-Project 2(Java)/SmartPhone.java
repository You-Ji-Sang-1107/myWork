package practice;
import java.util.Scanner;
public class SmartPhone {
    Scanner sc = new Scanner(System.in);
    public static final Addr[] addressBook = new Addr[10]; // �迭 �̸� ����
    private String name, phone, email, address, group;
    int count = 0;

    public void inputAddrData() {
        System.out.println("�̸��� �Է��ϼ���: ");
        name = sc.nextLine();
        System.out.println("��ȭ��ȣ�� �Է��ϼ���: ");
        phone = sc.nextLine();
        System.out.println("�̸����� �Է��ϼ���: ");
        email = sc.nextLine();
        System.out.println("�ּҸ� �Է��ϼ���: ");
        address = sc.nextLine();
        System.out.println("�׷��� �Է��ϼ���(ģ��/����): ");
        group = sc.nextLine();
    }

    public void addAddr() {
        Addr addr = new Addr(name, phone, email, address, group);
        if (count < addressBook.length) {
            addressBook[count] = addr;
            count++;
            System.out.println("����ó�� �߰��߽��ϴ�.");
        } else {
	            System.out.println("����ó�� ���� á���ϴ�.");
	        }
	    }
	
	    public void printAllAddr() {
        for (int i = 0; i < count; i++) {
            addressBook[i].printInfo();
        }
    }

    public void searchAddr() {
        System.out.print("�̸��� �Է��ϼ���: ");
        String name = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (addressBook[i].getName().equals(name)) {
                addressBook[i].printInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("�ּҸ� ã�� �� �����ϴ�.");
        }
    }

    public void deleteAddr() {
        System.out.print("������ �̸��� �Է��ϼ���: ");
        String name = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (addressBook[i].getName().equals(name)) {
                for (int j = i; j < count - 1; j++) {
                    addressBook[j] = addressBook[j + 1];
                }
                addressBook[count - 1] = null;
                count--;
                System.out.println("����ó�� �����Ǿ����ϴ�.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("������ ����ó�� ã�� �� �����ϴ�.");
        }
    }

    public void editAddr() {
        System.out.print("������ �̸��� �Է��ϼ���: ");
        String name = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (addressBook[i].getName().equals(name)) {
                System.out.println("������ �׸��� �����ϼ���: ");
                System.out.println("1. �̐a");
                System.out.println("2. ��ȭ��ȣ");
                System.out.println("3. �̸���");
                System.out.println("4. �ּ�");
                System.out.println("5. �׷�");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                	case 1: 
                		System.out.println("�� �̸��� �Է��ϼ���: ");
                		addressBook[i].setName(sc.nextLine());
                		break;
                    case 2:
                        System.out.println("�� ��ȭ��ȣ�� �Է��ϼ���: ");
                        addressBook[i].setPhone(sc.nextLine());
                        break;
                    case 3:
                        System.out.println("�� �̸����� �Է��ϼ���: ");
                        addressBook[i].setEmail(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("�� �ּҸ� �Է��ϼ���: ");
                        addressBook[i].setAddress(sc.nextLine());
                        break;
                    case 5:
                        System.out.println("�� �׷��� �Է��ϼ���: ");
                        addressBook[i].setGroup(sc.nextLine());
                        break;
                    default:
                        System.out.println("�߸��� �����Դϴ�.");
                }
                System.out.println("����ó�� �����Ǿ����ϴ�.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("������ ����ó�� ã�� �� �����ϴ�.");
        }
    }
}
