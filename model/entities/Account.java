package model.entities;

import model.exceptions.BusinessException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {

	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposito(Double amount) {
		balance += amount;
	}

	public void saque(Double amount) throws BusinessException {

		if (amount > balance) {
			throw new BusinessException("Saldo Insuficiente em conta.");

		} else if (amount > withdrawLimit) {

			throw new BusinessException("Valor excede limite de estabelecido para saque.");

		} else {
			balance -= amount;
		}

	}

	@Override
	public String toString() {
		return getBalance().toString();
	}

}
