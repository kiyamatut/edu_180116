package icCharger;

import java.util.Calendar;
import java.util.ArrayList;
public class MainShopCharger {
	private static StudentCard insertedStudentCard;
	
	public MainShopCharger(){}
	
	static int maxamount = 10000;
	static boolean bln;
	
	private static void insertStudentCard(int studentId){
		if(bln == false){
			bln = true;
			insertedStudentCard = StudentCard.getStudentCard(studentId);
		}else{
			System.out.println("�J�[�h���}������Ă��܂�");
		}
	}

	private static void chargeMoney(int money){
		if(insertedStudentCard != null){
			insertedStudentCard.setAccountBalance(insertedStudentCard.getAccountBalance() + money);
			getCalendar();
			printCalender();
			printAccountBalance();
		} else {
			System.err.println("�w���؂��}������Ă��܂���D");
		}
	}

	private static void printAccountBalance(){
		System.out.println("�c����\�����܂�");
		System.out.println("�w�Дԍ�"+insertedStudentCard.getStudentId()+" �w����:" + insertedStudentCard.getStudentName());
		if(insertedStudentCard.getAccountBalance() >= maxamount){
			System.out.println("�c���F"+ maxamount);
			System.out.println("����F"+ (insertedStudentCard.getAccountBalance()-maxamount));
		}else{
			System.out.println("�c��:" + insertedStudentCard.getAccountBalance());
		}
	}

	private static void getCalendar(){
		Calendar cl1 = Calendar.getInstance();
		Calendar cl2 = Calendar.getInstance();
		
		insertedStudentCard.setYear(cl1.get(Calendar.YEAR));
		insertedStudentCard.setMonth(cl1.get(Calendar.MONTH)+1);
		insertedStudentCard.setDay(cl1.get(Calendar.DATE));
		
		cl2.set(insertedStudentCard.getValidYear(),insertedStudentCard.getValidMonth(),insertedStudentCard.getValidDay(),0,0,0);
		if(cl1.compareTo(cl2) != -1){
			insertedStudentCard.setUseRight(false);
		}else{
			insertedStudentCard.setUseRight(true);
		}
	}
	
	private static void Checkdate(){
		getCalendar();
		if(insertedStudentCard.isUseRight()==true){
			
		}
	}
	
	private static void printCalender(){
		System.out.println("�ŐV�`���[�W�N����");
		System.out.print(insertedStudentCard.getYear()+"�N");
		System.out.print(insertedStudentCard.getMonth()+"��");
		System.out.println(insertedStudentCard.getDay()+"��");
	}
	
	private static void ejectStudentCard(){
		bln = false;
		System.out.println("�J�[�h�����o����܂���");
	}
	
	public static void main(String[] args) {
		//�w���؃C���X�^���X�̍쐬
		StudentCard studentCard1 = new StudentCard(0, "tut",2017,3,31,"�`���R���[�g�͂��܂�");
		StudentCard studentCard2 = new StudentCard(1, "tenpaku",2020,3,31,"�ɂ�ɂ͂ɂ�ɂ�Ƃ肪����");
		
// 		�����c���̐ݒ�
		studentCard1.setAccountBalance(1000);
		studentCard2.setAccountBalance(1000);
		//�G���[�����̕\��
		chargeMoney(200);

		//�w���� 1 ���ڂ̑}���ƃ`���[�W
		insertStudentCard(0);
		//���Z
		chargeMoney(1000);
		//�����o��
		chargeMoney(-300);
		chargeMoney(9500);
		insertedStudentCard.printNounNumber();
		insertStudentCard(1);
		ejectStudentCard();
		//�w���� 2 ���ڂ̑}���ƃ`���[�W
		insertStudentCard(1);
		//���Z
		chargeMoney(500);
		//�����o��
		chargeMoney(-1000);
		insertedStudentCard.printNounNumber();
		System.out.println("���s�w���ؖ���:" + StudentCard.getStudentCardList_().size());
	}
	
}