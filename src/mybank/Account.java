package mybank;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class Account {
	private AtomicReference<BigDecimal> balance = new AtomicReference<>();

	public AtomicReference<BigDecimal> getBalance() {
		return balance;
	}
	public void withdraw(int amount) {
		
		System.out.println(Thread.currentThread().getName()	+ " is going to withdraw $"+amount);
		if(balance.get().compareTo(new BigDecimal(amount)) >= 0 ) {
			balance.set(balance.get().subtract(new BigDecimal(amount)));
			System.out.println(Thread.currentThread().getName()	+ " completes the withdrawal of $"+amount);
			System.out.println(" ***** Balance in ATM left after "+ Thread.currentThread().getName() + "'s withdraw : $"+ balance);		
			
		}else {
			System.out.println("Not enough in account for "	+ Thread.currentThread().getName() + " to withdraw "
					+ balance.get().toString());
		}
		
	}
	public void setBalance(String balance) {
		BigDecimal bal = new BigDecimal(balance);
		this.balance.set(bal);
		
	}
}