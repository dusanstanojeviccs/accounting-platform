import Ember from 'ember';

export default Ember.Controller.extend({
	actions: {
		signup() {
			Ember.$.post("/j_spring_security_check", JSON.stringify({
				username: this.get("username"),
				password: this.get("password"),
			})).then((response) => {
				this.transitionToRoute("signin");	
			}, () => {
				this.get("notifications").error("Please try different username and password");
			});
		}
	}
});
