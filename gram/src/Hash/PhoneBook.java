package Hash;
public class PhoneBook {

	public boolean solution(String[] phone_book){
		for(int i =0;i<phone_book.length;i++) {
			for(int j=0;j<phone_book.length;j++) {
				if(i==j)
					continue;
				if(phone_book[j].startsWith(phone_book[i]))
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		PhoneBook pb =new PhoneBook();
		
		System.out.println(pb.solution(new String[]{"12", "123", "1235", "567", "88"}));	
	}
}