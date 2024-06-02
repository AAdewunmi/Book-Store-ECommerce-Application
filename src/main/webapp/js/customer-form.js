$(document).ready(function() {
		$("#customerForm").validate({
			rules: {
				email: {
					required: true,
					email: true
				},
				firstname: "required",
				lastname: "required",
				password: "required",
				},
				confirmPassword: {
					required: true,
					equalTo: "#password"
				},
				phone: "required",
				address1: "required",
				address2: "required",
				city: "required",
				state: "required",
				zipcode: "required",
				country: "required",
			},
			 {
				firstname: "Please enter first name",
				lastname: "Please enter last name",
				password: "Please enter password",
				confirmPassword: {
					required: "Please confirm password",
					email: "Confirm password does not match password",
				},
				phone: "Please enter email phone",
				address1: "Please enter address line 1",
				address2: "Please enter address line 2",
				city: "Please enter city",
				state: "Please enter state",
				zipcode: "Please enter zipcode",
				country: "Please enter country",		
			}
		);
		
		$("#buttonCancel").click(function() {
			history.go(-1);
		});
	});