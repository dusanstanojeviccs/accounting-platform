import Ember from 'ember';

export default Ember.Route.extend({
	actions: {
		transitionToSignIn() {
			this.transitionTo("signin");
		}
	}
});
