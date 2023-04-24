import java.util.Scanner;

abstract class Employee  //abstract class so we can use it to inherit later
{
    protected int employeeId;
    protected String employeeName;
    protected double salary;

    //Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(int employeeId,String employeeName){ //constructor

        this.employeeId=employeeId;
        this.employeeName=employeeName;
    }

    abstract public void calculateSalary(); //abstract method to calculate salary
}

 class Loan {

     public double calculateLoanAmount(Employee employeeObj) { //calculates maximum loan amount
        double loan;
        if(employeeObj instanceof PermanentEmployee) //if employee is permanent
        {
            loan=20*(employeeObj.getSalary());
        }
        else
        {
            loan=15*(employeeObj.getSalary()); //if employee is temporary
        }
        return loan;
    }
}

 class PermanentEmployee extends Employee //inherits employee class
{
    private double basicPay;

    public double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    public PermanentEmployee(int employeeId,String employeeName,double basicpay) //constructor
    {
        super(employeeId,employeeName); //inherits from parent class
        this.basicPay=basicpay;
    }

    public void calculateSalary() //overriding parent class method
    {
        double PFamount;
        PFamount=(basicPay*0.12);
        setSalary(basicPay-PFamount);
    }


}

class TemporaryEmployee extends Employee{ //inherits class employee

    private int  hoursWorked;
    private int hourlyWages;

    public int getHoursWorked() {
        return hoursWorked;
    }
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public int getHourlyWages() {
        return hourlyWages;
    }
    public void setHourlyWages(int hourlyWages) {
        this.hourlyWages = hourlyWages;
    }

    public TemporaryEmployee(int a,String b,int c,int d) //constructor
    {
        super(a,b);//calling parent class constructor
        this.hoursWorked=c;
        this.hourlyWages=d;
    }

    public void calculateSalary()
    {
        setSalary(hoursWorked*hourlyWages);
    } //overriding parent class method
}

public class loanEligibility {
    double amount,amount1;
    double emi;
    int time;
    public  Loan l = new Loan();
    Scanner scan = new Scanner(System.in);

    public void eligibility(int age,int creditScore,double salary,String name,int employeeID) {
        //method to calculate loan eligibility for permanent employee

        if ((age < 21 && age > 65) || creditScore < 650 || salary < 20000)//necessary conditions to be eligible for a loan
        {
            System.out.println("You are not eligible for getting loan according to our conditions");
        }
        else {
            Employee e = new PermanentEmployee(employeeID, name, salary);//creating instance
            e.calculateSalary();
            amount = l.calculateLoanAmount(e);
            if(amount > 7500000){ //since maximum loan amount is 7500000
               amount = 7500000;
             }

             System.out.println("The maximum amount of loan you would get is " + amount);
             System.out.println("Enter the amount of loan you want");
             amount1 = scan.nextFloat();

             if(amount1<=amount){  //amount1 should be less than maximum eligible loan amount
                System.out.println("Enter the amount of time to pay the loan in months");
                time = scan.nextInt();
                if(time > 120){ //maximum time to pay loan is 10 years
                    System.out.println("The maximum time you get is only 10 years so we will calculate emi for 10 years");
                time = 120;
                }
                emi = emi_calculator(amount1,6,time); //calculating emi
                System.out.println("The emi amount you will have to pay is + " + emi);
            }
            else{
                System.out.println("That's out of limit");
            }

        }
    }
    public void eligibility(int age,int creditScore,int wages,int hours,String name,int employeeID)
            //method overloading for temporary employee
    {
        if ((age < 21 && age > 65) || creditScore < 650 || wages*hours < 20000) {
            System.out.println("You are not eligible for getting loan according to our conditions");
        }
        else {
            Employee e = new TemporaryEmployee(employeeID,name,hours,wages);
            e.calculateSalary();
           amount = l.calculateLoanAmount(e);
            if(amount > 7500000){
                amount = 7500000;
            }

            System.out.println("The maximum amount of loan you would get is " + amount);

            System.out.println("Enter the amount of loan you want");
            amount1 = scan.nextFloat();
            if(amount1<=amount){
                System.out.println("Enter the amount of time to pay the loan in months");
                time = scan.nextInt();
                if(time > 120){
                    System.out.println("The maximum time you get is only 10 years so we will calculate emi for 10 years");
                    time = 120;
                }
                emi = emi_calculator(amount1,6,time);
                System.out.println("The emi amount you will have to pay is + " + emi);
            }
            else{
                System.out.println("That's out of limit");
            }


        }
        }

    static double emi_calculator(double p, float r, float t) //method to return emi
    {
        double emi;

        r = r / (12 * 100); // one month interest
        emi = (p * r * (float)Math.pow(1 + r, t)) / (float)(Math.pow(1 + r, t) - 1);

        return (emi);
    }


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int age,creditScore,employeeID,hours,wages;
        double salary;
        String employee,name;
        loanEligibility le = new loanEligibility();
        System.out.println("Enter your employee ID");
        employeeID = sc.nextInt();
        System.out.println("Enter your name");
        name = sc.next();
        System.out.println("Enter your age ");
        age = sc.nextInt();
        System.out.println("Enter you credit score");
        creditScore = sc.nextInt();
        System.out.println("Enter Yes if you are a permanent employee and No if you a temporary employee");
        employee = sc.next();
        if(employee.equals("Yes") || employee.equals("yes")){
            System.out.println("Enter your salary");
            salary = sc.nextDouble();
            System.out.println(salary);
            le.eligibility(age,creditScore,salary,name,employeeID);
        }
        else if(employee.equals("No") || employee.equals("no")){
            System.out.println("Enter your hourly wages");
            wages = sc.nextInt();
            System.out.println("Enter your hours worked");
            hours = sc.nextInt();
            le.eligibility(age,creditScore,wages,hours,name,employeeID);
        }
        else{
            System.out.println("Invalid response");
        }
    }

}



