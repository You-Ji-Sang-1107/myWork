package practice;

import java.util.Scanner;
public class SmartPhoneMain {
	public void printMenu() {
        System.out.println("------------------");
        System.out.println("1. ����ó ���");
        System.out.println("2. ��� ����ó ���");
        System.out.println("3. ����ó �˻�");
        System.out.println("4. ����ó ����");
        System.out.println("5. ����ó ����");
        System.out.println("6. �ý��� ����");
        System.out.println("------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        SmartPhone sp = new SmartPhone();
        
        while (true) {
        	SmartPhoneMain spm = new SmartPhoneMain();
            spm.printMenu();
            System.out.print(">>> ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
            case 1:
                sp.inputAddrData();
                sp.addAddr();
                break;
            case 2:
                sp.printAllAddr();
                break;
            case 3:
                sp.searchAddr();
                break;
            case 4:
                sp.deleteAddr();
                break;
            case 5:
                sp.editAddr();
                break;
            case 6:
                System.out.println("�ý����� �����մϴ�.");
                System.exit(0);
                break;
            default:
                System.out.println("�߸��� �Է��Դϴ�. �ٽ� �õ��ϼ���.");
        }
    }
    }
}