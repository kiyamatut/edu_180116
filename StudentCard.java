package icCharger;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.*;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class StudentCard {
	private int studentId;
	private String studentName;
	private int accountBalance = 0;
	private int year,month,day;
	private int validYear,validMonth,validDay;
	private boolean UseRight = false;
	public boolean isUseRight() {
		return UseRight;
	}

	public void setUseRight(boolean useRight) {
		UseRight = useRight;
	}

	private String password;
	private static ArrayList<StudentCard> studentCardList_ = new ArrayList<StudentCard>();
	
	private BufferedImage Buff;
	private String comment;
	
	public StudentCard(int studentId, String studentName,int validYear,int validMonth,int validDay,String comment) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.validYear = validYear;
		this.validMonth = validMonth;
		this.validDay = validDay;
		this.comment = comment;
		studentCardList_.add(this);
	}
	
	Map getJPNMroAnalysis(String text){
		URL url = null;
		Document doc = null;
		Element element = null;
		NodeList nodelist = null;
		Node node = null;
		Map<String , Integer> map =  new HashMap<String, Integer>();
		String checkKey;
		
		try{
			url = new URL("https://jlp.yahooapis.jp/MAService/V1/parse?appid=dj00aiZpPWptUTU1cjR2S3JUaSZzPWNvbnN1bWVyc2VjcmV0Jng9NjM-&results=ma&sentence="+text);
			doc = DocumentBuilderFactory.newInstance()
			     .newDocumentBuilder().parse(url.openStream());
			element = doc.getDocumentElement();
			nodelist = element.getElementsByTagName("pos");
			for(int i=0; i<nodelist.getLength(); i++){
				node = nodelist.item(i).getFirstChild();
				checkKey = node.getTextContent();
				if(map.containsKey(checkKey)){
					map.replace(checkKey , map.get(checkKey)+1);
				}else{
					map.put(checkKey , 1);
				}
			}
		}catch(Exception e){
		}
		return map;
	}
	
	void printNounNumber(){
		Map<String,Integer> map =  new HashMap<String, Integer>();
		System.out.print("ï∂èÕ: "+this.comment + " Ç…ä‹Ç‹ÇÍÇƒÇ¢ÇÈïiéåÇÃêîÇÕÅ@");
		map = this.getJPNMroAnalysis(this.comment);
		for(String key : map.keySet()){
			System.out.println(map.get(key) + "Ç¬Ç≈Ç∑");
		}
	}
	
	public int getValidYear() {
		return validYear;
	}

	public int getValidMonth() {
		return validMonth;
	}

	public int getValidDay() {
		return validDay;
	}


	public static ArrayList<StudentCard> getStudentCardList_() {
		return studentCardList_;
	}

	public static void setStudentCardList_(ArrayList<StudentCard> studentCardList_) {
		StudentCard.studentCardList_ = studentCardList_;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public int setAccountBalance(int accountBalance) {
	    return this.accountBalance = accountBalance;
	}

	public static StudentCard getStudentCard(int studentId){
		return studentCardList_.get(studentId);
	}

	public String getStudentName() {
	    return studentName;
	}
	
	public int getStudentId(){
		return studentId;
	}

}