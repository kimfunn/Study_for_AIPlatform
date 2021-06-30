package web.vo;

public class MemberVO {
	private String id, pw, name, address;
	private int age;
	

		public MemberVO() {
		super();
		//set 매소드로 넘어가게 만들어줘야함
		
		
		// TODO Auto-generated constructor stub
	} //default 생성자가 들어가게 됨
		
		public MemberVO(String id, String pw, String name) {
			this(id,pw,name,"대한민국",1);
			
		}
		public MemberVO(String id, String pw) {
			setId(id);
			setPw(pw);
			}
		public MemberVO(String id, String pw, String name, String address, int age) {
		setId(id);
		setPw(pw);
		setName(name);
		setAddress(address);
		setAge(age);
	}
		public String getId() {
		return id;
	}
	public void setId(String id) { //set 매소드는 유효성 검사가 꼭 필요함

		if(id!=null) {
		this.id = id;
		
		}else {System.out.println("id를 입력해주세요");
	}
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", address=" + address + ", age=" + age + "]";
	}

	
}
