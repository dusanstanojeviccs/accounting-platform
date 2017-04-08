import Ember from 'ember';

export default Ember.Route.extend({
	activate() {
		Ember.$("body").addClass("login-page-body");
	},

	deactivate() {
		Ember.$("body").removeClass("login-page-body");
	},
});
