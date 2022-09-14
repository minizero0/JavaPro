package exam01;

import java.sql.Date;

// ename, salary, addr, hiredate
public class EmpVO {
	private String ename;
	private int salary;
	private String addr;
	private Date hiredate;
	
	public EmpVO(String ename, int salary, String addr, Date hiredate) {
		super();
		this.ename = ename;
		this.salary = salary;
		this.addr = addr;
		this.hiredate = hiredate;
	}
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "EmpVO [ename=" + ename + ", salary=" + salary + ", addr=" + addr + ", hiredate=" + hiredate + "]";
	}

}
