// 자바 실습 시간에 만들어본 코드다.

class Accounting{
	public double valueOfSupply;
	public double vatRate;
	public double expenseRate;
	public double[] dividendRates;
	
	public void print() {
		System.out.println("Value of supply: "+valueOfSupply);
		System.out.println("VAT: " + getVat());
		System.out.println("Total: " + getTotal());
		System.out.println("Expense: "+getExpense());
		System.out.println("Income: "+getIncome());
		
		int i = 0;
		while(i < dividendRates.length) {
			System.out.println("Dividend: "+ (getIncome()*dividendRates[i]));
			i += 1;
		}
	}

	public double getIncome() {
		return valueOfSupply-getExpense();
	}

	public double getExpense() {
		return valueOfSupply*expenseRate;
	}

	public double getTotal() {
		return valueOfSupply+getVat();
	}

	public double getVat() {
		return valueOfSupply*vatRate;
	}
}


public class AccountingApp {
	public static void main(String[] args) {
		Accounting accounting = new Accounting();
		
		accounting.valueOfSupply = Double.parseDouble(args[0]);
		accounting.vatRate = 0.1;
		accounting.expenseRate = 0.3;
		accounting.dividendRates = new double[3];
		
		if(accounting.getIncome() >= 10000.0) {
			accounting.dividendRates[0] = 0.5;
			accounting.dividendRates[1] = 0.3;
			accounting.dividendRates[2] = 0.2;		
		}
		else {
			accounting.dividendRates[0] = 1.0;
			accounting.dividendRates[1] = 0.0;
			accounting.dividendRates[2] = 0.0;
		}
		
		accounting.print();
	}
}
