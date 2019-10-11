package com.laptrinhjavaweb.builder;

public class CustomerSearchBuilder {
	private final String customerName; // required
	private final String phoneNumber;
	private final String email;
	private final String staffId;

	private CustomerSearchBuilder(Builder builder) {
		super();
		this.customerName = builder.customerName;
		this.phoneNumber = builder.phoneNumber;
		this.email = builder.email;
		this.staffId = builder.staffId;

	}

	public String getCustomerName() {
		return customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getStaffId() {
		return staffId;
	}

	// Builder class
	public static class Builder {

		private String customerName; // required
		private String phoneNumber;
		private String email;
		private String staffId;

		public Builder(String customerName, String phoneNumber) {
			this.customerName = customerName;
			this.phoneNumber = phoneNumber;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setStaffId(String staffId) {
			this.staffId = staffId;
			return this;
		}

		public CustomerSearchBuilder build() {

			CustomerSearchBuilder customerSearchBuilder = new CustomerSearchBuilder(this);

			return customerSearchBuilder;
		}
	}
}
