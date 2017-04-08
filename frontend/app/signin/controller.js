import Ember from 'ember';

export default Ember.Controller.extend({
	auth: Ember.inject.service(),

	actions: {
		signin() {
			Ember.$.post("/j_spring_security_check", JSON.stringify({
				username: this.get("username"),
				password: this.get("password"),
			})).then((response) => {
				this.get("auth").set("user", response);
				this.transitionToRoute("accounting.dashboard");
			}, () => {
				this.get("notifications").error("Please enter valid username password combo");	
			});
		}
	}
});
