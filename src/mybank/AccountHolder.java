package mybank;

import java.math.BigDecimal;

public class AccountHolder implements Runnable {
	private Account account;

	public AccountHolder(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 4; i++) {
			
			if (account.getBalance().get().compareTo(BigDecimal.ZERO) <= 0) {
				System.out.println("account is overdrawn!");
			}else {
				makeWithdrawal(2000);
			}
		}
	}

	private void makeWithdrawal(int withdrawAmount) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException ex) {
			}
			account.withdraw(withdrawAmount);
			
		 
	}
}