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
			System.out.println("カードが挿入されています");
		}
	}

	private static void chargeMoney(int money){
		if(insertedStudentCard != null){
			insertedStudentCard.setAccountBalance(insertedStudentCard.getAccountBalance() + money);
			getCalendar();
			printCalender();
			printAccountBalance();
		} else {
			System.err.println("学生証が挿入されていません．");
		}
	}

	private static void printAccountBalance(){
		System.out.println("残高を表示します");
		System.out.println("学籍番号"+insertedStudentCard.getStudentId()+" 学生名:" + insertedStudentCard.getStudentName());
		if(insertedStudentCard.getAccountBalance() >= maxamount){
			System.out.println("残高："+ maxamount);
			System.out.println("おつり："+ (insertedStudentCard.getAccountBalance()-maxamount));
		}else{
			System.out.println("残高:" + insertedStudentCard.getAccountBalance());
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
		System.out.println("最新チャージ年月日");
		System.out.print(insertedStudentCard.getYear()+"年");
		System.out.print(insertedStudentCard.getMonth()+"月");
		System.out.println(insertedStudentCard.getDay()+"日");
	}
	
	private static void ejectStudentCard(){
		bln = false;
		System.out.println("カードが取り出されました");
	}
	
	public static void main(String[] args) {
		//学生証インスタンスの作成
		StudentCard studentCard1 = new StudentCard(0, "tut",2017,3,31,"チョコレートはあまい");
		StudentCard studentCard2 = new StudentCard(1, "tenpaku",2020,3,31,"にわにはにわにわとりがいる");
		
// 		初期残高の設定
		studentCard1.setAccountBalance(1000);
		studentCard2.setAccountBalance(1000);
		//エラー処理の表示
		chargeMoney(200);

		//学生証 1 枚目の挿入とチャージ
		insertStudentCard(0);
		//加算
		chargeMoney(1000);
		//引き出し
		chargeMoney(-300);
		chargeMoney(9500);
		insertedStudentCard.printNounNumber();
		insertStudentCard(1);
		ejectStudentCard();
		//学生証 2 枚目の挿入とチャージ
		insertStudentCard(1);
		//加算
		chargeMoney(500);
		//引き出し
		chargeMoney(-1000);
		insertedStudentCard.printNounNumber();
		System.out.println("発行学生証枚数:" + StudentCard.getStudentCardList_().size());
	}
	
}